/*
PiEncoder - a basic FFmpeg front end.
Written as part of my project for using FFmpeg to encode video and audio on a Raspberry Pi.
Copyright (C) 2016 morituri

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see http://www.gnu.org/licenses.
 */

package jPiEncoder;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        if (CheckForConfigFile() == false) {
            System.exit(0);    
        }
        initComponents();
        initIcon();
        if (initConfig()== false) {
            System.exit(0); 
        }
        initDragAndDrop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButtonRemove = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonConvert = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jComboBox1 = new javax.swing.JComboBox();
        jLabelFileName = new javax.swing.JLabel();
        jLabelTimeElapsed = new javax.swing.JLabel();
        jLabelTimeRemaining = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemDragAndDropFilter = new javax.swing.JMenuItem();
        jMenuItemConversionProfiles = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PiEncoder 0.3.1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 100));
        setMinimumSize(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButtonRemove.setText("Remove");
        jButtonRemove.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.setOpaque(true);
        jButtonClear.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonConvert.setText("Convert");
        jButtonConvert.setOpaque(true);
        jButtonConvert.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConvertActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(79, 29));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelFileName.setText(" ");

        jLabelTimeElapsed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTimeElapsed.setText("00:00:00");
        jLabelTimeElapsed.setToolTipText("");
        jLabelTimeElapsed.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelTimeRemaining.setText("00:00:00");

        jMenu1.setText("Options");

        jMenuItemDragAndDropFilter.setText("Drag and Drop Filter");
        jMenuItemDragAndDropFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDragAndDropFilterActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDragAndDropFilter);

        jMenuItemConversionProfiles.setText("Conversion Profiles");
        jMenuItemConversionProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConversionProfilesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemConversionProfiles);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTimeElapsed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTimeRemaining))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFileName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 410, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabelFileName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTimeRemaining)
                    .addComponent(jLabelTimeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonRemove.getAccessibleContext().setAccessibleName("jButtonRemove");
        jButtonClear.getAccessibleContext().setAccessibleName("jButtonClear");
        jButtonConvert.getAccessibleContext().setAccessibleName("jButtonConvert");

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        RemoveDragAndDropItem();
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        ClearAllDragAndDropItems();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConvertActionPerformed
        InitiateConversion();
    }//GEN-LAST:event_jButtonConvertActionPerformed

    private void jMenuItemDragAndDropFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDragAndDropFilterActionPerformed
        UpdateDragAndDropFilter();
    }//GEN-LAST:event_jMenuItemDragAndDropFilterActionPerformed

    private void jMenuItemConversionProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConversionProfilesActionPerformed
        UpdateConversionProfiles();
    }//GEN-LAST:event_jMenuItemConversionProfilesActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        CloseApplication();
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        GetComboBoxSelection();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        CloseApplication();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonConvert;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabelFileName;
    private javax.swing.JLabel jLabelTimeElapsed;
    private javax.swing.JLabel jLabelTimeRemaining;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemConversionProfiles;
    private javax.swing.JMenuItem jMenuItemDragAndDropFilter;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    
////////////////////////////////////////////////////////////////////////////////
    
         
    private void RemoveDragAndDropItem() {
        int SelectedIndex = jList1.getSelectedIndex();
        if (SelectedIndex > -1) {
            listModel.remove(SelectedIndex);
        }       
     }//End Sub
    
    private void ClearAllDragAndDropItems() {
        listModel.removeAllElements();        
    }//End Sub
    
    private void InitiateConversion() {
        if (ValidateData() == false) {
            return;
        }
        Index = -1;
        ToggleControls(false);
        GetConversionArguments();
        new Thread() {
            @Override
            public void run() {
                Start();
            }
        }.start();
    }//End Sub
    
    private void UpdateDragAndDropFilter() {
       DnDFilter f = new DnDFilter();
       f.setVisible(true);
    }//End Sub   
    
    private void UpdateConversionProfiles() {
        Profiles f = new Profiles(this);
        f.setVisible(true);        
    }//End Sub
    
    private void CloseApplication() {
        if (Encoding == true) {
            if (ConfirmExit() == false) {
                return;
            }
        }
        System.exit(0);   
    }//End Sub
    
    private boolean ConfirmExit() {
        int YesNo = (JOptionPane.showConfirmDialog(null, "Encoder is still running \nAre you sure you want to quit", "PiEncoder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
        if (YesNo == JOptionPane.YES_OPTION) {
            return true;
        }
        else {
            return false;
        }
    }//End Sub
        
    private void GetComboBoxSelection() {
        try {
            int SelectionIndex = jComboBox1.getSelectedIndex();
            this.jLabelFileName.setText(Config.EncodingProfiles.get(SelectionIndex));
        }
        catch (Exception ex) {
        }        
    }//End Sub

    private boolean CheckForConfigFile() {
        try {
            Config.ConfigFile = new File(URLDecoder.decode(Config.ConfigFile, "UTF-8")).toString();
        }
        catch (Exception ex) {
        }
        File ConfigFilePath = new File(Config.ConfigFile);
        if (ConfigFilePath.exists() == false) {
            JOptionPane.showConfirmDialog(null, "Cannot continue, file not found : " + ConfigFilePath, "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;   
        }    
        return true;
    }//End Sub

    private void initIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icon.png")));
    }//End Sub
    
    private boolean initConfig() {
        if (Config.ReadConfig() == false) {
            JOptionPane.showConfirmDialog(null, "Cannot continue, error reading Config File", "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        UpdateComboBox();
        return true;
    }//End Sub

    public void UpdateComboBox() {
        this.jComboBox1.removeAllItems();
        String ComboDescription;
        for (int i = 0; i < Config.EncodingDescriptions.size(); i++) {
            ComboDescription = Config.EncodingDescriptions.get(i)
            + " ("
            + Config.EncodingExtensions.get(i)
            + ")";        
            this.jComboBox1.addItem(ComboDescription);
        }
    }//End Sub
  
    private DefaultListModel listModel;
    private void initDragAndDrop() {
        listModel = new DefaultListModel();
        JList ListBoxList = new JList();
        ListBoxList.setModel(listModel); 
        jList1.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent e) {
                try {
                    e.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> DroppedFiles = (List<File>) e.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    for (File FileDropped : DroppedFiles) {
                        if (CheckExtensionValid(FileDropped) == true) {
                            listModel.addElement(FileDropped.getAbsolutePath());
                        }
                    }
                } 
                catch (Exception ex) {
                    //System.out.println(ex.getMessage());
                }
            }
        });
        jList1.setModel(listModel);
    }//End Sub
    
    private boolean CheckExtensionValid(File FileDropped) {
        String FileExtension = GetFileExtension(FileDropped);
        for (String ExtensionFilter : Config.DragAndDropFilter) {
	    if (FileExtension.toLowerCase().equals(ExtensionFilter.toLowerCase())) {
                return true;
            }
	}
        return false;
    }//End Sub
    
    private String GetFileExtension (File FileDropped) {
        String NameOfFile = FileDropped.getName();
        int index = NameOfFile.lastIndexOf(".");
        String FileExtension = NameOfFile.substring(index+1);
        return FileExtension; 
    }//End Sub   

    private boolean ValidateData() {
        ListModel model = jList1.getModel();
        if (model.getSize() == 0) {
            JOptionPane.showConfirmDialog(null, "Nothing to convert", "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }//End Sub
    
    private String ConversionArguments;
    private void GetConversionArguments() {
        int SelectionIndex = jComboBox1.getSelectedIndex();
        String Profile = Config.EncodingProfiles.get(SelectionIndex);
        String Extension = Config.EncodingExtensions.get(SelectionIndex);
        ConversionArguments = "ffmpeg -i [FILEPATH] " + Profile + " -y [FILEPATH]." + Extension;
    }//End Sub
    
    private int Index;
    private void Start() {
                Index = Index + 1;
                ListModel model = jList1.getModel();
                if (Index == model.getSize()) {
                    UpdateTimeRemaining("00;00;00");
                    ToggleControls(true);
                    return;
                }
                jList1.setSelectedIndex(Index);
                String FilePath =  model.getElementAt(Index).toString(); 
                DoConversion(FilePath);
    }//End Sub
    
    private boolean Encoding = false;
    private AppTimer timer = new AppTimer(this);
    private void DoConversion(String FilePath) {
        this.jProgressBar1.setValue((0));
        this.jProgressBar1.setMaximum(100);
        this.jProgressBar1.setStringPainted(true);
        Path path = Paths.get(FilePath);
        this.jLabelFileName.setText(path.getFileName().toString());
        try {
            // use URLEncode / Decode ??
            String xFilePath = FilePath.replace(" ","[SPACEREPLACER]");
            String ffmpegArguments = ConversionArguments.replace("[FILEPATH]", xFilePath);
            String[] Params = ffmpegArguments.split(" ");
            for (int i = 0; i < Params.length ; i++) {
                Params[i] = Params[i].replace("[SPACEREPLACER]", " "); 
            }
            ProcessBuilder pb = new ProcessBuilder(Params);
            Encoding = true;
            timer.Start();
            Process p = pb.start();
                    Scanner Scan = new Scanner(p.getErrorStream());
                    Pattern RegexDuration = Pattern.compile("(?<=Duration: )[^,]*");
                    String Duration = Scan.findWithinHorizon(RegexDuration, 0);
                    if (Duration == null) {
                        Encoding = false;
                        timer.Stop();
                        Scan.close();
                        Start();
                        //throw new RuntimeException();
                    }
                    String[] hms = Duration.split(":");
                    double TotalSeconds = Integer.parseInt(hms[0]) * 3600
                        + Integer.parseInt(hms[1]) *   60
                        + Double.parseDouble(hms[2]);
                    Pattern RegexTime = Pattern.compile("(?<=time=)[\\d:.]*");
                    String Match;
                    String[] SplitMatch;
                    double Progress;
                    double PercentageDone;
                    while (null != (Match = Scan.findWithinHorizon(RegexTime, 0))) {
                        SplitMatch = Match.split(":");
                        Progress = Integer.parseInt(SplitMatch[0]) * 3600 +
                        Integer.parseInt(SplitMatch[1]) * 60 +
                        Double.parseDouble(SplitMatch[2]);
                        PercentageDone = Progress/TotalSeconds * 100;
                        timer.PercentageDone = PercentageDone;
                        jProgressBar1.setValue(((int)PercentageDone));
                    }
                    jProgressBar1.setValue(100);
                    Encoding = false;
                    timer.Stop();
                    Scan.close();
                    Start();
        }
        catch(Exception ex) {
            //throw new RuntimeException();
        }        
    }//End Sub  

    private void ToggleControls(boolean Toggle) {
        this.jList1.setEnabled(Toggle);
        this.jButtonRemove.setEnabled(Toggle);
        this.jButtonClear.setEnabled(Toggle);
        this.jButtonConvert.setEnabled(Toggle);
        this.jComboBox1.setEnabled(Toggle);
        this.jMenu1.setEnabled(Toggle);
    }//End Sub

    public void UpdateTimeElapsed(String  LabelText) {
        this.jLabelTimeElapsed.setText(LabelText);  
    }//End Sub 
    
    public void UpdateTimeRemaining(String LabelText) {
        this.jLabelTimeRemaining.setText(LabelText);
    }//End Sub

}//End Class  
