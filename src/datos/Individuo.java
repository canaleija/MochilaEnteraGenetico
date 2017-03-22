/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import java.util.Random;
import mochilaenteragenetico.Herramientas;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    // atributos clase 
    public static ArrayList<Item> articulos;
    public static int capacidadMochila;
    // atributos instancia 
    private int[] genotipo;
    private int fitness;
    private int peso;
   
    // aleatoria 
    public Individuo() {
        
        do{
        this.genotipo = new int[articulos.size()];
        // validación individuo
        generarDeFormaAleatoria();
        calculaFitnessyPeso();
        }while(!this.isValido());
       
      
    }
     public Individuo(int geno[]) {
        this.genotipo =  geno.clone();
       
        calculaFitnessyPeso();
      
    }
    
    public Individuo (Individuo ind){
        this.genotipo = ind.getGenotipo().clone();
        this.fitness = ind.getFitness();
        this.peso = ind.getPeso();
    }

    private void generarDeFormaAleatoria() {
        Random ran = new Random();
        for (int x=0; x < getGenotipo().length;x++)
            genotipo[x]=ran.nextInt(2);
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }
    
    public void calculaFitnessyPeso(){
        this.fitness = 0;
        this.peso = 0;
        // recorremos el genotipo junto con la lista de articulos
        for (int x=0; x < genotipo.length;x++){
            // si esta en la lista acumulamos
            if (genotipo[x]==1){
            this.fitness+=articulos.get(x).getValor();
            this.peso+=articulos.get(x).getPeso();
            }            
        }
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }
    
    public boolean isValido(){
    
    return Herramientas.validarIndividuo(this);
    }
    
}
