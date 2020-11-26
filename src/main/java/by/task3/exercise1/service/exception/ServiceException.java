package by.task3.exercise1.service.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public ServiceException() {}
    
    public ServiceException(Exception e) {       
        super(e);
    }
    
    public ServiceException(String message, Exception e) {
        super(message, e);
    }
    
    public ServiceException(String message) {
        super(message);
    }

}
