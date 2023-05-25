import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class keyChooser implements ActionListener{
    private static final Utilities utility = new Utilities();
    private static JPasswordField secretKey;
    private static final JPanel panel = new JPanel();
    private static JLabel badPasswordLabel;
    private static String directory;

    public keyChooser(String directoryChosen){
        directory = directoryChosen;
        frame();
    }
    public void frame(){
        JFrame window = new JFrame();
        window.setTitle("Secret Key registration");
        window.setSize(300,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.setResizable(false);

        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        JLabel label = new JLabel("Secret key, max 20 characters");
        label.setBounds(50,10,200,25);
        panel.add(label);

        secretKey = new JPasswordField(10);
        secretKey.setBounds(55,35,170,25);
        panel.add(secretKey);

        JLabel label1 = new JLabel();
        label1.setBounds(15,150,300,25);
        label1.setText("This is a secretKey to encode the passwords");
        panel.add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(65,170,300,25);
        label2.setText("The input can be anything");
        panel.add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(65,190,300,25);
        label3.setText("Between 10 and 20 chars.");
        panel.add(label3);

        JButton button = new JButton("Enter");
        button.setBounds(40,85,200,25);
        button.setRolloverEnabled(true);
        button.setFocusPainted(false);
        button.addActionListener(this);
        panel.add(button);

        badPasswordLabel = new JLabel("Password too long or short");
        badPasswordLabel.setBounds(60,120,200,25);
        badPasswordLabel.setForeground(Color.red);
        badPasswordLabel.setVisible(false);
        panel.add(badPasswordLabel);




        window.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (!utility.isThePasswordGood(secretKey.getText())){
            badPasswordLabel.setVisible(true);
            return;
        }
        String createFile = utility.createFile(directory,"mukatte.dio");

        if(createFile.equals("0")){
            return;
        }

        String hash = utility.hashingMethod(secretKey.getText());
        utility.writer(hash,directory,null);

    }

}
