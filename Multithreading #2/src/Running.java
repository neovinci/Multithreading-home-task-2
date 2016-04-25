import java.util.Date;
import java.util.Random;

import by.epamlab.Sort;

public class Running {
	public static void main(String[] args) {
		Random rnd = new Random();
		final int MAX_SIZE = 99999999;
		int[] array = new int[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			array[i] = rnd.nextInt(MAX_SIZE * 4);
		}		
		Date start = new Date();
		Sort.quicksort(array);
		Date finish = new Date();
		System.out.println("Final! array sorted by " + (finish.getTime() - start.getTime()) + " ms");
	}
}
