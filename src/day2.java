import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;

public class day2 {

	public static int games(String input) {
		String[] gameSplit = input.split(":");
		int game = Integer.parseInt(gameSplit[0].split("Game ")[1]);
		String[] handfuls = gameSplit[1].split("[,;]");
		
		for(String handful: handfuls) {
			String[] cube = handful.trim().split(" ");
			int amt = Integer.parseInt(cube[0]);
			String color = cube[1];
			
			if((amt > 13 && color.equals("green")) || (amt > 12 && color.equals("red")) || (amt > 14 && color.equals("blue")))
				return 0;
		}
		
		return game;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("day2.txt"));
		int idsum = 0;
		
		while(s.hasNext()) {
			String str = s.nextLine();
			idsum += games(str);
		}
		
		System.out.println(idsum);
		
	}

}
