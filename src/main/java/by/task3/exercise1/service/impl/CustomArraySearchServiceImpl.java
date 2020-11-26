package by.task3.exercise1.service.impl;

import by.task3.exercise1.service.CustomArraySearchService;

public class CustomArraySearchServiceImpl implements CustomArraySearchService {
    
    @Override
    public int findElementIndexViaBinarySearch(int[] array, int value) {
        int startingPoint = 0;
        int finishingPoint = array.length;
        int middle = (startingPoint + finishingPoint) / 2;
        int index = -1;
        
        while (startingPoint <= finishingPoint) {          
            if(array[middle] == value) {
                index = middle;
                break;
            } else if (array[middle] < value) {
                startingPoint = middle + 1;
            } else {
                finishingPoint = middle - 1;
            }
            
            middle /= 2;
        }        
        return index;
    }
    
    @Override
    public int findIndexOfMax(int[] array) {
        int indexOfMax = 0;
        for(int i = 1; i < array.length; i++) {
            if (array[i] > array[indexOfMax]) {
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
    
    @Override
    public int findIndexOfMin(int[] array) {
        int indexOfMin = 0;
        for(int i = 1; i < array.length; i++) {
            if (array[i] < array[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    @Override
    public int[] findSimpleNumbers(int[] array) {
        int[] simpleNumbers = new int[countSimpleNumbers(array)];        
        int i = 0;
        for (int num : array) {
            if(isSimpleNum(num)) {
                simpleNumbers[i] = num;
                i++;
            }
        }
        return simpleNumbers;
    }
    
    public int countSimpleNumbers(int[] array) {
        int counter = 0;
        for (int num : array) {
            if (isSimpleNum(num)) {
                counter++;
            }
        }
        return counter;
    }
    
    public boolean isSimpleNum(int num) {
        boolean isSimple;
        
        int devisor = num - 1;
        while (devisor > 1) {
            if (num % devisor == 0) {
                break;
            }
            devisor--;
        }        
        isSimple = (devisor == 1);        
        return isSimple;        
    }
          
    @Override
    public int[] findFibonacciNumbers(int[] array) {
        int[] fibonacci = new int[countFibonacciNumbers(array)];
        int i = 0;
        for (int num : array) {
            if (isFibonacciNum(num)) {
                fibonacci[i] = num;
                i++;
            }
        }
        return fibonacci;
    }
    
    public int countFibonacciNumbers(int[] array) {
        int counter = 0;
        for (int num : array) {
            if (isFibonacciNum(num)) {
                counter++;
            }
        }
        return counter;
    }
    
    public boolean isFibonacciNum(int num) {
        int value1 = 5 * num * num + 4;
        int value2 = 5 * num * num - 4;
        boolean isFibonacci = (isPerfectSquare(value1) || isPerfectSquare(value2));
        return isFibonacci;
    }
    
    public boolean isPerfectSquare(int num) {
        int root = (int)Math.sqrt(num);
        boolean isPerfect = (root*root == num);
        return isPerfect;
    }

    @Override
    public int[] findThreeUniqueDigitNumbers(int[] array) {
        int[] threeDigitNums = new int[countThreeUniqueDigitNumbers(array)];
        int i = 0;
        for (int num : array) {
            if (isThreeDigitNumber(num) && areUniqueDigits(num)) {
                threeDigitNums[i] = num;
                i++;
            }
        }       
        return threeDigitNums;
    }
    
    public int countThreeUniqueDigitNumbers(int[] array) {
        int counter = 0;
        for (int num : array) {
            if (isThreeDigitNumber(num) && areUniqueDigits(num)) {
                counter++;
            }
        }
        return counter;
    }
    
    public boolean isThreeDigitNumber(int num) {
        boolean isThreeDigitNum = ((int)Math.log10(num) + 1 == 3);
        return isThreeDigitNum;
    }
    
    public boolean areUniqueDigits(int num) {        
        int a = num % 10;
        int b = num % 100 / 10;
        int c = num % 100 / 100;
        
        boolean areUnique = (a != b && a != c && b != c);
        return areUnique;
    }
}
