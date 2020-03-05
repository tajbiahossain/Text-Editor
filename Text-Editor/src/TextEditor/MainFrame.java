package TextEditor;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    File currentEditingFile = null;
    //variables used for font personalisation
    int fontSize = 12;
    int FontStyle = 0;
    String font = "Calibri";
    int Red = 0, Green = 0, Blue = 0;

    public MainFrame() {
        initComponents();

        //Filters the files of type to display. Only text files can be worked with.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        FileOpener.setFileFilter(filter);

        //Launches the frame in the middle of the screen
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            
            //Confirms if the user wants to save the file before exiting the app
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int ans = JOptionPane.showConfirmDialog(rootPane, "Save changes and close?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    SaveChanges();
                }
            }

        });
    }

    //calls the file reading function
    public MainFrame(File file) {
        initComponents();
        this.setLocationRelativeTo(null);

        currentEditingFile = file;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        FileOpener.setFileFilter(filter);
        ReadFile(file);
    }

    //reads the file and sets it to the display
    public void ReadFile(File file) {
        try {
            Scanner scn = new Scanner(file);
            String buffer = "";
            while (scn.hasNext()) {
                buffer += scn.nextLine() + "\n";
            }
            Display.setText(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //saves any changes 
    public void SaveChanges() {
        try {
            PrintWriter printWriter = new PrintWriter(currentEditingFile);
            printWriter.write(Display.getText());
            printWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileOpener = new javax.swing.JFileChooser();
        SaveDialog = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        Open = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        IncreaseFont = new javax.swing.JButton();
        DecreaseFont = new javax.swing.JButton();
        Find = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Display = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        ChooseFont = new javax.swing.JComboBox<>();
        FontType = new javax.swing.JComboBox<>();
        R = new javax.swing.JSlider();
        G = new javax.swing.JSlider();
        B = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        SaveDialog.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        SaveDialog.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text Editor");

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TextEditor/open.png"))); // NOI18N
        Open.setText("Open");
        Open.setFocusable(false);
        Open.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Open.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jToolBar1.add(Open);

        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TextEditor/save.png"))); // NOI18N
        Save.setText("Save");
        Save.setFocusable(false);
        Save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jToolBar1.add(Save);

        IncreaseFont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TextEditor/increase.png"))); // NOI18N
        IncreaseFont.setText("Increase Font");
        IncreaseFont.setFocusable(false);
        IncreaseFont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IncreaseFont.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        IncreaseFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncreaseFontActionPerformed(evt);
            }
        });
        jToolBar1.add(IncreaseFont);

        DecreaseFont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TextEditor/decrease.png"))); // NOI18N
        DecreaseFont.setText("Decrease Font");
        DecreaseFont.setFocusable(false);
        DecreaseFont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DecreaseFont.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DecreaseFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecreaseFontActionPerformed(evt);
            }
        });
        jToolBar1.add(DecreaseFont);

        Find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TextEditor/search.png"))); // NOI18N
        Find.setText("Find");
        Find.setFocusable(false);
        Find.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Find.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Find);

        Display.setColumns(20);
        Display.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Display.setLineWrap(true);
        Display.setRows(5);
        jScrollPane1.setViewportView(Display);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        ChooseFont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Change Font...", "Ariel", "Calibri", "Century Gothic Tahoma", "Georgia", "Times New Roman", "Trebuchet MS" }));
        ChooseFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFontActionPerformed(evt);
            }
        });

        FontType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plain", "Bold", "Italic" }));
        FontType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontTypeActionPerformed(evt);
            }
        });

        R.setMajorTickSpacing(10);
        R.setMaximum(255);
        R.setPaintTicks(true);
        R.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RStateChanged(evt);
            }
        });

        G.setMajorTickSpacing(10);
        G.setMaximum(255);
        G.setPaintTicks(true);
        G.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GStateChanged(evt);
            }
        });

        B.setMajorTickSpacing(10);
        B.setMaximum(255);
        B.setPaintTicks(true);
        B.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BStateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLOR [R, G, B]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ChooseFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FontType, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseFont, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FontType, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        //File Open dialog shown here
        int status = FileOpener.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION) {
            if (currentEditingFile != null) {
                // a file is opened and edited in a new window
                MainFrame newWindow = new MainFrame(FileOpener.getSelectedFile());
                newWindow.setVisible(true);
                newWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                newWindow.pack();
                return;
            }
            currentEditingFile = FileOpener.getSelectedFile();//assigns selected file to our file variable
            System.out.println("File chosen. File name = " + FileOpener.getSelectedFile().getName());

            try {
                //the contents of the file are read and set on the display
                Scanner scn = new Scanner(new FileInputStream(currentEditingFile));
                String buffer = "";
                while (scn.hasNext()) {
                    buffer += scn.nextLine() + "\n";
                }
                Display.setText(buffer);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("No file selected");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //If an opened file is being edited then the contents are saved to the same file, currentEditingFile
        if (currentEditingFile != null) {
            try {
                PrintWriter printWriter = new PrintWriter(currentEditingFile);
                printWriter.write(Display.getText());
                printWriter.close();
                JOptionPane.showMessageDialog(rootPane, "Saved to " + currentEditingFile.getName(), "Done", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Directory is selected to save the file
            int status = SaveDialog.showOpenDialog(rootPane);
            if (status == JFileChooser.APPROVE_OPTION) {
                //File name is taken as input from user
                String fileName = JOptionPane.showInputDialog("File Name", "Untitled.txt");//default name is selected as 'Untitled'
                if (!fileName.contains(".txt")) {//if user does not input file type after file name then it is inserted
                    fileName += ".txt";
                }
                File f = new File(SaveDialog.getSelectedFile() + "\\" + fileName);
                if (f.exists()) {//in case a file with the same file name is already present then error dialog is shown and it is not saved
                    JOptionPane.showMessageDialog(rootPane, "File already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    try {// no files of the same name are found so new file is created and message dialog shows if it is saved successfully
                        f.createNewFile();
                        PrintWriter printWriter = new PrintWriter(f);
                        printWriter.write(Display.getText());
                        printWriter.close();
                        JOptionPane.showMessageDialog(rootPane, "Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {//if the user does not select any directory then error message is shown and file is not saved
                JOptionPane.showMessageDialog(rootPane, "Error occured", "Could not save", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_SaveActionPerformed

    //increases the font size by 1 with each press of button
    private void IncreaseFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncreaseFontActionPerformed
        Display.setFont(new java.awt.Font(font, FontStyle, ++fontSize));
    }//GEN-LAST:event_IncreaseFontActionPerformed

    //decreases the font size by 1 with each press of button
    private void DecreaseFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecreaseFontActionPerformed
       Display.setFont(new java.awt.Font(font, FontStyle, --fontSize));
    }//GEN-LAST:event_DecreaseFontActionPerformed

    //changes the font style depending on which index is selected from the ComboBox ChooseFont
    private void ChooseFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFontActionPerformed
        // TODO add your handling code here:
        font = ChooseFont.getSelectedItem().toString();
        Display.setFont(new java.awt.Font(font, FontStyle, fontSize));
    }//GEN-LAST:event_ChooseFontActionPerformed

    //changes the type of the font depending on which index is selected from the ComboBox FontType
    private void FontTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontTypeActionPerformed
        // TODO add your handling code here:
        FontStyle = FontType.getSelectedIndex();
        Display.setFont(new java.awt.Font(font , FontStyle, fontSize));
    }//GEN-LAST:event_FontTypeActionPerformed

//This function changes the color of the foreground depending on where the slider R is placed. Used for the color red
    private void RStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RStateChanged
        // TODO add your handling code here:
        Red = R.getValue();
        Display.setForeground(new java.awt.Color(Red, Green, Blue));
    }//GEN-LAST:event_RStateChanged

    //This function changes the color of the foreground depending on where the slider G is placed. Used for the color green
    private void GStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GStateChanged
        // TODO add your handling code here:
        Green = G.getValue();
        Display.setForeground(new java.awt.Color(Red, Green, Blue));
    }//GEN-LAST:event_GStateChanged

    //This function changes the color of the foreground depending on where the slider B is placed. Used for the color blue
    private void BStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BStateChanged
        // TODO add your handling code here:
        Blue = B.getValue();
        Display.setForeground(new java.awt.Color(Red, Green, Blue));
    }//GEN-LAST:event_BStateChanged
                      

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider B;
    private javax.swing.JComboBox<String> ChooseFont;
    private javax.swing.JButton DecreaseFont;
    private javax.swing.JTextArea Display;
    private javax.swing.JFileChooser FileOpener;
    private javax.swing.JButton Find;
    private javax.swing.JComboBox<String> FontType;
    private javax.swing.JSlider G;
    private javax.swing.JButton IncreaseFont;
    private javax.swing.JButton Open;
    private javax.swing.JSlider R;
    private javax.swing.JButton Save;
    private javax.swing.JFileChooser SaveDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
