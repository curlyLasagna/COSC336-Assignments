import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class solution {
  static class Inputs {
    private int size;
    private List<Integer> inputVal;

    Inputs(int size, List<Integer> inputVal) {
      this.size = size;
      this.inputVal = inputVal;
    }

    Inputs(Inputs o) {
      this(o.getSize(), o.getInputVal());
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

  static class Outputs {
    private int sum;
    private List<Integer> sub_sequence;

    Outputs(int sum, List<Integer> sub_sequence) {
      this.sum = sum;
      this.sub_sequence = sub_sequence;
    }

    Outputs(Outputs o) {
      this(o.getSum(), o.getSub_sequence());
    }

    public int getSum() {
      return sum;
    }

    public void setSum(int sum) {
      this.sum = sum;
    }

    public List<Integer> getSub_sequence() {
      return sub_sequence;
    }

    public void setSub_sequence(List<Integer> sub_sequence) {
      this.sub_sequence = sub_sequence;
    }
  }

  /**
   * Reads a text file of integers where the first line is the size of the input
   * to be evaluated Returns an Inputs object with attributes size and inputVal
   *
   * @param file A string containing the name of the text file to be read
   * @return Inputs object
   */
  static Inputs readInput(String file) throws IOException {
    BufferedReader inputFile = new BufferedReader(new FileReader(file));
    int inputSize = Integer.parseInt(inputFile.readLine().trim());
    List<Integer> input = Stream.of(inputFile.readLine().split("\\s+")).map(Integer::parseInt).toList();
    inputFile.close();
    return new Inputs(inputSize, input);
  }

  // Returns the subsequence that sums up to the maximum
  static List<Integer> construct_subsequence(List<Integer> arr, int N, List<Integer> p) {
    // Return value
    List<Integer> subsequence = new ArrayList<>();
    // indices[] stores the target indices of the subsequence
    List<Integer> indices = new ArrayList<>();
    indices.add(N);
    get_predecessor_indices(N, p, indices);
    indices.forEach(x -> subsequence.add(arr.get(x)));
    // Reverse the list in place for an increasing subsequence
    Collections.reverse(subsequence);
    return subsequence;
  }

  static int get_predecessor_indices(int index, List<Integer> p, List<Integer> sum_index) {

    // Base case
    if (p.get(index) == index)
      return index;

    sum_index.add(p.get(index));
    return get_predecessor_indices(p.get(index), p, sum_index);
  }

  /**
   * Returns an Outputs object, which has the attributes sum and sub_sequence.
   * The sum attribute is set to the maximum sum
   * The sub_sequence attribute is set to a list containing the elements that sum up to the sum attribute.
   *
   * @param N        The size of the sequence
   * @param sequence The sequence that we're evaluating
   * @return Outputs object
   */
  static Outputs max_sum(int N, List<Integer> sequence) {
    // s[] stores the sums at each index i. Initialized with the values of the sequence
    // p[] stores the indices of the elements that sum up to the maximum sum. Initialized with values from range of 0 to N - 1
    List<Integer> s = new ArrayList<>(sequence);
    List<Integer> p = new ArrayList<>();

    for (int index = 0; index < N; index++)
      p.add(index);

    for (int i = 1; i < N; i++)
      for (int j = 0; j < i; j++) {
        if (sequence.get(i) >= sequence.get(j)) {
          // Populate p[]
          if (s.get(i) < s.get(j) + sequence.get(i)) {
            p.set(i, j);
          }
          // Populate s[]
          s.set(i, Math.max(s.get(i), s.get(j) + sequence.get(i)));
        }
      }

    return new Outputs(s.stream().max((a, b) -> a - b).get(), construct_subsequence(sequence, N - 1, p));
  }

  public static void main(String[] args) throws IOException {

    Inputs in3 = new Inputs(readInput("./input-5.3.txt"));
    Inputs in4 = new Inputs(readInput("./input-5.4.txt"));

    Outputs out3 = new Outputs(max_sum(in3.getSize(), in3.getInputVal()));
    Outputs out4 = new Outputs(max_sum(in4.getSize(), in4.getInputVal()));

    System.out.printf("The maximum sum is %d%nFrom subsequence: %s%n", out3.getSum(), out3.getSub_sequence());
    System.out.printf("The maximum sum is %d%nFrom subsequence: %s%n", out4.getSum(), out4.getSub_sequence());

  }
}
