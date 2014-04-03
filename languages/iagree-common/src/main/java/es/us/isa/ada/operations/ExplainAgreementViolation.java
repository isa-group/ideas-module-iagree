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

package es.us.isa.ada.operations;

import java.util.Map;

import es.us.isa.ada.Operation;
import es.us.isa.ada.errors.AgreementError;
import es.us.isa.ada.errors.Explanation;
import es.us.isa.ada.salmon.MonitoringManagementDocument;

public interface ExplainAgreementViolation extends Operation {


	int STANDARD_LEVEL = 0;
	int REFINE_OFFER = 1;
	int REFINE_TEMPLATE = 2;
	int REFINE_ALL = 3;
	
	
	public Map<AgreementError,Explanation> explainViolation();
	
	public void setMMD(MonitoringManagementDocument mmd);
		
	public void setExplanationLevel(int level);
	
}
