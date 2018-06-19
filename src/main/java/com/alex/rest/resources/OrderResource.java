package com.alex.rest.resources;

import com.alex.rest.domen.Order;
import com.alex.rest.repository.payment.OrderRepository;
import com.alex.rest.exceptions.InvalidParameterException;
import com.alex.rest.service.dto.OrderDto;
import com.alex.rest.service.impl.OrderServiceImpl;
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
import java.util.Collection;

@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class OrderResource {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository repository;

    // Retrieve

    @GET
    public Collection<OrderDto> findAll(){
        return orderService.findAll();
    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrderDto(OrderDto orderDto) throws InvalidParameterException {
        orderService.create(orderDto);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (!repository.isExist(id)) {
            throw new NullPointerException("The order with id = " + id + " is not exist!");
        }

        orderService.delete(id);
        return Response.ok("The order is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
