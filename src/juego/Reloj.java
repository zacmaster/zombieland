package juego;
 
public class Reloj {// variables del objeto
    int Minutos;
    int Segundos;
    int SegundosTotales;
    int Contador;
 
    
    public Reloj() { //Constructor  
        this.Minutos = 0;
        this.Segundos = 0;
        this.Contador = 0 ;           
    }
    
//    ----------------------------------------------------------------------------------
//    Getters y Setters
//  ----------------------------------------------------------------------------------    
    public int getSegundosTotales() {
        return SegundosTotales;
    }

    public void setSegundosTotales(int segundosTotales) {
        SegundosTotales = segundosTotales;
    }    
//  ----------------------------------------------------------------------------------
//    Metodos 
//  ----------------------------------------------------------------------------------
    
    public void Sumartiempo(int CounterTick) { //Le da formato al tiempo usando el CounterTick
        if (CounterTick % 100==0){
            Segundos += 1;
            SegundosTotales++;
        }
        if (Segundos == 60){
            Minutos += 1;
            Segundos = 0;
        }
   
    }   

    public String DarTiempo (){ //Devuelve un String con el tiempo
        String Tiempo = "";
        Tiempo += this.Minutos + ":" + this.Segundos;               
        return Tiempo;
    }
   
    public String DarTiempoFaltante(){ //Devuelve el tiempo faltante
        String Tiempo = "";
        int SegundosNew = 0;
        int MinutosNew = 0;
        int segundosfaltantes= 5 *60 - this.Minutos * 60 - this.Segundos;
        while (segundosfaltantes >= 60){
                MinutosNew += 1;
                segundosfaltantes -= 60;
        }
        SegundosNew = segundosfaltantes;
        Tiempo += MinutosNew + ":" + SegundosNew;
       
        return Tiempo;
    }
        
}

