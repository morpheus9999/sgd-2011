/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Jorge
 */
import java.io.*;
import java.net.*;
//import org.json.JSONObject;
import sgd.BytetoObject;
import sgd.ConverttoJSON;
import sgd.ConverttoXML;




import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;


class TCPServer {


    


    public static void main(String argv[]) throws Exception {

        Object obj = null;
        BytetoObject convert = new BytetoObject();
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket;
        connectionSocket = welcomeSocket.accept();
        InputStream in = connectionSocket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        
        ConverttoXML t = new ConverttoXML();
        ConverttoJSON t1 = new ConverttoJSON();

        int v = 0;
        while (true) {

            int len = dis.readInt();

            byte[] data = new byte[len];
            if (len > 0) {
                dis.readFully(data);
            }
            //System.out.println(data);
            //System.out.println(data.length);
            obj = convert.toObject(data);
            v++;
            
           XPath xpath = XPathFactory.newInstance().newXPath();
            Document m =loadXMLFrom(obj.toString());
            XPathExpression expr = xpath.compile("//root/*/text()");
                Object result = expr.evaluate(m, XPathConstants.NODESET);
                NodeList nodes = (NodeList) result;
                for (int i = 0; i < nodes.getLength(); i++) {
                 System.out.println(nodes.item(i).getNodeValue());
                }
        }

    }
    public static Document loadXMLFrom(String xml) throws Exception {
        InputSource is= new InputSource(new StringReader(xml));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        return doc;
    }

       public static Document loadJSONFrom(String json) throws Exception {
        InputSource is= new InputSource(new StringReader(json));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        return doc;
    }
    
}
