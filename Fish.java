import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


/**
 * Fish
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 */
public class Fish {


    /**
     * Return the number of fish that will stay alive.
     * 
     * Execution: O(n) - Space: O(n)
     */
    static public int fish(int[] a, int[] b) {

        // **** sanity check(s) ****
        if (a.length == 1) return 1;

        // **** initialization ****
        Stack<Integer> alive = new Stack<>();
  
        // **** process each fish - O(n) ****
        for (int i = 0; i < a.length; i++) {

            // **** current fish size (for ease of use) ****
            int size 	= a[i];

            // **** current fish direction (for ease of use) ****
            int dir 	= b[i];

            // ???? ????
            System.out.println("<<< i: " + i + " size: " + size + " dir: " + dir);

            // **** this fish is alive (for now) ****
            if (alive.empty()) alive.push(i);
            
            // **** check these fish ****
            else {

                // **** check if this fish eats alive fish ****
                while (!alive.empty() && dir - b[alive.peek()] == -1 && a[alive.peek()] < size)
                    alive.pop();

                // **** ****
                if (!alive.empty()) {

                    // **** these fish do not meet; this fish is alive (for now) ****
                    if (dir - b[alive.peek()] != -1)
                        alive.push(i);
                } else {

                    // **** this fish is alive (for now) ****
                    alive.push(i);		  
                }
            }

            // ???? ????
            System.out.println("<<< i: " + i + " alive: " + alive.toString());
        }

        // ???? ????
        System.out.println("<<<< alive: " + alive.toString());

        // **** number of fish alive ****
        return alive.size();
    }

    
    /**
     * Test scaffold
     * !!! NOT PART OF SOLUTION !!!!
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] array a ****
        int[] a = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read int[] b ****
        int[] b = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< a:         " + Arrays.toString(a));
        System.out.println("main <<< b: up <- 0 " + Arrays.toString(b) + " 1 -> down");

        // **** call function of interest and display result ****
        System.out.println("main <<< result: " + fish(a, b));
    }
}