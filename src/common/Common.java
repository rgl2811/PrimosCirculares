
package common;
import static java.lang.Math.*;  

/**
 *
 * @author Rodrigo
 */
public abstract class Common {
   
    
  public static enum Resultado{
    ESPRIMOCIRCULAR,
    NUMEROUNACIFRA,
    NUMERONOPRIMO,
    NUMERONOPRIMOCIRCULAR,
    ESPRIMO
    }
  
  private static String listaCirculares = "";
    
  // public static Resultado res;
   
   public static String getListaCirculares(){
       return listaCirculares;
   }
    
    	public static Resultado esPrimo(int numero)
	{
		int cantDiv = 0,raiz;
			if (numero > 1)//0 y 1 no son considerados números primos
			{
				raiz=(int)sqrt(numero);//Obtener la raíz cuadrada del número
				
				for (int indice = 1 ; indice<=raiz ; indice++) 
				{ 
				   if (numero%indice==0) //Si el resto es 0, entonces es divisor
				   cantDiv++;
				}
				if (cantDiv == 1 ) //Es divisible sólo por 1, y por si mismo, por lo tanto es primo
				{
					return Resultado.ESPRIMO;
				}
			}
         return Resultado.NUMERONOPRIMO;
	}
        
public static Resultado esPrimoCircular(int numero){
    
          if((int)(log10(numero)+1) > 1){ //No se puede rotar un número que contenga una sola cifra
              String numeroCircular = String.valueOf(numero);//convierto el numero a string para poder rotarlo
              listaCirculares = "";
            for(int indice = 0; indice <= numeroCircular.length()-2;indice++)
	        {
                numeroCircular = numeroCircular.charAt(numeroCircular.length()-1)+ numeroCircular.substring(0,numeroCircular.length()-1);//Se rota el número de a una cifra por vez         
	            
                if(esPrimo(Integer.parseInt(numeroCircular)) == Resultado.NUMERONOPRIMO){
                    
                    return Resultado.NUMERONOPRIMOCIRCULAR;
                }
                
                listaCirculares += numeroCircular;
                if(indice < numeroCircular.length() -2){
                listaCirculares += ", ";
                }
	        }

                return Resultado.ESPRIMOCIRCULAR;   
            }else{
            return Resultado.NUMEROUNACIFRA;
          }
    
}

}
