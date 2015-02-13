/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import javax.swing.JTextArea;
import common.Common;
import javax.swing.JButton;
import numcircularesprimos.NumPrimos;

/**
 *
 * @author Rodrigo
 */
public class GeneradorNumerosPrimosCircularesThread extends Thread{
    JTextArea textAreaFramePrincipal;
    JButton jButtonComenzar;
	private boolean terminar;
        
	public GeneradorNumerosPrimosCircularesThread(JTextArea textAreaFramePrincipal, JButton but)
	{
		this.textAreaFramePrincipal = textAreaFramePrincipal;
                this.jButtonComenzar = but;
                terminar = false;
	}

        
    @Override
	public void run()
	{
		
		while (!terminar)
		{
		try{
                 if(!NumPrimos.getTerminoGenerar())
                GeneradorNumerosPrimosCircularesThread.sleep((long)25);
                       
			if (NumPrimos.getListNumPrimos().size()>0) //Hay al menos un número primo a evaluar
			{
			int numero = NumPrimos.getListNumPrimos().get(0);//Número primo a evaluar
			if(Common.esPrimoCircular(numero) == Common.Resultado.ESPRIMOCIRCULAR){
                        			textAreaFramePrincipal.setText(textAreaFramePrincipal.getText() + "\n "+"El número "  + numero + " es primo circular - Sus primos circulares son:"  + Common.getListaCirculares());
                                                NumPrimos.aumentarCantidadPrimosCirculares();
                        }

                        NumPrimos.removeFirst();
			}
                        else{
                     System.out.println(NumPrimos.getTerminoGenerar());
                    if(NumPrimos.getTerminoGenerar()){
                        terminar = true;
                            textAreaFramePrincipal.setText(textAreaFramePrincipal.getText() + "\n \n Se terminó el procesamiento. Se encontraron " + NumPrimos.getCantidadPrimosCirculares() + " números primos circulares.");
                            jButtonComenzar.setEnabled(true);
                    }
                        }
                        

                          
                }
		catch(Exception e){
                 textAreaFramePrincipal.setText("Ha ocurrido el siguiente error: " + e.getMessage());   
                }
             }

	}
}
