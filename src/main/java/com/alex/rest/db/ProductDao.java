package com.alex.rest.db;

import com.alex.rest.core.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ProductDao extends AbstractDAO<Product>{

    public ProductDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public List<Product> findAll() {
        return list(namedQuery("com.alex.rest.core.Product.findAll"));
    }

    public Product create(Product product) {
        return persist(product);
    }

    public void delete(long id) {
        namedQuery("com.alex.rest.core.Product.delete").setParameter("id",id).executeUpdate();
    }
}
