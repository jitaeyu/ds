package kakao;

import java.time.LocalDate;

public class Friend {

	private String name;
	private LocalDate birthdate;
	
	public Friend(String name, String birthday) {
		this.name=name;
		this.birthdate=LocalDate.parse(birthday);
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "이름: " + this.name + ", 생일:" + this.birthdate + "]";
	}
	
	
}
