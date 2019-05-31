package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
@SuppressWarnings("unused") 
public class Explosion {

    private double x, y; //variables del metodo
    private boolean vivo;
    private double diametro;
    private boolean explota;
    private boolean explota_vivo;
    private int temporizador;
    
    public Explosion(){ //Constructor
        this.x = -500; 
        this.y = -500;
        this.diametro = 150;
        this.vivo = false;
    }

        
//  ------------------------------------------------------------------------------------------------------
//  Metodos de la clase:
//  ------------------------------------------------------------------------------------------------------ 
    
    
    public void dibujarse(Entorno entorno, Mina mina){ //Dibuja explosion
        if (isExplosion_vivo()){
            if (temporizador<10){            
            Image imagen = Herramientas.cargarImagen("boom.png");
            entorno.dibujarImagen(imagen, x, y,0, 2.5);
            temporizador ++;
            }
            else 
            {vivo = false;
            this.x=-300;
            this.y=-300;
            mina.setX(-500);
            mina.setY(-500);
            temporizador=0;
            
            }
        }
    }
       
    
    
//  ----------------------------------------------------------------------------------------------------
//  getters y setters
//----------------------------------------------------------------------------------------------------                               
    public boolean getExplota(){ //devuelve estado de la mina
        return this.explota;
    }
    public void setExplota(Boolean explota){ //cambia estado  y la borra (la pone en un lugar no visible)
        this.explota = explota;
    }
    public double getExplosion_x() {
        return x;
    }
    public void setExplosion_x(double x) {
        this.x = x;
    }        
    public double getExplosion_y() {
        return this.y;
    }
    public void setExplosion_y(double Explosion_y) {
        y = Explosion_y;
    }
    public double getExplosion_diametro() {
        return this.diametro;
    }
    public void setExplosion_diametro(double mina_Explosion) {
        this.diametro = mina_Explosion;
    }
    public boolean isExplosion_vivo() {
        return this.vivo;
    }
    public void setExplosion_vivo(boolean Explosion_vivo) {
        this.vivo = Explosion_vivo;
    }

}