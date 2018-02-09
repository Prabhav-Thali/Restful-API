package com.tienda.util;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.tienda.bean.ExceptionMessage;
import com.tienda.bean.Order;
import com.tienda.bean.Product;
import com.tienda.bean.User;
import com.tienda.bean.Wishlist;

public class DataStore {
	private static List<User> users = new CopyOnWriteArrayList<User>();
	private static List<Product> products = new CopyOnWriteArrayList<Product>();
	private static List<Order> orders = new CopyOnWriteArrayList<Order>();
	public static List<Order> getOrders() {
		return orders;
	}

	public static void setOrders(List<Order> orders) {
		DataStore.orders = orders;
	}

	private static List<Wishlist> wishlists = new CopyOnWriteArrayList<Wishlist>();
	
	
	static {
		User ophelia = new User(1, "Ophelia", "ophelia@ws.uk");
		User gertude = new User(2, "Gertude", "gertude@ws.uk");
		User laertes = new User(3, "Laertes", "laertes@ws.uk");
		User fortinbras = new User(4, "Fortinbras", "fortinbras@ws.uk");
		
		users.add(ophelia);
		users.add(gertude);
		users.add(laertes);
		users.add(fortinbras);
		
		Product roadster_t_shirt = new Product(1, "880589", 
												  "Roadster T-Shirt", 
												  "Black, V-Neck, Long sleeves", 
												  499);
		Product harley_t_shirt = new Product(2, "1292788", 
												"Harley Davidson Polo T-Shirt", 
												"Blue washed polo T-shirt in a pique knit, has a polo collar, a short button placket, short sleeves, two pockets, a vented hem", 
												2304);
		
		Product uspolo_t_shirt = new Product(3, "427414", 
												"U.S. Polo Assn. Men Orange Polo T-shirt", 
												"Orange pique knit polo T-shirt, has a ribbed polo collar, short sleeves with ribbed hems, numerical appliqué on the right sleeve, short button placket on the front, embroidered branding on the left side of the chest, vented hem with the back longer than the front", 
												1399);
		
		Product jackjones_t_shirt = new Product(4, "936908", 
													"Jack & Jones Yellow Printed T-shirt", 
													"Yellow printed T-shirt with slub effect, has a layered round neck and short sleeves", 
													598);
		Product adidas_flipflops = new Product(5, "1193694", 
												  "Adidas Women Charcoal Grey Brizo 4.0 Flip-Flops", 
												  "This stylish pair of flip-flops is lightweight and comfortable. A perfect blend of class and substance, it will look great with your casual outfits", 
												  769);
		
		Product adidas_basketball = new Product(6, "705583", 
													"Adidas Unisex Brown All-Court Basketball", 
													"Make your basketball practice session more fun with this ball from Adidas.", 
													1799);
		Product stevemadden_handbag = new Product(7, "1194021", 
													 "Steve Madden Black Handbag", 
													 "Carry your world in this super stylish handbag from Steve Madden. Irresistibly chic, team it with any outfit for a glamorous look. ", 
													 6999);
		
		Product caprese_wallet = new Product(8, "1247569", 
												"Caprese Women Orange Wallet", 
												"Stylish and chic, this range of wallets from Caprese is made for the urban woman. Carry your monetary essentials in this piece that is so versatile, you could pull it off with anything from your wardrobe.", 
												769);
		
		Product titan_watch = new Product(9, "1399728", 
											"Titan Raga Women Blue Dial Watch", 
											"Leave a lasting impression on everyone with this exquisite watch from Titan. We suggest you team it with an elegant dress to add some glitz.", 
											5636);

		products.add(roadster_t_shirt);
		products.add(harley_t_shirt);
		products.add(uspolo_t_shirt);
		products.add(jackjones_t_shirt);
		products.add(adidas_flipflops);
		products.add(adidas_basketball);
		products.add(stevemadden_handbag);
		products.add(caprese_wallet);
		products.add(titan_watch);
		
		Order order1 = new Order(1, "124719220", 
									Date.valueOf("2016-01-26"), 
									ophelia, 
									OrderStatus.ACTIVE,
									new HashSet<Product>(Arrays.asList(adidas_basketball, uspolo_t_shirt)));
		Order order2 = new Order(2, "119215410", 
				Date.valueOf("2016-02-14"), 
				gertude,
				OrderStatus.ACTIVE,
				new HashSet<Product>(Arrays.asList(titan_watch, caprese_wallet, harley_t_shirt)));		
		Order order3 = new Order(3, "119215340", 
				Date.valueOf("2016-03-23"), 
				laertes, 
				OrderStatus.ACTIVE,
				new HashSet<Product>(Arrays.asList(caprese_wallet, stevemadden_handbag, jackjones_t_shirt, adidas_flipflops)));
		Order order4 = new Order(4, "116410240", 
				Date.valueOf("2016-04-01"), 
				fortinbras, 
				OrderStatus.ACTIVE,
				new HashSet<Product>(Arrays.asList(uspolo_t_shirt, stevemadden_handbag)));
		Order order5 = new Order(5, "96357758", 
				Date.valueOf("2016-05-01"), 
				gertude, 
				OrderStatus.ACTIVE,
				new HashSet<Product>(Arrays.asList(caprese_wallet)));
		Order order6 = new Order(6, "80472941", 
				Date.valueOf("2016-08-15"), 
				fortinbras, 
				OrderStatus.ACTIVE,
				new HashSet<Product>(Arrays.asList(jackjones_t_shirt,adidas_flipflops,titan_watch)));
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
		orders.add(order6);
		
		
		Wishlist wishlist1 = new Wishlist(1, 
										  ophelia, 
										  new HashSet<Product>(Arrays.asList(caprese_wallet, roadster_t_shirt)));
		Wishlist wishlist2 = new Wishlist(2,
										  gertude,
										  new HashSet<Product>(Arrays.asList(titan_watch, adidas_basketball, adidas_flipflops)));
		Wishlist wishlist3 = new Wishlist(3, 
										  laertes, 
										  new HashSet<Product>(Arrays.asList(jackjones_t_shirt)));
		
		wishlists.add(wishlist1);
		wishlists.add(wishlist2);
		wishlists.add(wishlist3);
	}	
	
	public User getUser(String username) throws UserNotFoundException {
		for(User user : users) {
			if(user.getUsername().equals(username)) return user;
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("%s not found", username)));
	}
	
	public Product getProduct(String productCode) throws ProductNotFoundException {
		for(Product product : products) {
			if(product.getCode().equals(productCode)) return product;
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with code %s not found", productCode)));
	}

	public Order getOrderForUser(String username, String orderNumber) throws OrderNotFoundException {
		for(Order order : orders) {
			if(order.getNumber().equals(orderNumber) && order.getOrderedBy().getUsername().equals(username))
				return order;
		}
		throw new OrderNotFoundException(new ExceptionMessage(String.format("Order %s :: not found for user %s", orderNumber, username)));
	}

	public Set<Order> getAllOrdersForUser(String username) {
		Set<Order> _orders = new HashSet<Order>();
		for(Order order : orders) {
			if(order.getOrderedBy().getUsername().equals(username)) {
				_orders.add(order);
			}
		}
		return _orders;
	}
	
	public Wishlist getWishlistForUser(String username) throws WishlistNotFoundException {
		for(Wishlist wishlist : wishlists) {
			if(wishlist.getWishedBy().getUsername().equals(username)) return wishlist;
		}
		throw new WishlistNotFoundException(new ExceptionMessage(String.format("No wishlist yet for '%s'", username)));
	}
}
