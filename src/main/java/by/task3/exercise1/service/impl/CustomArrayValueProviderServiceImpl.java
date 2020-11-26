package by.task3.exercise1.service.impl;

import java.io.InputStream;
import java.util.Optional;
import java.util.Random;

import by.task3.exercise1.conversion.CustomArrayConsoleDataConverter;
import by.task3.exercise1.conversion.CustomArrayAbstractConverter;
import by.task3.exercise1.conversion.CustomArrayFileDataConverter;
import by.task3.exercise1.service.CustomArrayValueProviderService;
import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;

public class CustomArrayValueProviderServiceImpl implements CustomArrayValueProviderService {

    private static final int MAX_ARRAY_LENGTH_VALUE = 20;
    private final CustomArrayAbstractConverter consoleReader = new CustomArrayConsoleDataConverter();
    private final CustomArrayAbstractConverter fileReader = new CustomArrayFileDataConverter();

    @Override
    public int[] provideArrayRandomValues() {
        Random random = new Random();
        int[] array = new int[random.nextInt(MAX_ARRAY_LENGTH_VALUE)];
         
        int i = 0;
        while (i < array.length) {
            array[i] = random.nextInt();
            i++;
        }        
        return array;      
    }
    
    @Override
    public int[] provideValuesFromConsole(InputStream in) throws UnsupportedInputSourceServiceException, 
                                                InconvertibleInputServiceException, ServiceException {
        Optional<int[]> arrayOptional;       
        do {
            arrayOptional = consoleReader.convertToArray(in);
        }while (arrayOptional.isEmpty());       
        int[] array = arrayOptional.get();
        return array;     
    }
    
    @Override
    public int[] provideValuesFromFile(String path) throws UnsupportedInputSourceServiceException,
                                            InconvertibleInputServiceException, ServiceException {
        Optional<int[]> arrayOptional;       
        do {
            arrayOptional = fileReader.convertToArray(path);
        }while (arrayOptional.isEmpty());     
        int[] array = arrayOptional.get();
        return array;
    }
}
