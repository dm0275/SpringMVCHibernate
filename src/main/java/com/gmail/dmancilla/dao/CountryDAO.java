package com.gmail.dmancilla.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.dmancilla.model.Country;

/**
 * Created by dmancilla on 12/20/2016.
 */
@Repository
public class CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        List<Country> countryList = (List<Country>) session.createQuery("FROM Country").list();
        return countryList;
    }

    public Country getCountry(final int id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = (Country) session.load(Country.class, new Integer(id));
        return country;
    }

    public Country addCountry(final Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(country);
        return country;
    }

    public void updateCountry(final Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.update(country);
    }

    public void deleteCountry(final int id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = (Country) session.load(Country.class, new Integer(id));
        if (country != null) {
            session.delete(country);
        }
    }
}
