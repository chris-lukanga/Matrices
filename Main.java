

class Main{
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World");

        Matrix mat = Matrix.IdentityMatrix(5);

        Matrix mat2 = new Matrix(3, 4, new float[]{1, -3, 4, 7, 0, 1, 2, 2, 0, 0, 1, 5});

        

        Matrix A = new Matrix(3, 4 , new float[]{2, 1, 0, 3,-1, 0, 2, 4,4, -2, 7, 0});
        Matrix B  = new Matrix(3, 4, new float[]{ -4, 3, 5, 1,2, 2, 0, -1,3, 2, -4, 5});


        System.out.println(A.subtractMatrix(B));
        //System.out.println(mat2.getValueAt(3,4));
    }

}