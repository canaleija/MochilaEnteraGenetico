/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaenteragenetico;

import datos.Individuo;
import datos.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    public static void guardar (ArrayList<Item> items, String nombreAchivo){
    File f;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr;
    
        try{
            f=new File(nombreAchivo+".txt");
            w=new FileWriter(f);
            bw=new BufferedWriter (w);
            wr=new PrintWriter(bw);
            String peso=null;
            String valor=null;
            for (int x=0;x<items.size();x++){
                peso=String.valueOf(items.get(x).getPeso());
                valor=String.valueOf(items.get(x).getValor());
                wr.append(peso+","+valor+"\n");
            }
            wr.close();
            bw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ha sucedido un error"+ e);
        } 
        
    }
    
    public static ArrayList<Item> recuperarArticulosMochila() 
    {
        // Declaramos un arreglo de enteros y lo inicializamos
        ArrayList<Item> articulos = new ArrayList<>();
        try 
        {
            // Abrimos una ventana para escoger el archivo
            JFileChooser seleccionArchivo = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Texto", "txt");
            seleccionArchivo.setFileFilter(filtro);
            seleccionArchivo.showOpenDialog(seleccionArchivo);
            // Leemos el archivo
            FileReader fr = new FileReader(seleccionArchivo.getSelectedFile());
            BufferedReader br = new BufferedReader(fr);
            // Recuperamos la linea de texto con los datos de la mochila
            String articulosArchivo;
            String articulosAux[];
            int valor;
            int peso;
            lector: do
            {
                articulosArchivo = br.readLine();
                if(articulosArchivo==null)
                {
                    break;
                }
                // Separamos el texto con el símbolo indicado y lo asignamos a cada variable
                articulosAux = articulosArchivo.split(",");
                valor = Integer.parseInt(articulosAux[0]);
                peso = Integer.parseInt(articulosAux[1]);
                articulos.add(new Item(valor, peso));
            }while(articulosArchivo!=null);
        } 
        catch(FileNotFoundException ex) 
        {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(IOException ex) 
        {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulos;
    }
    
    public static ArrayList<Item> generarItemAleatorio(int cantidad, int rangoP, int rangoV){
        int valor = 0;
        int peso = 0;
        ArrayList<Item> lista = new ArrayList<>();
        
        Random ranV = new Random();
        Random ranP = new Random();
        
        
        for (int x=0; x<cantidad; x++){
            valor = ranV.nextInt(rangoV);
            peso = ranP.nextInt(rangoP);
            Item item = new Item(peso, valor);
            lista.add(item);
        }
     
        return lista;
    }
    
}
