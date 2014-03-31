/**
 * 	This file is part of ADA.
 *
 *     ADA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ADA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ada.util.bd;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author ajurado
 */

public class ADADBConnection implements DBConnection{
	
	private String username;
	
	private String password;
	
	private String jdbcURL;
	
	private String driverName;
	
	private static final String propertiesFileUrl = "resources/database.properties";
	
	public ADADBConnection(){
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(propertiesFileUrl));
		}catch(Exception e){
			e.printStackTrace();
		}
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		jdbcURL = prop.getProperty("url");
		driverName = prop.getProperty("driverClassName");
	}
	
	public ADADBConnection(String propertiesFile){
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(propertiesFile));
		}catch(Exception e){
			e.printStackTrace();
		}
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		jdbcURL = prop.getProperty("url");
		driverName = prop.getProperty("driverClassName");
	}

	public Connection connect() {
		Connection conn = null;
		try{
			Class.forName(driverName);
			conn = DriverManager.getConnection(jdbcURL, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public void disconnect(Connection conn) {
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
