/*
Median of Two Sorted Arrays - Mar 28 '11 - 3180 / 16668

There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

package week11.MedianofTwoSortedArrays;

public class Solution {
    // get the median of each array, and compare
    // smaller one will increase the index, bigger one will decrease the index
    // TODO: this code is totally a shit, needs to rewrite later
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A == null && B == null) {
            return 0;
        } else if(A == null || A.length == 0) {
            if(B.length == 0) return 0;
            return getMedian(B, 0, B.length-1, false, false, 0, 0);
        } else if(B == null || B.length == 0) {
            if(A.length == 0) return 0;
            return getMedian(A, 0, A.length-1, false, false, 0, 0);
        } else {
            int startA = 0, startB = 0, endA = A.length - 1, endB = B.length - 1;
            while((endA - startA) > 1 && (endB - startB) > 1) {
                int midA = (startA + endA) / 2;
                int midB = (startB + endB) / 2;
                boolean Alonger = (endA - startA) > (endB - startB) ? true : false;
                if(A[midA] > B[midB]){
                    if(Alonger){
                        endA -= (midB - startB);
                        startB = midB;
                    } else {
                        startB += (endA - midA);
                        if((endA - startA + 1) % 2 == 0){
                            startB--;
                            endA = midA + 1;
                        } else
                            endA = midA;
                    }
                } else {
                    if(Alonger){
                        startA += (endB - midB);
                        if((endB - startB + 1) % 2 == 0){
                            startA--;
                            endB = midB + 1;
                        } else
                            endB = midB;
                    } else {
                        endB -= (midA - startA);
                        startA = midA;
                    }
                }
            }
            if(endA - startA > 1){
                if(endB - startB == 1)
                    return getMedian(A, startA, endA, true, true, B[startB], B[endB]);
                else
                    return getMedian(A, startA, endA, true, false, B[startB], 0);
            } else {
                if(endA - startA == 1)
                    return getMedian(B, startB, endB, true, true, A[startA], A[endA]);
                else
                    return getMedian(B, startB, endB, true, false, A[startA], 0);
            }
        }
    }

    // hasN1 shows whether the passed n1 is valid
    // if only one valid number passed, assume it is in n1
    // assume n1 < n2;
    public double getMedian(int array[], int start, int end, boolean hasN1, boolean hasN2, int n1, int n2){
        if(!hasN1 && hasN2){
            System.out.println("calling function getMedian error");
            return -1;
        }
        if((end - start + 1) % 2 == 0) { // even elements
            int mid1 = (end + start) / 2, mid2 = mid1 + 1;
            if(hasN1 && hasN2){
                if(n2 <= array[mid1]) { // n1 < n2 < [m1] < [m2]
                    if(mid1 > start) // n1 < n2 < ... < [m1] < [m2]
                        return returnMedian(array[mid1], getMax(n2, array[mid1-1]));
                    else
                        return returnMedian(array[mid1], n2);
                } else if(n1 >= array[mid2]){ // [m1] < [m2] < n1 < n2
                    if(mid2 < end)
                        return returnMedian(array[mid2], getMin(n1, array[mid2+1]));
                    else
                        return returnMedian(array[mid2], n1);
                } else if(n1 >= array[mid1] && n2 <= array[mid2]) { // [m1] < n1 n2 < [m2]
                    return returnMedian(n1, n2);
                } else if(n1 <= array[mid1] && n2 >= array[mid2]) { // n1 < [m1] [m2] < n2
                    return returnMedian(array[mid1], array[mid2]);
                } else if(n1 <= array[mid1] && array[mid1] <= n2 && n2 <= array[mid2]) {
                    return returnMedian(array[mid1], n2);
                } else
                    return returnMedian(n1, array[mid2]);
            } else if(hasN1) {
                if(n1 >= array[mid1] && n1 <= array[mid2]) return n1;
                else if(n1 < array[mid1]) return array[mid1];
                else return  array[mid2];
            } else {
                return returnMedian(array[mid1], array[mid2]);
            }
        } else { // odd elements
            int mid = (end + start) / 2;
            if(hasN1 && hasN2){
                if(n1 <= array[mid] && array[mid] <= n2) return array[mid];
                else if(n1 > array[mid]) {
                    if(mid < end){
                        return getMin(array[mid+1], n1);
                    } else return n1;
                } else { // n2 < array[mid]
                    if(mid > start)
                        return getMax(n2, array[mid-1]);
                    else return n2;
                }
            } else if (hasN1) {
                if(n1 == array[mid]) return array[mid];
                if(mid == end) return returnMedian(n1, array[mid]);
                else if(n1 > array[mid]){
                    if(n1 > array[mid+1]) return returnMedian(array[mid], array[mid+1]);
                    else return returnMedian(array[mid], n1);
                } else { // n1 < array[mid]
                    if(n1 < array[mid-1]) return returnMedian(array[mid], array[mid-1]);
                    else return returnMedian(array[mid], n1);
                }
            } else {
                return array[mid];
            }
        }
    }

    public double returnMedian(int n1, int n2){
        return (n1 + n2) / (double) 2;
    }

    public int getMax(int n1, int n2){
        return n1 > n2 ? n1 : n2;
    }

    public int getMin(int n1, int n2){
        return n1 < n2 ? n1 : n2;
    }
}
