package oop;

public class Cooker {
	boolean inventoryState;
		
	public boolean materialTrimming(int minimumInventory) {
		String inventory;
		if(minimumInventory<1) {
			inventoryState=false;
			inventory="재료를 손질한다";
		}else {
			inventoryState=true;
			inventory="여유가 있으니 요리를하러간다";
		}
		System.out.println(inventory);
		return inventoryState;
	}
	
	public void cooking(boolean inventoryState) {
		if(inventoryState==true) {
			System.out.println("음식을 만들었습니다.");
		}else {
			System.out.println("재료 재고를 먼저 확인해주세요");
		}
	}
	
}
