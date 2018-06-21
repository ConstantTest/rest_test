package com.alex.rest.resources;

import com.alex.rest.exceptions.InvalidParameterException;
import com.alex.rest.repository.payment.InvoiceRepository;
import com.alex.rest.service.dto.InvoiceDto;
import com.alex.rest.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

@Path("invoices")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class InvoiceResource {

    @Autowired
    private InvoiceServiceImpl invoiceService;
    @Autowired
    private InvoiceRepository repository;

    // Retrieve
//    @GET
//    public Collection<InvoiceDto> findAll() throws InvalidParameterException {
//        return invoiceService.findAll();
//    }

    @GET
    @Path("/amount")
    public Response getAmountById(@QueryParam("id") Long id) {
        BigDecimal amount = BigDecimal.valueOf(invoiceService.findAll().stream()
                .filter(dto -> dto.getId().equals(id)).count());

        return Response.status(200).entity("id: " + id + ", amount = " + amount).build();
    }
//
//    @GET
//    @Path("/amount")
//    public Response getAmountById(@Context UriInfo uriInfo) {
//
//
//        return Response.status(200).type(MediaType.TEXT_PLAIN_TYPE).build();
//    }

    // Create
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createInvoiceDto(InvoiceDto invoiceDto) {
        InvoiceDto createdInvoiceDto = invoiceService.create(invoiceDto);

        return Response.status(201).entity(createdInvoiceDto).type(MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (!repository.isExist(id)) {
            throw new NullPointerException("The invoice with id = " + id + " is not exist!");
        }
        invoiceService.delete(id);
        return Response.ok("The invoice is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
