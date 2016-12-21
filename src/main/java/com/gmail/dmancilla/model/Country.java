package com.gmail.dmancilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dmancilla on 12/20/2016.
 */
@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "population")
    private long population;

    public Country() {
        super();
    }

    public Country(int id, String countryName, long population ) {
        super();
        setId(id);
        setCountryName(countryName);
        setPopulation(population);
    }

    public String getCountryName() {
        return countryName;
    }

    public int getId() {
        return id;
    }

    public long getPopulation() {
        return population;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
