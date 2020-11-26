package by.task3.exercise1.service;

import java.io.InputStream;

import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;

public interface CustomArrayValueProviderService {
    
    int[] provideArrayRandomValues();
    int[] provideValuesFromConsole(InputStream in) throws UnsupportedInputSourceServiceException, 
                                                InconvertibleInputServiceException, ServiceException;
    int[] provideValuesFromFile(String path) throws UnsupportedInputSourceServiceException,
                                             InconvertibleInputServiceException, ServiceException;

}
