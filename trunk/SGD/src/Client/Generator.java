/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import sgd.Info;

/**
 *
 * @author David
 */
public class Generator {

    //public static void main(String argv[]) throws Exception {

    public Generator(){}

    public Info [] getDados(){
        Info[] dados = new Info[100000];

        int i, j;
        String name = "";
        int duration=0;
        String[] nomes = {"Mike", "Isabel", "Joao", "Paulo", "Jorge", "David", "Sara", " "};


        for (j = 0; j < 100000; j++) {

            name = "";
            for (i = 0; i < 4; i++) {

                name += nomes[(int) (Math.random() * 7)];

            }

            duration = (int) (Math.random() * 990) + 10;
            

            dados[j] = new Info(name, duration, 37, 0, 0, 39, 39583, 36267, 238, 237955, 39583, 39583335);

        }

         /*for (j = 0; j < 100000; j++) {
              System.out.println(dados[j].getCaller_id());
              System.out.println(dados[j].getDuration());
        }*/
        return dados;
    }
}
