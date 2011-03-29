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
import org.json.JSONObject;
import sgd.BytetoObject;

class TCPServer {

    public static void main(String argv[]) throws Exception {

        Object obj = null;
        BytetoObject convert = new BytetoObject();
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket;
        connectionSocket= welcomeSocket.accept();
        InputStream in = connectionSocket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            int v=0;
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
            System.out.println(v);
            System.out.println(obj);
        }

    }


}
