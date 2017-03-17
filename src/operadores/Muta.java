/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import datos.Individuo;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Muta {
    
    public static void mutaGenAleatorio(Individuo i){
     Random ran = new Random();
     int pos = ran.nextInt(Individuo.articulos.size());
     
        mutaGen(i, pos);
     
    }
    
    public static void mutaGen(Individuo i,int n){
         if (i.getGenotipo()[n]==0){
           i.getGenotipo()[n]=1;
           i.calculaFitnessyPeso();
         }else {
           i.getGenotipo()[n]=0;
           i.calculaFitnessyPeso();
         }
    }
}
