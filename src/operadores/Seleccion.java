/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import datos.Individuo;
import datos.Poblacion;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Seleccion {
    // REGRESA UNA INSTANCIA NUEVA
    public static Individuo seleccionarAleatorio (Poblacion poblacion){
       Random ran = new Random();
       return new Individuo(poblacion.getIndividuos().get(ran.nextInt(poblacion.getIndividuos().size())));
    }
    public static Individuo selccionarMejor (Poblacion poblacion){
      return new Individuo(poblacion.getMejor());
    
    }
    public static Individuo selccionarPeor (Poblacion poblacion){
      return new Individuo(poblacion.getPeor());
    }
    public static void generarMuestreoNAleatorio (Poblacion pOrigen, Poblacion pDestino, int n){
        for (int x=0; x<n;x++){
           pDestino.getIndividuos().add(new Individuo(seleccionarAleatorio(pOrigen)));
        }
    }
    public static Individuo seleccionRuleta(Poblacion pob){
      
        double pos = pob.getFitnessPoblacion()*Math.random();
        double suma=0;
        // ahora costruimos la ruleta
        for (Individuo ind: pob.getIndividuos()){
          suma += ind.getFitness();
          if(suma>=pos){
            return new Individuo(ind);
          }
        }
        return new Individuo(pob.getIndividuos().get(0));
    }
    
    
}
