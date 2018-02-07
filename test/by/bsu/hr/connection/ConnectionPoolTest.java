package by.bsu.hr.connection;

import org.junit.Test;

import java.sql.Connection;


public class ConnectionPoolTest {
    @Test
    public void getInstance() throws Exception {
        ConnectionPool cn;
        cn=ConnectionPool.getInstance();
        if(cn!=null){
            assert true;
        }
    }

    @Test
    public void takeConnection() throws Exception {
        Connection cn;
        cn=ConnectionPool.getInstance().takeConnection();
        if(cn!=null){
            assert true;
        }
    }

    @Test
    public void returnConnectionToPool() throws Exception {
    }

    @Test
    public void closeSt() throws Exception {
    }

}