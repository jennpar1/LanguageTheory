package PA2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;


//Create random order arrays while only using each number one time
//Just change numbersNeeded to array size and max to the maximum number
//If max and numbersNeeded are different than the random +1 needs to be changed accordingly

public class CreateArrays {
	
	public static void main(String[] args) {
		int max = 1000;
		int numbersNeeded = max;
		if (max < numbersNeeded)
		{
		    throw new IllegalArgumentException("Can't ask for more numbers than are available");
		}
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		Set<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < numbersNeeded)
		{
			Integer next = rng.nextInt(max) + 1;
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
		}
		
		int [] array = new int [numbersNeeded];
		Iterator<Integer> itr = generated.iterator();
		int index = 0;
		while(itr.hasNext()){
			array[index] = itr.next();
			index++;
        }
		
		for (int j = 0; j < array.length; j+=50) {
			System.out.println(
							array[j]+ ", " + 
							array[j+1]+ ", "+
							array[j+2]+ ", " + 
							array[j+3]+ ", " + 
							array[j+4]+ ", " + 
							array[j+5]+ ", " + 
							array[j+6]+ ", " + 
							array[j+7]+ ", " + 
							array[j+8]+ ", " + 
							array[j+9]+ ", " + 
							array[j+10]+ ", " + 
							array[j+11]+ ", " +
							array[j+12]+ ", " + 
							array[j+13]+ ", " + 
							array[j+14]+ ", " + 
							array[j+15]+ ", " + 
							array[j+16]+ ", " + 
							array[j+17]+ ", " + 
							array[j+18]+ ", " + 
							array[j+19]+ ", " +
							array[j+20]+ ", " + 
							array[j+21]+ ", " +
							array[j+22]+ ", " + 
							array[j+23]+ ", " + 
							array[j+24]+ ", " + 
							array[j+25]+ ", " + 
							array[j+26]+ ", " + 
							array[j+27]+ ", " + 
							array[j+28]+ ", " + 
							array[j+29]+ ", " +
							array[j+30]+ ", " + 
							array[j+31]+ ", " +
							array[j+32]+ ", " + 
							array[j+33]+ ", " + 
							array[j+34]+ ", " + 
							array[j+35]+ ", " + 
							array[j+36]+ ", " + 
							array[j+37]+ ", " + 
							array[j+38]+ ", " + 
							array[j+39]+ ", " +
							array[j+40]+ ", " + 
							array[j+41]+ ", " +
							array[j+42]+ ", " + 
							array[j+43]+ ", " + 
							array[j+44]+ ", " + 
							array[j+45]+ ", " + 
							array[j+46]+ ", " + 
							array[j+47]+ ", " + 
							array[j+48]+ ", " + 
							array[j+49]+ "," 
							);
		}
		
	}	
}
