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

import es.us.isa.ideas.adaintegration.adaadhoc.ada.util.bd.ADADBConnection;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.util.bd.DBConnection;

public class ADAUsersManager implements UsersManager{
	
	private DBConnection db;
	
	public ADAUsersManager(){
		db = new ADADBConnection();
	}
	
	public ADAUsersManager(DBConnection db){
		this.db = db;
	}

	public int addUser(String name, String password, String company, String email) {
		int userId = 0;
		if (name != null && password != null && !name.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
			//No puede haber dos usuarios con el mismo nombre
			Connection c = db.connect();
			String checkIfExists = "SELECT idUsuario FROM usuarios WHERE nombre=?";
			String insertUser = "INSERT INTO usuarios VALUES (null, ?, ?, ?, ?)"; //1=nombre, 2=password, 3=organizacion, 4=email
			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = c.prepareStatement(checkIfExists);
				ps.setString(1, name);
				rs = ps.executeQuery();
				if (!rs.next()) {
					//Add user
					ps = c.prepareStatement(insertUser,
							PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(1, name);
					ps.setString(2, password);
					ps.setString(3, company);
					ps.setString(4, email);
					ps.executeUpdate();
					//Get inserted user identifier
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						userId = rs.getInt(1);
					}
				} else {
					System.err.println("Username "+"'"+name+"'"+" already exists");
				}
				rs.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			db.disconnect(c);
		}else{
			System.err.println("Username and password cannot be empty");
		}
		return userId;
	}

	public boolean deleteUser(int id, String session) {
		boolean deleted = false;
		SessionManager sm = new ADASessionManager();
		if(id > 0){
			if(sm.getUserId(session) == id){
				//delete
				Connection c = db.connect();
				String deleteUser = "DELETE FROM usuarios WHERE idUsuario=?";
				try{
					PreparedStatement ps = c.prepareStatement(deleteUser);
					ps.setInt(1, id);
					ps.executeUpdate();
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				db.disconnect(c);
				deleted = true;
			}else{
				System.err.println("User must be logged in to be deleted");
			}
		}else{
			System.err.println("Invalid user identifier");
		}
		return deleted;
	}

	public boolean updateUser(int id, String name, String password, String company, String email, String session) {
		//Hay que comprobar que el usuario existe y tiene sesion abierta
		boolean updated = false;
		SessionManager sm = new ADASessionManager();
		if(id > 0){
			if(sm.getUserId(session) == id){
				//update
				Connection c = db.connect();
				String updateUser = "UPDATE usuarios SET nombre=?, password=?, organizacion=?, email=? WHERE idUsuario=?";
				try{
					PreparedStatement ps = c.prepareStatement(updateUser);
					ps.setString(1, name);
					ps.setString(2, password);
					ps.setString(3, company);
					ps.setString(4, email);
					ps.setInt(5, id);
					ps.executeUpdate();
					ps.close();
					updated = true;
				}catch (Exception e){
					e.printStackTrace();
				}
				db.disconnect(c);
			}else{
				System.err.println("User must be logged in to be updated");
			}
		}else{
			System.err.println("Invalid user identifier");
		}
		return updated;
	}

	public int getUserIdByName(String username) {
		int userId = 0;
		Connection c = db.connect();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT idUsuario FROM usuarios WHERE nombre=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				userId = rs.getInt(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.disconnect(c);
		return userId;
	}
}
