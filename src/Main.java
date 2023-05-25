import java.io.File;

public class Main {
    private static final Utilities utility = new Utilities();

    public static void main(String[] args){
        String[] parentDirectory = {"C:\\Program Files (x86)\\", System.getProperty("user.home") + File.separator + "Documents"};
        String folderName = "Password Manager";

        if (utility.doesThatDirectoryExist(parentDirectory, folderName)){
            new keyLogin();
        }

        String directoryChosen = utility.createDirectory(parentDirectory, folderName);

        if (directoryChosen.equals("0")){
            System.out.print("Problem creating the directory");
        }
        new keyChooser();






    }


}
