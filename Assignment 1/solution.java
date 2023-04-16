import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class solution {
    /*
     * Complete the 'longest_inc_sub' function below.
     *
     * Finds the size of the longest non-continous increasing subsequence from a
     * list of integers.
     *
     */
    static Integer longest_inc_sub(List<Integer> seq) {
        int N = seq.size();
        // Initialize list with 1's
        List<Integer> d = new ArrayList<>(Collections.nCopies(N, 1));

        for (int i = 1; i < N; i++)
            for (int j = 0; j < i; j++) {
                if (seq.get(j) < seq.get(i) && d.get(i) < d.get(j) + 1)
                    d.set(i, d.get(j) + 1);
            }

        return d.stream().max((a, b) -> a - b).get();
    }

    public static void main(String[] args) {
        List<List<Integer>> seqs = new ArrayList<List<Integer>>();
        seqs.add(Arrays.asList(10, 9, 2, 5, 3, 101, 7, 18));
        seqs.add(Arrays.asList(186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579, 426, 188, 524, 991,
                91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191, 505, 724, 818, 536, 416, 179, 485, 334, 74, 998,
                100, 197, 768, 421, 114, 739, 636, 356, 908, 477, 656));
        seqs.add(Arrays.asList(318, 536, 390, 598, 602, 408, 254, 868, 379, 565, 206, 619, 936, 195, 123, 314, 729, 608,
                148, 540, 256, 768, 404, 190, 559, 1000, 482, 141, 26, 230, 550, 881, 759, 122, 878, 350, 756, 82, 562,
                897, 508, 853, 317, 380, 807, 23, 506, 98, 757, 247));

        for (List<Integer> x : seqs)
            System.out.println(longest_inc_sub(x));
    }
}
