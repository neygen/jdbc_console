package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Delete {
	
	public static void deleteOne() throws SQLException{
		Scanner sc = new Scanner(System.in);
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt=con.prepareStatement("DELETE FROM clienti WHERE id = ?");  
		System.out.println("Inserire il valore ID da eliminare");
		int id_scelto = sc.nextInt();
		stmt.setInt(1, id_scelto);  
		  
		int i=stmt.executeUpdate();  
		System.out.println("****" + i+" record eliminato con successo! ****\n");  
	}
	
}
