package com.alex.rest.resources;

import com.alex.rest.core.Product;
import com.alex.rest.db.ProductDao;
import io.dropwizard.hibernate.UnitOfWork;
import javafx.print.PaperSource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductDao productDao;

    public ProductResource(ProductDao productDao) {
        this.productDao = productDao;
    }

    // Retrieve
    @GET
    @UnitOfWork
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Product getProduct(@PathParam("id") Long id) {
        return findSafely(id);
    }

    // Create/update
    @POST
    @UnitOfWork
    public void createProduct(Product product) {
        productDao.create(product);
    }

    private Product findSafely(long productId) {
        return productDao.findById(productId).orElseThrow(() -> new NotFoundException("No such product"));
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        productDao.delete(id);
    }
}
