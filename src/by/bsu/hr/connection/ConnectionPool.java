package by.bsu.hr.connection;

import com.mysql.jdbc.Statement;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger=Logger.getLogger(ConnectionPool.class);
    private static BlockingQueue<Connection> connectionQueue;
    private  LinkedList<Connection> givenAwayConQueue;
    private  static ConnectionPool instance;
    private static String driverName;
    private static String url;
    private static String user;
    private static String password;
    private static int poolSize;
    private static ReentrantLock lock = new ReentrantLock();
    private static  AtomicBoolean checkFinish=new AtomicBoolean(true);


    private ConnectionPool() {
        DBResourceManager dbResourseManager = DBResourceManager.getInstance();
        this.driverName = "com.mysql.jdbc.Driver";
                //dbResourseManager.getValue(DBParameter.DB_DRIVER);
        this.url = "jdbc:mysql://localhost:3306/HR_system";
                //dbResourseManager.getValue(DBParameter.DB_URL);
        this.user = "root";
                //dbResourseManager.getValue(DBParameter.DB_USER);
        this.password = "root";
                //dbResourseManager.getValue(DBParameter.DB_PASSWORD);
        Locale.setDefault(Locale.ENGLISH);
        int checkCount=0;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.log(Level.ERROR, "Can't find properties file", e);
        }
        try {
            this.poolSize = Integer.parseInt(dbResourseManager.getValue(DBParameter.DB_POLL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = 5;
            logger.log(Level.INFO,"Default poolSize",e);
        }
        try {
            givenAwayConQueue = new LinkedList<>();
            connectionQueue = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url,user,password);
                PooledConnection pooledConnection = new PooledConnection( connection);
                connectionQueue.add(pooledConnection);
                checkCount++;
            }
            if(!(checkCount ==5)){
                logger.log(Level.FATAL, "Fatal error adding connections");
            }
        } catch (SQLException e) {
            // throw new ConnectionPoolException("SQLException in ConnectionPool", e);
            logger.log(Level.FATAL, "Fatal error adding connections", e);
        }
    }

    public static ConnectionPool getInstance() {
        if (checkFinish.get()) {
            lock.lock();
            if (instance == null) {
                try {
                    instance = new ConnectionPool();
                    checkFinish.set(false);
                    } finally {
                    lock.unlock();
                }
            }
        }
        return instance;
    }

    public void dispose() {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() {
        try {

            closeConnectionsQueue(connectionQueue);
        } catch (SQLException e) {
             logger.log(Level.ERROR, "Error closing the connection.", e);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    public  Connection takeConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
            givenAwayConQueue.add(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data source.", e);
        }
        return connection;
    }


    public static void returnConnectionToPool(Connection con) {
        try {
            connectionQueue.put(con);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Error returning connection to pool.", e);
        }
    }

    public static void closeSt(PreparedStatement st){
        try{
            if(st!=null) {
                st.close();
            }
        }catch (SQLException e){
            logger.log(Level.INFO, "Error closing the connection.", e);
        }
    }
    private void closeConnectionsQueue(BlockingQueue<Connection> queue)
            throws SQLException, InterruptedException {
        Connection connection;
        for(int i=0;i<poolSize;i++){
            connection=queue.take();
            if (!connection.getAutoCommit()) { connection.commit();
            }
            ((PooledConnection) connection).reallyClose();
        }
    }

    private static class PooledConnection implements Connection {
        private Connection connection;

        public PooledConnection(Connection c) throws SQLException { this.connection = c; this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException { connection.close();
        }

        @Override
        public void clearWarnings() throws SQLException { connection.clearWarnings();
        }

        @Override
        public void close() throws SQLException {
            if (connection.isClosed()) {
                throw new SQLException("Attempting to close closed connection");
            }
            if (connection.isReadOnly()) { connection.setReadOnly(false);
            }
        }

        @Override
        public void commit() throws SQLException { connection.commit();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements)
                throws SQLException {
            return connection.createArrayOf(typeName, elements);
        }
        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }
        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }
        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }
        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }
        @Override
        public Statement createStatement() throws SQLException {
            return (Statement) connection.createStatement();
        }
        @Override
        public Statement createStatement(int resultSetType,
                                         int resultSetConcurrency) throws SQLException {
            return (Statement) connection.createStatement(resultSetType, resultSetConcurrency);
        }
        @Override
        public Statement createStatement(int resultSetType,
                                         int resultSetConcurrency, int resultSetHoldability)
                throws SQLException {
            return (Statement) connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }
        @Override
        public Struct createStruct(String typeName, Object[] attributes)
                throws SQLException {
            return connection.createStruct(typeName, attributes);
        }
        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }
        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }
        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }
        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }
        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }
        @Override
        public DatabaseMetaData getMetaData() throws SQLException {


            return connection.getMetaData();
        }
        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }
        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }
        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }
        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }
        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }
        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }
        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }
        @Override
        public CallableStatement prepareCall(String sql, int resultSetType,
                                             int resultSetConcurrency) throws SQLException {
            return connection.prepareCall(sql, resultSetType,
                    resultSetConcurrency);
        }
        @Override
        public CallableStatement prepareCall(String sql, int resultSetType,
                                             int resultSetConcurrency, int resultSetHoldability)
                throws SQLException {
            return connection.prepareCall(sql, resultSetType,
                    resultSetConcurrency, resultSetHoldability);
        }
        @Override
        public PreparedStatement prepareStatement(String sql)
                throws SQLException {
            return connection.prepareStatement(sql);
        }
        @Override
        public PreparedStatement prepareStatement(String sql,
                                                  int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        }
        @Override
        public PreparedStatement prepareStatement(String sql,
                                                  int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql, columnIndexes);
        }
        @Override
        public PreparedStatement prepareStatement(String sql,
                                                  String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql, columnNames);
        }
        @Override
        public PreparedStatement prepareStatement(String sql,
                                                  int resultSetType, int resultSetConcurrency)
                throws SQLException {
            return connection.prepareStatement(sql, resultSetType,
                    resultSetConcurrency);
        }
        @Override
        public PreparedStatement prepareStatement(String sql,
                                                  int resultSetType, int resultSetConcurrency,
                                                  int resultSetHoldability) throws SQLException {
            return connection.prepareStatement(sql, resultSetType,
                    resultSetConcurrency, resultSetHoldability);
        }
        @Override
        public void rollback() throws SQLException { connection.rollback();
        }
        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException { connection.setAutoCommit(autoCommit);
        }
        @Override
        public void setCatalog(String catalog) throws SQLException { connection.setCatalog(catalog);
        }
        @Override
        public void setClientInfo(String name, String value)
                throws SQLClientInfoException { connection.setClientInfo(name, value);
        }
        @Override
        public void setHoldability(int holdability) throws SQLException { connection.setHoldability(holdability);
        }


        @Override
        public void setReadOnly(boolean readOnly) throws SQLException { connection.setReadOnly(readOnly);
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return connection.setSavepoint(name);
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException { connection.setTransactionIsolation(level);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {

        }

        @Override
        public void releaseSavepoint(Savepoint arg0) throws SQLException { connection.releaseSavepoint(arg0);
        }

        @Override
        public void rollback(Savepoint arg0) throws SQLException { connection.rollback(arg0);
        }

        @Override
        public void setClientInfo(Properties arg0)
                throws SQLClientInfoException { connection.setClientInfo(arg0);
        }

        @Override
        public void setNetworkTimeout(Executor arg0, int arg1)
                throws SQLException { connection.setNetworkTimeout(arg0, arg1);
        }

        @Override
        public void setSchema(String arg0) throws SQLException { connection.setSchema(arg0);
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException { connection.setTypeMap(arg0);
        }
    }

}