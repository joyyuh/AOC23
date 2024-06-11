import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
public class day4 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("day4.txt"));
		int sum = 0;
		int points;
		
		while(s.hasNext()) {
			String line = s.nextLine();
			String[]  groups = line.split("\\p{Punct}");
			List<String> cards = Arrays.asList(groups[1].split(" "));
			List<String> winnings = Arrays.asList(groups[2].split(" "));
			points = 0;

			for(String card: cards) {
				if(card == null || card.isEmpty()) {
					// ... 
				}
				else {
					if(winnings.contains(card)) {
						if(points == 0) 
							points = 1;
						else
							points *= 2;
					}
				}
			}

			sum += points;
			
			/*for(int i = 0; i < groups.length; i++) {
				System.out.println(groups[i]);
			}
			*/
		}
		
		System.out.println(sum);
	}

}
