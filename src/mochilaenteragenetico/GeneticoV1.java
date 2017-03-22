/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaenteragenetico;

import datos.Individuo;
import datos.Poblacion;
import operadores.Cruza;
import operadores.Mascaras;
import operadores.Muta;
import operadores.Seleccion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoV1 {
    private int tamano_poblacion;
    private int epocas;
    private double prob_muta;
    private Poblacion poblacion;

    public GeneticoV1(int tamano_poblacion, int epocas, double prob_muta) {
        this.tamano_poblacion = tamano_poblacion;
        this.epocas = epocas;
        this.prob_muta = prob_muta;
        this.poblacion = new Poblacion(tamano_poblacion);
    }
  
   public void evolucionar (){
       // crear un proceso iterativo para simular las epocas
        for (int e=0; e < this.epocas;e++){
            // garantizar la creación de una nueva población
            Poblacion nuevaP = new Poblacion(); 
            // tenemos que iterar para construir la nueva generacion
            for(int i=0; i < this.tamano_poblacion;i++){
               // proceso de seleccion de padre y madre
               Individuo padre = Seleccion.selccionarMejor(poblacion);
               Individuo madre = Seleccion.seleccionarAleatorio(poblacion);
               // ejecutamos la cruza y obtenemos al hijo
               Individuo hijo = Cruza.cruzaConMascara(madre, padre, Mascaras.generarMascaraAleatoria(Individuo.articulos.size()));
               // dependiendo de una prob. muta se cambia el hijo
               if (Math.random()<=this.prob_muta){
               Muta.mutaGenAleatorio(hijo);
               
               }
// agrega el hijo a la nueva poblacion
               nuevaP.agregarHabitante(hijo);
            }
            // actualizamos la población 
            this.poblacion = new Poblacion(nuevaP);
            Individuo mejor =  this.poblacion.getMejor();
            System.out.println(e+" - fitness de: "+mejor.getFitness()+" "+mejor.isValido());
        
        }
        System.out.println(this.poblacion.getMejor().toString());
    
    }
    
    
    
}

    
    
