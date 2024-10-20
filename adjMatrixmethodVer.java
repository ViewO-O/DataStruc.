package FINALdt;

import java.util.Scanner;

public class adjMatrixmethodVer {
    // Method to multiply two matrices
    public static int[][] matrixMultiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length; // Assuming square matrices
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }


    public static int outdegree(int[][] adjMatrix, int vertex) {
        int outdegree = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            outdegree += adjMatrix[vertex][i]; // Count all outgoing edges
        }
        return outdegree;
    }

    public static int indegree(int[][] adjMatrix, int vertex) {
        int indegree = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            indegree += adjMatrix[i][vertex]; // Count all incoming edges
        }
        return indegree;
    }

     // Method to count cycles of length k
     public static int countCycles(int[][] adjMatrix, int cycleLength) {
        int n = adjMatrix.length;
        int[][] resultMatrix = adjMatrix;
        int cycleCount = 0;

        // Multiply the matrix to find paths of the desired length
        for (int i = 1; i < cycleLength; i++) {
            resultMatrix = matrixMultiply(resultMatrix, adjMatrix);
        }

        // Sum the diagonal elements for cycle count
        for (int i = 0; i < n; i++) {
            cycleCount += resultMatrix[i][i];  // Diagonal elements represent cycles
        }

        // Divide by the cycle length to account for overcounting (since every cycle is counted k times)
        cycleCount /= cycleLength;

        return cycleCount;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int adjMatrix[][] = {
            {0, 1, 1, 0, 0}, //1
            {1, 0, 0, 1, 0}, //2
            {1, 0, 0, 1, 1}, //3
            {0, 1, 1, 0, 1}, //4
            {0, 0, 1, 1, 0}  //5
        };

        System.out.print("Enter Vertex: ");
        int vertex = sc.nextInt() - 1; // Adjusting for zero-based indexing

        // Get outdegree and indegree
        int outDeg = outdegree(adjMatrix, vertex);
        int inDeg = indegree(adjMatrix, vertex);

        System.out.println("Outdegree of vertex " + (vertex + 1) + ": " + outDeg);
        System.out.println("Indegree of vertex " + (vertex + 1) + ": " + inDeg);

        System.out.println();

        System.out.print("Enter Source Vertex: ");
        int source = sc.nextInt();
        System.out.print("Enter Target Vertex: ");
        int target = sc.nextInt();

        // get paths of length 2
        int[][] adjMatrix2 = matrixMultiply(adjMatrix, adjMatrix);

        // get paths of length 3
        int[][] adjMatrix3 = matrixMultiply(adjMatrix2, adjMatrix);

        int path2 = adjMatrix2[source - 1][target - 1];
        int path3 = adjMatrix3[source - 1][target - 1];

        System.out.println("From " + source + " to " + target);
        System.out.println(source + " to " + target + " #path(length=2): " + path2);
        System.out.println(source + " to " + target + " #path(length=3): " + path3);

        System.out.print("Enter cycle length: ");
        int cycleLength = sc.nextInt();

        // Count cycles of the given length
        int cycleCount = countCycles(adjMatrix, cycleLength);

        System.out.println("Number of cycles of length " + cycleLength + ": " + cycleCount);
        /*matrixMultiply method: ใช้คูณเมทริกซ์ adjacency เพื่อหาจำนวนเส้นทางในกราฟ
        countCycles method:
        รับค่า adjacency matrix และ cycle length ที่ต้องการนับ
        ทำการคูณ adjacency matrix หลายครั้งตาม cycle length เพื่อหาว่าเส้นทางย้อนกลับมาที่ vertex เดิมหรือไม่
        จากนั้นจำนวนนั้นจะถูกนับจากค่าของ diagonal ในเมทริกซ์ที่คูณแล้ว
        ต้องหารด้วย cycle length เพราะแต่ละรอบจะถูกนับซ้ำตามจำนวนรอบที่เท่ากับ cycle length */

    }
}
    

