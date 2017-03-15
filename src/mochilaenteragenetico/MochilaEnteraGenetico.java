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

/**
 *
 * @author Roberto Cruz Leija
 */
public class MochilaEnteraGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Item i1 = new Item(23, 1500);
       Item i2 = new Item(11, 500);
       Item i3 = new Item(5, 15000);
        ArrayList<Item> lista = new ArrayList<>();
        lista.add(i1);
        lista.add(i2);
        lista.add(i3);
       Individuo.capacidadMochila = 28;
       Individuo.articulos = lista;
       
       Poblacion p = new Poblacion(3);
       boolean valido = Herramientas.validarIndividuo(p.getIndividuos().get(1));
       System.out.println();
    }
    
}
