package com.ktdsuniversity.edu.app.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	
	private List<Contact> contactList;
	
	public ContactManager() {
		this.contactList=new ArrayList<>();
	}
	//1.contactList에 Contact인스턴스를 추가하는기능
	public void add() {
		Contact contact = new Contact();
		Company company = null;
		Scanner sc = new Scanner(System.in);
		String companyName = null;
		String job = null;
		String address = null;
		
		while(true) {
			System.out.println("연락처의 이름을 입력해주세요");
			contact.setName(sc.next());
			System.out.println("nickname입력해주세요");
			contact.setNickname(sc.next());
			System.out.println("email 입력해주세요");
			contact.setEmail(sc.next());
			System.out.println("firstName(이름)입력해주세요");
			contact.setFirstName(sc.next());
			System.out.println("lastName(성)입력해주세요");
			contact.setLastName(sc.next());
			List<Phone> phone=addPhone();//phone add
			System.out.println("companyName 회사이름입력");
			companyName=sc.next();
			System.out.println("job(직급입력)");
			job=sc.next();
			System.out.println("address 회사주소입력");
			address=sc.next();
			company = new Company(companyName, job, address);
			System.out.println("memo 한줄메모입력");
			contact.setMemo(sc.next());
			contact.setCompany(company);
			contact.setPhones(phone);
			contactList.add(contact);
			break;
		}
	}
	
	public List<Phone> addPhone() {
		Scanner sc = new Scanner(System.in);
		List<Phone> phone = new ArrayList<>();
		String phoneType =null;
		System.out.println("addphone");
		
		while(true) {
			System.out.println("사용목적을 입력해주세요 PERSONAL  HOME  COMPANY");
			phoneType=sc.next();
			if(phoneType.equals("PERSONAL")) {
				System.out.println("phoneNumber를 입력하세요");
				phone.add(new Phone(Phone.Type.PERSONAL, sc.next()));
				return phone;
			}if (phoneType.equals("HOME")) {
				System.out.println("phoneNumber를 입력하세요");
				phone.add(new Phone(Phone.Type.HOME, sc.next()));
				return phone;
			}if(phoneType.equals("COMPANY")) {
				System.out.println("phoneNumber를 입력하세요");
				phone.add(new Phone(Phone.Type.COMPANY, sc.next()));
				return phone;
			}
			System.out.println("번호를 추가하시려면1번 아니면 2번을 눌러주세요");
			if(Integer.parseInt(phoneType)==1) {
			}else if(Integer.parseInt(phoneType)==2) {
				return phone;
			}
			return phone;
		}
	}
	
	public void searchAll() {
		System.out.println("searchall");
		//2. contactList의 모든 연락처 정보를 출력하는 기능
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(contactList.get(i));
		}
		
//		for (int i = 0; i < contactList.size(); i++) {
//			System.out.println("name: "+contactList.get(i).getName());
//			System.out.println("nickname: "+contactList.get(i).getNickname());
//			System.out.println("email: "+contactList.get(i).getEmail());
//			System.out.println("firstName: "+contactList.get(i).getFirstName());
//			System.out.println("lastName: "+contactList.get(i).getLastName());
//			for (int j = 0; j < contactList.get(i).getPhones().size(); j++) {
//				System.out.println("phoneType: "+contactList.get(i).getPhones().get(j).getPhoneType());
//				System.out.println("phoneNumber: "+contactList.get(i).getPhones().get(j).getPhoneNumber());
//			}
//			System.out.println("companyName: "+contactList.get(i).getCompany().getCompanyName());
//			System.out.println("job: "+contactList.get(i).getCompany().getJob());
//			System.out.println("address: "+contactList.get(i).getCompany().getAddress());
//		}
	}
	//3. contactList에서 전화번호 검색 결과 출력하는 기능
	//ex) 010을 파라미터로 전달하면 전화번호에 010이 포함된 연락처의 모든 정보를 출력
	public void searchListNumber(List<Integer> list) {
		System.out.println("searchall");
		//2. contactList의 모든 연락처 정보를 출력하는 기능
		//1,3,5
		for (Integer integer : list) {
			System.out.println(contactList.get(integer));
		}
		
	}
	
	//4. contactList에서 이름 검색결과 출력하는기능
	//ex) "김"을 파라미터로 전달하면 name,firstName,lastName,companyName(Company)
//			ex) "김"일 포함된 연락처의 모든정보 출력
	public List<Integer> searchName(String name){
		List<Integer> list= new ArrayList<Integer>();
		for (int i = 0; i < contactList.size(); i++) {
			for (int j = 0; j < contactList.get(i).getPhones().size(); j++) {
				if(contactList.get(i).getName().contains(name)) {
					list.add(i);
					continue;
				}
			}
		}
		return list;
	}
	
	//5. contactLsit 에서 이메일 검색 결과 출력하는 기능
//		ex) "@abc.com"을 파라미터로 전달하면 이메일에 "@abc.com"이 포함된 연락처의 모든 정보를 출력
	public List<Integer> searchEmail(String email){
		List<Integer> list= new ArrayList<Integer>();
		for (int i = 0; i < contactList.size(); i++) {
			for (int j = 0; j < contactList.get(i).getPhones().size(); j++) {
				if(contactList.get(i).getEmail().contains(email)) {
					list.add(i);
					continue;
				}
			}
		}
		return list;
	}
	public List<Integer> searchPhoneNumber(String phoneNumber){
		List<Integer> list= new ArrayList<Integer>();
		for (int i = 0; i < contactList.size(); i++) {
			for (int j = 0; j < contactList.get(i).getPhones().size(); j++) {
				if(contactList.get(i).getPhones().get(j).getPhoneNumber().contains(phoneNumber)) {
					list.add(i);
					continue;
				}
			}
		}
		return list;
	}
	
//	7. 연락처 정보 삭제기능.
//		ex) 다양한 검색의 결과 중 하나를 선택해 contactList에서 제거하는 기능.
	public void dell(List<Integer> index) {
		for (Integer integer : index) {
//			if (index >= 0 && index < this.contactList.size()) {
				this.contactList.remove(integer);
		}
	}
	
	
	
//	6. 연락처 정보 수정기능 
//		ex) 다양한 검색의 결과중 하나를 선택해 연락처 정보를 수정할수있는 기능
//			이름을 변경,전화번호 추가 , 전화번호 수정, 회사정보수정...... 등등 수정기능
	public void changeValue(List<Integer> index) {
		Scanner sc = new Scanner(System.in);
		for (Integer integer : index) {
			System.out.println("email 변경");
			contactList.get(integer).setEmail(sc.next());
			System.out.println("변경되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		ContactManager cm = new ContactManager();
		Scanner sc = new Scanner(System.in);
		int a =0;
		System.out.println(a);
		List<Integer> result = new ArrayList<>();
		
		while(true) {
			System.out.println("주소록입니다");
			System.out.println("1: 입력  2:조회  3: 전화번호검색 4: 이름검색 5: 이메일검색 6:수정 원하시는 번호를 입력하세요");
			if(sc.nextInt()==1) {
				cm.add();
			}else if(sc.nextInt()==2) {
				cm.searchAll();
			}else if(sc.nextInt()==3) {
				System.out.println("찾고싶은 번호를 입력해주세요");
				result=cm.searchPhoneNumber(sc.next());
				cm.searchListNumber(result);
				System.out.println("지우시겠습니까?");
				if(sc.next().equalsIgnoreCase("Y")) {
					cm.dell(result);
				}else if(sc.next().equalsIgnoreCase("N")) {
					continue;
				}
			}else if(sc.nextInt()==4) {
				System.out.println("찾고싶은 이름를 입력해주세요");
				result=cm.searchName(sc.next());
				cm.searchListNumber(result);
				System.out.println("지우시겠습니까?");
				if(sc.next().equalsIgnoreCase("Y")) {
					cm.dell(result);
				}else if(sc.next().equalsIgnoreCase("N")) {
					continue;
				}
			}else if(sc.nextInt()==5) {
				System.out.println("찾고싶은 이메일를 입력해주세요");
				result=cm.searchEmail(sc.next());
				cm.searchListNumber(result);
				System.out.println("지우시겠습니까?");
				if(sc.next().equalsIgnoreCase("Y")) {
					cm.dell(result);
				}else if(sc.next().equalsIgnoreCase("N")) {
					continue;
				}else if(sc.next().equalsIgnoreCase("C")) {
					cm.changeValue(result);
				}
			}else if(sc.nextInt()==6) {
				
				
			}else {
				System.out.println("잘못된입력입니다.");
			}
			
			if(sc.next().equals("exit")) {
				break;
			}
		}
	}
}
