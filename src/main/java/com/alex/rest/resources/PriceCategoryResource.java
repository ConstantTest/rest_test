package com.alex.rest.resources;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.PriceCategory;
import com.alex.rest.repository.payment.PriceCategoryRepository;
import com.alex.rest.exceptions.InvalidParameterException;
import com.alex.rest.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

//@Path("prices/{price_id}/categories")
//@Produces(MediaType.APPLICATION_JSON)
//@Component
public class PriceCategoryResource {

    @Autowired
    private PriceServiceImpl priceService;
//    @Autowired
//    private PriceCategoryService categoryService;
    @Autowired
    private PriceCategoryRepository categoryRepository;

    // Retrieve

//    @GET
//    public PriceCategory getCategory(@PathParam("price_id") Long id) throws InvalidParameterException {
//        if (id < 0) {
//            throw new InvalidParameterException("Invalid input");
//        }
//        Optional<PriceCategory> category =
//                categoryService.findAll().stream().filter(c -> id.equals(c.getId())).findFirst();
//        return category.orElseThrow(() -> new NullPointerException("The category is not found."));
//    }
//
//    // Create
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createPrice(@PathParam("price_id") Long id, PriceCategory category) throws InvalidParameterException {
//        if (id < 0) {
//            throw new InvalidParameterException("Invalid input");
//        }
//        Price searchedPrice = priceService.findById(id);
//        category.setPrice(searchedPrice);
//        categoryService.create(category);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response delete(@PathParam("id") Long id) {
//        if (!categoryRepository.isExist(id)) {
//            throw new NullPointerException("The price category with id = " + id + "is not exist!");
//        }
//        categoryService.delete(id);
//        return Response.ok("The price category is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
//    }
}
