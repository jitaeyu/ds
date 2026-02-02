package report.listmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
비행기편위 이름을 입력하면, 좌석 현황을 볼수있습니다.
항공기편의 이름을 입력하세요
0003<-----------입력
0 : X  1 : X  2 : X  3 : X  4 : X  5 : X  6 : X  7 : X  8 : X  
좌석을 예약하려면 번호를 입력하세요 예약가능: O, 예약불가능 : X
2<-----------입력
2번 좌석을 예약하시겠습니까? 하려면 Y/N
Y<-----------입력
항공편 예약을 완료하였습니다
0 : X  1 : X  2 : O  3 : X  4 : X  5 : X  6 : X  7 : X  8 : X  항공권 예약완료 
종료를위해 exit를 입력하세요
exit<-----------입력
종료합니다

@@@@@@@@@@@@@@@@@@@실행시 콘솔입니다@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
*/
public class ListMap {

	public static void Reservation(Map<Integer, List<String>> aircraft) {

		Scanner sc = new Scanner(System.in);
		System.out.println("비행기편위 이름을 입력하면, 좌석 현황을 볼수있습니다.");

		while (true) {
			System.out.println("항공기편의 이름을 입력하세요");
			int getButton = sc.nextInt();
			List<String> aircraftData = aircraft.get(getButton);
			if (!aircraftData.isEmpty()) {
				
				int i = 0;
				for (String data : aircraftData) {
					i++;
					System.out.print(i-1 + " : " + data + "  ");
				}
				while (true) {
					System.out.println("\n좌석을 예약하려면 번호를 입력하세요 예약가능: O, 예약불가능 : X");
					int getbutton2 = sc.nextInt();
					if (aircraftData.get(getbutton2).equals("X")) {
						System.out.println(getbutton2 + "번 좌석을 예약하시겠습니까? 하려면 Y/N");
						if (sc.next().equals("Y")) {
							aircraftData.set(getbutton2, "O");
							System.out.println("항공편 예약을 완료하였습니다");
							int j = 0;
							for (String data : aircraftData) {
								j++;
								System.out.print(j-1 + " : " + data + "  ");
							}
							System.out.println("항공권 예약완료 \n종료를위해 exit를 입력하세요");
							break;
						} else {
							System.out.println("예약을 취소하셨습니다.");
							System.out.println("항공편예약을 다시 시작해주세요");
							break;
						}
					} else {
						System.out.println("예약 불가능한 좌석입니다");
					}
				}

			} else {
				System.out.println("해당 항공편이 없습니다 ");
			}
			if (sc.next().equals("exit")) {
				System.out.println("종료합니다");
				break;
			}

		}
	}

	public static void main(String[] args) {
		Map<Integer, List<String>> aircraft = new HashMap<>();
		aircraft.put(0002, new ArrayList<String>());
		aircraft.put(0003, new ArrayList<String>());
		List<String> data = aircraft.get(0002);
		data.add("O");
		data.add("O");
		data.add("O");
		data.add("O");
		data.add("X");
		data.add("O");
		data.add("O");
		data.add("O");
		data.add("O");
		List<String> data2 = aircraft.get(0003);
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
		data2.add("X");
//		System.out.println(data);
//		System.out.println(aircraft.get(0002));
//		System.out.println(data2);
//		System.out.println(data.get(4));
		Reservation(aircraft);
	}
}
