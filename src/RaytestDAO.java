import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class RaytestDAO implements IRaytestDAO{
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void insert(Raytest raytest) {
        String name = raytest.getFirstname();
        String phone = raytest.getPhone();
        
        Connection conn = null;
        Statement stmt = null;
         try {
             conn = dataSource.getConnection();
             conn.setAutoCommit(false);
             stmt = conn.createStatement();
             stmt.execute("INSERT INTO raytest(firstname,phone) VALUES('" + name + "','" + phone + "')");
             conn.commit();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         finally {
             
        	 if(stmt != null) {
                 try {
                     stmt.close();
                 }   
                 catch(SQLException e) {
                     e.printStackTrace();
                 }
             }
             if(conn != null) {
                 try {
                     conn.close();
                 }
                 catch(SQLException e) {
                     e.printStackTrace();
                 }
             }
         } 
     }

     public Raytest find() {
    	 Connection conn = null;
         Statement stmt = null;
         
          try {
              conn = dataSource.getConnection();
              stmt = conn.createStatement();
              
              ResultSet result = stmt.executeQuery("SELECT phone, firstname FROM raytest");
              if(result.next()) {
                  String phone = result.getString(1);
                  String firstname = result.getString(2);
                  // 封裝為 User 物件
                  Raytest raytest = new Raytest();
                  raytest.setFirstname(firstname);
                  raytest.setPhone(phone);
                  return raytest;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          finally {
              if(stmt != null) {
                  try {
                      stmt.close();
                  }   
                  catch(SQLException e) {
                      e.printStackTrace();
                  }
              }
              if(conn != null) {
                  try {
                      conn.close();
                  }
                  catch(SQLException e) {
                      e.printStackTrace();
                  }
              }
          }    
          
          return null;
     }

     public void update(Raytest raytest) {
         ;
     }

     public void delete(Raytest raytest) {
    	 ;
     }
}
