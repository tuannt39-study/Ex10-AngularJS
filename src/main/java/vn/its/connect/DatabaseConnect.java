package vn.its.connect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnect {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DatabaseConnect.class.getClassLoader()
						.getResourceAsStream("database.properties");
				prop.load(inputStream);
				final String driver = prop.getProperty("driver");
				final String user_name = prop.getProperty("user_name");
				final String password = prop.getProperty("password");
				final String server_name = prop.getProperty("server_name");
				final String port_number = prop.getProperty("port_number");
				final String sid_number = prop.getProperty("sid_number");
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					final String db_url = "jdbc:oracle:thin:@" + server_name + ":" + port_number + ":" + sid_number;
					conn = DriverManager.getConnection(db_url, user_name, password);
					return conn;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return conn;
		}
	}
}
