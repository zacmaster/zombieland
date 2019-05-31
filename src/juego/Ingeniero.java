package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.*;
import entorno.Entorno;
import entorno.Herramientas;

@SuppressWarnings("unused")

public class Ingeniero {
    Todo_Arreglos todo_arreglos;
    
    private double x; //variables del objeto
    private double y;   
    private double angulo;
    private double diametro;
    private Color color;    
    private double velocidad;
    private int vidas;
    private boolean vivo;
    private boolean creaTorreta;    
    private boolean creaTorretaLaser;
    private boolean creaMina;
    private boolean creaRobot;
    
    
    Ingeniero(){ // Constructor
        this.x = 15;
        this.y = 300;
        this.angulo = 0;
        this.diametro = 40;
        this.color = Color.BLUE;
        this.vivo = true;
        this.creaTorreta = false;
        this.creaMina = false ;
        this.creaRobot = false ;
        this.vidas = 3;
     }    
//  ------------------------------------------------------------------------------------------------------
//  Metodos del objeto:
//  ----------------------------------------------------------------------------------------------    
    public void moverDerecha(){ //Movimiento del personaje,mediante modificacion de coordenadas
        x+=2;
    }
    public void moverIzquierda(){
        x-=2;        
    }
    public void moverArriba(){
        y-=2;
    }
    public void moverAbajo(){
        y+=2;
    }
    public void dibujarse(Entorno entorno){ // Dibujarlo en pantalla
        Image imagen = Herramientas.cargarImagen("ingeniero.gif");
        entorno.dibujarImagen(imagen, x, y, 0, 0.4);
        if (this.vivo == true ){
            if (entorno.estaPresionada('1')){ // Con la tecla 1 se crea la torreta                
                this.creaTorreta = true;
            }    
        
            if (entorno.estaPresionada('2')){  // Con la tecla 2 se crea la torretalaser
                this.creaTorretaLaser = true ;            
            }
            
            if (entorno.estaPresionada('3')){// Con la tecla 3 se crea la mina                
                this.creaMina = true ;
            
            }
            
            if (entorno.estaPresionada('4')){ //// Con la tecla 4 se crea el robot                
                this.creaRobot = true ;
            
            }
        }
        
        if (entorno.estaPresionada(entorno.TECLA_DERECHA)){ //Uso de las teclas de dirección y sus respectivas restricciones
            if (this.x>=(800-(diametro/2))){
                this.x=(800-(diametro/2));
            }
            moverDerecha();
        }
        if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)){
            if (this.x<=((diametro/2))){
                this.x=(diametro/2);
            }
            moverIzquierda();
        }
        if (entorno.estaPresionada(entorno.TECLA_ARRIBA)){
            if (this.y<=(diametro/2)){
                this.y=(diametro/2);
            }
            moverArriba();
        }
        if (entorno.estaPresionada(entorno.TECLA_ABAJO)){
            if (this.y>=(600-this.diametro)){
                this.y=(600-this.diametro);
            }
            moverAbajo();
        }
    }
    
    
    
//  ----------------------------------------------------------------------------------------------------
//  getters y setters
//----------------------------------------------------------------------------------------------------        
    
    public boolean isCreaTorretaLaser() {
        return creaTorretaLaser;
    }

    public void setCreaTorretaLaser(boolean creaTorretaLaser) {
        this.creaTorretaLaser = creaTorretaLaser;
    }    
    
    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
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
    
    public boolean isCreaMina() {
        return creaMina;
    }

    public void setCreaMina(boolean creaMina) {
        this.creaMina = creaMina;
    }

    public boolean isCreaTorreta() {
        return creaTorreta;
    }

    public void setCreaTorreta(boolean creaTorreta) {
        this.creaTorreta = creaTorreta;
    }
    
    public boolean isCreaRobot() {
        return creaRobot;
    }

    public void setCreaRobot(boolean creaRobot) {
        this.creaRobot = creaRobot;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
}
