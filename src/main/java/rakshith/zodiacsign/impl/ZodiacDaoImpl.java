package rakshith.zodiacsign.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rakshith.zodiacsign.dao.ZodiacDao;
import rakshith.zodiacsign.exceptions.ZodiacNotFoundException;
import rakshith.zodiacsign.utils.JdbcUtilities;

public class ZodiacDaoImpl implements ZodiacDao {
	
	public String getZodiac(String date) throws ZodiacNotFoundException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        String zodiac = null;
        String sql = "select symbol from zodiac where ? between start_date and end_date";
        
        try {
			connection = JdbcUtilities.getConnection("zodiac_signs");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, date);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
            	zodiac = resultSet.getString("symbol");
            }
            else {
            	throw new ZodiacNotFoundException();
            }
            
            JdbcUtilities.closeStatement(preparedStatement);
            JdbcUtilities.closeConnection(connection);
            
		}  catch (SQLException e) {
			e.printStackTrace();
		}
        
        return zodiac;
	}
}
