import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class keyChooser implements ActionListener{
    private static final Utilities utility = new Utilities();
    public keyChooser(){
        frame();
    }
    public void frame(){
        JPanel panel = new JPanel();
        JFrame window = new JFrame();
        window.setTitle("Secret Key registration");
        window.setSize(300,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.setResizable(false);

        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        JLabel label = new JLabel("Only numbers, max 10 chars.");
        label.setBounds(56,10,200,25);
        panel.add(label);


        JPasswordField secretKey = new JPasswordField(10);
        secretKey.setBounds(55,35,170,25);
        panel.add(secretKey);

        JLabel label1 = new JLabel();
        label1.setBounds(10,150,300,25);
        label1.setText("This is a secretKey to encode the passwords");
        panel.add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(60,170,300,25);
        label2.setText("The input must be numerical");
        panel.add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(70,190,300,25);
        label3.setText("Between 1 and 10 chars.");
        panel.add(label3);

        JButton button = new JButton("Enter");
        button.setBounds(40,85,200,25);
        button.setRolloverEnabled(true);
        button.setFocusPainted(false);
        button.addActionListener(this);
        panel.add(button);



        window.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        String[] directoryPath = {"C:\\Program Files (x86)", System.getProperty("user.home") + File.separator + "Documents"};
        String directoryName = "Passoword Manager";
        String directoryChosen = "";

        int counterOfError = 0;

        // Tries to create a directory in one of the said path {directoryPath}.
        for(String i:directoryPath){
            try{
                File directory = new File(i);
                boolean isCreated = directory.mkdir();
                if (isCreated){
                    System.out.print("Directory created successfully in " + i);
                    directoryChosen += i;
                    break;
                }
                counterOfError += 1;

            }catch (Exception ex){
                System.out.print("Exception in the function actionPerformed");
            }
        }
        // Check if the directory was not created.
        if (counterOfError == 2){
            System.out.print("Error creating the directory of the program");
            return;
        }

        





    }

}
