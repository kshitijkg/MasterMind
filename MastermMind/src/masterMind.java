import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class masterMind {
	public static String[] codeGenerate(int len) {
		String[] colors = { "Red", "Blue", "Green", "Yellow", "Orange", "Black", "Violet" };
		printer(colors);
		String[] code = new String[len];
		for (int i = 0; i <len; i++) {
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

	public static String[] compare(String[] a, String[] b, int len) {
		String[] answer = new String[len];
		for (int i = 0; i < len; i++) {
			for (int y = i; y < len; y++) {
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

	public static boolean checker(String[] answer, int len) {
		boolean isWin = true;
		for (int i = 0; i < len; i++) {
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
		System.out.println("Enter The Secret Code Length/ Difficulty");
		Scanner reader = new Scanner(System.in);
		int len= Integer.parseInt(reader.nextLine());
		String[] code = codeGenerate(len);
		int counter = 1;
		boolean isWin = false;
		String n ="";
		printer(code);
		while (counter <= len*2+5 && isWin != true) {
			System.out.println("Enter The colors");
			n = reader.nextLine();
			String[] splited = n.split(" ");
			String[] answer = compare(splited, code, len);
			printer(answer);
			if (checker(answer, len)) {
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
