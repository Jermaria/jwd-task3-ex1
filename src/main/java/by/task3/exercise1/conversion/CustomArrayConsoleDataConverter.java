package by.task3.exercise1.conversion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;
import by.task3.exercise1.validation.InputValidator;

public class CustomArrayConsoleDataConverter extends CustomArrayAbstractConverter {
    
    private InputValidator validator = new InputValidator();    
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Optional<int[]> convertToArray(Object... sources) 
            throws UnsupportedInputSourceServiceException, InconvertibleInputServiceException, ServiceException {
        
        int[] array;       
        if (sources.length == 1 && validator.isConsoleSource(sources[0])) {           
            InputStream in = (InputStream)sources[0];
            String[] numberStrings = scanConsoleString(in);
            array = convertStringsToIntArray(numberStrings);              
        } else if (sources.length > 1) {
            LOGGER.log(Level.ERROR, "multiple sources in input");
            throw new UnsupportedInputSourceServiceException("multiple sources in input");          
        } else {
            LOGGER.log(Level.ERROR, "unsupported input source " +  sources[0].getClass().getName());
            throw new UnsupportedInputSourceServiceException("unsupported input source " + 
                                                                sources[0].getClass().getName());
        } 
        Optional<int[]> arrayOptional = (array != null) ? Optional.of(array) : Optional.empty();
        return arrayOptional;
    }

    @SuppressWarnings("resource")
    public String[] scanConsoleString(InputStream in) {
        Scanner scan = new Scanner(in);
        String[] numberStrings = scan.nextLine().split(" ");
        try {
            in.close();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "failed to close InputStream");
        }
        return numberStrings;
    }
    
    public int[] convertStringsToIntArray(String[] numberStrings) throws InconvertibleInputServiceException {
        int[] array = new int[numberStrings.length];       
        int i = 0;
        for (String numberString : numberStrings) {                
            if(validator.isConvertibleToInt(numberString)) {
                array[i] = Integer.parseInt(numberString);
                i++;
            } else {
                LOGGER.log(Level.ERROR, "inconvertible to int value ", numberString );
                throw new InconvertibleInputServiceException("failed to convert to int " 
                                                                + numberString);
            }    
        }        
        return array;
    }  
}
