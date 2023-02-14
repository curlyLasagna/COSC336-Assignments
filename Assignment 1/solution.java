import java.util.Arrays;
// import java.util.Collections;
// import java.util.stream.Collectors;

public class solution {
    /*
     * Complete the 'longest_inc_sub' function below.
     *
     * The function is expected to return an int. The function accepts int [] seq as
     * parameter.
     */
    static int longest_inc_sub(int[] seq) {
        int N = seq.length;
        int d[] = new int[N];
        Arrays.fill(d, 1);
        for (int i = 1; i < N; i++)
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && d[i] < (d[j] + 1))
                    d[i] = d[j] + 1;
            }

        // Finding the maximum solution from d[]
        int max = 0;
        for(int x = 0; x < d.length; x++) {
            if (max < d[x])
                max = d[x];
        }
        return max;
        // Find the maximum value of d by using Collections.max(), which requires an argument of type List but we have to convert the primitive array to a list first
        // Using streams, we can convert an array to a list in one line
        // return Collections.max(Arrays
        //                        .stream(d)
        //                        .boxed()
        //                        .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        int[][] sequences = { { 10, 9, 2, 5, 3, 101, 7, 18 },
                { 186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579, 426, 188, 524, 991, 91, 150, 117,
                        565, 993, 615, 48, 811, 594, 303, 191, 505, 724, 818, 536, 416, 179, 485, 334, 74, 998, 100,
                        197, 768, 421, 114, 739, 636, 356, 908, 477, 656 },
                { 318, 536, 390, 598, 602, 408, 254, 868, 379, 565, 206, 619, 936, 195, 123, 314, 729, 608, 148, 540,
                        256, 768, 404, 190, 559, 1000, 482, 141, 26, 230, 550, 881, 759, 122, 878, 350, 756, 82, 562,
                        897, 508, 853, 317, 380, 807, 23, 506, 98, 757, 247 } };

        for (int[] s : sequences)
            System.out.println(longest_inc_sub(s));
    }
}
