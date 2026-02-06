package fp.basic.stream.advanced;

import java.util.List;
import java.util.Optional;

public class CityTest {

	public static void main(String[] args) {
		List<City> cites = City.loadCityData();
//		cites.forEach(System.out::println);
		
		//stateId가 3907번인 City의 CountryName을 출력
		for(City city: cites) {
			if(city.getStateId()==3907) {
//				System.out.println(city.getCountryName());
			}
		}
		// ==> 이 코드를 스트림으로 구현하기
		cites
				.stream()
				.filter(city ->city.getStateId()==3907)
				.map(city -> city.getCountryName())//Stream<String>
				.forEach(countryName->System.out.println("stream01"+countryName));
		
		//countryName이 south Korea인 City의 _native를 출력
		cites
				.stream()
				.filter(city -> city.getCountryName().equals("South Korea"))
				.forEach(city ->System.out.print(city.get_native()));
		
		//countryName이 south Korea이면서 _native의 길이가 3이상인 city의 _native를 출력
		System.out.println();
		cites
				.stream()
				.filter(city -> city.getCountryName().equals("South Korea")&&city.get_native().length()>=3)
				.forEach(city -> System.out.print("ttts"+city.get_native()));
		
		System.out.println("=======");
		cites
				.stream()
				.filter(city -> city.getCountryName().equals("South Korea")&&city.get_native().length()>=3)
				.skip(3)
				.limit(3)
				.forEach(city -> System.out.print(""+city.get_native()));
		
		
		//_native의 값이 한글로만 이루어진 값 중에서 _native의 길이가 4글자 이상인 것의 
		//name을 중복없이 조회한다.
		
		//ex ) kor
		String name = "유지태";
//		System.out.println(name.matches("^[가-힣]{4,}+$")+" :한글임");
		
		System.out.println("=======");		System.out.println("=======");
		
		cites
				.stream()
				.filter(city->city.get_native().matches("^[가-힣]{4,}$"))
				.map(City::getName)
				.distinct()
				.map(String::length)
				.distinct()
				.forEach(System.out::println);
		
		
		
		
		
		//애월읍의 stateName을 출력한다.
		Optional<City> found = cites.stream()//Stream<City>
				.filter(city -> city.getName().equals("Gaigeturi"))//Stream<City>
				.findFirst();//Optional<City>
		
		System.out.println(found);

		
		Optional<City> found2 = cites.stream()//Stream<City>
				.filter(city -> city.getName().equals("fdkldsgjasmldlfdmfpaskl"))//Stream<City>
				.findFirst();//Optional<City>
		
		System.out.println(found2);
		City city =found2.orElse(null);
		if(city != null) {
			System.out.println(city.getStateName());
		}
		if(found2.isPresent()) {
			System.out.println(found2.get().getStateName());
		}
		
		//Optional을 사용하는케이스
		City city2 =found2.orElse(new City(""));
		System.out.println(city2.getStateName());
		
		
		cites.stream()
				.peek(_city ->System.out.println(_city.getCountryCode()))
				.filter(_city -> true)
				.map(_city -> _city.get_native());
		System.out.println("-------------------");
	}
}
