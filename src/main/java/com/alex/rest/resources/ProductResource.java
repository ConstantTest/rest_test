package com.alex.rest.resources;

import com.alex.rest.domen.Product;
import com.alex.rest.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ProductResource {

    private EntityService<Product> productService;

    @Autowired
    public ProductResource(EntityService<Product> productService) {
        this.productService = productService;
    }

    // Retrieve
    @GET
    public Collection<Product> findAll() {
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Long id) {
        return productService.findById(id);
    }

    // Create/update
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(Product product) {
        productService.add(product);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        productService.delete(id);
    }
}
