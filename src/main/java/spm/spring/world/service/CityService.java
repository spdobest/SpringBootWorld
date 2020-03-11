package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.model.City;
import spm.spring.world.repository.CityRepository;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {

        return (List<City>) cityRepository.findAll();

    }
}