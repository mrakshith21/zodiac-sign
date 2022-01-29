package rakshith.zodiacsign.dao;

import rakshith.zodiacsign.exceptions.ZodiacNotFoundException;

public interface ZodiacDao {
	
	public String getZodiac(String date) throws ZodiacNotFoundException;
	
}
