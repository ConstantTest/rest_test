package com.alex.rest.rest.mappers;

import com.fasterxml.jackson.databind.JsonMappingException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonExceptionMapper extends BaseExceptionMapper<JsonMappingException> {

    @Override
    protected Response.Status statusCode() {
        return Response.Status.BAD_REQUEST;
    }

    @Override
    protected String message(JsonMappingException exception) {

        return String.format("%s", exception.getMessage());
    }
}
