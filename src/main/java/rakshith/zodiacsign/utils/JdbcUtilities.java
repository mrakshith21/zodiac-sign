package rakshith.zodiacsign.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilities 
{ 
      public static Connection getConnection(String dbName) 
      {  
          Connection connection = null;  

          String driver = "org.gjt.mm.mysql.Driver"; 
          String url = "jdbc:mysql://localhost:3306/" + dbName; 
          String username = "root"; 
          String password = ""; 

          try 
          { 
               Class.forName(driver); 
               connection = DriverManager.getConnection(url,username,password); 
          } 
          catch(ClassNotFoundException cnfe) 
          { 
               System.out.println("JdbcUtilities.getConnection : " + cnfe); 
          } 
          catch(SQLException sqle) 
          { 
               System.out.println("JdbcUtilities.getConnection : " + sqle); 
          } 

          return connection; 
      } 

      public static void closeConnection(Connection connection) 
      { 
          try 
         { 
               if ( connection != null ) connection.close(); 
          } 
          catch (SQLException sqle) 
          { 
              System.out.println("JdbcUtilities.closeConnection() : " + sqle); 
          } 
      } 

      public static void closeStatement(Statement statement) 
      { 
          try 
          { 
              if ( statement != null ) statement.close(); 
          } 
          catch (SQLException sqle) 
          { 
              System.out.println("JdbcUtilities.closeStatement() : " + sqle); 
          } 
      } 
 }  