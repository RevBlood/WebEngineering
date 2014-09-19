package exercise1;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;



import java.util.ArrayList;
import java.util.List;


public class XMLTable {

	static private String xml = "D:\\Medier\\Skrivebord\\Semester7\\Web Engineering\\Git\\Exercise1\\tableofparts.xml";
	List<TableElement> Elements;
	
	public class TableElement {
		private int partkey;
		private String name;
		private double retailPrice;
		
		public TableElement(int partkey, String name, double retailPrice) {
			setPartkey(partkey);
			setName(name); 
			setRetailPrice(retailPrice);
		}

		public int getPartkey() {
			return partkey;
		}

		public void setPartkey(int partkey) {
			this.partkey = partkey;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public void setRetailPrice(double retailPrice) {
			this.retailPrice = retailPrice;
		}
		
		public double getRetailPrice() {
			return retailPrice;
		}
	}
	
	public XMLTable() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		
		FileInputStream file = new FileInputStream(new File(xml));
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(file);
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String expression = "//T";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		
		String keyPartkey = "P_PARTKEY";
		String keyName = "P_NAME";
		String keyRetailPrice = "P_RETAILPRICE";
		
		Elements = new ArrayList<TableElement>();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			
			NodeList lnodelist = nodeList.item(i).getChildNodes();
			int key = 0;
			String name = "";
			double retailPrice = 0;
			for(int j=0; j < lnodelist.getLength(); j++){
				
				if (lnodelist.item(j).getNodeName().equals(keyPartkey)){
					if(lnodelist.item(j).getTextContent() != null){
						key = Integer.parseInt(lnodelist.item(j).getTextContent());
					} else key = 0;
				}
				
				if (lnodelist.item(j).getNodeName().equals(keyName)){
					if(lnodelist.item(j).getTextContent() != null){
						name = lnodelist.item(j).getTextContent();
					} else name = "Not Available";
					
				}
				
				if (lnodelist.item(j).getNodeName().equals(keyRetailPrice)){
					if(lnodelist.item(j).getTextContent() != null){
						retailPrice = Double.parseDouble((lnodelist.item(j).getTextContent()));
					} else retailPrice = 0;
					
				}
			}
			
			TableElement tableElement = new TableElement(key, name, retailPrice);
			this.Elements.add(tableElement);
			file.close();
		}
		
	}
	
	public String getTableAsHTML(){
		
		String result = "<table>";
		for( TableElement e : Elements) {
		result += "<tr><td>" + e.getPartkey() + "</td><td>" + e.getName() + "</td><td>" + e.getRetailPrice() + "</td></tr>";
		}
		result += "</table>";
		
		return result;
	}
}