package by.task3.exercise1.entity;

import java.io.Serializable;
import java.util.Arrays;

public class CustomArray implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int[] numbers;
    
    public CustomArray(){}

    public CustomArray(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(numbers);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomArray other = (CustomArray) obj;
        if (!Arrays.equals(numbers, other.numbers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append(" [numbers=");
        builder.append(Arrays.toString(numbers));
        builder.append("]");
        return builder.toString();
    }
}
