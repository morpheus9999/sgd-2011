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
import sgd.Info;
import sgd.Medicoes;

class UDPServer {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);

        int v = 0;
        byte[] receiveData = new byte[1024];
        BytetoObject convert = new BytetoObject();
        Medicoes medir = new Medicoes();
        Object obj = null;
        Info infoo;

        while (true) {

            for (int j = 0; j < 10000; j++) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
               


                obj = convert.toObject(receivePacket.getData());
               // v++;


                XPath xpath = XPathFactory.newInstance().newXPath();
                Document m = loadXMLFrom(obj.toString());
                XPathExpression expr = xpath.compile("//root/*/text()");
                Object result = expr.evaluate(m, XPathConstants.NODESET);
                NodeList nodes = (NodeList) result;
                //for (int i = 0; i < nodes.getLength(); i++) {
                  //  System.out.println(nodes.item(i).getNodeValue());
                //}

                infoo = new Info(nodes.item(1).getNodeValue(), Integer.parseInt(nodes.item(2).getNodeValue()), Integer.parseInt(nodes.item(3).getNodeValue()), Integer.parseInt(nodes.item(4).getNodeValue()), Integer.parseInt(nodes.item(5).getNodeValue()), Integer.parseInt(nodes.item(6).getNodeValue()), Integer.parseInt(nodes.item(7).getNodeValue()), Integer.parseInt(nodes.item(8).getNodeValue()), Integer.parseInt(nodes.item(9).getNodeValue()), Integer.parseInt(nodes.item(10).getNodeValue()), Integer.parseInt(nodes.item(11).getNodeValue()), Integer.parseInt(nodes.item(12).getNodeValue()));


                long tempoFinal = System.currentTimeMillis();
                long tempoInicial = Long.parseLong(nodes.item(0).getNodeValue());
                long tempo = tempoFinal - tempoInicial;
                medir.add(tempo);
            }

             medir.print_statistics();

            break;
        }
        return;
    }

    public static Document loadXMLFrom(String xml) throws Exception {
        InputSource is = new InputSource(new StringReader(xml));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        return doc;
    }
}
