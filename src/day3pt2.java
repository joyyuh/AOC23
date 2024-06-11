import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day3pt2 {

	  //checking out of bounds

	  public static boolean validIndex(int x, int y, int rows) {
	    return 0 <= x && x < rows && 0 <= y && y < rows;
	  }

	  //checking if character is symbol
	  
	  public static boolean isSymbol(Character c) {
	    return !(Character.isDigit(c) || c == '.');
	  }

	  private static int gearNum(List<String> input) {
	    int rows = input.size();

	    //mapping nums to corresponding symbols
	    List<List<List<Integer>>> numsOfSymbol = new ArrayList<>(rows);

	    for (int i = 0; i < rows; i++) {
	      numsOfSymbol.add(new ArrayList<>(rows));
	      for (int j = 0; j < rows; j++) {
	        numsOfSymbol.get(i).add(new ArrayList<>());
	      }
	    }

	    int sum = 0;

	    for (int r = 0; r < rows; r ++) {
	      for (int c = 0; c < rows; c++) {

	        if (Character.isDigit(input.get(r).charAt(c))) {
	          int left = c;

	          //getting number from digits
	          int number = 0;
	          while (c < rows && Character.isDigit(input.get(r).charAt(c))) {
	            number = number * 10 + (input.get(r).charAt(c++) - '0');
	          }

	          int right = c - 1;

	          for (int i = left - 1; i < right + 2; i++) {
	            for (int j = r - 1; j < r + 2; j++) {
	              if (validIndex(j, i, rows) && isSymbol(input.get(j).charAt(i))) {
	                numsOfSymbol.get(j).get(i).add(number);
	              }
	            }
	          }
	        }
	      }
	    }
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < rows; j++) {
	        //finding gear ratios 
	        if (input.get(i).charAt(j) == '*' && numsOfSymbol.get(i).get(j).size() == 2) {
	          sum += numsOfSymbol.get(i).get(j).get(0) * numsOfSymbol.get(i).get(j).get(1);
	        }
	      }
	    }

	    return sum;
	  }
	
	public static void main(String[] args) throws IOException {	
		List<String> lines = Files.readAllLines(Paths.get("day3.txt"));
		System.out.println(gearNum(lines));
	}

}
