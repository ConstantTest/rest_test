package com.alex.rest.resources;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.Product;
import com.alex.rest.service.EntityService;
import com.alex.rest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Optional;

@Path("products/{productId}/prices")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class PriceResource {

    private final EntityService<Price> priceService;

    @Autowired
    public PriceResource(EntityService<Price> priceService) {
        this.priceService = priceService;
    }

    // Retrieve
    @GET
    @Path("/*")
    public Collection<Price> findAll() {
        return priceService.findAll();
    }

    @GET
    public Price getPrice(@PathParam("productId") Long id) {
        Optional<Price> matchingPrice = priceService.findAll().stream()
                .filter(p -> p.getProduct().getPrice().getId().equals(id))
                .findFirst();
        return priceService.findById(matchingPrice.get().getId());
    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrice(@PathParam("productId") Long id, Price price) {
        priceService.add(price);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        priceService.delete(id);
    }
}
