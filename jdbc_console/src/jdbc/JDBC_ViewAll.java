package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_ViewAll {
	
	public static void ViewValues() { 
		String sql = "SELECT * FROM clienti";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("id") + "\t" + 
						rs.getString("nome")  + "\t" +
						rs.getString("cognome"));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
