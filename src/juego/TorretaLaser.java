package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Herramientas;
import entorno.Entorno;

public class TorretaLaser { //variables de la clase
    
    private double x, y;
    private boolean vivo;
    private double diametro;
    private double laser_x, laser_y;
    private double laser_ancho;
    private double laser_alto;
    private boolean laser_vivo;
    private int temporizador;
    
    public TorretaLaser() {// Constructor
        this.x = -150;
        this.y = -150;
        this.vivo = false;
        this.diametro = 30;       
        this.laser_y = this.y;
        this.laser_ancho = 800-x;
        this.laser_x = this.x;
        this.laser_alto = 20;
        this.laser_vivo = false;
    }
    
//    ------------------------------------------------------------------------------------------------------
//    Metodos de la clase:
//    ----------------------------------------------------------------------------------------------
        public void dibujarse(Entorno entorno){ //Dibuja la torreta laser
            Image imagen;
            imagen = Herramientas.cargarImagen("torretaLaserSprite.png");
            entorno.dibujarImagen(imagen, x, y,0, 0.2);
            
        }
        public void dibujarLaser(Entorno entorno){ // Dibuja el laser
            if (this.temporizador < 30 ) {
                this.laser_vivo = true;
                laser_ancho = 800-x;
                entorno.dibujarRectangulo(laser_x +(0.5*this.laser_ancho), laser_y , laser_ancho  , laser_alto, 0, Color.red);
                this.temporizador++;        
            }
        else{
            this.laser_vivo = false;
            if (this.temporizador == 3000) { // Dispara el laser cada 30 segundos
                this.temporizador = 0;
                
            }
            temporizador++;
        }
    }
    
    
    
//  ----------------------------------------------------------------------------------------------------
//  getters y setters
//----------------------------------------------------------------------------------------------------    
  
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
	
	  public double getDiametro() {
	      return diametro;
	  }
	
	  public void setDiametro(double diametro) {
	      this.diametro = diametro;
	  }
	
	  public double getLaser_x() {
	      return laser_x;
	  }
	
	  public void setLaser_x(double laser_x) {
	      this.laser_x = laser_x;
	  }
	
	  public double getLaser_y() {
	      return laser_y;
	  }
	
	  public void setLaser_y(double laser_y) {
	      this.laser_y = laser_y;
	  }
	
	  public double getLaser_ancho() {
	      return laser_ancho;
	  }
	
	  public void setLaser_ancho(double laser_ancho) {
	      this.laser_ancho = laser_ancho;
	  }
	
	  public double getLaser_alto() {
	      return laser_alto;
	  }
	
	  public void setLaser_alto(double laser_alto) {
	      this.laser_alto = laser_alto;
	  }
	
	  public boolean isLaser_vivo() {
	      return laser_vivo;
	  }
	
	  public void setLaser_vivo(boolean laser_vivo) {
	      this.laser_vivo = laser_vivo;
	  }
	
	  public int getTemporizador() {
	      return temporizador;
	  }
	
	  public void setTemporizador(int temporizador) {
	      this.temporizador = temporizador;
	  }
    

}
