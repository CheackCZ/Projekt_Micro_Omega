package first_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * JPanel with file opening
 * @author ondra
 */
public class FirstWindow_File_JP extends JPanel {

    /**  JTextfield that shows the name of the uploaded file */
    private JTextField txtFileName;

    /** Button for uploading the CSV file */
    private JButton btnUploadFile;

    /** Buttons at the first window (JPanel) */
    private FirstWindow_Buttons_JP firstWindowButtonsJP;

    /** First window */
    private First_Window firstWindow;

    /**
     * @param firstWindowButtonsJP - window with buttons
     * @param firstWindow - firt window
     */
    public FirstWindow_File_JP(FirstWindow_Buttons_JP firstWindowButtonsJP, First_Window firstWindow) {

        //Declarations of JPanels and Objects
        this.firstWindowButtonsJP = firstWindowButtonsJP;
        this.firstWindow = firstWindow;


        setLayout(null);
        setBackground(Color.darkGray);


        btnUploadFile = new JButton("Upload File");
        btnUploadFile.setBounds(10, 10, 125, 30);
        btnUploadFile.setFont(new Font("Arial Black", Font.BOLD, 11));
        btnUploadFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUploadFile.setFocusable(false);
        btnUploadFile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnUploadFile.setBackground(Color.WHITE);
        btnUploadFile.setToolTipText("Button to upload the csv file");
        btnUploadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  //Method for search and uploading the file from file system
                uploadFile(e);
            }
        });
        add(btnUploadFile);


        txtFileName = new JTextField("");
        txtFileName.setHorizontalAlignment(SwingConstants.LEFT);
        txtFileName.setBounds(140, 10, 290, 30);
        txtFileName.setFont(new Font("Arial", Font.ITALIC, 10));
        txtFileName.setForeground(Color.gray);
        txtFileName.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        txtFileName.setBackground(Color.darkGray);
        add(txtFileName);
        txtFileName.setColumns(10);

    }

    //Getters and Setters
    /**
     * @return -ing the file name
     */
    public JTextField getTxtFileName() {
        return txtFileName;
    }
    /**
     * @param txtFileName setting the file name
     */
    public void setTxtFileName(JTextField txtFileName) {
        this.txtFileName = txtFileName;
    }


    /**
     * Method for search and uploading the file from file system
     * @param e - using in ActionListener
     */
    public void uploadFile(ActionEvent e) {
        boolean emptyText = true;

        String text = firstWindow.getTxtCompetitionName().getText().trim().toLowerCase();

        if (text.equals("enter the competition name") || (text.equals(""))) {
            emptyText = false;
        }

        if (e.getSource() == btnUploadFile) {
            JFileChooser fileChooser = new JFileChooser();  //JFileChooser to choose in file system

            fileChooser.setPreferredSize(new Dimension(800, 500));  //Setting the size of the file chooser
            fileChooser.setDialogTitle("Choose a file");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");  //Shows only CSV type files

            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                txtFileName.setText("File name: " + fileChooser.getSelectedFile().getName());
                firstWindowButtonsJP.getBtnViewFile().setEnabled(true);
                firstWindowButtonsJP.setPath(fileChooser.getSelectedFile().getAbsolutePath());
                if (emptyText && text.length() > 5) {
                    //Regex controlling if the given name uses correct alphanumeric values
                    if (firstWindow.getTxtCompetitionName().getText().matches("^[a-zìšèøıáíéùA-ZÌŠÈØİÁÍÉÙ0-9, ]{1,50}$")) {
                        firstWindowButtonsJP.getBtnContinue().setEnabled(true);
                    }
                }
            }
        }
    }}
