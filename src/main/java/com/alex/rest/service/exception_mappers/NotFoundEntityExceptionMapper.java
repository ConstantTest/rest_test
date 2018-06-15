package com.alex.rest.service.exception_mappers;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

public class NotFoundEntityExceptionMapper extends BaseExceptionMapper<NotFoundException> {
    @Override
    protected Response.Status statusCode() {
        return Response.Status.NOT_FOUND;
    }

    @Override
    protected String message(NotFoundException exception) {
        return String.format("No entity found: %s", exception.getMessage());
    }
}
