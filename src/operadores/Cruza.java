/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import datos.Individuo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Cruza {
    
    public static Individuo cruzaConMascara(Individuo mama, Individuo papa, int[] mascara){
       // generar la mascara aleatoria
        
         int genotipoPadre [] = papa.getGenotipo();
         int genotipoMadre [] = mama.getGenotipo();
         int genotipoResultante []= new int[mascara.length];
         int genotipoResultante2 []= new int[mascara.length];
         
         // realizar el cruce 
         // recorrer la mascara de cruce
         for (int x=0; x < mascara.length;x++){
          // analizar el valor de la mascara
          if(mascara[x] == 1){
              genotipoResultante[x] = genotipoPadre[x];
              genotipoResultante2[x] = genotipoMadre[x];
          }else{
              genotipoResultante[x] = genotipoMadre[x];
              genotipoResultante2[x] = genotipoPadre[x];
          }
              
         }
         
         Individuo hijo1 = new Individuo(genotipoResultante);
         Individuo hijo2 = new Individuo(genotipoResultante2);
         if(hijo1.getFitness()<=hijo2.getFitness())
         {
            return hijo2;
         }
         return hijo1;
    }
    
}
