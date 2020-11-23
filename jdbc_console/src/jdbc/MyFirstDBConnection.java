package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyFirstDBConnection {

	private static String url1 = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";
	private static String user = "root";
	private static String pwd = "admin";
	
	public static void main(String[] args) throws InterruptedException, SQLException {

		Connection connection1 = openConnectDB(url1, user, pwd);
		System.out.println(connection1);
		closeConnectDB(connection1);

	}

	private static void closeConnectDB(Connection connection) throws SQLException {

		if (connection != null)
			try {
				connection.close();
				System.out.println("*** CONNESSIONE CHIUSA CORRETTAMENTE A " + connection.getCatalog().toUpperCase() + " ***");
			} catch (SQLException e) {
				System.out.println("Si sono verificati dei problemi durante la chiusura della connessione al DB " + connection.getCatalog() + ": " + e.getMessage());
			}
	}

	private static Connection openConnectDB(String url, String user, String pwd) throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("*** CONNESSIONE AVVENUTA CORRETTAMENTE A " + connection.getCatalog().toUpperCase() + " ***");
			return connection;
		} catch (SQLException e) {
			System.out.println("Si sono verificati dei problemi durante l'apertura della connessione al DB " + connection.getCatalog() + ": " + e.getMessage());
			return connection;
		}
	}
}
