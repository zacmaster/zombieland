package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.Herramientas;
 
public class Zombie { //variables del objeto
    private double x;
    private double y;
    private int diametro;
    private double velocidad;
    private boolean vivo; 
    private double nRandom, nRandom2;
    
    public Zombie(){ //Constructor
        this.x = 850;
        this.diametro = 30;
        nRandom = Math.random()*(diametro/2+600-diametro*2)+diametro/2; //Hace un random en un rango para que esté dentro de la pantalla       
        nRandom2 = Math.random()*(100+800)+100; //random desde 100 hasta 800
        this.velocidad= nRandom2*0.00050;
        this.vivo = true;
        this.y = nRandom;
    }
    
//    -----------------------------------------------------------------------------------------------
//    Metodos del objeto
//    -----------------------------------------------------------------------------------------------

    public void avanzar(){ //avanza el zombie de derecha a izquierda      
      this.x-= this.velocidad;        
    }
    
    public void dibujarse(Entorno entorno){ //Dibuja al zombie
        Image imgZombie = Herramientas.cargarImagen("zombie.gif");        
        entorno.dibujarImagen(imgZombie, x, y,0, 0.7);
    }
   
    
//    ------------------------------------------------------------------------------------------------
//    Getters & Setters
//    ------------------------------------------------------------------------------------------------
    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;

    }
}

