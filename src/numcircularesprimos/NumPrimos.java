/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numcircularesprimos;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public abstract class NumPrimos {
    
    private static List<Integer> listNumPrimos = new ArrayList<>(); //Lista que almacena números primos a evaluar
    private static int cantidadPrimosCirculares = 0;
    private static boolean terminoGenerar = false;
    
    public static int getCantidadPrimosCirculares(){
        return cantidadPrimosCirculares;
    }
    public synchronized static boolean getTerminoGenerar(){
        return terminoGenerar;
    }
    
    public static void resetCantidadPrimosCirculares(){
        cantidadPrimosCirculares = 0;
    }
    
   public synchronized static void setTerminoGenerar(boolean term){
        terminoGenerar = term;
    }
        
   public synchronized static void aumentarCantidadPrimosCirculares(){
        cantidadPrimosCirculares++;
    }
         /** Agrega números primos.
          * @param numPrimo numero a agregar.
          */
	public synchronized static void add(int numPrimo)
	{
		listNumPrimos.add(numPrimo);
	}
	
	 /** Agrega números primos.
          */
	public synchronized static void removeFirst ()
	{
		listNumPrimos.remove(0);
	}
        
        public static List<Integer> getListNumPrimos(){
            return listNumPrimos;
        }
}
