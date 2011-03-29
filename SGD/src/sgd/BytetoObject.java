/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgd;

/**
 *
 * @author David
 */
public class BytetoObject {

    public BytetoObject() {
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
