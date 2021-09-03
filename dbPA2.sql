CREATE DATABASE IF NOT EXISTS paII;
USE paII;

CREATE TABLE users
(
id_user INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
username CHAR(255),
PASSWORD CHAR(255),
email CHAR(255),
nama CHAR(255),
alamat CHAR(255),
no_tel CHAR(255)
);

CREATE TABLE parmusik 
(
id_parmusik INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
username CHAR(255),
PASSWORD CHAR(255),
email CHAR(255),
nama CHAR(255),
alamat CHAR(255),
no_tel CHAR(255),
STATUS INT,
id_alatmusik INT
);

CREATE TABLE alat_musik 
(
id_alatmusik INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nama CHAR(255),
deskripsi TEXT,
foto BLOB
);

CREATE TABLE acara
(
id_acara INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_parmusik INT,
deskripsi TEXT,
biaya FLOAT,
jenis CHAR(255)
); 
CREATE TABLE penyewaan
(
id_penyewaan INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_user INT,
id_acara INT,
tglmulai DATE,
tglakhir DATE,
biaya_total FLOAT
);


CREATE TABLE pembayaran
(
id_pembayaran INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_penyewaan INT,
foto_bukti CHAR(255),
tanggal_upload DATE,
STATUS CHAR(255)
);
ALTER TABLE pembayaran ADD FOREIGN KEY (id_penyewaan) REFERENCES penyewaan(id_penyewaan);

ALTER TABLE parmusik ADD FOREIGN KEY (id_alatmusik) REFERENCES alat_musik(id_alatmusik);

ALTER TABLE acara ADD FOREIGN KEY (id_parmusik) REFERENCES parmusik(id_parmusik);

ALTER TABLE penyewaan ADD FOREIGN KEY (id_user) REFERENCES users(id_user);
ALTER TABLE penyewaan ADD FOREIGN KEY (id_acara) REFERENCES acara(id_acara);
