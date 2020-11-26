package by.task3.exercise1.conversion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import by.task3.exercise1.conversion.CustomArrayFileDataConverter;
import by.task3.exercise1.service.exception.InconvertibleInputServiceException;
import by.task3.exercise1.service.exception.ServiceException;
import by.task3.exercise1.service.exception.UnsupportedInputSourceServiceException;

public class CustomArrayFileDataConverterTest {

    private static final CustomArrayAbstractConverter reader = new CustomArrayFileDataConverter();
    private static final String FILE_PATH = "resources/data/array.txt";

    @Test
    public void convertToArrayTest() {
        try {
            int[] actual = reader.convertToArray(FILE_PATH).get();
            int[] expected = new int[] {6, 7, 8, 99, 8, 6, 8};
            assertEquals(actual, expected);
        } catch (UnsupportedInputSourceServiceException 
                | InconvertibleInputServiceException | ServiceException e) {
            fail();
        }
    }
    
    @Test(expectedExceptions = UnsupportedInputSourceServiceException.class)
    public void UnsupportedInputSourceServiceExceptionTest() 
            throws UnsupportedInputSourceServiceException {
        String s = "anotherSource";
        Object[] path = new Object[] {FILE_PATH, s};
        try {
            reader.convertToArray(path).get();
        } catch (InconvertibleInputServiceException | ServiceException e) {
            fail();
        }
    }

}
