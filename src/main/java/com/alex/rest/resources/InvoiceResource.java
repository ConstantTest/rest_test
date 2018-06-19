package com.alex.rest.resources;

import com.alex.rest.exceptions.InvalidParameterException;
import com.alex.rest.service.dto.InvoiceDto;
import com.alex.rest.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("invoices")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class InvoiceResource {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    // Retrieve

    @GET
    public Collection<InvoiceDto> findAll() throws InvalidParameterException {
        return invoiceService.findAll();
    }

    // Create
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createInvoiceDto(InvoiceDto dto) throws InvalidParameterException {
//        invoiceService.create(order);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response delete(@PathParam("id") long id) {
//        if (!repository.isExist(id)) {
//            throw new NullPointerException("The order with id = " + id + " is not exist!");
//        }
//
//        orderServiceImpl.delete(id);
//        return Response.ok("The order is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
//    }
}
