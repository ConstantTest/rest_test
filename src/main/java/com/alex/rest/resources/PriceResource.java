package com.alex.rest.resources;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.PriceRepository;
import com.alex.rest.service.PriceService;
import com.alex.rest.service.ProductService;
import com.alex.rest.service.QueryService;
import com.alex.rest.service.exceptions.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Optional;

@Path("products/{product_id}/prices")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class PriceResource {

    @Autowired
    private PriceService priceService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PriceRepository priceRepository;

    // Retrieve

    @GET
    public Collection<Price> findAll(@PathParam("product_id") Long id) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        return productService.findById(id).getPrices();
    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrice(@PathParam("product_id") Long id, Price price) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        price.setProduct(productService.findById(id));
        priceService.add(price);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (!priceRepository.isExist(id)) {
            throw new NullPointerException("The price with id = " + id + "is not exist!");
        }
        priceService.delete(id);
        return Response.ok("The price is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
