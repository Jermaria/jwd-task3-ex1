package by.task3.exercise1.validation;

import java.io.InputStream;
import java.util.regex.Pattern;

public class InputValidator {
    
    public boolean isFilePathString(Object source) {
        boolean isPath = (isString(source) && isMatchingPathRegex(source.toString()));
        return isPath;
    }
    
    public boolean isConsoleSource(Object source) {
        
        boolean isConsole = (source instanceof InputStream);
        return isConsole;
    }
    
    public boolean isString(Object source) {
        boolean isString = (source instanceof String);
        return isString;
    }
    
    public boolean isMatchingPathRegex(String path) {
        boolean isMatching = Pattern.compile("(.+)(.txt)$").matcher(path).matches();
        return isMatching;
    }
    
    public boolean isConvertibleToInt(String s) {
        boolean isConvertable = false;
        
        if (s != null && s.length() != 0) {
            int i = 0;
            if(s.charAt(i) == '-' && s.length() > 1) {
                i++;
            }
            while(i < s.length() && s.charAt(i)>='0' && s.charAt(i) <= '9') {
                i++;
            }
            if(i == s.length()) {
                isConvertable = true;
            }
        }     
        return isConvertable;
    }

}
