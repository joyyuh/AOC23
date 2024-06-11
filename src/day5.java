import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day5 {

	public static void main(String[] args) throws IOException {
		//converting input to list
		List<String> input = Files.readAllLines(Paths.get("day5.txt"));
		
		//creating list of numerical values of original seeds only
		String[] line1 = input.get(0).split(" ");
		List<Long> seeds = new ArrayList<>();
		List<Long> range = new ArrayList<>();
		
		for(int i = 1; i < line1.length; i++) {
			seeds.add(Long.parseLong(line1[i]));
			//System.out.println(seeds.get(i-1));
		}
		
		for(int i = 9; i >=0; i--) {
			range.add(0, seeds.remove(i*2+1));
			//System.out.println(range.get(0));
		}
		
		//seed to soil
		Long[][]sts = new Long[22][3];
		for(int i = 3; i < 25; i++) {
			String[] temp = input.get(i).split(" ");
			sts[i-3][0] = Long.parseLong(temp[0]);
			sts[i-3][1] = Long.parseLong(temp[1]);
			sts[i-3][2] = Long.parseLong(temp[2]);
		}
		
		//soil to fertilizer
		Long[][]stf = new Long[27][3];
		for(int i = 27; i < 54; i++) {
			String[] temp = input.get(i).split(" ");
			stf[i-27][0] = Long.parseLong(temp[0]);
			stf[i-27][1] = Long.parseLong(temp[1]);
			stf[i-27][2] = Long.parseLong(temp[2]);
		}
		
		//fertilizer to water
		Long[][]ftw = new Long[38][3];
		for(int i = 56; i < 94; i++) {
			String[] temp = input.get(i).split(" ");
			ftw[i-56][0] = Long.parseLong(temp[0]);
			ftw[i-56][1] = Long.parseLong(temp[1]);
			ftw[i-56][2] = Long.parseLong(temp[2]);
		}
		
		//water to light
		Long[][]wtl = new Long[25][3];
		for(int i = 96; i < 121; i++) {
			String[] temp = input.get(i).split(" ");
			wtl[i-96][0] = Long.parseLong(temp[0]);
			wtl[i-96][1] = Long.parseLong(temp[1]);
			wtl[i-96][2] = Long.parseLong(temp[2]);
		}
		
		//light to temperature
		Long[][]ltt = new Long[20][3];
		for(int i = 123; i < 143; i++) {
			String[] temp = input.get(i).split(" ");
			ltt[i-123][0] = Long.parseLong(temp[0]);
			ltt[i-123][1] = Long.parseLong(temp[1]);
			ltt[i-123][2] = Long.parseLong(temp[2]);
		}
		
		//temperature to humidity
		Long[][]tth = new Long[26][3];
		for(int i = 145; i < 171; i++) {
			String[] temp = input.get(i).split(" ");
			tth[i-145][0] = Long.parseLong(temp[0]);
			tth[i-145][1] = Long.parseLong(temp[1]);
			tth[i-145][2] = Long.parseLong(temp[2]);
		}
		
		//humidity to location 
		Long[][]htl = new Long[36][3];
		for(int i = 173; i < 209; i++) {
			String[] temp = input.get(i).split(" ");
			htl[i-173][0] = Long.parseLong(temp[0]);
			htl[i-173][1] = Long.parseLong(temp[1]);
			htl[i-173][2] = Long.parseLong(temp[2]);
		}
		
		Long minLocation = 10000000000000L;
		for(int i = 0; i < seeds.size(); i++) {
			for(long j = seeds.get(i); j < seeds.get(i)+range.get(i); j++) {
				long soil = (conversion(j, sts));
				long fertilizer = (conversion(soil, stf));
				long water = (conversion(fertilizer, ftw));
				long light = (conversion(water, wtl));
				long temp = (conversion(light, ltt));
				long humidity = (conversion(temp, tth));
				long location = (conversion(humidity, htl));
				if(location < minLocation)
					minLocation = location;
			}
		}
		
		System.out.println(minLocation);
		//format: destination range start, source range start, range length

	}
	
	public static long conversion(long input, Long[][] sts) {
		//conversions is [x rows][3 cols]
		for(int i = 0; i < sts.length; i++) {
			if(input >= sts[i][1] && input <= (sts[i][1] + sts[i][2]-1)) {
				return (sts[i][0] + (input - sts[i][1]));
			}
		}
		return input;
	}

}
