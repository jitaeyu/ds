package oop;

public class Restaurant {

	public static void main(String[] args) {

		
		Cooker cook = new Cooker();

		boolean cookState = cook.materialTrimming(1);
		cook.cooking(cookState);
	}
}