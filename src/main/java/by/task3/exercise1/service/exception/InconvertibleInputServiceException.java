package by.task3.exercise1.service.exception;

public class InconvertibleInputServiceException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public InconvertibleInputServiceException() {}
    
    public InconvertibleInputServiceException(Exception e) {       
        super(e);
    }
    
    public InconvertibleInputServiceException(String message, Exception e) {
        super(message, e);
    }
    
    public InconvertibleInputServiceException(String message) {
        super(message);
    }

}
