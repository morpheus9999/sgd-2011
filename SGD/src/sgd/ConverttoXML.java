/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

import Client.Generator;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author David
 */
public class ConverttoXML {

    public ConverttoXML() {
    }

    public Document conv(Object inf) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        String ficheiro = inf.toString();

        StringTokenizer teste = new StringTokenizer(ficheiro, "<> \n");
        int i = 0;

        Element root = doc.createElement("root");
        doc.appendChild(root);

        while (teste.hasMoreTokens()) {
            //System.out.println(i);
            String bla = teste.nextToken();

            switch (i) {
                case 3:
                    //create child element, add an attribute, and add to root
                    Element child = doc.createElement("caller_id");
                    root.appendChild(child);
                    //add a text element to the child
                    Text text = doc.createTextNode(bla);
                    child.appendChild(text);
                    break;
                case 7:
                    Element child1 = doc.createElement("duration");
                    root.appendChild(child1);
                    //add a text element to the child
                    Text text1 = doc.createTextNode(bla);
                    child1.appendChild(text1);
                    break;
                case 11:
                    Element child2 = doc.createElement("billsec");
                    root.appendChild(child2);
                    //add a text element to the child
                    Text text2 = doc.createTextNode(bla);
                    child2.appendChild(text2);
                    break;
                case 15:
                    Element child3 = doc.createElement("progresssec");
                    root.appendChild(child3);
                    //add a text element to the child
                    Text text3 = doc.createTextNode(bla);
                    child3.appendChild(text3);
                    break;
                case 19:
                    Element child4 = doc.createElement("progress_mediasec");
                    root.appendChild(child4);
                    //add a text element to the child
                    Text text4 = doc.createTextNode(bla);
                    child4.appendChild(text4);
                    break;
                case 23:
                    Element child5 = doc.createElement("flow_billsec");
                    root.appendChild(child5);
                    //add a text element to the child
                    Text text5 = doc.createTextNode(bla);
                    child5.appendChild(text5);
                    break;
                case 27:
                    Element child6 = doc.createElement("mduration");
                    root.appendChild(child6);
                    //add a text element to the child
                    Text text6 = doc.createTextNode(bla);
                    child6.appendChild(text6);
                    break;
                case 31:
                    Element child7 = doc.createElement("billmsec");
                    root.appendChild(child7);
                    //add a text element to the child
                    Text text7 = doc.createTextNode(bla);
                    child7.appendChild(text7);
                    break;
                case 35:
                    Element child8 = doc.createElement("progressmsec");
                    root.appendChild(child8);
                    //add a text element to the child
                    Text text8 = doc.createTextNode(bla);
                    child8.appendChild(text8);
                    break;
                case 39:
                    Element child9 = doc.createElement("progress_mediamsec");
                    root.appendChild(child9);
                    //add a text element to the child
                    Text text9 = doc.createTextNode(bla);
                    child9.appendChild(text9);
                    break;
                case 43:
                    Element child10 = doc.createElement("flow_billmsec");
                    root.appendChild(child10);
                    //add a text element to the child
                    Text text10 = doc.createTextNode(bla);
                    child10.appendChild(text10);
                    break;
                case 47:
                    Element child11 = doc.createElement("uduration");
                    root.appendChild(child11);
                    //add a text element to the child
                    Text text11 = doc.createTextNode(bla);
                    child11.appendChild(text11);
                    break;
            }
            i++;
        }

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

        System.out.println("Here's the xml:\n\n" + xmlString);



        return doc;
    }
}
