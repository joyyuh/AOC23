import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class warmup1 {

	public static void main(String[] args) throws FileNotFoundException {
		int floor = 0; 
		
		Scanner s = new Scanner(new File("warmup1.txt"));
		String str = s.next();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(')
				floor++;
			else 
				floor--;
		}
		
		System.out.println(floor);

	}

}
