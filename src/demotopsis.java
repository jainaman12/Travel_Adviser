import java.util.Arrays;

public class demotopsis extends AHP {
    demotopsis(double[][] a) {
        // String[] package1 = {"4500","3","3"}; //{"price","days","hotel star"}
        // String[] package2 = {"5500","3","4"};
        // String[] package3 = {"2000","2","1"};
        // String[] package4 = {"11500","5","5"};

        // double pack[][]=new double[4][3];

        double[][] pack = { {4999,3,2}, {5999,4,3}, {12500,6,4}, {15499,7,5}, {12000,5,4},
        {21001,8,7},{1899,5,7},{12500,4,5},{8999,2,3},{7500,2,3},
        {5600,6,2},{6700,4,5},{3999,3,2},{2999,3,1},{5500,4,3},{0,0,0} };
        double[] nor = new double[4];
        // double[] nor1=new double[4];

        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < 3; k++) {
                pack[15][k] += Math.pow(pack[i][k], 2); // for squaring and then sum
            }
        }
        for (int i = 0; i < 3; i++) {
            pack[15][i] = Math.pow((pack[15][i]), 0.5); // for underroot
        }

        // int k=0;
        // for(int i=0;i<3;i++){
        // pack[4][k]+=pack[i][k];
        // k++;

        // }
        // for(int i=0;i<3;i++){
        // pack[4][i]=Math.pow(pack[4][i], 0.5);

        // }
        // for(int i=0;i<4;i++){
        // for(int j=0;j<3;j++){
        // System.out.println(pack[i][j]);
        // }

        // }
        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(pack[i][k] + " "); // for printing sum of squares and then underoot
            }
            System.out.println();
        }

        double[][] pack1 = new double[15][3];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                pack1[i][j] = (pack[i][j] / pack[15][j]); // for dividing
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(pack1[i][j] + " ");
            }
            System.out.println();
        }
        double[][] pack2 = new double[15][3];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                pack2[i][j] = pack1[i][j] * a[j][0]; // multipling weighted values
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(pack2[i][j] + " ");
            }
            System.out.println();
        }

        double[] max = new double[3];

        max[0] = pack2[0][0];
        for (int i = 0; i < 15; i++) // ideal best for price(-ve)
        {
            if (pack2[i][0] < max[0]) {
                max[0] = pack2[i][0];
            }
        }

        max[1] = pack2[0][1];
        for (int i = 0; i < 15; i++) {
            if (pack2[i][1] > max[1]) // ideal best for time
            {
                max[1] = pack2[i][1];
            }
        }
        max[2] = pack2[0][2];
        for (int i = 0; i < 15; i++) {
            if (pack2[i][2] > max[2]) // ideal best for accomodation
            {
                max[2] = pack2[i][2];
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(max[i] + " ");
        }
        System.out.println("");

        double[] min = new double[3];

        min[0] = pack2[0][0];
        for (int i = 0; i < 15; i++) // ideal wrost for price()
        {
            if (pack2[i][0] > min[0]) {
                min[0] = pack2[i][0];
            }
        }

        min[1] = pack2[0][1];
        for (int i = 0; i < 15; i++) {
            if (pack2[i][1] < min[1]) // ideal worst for time
            {
                min[1] = pack2[i][1];
            }
        }
        min[2] = pack2[0][2];
        for (int i = 0; i < 15; i++) {
            if (pack2[i][2] < min[2]) // ideal worst for accomodation
            {
                min[2] = pack2[i][2];
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(min[i] + " ");
        }
        double[] splus = new double[15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                splus[i] += Math.pow((pack2[i][j] - max[j]), 2);
            }
        }
        for (int i = 0; i < 15; i++) {
            splus[i] = Math.pow(splus[i], 0.5); // for underroot
        }

        System.out.println("hey there");
        for (int i = 0; i < 15; i++) {
            System.out.println(splus[i]);
        }
        System.out.println();

        double[] sminus = new double[15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                sminus[i] += Math.pow((pack2[i][j] - min[j]), 2);
            }
        }
        for (int i = 0; i < 15; i++) {
            sminus[i] = Math.pow(sminus[i], 0.5); // for underroot
        }

        System.out.println("hey there");
        for (int i = 0; i < 15; i++) {
            System.out.println(sminus[i]);
        }

        double[] perf = new double[15];
        for (int i = 0; i < 15; i++) {
            perf[i] = sminus[i] / (sminus[i] + splus[i]);

        }
        System.out.println("Finaloutput");
        for (int i = 0; i < 15; i++) {
            System.out.println(perf[i]);
        }
        double n1;
        double n2;
        double n3;
        n1 = n2 = n3 = Integer.MIN_VALUE;
        for (int i = 0; i < 15; i++) {
            /*
             * If current element is greater than n1
             */
            if (perf[i] > n1) {
                n3 = n2;
                n2 = n1;
                n1 = perf[i];
            }

            /*
             * If perf[i] is in between n1 and n2 then update n2
             */
            else if (perf[i] > n2) {
                n3 = n2;
                n2 = perf[i];
            }

            else if (perf[i] > n3) {
                n3 = perf[i];
            }
        }

        System.out.println("Three largest elements are " + n1 + " " + n2 + " " + n3);
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        for (int i = 0; i < 15; i++) {
            if (n1 == perf[i]) {
                a1 = i;
            }
        }
        for (int i = 0; i < 15; i++) {
            if (n2 == perf[i]) {
                a2 = i;
            }
        }
        for (int i = 0; i < 15; i++) {
            if (n3 == perf[i]) {
                a3 = i;
            }
        }
        System.out.println(a1 + "" + a2 + "" + a3);

        // double final1 = Arrays.stream(perf).max().getAsDouble();

        new recomm(a1, a2, a3).setVisible(true);

        // System.out.println(e);



    }

    public static void main(String[] args) {

        double[][] a = new double[3][3];

        new demotopsis(a);
         

    }

}