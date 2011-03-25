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
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import org.json.JSONObject;

public class JSon{

    public static void main(String[] args) throws Exception {
        Generator gen = new Generator();
        ObjecttoByte convert = new ObjecttoByte();
        Info[] dados;
        int i = 0;
        dados = gen.getDados();
        //Socket clientSocket = new Socket("localhost", 6789);

        //for (i = 0; i < 100000; i++) {

        JSONObject json = new JSONObject();
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

        System.out.println(":" + json);

        byte[] teste = convert.toBytes(json);
        System.out.println(teste);
        System.out.println(teste.length);

        toObject(teste);
        //sendBytes(teste, 0, teste.length, clientSocket);

        //}
    }

    public static byte[] toBytes(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(object);
        return bos.toByteArray();
    }

    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {


       ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInput in = new ObjectInputStream(bis);
        Object o = in.readObject();
        System.out.println(0);
        return o;
    }

    public static void sendBytes(byte[] myByteArray, int start, int len, Socket clientSocket) throws IOException {
        if (len < 0) {
            throw new IllegalArgumentException("Negative length not allowed");
        }
        if (start < 0 || start >= myByteArray.length) {
            throw new IndexOutOfBoundsException("Out of bounds: " + start);
        }
        // Other checks if needed.

        // May be better to save the streams in the support class;
        // just like the socket variable.
        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        dos.writeInt(len);
        if (len > 0) {
            dos.write(myByteArray, start, len);
        }


    }
}
