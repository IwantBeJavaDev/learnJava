package pl.michal.learn.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	
	public  Connection getConection(Properties prop) {
		Connection con = null;
		try {
			Class.forName(prop.getProperty("DB_DRIVER_CLASS"));

			con = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("DB_USERNAME"),
					prop.getProperty("DB_PASSWORD"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	
	public Properties getProperties(String name) throws IOException{
		Properties prop = new Properties();
		InputStream inputStream = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			inputStream = loader.getResourceAsStream(name);
			prop.load(inputStream);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		
		return prop;
	}
}
