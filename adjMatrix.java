package FINALdt;

import java.util.Scanner;

public class adjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int adjMatrix[][] = {
            {0, 1, 1, 0, 0}, //1
            {1, 0, 0, 1, 0}, //2
            {1, 0, 0, 1, 1}, //3
            {0, 1, 1, 0, 1}, //4
            {0, 0, 1, 1, 0}  //5
        };

        System.out.print("Enter Source Vertex: ");
        int source = sc.nextInt();
        System.out.print("Enter Target Vertex: ");
        int target = sc.nextInt();

        int n = adjMatrix.length; 
        int[][] adjMatrix2 = new int[n][n];
        int[][] adjMatrix3 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix2[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    adjMatrix2[i][j] += adjMatrix[i][k] * adjMatrix[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix3[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    adjMatrix3[i][j] += adjMatrix2[i][k] * adjMatrix[k][j];
                }
            }
        }

        int path2 = adjMatrix2[source - 1][target - 1];
        int path3 = adjMatrix3[source - 1][target - 1];

        System.out.println("From " + source + " to " + target);
        System.out.println(source + " to " + target + " #path(length=2): " + path2);
        System.out.println(source + " to " + target + " #path(length=3): " + path3);

        
    }
    
}
