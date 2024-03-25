import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

    public static void main(String[] args) throws Exception{
        
        File xmlFile = new File("/home/madan/anand/Java Class Files/resources/sample2.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);

        NodeList nodeList = document.getElementsByTagName("root");

        for(int i =0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            System.out.println(node);
        }

        System.out.println(nodeList);

    }
    
}
