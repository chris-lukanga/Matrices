

class Main{
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World");

        Matrix mat = Matrix.IdentityMatrix(5);

        Matrix mat2 = new Matrix(3, 4, new float[]{1, -3, 4, 7, 0, 1, 2, 2, 0, 0, 1, 5});

        

        Matrix A = new Matrix(2, 1 , new float[]{1,2});
        Matrix B  = new Matrix(1, 3, new float[]{ 2, 0, 4});


        System.out.println(A.mult(B));
        //System.out.println(mat2.getValueAt(3,4));
    }

}