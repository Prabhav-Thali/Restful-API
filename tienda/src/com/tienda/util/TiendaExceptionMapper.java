package com.tienda.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider  //component class(es)
public class TiendaExceptionMapper implements ExceptionMapper<TiendaException> {

	@Override
	public Response toResponse(TiendaException ex) {
		// TODO Auto-generated method stub

		return Response.status(Response.Status.BAD_REQUEST)
				.entity(ex.getExceptionMessage()).build();
	}

}
