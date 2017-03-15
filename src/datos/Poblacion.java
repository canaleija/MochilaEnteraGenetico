/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.LinkedList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Poblacion {
    
    // lista de individuos 
    private LinkedList<Individuo> individuos;
    private int tamPob;
    private Individuo mejor;
    private Individuo peor;
    
    // por defecto / aleatorio
    public Poblacion(int tamPob){
        this.tamPob = tamPob;
        this.individuos = new LinkedList<>();
        for (int x=0; x < tamPob;x++){
           this.individuos.add(new Individuo());
        }
    }
     public Poblacion(Poblacion pob){
        this.tamPob = pob.getTamPob();
        this.individuos = clonarPoblacion(pob.getIndividuos());
        for (int x=0; x < tamPob;x++){
           this.individuos.add(new Individuo());
        }
    }

    /**
     * @return the individuos
     */
    public LinkedList<Individuo> getIndividuos() {
        return individuos;
    }

    /**
     * @return the tamPob
     */
    public int getTamPob() {
        return tamPob;
    }

    /**
     * @return the mejor
     */
    public Individuo getMejor() {
        return mejor;
    }

    /**
     * @return the peor
     */
    public Individuo getPeor() {
        return peor;
    }

    private LinkedList<Individuo> clonarPoblacion(LinkedList<Individuo> individuos) {
        LinkedList<Individuo> aux = new LinkedList<>();
        for (Individuo i:individuos){
         aux.add(new Individuo(i));
        }
        return aux;
    }
    
    
}
