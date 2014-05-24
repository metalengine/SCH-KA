1. web service client disimpan pada folder webapps/resources/webclient.php
2. skema web service client adalah memanggil command php yang mengeksekusi webclient.php melalui tombol di JSF (halaman admin-dashboard)
3. kebutuhan web service client adalah aplikasi php sudah terinstal sehingga hanya perlu mengetik php di terminal untuk memanggil.
4. web service client telah diuji di platform Fedora 20 x86_64 dengan RAM 6GB dan Processor Inter Core i5.
5. web service path disesuaikan dengan absolute path pada distro Linux (Unix based). Jika ingin mengganti ke Windows based, ganti indikator "/" dengan "\" pada constructor AdminBean.java.
6. pengaturan url web service dan database yang akan diisi data dari webservice terdapat pada variabel-variabel yang disimpan di atas pada webclient.php. Ubah isi variabel tersebut untuk menyeseuaikan dengan web service.
7. Jika sudah dieksekusi namun data belum berubah, maka coba pindahkan file webclient.php ke suatu tempat, ambil absolute path nya, simpan pada pengaturan p.command di AdminBean.java pada method actionGetData.


CATATAN :

terdapat perubahan pada web service yaitu dengan mengirim ID Karya Akhir (pada fungsi findAllKaryaAkhir) ke webclient karena jika ID Karya Akhir dibuat pada aplikasi penjadwalan, maka akan terjadi kesulitan dalam sinkronisasi data (karena ID akan selalu berubah setiap webclient mengambil data dari web service). Penjadwalan seminar dan sidang menggunakan ID Karya Akhir dan jika tidak dikirim dari web service maka kemungkinan ID bisa berubah dan jadwal menjadi kacau.
