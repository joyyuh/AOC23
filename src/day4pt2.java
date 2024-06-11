import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;  

public class day4pt2 {

	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static int parse(List<String> input) {
		for(int i = 0; i < input.size(); i++) {
			map.put(i, 1);
		}
		
		for(int i = 0; i < input.size(); i++) {
			String line = input.get(i);
			String[] splitted = line.split(":");
			String[] cards = splitted[1].split("\\|");
	
			List<Integer> st = new ArrayList<>();
			String[] winnings = cards[0].trim().split("\\s+");
			String[] nums = cards[1].trim().split("\\s+");
			for(String num: nums) {
				st.add(Integer.parseInt(num));
			}
			
			int count = 0;
			for(String winner: winnings) {
				if(st.contains(Integer.parseInt(winner))) {
					count++;
				}
			}
			
			for(int j = i+1; j < i + count + 1; j++) {
				map.put(j, map.getOrDefault(j, 0) + map.getOrDefault(i, 0));
			}
		}
		int sum = 0;
		for(int value: map.values()) {
			sum += value;
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day4.txt"));
		System.out.println(parse(input));
	}
	

}
