import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;

public class XmlReader {

    public static void main(String[] args) throws Exception{
        
        File xmlFile = new File("/home/madan/anand/Java Class Files/resources/SBI_NTPC_20240303_04032024073001.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("TRANSACTION");

        for(int temp =0;temp<nodeList.getLength();temp++){
            Node node = nodeList.item(temp);
            // System.out.println("\nCurrent Element :" + node.getNodeName());
if(node.getNodeType() == Node.ELEMENT_NODE){
Element eElement = (Element) node;
String refNo = eElement.getElementsByTagName("REFNO").item(0).getTextContent();
String paymentMode = eElement.getElementsByTagName("PAYMODE").item(0).getTextContent();
String utrNo = eElement.getElementsByTagName("UTRNO").item(0).getTextContent();
String totalAmount = eElement.getElementsByTagName("TOTALAMOUNT").item(0).getTextContent();
System.out.println("Ref No : "+refNo);
System.out.println("UTR No : "+utrNo);
System.out.println("Paytm :"+paymentMode);
System.out.println("Total Amount :"+totalAmount);
}
        }

    }
    
}
