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

/**
 * Interface to create/update/delete users
 *
 */
public interface UsersManager {

	/**
	 * 
	 * @param name Name of the user
	 * @param email Email of the user
	 * @param password Password of the user. It must be at least 6 characters long
	 * @return The id of created user, 0 if the user cannot be created
	 */
	public int addUser(String name, String password, String company, String email); //TODO ¿Que más información queremos añadir?
	
	/**
	 * 
	 * @param id The id of the user to be deleted
	 * @param session Opened session for user represented by id
	 * @return True if the user information was successfully deleted; false otherwise.
	 */
	public boolean deleteUser(int id, String session);
	
	/**
	 * 
	 * @param id The id of the user to be updated
	 * @param name Name of the user
	 * @param email Email of the user
	 * @param session Opened session for user represented by id
	 * @return True if the user information was successfully updated; false otherwise.
	 */
	public boolean updateUser(int id, String name, String password, String company, String email, String session); //TODO ¿Que más información habrá?
	
	/**
	 * 
	 * @param name Name of the user to be returned
	 * @return The id of the requested user. It will return 0 if the user doesn´t exist.
	 */
	public int getUserIdByName(String name);
}