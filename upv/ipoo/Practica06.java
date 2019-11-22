package edu.upv.ipoo;
import java.util.Scanner;
/**
 *
 * @author Armando Rodriguez Hdz
 */
public class Practica06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        
        System.out.print("Ingrese la fecha: ");
        String f1Str = in.nextLine();
            
        
       // while(!f1Str.equals("")){
            
            Fecha f1 = Fecha.leerFormato(f1Str);
            
            if(f1 != null){
                System.out.printf("La fecha ingresada en formato largo es: %s \n",f1.formatoLargo());
                
                System.out.printf("La fecha ingresada en formato corto: %s \n",f1.formatoCorto());       
                
                Fecha f1Mañana = f1.mañana();
                System.out.printf("El dia de mañana sera: %s \n", f1Mañana.formatoLargo());
        
                Fecha f1Ayer = f1.ayer();
                System.out.printf("El dia de ayer fue: %s \n", f1Ayer.formatoLargo());
            }else{
                System.out.println("La fecha ingresada no es valida!");
            }
            
       //3 }
        
       // System.out.print("Ingrese la fecha: ");
     //   f1Str = in.nextLine();
    
    
        
        
        
    }
    
}
