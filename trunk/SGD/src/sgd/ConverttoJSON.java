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
public class ConverttoJSON {

    public ConverttoJSON() {
    }

    public Document conv(Object inf) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        Document doc=null;
        
        String ficheiro = inf.toString();

        StringTokenizer teste = new StringTokenizer(ficheiro, "{:,'\"}");
        int i = 0;

      

        while (teste.hasMoreTokens()) {
            
            String bla = teste.nextToken();
            System.out.println(bla);
           
        }
        return doc;
    
}
}
