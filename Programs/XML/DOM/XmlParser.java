import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");

            Document xmlDoc = DocumentBuilderFactory
                                .newInstance()
                                .newDocumentBuilder()
                                .parse(xmlFile);
            xmlDoc.getDocumentElement().normalize();

            NodeList nodeList = xmlDoc.getElementsByTagName("book");
            for(int i=0; i<nodeList.getLength(); i++) {
                Element element = (Element)nodeList.item(i);
                System.out.println("Title : " + element
                                                    .getElementsByTagName("title")
                                                    .item(0)
                                                    .getTextContent());
                System.out.println("Author : " + element
                                                    .getElementsByTagName("author")
                                                    .item(0)
                                                    .getTextContent());
                System.out.println("Price : " + element
                                                    .getElementsByTagName("price")
                                                    .item(0)
                                                    .getTextContent());
                System.out.println("Genre : " + element
                                                    .getElementsByTagName("genre")
                                                    .item(0)
                                                    .getTextContent());
                System.out.println();

            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
