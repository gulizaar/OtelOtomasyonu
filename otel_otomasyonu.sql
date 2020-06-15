-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 15 Haz 2020, 00:26:27
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otel_otomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `misafirler`
--

CREATE TABLE `misafirler` (
  `TC` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Ad` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Soyad` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Telefon` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Adres` varchar(200) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Giriş_tarihi` date NOT NULL,
  `Çıkış_tarihi` date NOT NULL,
  `Oda_numarası` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personeller`
--

CREATE TABLE `personeller` (
  `TC` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Ad` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Soyad` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Telefon` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Yaş` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Doğum_tarihi` date NOT NULL,
  `Doğum_yeri` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Giriş_tarihi` date NOT NULL,
  `Maaş` varchar(10) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Departman` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Bölüm` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Adres` varchar(200) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `personeller`
--

INSERT INTO `personeller` (`TC`, `Ad`, `Soyad`, `Telefon`, `Yaş`, `Doğum_tarihi`, `Doğum_yeri`, `Giriş_tarihi`, `Maaş`, `Departman`, `Bölüm`, `Adres`) VALUES
('1237', 'Hatice', 'şahin', '21', '23', '2000-10-06', 'konya', '2020-06-15', '2500', 'F/B', 'Servis', 'KONYA'),
('124', 'Gülizar', 'Aksoy', '05340602644', '19', '2000-07-04', 'Antalya', '2020-05-10', '2500', 'HouseKeeping', 'Kat Şefi', 'antalya');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
