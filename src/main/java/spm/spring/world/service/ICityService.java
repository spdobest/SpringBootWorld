package spm.spring.world.service;

import spm.spring.world.model.City;

import java.util.List;

public interface ICityService {

    List<City> findAll();
}