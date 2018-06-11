package com.alex.rest.resources;

import com.alex.rest.core.Price;
import com.alex.rest.core.Product;
import com.alex.rest.db.PriceDao;
import com.alex.rest.db.ProductDao;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/products/prices")
@Produces(MediaType.APPLICATION_JSON)
public class PriceResource {

    private final PriceDao priceDao;

    public PriceResource(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    // Retrieve
    @GET
    @UnitOfWork
    public List<Price> findAll() {
        return priceDao.findAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Price getPrice(@PathParam("id") Long id) {
        return findSafely(id);
    }

    // Create/update
    @POST
    @UnitOfWork
    public void createPrice(Price price) {
        priceDao.create(price);
    }

    private Price findSafely(long priceId) {
        return priceDao.findById(priceId).orElseThrow(() -> new NotFoundException("No such product"));
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        priceDao.delete(id);
    }
}
