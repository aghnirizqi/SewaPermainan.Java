/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author AghniSurmikem
 */
import koneksi.koneksiSewa;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class frmUtama extends javax.swing.JFrame {
    String user;
    String pass;
    String akses;
    ResultSet Data;
    String hasil;

    /**
     * Creates new form frmUtama
     */
    
    public frmUtama() {
        initComponents();
        this.pack();
        this.setSize(500,340);
        this.setLocationRelativeTo(null);
        jPanel2.hide();
        
    }
    
    public String CekLogin(){
        if (user.isEmpty() || pass.isEmpty()){
            return "Form belum lengkap";
        } else {
            try{
                Statement stat = koneksiSewa.getKoneksi().createStatement();
                Data = stat.executeQuery("select * from login where username='"+user+"' and password='"+pass+"'");
            if (Data.next()){
                akses = Data.getString("level");
                return akses;
            } else {
                return "Gagal login";
            }   
            } catch (SQLException salahe){
                return "Kesalahan : "+salahe;
            }
        }
    }
    
    public void admin(){
        penyewa.setEnabled(true);
        pegawai.setEnabled(true);
        mainan.setEnabled(true);
        transaksi.setEnabled(false);
        laporan.setEnabled(true);
        
    }
    public void kasir(){
        penyewa.setEnabled(false);
        pegawai.setEnabled(false);
        mainan.setEnabled(false);
        transaksi.setEnabled(true);
        laporan.setEnabled(false);
        
    }
    public void login(){
        user = username.getText();
        pass = password.getText();
        hasil = CekLogin();
        if (hasil.equals("Admin")) {
            jPanel2.hide();
            jPanel1.show();
            admin();
            JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
            /*this.dispose();
            new formUtama().setVisible(true);*/
        } else if(hasil.equals("Kasir")){
            jPanel2.hide();
            jPanel1.show();
            kasir();
            JOptionPane.showMessageDialog(null, "Selamat Datang Kasir");
        } else {
            JOptionPane.showMessageDialog(null, hasil);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pegawai = new javax.swing.JButton();
        penyewa = new javax.swing.JButton();
        mainan = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        keluar1 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU UTAMA PERSEWAAN WAHANA PERMAINAN");

        pegawai.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pegawai.setText("PEGAWAI ");
        pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiActionPerformed(evt);
            }
        });

        penyewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        penyewa.setText("PENYEWA");
        penyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penyewaMouseClicked(evt);
            }
        });
        penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penyewaActionPerformed(evt);
            }
        });

        mainan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        mainan.setText("NAMA WAHANA");
        mainan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainanActionPerformed(evt);
            }
        });

        laporan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        laporan.setText("LAPORAN ");
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });

        keluar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        keluar.setText("KELUAR");
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        transaksi.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        transaksi.setText("TRANSAKSI");
        transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(laporan)
                        .addGap(24, 24, 24)
                        .addComponent(keluar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(penyewa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mainan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mainan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jLabel2.setText("LOGIN WAHANA PERMAINAN");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jLabel3.setText("USERNAME");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jLabel4.setText("PASSWORD");

        login.setFont(new java.awt.Font("Lucida Handwriting", 0, 10)); // NOI18N
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        keluar1.setFont(new java.awt.Font("Lucida Handwriting", 0, 10)); // NOI18N
        keluar1.setText("CANCEL");
        keluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(141, 141, 141))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(login)
                        .addGap(18, 18, 18)
                        .addComponent(keluar1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(password))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(keluar1))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penyewaActionPerformed

    private void penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penyewaMouseClicked
        // TODO add your handling code here:
         new frmpenyewa().setVisible(true);
      
    }//GEN-LAST:event_penyewaMouseClicked

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarMouseClicked

    private void pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiActionPerformed
        // TODO add your handling code here:
        new frmPegawai().setVisible(true);
        
    }//GEN-LAST:event_pegawaiActionPerformed

    private void mainanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainanActionPerformed
        // TODO add your handling code here:
         new frmWahana().setVisible(true);
        
    }//GEN-LAST:event_mainanActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:   
        jPanel1.hide();
        jPanel2.show();
    }//GEN-LAST:event_keluarActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
        
    }//GEN-LAST:event_laporanActionPerformed

    private void keluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluar1ActionPerformed
        // TODO add your handling code here:
        username.setText("");
        password.setText("");
    }//GEN-LAST:event_keluar1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_loginActionPerformed

    private void transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiActionPerformed
        // TODO add your handling code here:
         new frmtransaksi().setVisible(true);
      
    }//GEN-LAST:event_transaksiActionPerformed

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
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                frmUtama FL = new frmUtama();
                /*FL.pack();
                FL.setSize(370, 280);
                FL.setLocationRelativeTo(null);*/
                FL.setVisible(true);
                FL.jPanel1.hide();
                FL.jPanel2.show();
            }
           
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton keluar;
    private javax.swing.JButton keluar1;
    private javax.swing.JButton laporan;
    private javax.swing.JButton login;
    private javax.swing.JButton mainan;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton pegawai;
    private javax.swing.JButton penyewa;
    private javax.swing.JButton transaksi;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
