package com.noyex.weatherservice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noyex.weatherclient.city_client.ICityClient;
import com.noyex.weathercore.contracts.CityDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements ICityService {

    private ICityClient cityClient;
    private ObjectMapper objectMapper;

    @Override
    public CityDetailsDto getCity(String city) {
        String jsonWeather = cityClient.fetchCity(city);
        try{
            List<CityDetailsDto> cityDetailsDtos = objectMapper.readValue(jsonWeather, new TypeReference<List<CityDetailsDto>>() {});
            return cityDetailsDtos.getFirst();
        }
        catch (JsonProcessingException e){
            throw new RuntimeException("Error parsing weather data ", e);
        }
    }

    @Override
    public double getCityLat(CityDetailsDto city) {
        return city.latitude();
    }

    @Override
    public double getCityLon(CityDetailsDto city) {
        return city.longitude();
    }

}
