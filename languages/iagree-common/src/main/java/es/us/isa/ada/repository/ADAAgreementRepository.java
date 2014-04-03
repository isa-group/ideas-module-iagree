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

package es.us.isa.ada.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.ada.users.ADASessionManager;
import es.us.isa.ada.users.SessionManager;
import es.us.isa.ada.util.bd.ADADBConnection;
import es.us.isa.ada.util.bd.DBConnection;

/**
 * @author ajurado
 */

public class ADAAgreementRepository implements AgreementRepository{
	
	private DBConnection db;
	
	private SessionManager sm;
	
	private static final String PUBLIC_SESSION = "";
	
	public ADAAgreementRepository(){
		db = new ADADBConnection();
		sm = new ADASessionManager(db);
	}
	
	public ADAAgreementRepository(DBConnection db){
		this.db = db;
		sm = new ADASessionManager(db);
	}

//	public int storeAgreement(String agreementName, String agreementContent) throws SQLException{
//		Connection connection = db.connect();
//		int id = 0;
//		String insertDocQuery = "INSERT INTO documentos VALUES (null, ?, ?, ?)"; //1=nombre, 2=contenido, 3=usuario
//		PreparedStatement ps = connection.prepareStatement(insertDocQuery, PreparedStatement.RETURN_GENERATED_KEYS);
//		//Set parameters
//		ps.setString(1, agreementName);
//		ps.setString(2, agreementContent);
//		ps.setInt(3, PUBLIC_USER);
//		//Insert a new agreement
//		ps.executeUpdate();
//		//Get the new agreement id
//		ResultSet rs = ps.getGeneratedKeys();
//		if(rs.next()){
//			id = rs.getInt(1);
//		}
//		//Close resources
//		rs.close();
//		ps.close();
//		connection.close();
//
//		return id;
//	}

	public int storeAgreement(String agreementName, String agreementContent, String session) throws SQLException{
		Connection connection = db.connect();
		int userId = sm.getUserId(session);
		int idAg = 0;
		String addAgForUser = "INSERT INTO documentos VALUES (null, ?, ?, ?)"; //1=nombre, 2=contenido, 3=usuario

		if (userId != 0) {
			if (!existsAgWithSameNameForUser(connection, agreementName, userId)) {
				/* #####  Adding the agreement for this user  ##### */
				//Create prepared statement
				PreparedStatement ps = connection.prepareStatement(
						addAgForUser, PreparedStatement.RETURN_GENERATED_KEYS);
				//Set parameters
				ps.setString(1, agreementName);
				ps.setString(2, agreementContent);
				ps.setInt(3, userId);
				//Insert the agreement
				ps.executeUpdate();
				//Get the new agreement id
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					idAg = rs.getInt(1);
				}
				rs.close();
				ps.close();
			} else {
				System.err.println("The user already has an agreement with the same name");
			}
		}else{
			System.err.println("The user must be logged in");
		}
		connection.close();
		
		return idAg;
	}

//	public boolean deleteAgreement(int id) throws SQLException{
//		return deleteAgreement(id, PUBLIC_USER);
//	}

	public boolean deleteAgreement(int id, String session) throws SQLException{
		Connection connection = db.connect();
		int userId = sm.getUserId(session);
		boolean result = false;
		String deleteAg = "DELETE FROM documentos WHERE idDocumentos=?";
		
		if (existAgreement(connection, id)) {
			if (userId != 0) {
				//if the document exists and belong to the user
				if (isTheAgreementOwner(connection, id, userId)) {
					//delete the agreement
					PreparedStatement ps = connection
							.prepareStatement(deleteAg);
					ps.setInt(1, id);
					ps.executeUpdate();
					ps.close();
					result = true;
				} else {
					System.err.println("The agreement doesn�t belong to the user");
				}
			} else {
				System.err.println("The user must be logged in");
			}
		}else{
			System.err.println("The agreement doesn�t exists");
		}
		connection.close();
		
		return result;
	}

//	public boolean updateAgreement(int id, String agreementName, String agreementContent) throws SQLException{
//		return updateAgreement(id, agreementName, agreementContent, PUBLIC_USER);
//	}

	public boolean updateAgreement(int id, String agreementName, String agreementContent, String session) throws SQLException{
		Connection connection = db.connect();
		int userId = sm.getUserId(session);
		boolean result = false;
		String updateAg = "UPDATE documentos SET nombre = ?, contenido=? WHERE idDocumentos=?";
		if (existAgreement(connection, id)) {
			if (userId != 0) {
				if (isTheAgreementOwner(connection, id, userId)) {
					if (!existsAgWithSameNameForUserExceptCurrentUpdatedDocument(connection, id, agreementName, userId)) {
						PreparedStatement ps = connection.prepareStatement(updateAg);
						ps.setString(1, agreementName);
						ps.setString(2, agreementContent);
						ps.setInt(3, id);
						ps.executeUpdate();
						ps.close();
						result = true;
					}else{
						System.err.println("The user already has an agreement with the same name");
					}
				} else {
					System.err.println("The agreement doesn�t belong to the user");
				}
			} else {
				System.err.println("The user must be logged in");
			}
		}else{
			System.err.println("The agreement doesn�t exists");
		}
		return result;
	}

	public Map<Integer, DocumentProxy> getPublicAgreements() throws SQLException{
		return getAgreementsByUser(PUBLIC_SESSION);
	}

	public Map<Integer, DocumentProxy> getAgreementsByUser(String session) throws SQLException{
		int user = sm.getUserId(session);
		Map<Integer, DocumentProxy> agreements = new HashMap<Integer, DocumentProxy>();
		if (user != 0) {
			String getAgreements = "SELECT idDocumentos, nombre, contenido FROM documentos WHERE idUsuario=?";
			Connection connection = db.connect();
			PreparedStatement ps = connection.prepareStatement(getAgreements);
			ps.setInt(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DocumentProxy doc = new DocumentProxy(rs.getString(2), rs.getString(3));
				agreements.put(rs.getInt(1), doc);
			}
			rs.close();
			ps.close();
			db.disconnect(connection);
		}else{
			System.err.println("The user must be logged in");
		}
		return agreements;
	}
	
	public DocumentProxy getAgreementById(int id){
		DocumentProxy doc = null;
		Connection c = db.connect();
		try {
			if(existAgreement(c, id)){
				String getAgreement = "SELECT nombre, contenido FROM documentos WHERE idDocumentos=?";
				PreparedStatement ps = c.prepareStatement(getAgreement);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					doc = new DocumentProxy(rs.getString(1), rs.getString(2));
				}
				rs.close();
				ps.close();
			}else{
				System.err.println("The agreement doesn�t exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.disconnect(c);
		return doc;
	}
	
	/**
	 * 
	 * @param c The connection to the repository
	 * @param agId The agreement identifier
	 * @param user The user identifier
	 * @return True if the user is the agreement owner; false otherwise
	 * @throws SQLException
	 */
	private boolean isTheAgreementOwner(Connection c, int agId, int user) throws SQLException{
		boolean result = false;
		//Check if the agreement to delete is public
		String selectAg = "SELECT idUsuario FROM documentos WHERE idDocumentos=?";
		PreparedStatement ps = c.prepareStatement(selectAg);
		ps.setInt(1, agId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			if(rs.getInt(1) == user){
				result = true;
			}
		}
		rs.close();
		ps.close();
		return result;
	}
	
	/**
	 * 
	 * @param c The connection to the repository
	 * @param agName The agreement name
	 * @param user The user id
	 * @return True if the user already has an agreement with the same name
	 */
	private boolean existsAgWithSameNameForUser(Connection c, String agName, int user) throws SQLException{
		boolean result = false;
		String checkIfAgExistsQuery = "SELECT * FROM documentos WHERE nombre=? AND idUsuario=?";
		//Create prepared statement
		PreparedStatement ps = c.prepareStatement(checkIfAgExistsQuery);
		//Set parameters
		ps.setString(1, agName);
		ps.setInt(2, user);
		//Execute
		ResultSet rs = ps.executeQuery();
		//If exists an agreement with the same name
		if(rs.next()){
			result = true;
		}
		return result;
	}
	
	/**
	 * 
	 * @param c The connection to the repository
	 * @param updatedAgreem The agreement id to be updated
	 * @param agName The agreement name
	 * @param user The user id
	 * @return True if the user already has an agreement with the same name and it isn�t the agreement to be updated
	 * @throws SQLException
	 */
	private boolean existsAgWithSameNameForUserExceptCurrentUpdatedDocument(Connection c, int updatedAgreem, String agName, int user) throws SQLException{
		boolean result = false;
		String checkIfAgExistsQuery = "SELECT idDocumentos FROM documentos WHERE nombre=? AND idUsuario=?";
		//Create prepared statement
		PreparedStatement ps = c.prepareStatement(checkIfAgExistsQuery);
		//Set parameters
		ps.setString(1, agName);
		ps.setInt(2, user);
		//Execute
		ResultSet rs = ps.executeQuery();
		//If exists an agreement with the same name
		if(rs.next()){
			//If existing agreement with the same name is the agreement to be updated
			if(rs.getInt(1) != updatedAgreem){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param c The connection to the repository
	 * @param user The user id
	 * @return True if the user exists and is valid
	 * @throws SQLException
	 */
//	private boolean isAValidUser(Connection c, int user) throws SQLException{		
//		boolean result = false;
////		if (user != PUBLIC_USER) {
//			String isAValidUser = "SELECT nombre FROM usuarios WHERE idUsuario=?";
//			//Create prepared statement
//			PreparedStatement ps = c.prepareStatement(isAValidUser);
//			//Set parameters
//			ps.setInt(1, user);
//			//Execute
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
////				result = true;
//			}
////		}else{
//			result = true;
////		}
//		return result;
//	}
	
	/**
	 * 
	 * @param id The agreement id
	 * @return True if the agreement exists in the repository; false otherwise
	 */
	private boolean existAgreement(Connection c, int id) throws SQLException{
		boolean result = false;
		String isAValidUser = "SELECT nombre FROM documentos WHERE idDocumentos=?";
		//Create prepared statement
		PreparedStatement ps = c.prepareStatement(isAValidUser);
		//Set parameters
		ps.setInt(1, id);
		//Execute
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			result = true;
		}
		return result;
	}
}