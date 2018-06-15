package com.alex.rest.resources;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.Product;
import com.alex.rest.service.PriceService;
import com.alex.rest.service.ProductService;
import com.alex.rest.service.QueryService;
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

    private PriceService priceService;

    private ProductService productService;

    @Autowired
    public PriceResource(PriceService priceService, ProductService productService) {
        this.priceService = priceService;
        this.productService = productService;
    }

    // Retrieve
    @GET
    @Path("/*")
    public Collection<Price> findAll() {
        return priceService.findAll();
    }

    @GET
    public Price getPrice(@PathParam("productId") Long id) {
//        Optional<Price> matchingPrice = priceService.findAll().stream()
//                .filter(p -> p.getProduct().getPrice().getId().equals(id))
//                .findFirst();
        return priceService.findById(1L);
    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrice(@PathParam("productId") Long id, Price price) {
        Product searchedProduct = productService.findById(id);
        price.setProduct(searchedProduct);
        priceService.add(price);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        priceService.delete(id);
    }
}
