import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List; 

public class day7 {

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day7.txt"));
		List<String> hands = new ArrayList<String>();
		List<Integer> bids = new ArrayList<Integer>();
		List<Integer> rank = new ArrayList<Integer>();
		
		for(String line: input) {
			hands.add(line.split(" ")[0]);
			bids.add(Integer.parseInt(line.split(" ")[1]));
		}
		/*
		for(int i = 0; i < input.size(); i++) {
			System.out.println(hands.get(i));
			System.out.println(bids.get(i));
		}
		*/
		
		int winnings = 0;
	}
	
/*	public static String compareHands(String h1, String h2) {
		
	}
*/
}
