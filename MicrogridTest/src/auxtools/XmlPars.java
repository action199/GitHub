package auxtools;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import org.apache.xerces.parsers.DOMParser;
//import org.apache.xml.serialize.OutputFormat;
//import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlPars {
	static String value = null;
	/**
	 * @param args
	 * @return 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static  String ler(String file, String time) {
		String tempstr = null;
	
		double valor=0;
		try {
			File xml = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			dbFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xml);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("ROW");
			// Element nn= nList.

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;

				NodeList nlList = eElement.getElementsByTagName("TimeStamp").item(0)
						.getChildNodes();
				Node nValue = (Node) nlList.item(0);
				//System.out.println("TimeStamp: " + nValue.getNodeValue());
				if (nValue.getNodeValue().equalsIgnoreCase(time)) {
					Node VnNode = nList.item(temp);
					Element VeElement = (Element) VnNode;
					NodeList vnlList = VeElement.getElementsByTagName("Pac")
							.item(0).getChildNodes();
					Node vnValue = (Node) vnlList.item(0);
					tempstr = vnValue.getNodeValue().toString();
					//					valor=Double.parseDouble(tempstr);
					//					valor=temstr
				//	System.out.println("hour:++++ "
				//			+ tempstr);
					// TESTE ESCRITA

					
				}

			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		// System.out.println("hour:++++ "
		// + valor);
		return tempstr;

	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		value=ler("C://Users//Adriano//MicroGrid//SmartMicroGrid//Data//Profiles//Prod_PV.xml",
				"18:30");
		//	ler("C://Users//Adriano-PC//workspace//Smart//bin//SimTime.xml",
		//		"Data", "01:00", "wr", "12");
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+value);
	}
*/
}