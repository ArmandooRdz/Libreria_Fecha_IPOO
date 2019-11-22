package edu.upv.ipoo;


/**
 *
 * @author Armando Rodriguez Hdz
 */
public class Fecha {
    
    public int dia;
    public int mes;
    public int año;
    
    /**
     *   Obtiene una instancia de fecha segun el formato dd/mm/yyyy, 
     *   En caso de no ser una fecha valida, regresa null..
     * @param f   formato valido ej: 27/09/2018
     * @return    Una instancia de un tipo fecha. Null si es una fecha invalida....
     */
    
    
    
    
    public static Fecha leerFormato(String f){
        
        String[] fSplit = f.split("\\/");
        
        if(fSplit.length < 3) return null;
        
        Fecha fecha = new Fecha();
        fecha.dia = Integer.parseInt(fSplit[0]);
        fecha.mes = Integer.parseInt(fSplit[1]);
        fecha.año = Integer.parseInt(fSplit[2]);
        
        if(!esFechaValida(fecha.dia, fecha.mes, fecha.año)) return null;
        
        return fecha;
    }
    
    public static Boolean esFechaValida(int dia, int mes, int año){
        // Validaciones de fecha:
        if(mes < 1 || mes > 12)return false;
        if(dia < 1)return false;
        if(dia > 31) return false;
        if(mes == 2 && !esAñoBisiesto(año) && dia > 28) return false;
        if(mes == 2 && esAñoBisiesto(año) && dia > 29) return false;
        // las otras condiciones para los dias de los meses restantes.
        return true;
    }
    
    
    public static Boolean esAñoBisiesto(int año){
        // calcular año bisiesto..
         return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
    }
    
    /**
     * obtiene la presentacion de la fecha actual en el formato dd/MM/yyyy.
     * @return 
     */
    public String formatoCorto(){
        return String.format("%02d/%02d/%04d", dia,mes,año);
    }
    
    /**
     * Obtiene la representacion de la fecha actual en formato dd/Mes/yyy.
     * @return 
     */
    
    public String formatoLargo(){
        String mesStr = "";
        switch (mes){
            case 1:
                mesStr = "Enero"; 
                break;     
            case 2:
                mesStr = "Febrero";
                break;
            case 3: 
                mesStr = "Marzo";
                break;
            case 4:
                mesStr = "Abril";
                break;
            case 5:
                mesStr = "Mayo";
                break;
            case 6:
                mesStr = "Junio";
                break;
            case 7:
                mesStr = "Julio";
                break;
            case 8:
                mesStr = "Agosto";
                break;   
            case 9:
                mesStr = "Septiembre";
                break;    
            case 10:
                mesStr = "Octubre";
                break;
            case 11:
                mesStr = "Noviembre";
                break;
            case 12:
                mesStr = "Diciembre";
                break;            
        }   
        return String.format("%02d/%s/%04d",dia,mesStr,año);
    }
    
    
    /**
     * Obtiene la instancia de tipo Fecha que representa la fecha del dia siguiente de 
     * la fecha actual.
     * @return 
     */
    public Fecha mañana(){
        // aqui se debe crear el objeto de tipo Fecha es lo que esta funcion retornará.
         
        Fecha fecha = new Fecha();
        fecha.dia = dia;
        fecha.mes = mes;
        fecha.año = año;
        
        
        if(fecha.dia == 31){
            if(fecha.mes == 1 || fecha.mes == 3 || fecha.mes == 5 || fecha.mes == 7 || fecha.mes == 8 || fecha.mes == 10){
                fecha.dia = 1;
                fecha.mes = mes++;
            }else if(fecha.mes ==  12){
                fecha.dia = 1;
                fecha.mes = 1;
                fecha.año++;
            }
        }else if((fecha.mes == 2) && (fecha.dia == 29)){
           fecha.dia = 1;
           fecha.mes++;
        }else{
            fecha.dia++;
        }
        
        return fecha;
    }
    /**
     * Obtiene la instancia de tipo Fecha que representa la fecha del dia anterior de 
     * la fecha actual.
     * @return 
     */
    public Fecha ayer(){
       
        Fecha fecha = new Fecha();
        fecha.dia = dia;
        fecha.mes = mes;
        fecha.año = año;
        
       
        if(fecha.dia == 1){
            if(fecha.mes == 2 || fecha.mes == 4 || fecha.mes == 6 || fecha.mes == 9 || fecha.mes == 11 || fecha.mes == 1){
                if(fecha.mes == 1){
                    fecha.dia = 31;
                    fecha.mes--;
                    fecha.año--;
                }else{
                    fecha.dia = 31;
                    fecha.mes--;
                }
            }
        }if(fecha.mes == 3){
            if((fecha.año % 4 == 0 && fecha.año % 100 != 0) || fecha.año % 400 == 0){
               fecha.dia = 29;
               fecha.mes--;
            }else{
                fecha.dia = 28;
                fecha.mes--;
            }
        }else{
            fecha.dia--;
        }
        
        return fecha;
    }
    
    
    
    
}
