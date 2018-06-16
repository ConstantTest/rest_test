package com.alex.rest.resources;

import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.ProductRepository;
import com.alex.rest.service.exceptions.InvalidParameterException;
import com.alex.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ProductResource {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

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
        Optional<Product> product =
                Optional.ofNullable(productService.findById(id));
        return product.orElseThrow(() -> new NullPointerException("The product is not found."));
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
    public Response delete(@PathParam("id") Long id) throws NullPointerException {

        if (!productRepository.isExist(id)) {
            throw new NullPointerException("The product with id = " + id + "is not exist!");
        }
        productService.delete(id);
        return Response.ok("The product is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
