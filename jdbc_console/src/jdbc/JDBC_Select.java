package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBC_Select {

	public static void selectOne() {
		
		Scanner sc = new Scanner(System.in);
		ResultSet rs;
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM clienti WHERE id = ?");
			System.out.println("Indicare l'ID del cliente:");
			int id_scelto = sc.nextInt();
			stmt.setInt(1, id_scelto);
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println( rs.getInt("id") + "\t" +
									rs.getString("nome")+ "\t" +
									rs.getString("cognome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
