package by.task3.exercise1.service;

import by.task3.exercise1.service.impl.CustomArraySearchServiceImpl;
import by.task3.exercise1.service.impl.CustomArraySortingServiceImpl;
import by.task3.exercise1.service.impl.CustomArrayValueProviderServiceImpl;

public class ServiceFactory {
    
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final CustomArrayValueProviderService valueProvider = new CustomArrayValueProviderServiceImpl();
    private final CustomArraySearchService searchService = new CustomArraySearchServiceImpl();
    private final CustomArraySortingService sorter = new CustomArraySortingServiceImpl();
    
    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public CustomArrayValueProviderService getValueProvider() {
        return valueProvider;
    }

    public CustomArraySearchService getSearchService() {
        return searchService;
    }

    public CustomArraySortingService getSorter() {
        return sorter;
    }
}
