package juego;
import java.awt.Color; 
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
 
public class Torreta {
    Colisiones colisiones; //Variables de instancia
    private double x, y;
    private boolean vivo;
    private double diametro;
    private double bala_x, bala_y;
    private boolean bala_vivo;
    private int temporizador;
    private double bala_diametro;
       
    public Torreta() { //Constructor
        this.x = x;
        this.y = y;
        this.diametro = 30;
        this.vivo = true;
        this.bala_x = x+this.diametro/2;
        this.bala_y = this.y;
        this.bala_diametro = 10;
        this.bala_vivo = true;
        
    }
    
//---------------------------------------------------------------------------------------------
//Metodos del objeto
//----------------------------------------------------------------------------------------------

    
    
    public void dibujarse(Entorno entorno){ //Dibuja torreta        
        Image imgZ1 = Herramientas.cargarImagen("torretaSprite.png");
        entorno.dibujarImagen(imgZ1, x, y, 0, 0.2);
    }
    
    public void dibujarBala(Entorno entorno){        //Dibuja bala
        tiempoBala();     
        entorno.dibujarCirculo(bala_x , bala_y, bala_diametro, Color.ORANGE);
    }
    
    public void crearBala(){ //Mueve la bala
        this.bala_x+=6;
    }
    
    public void tiempoBala(){ //Prepara la bala para que salga aproximadamente cada 4 segundos.
        if (this.temporizador == 380){
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
       
