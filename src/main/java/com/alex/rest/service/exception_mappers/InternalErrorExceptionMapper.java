package com.alex.rest.service.exception_mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalErrorExceptionMapper extends BaseExceptionMapper<Exception> {
    @Override
    protected Response.Status statusCode() {
        return Response.Status.INTERNAL_SERVER_ERROR;
    }

    @Override
    protected String message(Exception exception) {
        return String.format("Server Error: %s", exception.getMessage());
    }
}
