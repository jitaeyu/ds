package report.restaurant.restaurantTest;

import report.restaurant.data.ContentData;
import report.restaurant.restaurant.Restaurant;

public class RestaurantTest {
	
	public static void main(String[] args) {
		
		ContentData data = new ContentData();
		Restaurant restaurant = new Restaurant(data);
		Restaurant restaurant2 = new Restaurant(data);
		

		System.err.println("----------restaurant1-------");
		restaurant.showAll();
		restaurant.custurmerOrder(2, 2);
		restaurant.custurmerOrder(2, 2);
		restaurant.showAll();
		

		System.err.println("----------restaurant2-------");
		restaurant2.showAll();
		restaurant2.custurmerOrder(2, 2);
		restaurant2.showAll();
	}

}
