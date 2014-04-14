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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ajurado
 */

public interface AgreementRepository {

//	/**
//	 * Stores an agreement in the repository as public
//	 * @param agreementName Name asigned to the agreement
//	 * @param agreementContent Text content of the agreement
//	 * @return the agreement id. Returns 0 if it doesn-t insert the agreement 
//	 */
//	public int storeAgreement(String agreementName, String agreementContent) throws SQLException;
	
	/**
	 * Stores an agreement in the repository as private
	 * @param agreementName Name asigned to the agreement
	 * @param agreementContent Text content of the agreement
	 * @param session An opened session
	 * @return the agreement id. Returns 0 if it doesn-t insert the agreement 
	 */
	public int storeAgreement(String agreementName, String agreementContent, String session) throws SQLException;
	
//	/**
//	 * Deletes a public agreement from the repository
//	 * @param id Identifier of the agreement to be deleted
//	 * @return <code>true</code> if the agreement was successfully deleted; <code>false</code> otherwise
//	 */
//	public boolean deleteAgreement(int id) throws SQLException;
	
	/**
	 * Deletes a private agreement from the repository if the user is the document owner
	 * @param id Identifier of the agreement to be deleted
	 * @param session An opened session
	 * @return <code>true</code> if the agreement was successfully deleted; <code>false</code> otherwise
	 */
	public boolean deleteAgreement(int id, String session) throws SQLException;
	
//	/**
//	 * Updates a public agreement in the repository
//	 * @param id Identifier of the agreement to be updated
//	 * @param agreementName Name asigned to the agreement
//	 * @param agreementContent Text content of the agreement
//	 * @return <code>true</code> if the agreement was successfully updated; <code>false</code> otherwise
//	 */
//	public boolean updateAgreement(int id, String agreementName, String agreementContent) throws SQLException;
	
	/**
	 * Updates a private agreement in the repository if the user is the document owner
	 * @param id Identifier of the agreement to be updated
	 * @param agreementName Name asigned to the agreement
	 * @param agreementContent Text content of the agreement
	 * @param session An opened session
	 * @return <code>true</code> if the agreement was successfully updated; <code>false</code> otherwise
	 */
	public boolean updateAgreement(int id, String agreementName, String agreementContent, String session) throws SQLException;
	
	/**
	 * 
	 * @return All public agreements stored in the repository. Key is the agreement id and value is an agreement
	 */
	public Map<Integer, DocumentProxy> getPublicAgreements() throws SQLException;
	
	/**
	 * 
	 * @param session An opened session 
	 * @return All private agreements stored in the repository that belongs to the user that has opened the session. Key is the agreement id and value is an agreement. Returns empty Map if the session hasn-t been opened
	 */
	public Map<Integer, DocumentProxy> getAgreementsByUser(String session) throws SQLException;
	
	/**
	 * 
	 * @param docId Agreement identifier
	 * @return An agreement. Returns null if the agreement doesn-t exist
	 * @throws SQLException
	 */
	public DocumentProxy getAgreementById(int docId) throws SQLException;
}
