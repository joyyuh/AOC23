import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class day6 {

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day6.txt"));
		String[] times = input.get(0).split(" ");
		String[] distances = input.get(1).split(" ");
		int ways = 1;
		
		for(int i = 1; i < times.length; i++) {
			int tempWay = 0;
			for(int j = 0; j < Integer.parseInt(times[i]); j++) {
				if(Integer.parseInt(distances[i]) < (Integer.parseInt(times[i]) - j) * j) 
					tempWay++;
			}
			ways *= tempWay;
		}
		
		System.out.println(ways);
		
	}

}
