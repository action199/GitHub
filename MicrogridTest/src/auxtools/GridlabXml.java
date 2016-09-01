package auxtools;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

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

public class GridlabXml {
	static String value = null;
	/**
	 * @param args
	 * @return 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static  String ler(String file, String time) {
		String tempstr = null;
		try {//"D://GridlabTest//Simulations//solar.xml"
			FileReader input = new FileReader(file);
			BufferedReader bufRead = new BufferedReader(input);
			String myLine = null;


			while ( (myLine = bufRead.readLine()) != null)
			{    
				if((!myLine.contains("#") )&& myLine.contains(time))
				{ String[] array1 = myLine.split(",");
				// check to make sure you have valid data
				// String[] array2 = array1[1].split(" ");
				//for (int i = 0; i < array1.length; i++)
				StringBuilder sb = new StringBuilder(array1[1]);
				sb.deleteCharAt(0);
				tempstr=sb.toString();
			//	System.out.println(tempstr);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("hour:++++ "
		// + valor);
		return tempstr;

	} 
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directory=System.getProperty("user.dir");
	value=	ler(directory+"//Data//Profiles//solar.xml",
				"2001-01-01 12:00");
		//	ler("C://Users//Adriano-PC//workspace//Smart//bin//SimTime.xml",
		//		"Data", "01:00", "wr", "12");
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+value);
	}*/

}
