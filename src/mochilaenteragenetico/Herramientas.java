/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaenteragenetico;

import datos.Individuo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    
    public static boolean validarIndividuo(Individuo ind){
        int capacidad = Individuo.capacidadMochila;
        if (ind.getPeso()<=capacidad){
        return true;
        }
        return false;
    }
    
}
