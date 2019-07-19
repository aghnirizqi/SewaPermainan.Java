-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jul 2019 pada 06.18
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewa_permainan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `id_login` char(5) NOT NULL,
  `id_pegawai` char(5) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`id_login`, `id_pegawai`, `username`, `password`, `level`) VALUES
('L001', 'K001', 'Sintia', 'Admin', 'Admin'),
('L002', 'K002', 'Aghni', 'Kasir', 'Kasir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` char(5) NOT NULL,
  `nama_pegawai` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jk` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `alamat`, `jk`) VALUES
('K001', 'SINTIA', 'SURAKARTA', 'PEREMPUAN'),
('K002', 'GALANG', 'SIDODADI', 'LAKI-LAKI'),
('K003', 'TUNIA', 'BANJARNEGARA', 'PEREMPUAN');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyewa`
--

CREATE TABLE `penyewa` (
  `id_penyewa` char(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(11) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penyewa`
--

INSERT INTO `penyewa` (`id_penyewa`, `nama`, `jenis_kelamin`, `alamat`) VALUES
('P001', 'aghni', 'perempuan', 'banjarnegara'),
('P002', 'Angga', 'Laki-Laki', 'Surabaya'),
('P003', 'Hanifah', 'Perempuan', 'Solo');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `no_sewa` char(5) NOT NULL,
  `id_pegawai` char(5) NOT NULL,
  `id_penyewa` char(5) NOT NULL,
  `kd_wahana` varchar(5) NOT NULL,
  `harga_sewa` int(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`no_sewa`, `id_pegawai`, `id_penyewa`, `kd_wahana`, `harga_sewa`, `jumlah`, `total`, `bayar`, `kembali`) VALUES
('S001', 'K001', 'P001', 'W001', 15000, 5, 75000, 100000, 25000),
('S002', 'K001', 'P002', 'W002', 8000, 6, 96000, 100000, 4000),
('S004', 'K003', 'P002', 'W004', 10000, 5, 150000, 300000, 150000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `wahana`
--

CREATE TABLE `wahana` (
  `kd_wahana` varchar(5) NOT NULL,
  `nama_wahana` varchar(20) NOT NULL,
  `harga_sewa` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `wahana`
--

INSERT INTO `wahana` (`kd_wahana`, `nama_wahana`, `harga_sewa`) VALUES
('W001', 'Outbond', 15000),
('W002', 'Kolam Renang', 8000),
('W003', 'Mandi Bola', 5000),
('W004', 'Mobil Senggol', 10000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indeks untuk tabel `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_sewa`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_penyewa` (`id_penyewa`),
  ADD KEY `kd_wahana` (`kd_wahana`);

--
-- Indeks untuk tabel `wahana`
--
ALTER TABLE `wahana`
  ADD PRIMARY KEY (`kd_wahana`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`kd_wahana`) REFERENCES `wahana` (`kd_wahana`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_penyewa`) REFERENCES `penyewa` (`id_penyewa`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
