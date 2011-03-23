/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgd;

/**
 *
 * @author Jorge
 */
import org.json.JSONObject;

public class JSon {

    public static void main(String[] args) throws Exception {
        JSONObject json = new JSONObject();
        json.put("city", "Mumbai");
        json.put("country", "India");
        
        System.out.println(":"+json);
    }
}
