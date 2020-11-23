package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Update {
	
    public static void update() {
    	Scanner sc = new Scanner(System.in);
    	
        String sqlUpdate = "UPDATE clienti "
                + "SET nome = ?, cognome = ? "
                + "WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(sqlUpdate)) {

        	System.out.println("Che ID vorresti modificare?");
        	int id_scelto = sc.nextInt(); sc.nextLine();
        	System.out.println("Come vorresti modificare il nome?");
            String nome_scelto = sc.nextLine();
            System.out.println("Come vorresti modificare il cognome?");
            String cognome_scelto = sc.nextLine();
            stmt.setString(1, nome_scelto);
            stmt.setString(2, cognome_scelto);
            stmt.setInt(3, id_scelto);
            
            int i=stmt.executeUpdate();  
    		System.out.println("****" + i+" record modificato con successo!" + "****");  

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
		JDBC_Update.update();
	}

}
