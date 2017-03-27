/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaenteragenetico;

import datos.Individuo;
import datos.Item;
import datos.Poblacion;
import java.util.ArrayList;
import operadores.Mascaras;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MochilaEnteraGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Item> l = Herramientas.recuperarArticulosMochila();
     
        Individuo.articulos = l;
        Individuo.capacidadMochila=24698;
        int suma =0;
        int sumaP = 0;
        for (Item it:Individuo.articulos){
           suma+=it.getValor();
           sumaP+=it.getPeso();
        }
        System.out.println("Suma valores art: "+ suma);
        System.out.println("Suma pesos art: "+ sumaP);
        
        GeneticoV1 g1 = new GeneticoV1(70, 100000, 0.35);
        g1.evolucionar();
        
        
        System.out.println();
         
        
//      Individuo.articulos = Herramientas.recuperarArticulosMochila();
//      Individuo.capacidadMochila=300000;
//      
//      GeneticoV1 g1 = new GeneticoV1(100, 1000, 0.35);
//      g1.evolucionar();
    }
    
}
