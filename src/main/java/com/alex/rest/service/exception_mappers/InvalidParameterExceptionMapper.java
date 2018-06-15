package com.alex.rest.service.exception_mappers;

import com.alex.rest.service.exceptions.InvalidParameterException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidParameterExceptionMapper extends BaseExceptionMapper<InvalidParameterException>  {
    @Override
    protected Response.Status statusCode() {
        return Response.Status.BAD_REQUEST;
    }

    @Override
    protected String message(InvalidParameterException exception) {
        return String.format("Invalid Parametr: %s", exception.getMessage());
    }
}
