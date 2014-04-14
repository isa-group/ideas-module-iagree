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

public interface SessionManager {
	
	/**
	 * 
	 * @param username 
	 * @param password
	 * @return An opened session identifier for this user. If login process fails it returns null
	 */
	public String login(String username, String password);
	
	/**
	 * Close an opened session
	 * @param session
	 * @return True if the session was successfully closed; false otherwise
	 */
	public boolean logout(String session);
	
	/**
	 * 
	 * @param session
	 * @return The user id for this opened session. If session isn-t opened it returns 0
	 */
	public int getUserId(String session);
}
