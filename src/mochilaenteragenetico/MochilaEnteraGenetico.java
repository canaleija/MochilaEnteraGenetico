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
        ArrayList<Item> l = Herramientas.generarItemAleatorio(10, 10, 20);
        Herramientas.guardar(l);
        Individuo.articulos = l;
        Individuo.capacidadMochila=5;
        Individuo i1 = new Individuo();
        System.out.println(" f:"+i1.getFitness()+" "+i1.isValido());
        System.out.println();
         
        
//      Individuo.articulos = Herramientas.recuperarArticulosMochila();
//      Individuo.capacidadMochila=300000;
//      
//      GeneticoV1 g1 = new GeneticoV1(100, 1000, 0.35);
//      g1.evolucionar();
    }
    
}
