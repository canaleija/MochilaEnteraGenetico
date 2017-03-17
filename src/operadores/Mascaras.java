/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Mascaras {
   
    public static int[] generarMascaraMitadYMitad(int longitud){
     int[] mascara = new int[longitud];
    int mitad = longitud/2;
    for (int x=0;x<mitad;x++)
        mascara[x]=1;
    
      return mascara;
    }
    
    public static int[] generarMascaraUnoYUno(int longitud){
     int[] mascara = new int[longitud];
    for (int x=0;x<longitud;x=x+2)
        mascara[x]=1;
     return mascara;
    }
    
    public static int[] generarMascaraAleatoria(int longitud){
     int[] mascara = new int[longitud];
   Random ran = new Random();
     for (int x=0;x<longitud;x++)
        mascara[x]=ran.nextInt(2);
     return mascara;
    }
}
