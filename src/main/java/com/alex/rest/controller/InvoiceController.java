package com.alex.rest.controller;

import com.alex.rest.repository.SearchCriteria;
import com.alex.rest.service.dto.InvoiceDto;
import com.alex.rest.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path("/invoices")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @GET
    @Path("/test")
    public List<InvoiceDto> search(@QueryParam(value = "search") String search) {
        List<SearchCriteria> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(w+?)(:|<|>)(w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while(matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return invoiceService.searchInvoice(params);
    }
}
