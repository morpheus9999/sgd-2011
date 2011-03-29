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
import sgd.BytetoObject;

class UDPServer {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        int v=0;
        byte[] receiveData = new byte[1024];
        BytetoObject convert = new BytetoObject();
        Object obj = null;
        byte[] sendData = new byte[1024];
        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            
           
            obj = convert.toObject(receivePacket.getData());
            v++;
            System.out.println(v);
            System.out.println(obj);
        }
    }
}
