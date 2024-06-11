import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day1 { 

	public static void main(String[] args)  throws FileNotFoundException {
		Scanner s = new Scanner(new File("day1.txt"));
		int sum = 0;

		while (s.hasNext()) {
			String s1 = s.next();
			String str = "";
			String str1 = "";
		
			for(int i = 0; i < s1.length(); i++) {
				if(Character.isDigit(s1.charAt(i))) {
					str += s1.charAt(i);
				}
			}
			
			str1 += str.charAt(0);
			str1 += str.charAt(str.length()-1);
			
			sum += Integer.parseInt(str1);
		}
		
		System.out.println(sum);

	}

}
