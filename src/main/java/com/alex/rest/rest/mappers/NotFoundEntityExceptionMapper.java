package com.alex.rest.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundEntityExceptionMapper extends BaseExceptionMapper<NullPointerException> {
    @Override
    protected Response.Status statusCode() {
        return Response.Status.NOT_FOUND;
    }

    @Override
    protected String message(NullPointerException exception) {
        return String.format("No entity found: %s ", exception.getMessage());
    }
}
