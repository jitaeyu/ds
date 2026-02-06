package fp.basic.stream.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fp.basic.stream.object.Dish;
import fp.basic.stream.object.DishList;
import fp.basic.stream.object.DishType;
import fp.basic.stream.object.FoodType;

public class StreamBasic {

	

	public void printDishUseFor() {
		System.out.println("전체 요리목록 -for-근데이제 칼로리가 500 미만인&&FOODTYPE이 MEAT인&&DishType이 fish인");
		List<Dish> dishList = DishList.makeDishList();
		for(Dish dish: dishList) {
			if(dish.getCalories()<=500 && dish.getFoodType() ==FoodType.MEAT && dish.getDishType()==DishType.FISH) {
				System.out.println(dish);
			}
			System.out.println(dish);
		}
	}
	
	public void printDishUseStream() {
		System.out.println("전체요리목록 - List.forEach-- 근데이제 칼로리가 500미만인..&&FOODTYPE이 MEAT인");
		List<Dish> dishList = DishList.makeDishList();
//		dishList.forEach(dish ->System.out.print(dish));
//		dishList.forEach(System.out::println);//위에랑같은거임!
		dishList.forEach(dish->{
			if(dish.getCalories()<=500 &&dish.getFoodType() ==FoodType.MEAT&& dish.getDishType()==DishType.FISH) {
				System.out.println("A"+dish);
			}
		});
		
		System.out.println("전체요리목록 -stream-");
		//Stream을 사용할수있는 대상 -> List, Set
		dishList//List<Dish> stream을 호출하는 인스턴스(List)의 제네릭이온다.(dish) 복사해서 사용함으로 내용은같지만 다른메모리를 사용한다
					.stream()//stream<Dish>
					.peek(dish ->{
						System.out.println("첫번째 필터를 실행하기 이전의 인스턴스값");
						System.out.println("1."+dish.getName());
						System.out.println("1."+dish.getCalories());
						System.out.println("1."+dish.getFoodType());
						System.out.println("1."+dish.getDishType());
					})//stream<Dish>(현재 반복중인 인스턴스를 확인 - 디버깅 용도)
					.filter(dish->dish.getCalories()<=500)//를 호출한 인스턴스의 제네릭
					.peek(dish ->{
						System.out.println("두번째 필터를 실행하기 이전의 인스턴스값");
						System.out.println("2."+dish.getName());
						System.out.println("2."+dish.getCalories());
						System.out.println("2."+dish.getFoodType());
						System.out.println("2."+dish.getDishType());
					})
					.filter(dish->dish.getFoodType() ==FoodType.MEAT)//filter는 조건을 여러개 걸수있다 원하는만큼 길면짤라쓰자
					.peek(dish ->{
						System.out.println("세번째 필터를 실행하기 이전의 인스턴스값");
						System.out.println("3."+dish.getName());
						System.out.println("3."+dish.getCalories());
						System.out.println("3."+dish.getFoodType());
						System.out.println("3."+dish.getDishType());
					})
					.filter(dish->dish.getDishType()==DishType.FISH)//Stream<Dish>
					.peek(dish ->{
						System.out.println("네번째 필터를 실행하기 이전의 인스턴스값");
						System.out.println("4."+dish.getName());
						System.out.println("4."+dish.getCalories());
						System.out.println("4."+dish.getFoodType());
						System.out.println("4."+dish.getDishType());
					})
					.forEach(dish->System.out.println("s--"+dish));
		
	}
	
	public void printEvenNumbers() {
		List<Integer> numbers = Arrays.asList(1,23,5,4342,4544,2,342,54,32,8,32,213,5,12);
		
		
		//1. numbers에 있는 값을 전부 2를 곱해서 짝수로 만들어 출력한다
		numbers
					.stream()
					.map(num -> num*2)
					.forEach(System.out::println);
		//2. numbers에 있는 값에서 중복된 숫자는 모두 제거하고 나머지 숫자에 전부 2를 곱해서 짝수로 만들어 출력한다.
	}
	
	public String makeString() {
		//모든 vegetables 메뉴의 이름들을 "," 로 연결한 문자열을 반환한다.
		List<Dish> dishList = DishList.makeDishList();
		String dishesName = dishList.stream()
													.filter(dish->dish.getFoodType()==FoodType.VEGETABLES)
													.map(Dish::getName)
													.collect(Collectors.joining(", "));
		
		
		return dishesName;
	}
	
	public List<Dish> getHealthyDishes(){
		//변경불가능한 리스트(add불가)
		List<Dish> dishes = DishList.makeDishList();
		List<Dish> result = dishes.stream()
												.filter(dish -> dish.getCalories() <400)
												.toList();
		
		return result;
	}
	
	
	public List<Dish> getHealthyDishes2(){
		//변경불가능한 리스트(add불가)
		List<Dish> dishes = DishList.makeDishList();
		
		List<Dish> result = dishes.stream()
												.filter(dish -> dish.getCalories() <400)
												.collect(Collectors.toList());
		
		return result;
	}

	
	public static void main(String[] args) {
		StreamBasic basic = new StreamBasic();
//		basic.printDishUseFor();
//		basic.printDishUseStream();
//		basic.printEvenNumbers();
		String dishesName = basic.makeString();
//		System.out.println(dishesName);
		List<Dish> result = basic.getHealthyDishes();
		System.out.println(result);
//		result.add(new Dish("곱창",FoodType.MEAT,3000,DishType.MEAT));
//		System.out.println(result);
		
		
	}
}
