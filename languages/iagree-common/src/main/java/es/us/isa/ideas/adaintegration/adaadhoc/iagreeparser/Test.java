package es.us.isa.ideas.adaintegration.adaadhoc.iagreeparser;

import java.rmi.RemoteException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceImpl;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceV2;


public class Test {

	public static void main(String[] args) throws RecognitionException {
		
		String testText = "Template S3Premium version 1.0\n" + 
				"	Provider as Responder\n" + 
				"	DateFormat: \"MM/DD/YYYY\"\n" + 
				"	GMTZone: +1\n" + 
				"	GlobalPeriod: during 01/01/2012..12/31/2012\n" + 
				"\n" + 
				"	DefinedPeriod:\n" + 
				"		HOLIDAY: from 00:00..24:00 during 01/01/2012..01/01/2012\n" + 
				"						and from 00:00..24:00 during 05/01/2012..05/01/2012\n" + 
				"		WORK: from 08:00..17:00 on MON-FRI during 01/01/2012..12/31/2012 except HOLIDAY \n" + 
				"		HOME: GlobalPeriod except WORK\n" + 
				"\n" + 
				"	Metrics:\n" + 
				"		id: string\n" + 
				"		percent: float [0..100]\n" + 
				"		countries: set {US, west_US, EU_Irland, Pacific_Asia, Southamerica, GovCloud_US}\n" + 
				"		interfaceType: enum {SOAP, REST}\n" + 
				"		objectType: string\n" + 
				"		protocol: set {HTTP, BitTorrent, HTTPS, FTP}\n" + 
				"		rightsType: set {read, write, delete, read_write, full}\n" + 
				"		money: float\n" + 
				"		size: float\n" + 
				"		supportType: enum {Bronze, Silver, Gold, Platinum}\n" + 
				"		Boolean: boolean		RangeTest: float [-20..100]\n" + 
				"\n" + 
				"AgreementTerms\n" + 
				"	Service AWS-S3PremiumSupport availableAt. http://aws.amazon.com/s3/\n" + 
				"		Features/Operations: put(Object,Private), post(Object,Private), get(ObjectId,DownloadProtocol),\n" + 
				"		delete(ObjectId), deleteRule(ObjectId,Rule), grant(ObjectId,Rights,UserId), copy, list\n" + 
				"		\n" + 
				"		GlobalDescription\n" + 
				"			ObjectSize: float = 7;\n" + 
				"			Region: countries\n" + 
				"			Interface: interfaceType\n" + 
				"			SVN: boolean\n" + 
				"			RRS: boolean\n" + 
				"			TotalPrice: money = 100;\n" + 
				"			StoragePrice: money\n" + 
				"			DataTransferPrice: money\n" + 
				"			StorageSize: size\n" + 
				"			WriteRequests: integer\n" + 
				"			ReadRequests: integer\n" + 
				"			TransferredGB: size\n" + 
				"			Support: supportType\n" + 
				"			\n" + 
				"	MonitorableProperties\n" + 
				"		global:\n" + 
				"			Availability: percent\n" + 
				"			DataDurability: percent\n" + 
				"			ForumAccess: boolean\n" + 
				"			Report-an-issue: boolean\n" + 
				"			WebTicketing: boolean \n" + 
				"			WebSupport: boolean\n" + 
				"\n" + 
				"	GuaranteeTerms\n" + 
				"		G2: Provider guarantees DataDurability >= 99.999999999%;\n" + 
				"			onlyIf (NOT RRS);\n" + 
				"\n" + 
				"		G3: Provider guarantees DataDurability <= 99.99%;\n" + 
				"			onlyIf (RRS);\n" + 
				"\n" + 
				"		G4: Provider guarantees ForumAccess = true and Report-an-issue = true;\n" + 
				"\n" + 
				"		G5: Provider guarantees WebTicketing = true and WebSupport = true on WORK;\n" + 
				"			onlyIf (Support = Bronze);\n" + 
				"\n" + 
				"		G6: one or more of\n" + 
				"			G6.1: Provider guarantees (WebTicketing = true and WebSupport = true) IMPLIES Support = Bronze on WORK;\n" + 
				"					\n" + 
				"			G6.2: Provider guarantees (TurnAroundTime = 240) IMPLIES (Support = Silver and WebTicketing = true and WebSupport = true) on WORK;\n" + 
				"\n" + 
				"CreationConstraints\n" + 
				"	C1: Region belongs {US, west_US, EU_Irland, Pacific_Asia, Southamerica, GovCloud_US};\n" + 
				"\n" + 
				"	C3: TotalPrice = 0;\n" + 
				"		onlyIf (StorageSize <= 5 and WriteRequests <=2000 and ReadRequests <= 20000 and TransferredGB <= 15);\n" + 
				"" + 
				"";
		
		
		String wsag = "";
		String metrics ="";
		
		try {
			
			CharStream charStream = new ANTLRStringStream(testText);
			
			SampleLexer lexer = new SampleLexer(charStream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			SampleParser parser = new SampleParser(tokenStream);
			
			wsag = parser.entry();
			
//			System.out.println(wsag);
//			
//			System.out.println("\n\n"+parser.getMetrics());
			metrics = parser.getMetrics();
			
			ADAServiceV2 ada;
			
			
			
			
			ada = new ADAServiceImpl();
			wsag = parser.entry();
			metrics = parser.getMetrics();
			
			
			ada.addMetricFile("blabla".getBytes(), "wsagTest_metric2".getBytes());
		}catch (NoViableAltException e) {
			wsag += "Error processing \""+ e.token.getText() + "\" at line "+ e.line + " column "+e.charPositionInLine +".";
		} catch (MismatchedTokenException e) {
			System.out.println("EXC: "+e.token+" :: "+e.line+" : " +e.charPositionInLine);
		}
		
		
		
		System.out.println(wsag+"\n\n"+metrics);
	}

}
