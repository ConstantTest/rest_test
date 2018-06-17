package com.alex.rest.resources;

import com.alex.rest.domen.Order;
import com.alex.rest.domen.Price;
import com.alex.rest.domen.Product;
import com.alex.rest.domen.Tenant;
import com.alex.rest.repository.payment.OrderRepository;
import com.alex.rest.service.OrderService;
import com.alex.rest.service.TenantService;
import com.alex.rest.service.exceptions.InvalidParameterException;
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
import java.util.List;
import java.util.Optional;

@Path("tenants/{tenant_id}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class OrderResource {

    @Autowired
    private OrderService orderService;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private OrderRepository repository;

    // Retrieve

    @GET
    public Collection<Order> findAll(@PathParam("tenant_id") Long id) throws InvalidParameterException{
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        return tenantService.findById(id).getOrders();
    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrder(@PathParam("tenant_id") Long id, Order order) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input");
        }
        Tenant currentTenant = tenantService.findById(id);
        order.setTenant(currentTenant);
        orderService.add(order);
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
