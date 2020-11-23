package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_Add {

	public static void addOne() {

		try{  
			Scanner sc = new Scanner(System.in);
			Connection con = DBConnection.getConnection();		

			PreparedStatement stmt = con.prepareStatement("INSERT INTO clienti(nome, cognome) VALUES(?,?)");  
			System.out.println("Inserire nome del cliente");
			String nome_scelto = sc.nextLine();
			stmt.setString(1, nome_scelto);
			System.out.println("Inserire cognome del cliente");
			String cognome_scelto = sc.nextLine();
			stmt.setString(2, cognome_scelto);

			int i=stmt.executeUpdate();  
			System.out.println("****" + i+" record inserito con successo! ****\n");  

			con.close();  

		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}


