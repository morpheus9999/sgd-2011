/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

/**
 *
 * @author Jorge
 */
import Client.Generator;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class DomXmlExampleUDP {

    /**
     * Our goal is to create a DOM XML tree and then print the XML.
     */
    Generator gen = new Generator();
    Info[] dados;
    ObjecttoByte convert = new ObjecttoByte();
    ConverttoXML t = new ConverttoXML();

    public static void main(String args[]) throws Exception {

        new DomXmlExampleUDP();
    }

    public DomXmlExampleUDP() throws UnknownHostException, IOException {
        int i = 0;
        dados = gen.getDados();

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];

        //for (i = 0; i < 100000; i++) {
            try {
                /////////////////////////////
                //Creating an empty XML Document

                //We need a Document
                DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                ////////////////////////
                //Creating the XML tree

                //create the root element and add it to the document
                Element root = doc.createElement("root");
                doc.appendChild(root);

                

                //create child element, add an attribute, and add to root
                Element child = doc.createElement("caller_id");
                root.appendChild(child);
                //add a text element to the child
                Text text = doc.createTextNode(dados[i].getCaller_id());
                child.appendChild(text);

                Element child1 = doc.createElement("duration");

                root.appendChild(child1);
                //add a text element to the child
                Text text1 = doc.createTextNode("" + dados[i].getDuration());
                child1.appendChild(text1);

                Element child2 = doc.createElement("billsec");
                root.appendChild(child2);
                //add a text element to the child
                Text text2 = doc.createTextNode("" + dados[i].getBillsec());
                child2.appendChild(text2);

                Element child3 = doc.createElement("progresssec");
                root.appendChild(child3);
                //add a text element to the child
                Text text3 = doc.createTextNode("" + dados[i].getProgressec());
                child3.appendChild(text3);

                Element child4 = doc.createElement("progress_mediasec");
                root.appendChild(child4);
                //add a text element to the child
                Text text4 = doc.createTextNode("" + dados[i].getProgress_mediasec());
                child4.appendChild(text4);

                Element child5 = doc.createElement("flow_billsec");
                root.appendChild(child5);
                //add a text element to the child
                Text text5 = doc.createTextNode("" + dados[i].getFlow_billsec());
                child5.appendChild(text5);

                Element child6 = doc.createElement("mduration");
                root.appendChild(child6);
                //add a text element to the child
                Text text6 = doc.createTextNode("" + dados[i].getMduration());
                child6.appendChild(text6);

                Element child7 = doc.createElement("billmsec");
                root.appendChild(child7);
                //add a text element to the child
                Text text7 = doc.createTextNode("" + dados[i].getBillmsec());
                child7.appendChild(text7);


                Element child8 = doc.createElement("progressmsec");
                root.appendChild(child8);
                //add a text element to the child
                Text text8 = doc.createTextNode("" + dados[i].getProgressmsec());
                child8.appendChild(text8);

                Element child9 = doc.createElement("progress_mediamsec");
                root.appendChild(child9);
                //add a text element to the child
                Text text9 = doc.createTextNode("" + dados[i].getProgress_mediamsec());
                child9.appendChild(text9);

                Element child10 = doc.createElement("flow_billmsec");
                root.appendChild(child10);
                //add a text element to the child
                Text text10 = doc.createTextNode("" + dados[i].getFlow_billmsec());
                child10.appendChild(text10);

                Element child11 = doc.createElement("uduration");
                root.appendChild(child11);
                //add a text element to the child
                Text text11 = doc.createTextNode("" + dados[i].getUduration());
                child11.appendChild(text11);



                /////////////////
                //Output the XML

                //set up a transformer
                TransformerFactory transfac = TransformerFactory.newInstance();
                Transformer trans = transfac.newTransformer();
                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                trans.setOutputProperty(OutputKeys.INDENT, "yes");

                //create string from xml tree
                StringWriter sw = new StringWriter();
                StreamResult result = new StreamResult(sw);
                DOMSource source = new DOMSource(doc);
                trans.transform(source, result);
                String xmlString = sw.toString();
                
                //System.out.println("Here's the xml:\n\n" + xmlString);

                sendData = convert.toBytes(xmlString);
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                

                
            } catch (Exception e) {
                System.out.println(e);
            }

            if (i == 99000) {
                i = 0;
            }
        //}
    }
}
