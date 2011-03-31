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
import javax.swing.text.Document;

import sgd.BytetoObject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.json.JSONObject;

import sgd.Info;
import sgd.Medicoes;

class UDPServer {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        Info infoo;
        Medicoes medir = new Medicoes();

        //int v = 0;
        byte[] receiveData = new byte[1024];
        BytetoObject convert = new BytetoObject();
        Object obj = null;

        while (true) {

            for (int j = 0; j < 10000; j++) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());


                obj = convert.toObject(receivePacket.getData());
                //v++;

                JSONObject object = new JSONObject(obj.toString());
                //System.out.println("caller_id:"+object.getString("caller_id"));

                infoo = new Info(object.getString("caller_id"), Integer.parseInt(object.getString("duration")), Integer.parseInt(object.getString("billsec")), Integer.parseInt(object.getString("progresssec")), Integer.parseInt(object.getString("progress_mediasec")), Integer.parseInt(object.getString("flow_billsec")), Integer.parseInt(object.getString("mduration")), Integer.parseInt(object.getString("billmsec")), Integer.parseInt(object.getString("progressmsec")), Integer.parseInt(object.getString("progress_mediamsec")), Integer.parseInt(object.getString("flow_billmsec")), Integer.parseInt(object.getString("uduration")));

                long tempoFinal = System.currentTimeMillis();
                long tempoInicial = object.getLong("tempo");
                long tempo = tempoFinal - tempoInicial;
                medir.add(tempo);
            }
            System.out.println("Média: " + medir.getAvg());
            System.out.println("Máximo: " + medir.getMax());
            System.out.println("Minimo: " + medir.getMin());
            System.out.println("Desvio Padrão: " + medir.getStdev());
            System.out.println("Total: " + medir.getN());
            break;
        }
        return;

    }
}
