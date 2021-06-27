package ultilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static FakerConfig getData() {
		return new FakerConfig();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}

}
