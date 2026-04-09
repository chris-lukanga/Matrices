import java.io.File;

public class FileHandler {
    
    File file;

    public FileHandler(String filePath, boolean create, boolean binary) throws Exception{
        file = new File(filePath);
        if(create){
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
    }
}
