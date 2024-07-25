import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery implements ActionListener  {
    JLabel label;
    JFrame frame;
    JButton button;
    JTextField textfield = new JTextField();

    public Delivery() {
        ImageIcon image = new ImageIcon("C:\\Users\\MSI\\IdeaProjects\\Delivery\\src\\download.png");
        frame = new JFrame("Mega Delivery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(650, 650);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setIconImage(image.getImage());

        textfield.setBounds(0, 0, 650, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("Welcome to Mega Delivery");


        label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.GREEN, 10);
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("MV BOLI", Font.PLAIN, 40));
        label.setIconTextGap(20);
        label.setBackground(Color.WHITE);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(110, 90, 380, 380);
        label.setOpaque(true);

        button = new JButton();
        button.setBounds(260, 510, 100, 70);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setText("Begin");
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(new Font("Ink Free", Font.BOLD, 30));
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);
        button.setBorder(BorderFactory.createEtchedBorder());


        frame.add(button);
        frame.add(label);
        frame.add(textfield);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            NewWindow NewWindow=new NewWindow();
        }

    }
}








