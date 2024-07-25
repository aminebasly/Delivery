import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArtifactPanel extends JPanel implements ActionListener {

    public JCheckBox dbs = new JCheckBox("DBScript");
    JCheckBox ear = new JCheckBox("Ear");
    JCheckBox cnfg= new JCheckBox("Configr");
    JCheckBox lc = new JCheckBox("LC");
    JCheckBox report = new JCheckBox("Report");
    JCheckBox job = new JCheckBox("Job");
    JButton next1 = new JButton();
    JCheckBox Ready = new JCheckBox("Is ur file Ready ?");
    JButton FinishButton=new JButton();
    JTextArea textarea = new JTextArea();
    JFrame frame;
    String FileName ,formattedDate,Artifacts;
    public static List<String> filePaths;
    public ArtifactPanel(){
        filePaths=new ArrayList<>();
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-");
        formattedDate = dateFormat.format(today);




        this.setBackground(new Color(208, 204, 204));
        this.setBounds(0, 100, 650, 550);
        this.setLayout(null);
        frame = NewWindow.frame;


        Ready.setBounds(25, 510, 300, 40);
        Ready.setFocusable(false);
        Ready.setFont(new Font("Consolas", Font.PLAIN, 24));
        Ready.setBackground(new Color(208, 204, 204));
        Ready.addActionListener(this);


        dbs.setBounds(150, 170, 300, 60);
        dbs.setFocusable(false);
        dbs.setFont(new Font("Palatino", Font.BOLD, 24));
        dbs.addActionListener(this);
        ear.setBounds(150, 220, 300, 60);
        ear.setFocusable(false);
        ear.addActionListener(this);
        ear.setFont(new Font("Palatino", Font.BOLD, 24));
        cnfg.setBounds(150, 270, 300, 60);
        cnfg.setFocusable(false);
        cnfg.setFont(new Font("Palatino", Font.BOLD, 24));
        cnfg.addActionListener(this);
        lc.setBounds(150, 320, 300, 60);
        lc.setFocusable(false);
        lc.setFont(new Font("Palatino", Font.BOLD, 24));
        lc.addActionListener(this);
        report.setBounds(150, 370, 300, 60);
        report.setFocusable(false);
        report.setFont(new Font("Palatino", Font.BOLD, 24));
        report.addActionListener(this);
        job.setBounds(150, 420, 300, 60);
        job.setFocusable(false);
        job.setFont(new Font("Palatino", Font.BOLD, 24));
        job.addActionListener(this);



        ImageIcon image2 = new ImageIcon("C:\\Users\\MSI\\IdeaProjects\\Delivery\\src\\download2.png");
        Image originalImage = image2.getImage();
        Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        next1.setIcon(resizedImageIcon);
        next1.setBounds(530, 550, 100, 50);
        next1.setFont(new Font("Ink Free", Font.BOLD, 14));
        next1.setFocusable(false);
        next1.addActionListener(this);
        next1.setText("Next");
        next1.setIconTextGap(5);

        next1.setHorizontalTextPosition(JButton.LEFT);
        next1.setVerticalTextPosition(JButton.CENTER);

        textarea.setBounds(0, 0, 650, 100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(255, 255, 255));
        textarea.setForeground(new Color(0, 0, 0));
        textarea.setFont(new Font("MV Boli", Font.BOLD, 23));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setCaretColor(Color.WHITE);
        textarea.setText("Artifacts Select: \nSelect Delivery Artifacts ");


        FinishButton = new JButton("Finish");
        FinishButton.setBounds(20,550,100,50);
        FinishButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        FinishButton.setFocusable(false);
        FinishButton.addActionListener(this);
        FinishButton.setEnabled(false);
        FinishButton.setHorizontalTextPosition(JButton.RIGHT);
        FinishButton.setVerticalTextPosition(JButton.CENTER);

        this.add(next1);
        this.add(textarea);
        this.add(dbs);
        this.add(ear);
        this.add(cnfg);
        this.add(lc);
        this.add(report);
        this.add(job);
        this.add(FinishButton);
        this.add(Ready);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next1) {
            Artifacts = "";
            if (dbs.isSelected()) Artifacts += dbs.getText() + " ";
            if (ear.isSelected()) Artifacts += ear.getText() + " ";
            if (cnfg.isSelected()) Artifacts += cnfg.getText() + " ";
            if (lc.isSelected()) Artifacts += lc.getText() + " ";
            if (report.isSelected()) Artifacts += report.getText() + " ";
            if (job.isSelected()) Artifacts += job.getText() + " E";




            if (job.isSelected()) {
                JobFrame JFrame = new JobFrame();


            }
            if (report.isSelected()) {
                ReportFrame RFrame = new ReportFrame();

            }
            if (lc.isSelected()) {
                LcFrame LcFrame = new LcFrame();

            }
            if (cnfg.isSelected()) {
                ConfigrFrame CFrame = new ConfigrFrame();

            }
            if (ear.isSelected()) {
                EarFrame EFrame = new EarFrame();

            }
            if (dbs.isSelected()) {
                DbsFrame DFrame = new DbsFrame();


            }

        }

        if (Ready.isSelected()) {
            FinishButton.setEnabled(true);
            next1.setEnabled(false);
        } else {
            FinishButton.setEnabled(false);
            next1.setEnabled(true);
        }
        if(e.getSource() == FinishButton){
            frame.dispose();




        }
        if(e.getSource()==FinishButton){
            if (!filePaths.isEmpty()) {
                FileName=formattedDate+NewWindow.Client+"-"+Artifacts;
                zipFiles(filePaths);
            }




        }

    }
    private void zipFiles(List<String> filePaths) {
        String zipFilePath = "C:\\Users\\MSI\\Desktop\\Test\\"+ FileName +".zip";

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (String filePath : filePaths) {
                File file = new File(filePath);
                if (file.exists()) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zos.putNextEntry(zipEntry);

                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, bytesRead);
                    }
                    fis.close();
                    zos.closeEntry();
                } else {
                    System.out.println("File does not exist: " + filePath);
                }
            }

            JOptionPane.showMessageDialog(this, "Files zipped successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error zipping files: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    }



