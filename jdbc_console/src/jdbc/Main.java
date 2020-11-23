package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException { 
		String risp;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("*** SCEGLI UNO DELLE SEGUENTI OPZIONI"
					+ "\n" + "[1]. Visualizza tutto"
					+ "\n" + "[2]. Ricerca un cliente"
					+ "\n" + "[3]. Modifica un cliente"
					+ "\n" + "[4]. Aggiungi un cliente"
					+ "\n" + "[5]. Elimina un cliente");
			int nr_scelta = sc.nextInt(); sc.nextLine();
			if(nr_scelta == 1) {
				JDBC_ViewAll.ViewValues();
			} else if (nr_scelta == 2) {
				JDBC_Select.selectOne();
			} else if (nr_scelta == 3) {
				JDBC_Update.update();
			} else if (nr_scelta == 4) {
				JDBC_Add.addOne();
			} else if (nr_scelta == 5) {
				JDBC_Delete.deleteOne();
			} else if (nr_scelta > 5) {
				System.out.println("/!\\ ERRORE!!! /!\\ \nHai superato il numero da te selezionato! Si prega di riprovare");
			}
			System.out.println("Vuoi continuare? (s/n)");
			risp = sc.nextLine();
		}while (risp.equalsIgnoreCase("s"));

	}

}
