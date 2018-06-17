package com.alex.rest.resources;

import com.alex.rest.domen.Tenant;
import com.alex.rest.repository.payment.TenantRepository;
import com.alex.rest.service.TenantService;
import com.alex.rest.service.exceptions.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import java.util.Optional;

@Path("/tenants")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class TenantResource {

    @Autowired
    private TenantService tenantService;
    @Autowired
    private TenantRepository tenantRepository;

    // Retrieve
    @GET
    public Collection<Tenant> findAll() {
        return tenantService.findAll();
    }

    @GET
    @Path("/{id}")
    public Tenant getTenant(@PathParam("id") Long id) throws InvalidParameterException {
        if (id < 0) {
            throw new InvalidParameterException("Invalid input.");
        }
        Optional<Tenant> tenant =
                Optional.ofNullable(tenantService.findById(id));
        return tenant.orElseThrow(() -> new NullPointerException("The tenant is not found."));
    }

    // Create/update
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(Tenant tenant) {
        tenantService.add(tenant);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) throws NullPointerException {

        if (!tenantRepository.isExist(id)) {
            throw new NullPointerException("The tenant with id = " + id + "is not exist!");
        }
        tenantService.delete(id);
        return Response.ok("The tenant is deleted successfully").type(MediaType.TEXT_PLAIN_TYPE).build();
    }
}
