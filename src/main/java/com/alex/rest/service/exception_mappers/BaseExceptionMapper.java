package com.alex.rest.service.exception_mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


public abstract class BaseExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    @Override
    public Response toResponse(T exception) {
        return handler(exception);
    }

    protected Response handler(T exception) {
        return Response.status(statusCode())
                .entity(message(exception))
                .type(MediaType.TEXT_PLAIN)
                .build();
    }

    protected abstract Response.Status statusCode();

    protected abstract String message(T exception);
}
