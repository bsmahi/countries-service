package com.learnspring.webservice;

import io.spring.guides.countries_web_service.Country;
import io.spring.guides.countries_web_service.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountriesRepository {

    private static final Map<String, Country> countryDetails = new HashMap<>();

    @PostConstruct
    public void initData() {
        var countryOne = new Country();
        countryOne.setCountryName("Spain");
        countryOne.setCapital("Madrid");
        countryOne.setCurrency(Currency.EUR);
        countryOne.setPopulation(200000);
        countryOne.setLanguage("Spanish");

        countryDetails.put(countryOne.getCountryName(), countryOne);

        var countryTwo = new Country();
        countryTwo.setCountryName("Poland");
        countryTwo.setCapital("Warsaw");
        countryTwo.setCurrency(Currency.PLN);
        countryTwo.setPopulation(200001);
        countryTwo.setLanguage("polish");

        countryDetails.put(countryTwo.getCountryName(), countryTwo);

        var countryThree = new Country();
        countryThree.setCountryName("United Kingdom");
        countryThree.setCapital("London");
        countryThree.setCurrency(Currency.GBP);
        countryThree.setPopulation(200002);
        countryThree.setLanguage("English");

        countryDetails.put(countryThree.getCountryName(), countryThree);

    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countryDetails.get(name);
    }
}
