package report.restaurant.restaurantTest;

import report.restaurant.data.ContentData;
import report.restaurant.exceptions.DrunkenException;
import report.restaurant.exceptions.FullException;
import report.restaurant.exceptions.MoneyException;
import report.restaurant.exceptions.StockException;
import report.restaurant.restaurant.Restaurant;

public class RestaurantTest {
	
	public static void main(String[] args) {
		
		ContentData data = new ContentData();
		Restaurant restaurant = new Restaurant(data);
		Restaurant restaurant2 = new Restaurant(data);
		

		System.err.println("----------restaurant1-------");

		

		System.err.println("----------restaurant2-------");

		
		try {
			restaurant.showAll();
			restaurant.custurmerOrder(2, 1);
			restaurant.custurmerOrder(2, 2);

			restaurant.custurmerOrder(2, 2);
			restaurant.showAll();
			
			restaurant2.showAll();
			restaurant2.custurmerOrder(2, 2);
			restaurant2.showAll();
			
		} catch (DrunkenException de) {
			System.out.println(de.getMessage());
		}catch (FullException fe) {
			System.out.println(fe.getMessage());
		}catch (MoneyException me) {
			System.out.println(me.getMessage());
		}catch (StockException se) {
			System.out.println(se.getMessage());
		}
		
	}

}
