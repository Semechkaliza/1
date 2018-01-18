package by.bsu.hr.connection;

public class ConnectionPoolException extends Throwable {
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
