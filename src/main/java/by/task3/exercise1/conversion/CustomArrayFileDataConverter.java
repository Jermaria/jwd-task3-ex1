package by.task3.exercise1.conversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;
import by.task3.exercise1.validation.InputValidator;

public class CustomArrayFileDataConverter extends CustomArrayAbstractConverter {
    
    private static final Logger LOGGER = LogManager.getLogger();
    private InputValidator validator = new InputValidator();
    
    @Override
    public Optional<int[]> convertToArray(Object... sources)
            throws UnsupportedInputSourceServiceException, InconvertibleInputServiceException, ServiceException {
        int[] array = null;       
        if (sources.length ==1 && validator.isFilePathString(sources[0])) {
            String path = sources[0].toString();
            Optional<String[]> stringsOptional = readFileStrings(path);
            
            if (stringsOptional.isPresent()) {
                String[] numberStrings = stringsOptional.get();
                array = convertStringsToIntArray(numberStrings);
            } 
        } else if (sources.length > 1) {
            LOGGER.log(Level.ERROR, "multiple sources in input");
            throw new UnsupportedInputSourceServiceException("multiple sources in input");
        } else {
            LOGGER.log(Level.ERROR, "unsupported input source " + sources[0].getClass().getName());
            throw new UnsupportedInputSourceServiceException("unsupported input source " + 
                    sources[0].getClass().getName());
        }        
        Optional<int[]> arrayOptional = (array != null) ? Optional.of(array) : Optional.empty();
        return arrayOptional;
    }
    
    public Optional<String[]> readFileStrings(String path) throws UnsupportedInputSourceServiceException, ServiceException {
        String[] numbers;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String fileString = reader.readLine();
            numbers = fileString.split(" ");
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.ERROR, "no file found: ", e );
            throw new UnsupportedInputSourceServiceException("file not found ", e);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "buffered reader failed to read line or close ", e );
            throw new ServiceException("buffered reader failed to read line or close", e);
        }       
        Optional<String[]> numbersOptional = (numbers != null) ? Optional.of(numbers) : Optional.empty();        
        return numbersOptional;
    }
    
    public int[] convertStringsToIntArray(String[] numberStrings) throws InconvertibleInputServiceException {
        int[] array = new int[numberStrings.length];
        int i = 0;
        for (String s : numberStrings) {
            if (validator.isConvertibleToInt(s)) {
                array[i] = Integer.parseInt(s);
                i++;
            } else {
                LOGGER.log(Level.ERROR, "failed to convert to int " + s);
                throw new InconvertibleInputServiceException("failed to convert string to int " + s);
            }
        }
        return array;
    }
}
