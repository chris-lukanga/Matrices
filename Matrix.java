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

    public static Matrix IdentityMatrix(int n){
        float nums[] = new float[n*n];

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
            text +="| ";
            for( int j = 0; j< cols; j++){
                text+= String.format("%.0f \t", nums[i+rows*j]);
            }
            text+="|";
            text+=String.format("%n");
            
        }
        


        return text;
    }



}
