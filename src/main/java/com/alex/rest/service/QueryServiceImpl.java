package com.alex.rest.service;

import com.alex.rest.repository.payment.InvoiceRepository;
import com.alex.rest.service.dto.InvoiceDto;
import com.alex.rest.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class QueryServiceImpl {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Autowired
    private InvoiceRepository invoiceRepository;


    @GET
    public Response getEntity(@QueryParam("param") String s) {
        Object o = new Object();

        if (s.equalsIgnoreCase("all")) {
            Collection<InvoiceDto> dtoInvoices = invoiceService.findAll();
            o = dtoInvoices;
        }
        return Response.status(200).type(MediaType.APPLICATION_JSON_TYPE).entity(o).build();
    }
}
