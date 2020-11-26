package by.task3.exercise1.service.impl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import by.task3.exercise1.service.CustomArraySearchService;
import by.task3.exercise1.service.ServiceFactory;

public class CustomArraySearchServiceImplTest {
    
    private static final ServiceFactory FACTORY = ServiceFactory.getInstance();
    private static final CustomArraySearchService SERVICE = FACTORY.getSearchService();
    private static final int[] array = new int[] {4, 7, 6, 5};

    @Test
    public void findElementViaBinarySearchTest() {
        int actual = SERVICE.findElementIndexViaBinarySearch(array, 6);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void findFibonacciNumbersTest() {
        int[] actual = SERVICE.findFibonacciNumbers(array);
        int[] expected = new int[] {5};
        assertEquals(actual, expected);
    }

    @Test
    public void findIndexOfMaxTest() {
        int actual = SERVICE.findIndexOfMax(array);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void findIndexOfMinTest() {
        int actual = SERVICE.findIndexOfMin(array);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void findSimpleNumbersTest() {
        int[] actual = SERVICE.findSimpleNumbers(array);
        int[] expected = new int[] {7, 5};
        assertEquals(actual, expected);
    }

    @Test
    public void findThreeUniqueDigitNumbersTest() {
        int[] actual = SERVICE.findThreeUniqueDigitNumbers(array);
        int[] expected = new int[0];
        assertEquals(actual, expected);
    }

}
