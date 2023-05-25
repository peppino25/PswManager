import java.io.File;

public class Utilities {
    public Utilities(){

    }

    public boolean doesThatDirectoryExist(String[] directory, String directoryName) {


        for (String s : directory) {
            File parentDirectory = new File(s);

            if (parentDirectory.exists() && parentDirectory.isDirectory()) {
                File[] files = parentDirectory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory() && file.getName().equals(directoryName)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
