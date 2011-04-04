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

import org.json.JSONObject;
import sgd.Info;
import sgd.Medicoes;

class TCPServerJSON {

    public static void main(String argv[]) throws Exception {

        Object obj = null;
        BytetoObject convert = new BytetoObject();
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket;
        connectionSocket = welcomeSocket.accept();
        InputStream in = connectionSocket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        Info infoo;
        Medicoes medir = new Medicoes();

//        int v = 0;
        while (true) {

            for (int j = 0; j < 10000; j++) {
                int len = dis.readInt();

                byte[] data = new byte[len];
                if (len > 0) {
                    dis.readFully(data);
                }
                //System.out.println(data);
                //System.out.println(data.length);
                obj = convert.toObject(data);
                // v++;

                JSONObject object = new JSONObject(obj.toString());
                //System.out.println("caller_id:" + object.getString("caller_id"));

                infoo = new Info(object.getString("caller_id"), Integer.parseInt(object.getString("duration")), Integer.parseInt(object.getString("billsec")), Integer.parseInt(object.getString("progresssec")), Integer.parseInt(object.getString("progress_mediasec")), Integer.parseInt(object.getString("flow_billsec")), Integer.parseInt(object.getString("mduration")), Integer.parseInt(object.getString("billmsec")), Integer.parseInt(object.getString("progressmsec")), Integer.parseInt(object.getString("progress_mediamsec")), Integer.parseInt(object.getString("flow_billmsec")), Integer.parseInt(object.getString("uduration")));

                long tempoFinal = System.currentTimeMillis();
                long tempoInicial = object.getLong("tempo");
                long tempo = tempoFinal - tempoInicial;
                medir.add(tempo);
            }
             medir.print_statistics();

            break;
        }
        return;
    }
}
