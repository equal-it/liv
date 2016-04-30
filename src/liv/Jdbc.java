package liv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	static String connectURL = "jdbc:mysql://SERVERADESS/ABC";  //verbindung + adresse server
	static String user = "efg";									//angabe username
	static String pw ="hij";									//angabe passwort
	static Connection conn;
	
	public static void main (String Args[]){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}	catch (Exception e) {
			System.err.println("Treiber konnte nicht geladen werden!");
			System.err.println(e);
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Treiber wurde geladen!");
		try {
			conn = DriverManager.getConnection(connectURL, user, pw);
			System.out.println("Verbindung aufgebaut!");
			Statement stmt = conn.createStatement();			//datenabfrage aufbereiten
			String query = "select BLA, BLUB from BLUERB";		//datenabfrage ausführen
			ResultSet rs = stmt.executeQuery(query);			//ergebismenge verarbeiten
			System.out.println("BLA\t\tBLUB");
			System.out.println("------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString("BLA") + "\t" + rs.getString("BLUB"));
			}
			//resultset und statement schließen
				rs.close();
				stmt.close();
		}	catch (SQLException e) {
			System.err.println("keine Verbindung möglich!");
			e.printStackTrace();
			System.err.println("SQLException: " + e.getMessage());
			System.err.println("SQLState: " + e.getSQLState());
			System.err.println("VendorError: " + e.getErrorCode());
			System.exit(-1);			
		}	finally {											//verbindung schließen
			if (conn !=null) {
				try{
					conn.close();					
				}	catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
