package by.task3.exercise1.service.impl;

import by.task3.exercise1.service.CustomArraySortingService;

public class CustomArraySortingServiceImpl implements CustomArraySortingService {
    
    @Override
    public void sortViaBubble(int[] array) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
        }    
    }

    @Override
    public void sortViaSelection(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int indexOfMin = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[indexOfMin]) {
                    indexOfMin = j;
                }                              
            }
            if (indexOfMin != i) {
                int temp = array[i];
                array[i] = array[indexOfMin];
                array[indexOfMin] = temp;
            }
        }
    }

    @Override
    public void sortViaInsertion(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }      
    }
}
