import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlReader {

    public static void main(String[] args) throws Exception{
        
        File xmlFile = new File("/home/madan/anand/Java Class Files/resources/SBI_UP_20240302_03032024073001.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        traverseNode(document);

    }

    public static void traverseNode(Document document){
        NodeList first = document.getElementsByTagName("TRANSACTION");
    //     for(int temp =0;temp<first.getLength();temp++){
    //         Node getNodeList = first.item(temp);
    //         NodeList getChildLength = getNodeList.getChildNodes(); 
    //     Node currentNode;
    //     for(int i =0;i<getChildLength.getLength();i++){
    //         currentNode = getChildLength.item(i);
    //         if(currentNode.getNodeType()==Node.ELEMENT_NODE)
    //         System.out.println(currentNode.getNodeName() +" : " +currentNode.getTextContent());
    //     }
    //     System.out.println();
    // }
    System.out.println("Total Transaction From the XML :" + first.getLength());
}

}
