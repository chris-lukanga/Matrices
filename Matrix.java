public class Matrix {

    private int cols;
    private int rows;
    private float nums[];


    /**
     * creates a mtrix of given size with the given data
     * @param rows the number of rows
     * @param cols the number of cols
     * @param nums a list of all the entries in the matrix, in row major order
     * @throws Exception
     */
    public Matrix(int rows, int cols, float[] nums) throws Exception{

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

    /**
     * Returns a column vector of the specified column
     * @param n the nth to return 
     * @return a nx1 column matrix
     * @throws Exception 
     */
    public Matrix getColVector(int n) throws Exception{
            float v[] = new float[rows];
            if(n > cols || n<=0){
                throw new Exception(" You asked for column "+ n+ " while only "+ cols+"  columns exists.");
            }
            for(int i = 0; i< rows; i++){
                v[i] = nums[i*cols +n-1];
            }

        return new Matrix(rows, 1, v);
    }

    /**
     * Returns a row vector with the specified column
     * @param n the nth row
     * @return a 1xn row matrix
     * @throws Exception
     */
        public Matrix getRowVector(int n) throws Exception{
            float v[] = new float[cols];
            if(n > rows || n<=0){
                throw new Exception(" You asked for row "+ n+ " while only "+ rows+"  rows exists.");
            }
            for(int i = 0; i< cols; i++){
                v[i] = nums[(n-1)*cols +i];
            }

        return new Matrix(1, cols, v);
    }


    /**
     * gets the value at the specified index
     * @param i the row
     * @param j the column
     * @return the value at that position
     * @throws Exception
     */
    public float getValueAt(int i, int j) throws Exception{
        j--;
        i--;
        if(i >rows || i<0){
            throw new Exception(" Row "+ i+" does not exist");
        }
        if(j>cols || j<0){
            throw new Exception(" Column " + j+" does not exist");
        }

        return nums[j + cols*(i)];
    }

    /**
     * sets the value at the specified index
     * @param i the row
     * @param j the column
     * @param value the value to set at that position
     * @return the value that was set
     * @throws Exception
     */
    public float setValueAt(int i, int j, float value) throws Exception{
        j--;
        i--;
        if(i >rows || i<0){
            throw new Exception(" Row "+ i+" does not exist");
        }
        if(j>cols || j<0){
            throw new Exception(" Column " + j+" does not exist");
        }

        return nums[j + cols*(i)] = value;
    }


    @Override 
    public String toString(){
        String text = "";
        text += String.format("Matrix with rows %d and columns %d%n", rows, cols);

        for(int i = 0; i< rows; i++){
            text +="| ";
            for( int j = 0; j< cols; j++){
                text+= String.format("%.0f ", nums[j+cols*i]);
                if(j < cols-1){
                    text+= "\t";
                }
            }
            text+="|";
            text+=String.format("%n");
            
        }
        return text;
    }


    /**
     * Matrix addition defined only when their dimensions are equal
     * @param other the other matrix
     * @return the new matrix which is the sum of the original plus the other
     * @throws Exception 
     */
    public Matrix addMatrix(Matrix other) throws Exception{
        

        //checking to see if dimensions are equal
        if(cols != other.cols || cols !=other.cols){
            throw new RuntimeException("Dimensions of matrices do not match");
        }

        float nums[] = new float[rows*cols];
        for(int i = 0; i<rows*cols; i++){
            nums[i] = this.nums[i] + other.nums[i];
        }
        return new Matrix(rows, cols, nums);

    }

    /**
     * Matrix subtraction defined only when their dimesions are equal
     * @param other
     * @return
     * @throws Exception
     */
    public Matrix subtractMatrix(Matrix other) throws Exception{
        

        return addMatrix(other.mult(-1));

    }


    /**
     * mutliplies each entry in the matrix by the value
     * @param k the value to multipy the matrix by
     */
    public Matrix mult(float k){
        for(int i = 0; i<rows*cols; i++){
            nums[i] = k*nums[i];
        }
        return this;
    }



    /**
     * Matrix multiplication defined only when the number of columns in the first matrix is equal to the number of rows in the second matrix
     * @param other
     * @return
     * @throws Exception 
     */
    public Matrix mult(Matrix other) throws Exception{

        //checking for the correct dimensions
        if(cols != other.rows){
            throw new RuntimeException("The number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        //getting the columns of the second matrix
        Matrix columns[] = new Matrix[other.cols];
        for(int i = 0; i< other.cols; i++){
            columns[i] = other.getColVector(i+1);
        };

        Matrix resultantCols[] = new Matrix[other.cols];

        for(int i = 0; i< other.cols; i++){
            resultantCols[i] = this.mult(columns[i].asArray());
        }

        Matrix result = new Matrix(rows, other.cols);
        for(int i = 0; i< other.cols; i++){
            for(int j = 0; j< rows; j++){
                result.setValueAt(j+1, i+1, resultantCols[i].getValueAt(j+1, 1));
            }
        }
        return result;

    }

    private Matrix mult(float[] colVector) throws Exception{
        float nums[] = new float[rows];
        for(int i = 0; i< rows; i++){
            float sum = 0;
            for(int j = 0; j< cols; j++){
                sum += this.getValueAt(i+1, j+1)*colVector[j];
            }
            nums[i] = sum;
        }
        return new Matrix(rows, 1, nums);
    }

    public float[] asArray(){
        return nums;
    }




}
