package juego;
import entorno.Entorno;
public class Todo_Arreglos { //Declaro las variables de clase
    private Zombie[] zombies; 
    private Torreta[] torretas;
    private TorretaLaser[] torretasLaser;
    private Mina[] minas;
    private Explosion[] explosiones;
    private Robot[] robots;
    
    
    
    public Todo_Arreglos() { //Constructor, vacío pues sólo sirve para llamar a los métodos.
    }
    

//  ------------------------------------------------------------------------------------------------------
//  Metodos de la clase:
//  ------------------------------------------------------------------------------------------------------ 

// ------------ Metodos de Zombies-------------------------------    
    
    public void Arr_Zombie(int cantidad) { //Crea un arreglo de zombies en null
        this.zombies = new Zombie[cantidad];        
        for(int i=0;i<cantidad;i++){
            zombies[i]= null;            
        }        
    }
    
    public void dibujarZombie(Entorno entorno){ //Dibuja los zombies que no est�n en null
        for (int i = 0; i < zombies.length; i++) {
        	if (zombies[i] != null) {
        		if (zombies[i].isVivo() == true) {
                    zombies[i].dibujarse(entorno);
        		}           
            }            
        }
    }
    
    public void avanzarZombie(){ //Hace avanzar a los zombies vivos        
        for (int i = 0; i < zombies.length; i++) {
        	if (zombies[i]!= null) {
        		zombies[i].avanzar();
			}            
        }
    }
    
    public boolean zombieLlega(){ // Metodo que devuelve true si un zombie llega a la casa del ingeniero       
        for (int i = 0; i < zombies.length; i++) {
            if (zombies[i]!= null) {                
                if (zombies[i].getX() <= 10) {
                    zombies[i] = null;
                    return true;
                }
            }
        }
        return false;       
    }
    
    
    public int ZombiePorSegundo(int counterTick, int punteroZombie){ //Programa la aparicion de un zombie por segundo
        if (counterTick % 100 == 0 && punteroZombie < zombies.length) {
                zombies[punteroZombie] = new Zombie();
                punteroZombie++;
        }
        return punteroZombie;
    }
    
    public void TiemposZombie(int counterTick){ //Metodo que recibe un contador de ticks y programa la salida por oleadas.
    	switch (counterTick) {    	
    		case 10*100:  for (int i = 0; i < 10; i++) { //Crea 10 zombies a los 10 segundos.
    		            zombies[i] = new Zombie();
	                    }
				        break;
    		
    		case 20*100:   for (int i = 10 ; i < 30; i++) { //Crea 20 zombies a los 20 segundos.
		                  zombies[i] = new Zombie();
			              }
    		             break;
    		             
    		case 40*100:   for (int i = 30 ; i < 50; i++) { //Crea 20 zombies a los 40 segundos.
                zombies[i] = new Zombie();
                }
               break;
               
    		case 70*100:   for (int i = 50 ; i < 80; i++) { //Crea 30 zombies a los 70 segundos.
                zombies[i] = new Zombie();
                }
               break;
    		 
    		case 80*100:   for (int i = 80 ; i < 110; i++) { //Crea 30 zombies a los 80 segundos.
    		    zombies[i] = new Zombie();
    		    }
               break;
               
    		case 100*100:   for (int i = 110 ; i < 140; i++) { //Crea 30 zombies a los 100 segundos.
                zombies[i] = new Zombie();
                }
               break;
               
    		case 140*100:   for (int i = 140 ; i < 170; i++) { //Crea 30 zombies a los 140 segundos.
                zombies[i] = new Zombie();
                }
    		    break;
    		    
    		case 150*100:   for (int i = 170 ; i < 210; i++) { //Crea 40 zombies a los 150 segundos. 
                zombies[i] = new Zombie();
                }
               break;
               
    		case 170*100:   for (int i = 210 ; i < 240; i++) { //Crea 30 zombies a los 170 segundos.
                zombies[i] = new Zombie();
                }
               break;
               
    		case 200*100:   for (int i = 240 ; i < 270; i++) { //Crea 30 zombies a los 200 segundos.235
                zombies[i] = new Zombie();
                }
               break;
               
    		case 220*100:   for (int i = 270 ; i < 300; i++) { //Crea  30 zombies a los 220 segundos.285
                zombies[i] = new Zombie();
                }
               break;
               
    		case 240*100:   for (int i = 300 ; i < 360; i++) { //Crea 60 zombies a los 240 segundos.305
                zombies[i] = new Zombie();
                }
               break;
               
    		case 270*100:   for (int i = 360 ; i < 390; i++) { //Crea 30 zombies a los 270 segundos.
                zombies[i] = new Zombie();
                }
               break;
               
    		case 280*100:   for (int i = 390 ; i < 400; i++) { //Crea 10 zombies a los 280 segundos.
                zombies[i] = new Zombie();
                }
               break;
               
    	}
    }

        
    
// ------------ Metodos de Torretas-------------------------------        
        
    public void Arr_Torreta(int cantidad) { //Crea un arreglo de torretas en null        
        this.torretas = new Torreta[cantidad];        
        for(int i=0;i<cantidad;i++){
            torretas[i]= null;            
        }
    }
    public void Arr_TorretaLaser(int cantidad) { //Crea un arreglo de torretas laser en null       
        this.torretasLaser = new TorretaLaser[cantidad];        
        for(int i=0;i<cantidad;i++){
            torretasLaser[i]= null;            
        }
    }
    public void Arr_Mina(int cantidad){ //Crea un arreglo de minas
        this.minas = new Mina[cantidad];
        for (int i = 0; i < cantidad; i++) {
            minas[i] = new Mina();
        }
    }
    
    public void Arr_Explosion(int cantidad){ //Crea un arreglo de explosiones
        this.explosiones = new Explosion[cantidad];
        for (int i = 0; i < cantidad; i++) {
            explosiones[i] = new Explosion();
        }
    }    
    public void Arr_Robot(int cantidad) { //Crea un arreglo de robots       
        this.robots = new Robot[cantidad];        
        for(int i=0;i<cantidad;i++){
            robots[i]= null;            
        }
    }
    
//  ----------------------------------------------------------------------------------------------------
//  getters y setters
//----------------------------------------------------------------------------------------------------                               

    
    public Mina[] getMinas() {
        return minas;
    }
    public Explosion[] getExplosiones() {
        return explosiones;
    }
    public void setExplosiones(Explosion[]explosiones) {
        this.explosiones = explosiones;
    }
    public void setMinas(Mina[] minas) {
        this.minas = minas;
    }
        
    public Zombie[] getZombies() {
        return zombies;
    }
    public void setZombies(Zombie[] zombies) {
        this.zombies = zombies;
    }
    
    public Torreta[] getTorretas() {
        return torretas;
    }
    public void setTorretas(Torreta[] torretas) {
        this.torretas = torretas;
    }    
    public TorretaLaser[] getTorretasLaser() {
        return torretasLaser;
    }
    public void setTorretasLaser(TorretaLaser[] torretasLaser) {
        this.torretasLaser = torretasLaser;
    }
    public Robot[] getRobots() {
        return robots;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }
    
    
    


}