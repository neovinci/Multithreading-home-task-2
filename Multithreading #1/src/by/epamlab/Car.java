package by.epamlab;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Car extends Thread {
    private static final long MAX_DISTANCE = 10000;
    Logger log = Logger.getLogger(getClass().getName());
    private static String winner = null;
    private long friction; 
    private long distance; 
    private String name;
    
    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;        
    }
               
	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
        	Race.startAvait();
            while (distance < MAX_DISTANCE && !this.isInterrupted()) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }            
            winner = (winner == null && distance == MAX_DISTANCE) ? name : winner;
            Race.finishCar();
        } catch (InterruptedException e) {
            log.log(Level.SEVERE, name + ": Exception:", e);            
        }
	}
	
	public static String getWinner() {
    	return winner;
    }
	
	public void disqualify() {
		this.interrupt();
		Race.finishCar();
	}
}
