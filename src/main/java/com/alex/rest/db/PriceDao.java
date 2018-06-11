package com.alex.rest.db;

import com.alex.rest.core.Price;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PriceDao extends AbstractDAO<Price> {

    public PriceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Price> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public List<Price> findAll() {
        return list(namedQuery("com.alex.rest.core.Price.findAll"));
    }

    public Price create(Price price) {
        return persist(price);
    }

    public void delete(long id) {
        namedQuery("com.alex.rest.core.Price.delete").setParameter("id",id).executeUpdate();
    }
}
