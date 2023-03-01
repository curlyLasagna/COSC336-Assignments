import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class solution {
  public static void merge(
      List<Integer> a, int left, int right) {

    int mid = a.size() / 2;
    int l_length = mid - left + 1;
    int r_length = right - mid;
    int[] l_arr = new int[l_length];
    int[] r_arr = new int[r_length];

    for (int i = 0; i < l_length - 1; i++)
      l_arr[i] = a.get(left + i);

    for (int i = 0; i < r_length - 1; i++)
      r_arr[i] = a.get(mid + i + 1);

    int i, j, k;
    i = j = k = 0;
    

    while (i < l_length && j < r_length) {
      if (l_arr[i] <= r_arr[j]) {
        a.set(k, l_arr[i]);
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
  }

  public static void main(String[] args) throws IOException {
    BufferedReader input34 = new BufferedReader(new
    FileReader("./input-3.4.txt"));
    BufferedReader input35 = new BufferedReader(new
    FileReader("./input-3.5.txt"));

    int size_34 = Integer.parseInt(input34.readLine().trim());
    int size_35 = Integer.parseInt(input35.readLine().trim());
    List<Integer> data = Arrays.asList(7, 3, 8, 1, 5);

    List<Integer> data34 = Stream.of(input34.readLine().replaceAll("\\s+$",
    "").split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList());

    List<Integer> data35 = Stream.of(input35.readLine().replaceAll("\\s+$",
    "").split(" "))
    .map(Integer::parseInt)
    .collect(Collectors.toList());

    merge(data, 0, data.size());
    for (Integer x : data) {
      System.out.println(x);
    }
    input34.close();
    input35.close();
  }
}