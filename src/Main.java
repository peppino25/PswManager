import java.io.File;

public class Main {

    public static void main(String[] args){
        // Parent directory to check if the directory "Password manager" is there
        String[] directoryPath = {"C:\\Program Files (x86)", System.getProperty("user.home") + File.separator + "Documents"};
        String directoryName = "Passoword Manager";

        File directory1 = new File(directoryPath[0]);
        File directory2 = new File(directoryPath[1]);

        if(directory1.exists() && directory1.isDirectory()){

            File[] files = directory1.listFiles();
            if (files != null){
                for (File file: files){
                    if(file.isDirectory() && file.getName().equals(directoryName)){
                        new keyLogin();
                        return;
                    }
                }
            }
            System.out.println("Directory in Program filex (x86) does not exist");
        } if(directory2.exists() && directory2.isDirectory()){

            File[] files = directory2.listFiles();
            if (files != null){
                for (File file: files){
                    if(file.isDirectory() && file.getName().equals(directoryName)){
                        new keyLogin();
                        return;
                    }
                }
            }
            System.out.println("Directory in Documents does not exist");
            new keyChooser();
        }

    }
}
