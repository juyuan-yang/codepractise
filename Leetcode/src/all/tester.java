package all;

import java.util.ArrayList;

public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		week5.ScrambleString.Solution s = new week5.ScrambleString.Solution();
//		System.out.println(s.isScramble("ab", "ba"));
//		week6.MergeTwoSortedLists.Solution s = new week6.MergeTwoSortedLists.Solution();
//		ListNode node1 = new ListNode(0);
//		System.out.println(s.mergeTwoLists(node1, null));
//		week6.TextJustification.Solution s = new week6.TextJustification.Solution();
//		System.out.println(s.fullJustify(
//				new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
//		week6.ValidaNumber.Solution s = new week6.ValidaNumber.Solution();
//		System.out.println(s.isNumber("1e.3"));
//		week6.MaximalRectangle.Solution s = new week6.MaximalRectangle.Solution();
//		System.out.println(s.maximalRectangle(new char[][]{{'1', '0'}, {'1', '0'}}));
		week7.MergeIntervals.Solution s = new week7.MergeIntervals.Solution();
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 4));
		list.add(new Interval(5, 6));
		s.merge(list);
	}
}
