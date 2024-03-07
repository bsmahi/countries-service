package com.learnspring.webservice;

import io.spring.guides.countries_web_service.GetCountryRequest;
import io.spring.guides.countries_web_service.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint // The annotation registers the class with Spring WS as a potential candidate for processing incoming SOAP messages
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/countries-web-service";

    private final CountriesRepository countriesRepository;

    // Constructor Dependency Injection
    public CountryEndpoint(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    /**
     * <code>PayloadRoot</code> annotation is then used by Spring WS to pick the handler method, based on the message’s namespace and localPart.
     * <code>RequestPayload</code> annotation indicates that the incoming message will be mapped to the method’s request parameter
     * <code>ResponsePayload</code> annotation makes Spring WS map the returned value to the response payload
     * @param request payload for fetching the countries
     * @return countries details
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        var response = new GetCountryResponse();
        response.setCountry(countriesRepository.findCountry(request.getName()));

        return response;
    }
}
