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

@Path("/orders")
public class OrderResource {

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{ord-num}")
	public Order fetchOrderDetailsForUser(@PathParam("uname") String username,
			@PathParam("ord-num") String number) throws OrderNotFoundException {
		Order order;
		order = new TiendaService().getOrderDetailsForUser(username, number);

		return order;

	}
//
//	@GET
//	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Set<Order> fetchAllwisForUser(@PathParam("uname") String username) {
//		Set<Order> orders;
//		orders = new TiendaService().getAllOrdersForUser(username);
//		return orders;
//
//	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createwishlist(Wishlist wishlist) throws URISyntaxException {
		System.out.println(wishlist.getWishlistId());
		

		return Response.created(new URI("http://localhost:8080/tienda"))
				.build();
	}

	TiendaService ts=new TiendaService();
	@DELETE
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("deletes/{wish-num}")
	public Response deleteWishlist(@PathParam("uname") String username,@PathParam("ord-num") String number) throws URISyntaxException, OrderNotFoundException, WishlistNotFoundException {
		//List<Order>
//		Wishlist wishlist;
//		wishlist=ts.getWishlistForUser(username);
		
		Wishlist wish;
		wish=ts.getWishlistForUser(username);
		
		return Response.status(200).entity("Deleted").build();
//		orders.remove(order);
//		ts.setOrdersForUser(orders);
//		return orders;
		
		
		
		// return Response.created(new URI("http://localhost:8080/tienda")).build();
	}

}
