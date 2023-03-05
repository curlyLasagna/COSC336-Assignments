import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class solution {
  /*
   * This is a modified version of a standard merge function. This function
   * returns the number of star pairs within the array. Star-pairs must meet the
   * following conditions: a[i] < a[j] and i < j
   * @param a: The list to be merged
   * @param mid: The middle index of the array
   * @param left: The starting index of the array
   * @param right: The last index of the array
   */
  public static int merge(List<Integer> a, int left, int mid, int right, int star_pairs) {
    int l_length = mid - left + 1;
    int r_length = right - mid;
    int[] l_arr = new int[l_length];
    int[] r_arr = new int[r_length];

    for (int i = 0; i < l_length; i++)
      l_arr[i] = a.get(left + i);

    for (int i = 0; i < r_length; i++)
      r_arr[i] = a.get(mid + 1 + i);
    /*i = index for left
      j = index for right
      k = current index of the sorted array
     */ 
    int i, j, k;
    i = j = 0;
    k = left;

    while (i < l_length && j < r_length) {
      if (l_arr[i] < r_arr[j]) {
        a.set(k, l_arr[i]);
        star_pairs++;
        i++;
      } else {
        a.set(k, r_arr[j]);
        j++;
      }
      k++;
    }

    while (i < l_length) {
      a.set(k, l_arr[i]);
      i++;
      k++;
    }

    while (j < r_length) {
      a.set(k, r_arr[j]);
      j++;
      k++;
    }
    return star_pairs;
  }

  static int mergeSort(List<Integer> a, int left, int right, int star_pairs) {
    if (left < right) {
      int mid = (left + right) / 2;

      // Sort left half of the array
      mergeSort(a, left, mid, star_pairs);

      // Sort right half of the array
      mergeSort(a, mid + 1, right, star_pairs);

      // Merge the arrays
      merge(a, left, mid, right, star_pairs);
    }
    return star_pairs;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader input34 = new BufferedReader(new FileReader("./input-3.4.txt"));
    BufferedReader input35 = new BufferedReader(new FileReader("./input-3.5.txt"));

    // First line of the file is the size of the
    int size_34 = Integer.parseInt(input34.readLine().trim());
    int size_35 = Integer.parseInt(input35.readLine().trim());
    List<Integer> data = Arrays.asList(7, 3, 8, 1, 5);

    // Read text file and store the values into a list
    List<Integer> data34 = Stream.of(input34.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());

    List<Integer> data35 = Stream.of(input35.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());

    // Store results
    List<Integer> results = new ArrayList<>();
    results.add(mergeSort(data, 0, data.size() - 1, 0));
    // results.add(mergeSort(data34, 0, size_34 - 1, 0));
    // results.add(mergeSort(data35, 0, size_35 - 1, 0));

    results.stream().forEach(result -> {
      System.out.printf("Star pairs: %d%n", result);
    });

    // mergeSort(data, 0, data.size() - 1);
    // System.out.printf("Star pairs: %d%n", star_pairs);

    // mergeSort(data34, 0, size_34 - 1);
    // System.out.printf("Star pairs: %d%n", star_pairs);

    // mergeSort(data35, 0, size_35 - 1);
    // System.out.printf("Star pairs: %d%n", star_pairs);

    input34.close();
    input35.close();
  }
}
