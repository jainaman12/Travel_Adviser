public class AHP {

    public static double[][] initialize_matrix(double[] p) {
        // initialize the matrix a
        double a[][] = new double[p.length][p.length];
        int k = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (i == j)
                    a[i][j] = 1;
                else if (i < j) {

                    a[i][j] = p[k];
                    k++;
                }

                else if (i > j)
                    a[i][j] = 1 / a[j][i];
            }
        }
        double c[] = new double[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[j] += a[i][j];

                // System.out.print(c[j] + "\t");

            }
            // System.out.println();
        }
        double d[][] = new double[p.length][p.length];

        d[0][0] = a[0][0] / c[0];
        d[1][0] = a[1][0] / c[0];
        d[2][0] = a[2][0] / c[0];

        d[0][1] = a[0][1] / c[1];
        d[1][1] = a[1][1] / c[1];
        d[2][1] = a[2][1] / c[1];

        d[0][2] = a[0][2] / c[2];
        d[1][2] = a[1][2] / c[2];
        d[2][2] = a[2][2] / c[2];

        double e[][] = new double[d[0].length][1];
        e[0][0] = (d[0][0] + d[0][1] + d[0][2]) / 3;
        e[1][0] = (d[1][0] + d[1][1] + d[1][2]) / 3;
        e[2][0] = (d[2][0] + d[2][1] + d[2][2]) / 3;

        for (int j = 0; j < 3; j++) {

            System.out.print(e[j][0] + "\t");

        }
        System.out.println();

        return e;
    }

    public static void show_matrix(double[][] b) {
        // display the elements of the matrix a
        System.out.println("\nThe matrix d is:");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                System.out.print(b[i][j] + "    ");
            System.out.println();
        }

    }
    

}