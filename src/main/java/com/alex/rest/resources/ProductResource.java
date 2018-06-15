package com.alex.rest.resources;

import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.ProductRepository;
import com.alex.rest.service.exceptions.InvalidParameterException;
import com.alex.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ProductResource {

    private ProductService productService;
    private ProductRepository productRepository;

    @Autowired
    public ProductResource(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
    }

    // Retrieve
    @GET
    public Collection<Product> findAll() {
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Long id) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
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
    public Response delete(@PathParam("id") Long id) throws NotFoundException {
        if (!productRepository.isExist(id)) {
            throw new NotFoundException("The product with id = " + id + "is not exist!");
        }
        productService.delete(id);
        return Response.ok("The product is deleted successfully").build();
    }
}
