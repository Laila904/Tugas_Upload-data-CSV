package Upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import Upload.Utils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Matakuliah extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/Perkuliahan";
    String user = "postgres";
    String password = "Ela200705";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public Matakuliah() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMK = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtSks = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtSemester = new javax.swing.JTextField();
        btnUppload = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtUpdate = new javax.swing.JButton();
        TXTInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DATA PERKULIAHAN");

        tblMK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode_MK", "SKS", "Nama_MK", "Semester_Ajar"
            }
        ));
        tblMK.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMKAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMK);

        jLabel2.setText("Kode_MK");

        jLabel3.setText("SKS");

        jLabel4.setText("Nama_MK");

        jLabel5.setText("Semester_Ajar");

        btnUppload.setText("UPLOAD");
        btnUppload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpploadActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtUpdate.setText("UPDATE");
        txtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateActionPerformed(evt);
            }
        });

        TXTInsert.setText("INSERT");
        TXTInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSemester))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtSks)
                            .addComponent(txtNama))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TXTInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUppload)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUppload)
                    .addComponent(btnCetak)
                    .addComponent(btnDelete)
                    .addComponent(txtUpdate)
                    .addComponent(TXTInsert))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        JasperReport reports;

        try {
            if (conn == null || conn.isClosed()) {
                // Mencoba untuk membuka koneksi baru
                try {
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Perkuliahan", "postgres", "Ela200705");
                    System.out.println("Koneksi berhasil dibuka.");
                } catch (SQLException e) {
                    System.err.println("Gagal membuka koneksi: " + e.getMessage());
                    return; // Keluar dari metode jika koneksi gagal
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Matakuliah.class.getName()).log(Level.SEVERE, null, ex);
        }

        String path = ".\\src\\Upload\\reportMatkuliah.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Matakuliah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void TXTInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTInsertActionPerformed

        if (txtKode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtSks.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtSemester.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                conn.setAutoCommit(false);

                String sql = "INSERT INTO Matakuliah(KodeMK, Sks, NamaMK, Semesterajar) VALUES(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);

                String KodeMK, Sks, NamaMK, Semesterajar;
                KodeMK = txtKode.getText();
                Sks = txtSks.getText();
                NamaMK = txtNama.getText();
                Semesterajar = txtSemester.getText();
                pstmt.setInt(1, Integer.parseInt(KodeMK));
                pstmt.setString(2, Sks);
                pstmt.setString(3, NamaMK);
                pstmt.setString(4, Semesterajar);

                pstmt.executeUpdate();
                conn.commit();

                pstmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Succes to insert");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed to insert " + ex.getMessage());
            }
        }
        bersih();
        showTable();
    }//GEN-LAST:event_TXTInsertActionPerformed

    private void txtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateActionPerformed
        String KodeMK, Sks, NamaMK, Semesterajar;
        if (txtKode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtSks.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else if (txtSemester.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data harus terisi");
        } else {
            try {
                Class.forName(driver);
                String sql = "UPDATE Matakuliah SET Sks = ?, NamaMK = ?, Semesterajar = ? WHERE KodeMk = ?";
                conn = DriverManager.getConnection(koneksi, user, password);
                pstmt = conn.prepareStatement(sql);

                KodeMK = txtKode.getText();
                Sks = txtSks.getText();
                NamaMK = txtNama.getText();
                Semesterajar = txtSemester.getText();

                pstmt.setString(1, Sks);
                pstmt.setString(2, NamaMK);
                pstmt.setString(3, Semesterajar);
                pstmt.setInt(4, Integer.parseInt(KodeMK));

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "update Sukses");
                    bersih();
                } else {
                    JOptionPane.showMessageDialog(null, "Update gagal");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ISBN harus berupa angka");
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
                }
            }
        }
        showTable();

    }//GEN-LAST:event_txtUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String KodeMK;
        KodeMK = txtKode.getText();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            int jawab = JOptionPane.showConfirmDialog(null, "Silakan Konfirmasi?");
            switch (jawab) {
                case JOptionPane.YES_OPTION:
                    String deleteSql = "DELETE FROM Matakuliah WHERE KodeMK = ?";
                    pstmt = conn.prepareStatement(deleteSql);
                    pstmt.setInt(1, Integer.parseInt(KodeMK));
                    pstmt.executeUpdate();
                    pstmt.close();
                    conn.close();

                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(this, "Kamu menjawab tidak");
                    break;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Cek Lagi!!!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        bersih();
        showTable();

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblMKAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMKAncestorAdded
        int row = tblMK.getSelectedRow();
        if (row >= 0) {
            txtKode.setText(tblMK.getValueAt(row, 0).toString());
            txtSks.setText(tblMK.getValueAt(row, 1).toString());
            txtNama.setText(tblMK.getValueAt(row, 2).toString());
            txtSemester.setText(tblMK.getValueAt(row, 3).toString());
        }
        bersih();
        showTable();
    }//GEN-LAST:event_tblMKAncestorAdded

    private void tblMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMKMouseClicked
        int selectdRow = tblMK.getSelectedRow();
        if (selectdRow != -1) {
            int KodeMK = Integer.parseInt(tblMK.getValueAt(selectdRow, 0).toString());
            String Sks = tblMK.getValueAt(selectdRow, 1).toString();
            String NamaMK = tblMK.getValueAt(selectdRow, 2).toString();
            String Semesterajar = tblMK.getValueAt(selectdRow, 3).toString();

            txtKode.setText(String.valueOf(KodeMK));
            txtSks.setText(Sks);
            txtNama.setText(NamaMK);
            txtSemester.setText(Semesterajar);
        }
    }//GEN-LAST:event_tblMKMouseClicked

    private void btnUpploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpploadActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris = new String("");
                String pemisah = ",";
                while ((baris = br.readLine()) != null) //returns a Boolean value
                {
                    String[] Perkuliahan = baris.split(pemisah);
                    String KodeMK = Perkuliahan[0];
                    String Sks = Perkuliahan[1];
                    String NamaMK = Perkuliahan[2];
                    String Semesterajar = Perkuliahan[3];
                    if (!KodeMK.isEmpty() && !Sks.isEmpty() && !NamaMK.isEmpty() && !Semesterajar.isEmpty()) {
                        try {
                            Class.forName(driver);
                            conn = DriverManager.getConnection(koneksi, user, password);
                            conn.setAutoCommit(false);

                            String sql = "INSERT INTO Matakuliah(KodeMK, Sks, NamaMK, Semesterajar) VALUES(?,?,?,?)";
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setInt(1, Integer.parseInt(KodeMK));
                            pstmt.setString(2, Sks);
                            pstmt.setString(3, NamaMK);
                            pstmt.setString(4, Semesterajar);

                            pstmt.executeUpdate();
                            conn.commit();

                            pstmt.close();
                            conn.close();

                            JOptionPane.showMessageDialog(null, "Succes to insert");
                        } catch (ClassNotFoundException | SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Failed to insert " + ex.getMessage());
                        }

                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Matakuliah.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Matakuliah.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpploadActionPerformed

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
            java.util.logging.Logger.getLogger(Matakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matakuliah().setVisible(true);
            }
        });
    }

    public void showTable() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM Matakuliah order by KodeMK";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {

                ResultSet rs = stmt.executeQuery(sql);
                this.tblMK.setModel(Utils.resultSetToTableModel(rs));
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)) + " " + String.valueOf(rs.getObject(3) + " " + String.valueOf(rs.getObject(4))));
                }
                conn.close();//move this outside the while loop
            }

            stmt.close();

        } catch (ClassNotFoundException | SQLException ex) {

        }
    }

    private void bersih() {
        txtKode.setText("");
        txtSks.setText("");
        txtNama.setText("");
        txtSemester.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TXTInsert;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUppload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMK;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSemester;
    private javax.swing.JTextField txtSks;
    private javax.swing.JButton txtUpdate;
    // End of variables declaration//GEN-END:variables
}
