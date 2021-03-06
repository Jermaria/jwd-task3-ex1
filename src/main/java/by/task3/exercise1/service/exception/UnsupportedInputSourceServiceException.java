package by.task3.exercise1.service.exception;

public class UnsupportedInputSourceServiceException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public UnsupportedInputSourceServiceException() {}
    
    public UnsupportedInputSourceServiceException(Exception e) {       
        super(e);
    }
    
    public UnsupportedInputSourceServiceException(String message, Exception e) {
        super(message, e);
    }
    
    public UnsupportedInputSourceServiceException(String message) {
        super(message);
    }

}
