/*
PiEncoder - An FFmpeg front end to encode video and audio on your Raspberry Pi.
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

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Profiles extends javax.swing.JFrame {

    private boolean ChangesMade = false;
    private final GUI updateGUI;
    public Profiles(GUI guiForm) {
        updateGUI = guiForm;
        initComponents();
        initProfileTable();
        this.jTextFieldDescription.requestFocus();
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
        jProfileTable = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldProfile = new javax.swing.JTextField();
        jTextFieldExtension = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("PiEncoder");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jProfileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Profile", "Extension"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jProfileTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProfileTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jProfileTable);

        jButtonAdd.setText("Add");
        jButtonAdd.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonDelete.setRolloverEnabled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.setPreferredSize(new java.awt.Dimension(80, 29));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        jLabel2.setText("Profile");

        jLabel3.setText("Extension");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldProfile)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        AddProfile();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        UpdateProfile();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        DeleteProfile();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        SaveChanges();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        CloseForm();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jProfileTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProfileTableMouseClicked
        GetFilterTableItem();
    }//GEN-LAST:event_jProfileTableMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        CloseForm();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Profiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTable jProfileTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldExtension;
    private javax.swing.JTextField jTextFieldProfile;
    // End of variables declaration//GEN-END:variables

////////////////////////////////////////////////////////////////////////////////

    DefaultTableModel TableModel;
    private void initProfileTable() {
        this.jProfileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jProfileTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.jProfileTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.jProfileTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.jProfileTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        TableModel = new DefaultTableModel();
        TableModel = (DefaultTableModel)jProfileTable.getModel();
        String Description;
        String Profile;
        String Extension;
        for (int Index = 0; Index < Config.EncodingProfiles.size(); Index++) {
            Description = Config.EncodingDescriptions.get(Index);
            Profile = Config.EncodingProfiles.get(Index);
            Extension = Config.EncodingExtensions.get(Index);
            TableModel.insertRow(TableModel.getRowCount(),new String[] {Description, Profile, Extension});
        }
    }//End Sub  
    
    private void GetFilterTableItem() {
        this.jTextFieldDescription.setText(String.valueOf(TableModel.getValueAt(jProfileTable.getSelectedRow(),0)));
        this.jTextFieldProfile.setText(String.valueOf(TableModel.getValueAt(jProfileTable.getSelectedRow(),1)));
        this.jTextFieldExtension.setText(String.valueOf(TableModel.getValueAt(jProfileTable.getSelectedRow(),2)));        
    }//End Sub  

    private void AddProfile() {
        if (NullFields() == true) {
            JOptionPane.showConfirmDialog(null, "Empty field not allowed", "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        TableModel.insertRow(TableModel.getRowCount(),new String[] {this.jTextFieldDescription.getText(), this.jTextFieldProfile.getText(), this.jTextFieldExtension.getText()});
        SetChanges();        
    }//End Sub  
    
    private void UpdateProfile() {
        if (NullFields() == true) {
            JOptionPane.showConfirmDialog(null, "Empty field not allowed", "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }        
        TableModel.setValueAt(this.jTextFieldDescription.getText(), jProfileTable.getSelectedRow(),0);
        TableModel.setValueAt(this.jTextFieldProfile.getText(), jProfileTable.getSelectedRow(),1);
        TableModel.setValueAt(this.jTextFieldExtension.getText(), jProfileTable.getSelectedRow(),2);
        SetChanges();        
    }//End Sub  
    
    private void DeleteProfile() {
        if (jProfileTable.getSelectedRow() > -1) {
            TableModel.removeRow(jProfileTable.getSelectedRow());
            SetChanges();
        }    
    }//End Sub  
    
    private void SetChanges() {
        ChangesMade = true;
        this.jTextFieldDescription.setText(null);
        this.jTextFieldProfile.setText(null);    
        this.jTextFieldExtension.setText(null);
        this.jTextFieldDescription.requestFocus();
    }//End Sub  
    
    private void SaveChanges() {
        UpdateProfileLists();
        Config.SaveConfig();
        updateGUI.UpdateComboBox();
        ChangesMade = false;  
    }//End Sub  
    
    private void UpdateProfileLists() {
        Config.EncodingDescriptions = new ArrayList<>();
        Config.EncodingProfiles = new ArrayList<>();
        Config.EncodingExtensions = new ArrayList<>();
        for (int row = 0;row < TableModel.getRowCount();row++) {
            Config.EncodingDescriptions.add((String) TableModel.getValueAt(row, 0));
            Config.EncodingProfiles.add((String) TableModel.getValueAt(row, 1));
            Config.EncodingExtensions.add((String) TableModel.getValueAt(row, 2));
        }
    }//End Sub      

    private void CheckSaveOnExit () {
        int YesNo = (JOptionPane.showConfirmDialog(null, "Save Changes", "PiEncoder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
        if (YesNo == 0) {                                      //Yes = 0  No = 1   
            SaveChanges();
        }
    }//End Sub    

    private void CloseForm() {
        if (ChangesMade == true) {
            CheckSaveOnExit();
        }
        this.setVisible(false);         
     }//End Sub  

    private boolean NullFields() {
        if (this.jTextFieldDescription.getText().length() == 0) {
            return true;
        }
        if (this.jTextFieldProfile.getText().length() == 0) {
            return true;
        }            
        if (this.jTextFieldExtension.getText().length() == 0) {
            return true;
        }            
        return false;
    }

}//End Class
