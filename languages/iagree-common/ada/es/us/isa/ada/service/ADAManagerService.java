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

package es.us.isa.ada.service;

import java.sql.SQLException;
import java.util.Map;

import es.us.isa.ada.repository.DocumentProxy;
import es.us.isa.ada.salmon.MonitoringManagementDocument;

public interface ADAManagerService {

	public String login(String user, String pass);
	
	public boolean logout(String session);
	
	public int getUserId(String session);
	
	public int storeAgreement(String agreementName, String agreementContent, String session) throws SQLException;
	
	public boolean deleteAgreement(int id, String session) throws SQLException;

	public boolean updateAgreement(int id, String agreementName, String agreementContent, String session) throws SQLException;
	
	public Map<Integer, DocumentProxy> getPublicAgreements() throws SQLException;

	public Map<Integer, DocumentProxy> getAgreementsByUser(String session) throws SQLException;
	
	//antes getMonitorisableProperties
	public String getMMD(int docId, String session);
	
	public byte[] documentId2String(int docId) throws SQLException;
	
}
