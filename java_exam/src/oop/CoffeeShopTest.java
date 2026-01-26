package oop;

public class CoffeeShopTest {

	public static void main(String[] args) {
		
		int a = 10;
		String str = a + "";
		String.valueOf(false);
		
		Coffee hotCoffee = new Coffee("아메리카노", 4500);
		Coffee iceCoffee = new Coffee("아이스티", 4000);
		Coffee tea = new Coffee("캐모마일 티",5000);
		CoffeeShopArray starBucks = new CoffeeShopArray(hotCoffee,iceCoffee,tea);
		CoffeeShop starBucks2 = new CoffeeShop(hotCoffee,iceCoffee);
		CoffeeShop starBucks3 = new CoffeeShop();
		
		int price = starBucks.orderCoffee(1, 3);
//		System.out.println(price);
		
		price = starBucks.orderCoffee(0, 10);
//		System.out.println(price);
		
		price = starBucks2.orderCoffee(2);
		System.out.println(price);
	}
}
