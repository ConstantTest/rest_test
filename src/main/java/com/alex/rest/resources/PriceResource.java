package com.alex.rest.resources;

import com.alex.rest.domen.Price;
import com.alex.rest.service.PriceService;
import com.alex.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("products/{productId}/prices")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class PriceResource {

    private final PriceService priceService;

    @Autowired
    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }

    // Retrieve
    @GET
    public Collection<Price> findAll(@PathParam("productId") Long id) {
        return priceService.findAll(id);
    }

    @GET
    @Path("/{id}")
    public Price getPrice(@PathParam("id") Long id) {
        return priceService.findById(id);
    }

    // Create/update
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrice(Price price) {
        priceService.add(price);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        priceService.delete(id);
    }
}
