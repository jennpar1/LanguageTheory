//Brockman, Doyle, Parnell
//CSC 332 PA1
//Euclid's Algorithm


package PA1;
import java.util.ArrayList;
//launch for j
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static final int numList = 100;

	public static void main(String[] args) {
		int max = 1000;
		int min = 500;
		//JOptionPane.showConfirmDialog(null, "Generate Random Numbers", "", JOptionPane.YES_OPTION);
//		int[] original = new int [numList];
//		int[] improved = new int [numList];
		String[] arrayOriginal;
		String[] arrayImproved;
		//Generate 100 pairs of random numbers
//		int [][] numbers = new int[numList][2];			//Create matrix for pair of numbers
//		int count = 0;
//		for (int col = 0; col<2; col++) {
//			for (int row = 0; row<numbers.length; row++) {
//				int num = new Random().nextInt(max + 1 + min) - min; 
//				numbers [row][col] = num;
//				count += 1;
//			}
//		}
		int [][] numbers = {{-58,846},{839,219},{275,-267},{392,287},{588,233},
							{-52,458},{906,28},{-160,134},{-455,-114},{884,-31},
							{-119,646},{123,755},{884,715},{446,909},{-112,993},
							{-45,686},{940,664},{510,-276},{281,502},{118,-494},
							{-222,867},{-395,-45},{370,-75},{217,-203},{26,-329},
							{-242,-368},{350,949},{175,787},{-391,621},{-138,837},
							{-468,275},{241,830},{53,-75},{-145,868},{290,463},
							{148,-142},{674,-303},{723,284},{969,585},{-159,289},
							{-92,515},{659,602},{-188,-294},{504,-287},{941,958},
							{296,-456},{-376,521},{-60,138},{107,919},{811,970},
							{168,679},{656,582},{636,-51},{-115,774},{-48,258},
							{138,590},{763,64},{859,482},{541,565},{598,47},
							{219,655},{-307,832},{-469,611},{590,658},{275,-206},
							{-487,-462},{340,-101},{-382,-386},{457,67},{-328,145},
							{954,460},{607,284},{-61,21},{-84,-310},{307,477},
							{975,395},{-451,-67},{-127,127},{594,688},{-106,216},
							{200,391},{735,677},{-256,461},{235,-255},{-447,-182},
							{991,462},{176,-57},{398,-195},{418,192},{-2,93},
							{-197,650},{-46,-22},{-297,476},{180,880},{-413,480},
							{870,378},{493,370},{730,705},{850,602},{603,764}};
		String array = "";
		String[] array1;
		for (int i = 0; i < numbers.length; i++) {
			int j = 0;
			//array[i] = "(" + numbers[i][j] + ", ";
			//String two = numbers [j] + ")";
			i +=1;
			j=0;
			//int three = numbers [i][j];
			//int four = numbers [i][j+1];
			//array1 += "(" + one + ", " + two + ")   (" + three + ", " + four + ")\n";
		}
		
		//JOptionPane.showMessageDialog(null, array1);
		
		arrayOriginal = Original(numbers);
		
//		for (int i = 0; i < original.length; i++) {
//			int one = original[i];
//			i ++;
//			arrayOriginal += one + "\n";
//		}
		
		arrayImproved = Improved(numbers);
		
//		for (int i = 0; i < improved.length; i++) {
//			int one = improved[i];
//			i ++;
//			arrayImproved += one + "\n";
//		}

		//String time = "";
		//String results = "Original GCD      " + "     Improved GCD \n";
		//time = "Original elapsed time: " + elapsedTime + "\n" + "Improved elapsed time: " + elapsedTime2;
		JFrame frame;
		JPanel panel;
		JLabel gcdarray, original, theTime, title1, title2, title3;
		
		frame = new JFrame("Brockman, Doyle, Parnell");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground(new Color(0, 32, 91));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        // set the jframe height and width
        frame.setPreferredSize(new Dimension(width, height));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.setVisible(true);
        
		panel = new JPanel();
        panel.setBackground(new Color(0, 32, 91));
        
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		title1 = new JLabel("GCD Pairs");
		title1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title1.setBackground(Color.WHITE);
		title1.setForeground(new Color(191, 13, 62));
		title1.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		panel.add(title1, c);		
		

		String arrayList = Arrays.deepToString(numbers);
		String[] strings = arrayList.replace("[", "").split("],");	
		JList gcdArray = new JList(strings);		
		gcdArray.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		gcdArray.setBackground(Color.WHITE);
		gcdArray.setForeground(new Color(191, 13, 62));
		gcdArray.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 10;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		panel.add(new JScrollPane(gcdArray), c);

		title2 = new JLabel("Original Results (nanoseconds)");
		title2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title2.setBackground(Color.WHITE);
		title2.setForeground(new Color(191, 13, 62));
		title2.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 50;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		panel.add(title2, c);		
		
		JList originalResults = new JList(arrayOriginal);
		//theResults.setText(arrayOriginal);
		originalResults.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		originalResults.setBackground(Color.WHITE);
		originalResults.setForeground(new Color(191, 13, 62));
		originalResults.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 50;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 3.0;
		panel.add(new JScrollPane(originalResults), c);
		
		title3 = new JLabel("Improved Results (nanoseconds)");
		title3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		title3.setBackground(Color.WHITE);
		title3.setForeground(new Color(191, 13, 62));
		title3.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 90;	
		c.gridy = 1;	//row 1
		c.weightx = 1.0;
  		c.weighty = 1.0;
		panel.add(title3, c);
		
		JList improved = new JList(arrayImproved);
		//theTime.setText(arrayImproved);
		improved.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		improved.setBackground(Color.WHITE);
		improved.setForeground(new Color(191, 13, 62));
		improved.setBorder(BorderFactory.createLineBorder(new Color(191, 13, 62)));
		c.gridx = 90;	
		c.gridy = 50;	//row 1
		c.weightx = 1.0;
  		c.weighty = 3.0;
		panel.add(new JScrollPane(improved), c);
		
        frame.getContentPane().add(panel);
        frame.revalidate();

	}
	

	
	public static String[] Original(int [][] numbers){
		//Original Euclid's Algorithm
		String [] array = new String [Main.numList];
		int [] time = new int [Main.numList];
		long startTime = 0;
		long endTime = 0;
		long total = 0;
		for (int row = 0; row < numbers.length; row++) {
			startTime = System.nanoTime();
			int col = 0;
			int a = numbers[row][col];
//				System.out.println("a = " + a);
			int b = numbers[row][col + 1];
//				System.out.println("b = " + b);
			int remainder = 1;
			int quotient = 0;
			while ( a <= 0 || b <= 0) {
				if (a < 0) {
					a = a * -1;
				}
				if (a == 0) {
					a = (int)Math.random();
				}
				if (b < 0) {
					b = b * -1;
				}
				if (b == 0) {
					b = (int)Math.random();
				}
			}
			if (a < b) {
				int holder = a;
				a = b;
				b = holder;
			}
			while (0 != remainder) {
				quotient = (a/b);
				remainder = a-quotient*b;
				a = b;
				b = remainder;
			} 
			endTime = System.nanoTime();
			long elapsed = endTime - startTime;
			array[row] = a + "";
//				System.out.println(a);
			time[row] = (int) elapsed;
			total += elapsed;
		}
		
		return array;
	}


	
	public static String[] Improved(int [][] numbers){
		//Original Euclid's Algorithm
		String [] array = new String [Main.numList];
		int [] time = new int [Main.numList];
		long startTime = 0;
		long endTime = 0;
		long total = 0;
		for (int row = 0; row < numbers.length; row++) {
			int col = 0;
			int a = numbers[row][col];
//				System.out.println("a = " + a);
			int b = numbers[row][col + 1];
//				System.out.println("b = " + b);
			int remainder = 1;
			int quotient = 0;
			startTime = System.nanoTime();
			while ( a <= 0 || b <= 0) {
				if (a < 0) {
					a = a * -1;
				}
				if (a == 0) {
					a = (int)Math.random();
				}
				if (b < 0) {
					b = b * -1;
				}
				if (b == 0) {
					b = (int)Math.random();
				}
			}
			if (a < b) {
				int holder = a;
				a = b;
				b = holder;
			}
			while (0 != remainder) {
				remainder = a-b;
				if (remainder >b) { 			//meaning quotient > 1
					remainder = remainder - b;
					if (remainder > b) {		// meaning quotient > 2
						remainder = remainder - b;
						if (remainder > b) {	//meaning quotient > 3
							remainder = a - b * (a/b);	//PUNT
						}//endif
					}//endif
				}//endif
				a = b;
				b = remainder;
			} //endwhile
			endTime = System.nanoTime();
			array[row] = a + "";
//				System.out.println(a);
			long elapsed = endTime - startTime;
			time[row] = (int) elapsed;
			total += elapsed;
		}

		
		return array;
	}
}





