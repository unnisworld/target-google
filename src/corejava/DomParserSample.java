package corejava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomParserSample {

	public static void main(String[] args) {
		
		try {
//			File xmlFile = new File("/Users/uvalsala/eclipse-workspace/JavaPlayGround/src/corejava/fprs.xml");
			String xmlFile = ("/Users/uvalsala/eclipse-workspace/JavaPlayGround/src/corejava/fprs.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			System.out.println("Root : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("partId");
			System.out.println("__________________________________");
			
//			NodeList partID = doc.getElementsByTagName("partId");
			
			for (int temp=0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element : " + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element place = doc.createElement("place");
					place.appendChild(doc.createTextNode("Bangalore"));
					nNode.appendChild(place);

//					Element eElement = (Element)nNode;
//					System.out.println("Part ID : " + eElement.getAttribute("id"));
//					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//					System.out.println("DOB : " + eElement.getElementsByTagName("dob").item(0).getTextContent());
				}
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(xmlFile));
			transformer.transform(domSource, result);
			
			
		} 
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
		catch (SAXException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class PartData {
	List<PartId> partData = new ArrayList<>();
}

class PartId {
	String firstName;
	String lastName;	
	int dob;
}
