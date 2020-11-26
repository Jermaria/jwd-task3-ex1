package by.task3.exercise1.conversion;

import java.util.Optional;

import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;

public abstract class CustomArrayAbstractConverter {
    
    public abstract Optional<int[]> convertToArray(Object...sources) 
                            throws UnsupportedInputSourceServiceException, InconvertibleInputServiceException, ServiceException;

}
