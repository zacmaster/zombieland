package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.*;
public class Juego extends InterfaceJuego{
    private Entorno entorno; //variables de juego
    Ingeniero juan;
    Todo_Arreglos todo_arreglos;
    Colisiones colisiones;
    Reloj reloj;
    int  punteroTorreta, punteroTorretaLaser, punteroMina ,punteroExplosionMina, punteroZombie, punteroRobot, counterTick;
    Image imagen;
   
    Juego(){ //Constructor
        this.reloj = new Reloj();
        this.todo_arreglos = new Todo_Arreglos();
        this.todo_arreglos.Arr_Zombie(400);
        this.todo_arreglos.Arr_Torreta(63);
        this.todo_arreglos.Arr_TorretaLaser(25);
        this.todo_arreglos.Arr_Mina(250);
        this.todo_arreglos.Arr_Robot(125);
        this.todo_arreglos.Arr_Explosion(250);
        this.juan = new Ingeniero();
        this.colisiones = new Colisiones(juan,todo_arreglos,entorno);
        this.entorno = new Entorno(this, "Zombieland", 800, 620);     
        this.entorno.iniciar();
        this.punteroTorreta = 0;
        this.punteroTorretaLaser = 0;
        this.punteroZombie = 0;
        this.punteroMina = 0;
        this.punteroRobot = 0;
        this.counterTick = 0;
        
    }




    private void prepararTorreta(int punteroTorreta){ //Instala  torretas y actualiza el estado de las mismas
        
        if (juan.isCreaTorreta() && punteroTorreta < todo_arreglos.getTorretas().length ) {
            double x = juan.getX(); double y = juan.getY(); int dineroActual = colisiones.getDinero();;
            if (dineroActual>= 200 &&!colisiones.robotsDebajo(x, y) && !colisiones.torretasDebajo(x,y) && !colisiones.torretasLaserDebajo(x,y) && !colisiones.minasDebajo(x,y)) {
                todo_arreglos.getTorretas()[punteroTorreta] = new Torreta();
                todo_arreglos.getTorretas()[punteroTorreta].setX(juan.getX());
                todo_arreglos.getTorretas()[punteroTorreta].setY(juan.getY());
                todo_arreglos.getTorretas()[punteroTorreta].setBala_x(juan.getX()+50);
                todo_arreglos.getTorretas()[punteroTorreta].setBala_y(juan.getY());
                juan.setCreaTorreta(false);
                this.punteroTorreta++;
                colisiones.setDinero(dineroActual-=200);
            }
            else{
                juan.setCreaTorreta(false);
            }            
        }
        for (int i = 0; i < todo_arreglos.getTorretas().length; i++) {
            if(todo_arreglos.getTorretas()[i] != null ){
                todo_arreglos.getTorretas()[i].dibujarBala(entorno); 
                todo_arreglos.getTorretas()[i].dibujarse(entorno);
            }
         }
    }
    
    
    
    private void prepararTorretaLaser(int punteroTorretaLaser){//Instala  torretas laser y actualiza el estado de las mismas
        if (juan.isCreaTorretaLaser() && punteroTorretaLaser < todo_arreglos.getTorretasLaser().length ) {
            double x = juan.getX(); double y = juan.getY(); int dineroActual = colisiones.getDinero();
            if (dineroActual>= 500 && !colisiones.robotsDebajo(x, y) && !colisiones.torretasDebajo(x,y) && !colisiones.torretasLaserDebajo(x,y) && !colisiones.minasDebajo(x,y)) {
                todo_arreglos.getTorretasLaser()[punteroTorretaLaser] = new TorretaLaser();             
                todo_arreglos.getTorretasLaser()[punteroTorretaLaser].setX(juan.getX());
                todo_arreglos.getTorretasLaser()[punteroTorretaLaser].setY(juan.getY());
                todo_arreglos.getTorretasLaser()[punteroTorretaLaser].setLaser_x(juan.getX()+15);
                todo_arreglos.getTorretasLaser()[punteroTorretaLaser].setLaser_y(juan.getY());                
                juan.setCreaTorretaLaser(false);
                this.punteroTorretaLaser++;
                colisiones.setDinero(dineroActual-=500);
            }
            else{
                juan.setCreaTorretaLaser(false);
            }            
        }

        for (int i = 0; i < todo_arreglos.getTorretasLaser().length; i++) {
            if(todo_arreglos.getTorretasLaser()[i] != null){                
                todo_arreglos.getTorretasLaser()[i].dibujarLaser(entorno);
                todo_arreglos.getTorretasLaser()[i].dibujarse(entorno);
            }
         }
    }
    
    public void prepararMina(int punteroMina){ //Instala  minas y actualiza el estado de las mismas
    	if(juan.isCreaMina() && punteroMina < todo_arreglos.getMinas().length){
        	double x = juan.getX(); double y = juan.getY(); int dineroActual = colisiones.getDinero();
            if(colisiones.getDinero()>= 50 && !colisiones.robotsDebajo(x, y) && !colisiones.torretasDebajo(x,y) && !colisiones.torretasLaserDebajo(x,y) && !colisiones.minasDebajo(x,y)) { 
                todo_arreglos.getMinas()[punteroMina].setVivo(true);
                todo_arreglos.getMinas()[punteroMina].setX(juan.getX());
                todo_arreglos.getMinas()[punteroMina].setY(juan.getY());
                juan.setCreaMina(false);
                this.punteroMina++;
                colisiones.setDinero(dineroActual-=50);
            }            
            else{
                juan.setCreaMina(false);
            } 
        }
        for (int i = 0; i < todo_arreglos.getMinas().length; i++) {
            if(todo_arreglos.getMinas()[i].isVivo()){
                todo_arreglos.getMinas()[i].dibujarse(entorno);
            }
         }
 
        for (int i = 0; i < todo_arreglos.getExplosiones().length; i++) {

            if(todo_arreglos.getExplosiones()[i].isExplosion_vivo()){
                todo_arreglos.getExplosiones()[i].dibujarse(entorno,todo_arreglos.getMinas()[i] );
            }
        }
    }
    
    private void prepararRobot(int punteroRobot){ //Instala  robots y actualiza el estado de los mismos
        
        if (juan.isCreaRobot() && punteroRobot < todo_arreglos.getRobots().length ) {
            double x = juan.getX(); double y = juan.getY(); int dineroActual = colisiones.getDinero();;
            if (dineroActual>= 100 && !colisiones.robotsDebajo(x,y) && !colisiones.torretasLaserDebajo(x,y) && !colisiones.minasDebajo(x,y) && !colisiones.robotsDebajo(x, y)) {
                todo_arreglos.getRobots()[punteroRobot] = new Robot();
                todo_arreglos.getRobots()[punteroRobot].setX(juan.getX());
                todo_arreglos.getRobots()[punteroRobot].setY(juan.getY());
                todo_arreglos.getRobots()[punteroRobot].setBala_x(juan.getX()+50);
                todo_arreglos.getRobots()[punteroRobot].setBala_y(juan.getY());
                juan.setCreaRobot(false);
                this.punteroRobot++;
                colisiones.setDinero(dineroActual-=100);
            }
            else{
                juan.setCreaRobot(false);
            }            
        }
        for (int i = 0; i < todo_arreglos.getRobots().length; i++) {
            if(todo_arreglos.getRobots()[i] != null ){
                if (todo_arreglos.getRobots()[i].getX()<800) {
                    todo_arreglos.getRobots()[i].avanzar();
                    todo_arreglos.getRobots()[i].dibujarBala(entorno);
                    todo_arreglos.getRobots()[i].dibujarse(entorno);
                    
                }
                else{
                    todo_arreglos.getRobots()[i]= null;
                }
                                
            }
         }
        
    }
    
    
    /*
     * Durante el juego, el método tick() será ejecutado en cada instante y
     * por lo tanto es el método más importante de esta clase. Aquí se debe
     * actualizar el estado interno del juego para simular el paso del tiempo
     * (ver el enunciado del TP para mayor detalle).
     */
    public void tick(){
        
        imagen = Herramientas.cargarImagen("fondoEditado.jpg"); //Carga fondo
        entorno.dibujarImagen(imagen, 405, 310, 0, 1);
        
        //Si estan dadas las condiciones, el juego est� activo
        if (juan.getVidas()>= 0 && colisiones.getContador_muertos() != todo_arreglos.getZombies().length && this.counterTick <= 30000 ){
            
        //Cargo los metodos void de la clase colisiones
        colisiones.LaserMataZombie();
        colisiones.BalaMataZombie();
        colisiones.BalaRobotMataZombie();
        colisiones.zombieChocaMina();
        colisiones.zombieChocaExplosion();
        colisiones.ExplosionChocaMina();
        colisiones.ExplosionMataIngeniero();        
        colisiones.zombieChocaTorreta();
        colisiones.zombieChocaRobot();
        colisiones.zombieChocaTorretaLaser();
        
        //Compruebo si el ingeniero pierde una vida
        if (colisiones.ExplosionMataIngeniero() || colisiones.zombieMataIngeniero()||  todo_arreglos.zombieLlega()) { //Condiciones que quitan vidas al ingeniero
			juan.setX(20);
			juan.setY(300);			
            int vidasIngeniero = juan.getVidas();
        	juan.setVidas(vidasIngeniero-=1);
        	juan.setVivo(true);
		}
        
        
        
    	//Dos formas distintas de hacer aparecer a los zombies
        
//        punteroZombie = todo_arreglos.ZombiePorSegundo(this.counterTick, punteroZombie); // 1 zombie por segundo
        todo_arreglos.TiemposZombie(this.counterTick); // Oleada de zombies programada
        todo_arreglos.avanzarZombie();
        todo_arreglos.dibujarZombie(entorno);

        prepararTorreta(punteroTorreta); //funciones arriba explicadas
        prepararTorretaLaser(punteroTorretaLaser);
        prepararMina(punteroMina);
        prepararRobot(punteroRobot);     
        
        juan.dibujarse(entorno); //El ingeniero se dibuja por encima de los objetos
        
        //Carteles en pantalla
        entorno.cambiarFont("Arial",40, Color.green);
        entorno.escribirTexto("Vidas: " +juan.getVidas()  ,20, 620);//Cantidad de vidas        
        entorno.cambiarFont("Arial",20, Color.green);
        entorno.escribirTexto("Zombies muertos : "+colisiones.getContador_muertos(),300, 625);//Cantidad de zombies muertos
        entorno.cambiarFont("Arial",20, Color.green);
        entorno.escribirTexto("Dinero :"+colisiones.getDinero(),300, 605); //Dinero disponible
        
        //Reloj en pantalla
        reloj.Sumartiempo(this.counterTick);        
        entorno.cambiarFont("Arial", 18, Color.white);
        entorno.escribirTexto("Tiempo Jugado " +  reloj.DarTiempo(),600, 605);
        entorno.escribirTexto("Tiempo faltante " +  reloj.DarTiempoFaltante(),600, 625);
        
        this.counterTick++;
  
        }
        
        //Si el ingeniero est� vivo y se cumplen los 5 minutos o se matan todos los zombies se muestra mensaje ganador
        if (juan.getVidas() >= 0 && (colisiones.getContador_muertos() == todo_arreglos.getZombies().length || counterTick >= 30000)  ) {
            entorno.cambiarFont("Arial", 46, Color.white);
            entorno.escribirTexto("GANASTE, GENIO " ,0, 625);
            entorno.cambiarFont("Arial",20, Color.white);
            entorno.escribirTexto("Mataste "+ colisiones.getContador_muertos()+" zombies como un campeón!",420, 625);
        }
        //Si el ingeniero pierde todas las vidas se muestra el mensaje perdedor
        if (juan.getVidas() < 0 ) {
            entorno.cambiarFont("Arial", 50, Color.white);
            entorno.escribirTexto("HAS PERDIDO " ,0, 625);
            entorno.cambiarFont("Arial",23, Color.white);
            entorno.escribirTexto("Mataste "+ colisiones.getContador_muertos()+" zombies, sigue practicando...",350, 625);
        }
        
    
    }
    @SuppressWarnings("unused")
    public static void main(String[] args){
       
        Juego juego = new Juego();       
        
        
       
       
    }
}
