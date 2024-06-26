/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
import model.rumah.ModelRumah;

/**
 *
 * @author adity
 */
public class Tawar extends javax.swing.JFrame {

    /**
     * Creates new form Tawar
     */
    ControllerRumah controller;
    ControllerAuctioneer auction;
    public Tawar() {
        initComponents();
        controller=new ControllerRumah(this);
        auction = new ControllerAuctioneer(this);
        controller.showOfferedHouse();
    }

    
    public void setAlamat(String alamat) {
        labelalamat.setText(alamat);
    }
    
    public void setLuasTanah(Integer luasTanah) {
        labelluastanah.setText(String.valueOf(luasTanah));
    }
    
    public void setLuasBangunan(Integer luasBangunan) {
        labelluasbangunan.setText(String.valueOf(luasBangunan));
    }
    
    public void setKamarMandi(Integer kamarMandi) {
        labelkamarmandi.setText(String.valueOf(kamarMandi));
    }
    
    public void setKamarTidur(Integer kamarTidur) {
        labelkamartidur.setText(String.valueOf(kamarTidur));
    }
    
    public void setGarasi(Integer garasi) {
        labelgarasi.setText(String.valueOf(garasi));
    }
    
    public void setPrice(Integer price) {
        labelstartprice.setText(String.valueOf(price));
    }
    
    public void setStatus(String status) {
        labelstatus.setText(status);
    }
    
    public Integer getBargain(){
        return Integer.valueOf(inputtawarharga.getText());
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
        jPanel2 = new javax.swing.JPanel();
        inputtawarharga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonsubmittawar = new javax.swing.JButton();
        buttonkembali = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        labelstartprice = new javax.swing.JLabel();
        labelluasbangunan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelluastanah = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelkamartidur = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelkamarmandi = new javax.swing.JLabel();
        labelalamat = new javax.swing.JLabel();
        labelgarasi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 121, 171));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TAWAR HARGA");

        buttonsubmittawar.setBackground(new java.awt.Color(0, 153, 153));
        buttonsubmittawar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonsubmittawar.setText("Submit");
        buttonsubmittawar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsubmittawarActionPerformed(evt);
            }
        });

        buttonkembali.setBackground(new java.awt.Color(0, 204, 204));
        buttonkembali.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonkembali.setText("Kembali Ke Menu");
        buttonkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonkembaliActionPerformed(evt);
            }
        });

        jLabel16.setText("Status");

        labelstatus.setText("--Data Start Price--");

        labelstartprice.setText("--Data Start Price--");

        labelluasbangunan.setText("--Data Luas Bangunan--");

        jLabel5.setText("Jumlah Kamar Tidur");

        labelluastanah.setText("--Data Luas Tanah--");

        jLabel6.setText("Jumlah Kamar Mandi");

        labelkamartidur.setText("--Data Kamar Tidur--");

        jLabel7.setText("Jumlah Garasi");

        jLabel3.setText("Alamat Rumah");

        labelkamarmandi.setText("--Data Kamar  Mandi--");

        labelalamat.setText("--Data Alamat Rumah--");

        labelgarasi.setText("--Data Garasi--");

        jLabel4.setText("Luas Bangunan");

        jLabel15.setText("Start Price");

        jLabel8.setText("Luas Tanah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputtawarharga, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonsubmittawar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonkembali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelstatus)
                    .addComponent(labelgarasi)
                    .addComponent(labelkamartidur)
                    .addComponent(labelalamat)
                    .addComponent(labelkamarmandi)
                    .addComponent(labelstartprice)
                    .addComponent(labelluastanah)
                    .addComponent(labelluasbangunan))
                .addGap(140, 140, 140))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelalamat)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelluasbangunan))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelluastanah)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelkamartidur))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelkamarmandi))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelgarasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelstartprice)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(labelstatus))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputtawarharga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonsubmittawar)
                .addGap(18, 18, 18)
                .addComponent(buttonkembali)
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel2.setText("Tawar harga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel2)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonkembaliActionPerformed
        Menu_Utama_Pembeli buy = new Menu_Utama_Pembeli();
        buy.setVisible(true);
        buy.pack();
        buy.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_buttonkembaliActionPerformed

    private void buttonsubmittawarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsubmittawarActionPerformed
        auction.bargain();
        Menu_Utama_Pembeli buy = new Menu_Utama_Pembeli();
        buy.setVisible(true);
        buy.pack();
        buy.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_buttonsubmittawarActionPerformed

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
            java.util.logging.Logger.getLogger(Tawar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tawar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tawar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tawar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tawar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonkembali;
    private javax.swing.JButton buttonsubmittawar;
    private javax.swing.JTextField inputtawarharga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelalamat;
    private javax.swing.JLabel labelgarasi;
    private javax.swing.JLabel labelkamarmandi;
    private javax.swing.JLabel labelkamartidur;
    private javax.swing.JLabel labelluasbangunan;
    private javax.swing.JLabel labelluastanah;
    private javax.swing.JLabel labelstartprice;
    private javax.swing.JLabel labelstatus;
    // End of variables declaration//GEN-END:variables
}
