import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewWindow implements ActionListener {

    JRadioButton AbcButton = new JRadioButton("ABC");
    JRadioButton SpdbButton = new JRadioButton("SPDB");
    JRadioButton KkbButton = new JRadioButton("KKB");
    JRadioButton CcbaButton = new JRadioButton("CCBA");
    JRadioButton KpieButton = new JRadioButton("KPIE");
    JRadioButton BblButton = new JRadioButton("BBL");
    ButtonGroup group = new ButtonGroup();


    static JFrame frame;
    //cardPanel;
    JTextArea textarea = new JTextArea();
    public static String Client;
    JButton next = new JButton();


    JPanel ClientPanel;
    CardLayout cardLayout;
    JPanel cardPanel;


    public NewWindow() {

        ImageIcon image = new ImageIcon("C:\\Users\\MSI\\IdeaProjects\\Delivery\\src\\download.png");

        frame = new JFrame("Mega Delivery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(650, 650);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setIconImage(image.getImage());
        this.frame=frame;
        this.Client=Client;


        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        ClientPanel=new JPanel();
        ClientPanel.setBackground(new Color(208, 204, 204));
        ClientPanel.setBounds(0, 100, 650, 550);
        ClientPanel.setLayout(null);


        AbcButton.setBounds(150, 180, 300, 60);
        AbcButton.setFocusable(false);
        AbcButton.setFont(new Font("Palatino", Font.BOLD, 24));
        AbcButton.addActionListener(this);
        SpdbButton.setBounds(150, 230, 300, 60);
        SpdbButton.setFocusable(false);
        SpdbButton.setFont(new Font("Palatino", Font.BOLD, 24));
        SpdbButton.addActionListener(this);
        KkbButton.setBounds(150, 280, 300, 60);
        KkbButton.setFocusable(false);
        KkbButton.setFont(new Font("Palatino", Font.BOLD, 24));
        KkbButton.addActionListener(this);
        CcbaButton.setBounds(150, 330, 300, 60);
        CcbaButton.setFocusable(false);
        CcbaButton.setFont(new Font("Palatino", Font.BOLD, 24));
        CcbaButton.addActionListener(this);
        KpieButton.setBounds(150, 380, 300, 60);
        KpieButton.setFocusable(false);
        KpieButton.setFont(new Font("Palatino", Font.BOLD, 24));
        KpieButton.addActionListener(this);
        BblButton.setBounds(150, 430, 300, 60);
        BblButton.setFocusable(false);
        BblButton.setFont(new Font("Palatino", Font.BOLD, 24));
        BblButton.addActionListener(this);


        group.add(AbcButton);
        group.add(SpdbButton);
        group.add(KkbButton);
        group.add(CcbaButton);
        group.add(KpieButton);
        group.add(BblButton);




        ClientPanel.add(AbcButton);
        ClientPanel.add(SpdbButton);
        ClientPanel.add(KkbButton);
        ClientPanel.add(CcbaButton);
        ClientPanel.add(KpieButton);
        ClientPanel.add(BblButton);


        ArtifactPanel Panel2 = new ArtifactPanel();



        textarea.setBounds(0, 0, 650, 100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(255, 255, 255));
        textarea.setForeground(new Color(0, 0, 0));
        textarea.setFont(new Font("MV Boli", Font.BOLD, 23));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setCaretColor(Color.WHITE);
        textarea.setText("Client Select: \nSelect the recipient Client");



        ImageIcon image2 = new ImageIcon("C:\\Users\\MSI\\IdeaProjects\\Delivery\\src\\download2.png");
        Image originalImage = image2.getImage();
        Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        next.setBounds(530, 550, 100, 50);
        next.setFont(new Font("Ink Free", Font.BOLD, 14));
        next.setFocusable(false);
        next.addActionListener(this);
        next.setText("Next");
        next.setIconTextGap(5);
        next.setHorizontalTextPosition(JButton.LEFT);
        next.setIcon(resizedImageIcon);
        next.setVerticalTextPosition(JButton.CENTER);
        next.setEnabled(false);

        ClientPanel.add(next);
        ClientPanel.add(textarea);
        cardPanel.add(ClientPanel, "ClientPanel");
        cardPanel.add(Panel2, "ArtifactPanel");


        //frame.add(textarea);
        frame.add(cardPanel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            Client="";



            if (AbcButton.isSelected()) {
                Client = AbcButton.getText();



                
            }

            if (SpdbButton.isSelected()) {
                Client = SpdbButton.getText();

                 
            }
            if (KkbButton.isSelected()) {
                Client = KkbButton.getText();

                 
            }
            if (CcbaButton.isSelected()) {
                Client = CcbaButton.getText();

                 
            }
            if (KpieButton.isSelected()) {
                Client = KpieButton.getText();

                 
            }
            if (BblButton.isSelected()) {
                Client = BblButton.getText();

                 
            }

            cardLayout.show(cardPanel, "ArtifactPanel");
        }
        if (AbcButton.isSelected() || SpdbButton.isSelected() || KkbButton.isSelected() ||
                CcbaButton.isSelected() || KpieButton.isSelected() || BblButton.isSelected()) {
            next.setEnabled(true);
        } else {
            next.setEnabled(false);
        }


        }





    }














