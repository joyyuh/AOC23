import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2pt2 {

	public static int minPower(String input) {
		String[] gameSplit = input.split(":");
		String[] handfuls = gameSplit[1].split("[,;]");
		
		int rMin, gMin, bMin;
		rMin = gMin = bMin = 0;
		
		for(String handful: handfuls) {
			String[] cube = handful.trim().split(" ");
			int amt = Integer.parseInt(cube[0]);
			String color = cube[1].trim();
			
			if(amt > rMin && color.equals("red"))
				rMin = amt;
			if(amt > gMin && color.equals("green"))
				gMin = amt;
			if(amt > bMin && color.equals("blue"))
				bMin = amt;
		}
		
		return rMin * gMin * bMin;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("day2.txt"));
		int power = 0;
		while(s.hasNext()) {
			String str = s.nextLine();
			power += minPower(str);
		}
		
		System.out.println(power);
		
		
	}

}
