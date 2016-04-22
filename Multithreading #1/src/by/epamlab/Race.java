package by.epamlab;

import java.util.concurrent.CountDownLatch;

public class Race {
	private static CountDownLatch start;
	private static CountDownLatch finish;
	private Car[] cars;
	
	public Race(Car...cars) {
		this.cars = cars;
		start = new CountDownLatch(1);
		finish = new CountDownLatch(cars.length);		
	}
	
	public void start() throws InterruptedException {
		for(Car car : cars) {
			car.start();
		}
		start.countDown();		
	}
	
	public static void startAvait() throws InterruptedException {
		start.await();
	}	
	
	public void finishAvait() throws InterruptedException {
		finish.await();
	}
	
	public static void finishCar() {
		finish.countDown();
	}
}
