import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class day3 {

	public static boolean validIndex(int x, int y, int rows) {
		return 0 <= x && x < rows && 0 <= y && y < rows;
	}
	
	public static boolean isSymbol(Character c) {
		return !(Character.isDigit(c) || c == '.');
	}
	
	private static int partNum(List<String> input) {
		int sum = 0;
		int rows = input.size();
		
		boolean[][] checked = new boolean[rows][rows];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < rows; j++) {
				if (Character.isDigit(input.get(i).charAt(j))) {
			          int left = j;
			          int num = 0;
			          
			          while (j < rows && Character.isDigit(input.get(i).charAt(j))) {
			              num = num * 10 + (input.get(i).charAt(j++) - '0');
			          }
			          
			          int right = j-1;
			          boolean isPartNum = false;

			          for (int k = left - 1; k < right + 2; k++) {
			            for (int ii = i - 1; ii < i + 2; ii++) {
			              boolean b = validIndex(ii, k, rows) && isSymbol(input.get(ii).charAt(k));

			              isPartNum = isPartNum | b;

			              if (b) {
			                checked[ii][k] = true;
			              }
			            }
			          }

			          if (isPartNum) {
			            sum += num;
			          }
				}
			}
		}
		return sum;
		
	}
	
	public static void main(String[] args) throws IOException {	
		List<String> lines = Files.readAllLines(Paths.get("day3.txt"));
		System.out.println(partNum(lines));
	}

}
