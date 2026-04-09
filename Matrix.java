public class Matrix {

    private int cols;
    private int rows;
    private float nums[];


    public Matrix(int rows, int cols, float nums[]) throws Exception{

        if(nums.length != cols*rows){
            throw new Exception("Dimensions of matrix does not correspond to the given element");
        }
        this.rows = rows;
        this.cols = cols;
        this.nums = nums;
    }

    public Matrix(int rows, int cols){

        this.cols = cols;
        this.rows = rows;
        this.nums = new float[rows*cols];
        
    }

    /**
     * Creates an identity matrix of a given size
     * @param n the size of the matrix
     * @return an identity matrix
     */
    public static Matrix IdentityMatrix(int n){
        //size n squared
        float nums[] = new float[n*n];

        //filling the diagonals with the number 1
        //evry other entry will have a default value of 0
        for(int i = 0; i<n; i++){
            nums[i+n*i] = 1;
        }

        try {
            return new Matrix(n, n, nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override 
    public String toString(){
        String text = "";
        for(int i = 0; i< rows; i++){
            text +="| \t";
            for( int j = 0; j< cols; j++){
                text+= String.format("%.0f \t", nums[i+rows*j]);
            }
            text+="|";
            text+=String.format("%n");
            
        }
        return text;
    }



}
