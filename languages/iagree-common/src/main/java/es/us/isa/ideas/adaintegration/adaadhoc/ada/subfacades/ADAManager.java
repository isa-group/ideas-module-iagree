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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.subfacades;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.repository.AgreementRepository;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.users.SessionManager;

public class ADAManager {

	private SessionManager sm;
	private AgreementRepository ar;
	
	public ADAManager(){
		
	}
	
	public ADAManager(SessionManager sm, AgreementRepository ar) {
		this.sm = sm;
		this.ar = ar;
	}

	public SessionManager getSessionManager() {
		return sm;
	}

	public void setSessionManager(SessionManager sm) {
		this.sm = sm;
	}

	public AgreementRepository getAgreementRepository() {
		return ar;
	}

	public void setAgreementRepository(AgreementRepository ar) {
		this.ar = ar;
	}
	
}
