package com.gmail.dmancilla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.dmancilla.dao.CountryDAO;
import com.gmail.dmancilla.model.Country;

/**
 * Created by dmancilla on 12/20/2016.
 */
@Service("countryService")
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Transactional
    public void addCountry(final Country country) {
        countryDAO.addCountry(country);
    }

    @Transactional
    public void deleteCountry(final int id) {
        countryDAO.deleteCountry(id);
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getAllCountries();
    }

    @Transactional
    public Country getCountry(final int id) {
        return countryDAO.getCountry(id);
    }

    @Transactional
    public void updateCountry(final Country country) {
        countryDAO.updateCountry(country);
    }
}
