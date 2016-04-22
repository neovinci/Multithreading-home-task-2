import by.epamlab.Car;
import by.epamlab.Race;

public class Running {
	public static void main(String[] args) throws InterruptedException {
		Car car1 = new Car("First", 100);
		Car car2 = new Car ("Second", 120);
		Car car3 = new Car ("Three", 90);
		Race race = new Race(car1, car2, car3);
		race.start();
		Thread.sleep(5000);
		car1.disqualify();
		race.finishAvait();
		System.out.println("Winner is " + Car.getWinner() + "!");
	}
}



