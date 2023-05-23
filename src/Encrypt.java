import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Encrypt {
    private List<Character> text = new ArrayList<Character>();
    private final Random generateKey = new Random();
    private final int secretKey = 6969;

    public Encrypt(){
        Encryption("ciao");
        Decryption(text);

    }

    private void Encryption(String textToEncrypt){
        int key = generateKey.nextInt(5000);

        char[] textPreEncryption = textToEncrypt.toCharArray();

        for (char chars:textPreEncryption){
            text.add(0,chars += key);
        }

        char cKey = (char) key;

        text.add(cKey += secretKey);

    }

    private void Decryption(List<Character> textToDecrypt){
        char cKey = textToDecrypt.get(textToDecrypt.size() - 1);

        text.remove(textToDecrypt.size() -1 );

        int key = (int)cKey - secretKey;

        String decryptedText = "";

        for (int i = text.size() - 1; i >= 0; i--){
            char chars = text.get(i);
            decryptedText += (chars -= key);
        }

    }
}