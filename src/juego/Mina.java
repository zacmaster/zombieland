package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
 
public class Mina {

    Colisiones colisiones; //variables del metodo
    private double x, y;
    private boolean vivo;
    private double diametro;
    
    public Mina(){ //Constructor
        this.x = -500; 
        this.y = -500;
        this.diametro = 30;
        this.vivo = false;            
    }
     
//  ------------------------------------------------------------------------------------------------------
//  Metodos de la clase:
//  ------------------------------------------------------------------------------------------------------ 
    
    public void dibujarse(Entorno entorno){ //Dibuja la mina
        Image imagen;
        imagen = Herramientas.cargarImagen("Mina.png");
        entorno.dibujarImagen(imagen, x, y,0, 0.3);
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
     
}