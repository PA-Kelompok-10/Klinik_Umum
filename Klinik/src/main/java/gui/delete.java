    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.*;
import Database.Database;
import javax.swing.table.DefaultTableModel;
import Class.pasien;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class delete extends javax.swing.JFrame {
    
    Database data = new Database();
    String namaDepan, namaBelakang, noTelepon, tanggalLahir, tanggalPeriksa, jenisKelamin, noKerabat, alamat;
    public static String idAdmin;
    String id;
    
    /**
     * Creates new form delete
     */
    public delete(String idAdmin) {
        initComponents();
        this.idAdmin = idAdmin;
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
        pasientbl = new javax.swing.JTable();
        idbox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pasientbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PASIEN", "NAMA DEPAN","NAMA BELAKANG", "NO TELEPON", "NO KERABAT",  "ALAMAT", "JENIS KELAMIN","TANGGAL LAHIR", "TANGGAL PERIKSA"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }

        }
    );
    pasientbl.addContainerListener(new java.awt.event.ContainerAdapter() {
        public void componentAdded(java.awt.event.ContainerEvent evt) {
            pasientblComponentAdded(evt);
        }
    });
    jScrollPane1.setViewportView(pasientbl);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 680, 250));

    idbox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            idboxActionPerformed(evt);
        }
    });
    getContentPane().add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 130, -1));

    jLabel2.setText("MASUKKAN ID YANG INGIN DIHAPUS");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

    jButton1.setText("BACK");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 60, 20));

    jButton2.setText("DELETE");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton2MouseClicked(evt);
        }
    });
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete (2).png"))); // NOI18N
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admindashboard dasbor = new Admindashboard(idAdmin, noKerabat);
        dasbor.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pasientblComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pasientblComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pasientblComponentAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pasien delPasien = new pasien(id, namaDepan, namaBelakang, noTelepon, noKerabat, tanggalLahir, tanggalPeriksa, jenisKelamin, alamat);
        delPasien.id = idbox.getText();
        
        if(delPasien.delete()){
            JOptionPane.showMessageDialog(rootPane, "data dihapus");
            idbox.setText("");
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "data tidak ditemukan");
            
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
                
    }//GEN-LAST:event_jButton2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Connection connection = data.openConnection();  
        String sql = "select * from pasien";
        try{
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = ( DefaultTableModel)pasientbl.getModel();
            while (rs.next()){
                model.addRow((new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)}));
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete(idAdmin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pasientbl;
    // End of variables declaration//GEN-END:variables
}
