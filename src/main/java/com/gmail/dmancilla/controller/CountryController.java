package com.gmail.dmancilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.dmancilla.model.Country;
import com.gmail.dmancilla.service.CountryService;

/**
 * Created by dmancilla on 12/20/2016.
 */
@Controller
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addCountry(@ModelAttribute("country") Country country) {
        if (country.getId() == 0) {
            countryService.addCountry(country);
        } else {
            countryService.updateCountry(country);
        }

        return "redirect:/getAllCountries";
    }

    @RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);
        return "redirect:/getAllCountries";
    }

    @RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getCountries(Model model) {
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("country", new Country());
        model.addAttribute("listOfCountries", listOfCountries);
        return "countryDetails";
    }

    @RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable("id") int id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCountry(@PathVariable("id") int id, Model model) {
        model.addAttribute("country", countryService.getCountry(id));
        model.addAttribute("listOfCountries", countryService.getAllCountries());
        return "countryDetails";
    }
}
