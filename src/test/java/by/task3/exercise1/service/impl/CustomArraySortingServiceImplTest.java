package by.task3.exercise1.service.impl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import by.task3.exercise1.service.CustomArraySortingService;
import by.task3.exercise1.service.ServiceFactory;

public class CustomArraySortingServiceImplTest {

    private static final ServiceFactory FACTORY = ServiceFactory.getInstance();
    private static final CustomArraySortingService SERVICE = FACTORY.getSorter();

    @Test
    public void sortViaBubbleTest() {
        int[] nums = new int[] {4, 6, 5, 7};
        SERVICE.sortViaBubble(nums);
        int[] expected = new int[] {4, 5, 6, 7};
        assertEquals(nums, expected);
    }

    @Test
    public void sortViaInsertionTest() {
        int[] nums = new int[] {4, 6, 5, 7};
        SERVICE.sortViaInsertion(nums);
        int[] expected = new int[] {4, 5, 6, 7};
        assertEquals(nums, expected);
    }

    @Test
    public void sortViaSelectionTest() {
        int[] nums = new int[] {4, 6, 5, 7};
        SERVICE.sortViaSelection(nums);
        int[] expected = new int[] {4, 5, 6, 7};
        assertEquals(nums, expected);
    }
}
