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

class TCPServer {

    public static void main(String argv[]) throws Exception {

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
            toObject(data);
            v++;
            System.out.println(v);
        }

    }

    public static Object toObject(byte[] bytes) {


        Object object = null;
   
        try {

            object =  new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes)).readObject();
        } catch (java.io.IOException ioe) {
            System.out.println("aaa");
             java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE,ioe.getMessage());
        } catch (java.lang.ClassNotFoundException cnfe) {
        }
        //System.out.println(object);
        return object;
    }
}
