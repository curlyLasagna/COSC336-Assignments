import java.util.*;

public class final_solution {
  public static void main(String[] args) {
    // Read input files
    int histHeight[] = { 0, 2, 2, 1, 1, 0 };
    int histX[] = { 2, 2, 8, 8, 14, 14 };

    Set<Integer> height = new HashSet<>();
    Set<Integer> width = new HashSet<>();

    for (Integer val : histHeight)
      height.add(val);

    for (Integer val : histX)
      width.add(val);

    System.out.println("Maximum area is " +
        getMaxArea(height, width, height.size()));
  }

  // Function to find largest rectangular area possible in
  // a given histogram.
  public static int getMaxArea(Set<Integer> heights, Set<Integer> widths, int n) {

    // we create an empty stack here.
    Stack<Integer> s = new Stack<>();
    // we push -1 to the stack because for some elements
    // there will be no previous smaller element in the
    // array and we can store -1 as the index for
    // previous smaller.
    s.push(0);
    int max_area = heights.get[0];
    // We declare left_smaller and right_smaller array
    // of size n and initialize them with -1 and n as
    // their default value. left_smaller[i] will store
    // the index of previous smaller element for ith
    // element of the array. right_smaller[i] will store
    // the index of next smaller element for ith element
    // of the array.
    int left_smaller[] = new int[n];
    int right_smaller[] = new int[n];
    for (int i = 0; i < n; i++) {
      left_smaller[i] = -1;
      right_smaller[i] = n;
    }

    int i = 0;
    while (i < arr.length) {
      while (!s.empty() && s.peek() != -1 && arr[i] < arr[s.peek()]) {
        // if the current element is smaller than
        // element with index stored on the top of
        // stack then, we pop the top element and
        // store the current element index as the
        // right_smaller for the popped element.
        right_smaller[s.peek()] = (int) i - 1;
        s.pop();
        System.out.printf("%nCondition 1: %d", i);
      }
      if (i > 0 && arr[i] == arr[(i - 1)]) {
        System.out.printf("%nCondition 2: %d", i);
        // we use this condition to avoid the
        // unnecessary loop to find the
        // left_smaller. since the previous element
        // is same as current element, the
        // left_smaller will always be the same for
        // both.
        left_smaller[i] = left_smaller[(int) (i - 1)];
      } else {
        // Element with the index stored on the top
        // of the stack is always smaller than the
        // current element. Therefore the
        // left_smaller[i] will always be s.top().
        left_smaller[i] = (s.peek() == -1 ? i : s.peek());
        System.out.printf("%nCondition 3: %d", i);
      }
      s.push(i);
      i++;
    }

    for (i = 0; i < n; i++) {
      // here we find area with every element as the
      // smallest element in their range and compare
      // it with the previous area. in this way we get
      // our max Area form this.

      max_area = Math.max(max_area, arr[i] * ((right_smaller[i] == histX.length
          ? histX[right_smaller[i] - 1]
          : histX[right_smaller[i]]) -
          histX[left_smaller[i]]));

      int length = arr[i];
      int right = (right_smaller[i] == histX.length ? histX[right_smaller[i] - 1]
          : histX[right_smaller[i]]);
      int left = histX[left_smaller[i]];
      int breadth = right - left;
      int area = arr[i] * (right - left);

      System.out.printf(
          "%nThe area is: %d%n The lenght is:  %d%nThe breadth is: %d%nThe right is: %d%nThe left is: %d%n",
          area, length, breadth, right, left);
    }
    System.out.printf("%nThe elements of the right array are: ");
    for (int j = 0; j < right_smaller.length; j++) {
      System.out.printf("%d", right_smaller[j]);
    }
    System.out.println();

    System.out.printf("%nThe elements of the left array are: ");
    for (int j = 0; j < left_smaller.length; j++) {
      System.out.printf("%d", left_smaller[j]);
    }
    System.out.println();

    return max_area;
  }
}
