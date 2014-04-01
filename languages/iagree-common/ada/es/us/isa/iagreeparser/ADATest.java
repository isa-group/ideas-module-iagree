package es.us.isa.iagreeparser;

import java.net.SocketException;
import java.rmi.RemoteException;

import es.us.isa.ada.exceptions.BadSyntaxException;
import es.us.isa.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ada.service.ADAServiceImpl;
import es.us.isa.ada.service.ADAServiceV2;

public class ADATest {
	
	public static void main(String[] args) {
	
	
		String sample = "<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n" + 
				"<wsag:Template wsag:TemplateId=\"1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n" + 
				" xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n" + 
				" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" + 
				" xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n" + 
				" agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n" + 
				"	<wsag:Name >S3Premium</wsag:Name>\n" + 
				"	<wsag:Context >\n" + 
				"		<wsag:AgreementResponder >Provider</wsag:AgreementResponder >\n" + 
				"\n" + 
				"	</wsag:Context >\n" + 
				"\n" + 
				"	<wsag:Terms wsag:Name=\"AWS-S3PremiumSupport\">\n" + 
				"		<wsag:All >\n" + 
				"			<wsag:ServiceDescriptionTerm wsag:Name=\"SDT_AWS-S3PremiumSupport\" wsag:ServiceName=\"AWS-S3PremiumSupport\" >\n" + 
				"				<OfferItem name=\"ObjectSize\" wsag:Metric=\"metrics/S3Premium_1336591850145:integer\" ></OfferItem>\n" + 
				"				<OfferItem name=\"Region\" wsag:Metric=\"metrics/S3Premium_1336591850145:countries\" ></OfferItem>\n" + 
				"				<OfferItem name=\"Interface\" wsag:Metric=\"metrics/S3Premium_1336591850145:interfaceType\" ></OfferItem>\n" + 
				"				<OfferItem name=\"SVN\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" ></OfferItem>\n" + 
				"				<OfferItem name=\"RRS\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" ></OfferItem>\n" + 
				"				<OfferItem name=\"TotalPrice\" wsag:Metric=\"metrics/S3Premium_1336591850145:money\" ></OfferItem>\n" + 
				"				<OfferItem name=\"StoragePrice\" wsag:Metric=\"metrics/S3Premium_1336591850145:money\" ></OfferItem>\n" + 
				"				<OfferItem name=\"DataTransferPrice\" wsag:Metric=\"metrics/S3Premium_1336591850145:money\" ></OfferItem>\n" + 
				"				<OfferItem name=\"StorageSize\" wsag:Metric=\"metrics/S3Premium_1336591850145:size\" ></OfferItem>\n" + 
				"				<OfferItem name=\"WriteRequests\" wsag:Metric=\"metrics/S3Premium_1336591850145:integer\" ></OfferItem>\n" + 
				"				<OfferItem name=\"ReadRequests\" wsag:Metric=\"metrics/S3Premium_1336591850145:integer\" ></OfferItem>\n" + 
				"				<OfferItem name=\"TransferredGB\" wsag:Metric=\"metrics/S3Premium_1336591850145:size\" ></OfferItem>\n" + 
				"				<OfferItem name=\"Support\" wsag:Metric=\"metrics/S3Premium_1336591850145:supportType\" ></OfferItem>\n" + 
				"			</wsag:ServiceDescriptionTerm>\n" + 
				"\n" + 
				"			<wsag:ServiceReference  wsag:Name=\"AWS-S3PremiumSupport_SREF\" wsag:ServiceName=\"AWS-S3PremiumSupport\" >http://aws.amazon.com/s3/</wsag:ServiceReference>\n" + 
				"\n" + 
				"			<wsag:ServiceProperties wsag:Name=\"SP_AWS-S3PremiumSupport\" wsag:ServiceName=\"AWS-S3PremiumSupport\">\n" + 
				"				<wsag:VariableSet >\n" + 
				"					<wsag:Variable  wsag:Name=\"Availability\" wsag:Metric=\"metrics/S3Premium_1336591850145:percent\" >\n" + 
				"						<wsag:Location >/Availability</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"					<wsag:Variable  wsag:Name=\"DataDurability\" wsag:Metric=\"metrics/S3Premium_1336591850145:percent\" >\n" + 
				"						<wsag:Location >/DataDurability</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"					<wsag:Variable  wsag:Name=\"ForumAccess\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" >\n" + 
				"						<wsag:Location >/ForumAccess</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"					<wsag:Variable  wsag:Name=\"ReportAnIssue\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" >\n" + 
				"						<wsag:Location >/ReportAnIssue</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"					<wsag:Variable  wsag:Name=\"WebTicketing\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" >\n" + 
				"						<wsag:Location >/WebTicketing</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"					<wsag:Variable  wsag:Name=\"WebSupport\" wsag:Metric=\"metrics/S3Premium_1336591850145:boolean\" >\n" + 
				"						<wsag:Location >/WebSupport</wsag:Location>\n" + 
				"					</wsag:Variable >\n" + 
				"				</wsag:VariableSet >\n" + 
				"			</wsag:ServiceProperties>\n" + 
				"\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G2\" >\n" + 
				"				<wsag:QualifyingCondition >\n" + 
				"RRS = \"False\"\n" + 
				"				</wsag:QualifyingCondition>\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >DataDurability &gt;= 99</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G3\" >\n" + 
				"				<wsag:QualifyingCondition >\n" + 
				"RRS = \"True\"\n" + 
				"				</wsag:QualifyingCondition>\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >DataDurability &lt;= 98</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G4\" >\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >ForumAccess = \"True\" AND ReportAnIssue = \"True\"</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G5\" >\n" + 
				"				<wsag:QualifyingCondition >\n" + 
				"Support = \"Bronze\"\n" + 
				"				</wsag:QualifyingCondition>\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >WebTicketing = \"True\" AND WebSupport = \"True\"</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			<wsag:OneOrMore >\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G6.1\" >\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >(WebTicketing = \"True\" AND WebSupport = \"True\") IMPLIES Support = \"Bronze\"</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			<wsag:GuaranteeTerm wsag:Obligated=\"ServiceProvider\" wsag:Name=\"G6.2\" >\n" + 
				"				<wsag:ServiceLevelObjective >\n" + 
				"					<wsag:CustomServiceLevel >(TurnAroundTime = 240) IMPLIES (Support = \"Silver\" AND WebTicketing = \"True\" AND WebSupport = \"True\")</wsag:CustomServiceLevel>\n" + 
				"				</wsag:ServiceLevelObjective>\n" + 
				"			</wsag:GuaranteeTerm>\n" + 
				"			</wsag:OneOrMore >\n" + 
				"\n" + 
				"		</wsag:All >\n" + 
				"	</wsag:Terms >\n" + 
				"\n" + 
				"	<wsag:CreationConstraints >\n" + 
				"		<wsag:Constraint >\n" + 
				"			<Name>C1</Name>\n" + 
				"			<Content>(Region = US OR Region = \"west_US\" OR Region = \"EU_Irland\" OR Region = \"Pacific_Asia\" OR Region = \"Southamerica\" OR Region = \"GovCloud_US\")</Content>\n" + 
				"		</wsag:Constraint >\n" + 
				"		<wsag:Constraint >\n" + 
				"			<Name>C3</Name>\n" + 
				"			<Content>StorageSize &lt;= 5 AND WriteRequests &lt;= 400 AND ReadRequests &lt;= 400 AND TransferredGB &lt;= 15 IMPLIES TotalPrice = 0</Content>\n" + 
				"		</wsag:Constraint >\n" + 
				"	</wsag:CreationConstraints >\n" + 
				"</wsag:Template>";
		
		
		ADAServiceV2 ada;

		try {
			ada = new ADAServiceImpl();
			
			System.out.println( ada.checkDocumentConsistency(sample.getBytes()) );
			
		} catch (PeriodDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (PeriodDefinitionWarningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (BadSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		
	}

}
