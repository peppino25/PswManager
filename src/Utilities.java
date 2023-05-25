import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Utilities {
    private final Random generateKey = new Random();
    public Utilities(){

    }

    public boolean doesThatDirectoryExist(String[] directoryPath, String directoryName) {
        for (String s : directoryPath) {
            // Creating a new File object containing the directory path (s).
            File parentDirectory = new File(s);

            // Checking if the directory exists and if it is a directory.
            if (parentDirectory.exists() && parentDirectory.isDirectory()) {
                // Creating an Array File type variable listing every file that is in that directory.
                File[] files = parentDirectory.listFiles();

                // Checking if there are files in the directory.
                if (files != null) {
                    for (File file : files) {
                        // Checking if the file is a directory and the name is equal to the one we are looking for.
                        if (file.isDirectory() && file.getName().equals(directoryName)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String createDirectory(String[] directoryPath, String directoryName){
        String directoryChosen = "";

        // Tries to create a directory in one of the said path {directoryPath}.
        for(String i:directoryPath){
            try{
                File directory = new File(i + directoryName);

                boolean isCreated = directory.mkdir();

                if (isCreated){
                    System.out.print("Directory created successfully in " + i);
                    directoryChosen += i;
                    return directoryChosen;
                }

            }catch (Exception ex){
                System.out.print("Exception in the function createDirectory");
            }
        }
        return "0";

    }
    public String createFile(String filePath, String fileNameAndExtension){
        filePath = filePath += fileNameAndExtension;
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.close();
            System.out.println("The text file was created successfully");
            return filePath;
        }catch (IOException e){
            System.out.println("An error occurred while creating the text file: " + e.getMessage());
            return "0";
        }
    }

    public void writer(String textToWrite, String filePath, Character token){
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(textToWrite);
            myWriter.append(token);
            myWriter.close();
        }catch (IOException e){
            System.out.println("An error occurred." + e.getMessage());
        }
    }


    public boolean isThePasswordGood(String password){
        int passwordLength = password.length();
        return passwordLength >= 10 && passwordLength <= 20;

    }

    public String hashingMethod(String text){
        String hash;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes){
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            hash = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hash;
    }

    public boolean SHA256Verification(String hash, String textToCompare){
            String calculatedHash = hashingMethod(textToCompare);

            return calculatedHash.equals(hash);
    }

    public String Encryption(String textToEncrypt){
        int key = generateKey.nextInt(1000,9999);

        char[] textPreEncryption = textToEncrypt.toCharArray();

        String encryptedText = "";

        for (char chars:textPreEncryption){
            encryptedText += (chars += key);
        }

        encryptedText += ".";
        encryptedText += key;

        return encryptedText;

    }

    public String Decryption(String textToDecrypt){
        String[] tokens = textToDecrypt.split("[.]");
        List<String> tokenList = new ArrayList<String>(Arrays.asList(tokens));

        int key = Integer.parseInt(tokenList.get(1));
        char[] encryptedTextCharArray = tokenList.get(0).toCharArray();

        String decryptedText = "";

        for (char chars:encryptedTextCharArray){
            decryptedText += chars -= key;
        }

        return decryptedText;

    }

}
