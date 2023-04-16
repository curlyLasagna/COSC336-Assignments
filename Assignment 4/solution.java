import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class solution {
    static int getMaxArea(List<Integer> x, List<Integer> y, int n) {
        // Calculate length of arrays containing histograms
        int len = (n / 2) - 1;
        List<Integer> hs = new ArrayList<>();
        List<Integer> ws = new ArrayList<>();

        // Store the widths and heights of each histogram
        for (int i = 2, j = 0; i < n; i += 2) {
            ws.add(x.get(i) - x.get(j));
            j += 2;
        }

        
        for (int i = 2; i < n; i += 2)
            hs.add(y.get(i));

        Stack<Integer> s = new Stack<>();
        int w = 0;
        int maxArea = 0;
        int widthSum = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : hs.get(i));
            if (s.isEmpty() || h >= hs.get(s.peek())) {
                s.push(i);
                widthSum += ws.get(s.peek());
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea,
                        hs.get(tp) * (s.isEmpty() ? (i * widthSum) : (i - 1 - s.peek()) * widthSum));
                i--;
            }
        }
        return maxArea;
    }

    static void readInput(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int inputSize = Integer.parseInt(in.readLine().trim());
        Stream.of(in.readLine()).

    }

    public static void main(String[] args) throws IOException {
        BufferedReader input41 = new BufferedReader(new FileReader("./input-4.1.txt"));
        BufferedReader input42 = new BufferedReader(new FileReader("./input-4.2.txt"));
        BufferedReader input43 = new BufferedReader(new FileReader("./input-4.3.txt"));
        BufferedReader input44 = new BufferedReader(new FileReader("./input-4.4.txt"));

        // First line of the file are the number of inputs
        int size_41 = Integer.parseInt(input41.readLine().trim());
        int size_42 = Integer.parseInt(input42.readLine().trim());
        int size_43 = Integer.parseInt(input43.readLine().trim());
        int size_44 = Integer.parseInt(input44.readLine().trim());

        // TODO: Read the rest of the input as space separated pairs
        // Read text file and store the values into a list
        List<String> xVal = Stream.of(input41.readLine().split(" ")[0]).collect(Collectors.toList());
        List<Integer> yVal = Stream.of(input41.readLine().split(" ")[1]).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> x = Arrays.asList(3, 3, 4, 4, 6, 6, 10, 10, 13, 13, 17, 17, 18,
        18, 20, 20);
        List<Integer> y = Arrays.asList(0, 1, 1, 3, 3, 6, 6, 2, 2, 5, 5, 1, 1, 8, 8,
        0);
        System.out.println(getMaxArea(x, y, x.size()));
        input41.close();
        input42.close();
        input43.close();
        input44.close();
    }
}
