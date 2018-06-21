package com.alex.rest.resources;

import com.alex.rest.repository.payment.ProductRepository;
import com.alex.rest.exceptions.InvalidParameterException;
import com.alex.rest.service.dto.ProductDto;
import com.alex.rest.service.impl.OrderServiceImpl;
import com.alex.rest.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Optional;

@Path("orders/{order_id}/products")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ProductResource {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;

    // Retrieve
    @GET
    public Collection<ProductDto> findAll() throws InvalidParameterException {
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public ProductDto getProductDto(@PathParam("id") Long id) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        Optional<ProductDto> productDto =
                Optional.ofNullable(productService.findById(id));
        return productDto.orElseThrow(() -> new NullPointerException("The product is not found."));
    }

    // Create/update
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDto productDto,@PathParam("order_id") Long orderId) throws InvalidParameterException{
        if (orderId < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        ProductDto createdProductDto = productService.createProductForOrder(productDto, orderId);

        return Response.status(201).type(MediaType.APPLICATION_JSON_TYPE).entity(createdProductDto).build();
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
