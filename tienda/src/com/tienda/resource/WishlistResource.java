package com.tienda.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tienda.bean.Order;
import com.tienda.bean.Wishlist;
import com.tienda.service.TiendaService;
import com.tienda.util.OrderNotFoundException;
import com.tienda.util.WishlistNotFoundException;

@Path("/wishlist")
public class WishlistResource {

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Wishlist fetchWishlistForUser(@PathParam("uname") String username)
			throws WishlistNotFoundException {
		Wishlist wishlist;
		wishlist = new TiendaService().getWishlistForUser(username);
		return wishlist;

	}

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set<Order> fetchAllOrdersForUser(@PathParam("uname") String username) {
		Set<Order> orders;
		orders = new TiendaService().getAllOrdersForUser(username);
		return orders;

	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createOrder(Order order) throws URISyntaxException {
		System.out.println(order.getNumber());
		System.out.println(order.getOrderId());

		return Response.created(new URI("http://localhost:8080/tienda"))
				.build();
	}

	TiendaService ts=new TiendaService();
	@DELETE
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("deletes/{ord-num}")
	public Response deleteOrder(@PathParam("uname") String username,@PathParam("ord-num") String number) throws URISyntaxException, OrderNotFoundException {
		//List<Order>
		Order order;
		order=ts.getOrderDetailsForUser(username, number);
		
		List<Order> orders;
		orders=ts.getOrdersForUser(username);
		
		orders.remove(order);
		ts.setOrdersForUser(orders);
		System.out.println(orders.toString());
		return Response.status(200).entity("Deleted").build();
//		orders.remove(order);
//		ts.setOrdersForUser(orders);
//		return orders;
		
		
		
		// return Response.created(new URI("http://localhost:8080/tienda")).build();
	}

}
