/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

import Client.Generator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.json.JSONObject;

/**
 *
 * @author David
 */
public class JSonUDP {

    public static void main(String[] args) throws Exception {

        Generator gen = new Generator();
        ObjecttoByte convert = new ObjecttoByte();
        Info[] dados;
        int i = 0;
        dados = gen.getDados();
        String example;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        
        

        for (i = 0; i < 100000; i++) {

            JSONObject json = new JSONObject();
            json.put("tempo", System.currentTimeMillis());
            json.put("caller_id", dados[i].getCaller_id());
            json.put("duration", dados[i].getDuration());
            json.put("billsec", dados[i].getBillsec());
            json.put("progresssec", dados[i].getProgressec());
            json.put("progress_mediasec", dados[i].getProgress_mediasec());
            json.put("flow_billsec", dados[i].getBillsec());
            json.put("mduration", dados[i].getMduration());
            json.put("billmsec", dados[i].getBillmsec());
            json.put("progressmsec", dados[i].getProgressmsec());
            json.put("progress_mediamsec", dados[i].getProgress_mediamsec());
            json.put("flow_billmsec", dados[i].getFlow_billmsec());
            json.put("uduration", dados[i].getUduration());

            //System.out.println(":" + json);
            example = json.toString();
            sendData = convert.toBytes(example);
            // System.out.println(teste);

          
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            if (i == 99000) {
                i = 0;
            }

        }
    }
}
