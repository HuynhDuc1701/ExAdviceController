package com.nextpay.vimo.service;


import com.nextpay.vimo.exception.CityNotFoundException;
import com.nextpay.vimo.exception.NoDataFoundException;
import com.nextpay.vimo.model.City;
import com.nextpay.vimo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findById(Long id) {

        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City save(City city) {

        return cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) cityRepository.findAll();

        if (cities.isEmpty()) {

            throw new NoDataFoundException();
        }

        return cities;
    }
}
