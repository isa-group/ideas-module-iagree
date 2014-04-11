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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Location;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Restriction;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.Domain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.EnumeratedDomain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.IntegerDomain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.RealDomain;


//TODO hay que usar los location
//a traves de XPATH???

public class JSDLSDTParser implements SDTParser {

	@Override
	public ServiceDescriptionTerm parseSDT(Node n) {
		// TODO Auto-generated method stub
		return new ServiceDescriptionTerm();
	}

	@Override
	public void setVars(Map<String, Variable> vars) {
		// TODO Auto-generated method stub
		
	}
	
}
