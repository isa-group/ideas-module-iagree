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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.util.bd.ADADBConnection;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.util.bd.DBConnection;

public class ADASessionManager implements SessionManager{
	
	private static Map<String, Integer> sessions = new HashMap<String, Integer>();
	static{
		sessions.put("", 1);
	}
	
	private DBConnection db;
	
	public ADASessionManager(){
		db = new ADADBConnection();
	}
	
	public ADASessionManager(DBConnection db){
		this.db = db;
	}
	
	//-Singleton?

	public String login(String username, String password) {
		Connection c = db.connect();
		UUID session = null;
		String dbUsername = null;
		String dbPassword = null;
		try {
			//If the user exists, get his username and password
			PreparedStatement ps = c.prepareStatement("SELECT nombre, password FROM usuarios WHERE nombre=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dbUsername = rs.getString(1);
				dbPassword = rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//If username and password are correct
		if(dbUsername != null && dbPassword != null && dbUsername.equals(username) && dbPassword.equals(password)){
			session = UUID.randomUUID();
			UsersManager um = new ADAUsersManager(db);
			int userId = um.getUserIdByName(username);
			sessions.put(session.toString(), new Integer(userId));
		}
		if(session != null){
			return session.toString();
		}else{
			return null;
		}
	}

	public boolean logout(String session) {
		return (sessions.remove(session) != null);
	}

	public int getUserId(String session) {
		Integer userId = sessions.get(session);
		if(userId == null){
			return 0;
		}else{
			return userId.intValue();
		}
	}
}