import java.util.*;

public class lapt_assignment_1 {
    public static void main(String[] args) {
        double[][] A={{8.25, -9.75, -7.5}
                , {2.25,2.25,-1.5},
                {2.25,-12.75,-4.5}};

        System.out.println("The given matrix is:");
        for (double[] doubles : A) {
            System.out.println(Arrays.toString(doubles));
        }
        System.out.println();

        //Calculating the characteristic equation
        ArrayList<Double> coefficients=calculateCoefficients(A);
        System.out.println("The characteristic equation is given by:");
        System.out.println(coefficients);
        System.out.println();

        //Getting the roots of the characteristic equation
        ArrayList<Double> roots=findRoots(coefficients.get(0),coefficients.get(1),coefficients.get(2),coefficients.get(3));
        roots=cleanUpRoots(roots);
        System.out.println("The roots to the above given equation are(eigen values):");
        System.out.println(roots);
        System.out.println();

        //Finding the null space of (A-λI)
        double[][] A1=getModMatrix(A,roots.get(0));
        double[][] A2=getModMatrix(A,roots.get(1));
        double[][] A3=getModMatrix(A,roots.get(2));

        reduceRowForm(A1);
        reduceRowForm(A2);
        reduceRowForm(A3);

        A1=cleanUpMatrix(A1);
        A2=cleanUpMatrix(A2);
        A3=cleanUpMatrix(A3);


        double[][] eigenVector1=getEigenVector(A1);
        System.out.println("The eigen vector for λ=" + roots.get(0) +":");
        for (double[] i : eigenVector1) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        System.out.println("The eigen vector for λ=" + roots.get(1) +":");
        double[][] eigenVector2=getEigenVector(A2);
        for (double[] i : eigenVector2) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        System.out.println("The eigen vector for λ=" + roots.get(2) +":");
        double[][] eigenVector3=getEigenVector(A3);
        for (double[] i : eigenVector3) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static double[][] getEigenVector(double[][] A) {
        double[][] vector=new double[3][1];
        vector[0][0]=-A[0][2];
        vector[1][0]=-A[1][2];
        vector[2][0] = 1;

        return vector;
    }

    private static double[][] cleanUpMatrix(double[][] A) {
        double[][] temp = new double[A.length][A[0].length];

        for(int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j]-Math.floor(A[i][j])<1e-4){
                    temp[i][j] = Math.floor(A[i][j]);
                }else if(Math.ceil(A[i][j])-A[i][j]<1e-4){
                    temp[i][j] = Math.ceil(A[i][j]);
                }else{
                    temp[i][j]=A[i][j];
                }
            }
        }

        return temp;
    }

    public static void reduceRowForm(double[][] arr) {
        //Checking if there are zero rows and swapping them with last rows

        int zero_rows=arr.length-1;

        boolean consecZeroRows=true;
        for(int i= arr.length-1; i>=0; i--){
            for(int j=0; j < arr[i].length; j++){
                if(arr[i][j]!=0){
                    consecZeroRows=false;
                    break;
                }
            }
            if(!consecZeroRows){
                break;
            }else{
                zero_rows--;
            }
        }

        for(int i=0; i<arr.length-1; i++){
            boolean allZeroes=true;
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=0){
                    allZeroes = false;
                    break;
                }
            }
            if(allZeroes){
                swap_rows(arr,i, zero_rows--);
            }
        }

        //Checking if the first element of the first row is non-zero
        int next_row=1;
        while(arr[0][0]==0){
            for(int i=0; i<arr[0].length; i++){
                double temp=arr[0][i];
                arr[0][i]=arr[next_row][i];
                arr[next_row][i]=temp;

            }
            next_row++;
        }

        //Applying the appropriate row transforms to gor into the reduced row form
        for(int i=0; i<arr.length; i++){

            int first_non_zero=0;
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==0){
                    first_non_zero++;
                }else{
                    break;
                }
            }

            if(first_non_zero==arr[0].length){
                continue;
            }

            double factor=arr[i][first_non_zero];

            for(int j=0; j<arr[0].length; j++){
                arr[i][j]=arr[i][j]/factor;

            }

            subtract_row(arr, i, first_non_zero);

            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr[j].length; k++){
                    if(Math.abs(arr[j][k])<1e-6){
                        arr[j][k] = 0.0f;
                    }
                }
            }
        }
    }

    private static void subtract_row(double[][] arr, int i, int first_non_zero) {

        for(int j=0; j<arr.length; j++){
            double factor=arr[j][first_non_zero];
            for(int k=0;k < arr[0].length; k++){
                if(i==j){
                    break;
                }
                arr[j][k]=arr[j][k]-arr[i][k]*factor;

            }
        }

        for(int j=0; j<arr.length; j++){
            for(int k=0; k<arr[j].length; k++){
                if(Math.abs(arr[j][k])<1e-6){
                    arr[j][k] = 0.0f;
                }
            }
        }
    }

    public static void swap_rows(double[][] arr, int i, int zero_rows) {

        for(int j=0; j<arr[0].length;j++){
            double temp=arr[i][j];
            arr[i][j] = arr[zero_rows][j];
            arr[zero_rows][j] = temp;


        }

    }

    private static double[][] getModMatrix(double[][] A, Double eigenvalue) {
        double[][] temp = new double[A.length][A[0].length];
        for(int i=0; i<A.length; i++){
            for (int j = 0; j< A[i].length; j++){
                if(i==j){
                    temp[i][j]=A[i][j]-eigenvalue;
                }else{
                    temp[i][j]=A[i][j];
                }
            }
        }
        return temp;
    }

    private static ArrayList<Double> cleanUpRoots(ArrayList<Double> roots) {
        ArrayList<Double> temp = new ArrayList<>();

        for (Double root : roots) {
            if (root - Math.floor(root) < 1e-4) {
                temp.add(Math.floor(root));
            } else if(Math.ceil(root)-root<1e-4){
                temp.add(Math.ceil(root));
            }else {
                temp.add(root);
            }
        }

        return temp;
    }

    private static ArrayList<Double> calculateCoefficients(double[][] A) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.0);
        double b=A[0][0] + A[1][1] + A[2][2];
        list.add(-b);
        double c=A[1][1]*A[2][2]-A[1][2]*A[2][1] +A[0][0]*A[2][2]-A[0][2]*A[2][0] +A[1][1]*A[0][0]-A[1][0]*A[0][1];
        list.add(c);
        double d=A[0][0]*(A[1][1]*A[2][2]-A[1][2]*A[2][1]) - A[0][1]*(A[1][0]*A[2][2]-A[1][2]*A[2][0]) + A[0][2]*(A[1][0]*A[2][1]-A[1][1]*A[2][0]);
        list.add(-d);

        return list;
    }



        public static ArrayList<Double> findRoots(double a, double b, double c, double d) {
            ArrayList<Double> roots = new ArrayList<>();


            double p = (3 * c - b * b) / 3;
            double q = (2 * b * b * b - 9 * b * c + 27 * d) / 27;
            double offset = b / 3;

            if (p == 0) {
                roots.add(-offset);
                return roots;
            } else if (q == 0) {
                roots.add(-offset);
                return roots;
            }

            double discriminant = q * q / 4 + p * p * p / 27;
            if (discriminant > 0) {
                double sqrtDiscriminant = Math.sqrt(discriminant);
                double u = (-q / 2 + sqrtDiscriminant) / 2;
                double v = (-q / 2 - sqrtDiscriminant) / 2;

                roots.add(cuberoot(u) - offset);
                roots.add(cuberoot(v) - offset);
                return roots;
            }

            double r = Math.sqrt(-p / 3);
            double phi = Math.acos(-q / 2 / r / r / r);

            roots.add(2 * r * Math.cos(phi / 3) - offset);
            roots.add(2 * r * Math.cos((phi + 2 * Math.PI) / 3) - offset);
            roots.add(2 * r * Math.cos((phi + 4 * Math.PI) / 3) - offset);
            
            return roots;
        }

        private static double cuberoot(double x) {
            if (x >= 0) {
                return Math.pow(x, 1.0 / 3);
            } else {
                return -Math.pow(-x, 1.0 / 3);
            }
        }
    }


