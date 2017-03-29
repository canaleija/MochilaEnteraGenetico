/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import mochilaenteragenetico.GeneticoV1;

/**
 *
 * @author Roberto Cruz Leija
 */
public class OrganoGestor extends Thread{
    
    GeneticoV1 gen;

    public OrganoGestor(GeneticoV1 gen) {
        this.gen = gen;
    }
    public void ejecutar(){
     this.start();
    }
    
    
    
    
}
