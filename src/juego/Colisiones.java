package juego;

import entorno.Entorno;

public class Colisiones { //Esta clase maneja la interacci�n entre los objetos.
    Ingeniero ingeniero;  
    Todo_Arreglos todo_arreglos;
    int contador_muertos;
    int dinero;
    public Colisiones() { //Constructor vacio para llamado de funciones.        
    }
    public Colisiones(Ingeniero ingeniero, Todo_Arreglos todo_Arreglos, Entorno entorno){//Constructor con objetos como parametros
        this.ingeniero = ingeniero;
        this.todo_arreglos = todo_Arreglos;
        contador_muertos = 0;
        this.dinero = 500;
    }
    
//  ------------------------------------------------------------------------------------------------------
//  Metodos de la clase:
//  ------------------------------------------------------------------------------------------------------
    
 // Metodos para comprobar si hay armas debajo

    public boolean torretasDebajo(double x,double y){ //Comprueba si hay torretas debajo
        double radioTorreta = 15;
        for (int i = 0; i < todo_arreglos.getTorretas().length; i++) {
            if (todo_arreglos.getTorretas()[i] != null) {
                if (distanciaObjetoObjeto(x,y,todo_arreglos.getTorretas()[i].getX(),todo_arreglos.getTorretas()[i].getY())<(radioTorreta*2)) {
                    return true;
                }
            }            
        }
        return false;
    }
    
    public boolean torretasLaserDebajo(double x,double y){ //Comprueba si hay torretas laser debajo
        double radioTorreta = 15;
        for (int i = 0; i < todo_arreglos.getTorretasLaser().length; i++) { 
            if (todo_arreglos.getTorretasLaser()[i] != null) {
                if (distanciaObjetoObjeto(x,y,todo_arreglos.getTorretasLaser()[i].getX(),todo_arreglos.getTorretasLaser()[i].getY())<(radioTorreta*2)) {
                    return true;
                }            
            }
        }
        return false;
    }
    
    public boolean minasDebajo(double x , double y ){ //Comprueba si hay minas debajo
        double radioMina = 13;
        for(int i= 0 ; i < todo_arreglos.getMinas().length ; i++){
            if (todo_arreglos.getMinas()[i] != null) {
                if (distanciaObjetoObjeto(x,y,todo_arreglos.getMinas()[i].getX(),todo_arreglos.getMinas()[i].getY())<(radioMina *2)){
                    return true;
                }
            }            
        }
        return false;
    }
    
    
    public boolean robotsDebajo(double x,double y){ //Comprueba si hay un robot debajo
        double radioTorreta = 15;
        for (int i = 0; i < todo_arreglos.getRobots().length; i++) {
            if (todo_arreglos.getRobots()[i] != null) {
                if (distanciaObjetoObjeto(x,y,todo_arreglos.getRobots()[i].getX(),todo_arreglos.getRobots()[i].getY())<(radioTorreta*2)) {
                    return true;
                }
            }            
        }
        return false;
    }
    
// ------------------------------------------------------------------------------------------------
        

    public boolean zombieMataIngeniero(){ //Devuelve true si el zombie toca al ingeniero        
        
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
        	if (todo_arreglos.getZombies()[i]!= null) {			
	            if ((distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY()
	                ,ingeniero.getX(),ingeniero.getY())
	                <= ingeniero.getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){
	            	todo_arreglos.getZombies()[i] = null;
	            	contador_muertos++;
	                return true;	                
	            }
        	}
        }
        
        return false;
    }
    
    public void BalaMataZombie(){ //Si la bala de una torreta toca al zombie, pone al mismo en null
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i]!= null) {
                for (int j = 0; j < todo_arreglos.getTorretas().length; j++) {
                    if (todo_arreglos.getTorretas()[j] != null && todo_arreglos.getZombies()[i] != null ) {
                        if (todo_arreglos.getZombies()[i].isVivo() && todo_arreglos.getTorretas()[j].isVivo() && todo_arreglos.getTorretas()[j].isBala_vivo()) {
                            if (distanciaObjetoObjeto(todo_arreglos.getTorretas()[j].getBala_x(),todo_arreglos.getTorretas()[j].getBala_y(),todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY()) <= todo_arreglos.getTorretas()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2) {
                            	
                                todo_arreglos.getTorretas()[j].setBala_vivo(false);
                                contador_muertos++;
                                todo_arreglos.getZombies()[i] = null;
                                this.dinero += 30;
                            }
                        }
                    }                        
                }    
            }
        }
    }
    
    
    public void BalaRobotMataZombie(){ // Si 
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i]!= null) {
                for (int j = 0; j < todo_arreglos.getRobots().length; j++) {
                    if (todo_arreglos.getRobots()[j] != null && todo_arreglos.getZombies()[i] != null ) {
                        if (todo_arreglos.getZombies()[i].isVivo() && todo_arreglos.getRobots()[j].isVivo() && todo_arreglos.getRobots()[j].isBala_vivo()) {
                            if (distanciaObjetoObjeto(todo_arreglos.getRobots()[j].getBala_x(),todo_arreglos.getRobots()[j].getBala_y(),todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY()) <= todo_arreglos.getRobots()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2) {
                                
                                todo_arreglos.getRobots()[j].setBala_vivo(false);
                                contador_muertos++;
                                todo_arreglos.getZombies()[i] = null;
                                this.dinero += 30;
                            }
                        }
                    }                        
                }    
            }
        }
    }
    public void LaserMataZombie(){ //Si algun zombie es tocado por el laser, lo pone en null
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i]!= null) {
                for (int j = 0; j < todo_arreglos.getTorretasLaser().length; j++) {
                    if (todo_arreglos.getTorretasLaser()[j] != null && todo_arreglos.getZombies()[i] != null) {
                        if (todo_arreglos.getZombies()[i].getX() >= todo_arreglos.getTorretasLaser()[j].getX() && todo_arreglos.getZombies()[i].getX() < 809 ) { //Son 809 es el tamanio de la pantalla+ el radio del zombie
                            if (distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getZombies()[i].getX(),todo_arreglos.getTorretasLaser()[j].getY())<= todo_arreglos.getZombies()[i].getDiametro()/2+todo_arreglos.getTorretasLaser()[j].getDiametro()/2) {
                                
                                todo_arreglos.getZombies()[i] = null;
                                contador_muertos++;
                                this.dinero += 30;
                                
                            }
                        }
                    }
                }
            }            
        }
    }
    
    
    
    
    
    public void zombieChocaMina(){ //Se fija si el zombie toca a la mina
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i]!= null) {
                for (int j = 0; j < todo_arreglos.getMinas().length; j++) {
                    if (todo_arreglos.getZombies()[i] != null) {
                        if ((distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getMinas()[j].getX(),todo_arreglos.getMinas()[j].getY())
                                <= todo_arreglos.getMinas()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){                
                            
                            todo_arreglos.getMinas()[j].setVivo(false);
                            todo_arreglos.getExplosiones()[j].setExplosion_vivo(true);
                            
                            todo_arreglos.getExplosiones()[j].setExplosion_x(todo_arreglos.getMinas()[j].getX());
                            todo_arreglos.getExplosiones()[j].setExplosion_y(todo_arreglos.getMinas()[j].getY());
                            todo_arreglos.getZombies()[i] = null;
                            contador_muertos++;
                            this.dinero += 30;
                                    
                        }
                    }
                }
            }
        } 
    }
    

	public void zombieChocaExplosion(){ //Se fija si el zombie choca alguna explosion
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i]!= null) {
                for (int j = 0; j < todo_arreglos.getExplosiones().length; j++) {  
                	if (todo_arreglos.getExplosiones()[j] != null && todo_arreglos.getZombies()[i] != null) {
                		if ((distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getExplosiones()[j].getExplosion_x(),todo_arreglos.getExplosiones()[j].getExplosion_y())
                                <= todo_arreglos.getExplosiones()[j].getExplosion_diametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){
                            
                            todo_arreglos.getExplosiones()[j].setExplosion_vivo(true);
                            todo_arreglos.getMinas()[j].setX(-500);
                            todo_arreglos.getMinas()[j].setY(-500);                            
                            todo_arreglos.getZombies()[i] = null;
                            contador_muertos++;
                            this.dinero += 30;
                                    
                        }
					}                    
                }
            }
        } 
    }  
    
    public void ExplosionChocaMina(){ //Se fija si alguna explosion alcanza alguna mina
        for (int i = 0; i < todo_arreglos.getExplosiones().length; i++) {
        	if (todo_arreglos.getExplosiones()[i] != null) {
        		for (int j = 0; j < todo_arreglos.getMinas().length; j++) {  
                	if (todo_arreglos.getMinas()[j].isVivo() && todo_arreglos.getExplosiones()[i] != null){              
    	                if ((distanciaObjetoObjeto(todo_arreglos.getExplosiones()[i].getExplosion_x(),todo_arreglos.getExplosiones()[i].getExplosion_y(),todo_arreglos.getMinas()[j].getX(),todo_arreglos.getMinas()[j].getY())
    	                <= todo_arreglos.getMinas()[j].getDiametro()/2+todo_arreglos.getExplosiones()[i].getExplosion_diametro()/2)){                
    	                    
    	                    todo_arreglos.getMinas()[j].setVivo(false);
    	                    todo_arreglos.getExplosiones()[j].setExplosion_vivo(true);
    	                    todo_arreglos.getExplosiones()[j].setExplosion_x(todo_arreglos.getMinas()[j].getX());
    	                    todo_arreglos.getExplosiones()[j].setExplosion_y(todo_arreglos.getMinas()[j].getY());
    	                    todo_arreglos.getMinas()[i].setX(-500);
    	                    todo_arreglos.getMinas()[i].setY(-500);
    	                    
    	                    todo_arreglos.getExplosiones()[i].setExplosion_vivo(true);
    	                            
    	                }
                	}
                }
			}            
        } 
    }
    
    
    public boolean ExplosionMataIngeniero(){ //Devuelve true la explosion toca al ingeniero        
        
        for (int i = 0; i < todo_arreglos.getExplosiones().length; i++) {
        	if (todo_arreglos.getExplosiones()[i] != null) {
        		if ((distanciaObjetoObjeto(todo_arreglos.getExplosiones()[i].getExplosion_x(),todo_arreglos.getExplosiones()[i].getExplosion_y()
                        ,ingeniero.getX(),ingeniero.getY())
                        <= ingeniero.getDiametro()/2+todo_arreglos.getExplosiones()[i].getExplosion_diametro()/2)){
                    	ingeniero.setVivo(false);
                    	return true;
                }
			}            
        }
        return false;
    }
    
    
    
    
    
    public void zombieChocaTorreta(){ // Se fija si el zombie choca a la torreta
        for (int i = 0; i < todo_arreglos.getZombies().length; i++){
            if (todo_arreglos.getZombies()[i] != null) {
                for (int j = 0; j < todo_arreglos.getTorretas().length; j++) { 
                    if (todo_arreglos.getTorretas()[j] != null) {
                        if (distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getTorretas()[j].getX(),todo_arreglos.getTorretas()[j].getY())
                                <= (todo_arreglos.getTorretas()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){                
                                    
                                    todo_arreglos.getTorretas()[j] = null;                                    
                                    todo_arreglos.getZombies()[i] = null;
                                    
                                    contador_muertos++;
                        }
                    }
                }
            }
        } 
    }
    
    public void zombieChocaTorretaLaser(){ //Se fija si el zombie choca a la torreta laser 
        for (int i = 0; i < todo_arreglos.getZombies().length; i++) {
            if (todo_arreglos.getZombies()[i] != null) {
                for (int j = 0; j < todo_arreglos.getTorretasLaser().length; j++) {  
                    if (todo_arreglos.getTorretasLaser()[j] != null) {
                        if (distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getTorretasLaser()[j].getX(),todo_arreglos.getTorretasLaser()[j].getY())
                                <= (todo_arreglos.getTorretasLaser()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){                
                                    
                                    todo_arreglos.getTorretasLaser()[j] = null;
                                    todo_arreglos.getZombies()[i] = null;                                    
                                    contador_muertos++;                                           
                        }                
                    }
                }
            }            
        } 
    }
    
    public void zombieChocaRobot(){ // Se fija si el zombie choca al robot
        for (int i = 0; i < todo_arreglos.getZombies().length; i++){
            if (todo_arreglos.getZombies()[i] != null) {
                for (int j = 0; j < todo_arreglos.getRobots().length; j++) { 
                    if (todo_arreglos.getRobots()[j] != null && todo_arreglos.getZombies()[i] != null) {
                        if (distanciaObjetoObjeto(todo_arreglos.getZombies()[i].getX(),todo_arreglos.getZombies()[i].getY(),todo_arreglos.getRobots()[j].getX(),todo_arreglos.getRobots()[j].getY())
                                <= (todo_arreglos.getRobots()[j].getDiametro()/2+todo_arreglos.getZombies()[i].getDiametro()/2)){                
                                    
                                    todo_arreglos.getZombies()[i] = null;
                                    contador_muertos++;
                                            
                        }
                    }                    
                }
            }
        }
    }
    
//    ------------------------------------------------------------------------------------
//    Metodo de clase, devuelve la distancia entre 2 objetos
//    -------------------------------------------------------------------------------------
    
    static double distanciaObjetoObjeto(double x1,double y1,double x2, double y2){
        double distancia;
        distancia = Math.pow((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)), 0.5);
        return distancia;
    }
    
//    ----------------------------------------------------------------------------------------------
//    Getters y Setters
//    ----------------------------------------------------------------------------------------------
    
    public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}	
	public int getContador_muertos() {
        return contador_muertos;
    }
    public void setContador_muertos(int contador_muertos) {
        this.contador_muertos = contador_muertos;
    }
          
}