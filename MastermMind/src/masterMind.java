import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class masterMind {
	public static String[] codeGenerate() {
		String[] colors = { "Red", "Blue", "Green", "Yellow", "Orange", "Black", "Violet" };
		printer(colors);
		String[] code = new String[4];
		for (int i = 0; i < 4; i++) {
			code[i] = colors[(int) Math.floor(Math.random() * 6)];
		}
		return code;
	}
	
	static void shuffleArray(String[] answer)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = answer.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      String a = answer[index];
	      answer[index] = answer[i];
	      answer[i] = a;
	    }
	  }

	public static String[] compare(String[] a, String[] b) {
		String[] answer = new String[4];
		for (int i = 0; i < 4; i++) {
			for (int y = i; y < 4; y++) {
				if ((a[i].toUpperCase()).equals(b[y].toUpperCase()) && !a[i].equals("") && !b[i].equals("") && i == y) {
					answer[i] = "red";
					break;
				} else if ((a[i].toUpperCase()).equals(b[y].toUpperCase()) && !b[i].equals("")) {
					answer[i] = "white";
				} else {
					if(answer[i] == null) {
						answer[i] = "none";
					}
				}
			}
		}
		shuffleArray(answer);
		return answer;
	}

	public static boolean checker(String[] answer) {
		boolean isWin = true;
		for (int i = 0; i < 4; i++) {
			if (answer[i].equals("white") || answer[i].equals("none")) {
				isWin = false;
			}
		}
		return isWin;
	}

	public static void printer(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] code = codeGenerate();
		int counter = 1;
		boolean isWin = false;
		Scanner reader = new Scanner(System.in);
		String n ="";
		//printer(code);
		while (counter <= 10 && isWin != true) {
			System.out.println("Enter The colors");
			n = reader.nextLine();
			String[] splited = n.split(" ");
			String[] answer = compare(splited, code);
			printer(answer);
			if (checker(answer)) {
				isWin = true;
				System.out.println("You win");
			}
			counter ++;
		}
		if(isWin!=true) {
			System.out.println("You Lost");
		}
		
	}

}
