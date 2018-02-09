package com.tienda.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.tienda.bean.ExceptionMessage;
import com.tienda.bean.Link;
import com.tienda.bean.Order;
import com.tienda.bean.User;
import com.tienda.service.TiendaService;
import com.tienda.util.UserNotFoundException;

@Path("/users")
public class UserResource { // resource class

	@Context
	private ResourceContext resourcecontext;

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{uname}")
	// template param
	// public User fetchUserDetails(@QueryParam("uname") String username)
	public User fetchUserDetails(@PathParam("uname") String username)
			throws UserNotFoundException {
		// resource method
		User user;
		user = new TiendaService().getUserDetails(username);
		user.setLinks(new HashSet<Link>());

		UriBuilder baseBuilder = uriInfo.getBaseUriBuilder();
		baseBuilder.path(UserResource.class);
		baseBuilder.path(UserResource.class, "getSubResource").resolveTemplate(
				"uname", username);

		user.getLinks()
				.add(new Link(UriBuilder.fromPath(baseBuilder.toTemplate())
						.resolveTemplate("sub-resource-name", "orders").build()
						.toString(), "collection", String.format("%s,%s",
						MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)));

		return user;

	}

	
	
	
	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createUser(User user) throws URISyntaxException {

		System.out.println(user.getUserId());
		System.out.println(user.getUsername());

		return Response.created(new URI("http://localhost:8080/tienda"))
				.build();
	}

	@Path("{uname}/{sub-resource-name}")
	public Object getSubResource(
			@PathParam("sub-resource-name") String subResourceName)// sub-resource
																	// locator
	{
		if ("orders".equals(subResourceName)) {
			return resourcecontext.getResource(OrderResource.class);
		} else if ("wishlist".equals(subResourceName)) {
			return resourcecontext.getResource(WishlistResource.class);
		}
		throw new WebApplicationException(Response
				.status(Response.Status.NOT_FOUND)
				.entity(new ExceptionMessage("Resource Not found")).build());

	}

}
