import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class day6pt2 {

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day6.txt"));
		String[] times = input.get(0).split(" ");
		String[] distances = input.get(1).split(" ");
		
		String sTime = "";
		String sDistance = "";
		for(int i = 1; i < times.length; i++) {
			sTime += times[i];
			sDistance += distances[i];
		}

		long time = Long.parseLong(sTime);
		long distance = Long.parseLong(sDistance);
		int ways = 0;
		
		for(int i = 0; i < time; i++) {
			if(distance < (time-i) * i) 
				ways++;
		}
		
		System.out.println(ways);
	
	}

}
