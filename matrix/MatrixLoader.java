package matrix;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MatrixLoader {
    
    private File file;
    private Matrix Matrixes[];

    public MatrixLoader(String filePath, boolean create, boolean binary) throws Exception{
        file = new File(filePath);
        if(create){
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
    }

    public static Matrix[] readFromFile(File file) throws Exception{
        Matrix[] Matrixes = null;


        //Reading from file using ARM
        try(
            Scanner sc = new Scanner(file);
            
        ){
            sc.useDelimiter("[,\\s]+");
            int numOfMatrixes = sc.nextInt();
            System.out.println("Number of matrixes: " + numOfMatrixes);
            Matrixes = new Matrix[numOfMatrixes];

            for(int i = 0; i< numOfMatrixes; i++){
                int rows = sc.nextInt();
                int cols = sc.nextInt();
                System.out.println("Matrix " + (i+1) + ": " + rows + "x" + cols);
                sc.nextLine(); // Move to the next line after reading rows and cols
                float[] values = new float[rows*cols];
                for(int j = 0; j< rows; j++){
                    String line = sc.nextLine();
                    String[] tokens = line.trim().split("[,\\s]+");
                    for(int k = 0; k< cols; k++){
                        values[j*cols + k] = Float.parseFloat(tokens[k]);
                    }
                }
                Matrixes[i] = new Matrix(rows, cols, values);
            }


        }
        catch(Exception e){
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return Matrixes;

    }


    public static void writeToFile(File file, Matrix[] Matrixes, boolean append) throws Exception{

        try(
            PrintWriter pw = new PrintWriter(new FileWriter(file, append));

        ){
            pw.println(Matrixes.length);
            for(Matrix m : Matrixes){
                pw.println(m.getRows() + "," + m.getCols());
                for(int i = 1; i<= m.getRows(); i++){
                    for(int j = 1; j<= m.getCols(); j++){
                        pw.print(m.getValueAt(i, j) + ",");
                    }
                    pw.println();
                }
            }

        }
        catch(Exception e){
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void writeToFiile(File file, Matrix m, boolean append) throws Exception{
        writeToFile(file, new Matrix[]{m}, append);
    }


    
}
