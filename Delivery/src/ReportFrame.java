import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportFrame extends JFrame implements ActionListener {

    JTextField filePathField;
    JTextArea textarea;
    JButton browseButton;
    JButton submitButton;
    List<String> filePaths;
    JButton FinishButton;
    ReportFrame() {
        ImageIcon image = new ImageIcon("C:\\Users\\MSI\\IdeaProjects\\Delivery\\src\\download1.png");
        this.setIconImage(image.getImage());
        this.setTitle("Report Browse");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        filePaths = ArtifactPanel.filePaths;


        filePathField = new JTextField(20);
        browseButton = new JButton("Browse File");
        submitButton = new JButton("Submit");
        browseButton.setFocusable(false);
        submitButton.setFocusable(false);
        browseButton.addActionListener(this);
        submitButton.addActionListener(this);

        FinishButton = new JButton("Finish");
        FinishButton.setBounds(210,265,70,40);
        FinishButton.setFocusable(false);
        FinishButton.addActionListener(this);

        textarea=new JTextArea();

        textarea.setBounds(45, 100, 390, 160);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(255, 255, 255));
        textarea.setForeground(new Color(0, 0, 0));
        textarea.setEditable(false);
        textarea.setCaretColor(Color.WHITE);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Selected File:"));
        panel.add(filePathField);
        panel.add(browseButton);
        panel.add(submitButton);
        this.add(textarea);
        this.add(FinishButton);

        this.add(panel);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePathField.setText(selectedFile.getAbsolutePath());
            }
        }
        if (e.getSource() == submitButton) {
            String filePath = filePathField.getText();

            if (!filePath.isEmpty()) {
                filePaths.add(filePath);
                JOptionPane.showMessageDialog(this, "File submitted: " + filePath);
                textarea.setText(textarea.getText()+"\n"+filePath);


            } else {
                JOptionPane.showMessageDialog(this, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == FinishButton) {
            this.dispose();

        }
    }
}