/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

/**
 *
 * @author David
 */
public class ObjecttoByte {

    public ObjecttoByte() {
    }

    public static byte[] toBytes(Object object) {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        try {
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (java.io.IOException ioe) {
            java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE, ioe.getMessage());
        }
        return baos.toByteArray();
    }
}
