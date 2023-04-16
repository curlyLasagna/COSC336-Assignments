import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class solution {
  static class Inputs {
    private int size;
    private List<Integer> inputVal;

    Inputs(int size, List<Integer> inputVal) {
      this.size = size;
      this.inputVal = inputVal;
    }

    public int getSize() {
      return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    public List<Integer> getInputVal() {
      return inputVal;
    }

    public void setInputVal(List<Integer> inputVal) {
      this.inputVal = inputVal;
    }
  }

  /*
   * This is a modified version of a standard merge function. This function
   * returns the number of star pairs within the array. Star-pairs must meet the
   * following conditions: a[i] < a[j] and i < j where i and j are indices
   *
   * @param a: The list to be merged
   *
   * @param mid: The middle index of the array
   *
   * @param left: The starting index of the array
   *
   * @param right: The last index of the array
   */
  public static int merge(List<Integer> a, int left, int mid, int right) {
    int star_pairs = 0;
    int l_length = mid - left + 1;
    int r_length = right - mid;
    int[] l_arr = new int[l_length];
    int[] r_arr = new int[r_length];

    for (int i = 0; i < l_length; i++)
      l_arr[i] = a.get(left + i);

    for (int i = 0; i < r_length; i++)
      r_arr[i] = a.get(mid + 1 + i);

    /*
     * i = index for left j = index for right k = current index of the sorted array
     */
    int i, j, k;
    i = j = 0;
    k = left;

    while (i < l_length && j < r_length) {
      if (l_arr[i] < r_arr[j]) {
        a.set(k, l_arr[i]);
        star_pairs += r_length - 2;
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
    int mid = (left + right) / 2;
    if (left < right) {
      // Sort left half of the array
      star_pairs = mergeSort(a, left, mid, star_pairs);

      // Sort right half of the array
      star_pairs = mergeSort(a, mid + 1, right, star_pairs);

      // Merge the arrays
      star_pairs += merge(a, left, mid, right);
    }
    return star_pairs;
  }

  static Inputs readInput(String file) throws IOException {
    BufferedReader inputFile = new BufferedReader(new FileReader(file));
    int inputSize = Integer.parseInt(inputFile.readLine().trim());
    List<Integer> input = Stream.of(inputFile.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());
    inputFile.close();
    return new Inputs(inputSize, input);
  }

  public static void main(String[] args) throws IOException {
    readInput("./input-3.4.txt");
    List<Integer> data = Arrays.asList(7, 3, 8, 1, 5);

    // Store results
    List<Integer> results = new ArrayList<>();
    results.add(mergeSort(data, 0, data.size() - 1, 0));
    results
        .add(mergeSort(readInput("./input-3.4.txt").getInputVal(), 0, readInput("./input-3.5.txt").getSize() - 1, 0));

    results
        .add(mergeSort(readInput("./input-3.5.txt").getInputVal(), 0, readInput("./input-3.5.txt").getSize() - 1, 0));

    results.stream().forEach(result -> {
      System.out.printf("Star pairs: %d%n", result);
    });

  }
}
