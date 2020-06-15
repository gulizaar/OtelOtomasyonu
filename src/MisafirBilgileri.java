
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class MisafirBilgileri extends javax.swing.JFrame {

   DefaultTableModel tablo= new DefaultTableModel();
 
      
      public static Connection baglan=null;
      String bag="jdbc:mysql://localhost:3306/otel_otomasyonu";
      String kullaniciadi="root";
      String sifre="";
        
    public MisafirBilgileri() {
        
        initComponents();
          try {
              
            misafirleriGetir();
        
        } 
          catch (SQLException ex) {
            System.out.println("HATA");
        }
    }

    public void KayıtSil(String Tc){
        
        try{
            Statement st=baglantiAc();
            st.executeUpdate("DELETE fROM otel_otomasyonu.misafirler where TC=" +Tc);
            bağlantıKapat();
            misafirleriGetir();
            JOptionPane.showMessageDialog(rootPane, "Seçilen Kayıt Silindi");
            
            
        }
        catch(Exception e){
            System.out.println("Bir hata oluştu" +e);
            
        }
   
    }
    
     public void KayıtGüncelle(String Tc,String ad,String soyad,String telefon,String adres,String giriş_tarihi,String çıkış_tarihi,String oda_numarası,String eski_TC){
        
        try{
            Statement st = baglantiAc();
            String sql = "UPDATE misafirler SET  TC='" +Tc+ "', Ad='" +ad+ "',Soyad='" +soyad+ "',Telefon='" +telefon+ "',Adres='" +adres+ "',Giriş_tarihi='" +giriş_tarihi+ "',Çıkış_tarihi='" +çıkış_tarihi+ "',Oda_Numarası='" +oda_numarası+ "' WHERE TC='" +eski_TC+"' ";
             
            st.executeUpdate(sql);
            
            misafirleriGetir();
            bağlantıKapat();
            JOptionPane.showMessageDialog(rootPane, "Bilgiler Güncellendi.");
            
            
        }
        catch(Exception e){
            System.out.println("Bir Hata Oluştu"+e);
        }
        
        
    }
     
      public void KayıtEkle (String Tc, String adı, String soyadı,String telefonu,String adresi,String giriş_tarihi,String çıkış_tarihi,String oda_numarası){
          try{
              
              Statement st = baglantiAc();
              String sql = "Insert Into  misafirler (TC,Ad,Soyad,Telefon,Adres,Giriş_tarihi,Çıkış_tarihi,Oda_Numarası) VALUES("+ "'" + Tc + "'," + "'" +adı+ "'," + "'" + soyadı+ "'," + "'" + telefonu + "'," + "'" + adresi + "'," + "'" + giriş_tarihi + "'," + "'" + çıkış_tarihi +"'," + "'" + oda_numarası +"') " ;
              st.executeUpdate(sql);
              bağlantıKapat();
              misafirleriGetir();
          }
          catch(Exception e){
              System.out.println("Hata Oluştu"+e);
          
          
      }
      } 
      
      public void misafirleriGetir() throws SQLException {
          
         Connection con= null;
         
          try{
          
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection(bag,kullaniciadi,sifre);
          String sql = "SELECT * FROM misafirler";
          PreparedStatement pstmt =  con.prepareStatement(sql);
          ResultSet rs= pstmt.executeQuery();
          Bilgi_Tablosu.setModel(DbUtils.resultSetToTableModel(rs));
          con.close();
          }
          
          catch(Exception e){
              System.out.println("Hata"+e);
          }

          }
      
      
      public  Statement baglantiAc() throws ClassNotFoundException, SQLException{
        
        
             Class.forName("com.mysql.jdbc.Driver");
             
             baglan=DriverManager.getConnection(bag,kullaniciadi,sifre);
             return baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
             
       

    }
    
    public void bağlantıKapat(){
        
        try{
            baglan.close();
        }
        catch(SQLException e){
            System.out.println("Veritabanı kapatma işlemi başarısız oldu.");
        }
        
        
    }
     
     
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        Kayıt_Güncelle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sys_giriş = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sys_çıkış = new javax.swing.JTextField();
        sys_tc = new javax.swing.JTextField();
        sys_odaNo = new javax.swing.JTextField();
        sys_soyad = new javax.swing.JTextField();
        Kaydet_butonu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Sil_butonu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Çıkış_butonu = new javax.swing.JButton();
        sys_adres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Bilgi_Tablosu = new javax.swing.JTable();
        sys_telefon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sys_ad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));

        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Çıkış Tarihi :");

        Kayıt_Güncelle.setBackground(new java.awt.Color(255, 204, 255));
        Kayıt_Güncelle.setForeground(new java.awt.Color(0, 102, 102));
        Kayıt_Güncelle.setText("Bilgileri Güncelle");
        Kayıt_Güncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kayıt_GüncelleActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Tc Kimlik No :");

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Oda Numarası :");

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Adı :");

        sys_giriş.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Soyadı :");

        sys_çıkış.setBackground(new java.awt.Color(204, 204, 255));
        sys_çıkış.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys_çıkışActionPerformed(evt);
            }
        });

        sys_tc.setBackground(new java.awt.Color(204, 204, 255));
        sys_tc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys_tcActionPerformed(evt);
            }
        });

        sys_odaNo.setBackground(new java.awt.Color(204, 204, 255));

        sys_soyad.setBackground(new java.awt.Color(204, 204, 255));

        Kaydet_butonu.setBackground(new java.awt.Color(255, 204, 255));
        Kaydet_butonu.setForeground(new java.awt.Color(0, 102, 102));
        Kaydet_butonu.setText("Kayıt Oluştur");
        Kaydet_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kaydet_butonuActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Telefon :");

        Sil_butonu.setBackground(new java.awt.Color(255, 204, 255));
        Sil_butonu.setForeground(new java.awt.Color(0, 102, 102));
        Sil_butonu.setText("Kayıt Sil");
        Sil_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sil_butonuActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Adres :");

        Çıkış_butonu.setBackground(new java.awt.Color(255, 204, 255));
        Çıkış_butonu.setForeground(new java.awt.Color(0, 102, 102));
        Çıkış_butonu.setText("Çıkış");
        Çıkış_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Çıkış_butonuActionPerformed(evt);
            }
        });

        sys_adres.setBackground(new java.awt.Color(204, 204, 255));

        Bilgi_Tablosu.setBackground(new java.awt.Color(204, 255, 204));
        Bilgi_Tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Bilgi_Tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bilgi_TablosuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Bilgi_Tablosu);

        sys_telefon.setBackground(new java.awt.Color(204, 204, 255));
        sys_telefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys_telefonActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Giriş Tarihi :");

        sys_ad.setBackground(new java.awt.Color(204, 204, 255));
        sys_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys_adActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Kayıt_Güncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Kaydet_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sys_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sys_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sys_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sys_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sys_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Sil_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(Çıkış_butonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sys_giriş, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(sys_çıkış)
                                    .addComponent(sys_odaNo)))))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sys_giriş, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sys_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sys_çıkış, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sys_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sys_odaNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sys_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sys_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sys_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Çıkış_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Kayıt_Güncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sil_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Kaydet_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Kayıt_GüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kayıt_GüncelleActionPerformed

        //güncelle();

        String eski_TC = Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 0).toString();
        String Tc= sys_tc.getText();
        String ad= sys_ad.getText();
        String soyad= sys_soyad.getText();
        String telefon= sys_telefon.getText();
        String adres= sys_adres.getText();
        String giriş_tarihi= sys_giriş.getText();
        String çıkış_tarihi= sys_çıkış.getText();
        String oda_numarası= sys_odaNo.getText();

        KayıtGüncelle(Tc,ad,soyad,telefon,adres,giriş_tarihi,çıkış_tarihi,oda_numarası,eski_TC);
        
        sys_ad.setText("");
        sys_soyad.setText("");
        sys_tc.setText("");
        sys_adres.setText("");
        sys_giriş.setText("");
        sys_çıkış.setText("");
        sys_telefon.setText("");
        sys_odaNo.setText("");


    }//GEN-LAST:event_Kayıt_GüncelleActionPerformed

    private void sys_çıkışActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys_çıkışActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sys_çıkışActionPerformed

    private void Kaydet_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kaydet_butonuActionPerformed

        String Tc =sys_tc.getText();
        String adı = sys_ad.getText();
        String soyadı =sys_soyad.getText();
        String telefonu = sys_telefon.getText();
        String adresi = sys_adres.getText();
        String giriş_tarihi = sys_giriş.getText();
        String çıkış_tarihi = sys_çıkış.getText();
        String oda_numarası = sys_odaNo.getText();

        KayıtEkle(Tc,adı,soyadı,telefonu,adresi,giriş_tarihi,çıkış_tarihi,oda_numarası);
        sys_ad.setText("");
        sys_soyad.setText("");
        sys_tc.setText("");
        sys_adres.setText("");
        sys_giriş.setText("");
        sys_çıkış.setText("");
        sys_telefon.setText("");
        sys_odaNo.setText("");

    }//GEN-LAST:event_Kaydet_butonuActionPerformed

    private void Sil_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sil_butonuActionPerformed
        String Tc = Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(),0).toString();

        String kalınan_gün =JOptionPane.showInputDialog("Kalınan Gün Sayısı");
        int gün= Integer.parseInt(kalınan_gün);
        int hesap= gün*300;

        JOptionPane.showMessageDialog(rootPane,"Ödencek Tutar:" +String.valueOf(hesap));

        KayıtSil(Tc);
        /*DefaultTableModel tablo= (DefaultTableModel)Bilgi_Tablosu.getModel();
        int seçili_row= Bilgi_Tablosu.getSelectedRow();
        tablo.removeRow(seçili_row);*/

        sys_ad.setText("");
        sys_soyad.setText("");
        sys_tc.setText("");
        sys_adres.setText("");
        sys_giriş.setText("");
        sys_çıkış.setText("");
        sys_telefon.setText("");
        sys_odaNo.setText("");

    }//GEN-LAST:event_Sil_butonuActionPerformed

    private void Çıkış_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Çıkış_butonuActionPerformed

        dispose();
        Butonlar butonlar = new Butonlar ();
        butonlar.setVisible(true);
    }//GEN-LAST:event_Çıkış_butonuActionPerformed

    private void Bilgi_TablosuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bilgi_TablosuMousePressed

        sys_tc.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 0).toString());
        sys_ad.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 1).toString());
        sys_soyad.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 2).toString());
        sys_telefon.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 3).toString());
        sys_adres.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 4).toString());
        sys_giriş.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 5).toString());
        sys_çıkış.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 6).toString());
        sys_odaNo.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 7).toString());

    }//GEN-LAST:event_Bilgi_TablosuMousePressed

    private void sys_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys_adActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sys_adActionPerformed

    private void sys_tcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys_tcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sys_tcActionPerformed

    private void sys_telefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys_telefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sys_telefonActionPerformed

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
            java.util.logging.Logger.getLogger(MisafirBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisafirBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisafirBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisafirBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisafirBilgileri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Bilgi_Tablosu;
    private javax.swing.JButton Kaydet_butonu;
    private javax.swing.JButton Kayıt_Güncelle;
    private javax.swing.JButton Sil_butonu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sys_ad;
    private javax.swing.JTextField sys_adres;
    private javax.swing.JTextField sys_giriş;
    private javax.swing.JTextField sys_odaNo;
    private javax.swing.JTextField sys_soyad;
    private javax.swing.JTextField sys_tc;
    private javax.swing.JTextField sys_telefon;
    private javax.swing.JTextField sys_çıkış;
    private javax.swing.JButton Çıkış_butonu;
    // End of variables declaration//GEN-END:variables
}
