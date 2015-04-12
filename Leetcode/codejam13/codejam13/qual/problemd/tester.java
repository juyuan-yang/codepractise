package codejam13.qual.problemd;

import java.io.File;

import codejam13.qual.problemd.Solution;

public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		try {
			File file = new File("in.txt");
			solution.process(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
