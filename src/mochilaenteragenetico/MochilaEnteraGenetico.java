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
      ArrayList<Item> lista = Herramientas.generarItemAleatorio(1000, 100, 500);
      Herramientas.guardar(lista,"1000Items");
      
    }
    
}
