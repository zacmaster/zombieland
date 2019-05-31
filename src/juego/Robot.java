package juego;
import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Robot {
                        
    private double x, y; //Variables de instancia
    private boolean vivo;
    private double diametro;
    private double bala_x, bala_y;
    private boolean bala_vivo;
    private int temporizador;
    private double bala_diametro;
    private double velocidad;
       
    public Robot() { //Constructor del robot
        this.x = x;
        this.y = y;
        this.diametro = 30;
        this.vivo = true;
        this.bala_x = x+this.diametro/2;
        this.bala_y = this.y;
        this.bala_diametro = 10;
        this.bala_vivo = true;
        this.velocidad= 0.5;       
        
    }
    
    
    
//  ------------------------------------------------------------------------------------------------------
//  Metodos de la clase:
//  ------------------------------------------------------------------------------------------------------    
    
    public void dibujarse(Entorno entorno){ //Dibuja al robot
        Image imagen = Herramientas.cargarImagen("r2d2.png");
        entorno.dibujarImagen(imagen, x, y, 0, .4);
    }
    
    public void dibujarBala(Entorno entorno){        //Dibuja bala
        tiempoBala();     
        entorno.dibujarCirculo(bala_x , bala_y, bala_diametro, Color.blue);
    }
    
    public void crearBala(){ //Mueve la bala
        this.bala_x+=6;
    }
    
    public void tiempoBala(){ //Prepara la bala para que salga con mucha frecuencia.
        if (this.temporizador == 50){
            this.bala_vivo = true;
            this.temporizador = 0;            
        }
        if (bala_vivo){
            if (this.temporizador>0){
                crearBala();
            }
            if (this.bala_x > 800) {
                this.bala_x = x;
                this.bala_vivo = false;
            }                       
        }
        else{
            bala_x = x;            
        }
        this.temporizador++;
    }
    
    public void avanzar(){ // Hace avanzar al robot
            this.x+= this.velocidad;
    }
    
    
    
//  ----------------------------------------------------------------------------------------------------
//  getters y setters
//----------------------------------------------------------------------------------------------------    
    
    public double getBala_x() {
        return bala_x;
    }
    public void setBala_x(double bala_x) {
        this.bala_x = bala_x;
    }
    public double getBala_y() {
        return bala_y;
    }
    public void setBala_y(double bala_y) {
        this.bala_y = bala_y;
    }
    public double getBala_diametro() {
        return bala_diametro;
    }
    public void setBala_diametro(double bala_diametro) {
        this.bala_diametro = bala_diametro;
    }
    public boolean isBala_vivo() {
        return bala_vivo;
    }
    public void setBala_vivo(boolean bala_vivo) {

        this.bala_vivo = bala_vivo;
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
    public double getDiametro() {
        return diametro;
    }
    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
    
    
}
       

