
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
public class PersonelBilgileri extends javax.swing.JFrame {

    DefaultTableModel tablo= new DefaultTableModel();
 
    
    
    public static Connection baglan=null;
    String bag="jdbc:mysql://localhost:3306/otel_otomasyonu";
    String kullaniciadi="root";
    String sifre="";
        
    
    public PersonelBilgileri() {
        initComponents();
         try {
            personelleriGetir();
            
            
        } catch (SQLException ex) {
            System.out.println("HATA");
        }
    }
    
     public void KayıtSil(String Tc){
        
        try{
            Statement st=baglantiAc();
            st.executeUpdate("DELETE fROM otel_otomasyonu.personeller where TC=" +Tc);
            bağlantıKapat();
            personelleriGetir();
        
        }
        catch(Exception e){
            System.out.println("Bir hata oluştu" +e);
            
        }
     }
     
         public void KayıtGüncelle(String Tc,String ad,String soyad,String telefon,String yaş,String doğum_tarihi,String doğum_yeri,String giriş_tarihi,String maaş,String departman,String bölüm, String adres,String eski_TC){
        
        try{
            Statement st = baglantiAc();
            String sql = "UPDATE personeller SET  TC='" +Tc+ "', Ad='" +ad+ "',Soyad='" +soyad+ "',Telefon='" +telefon+ "',Yaş='" +yaş+ "',Doğum_tarihi='" +doğum_tarihi+ "',Doğum_yeri='" +doğum_yeri+ "',Giriş_tarihi='" +giriş_tarihi+"' ,Maaş='" +maaş+ "' ,Departman='" +departman+ "' ,Bölüm='" +bölüm+ "' ,Adres='" +adres+ "' WHERE TC='" +eski_TC+"' ";
             
            st.executeUpdate(sql);
            
            personelleriGetir();
            bağlantıKapat();
            JOptionPane.showMessageDialog(rootPane, "Personel Bilgileri Güncellendi.");
            
            
        }
        catch(Exception e){
            System.out.println("Bir Hata Oluştu"+e);
        }
        
        
    }
        
          public void KayıtEkle (String Tc, String adı, String soyadı,String telefonu,String yaş,String doğum_tarihi,String doğum_yeri,String giriş_tarihi,String maaş,String departman,String bölüm,String adres){
          try{
              
              Statement st = baglantiAc();
              String sql = "Insert Into  personeller (TC,Ad,Soyad,Telefon,Yaş,Doğum_tarihi,Doğum_yeri,Giriş_tarihi,Maaş,Departman,Bölüm,Adres) VALUES("+ "'" + Tc + "'," + "'" +adı+ "'," + "'" + soyadı+ "'," + "'" + telefonu + "'," + "'" + yaş + "'," + "'" + doğum_tarihi + "'," + "'" + doğum_yeri +"'," + "'" + giriş_tarihi+"'," + "'" + maaş + "'," + "'" + departman + "'," + "'" + bölüm + "'," + "'" + adres + "') " ;
              st.executeUpdate(sql);
              bağlantıKapat();
              personelleriGetir();
          }
          catch(Exception e){
              System.out.println("Hata Oluştu"+e);
          
          
      }
      } 
    
          public void personelleriGetir() throws SQLException {
          
         Connection con= null;
         
          try{
          
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection(bag,kullaniciadi,sifre);
          String sql = "SELECT * FROM personeller";
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

        sys_telefon = new javax.swing.JTextField();
        sys_yaş = new javax.swing.JTextField();
        sys_doğum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sys_yer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sys_giriş = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sys_maaş = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sys_adres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Personel_Ekle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Personel_sil = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Personel_güncelle = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Çıkış = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Bilgi_Tablosu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        sys_tc = new javax.swing.JTextField();
        sys_departman = new javax.swing.JTextField();
        sys_ad = new javax.swing.JTextField();
        sys_bölüm = new javax.swing.JTextField();
        sys_soyad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sys_telefon.setBackground(new java.awt.Color(204, 204, 255));

        sys_yaş.setBackground(new java.awt.Color(204, 204, 255));

        sys_doğum.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Doğum Tarihi :");

        sys_yer.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Doğum Yeri :");

        sys_giriş.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("İşe Giriş Tarihi :");

        sys_maaş.setBackground(new java.awt.Color(204, 204, 255));

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Maaşı :");

        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Departmanı :");

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Bölümü :");

        sys_adres.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("TC :");

        Personel_Ekle.setBackground(new java.awt.Color(255, 204, 255));
        Personel_Ekle.setForeground(new java.awt.Color(0, 102, 102));
        Personel_Ekle.setText("Yeni Personel Ekle");
        Personel_Ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Personel_EkleActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Personel Adı :");

        Personel_sil.setBackground(new java.awt.Color(255, 204, 255));
        Personel_sil.setForeground(new java.awt.Color(0, 102, 102));
        Personel_sil.setText("Personel Bilgileri Sil");
        Personel_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Personel_silActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Personelin Soyadı:");

        Personel_güncelle.setBackground(new java.awt.Color(255, 204, 255));
        Personel_güncelle.setForeground(new java.awt.Color(0, 102, 102));
        Personel_güncelle.setText("Personel Bilgilerini Güncelle");
        Personel_güncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Personel_güncelleActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Telefon :");

        Çıkış.setBackground(new java.awt.Color(255, 204, 255));
        Çıkış.setForeground(new java.awt.Color(0, 102, 102));
        Çıkış.setText("Çıkış");
        Çıkış.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ÇıkışActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Adres :");

        Bilgi_Tablosu.setBackground(new java.awt.Color(204, 255, 204));
        Bilgi_Tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Yaşı :");

        sys_tc.setBackground(new java.awt.Color(204, 204, 255));

        sys_departman.setBackground(new java.awt.Color(204, 204, 255));

        sys_ad.setBackground(new java.awt.Color(204, 204, 255));

        sys_bölüm.setBackground(new java.awt.Color(204, 204, 255));

        sys_soyad.setBackground(new java.awt.Color(204, 204, 255));
        sys_soyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys_soyadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sys_maaş)
                            .addComponent(sys_giriş)
                            .addComponent(sys_yer)
                            .addComponent(sys_doğum)
                            .addComponent(sys_yaş)
                            .addComponent(sys_telefon)
                            .addComponent(sys_soyad)
                            .addComponent(sys_ad)
                            .addComponent(sys_tc)
                            .addComponent(sys_departman)
                            .addComponent(sys_bölüm, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sys_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Personel_güncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Personel_Ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Personel_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Çıkış, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sys_yaş, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_doğum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sys_yer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sys_giriş, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sys_maaş)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sys_departman, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sys_bölüm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sys_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Personel_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Personel_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Personel_güncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Çıkış, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Personel_EkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Personel_EkleActionPerformed
        String Tc =sys_tc.getText();
        String adı = sys_ad.getText();
        String soyadı =sys_soyad.getText();
        String telefonu = sys_telefon.getText();
        String yaş = sys_yaş.getText();
        String doğum_tarihi = sys_doğum.getText();
        String doğum_yeri = sys_yer.getText();
        String giriş_tarihi = sys_giriş.getText();
        String maaş = sys_maaş.getText();
        String departman = sys_departman.getText();
        String bölüm = sys_bölüm.getText();
        String adres = sys_adres.getText();

        KayıtEkle(Tc,adı,soyadı,telefonu,yaş,doğum_tarihi,doğum_yeri,giriş_tarihi,maaş,departman,bölüm,adres);

        sys_tc.setText("");
        sys_ad.setText("");
        sys_soyad.setText("");
        sys_telefon.setText("");
        sys_yaş.setText("");
        sys_doğum.setText("");
        sys_yer.setText("");
        sys_giriş.setText("");
        sys_maaş.setText("");
        sys_departman.setText("");
        sys_bölüm.setText("");

        sys_adres.setText("");

    }//GEN-LAST:event_Personel_EkleActionPerformed

    private void Personel_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Personel_silActionPerformed

        String Tc = Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(),0).toString();
        KayıtSil(Tc);

        sys_tc.setText("");
        sys_ad.setText("");
        sys_soyad.setText("");
        sys_telefon.setText("");
        sys_yaş.setText("");
        sys_doğum.setText("");
        sys_yer.setText("");
        sys_giriş.setText("");
        sys_maaş.setText("");
        sys_departman.setText("");
        sys_bölüm.setText("");
        sys_adres.setText("");

        String message =" Personel Bilgileri Silindi.";
        JOptionPane.showMessageDialog(rootPane,message);

    }//GEN-LAST:event_Personel_silActionPerformed

    private void Personel_güncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Personel_güncelleActionPerformed

        String eski_TC = Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 0).toString();
        String Tc= sys_tc.getText();
        String ad= sys_ad.getText();
        String soyad= sys_soyad.getText();
        String telefon= sys_telefon.getText();
        String yaş= sys_yaş.getText();
        String doğum_tarihi = sys_doğum.getText();
        String doğum_yeri = sys_yer.getText();
        String giriş_tarihi=sys_giriş.getText();
        String maaş=sys_maaş.getText();
        String departman=sys_departman.getText();
        String bölüm =sys_bölüm.getText();
        String adres= sys_adres.getText();

        KayıtGüncelle(Tc,ad,soyad,telefon,yaş,doğum_tarihi,doğum_yeri,giriş_tarihi,maaş,departman,bölüm,adres,eski_TC);

        sys_tc.setText("");
        sys_ad.setText("");
        sys_soyad.setText("");
        sys_telefon.setText("");
        sys_yaş.setText("");
        sys_doğum.setText("");
        sys_yer.setText("");
        sys_giriş.setText("");
        sys_maaş.setText("");
        sys_departman.setText("");
        sys_bölüm.setText("");
        sys_adres.setText("");

    }//GEN-LAST:event_Personel_güncelleActionPerformed

    private void ÇıkışActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ÇıkışActionPerformed
        dispose();
        Butonlar butonlar = new Butonlar ();
            butonlar.setVisible(true);
    }//GEN-LAST:event_ÇıkışActionPerformed

    private void Bilgi_TablosuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bilgi_TablosuMousePressed

        sys_tc.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 0).toString());
        sys_ad.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 1).toString());
        sys_soyad.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 2).toString());
        sys_telefon.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 3).toString());
        sys_yaş.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 4).toString());
        sys_doğum.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 5).toString());
        sys_yer.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 6).toString());
        sys_giriş.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 7).toString());
        sys_maaş.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 8).toString());
        sys_departman.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 9).toString());
        sys_bölüm.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 10).toString());
        sys_adres.setText(Bilgi_Tablosu.getValueAt(Bilgi_Tablosu.getSelectedRow(), 11).toString());

    }//GEN-LAST:event_Bilgi_TablosuMousePressed

    private void sys_soyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys_soyadActionPerformed

    }//GEN-LAST:event_sys_soyadActionPerformed

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
            java.util.logging.Logger.getLogger(PersonelBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelBilgileri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelBilgileri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Bilgi_Tablosu;
    private javax.swing.JButton Personel_Ekle;
    private javax.swing.JButton Personel_güncelle;
    private javax.swing.JButton Personel_sil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sys_ad;
    private javax.swing.JTextField sys_adres;
    private javax.swing.JTextField sys_bölüm;
    private javax.swing.JTextField sys_departman;
    private javax.swing.JTextField sys_doğum;
    private javax.swing.JTextField sys_giriş;
    private javax.swing.JTextField sys_maaş;
    private javax.swing.JTextField sys_soyad;
    private javax.swing.JTextField sys_tc;
    private javax.swing.JTextField sys_telefon;
    private javax.swing.JTextField sys_yaş;
    private javax.swing.JTextField sys_yer;
    private javax.swing.JButton Çıkış;
    // End of variables declaration//GEN-END:variables
}
