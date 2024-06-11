import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;

public class day1pt2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("day1.txt"));
		int sum = 0;
		String[] nums = {"one","two","three","four","five","six","seven","eight","nine"};

		while (s.hasNext()) {
			String s1 = s.next();
			String str = "";
			String str1 = "";
//			
			for(int i = 0; i < s1.length(); i++) {
				if(Character.isDigit(s1.charAt(i))) {
					str += s1.charAt(i);
				}
//				
//				for(int j = 0; j < nums.length; j++) {
//					if(s1.indexOf(nums[j]) == i) {
//						str += Integer.toString(j+1);
//					}
//					if(s1.lastIndexOf(nums[j]) == i) {
//						str += Integer.toString(j+1);
//					}
//				}
				
				else {
					for(String num: nums) {
						if(s1.indexOf(num) == i || s1.lastIndexOf(num) == i) {
							if(num.equals("one")) {
								str += '1';
//								i += 2;
							}
							else if(num.equals("two")) {
								str += '2';
//								i += 2;
							}
							else if(num.equals("three")) {
								str += '3';
//								i += 4;
							}
							else if(num.equals("four")) {
								str += '4';
//								i += 3;
							}
							else if(num.equals("five")) {
								str += '5';
//								i += 3;
							}
							else if(num.equals("six")) {
								str += '6';
//								i += 2;
							}
							else if(num.equals("seven")) {
								str += '7';
//								i += 4;
							}
							else if(num.equals("eight")) {
								str += '8';
//								i += 4;
							}
							else if (num.equals("nine")){
								str += '9';
//								i += 3;
							}
						
						}
					}
				}
				
			}

			str1 += str.charAt(0);
			str1 += str.charAt(str.length()-1);
			
			sum += Integer.parseInt(str1);
			
		}
		
		System.out.println(sum);
		
	}

}
