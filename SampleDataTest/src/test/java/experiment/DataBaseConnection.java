package experiment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DataBaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(rawSuppliersWithBank().get("employeeName"));
	
	        }
	
		 public static Map<String, String > rawSuppliersWithBank() {

			
					
			 PreparedStatement ps;
				ResultSet rs;

				Map<String, String> employee = new HashMap<String, String>();

				String connectionUrl =
		                "jdbc:sqlserver://sqlcertification1748.database.windows.net:1433;"
		                        + "database=sqlpractise;"
		                        + "user=bchand1748;"
		                        + "password=Bivek123$$;"
		                        + "encrypt=true;"
		                        + "trustServerCertificate=false;"
		                        + "loginTimeout=30;";

				try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
					String SQL = "SELECT  * FROM [HR].[Employees]\n" + 
							"where empid=9" ;
					ps = con.prepareStatement(SQL);
					rs = ps.executeQuery();

					while (rs.next()) {

						employee.put("employeeName", rs.getString(4));
						
					}

					con.close();

				}
				// Handle any errors that may have occurred.
				catch (SQLException e) {
					e.printStackTrace();

				}

				return employee;

			}
	
	
	
	
	}


