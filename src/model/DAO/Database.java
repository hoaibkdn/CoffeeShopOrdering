package model.DAO;

import java.sql.*;

/**
 * @author Quang Ngo TP
 *
 */
public class Database {
	Connection connection = null;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coffeeshopordering?useUnicode=true&characterEncoding=utf-8&SSL=false",
					"root", "");
		} catch (Exception e) {
			System.err.println("Error while connecting database: " + e.getMessage());
		}
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
