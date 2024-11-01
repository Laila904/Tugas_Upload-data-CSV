#  📖 Aplikasi Unggah Data CVS Menggunakan Java Swing

👨‍🏫 *Dosen Pembimbing: Bayu Adhi Nugroho, Ph.D*

🎓 *Program Studi: Sistem Informasi*

# 📝A. Penjelasan

Laporan ini membahas pembuatan aplikasi Mengunggah data cvs menggunakan Java Swing untuk menampilkan dan mengelola data matakuliah
dalam tabel yang mencakup Kode Mk, SKS, Nama Mata Kuliah, dan Semester Ajar.Aplikasi ini untuk mempermudah input data ketabel yang terhubung ke database secara otomatis 📄✨.

# Langkah-Langkah
1. Langkah pertama yaitu membuat data di excel untuk di input ke tabel agar data otomatis ke input,
   dan ketika data di save harus berbentuk file CSV.
   ![Screenshot 2024-11-01 211900](https://github.com/user-attachments/assets/4e01240a-ce34-4c81-8cd8-556ac64366d4)
   ![Screenshot 2024-11-01 211949](https://github.com/user-attachments/assets/29b070f6-a718-4608-94e3-d1ff7224d2c7)

2. Langkah kedua yaitu menambahkan button “Upload” di desain GUI, agar bisa mengunggah cvs yang sudah dibuat sebelumnya.

   ![Screenshot 2024-11-01 212150](https://github.com/user-attachments/assets/cca1199a-cfe4-4fd0-9c87-8ead4f524244)

4. Langkah ketiga yaitu mengetahui fungsi button upload pada desain GUI, pada kode button “Upload” yaitu menambahkan fungsi untuk membaca file CSV,
   parsing data, dan juga menyimpan data ke database dengan menggunakan JPA(Java Persistence API).
   ![Screenshot 2024-11-01 213354](https://github.com/user-attachments/assets/dc29331b-fc09-455b-97c6-7f9cea5c973b)

Dengan menggunakan kode dibawah ini:
      
      private void btnUpploadActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
        }}    

4. Langkah keempat yaitu menampilkan output sebelum button upload di klik.
   ![Screenshot 2024-11-01 213449](https://github.com/user-attachments/assets/e6eff766-35d0-4afd-b42a-c42d526af3fc)

5. Langkah kelima yaitu menampilkan output sesudah button upload di klik.
   ![Screenshot 2024-11-01 213548](https://github.com/user-attachments/assets/ae922f63-c4ab-48c2-8599-f25a518e7dde)
