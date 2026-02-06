package fp.basic.stream.advanced;

import java.io.File;
import java.nio.file.Files;
import java.util.List;


public class City {
	private int id;//1
	private String name;//2
	private int stateId;//3
	private String stateCode;//4
	private String stateName;//5
	private int countryId;//6
	private String countryCode;//7
	private String countryName;//8
	private String latitude;//9
	private String longitude;//10
	private String _native;//11
	private String type;//12
	private int level;//13
	private int parentId;//14
	private int population;//15
	private String timezone;//16
	private String wikiDataId;//17
	
	
	public static List<City> loadCityData(){
		String path ="C:\\dev_programs\\java-stream-countries-states-cities-database-master\\csv\\cities.csv";
		try {
			return Files.lines(new File(path).toPath())
					.skip(1)//Stream<String>
					.parallel()//병렬로처리한다.!!
					.map(City::new)//String<City>
					.toList();//List<City>
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public City(String cityLineString) {
		//CSV : Comma Seqarate Value
		String[] values= cityLineString.split(",");
		this.id=StringUtil.toInt(ArrayUtil.getValue(values, 0));
		this.name=ArrayUtil.getValue(values, 1);
		this.stateId=StringUtil.toInt(ArrayUtil.getValue(values, 2));
		this.stateCode=ArrayUtil.getValue(values, 3);
		this.stateName=ArrayUtil.getValue(values, 4);
		this.countryId=StringUtil.toInt(ArrayUtil.getValue(values, 5));
		this.countryCode=ArrayUtil.getValue(values, 6);
		this.countryName=ArrayUtil.getValue(values, 7);
		this.latitude=ArrayUtil.getValue(values, 8);
		this.longitude=ArrayUtil.getValue(values, 9);
		this._native=ArrayUtil.getValue(values, 10);
		this.type=ArrayUtil.getValue(values, 11);
		this.level=StringUtil.toInt(ArrayUtil.getValue(values, 12));
		this.parentId=StringUtil.toInt(ArrayUtil.getValue(values, 13));
		this.population=StringUtil.toInt(ArrayUtil.getValue(values, 14));
		this.timezone=ArrayUtil.getValue(values, 15);
		this.wikiDataId=ArrayUtil.getValue(values, 16);
		
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getStateId() {
		return this.stateId;
	}
	public String getStateCode() {
		return this.stateCode;
	}
	public String getStateName() {
		return this.stateName;
	}
	public int getCountryId() {
		return this.countryId;
	}
	public String getCountryCode() {
		return this.countryCode;
	}
	public String getCountryName() {
		return this.countryName;
	}
	public String getLatitude() {
		return this.latitude;
	}
	public String getLongitude() {
		return this.longitude;
	}
	public String get_native() {
		return this._native;
	}
	public String getType() {
		return this.type;
	}
	public int getLevel() {
		return this.level;
	}
	public int getParentId() {
		return this.parentId;
	}
	public int getPopulation() {
		return this.population;
	}
	public String getTimezone() {
		return this.timezone;
	}
	public String getWikiDataId() {
		return this.wikiDataId;
	}

	
}
