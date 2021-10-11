/**
 * created by hansikaweerasena
 * Date: 10/11/21
 **/
import java.util.Arrays;
import java.util.Random;

class GFG {

    // Prints edges of tree
    // represented by give Prufer code
    static void printTreeEdges(int prufer[], int m)
    {
        int vertices = m + 2;
        int vertex_set[] = new int[vertices];

        // Initialize the array of vertices
        for (int i = 0; i < vertices; i++)
            vertex_set[i] = 0;

        // Number of occurrences of vertex in code
        for (int i = 0; i < vertices - 2; i++)
            vertex_set[prufer[i] - 1] += 1;

        System.out.print("\nThe edge set E(G) is:\n");

        int j = 0;

        // Find the smallest label not present in
        // prufer[].
        for (int i = 0; i < vertices - 2; i++) {
            for (j = 0; j < vertices; j++) {

                // If j+1 is not present in prufer set
                if (vertex_set[j] == 0) {

                    // Remove from Prufer set and print
                    // pair.
                    vertex_set[j] = -1;
                    System.out.print("(" + (j) + ", "
                            + (prufer[i] - 1) + ") ");

                    vertex_set[prufer[i] - 1]--;

                    break;
                }
            }
        }

        j = 0;

        // For the last element
        for (int i = 0; i < vertices; i++) {
            if (vertex_set[i] == 0 && j == 0) {

                System.out.print("(" + (i) + ", ");
                j++;
            }
            else if (vertex_set[i] == 0 && j == 1)
                System.out.print((i) + ")\n");
        }
    }

    // Function to Generate Random Tree
    static void generateRandomTree(int n)
    {

        Random rand = new Random();
        int length = n - 2;
        int[] arr = new int[length];

        // Loop to Generate Random Array
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(length + 1) + 1;
        }
        printTreeEdges(arr, length);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 5;
        generateRandomTree(n);
    }
}
