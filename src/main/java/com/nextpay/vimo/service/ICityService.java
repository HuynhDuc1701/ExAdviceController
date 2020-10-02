package com.nextpay.vimo.service;

import com.nextpay.vimo.model.City;

import java.util.List;

public interface ICityService {

    City findById(Long id);
    City save(City city);
    List<City> findAll();
}
