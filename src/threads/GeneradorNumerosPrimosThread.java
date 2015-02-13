/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import common.Common;
import numcircularesprimos.NumPrimos;

/**
 *
 * @author Rodrigo
 */
public class GeneradorNumerosPrimosThread extends Thread{
    private int topeIteracion;
    public void setTopeIteracion(int topeIteracion){
        this.topeIteracion = topeIteracion;   
    }
   
    
    @Override
    	public void run()
	{
                while(!NumPrimos.getTerminoGenerar()){
               try{    
                 
                GeneradorNumerosPrimosThread.sleep((long)20);
                
		for (int indice=0;indice<=this.topeIteracion;indice++) //Itera de 0 al número elegido como tope
		{
			if(Common.esPrimo(indice) == Common.Resultado.ESPRIMO)
			{
				NumPrimos.add(indice);
			}
                }
               
                NumPrimos.setTerminoGenerar(true);
            }catch(Exception e){
                //no deberia entrar aca 
            }
                }

        }
}
