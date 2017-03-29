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
public class GeneticoV1 implements Runnable{
    private int tamano_poblacion;
    private int epocas;
    private double prob_muta;
    private Poblacion poblacion;
    private int e;
    private  Thread hiloGenetico;
    public GeneticoV1(int tamano_poblacion, int epocas, double prob_muta) {
        
        this.tamano_poblacion = tamano_poblacion;
        this.epocas = epocas;
        this.prob_muta = prob_muta;
        this.poblacion = new Poblacion(tamano_poblacion);
        hiloGenetico = new Thread(this);
        hiloGenetico.start();
    }
  
   public void evolucionar (){
       // crear un proceso iterativo para simular las epocas
     
        for ( e=0; getE() < this.epocas;e++){
            // garantizar la creación de una nueva población
            Poblacion nuevaP = new Poblacion(); 
            // tenemos que iterar para construir la nueva generacion
            for(int i=0; i < this.tamano_poblacion;i++){
               // proceso de seleccion de padre y madre
               Individuo padre = Seleccion.selccionarMejor(getPoblacion());
               Individuo madre = Seleccion.seleccionRuleta(getPoblacion());
               // ejecutamos la cruza y obtenemos al hijo
               Individuo hijo;
               do {
               hijo = Cruza.cruzaConMascara(madre, padre, Mascaras.generarMascaraAleatoria(Individuo.articulos.size()));
               // dependiendo de una prob. muta se cambia el hijo
               if (Math.random()<=this.prob_muta){
               Muta.mutaGenAleatorio(hijo);
               
               }}while(!hijo.isValido());
// agrega el hijo a la nueva poblacion
             
               nuevaP.agregarHabitante(hijo);
            }
            // actualizamos la población 
            this.setPoblacion(new Poblacion(nuevaP));
            Individuo mejor =  this.getPoblacion().getMejor();
             
            if (mejor.getFitness()==175){
             System.out.println();
             }
            //99429
            
          System.out.println(getE()+" - fitness de: "+mejor.getFitness()+" peso:  "+ mejor.getPeso()+" "+mejor.isValido()+"--!!!!!!!");
        
          

            
        }
        System.out.println(this.getPoblacion().getMejor().toString());
    
    }

    /**
     * @return the poblacion
     */
    public Poblacion getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * @return the e
     */
    public int getE() {
        return e;
    }

   

    @Override
    public void run() {
        evolucionar();
    }

    /**
     * @return the hiloGenetico
     */
    public Thread getHiloGenetico() {
        return hiloGenetico;
    }

    
    
}

    
    
