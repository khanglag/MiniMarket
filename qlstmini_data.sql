-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 05, 2023 lúc 03:58 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlstmini_data`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_hoadon`
--

CREATE TABLE `chitiet_hoadon` (
  `SOHD` int(11) NOT NULL,
  `MASP` char(13) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiet_hoadon`
--

INSERT INTO `chitiet_hoadon` (`SOHD`, `MASP`, `SOLUONG`, `TONTAI`) VALUES
(1, '4902430556781', 2, 1),
(1, '8809541033891', 3, 1),
(2, '8835166023316', 5, 1),
(3, '8936011896782', 2, 1),
(4, '8934563138165', 2, 1),
(4, '8934822220112', 4, 1),
(5, '8934841903058', 10, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_kiemhang`
--

CREATE TABLE `chitiet_kiemhang` (
  `MAPHIEU` char(7) NOT NULL,
  `MASP` char(13) NOT NULL,
  `TENSP` text NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVI` text NOT NULL,
  `TINHTRANGSP` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiet_kiemhang`
--

INSERT INTO `chitiet_kiemhang` (`MAPHIEU`, `MASP`, `TENSP`, `SOLUONG`, `DONVI`, `TINHTRANGSP`, `TONTAI`) VALUES
('0000001', '4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', 1, 'gói', 'MAT', 1),
('0000001', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 1, 'cái', 'HU HONG', 1),
('0000002', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 1, 'cái', 'HU HONG', 1);

--
-- Bẫy `chitiet_kiemhang`
--
DELIMITER $$
CREATE TRIGGER `before_chitietkiemhang_insert` BEFORE INSERT ON `chitiet_kiemhang` FOR EACH ROW BEGIN 
		UPDATE hanghoa
		SET SOLUONG = SOLUONG - new.SOLUONG
		where new.MASP= hanghoa.MASP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_phieunhap`
--

CREATE TABLE `chitiet_phieunhap` (
  `MAPHIEUNHAP` char(7) NOT NULL,
  `MAHANGNHAP` char(13) NOT NULL,
  `TENHANGNHAP` text NOT NULL,
  `MANCC` char(7) NOT NULL,
  `VAT` double NOT NULL,
  `XUATXU` text NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVI` text NOT NULL,
  `GIANHAP` double NOT NULL,
  `TONGTIENNHAP` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiet_phieunhap`
--

INSERT INTO `chitiet_phieunhap` (`MAPHIEUNHAP`, `MAHANGNHAP`, `TENHANGNHAP`, `MANCC`, `VAT`, `XUATXU`, `SOLUONG`, `DONVI`, `GIANHAP`, `TONGTIENNHAP`, `TONTAI`) VALUES
('0000001', '4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'gói', 165000, 1650000, 1),
('0000001', '8657882990341', 'Nước giặt Downy vườn hoa thơm ngát túi 3.05kg', 'NCCDYQN', 0.08, 'Việt Nam', 20, 'túi', 89400, 1788000, 1),
('0000001', '8809541033891', 'Mặt nạ chiết xuất từ nghệ Purederm dưỡng da', 'NCCDYQN', 0.08, 'Việt Nam', 100, 'miếng', 12000, 1200000, 1),
('0000001', '8835166023316', 'Lốc 3 cuộn túi rác đen tự huỷ sinh học 64x78cm (1kg)', 'NCCDYQN', 0.08, 'Việt Nam', 50, 'lốc', 24500, 1225000, 1),
('0000001', '8843331098667', 'Thùng 24 bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 'NCCDYQN', 0.08, 'Việt Nam', 5, 'thùng', 194600, 973000, 1),
('0000001', '8853301530293', 'Thức ăn cho chó lớn Pedigree vị bò kho và rau củ túi 130g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'túi', 86300, 863000, 1),
('0000001', '8934558928122', 'Dầu ăn cao cấp Happi Koki chai 1 lít', 'NCCDYQN', 0.08, 'Việt Nam', 50, 'chai', 36100, 1805000, 1),
('0000001', '8934561667891', 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'thùng', 83900, 839000, 1),
('0000001', '8934822561234', 'Thùng 12 lon bia Bia Việt 330ml', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'thùng', 186300, 1863000, 1),
('0000001', '8935162895621', 'Gạo thơm đặc sản Neptune ST25 túi 5kg', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'túi', 112700, 1127000, 1),
('0000001', '8936011896782', 'Sữa chua dẻo phô mai Merino gói 50g', 'NCCDYQN', 0.08, 'Việt Nam', 40, 'gói', 36400, 1456000, 1),
('0000001', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'cái', 27000, 270000, 1),
('0000002', '8934563138165', 'Mì Hảo Hảo gói 75g', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'gói', 3200, 960000, 1),
('0000002', '8934822220112', 'Lon bia Việt 330ml', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'lon', 8500, 255000, 1),
('0000002', '8934841903058', 'Bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'bịch', 5900, 1770000, 1),
('0000003', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'cái', 27000, 270000, 1);

--
-- Bẫy `chitiet_phieunhap`
--
DELIMITER $$
CREATE TRIGGER `before_chitiet_phieunhap_insert` BEFORE INSERT ON `chitiet_phieunhap` FOR EACH ROW BEGIN 
			UPDATE hanghoa
			SET SOLUONG = SOLUONG + new.SOLUONG
            where new.MAHANGNHAP=hanghoa.MASP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_phieuxuat`
--

CREATE TABLE `chitiet_phieuxuat` (
  `MAPHIEUXUAT` char(7) NOT NULL,
  `MAHANGXUAT` char(13) NOT NULL,
  `SOLUONGYEUCAU` int(11) NOT NULL,
  `SOLUONGTHUCXUAT` int(11) NOT NULL,
  `DONVI` text NOT NULL,
  `DONGIA` double NOT NULL,
  `THANHTIEN` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiet_phieuxuat`
--

INSERT INTO `chitiet_phieuxuat` (`MAPHIEUXUAT`, `MAHANGXUAT`, `SOLUONGYEUCAU`, `SOLUONGTHUCXUAT`, `DONVI`, `DONGIA`, `THANHTIEN`, `TONTAI`) VALUES
('0000001', '4902430556781', 3, 3, 'gói', 210000, 630000, 1),
('0000001', '8657882990341', 5, 5, 'túi', 125000, 625000, 1),
('0000002', '4902430556781', 3, 3, 'gói', 210000, 630000, 1),
('0000002', '8657882990341', 5, 5, 'túi', 125000, 625000, 1);

--
-- Bẫy `chitiet_phieuxuat`
--
DELIMITER $$
CREATE TRIGGER `before_phieuxuat_insert` BEFORE INSERT ON `chitiet_phieuxuat` FOR EACH ROW BEGIN 
		UPDATE hanghoa
		SET SOLUONG = SOLUONG - new.SOLUONGTHUCXUAT
		where new.MAHANGXUAT= hanghoa.MASP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hanghoa`
--

CREATE TABLE `hanghoa` (
  `MASP` char(13) NOT NULL,
  `TENSP` text NOT NULL,
  `MANH` char(7) NOT NULL,
  `MANCC` char(7) NOT NULL,
  `DONVI` text NOT NULL,
  `GIANHAP` double NOT NULL,
  `GIABAN` double NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `XUATXU` text NOT NULL,
  `ANHSP` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hanghoa`
--

INSERT INTO `hanghoa` (`MASP`, `TENSP`, `MANH`, `MANCC`, `DONVI`, `GIANHAP`, `GIABAN`, `SOLUONG`, `XUATXU`, `ANHSP`, `TONTAI`) VALUES
('4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', '0000004', 'NCCDYQN', 'gói', 165000, 210000, 60, 'Việt Nam', '/images/tadan.jpg', 1),
('8657882990341', 'Nước giặt Downy vườn hoa thơm ngát túi 3.05kg', '0000003', 'NCCDYQN', 'túi', 89400, 125000, 45, 'Việt Nam', '/images/nuocgiat.jpg', 1),
('8809541033891', 'Mặt nạ chiết xuất từ nghệ Purederm dưỡng da', '0000005', 'NCCDYQN', 'miếng', 12000, 19800, 100, 'Việt Nam', '/images/matna.jpg', 1),
('8835166023316', 'Lốc 3 cuộn túi rác đen tự huỷ sinh học 64x78cm (1kg)', '0000002', 'NCCDYQN', 'lốc', 24500, 35600, 50, 'Việt Nam', '/images/tuirac.jpg', 1),
('8843331098667', 'Thùng 24 bịch sữa tiệt trùng ít đường Dutch Lady 180ml', '0000007', 'NCCLADY', 'thùng', 194600, 225800, 25, 'Việt Nam', '/images/thung24bichsua.jpg', 1),
('8853301530293', 'Thức ăn cho chó lớn Pedigree vị bò kho và rau củ túi 130g', '0000001', 'NCCDYQN', 'túi', 86300, 123400, 30, 'Việt Nam', '/images/thucancho.jpg', 1),
('8934558928122', 'Dầu ăn cao cấp Happi Koki chai 1 lít', '0000012', 'NCCDYQN', 'chai', 36100, 43200, 43, 'Việt Nam', '/images/dauan.jpg', 1),
('8934561667891', 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', '0000010', 'NCCCOOK', 'thùng', 83900, 95200, 18, 'Việt Nam', '/images/thung30goimihaohao.jpg', 1),
('8934563138165', 'Mì Hảo Hảo gói 75g', '0000010', 'NCCCOOK', 'gói', 3200, 5400, 300, 'Việt Nam', '/images/mihaohao.jpg', 1),
('8934822220112', 'Lon bia Việt 330ml', '0000008', 'NCCBIAV', 'lon', 8500, 11900, 120, 'Việt Nam', '/images/biaviet.jpg', 1),
('8934822561234', 'Thùng 12 lon bia Bia Việt 330ml', '0000008', 'NCCBIAV', 'thùng', 186300, 221300, 17, 'Việt Nam', '/images/thung12lonbiaviet.jpg', 1),
('8934841903058', 'Bịch sữa tiệt trùng ít đường Dutch Lady 180ml', '0000007', 'NCCLADY', 'bịch', 5900, 7200, 300, 'Việt Nam', '/images/suatiettrung.jpg', 1),
('8935162895621', 'Gạo thơm đặc sản Neptune ST25 túi 5kg', '0000009', 'NCCDYQN', 'túi', 112700, 153600, 10, 'Việt Nam', '/images/gao.jpg', 1),
('8936011896782', 'Sữa chua dẻo phô mai Merino gói 50g', '0000011', 'NCCDYQN', 'gói', 3640, 4780, 50, 'Việt Nam', '/images/suachua.jpg', 1),
('8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', '0000006', 'NCCDYQN', 'cái', 27000, 37800, 18, 'Việt Nam', '/images/btt.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `SOHD` int(11) NOT NULL,
  `MANV` char(7) NOT NULL,
  `THOIGIANLAP` datetime NOT NULL,
  `MAKH` char(7) NOT NULL,
  `THANHTIEN` double NOT NULL,
  `TIENKHACHDUA` double NOT NULL,
  `TIENTRAKHACH` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`SOHD`, `MANV`, `THOIGIANLAP`, `MAKH`, `THANHTIEN`, `TIENKHACHDUA`, `TIENTRAKHACH`, `TONTAI`) VALUES
(1, 'A070103', '2023-09-19 08:00:30', '0000001', 479400, 500000, 20600, 1),
(2, 'A140403', '2023-09-20 08:39:34', '0000001', 178000, 200000, 22000, 1),
(3, 'A140403', '2023-10-19 12:10:04', '0000001', 9560, 10000, 440, 1),
(4, 'A070103', '2023-10-23 17:43:51', '0000001', 58400, 60000, 1600, 1),
(5, 'A140403', '2023-10-30 21:03:34', '0000001', 72000, 72000, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` char(7) NOT NULL,
  `TENKH` text NOT NULL,
  `NGAYSINH` date NOT NULL,
  `SDT` char(10) NOT NULL,
  `DIACHI` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `TENKH`, `NGAYSINH`, `SDT`, `DIACHI`, `TONTAI`) VALUES
('0000000', 'Khách vãng lai', '0000-00-00', '1', '', 1),
('0000001', 'Lê Văn Việt', '1999-09-01', '0368779041', 'Quận 8', 1),
('0000002', 'Đặng Văn Khoa', '2000-10-07', '0393506251', 'Quận 5', 1),
('0000003', 'Vũ Hà', '2003-09-07', '0336544121', 'Quận 10', 1),
('0000004', 'Dương Huy', '1995-09-07', '0377371312', 'Quận 5', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MANCC` char(7) NOT NULL,
  `TENNCC` text NOT NULL,
  `SDT` char(10) NOT NULL,
  `DIACHI` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MANCC`, `TENNCC`, `SDT`, `DIACHI`, `TONTAI`) VALUES
('NCCBIAV', 'Công ty TNHH Nhà Máy Bia HEINEKEN Việt Nam', '0300831132', 'TP Hồ Chí Minh', 1),
('NCCCOOK', 'Công ty Acecook Việt Nam', '0283815406', 'TP Hồ Chí Minh', 1),
('NCCDYQN', 'Công ty cung cấp thực phẩm', '0283615622', '36 Nguyễn Thị Thập', 1),
('NCCLADY', 'FrieslandCampina Việt Nam', '0283754422', 'Tỉnh Bình Dương', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` char(7) NOT NULL,
  `TENNV` text NOT NULL,
  `NGAYSINH` date NOT NULL,
  `GIOITINH` text NOT NULL,
  `CCCD` char(12) NOT NULL,
  `SDT` char(10) NOT NULL,
  `EMAIL` text NOT NULL,
  `DIACHI` text NOT NULL,
  `MAQUYEN` char(7) NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `NGAYSINH`, `GIOITINH`, `CCCD`, `SDT`, `EMAIL`, `DIACHI`, `MAQUYEN`, `TONTAI`) VALUES
('A000001', 'Võ Đinh Xuân Hoàng', '2003-02-02', 'nam', '068000000002', '0944313407', 'vodinhxuanhoang@gmail.com', '277 Âu Dương Lân', 'NVBH203', 1),
('A000003', 'Nguyễn Trần Yến Nhi', '2003-04-17', 'nữ', '068000000000', '0368562519', 'tuoi@gmail.com', 'Thủ Đức', 'NVTK203', 1),
('A038645', 'Nguyễn Thị Anh Thư ', '2003-08-15', 'nữ', '068303002628', '0368779041', 'nguyenanhthu15082003@gmail.com', '101 Nguyễn Thị Tần', 'NVTK203', 1),
('A070103', 'Nguyễn Kế Cường', '2003-01-07', 'nam', '052000000000', '0682620178', 'kecuong0701@gmail.com', '477 Tân Sơn', 'NVBH203', 1),
('A140403', 'Đỗ Minh Khang', '2003-04-14', 'nam', '068000000001', '0838208944', 'khanglag@gmail.com', 'Dương Quảng Hàm', 'ADMIN01', 1),
('B041003', 'Lê Duy Khang', '2003-10-04', 'nam', '091203002454', '0358808913', 'lehoanggiakhuong@gmail.com', '277 Âu Dương Lân', 'QL20003', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomhang`
--

CREATE TABLE `nhomhang` (
  `MANH` char(7) NOT NULL,
  `TENNH` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomhang`
--

INSERT INTO `nhomhang` (`MANH`, `TENNH`, `TONTAI`) VALUES
('0000001', 'Chăm sóc thú cưng', 1),
('0000002', 'Đồ dùng gia đình', 1),
('0000003', 'Vệ sinh nhà cửa', 1),
('0000004', 'Sản phẩm cho mẹ và bé', 1),
('0000005', 'Chăm sóc cá nhân', 1),
('0000006', 'Bánh kẹo các loại', 1),
('0000007', 'Sửa các loại', 1),
('0000008', 'Bia, nước các loại', 1),
('0000009', 'gạo, bột, đồ khô', 1),
('0000010', 'mì, miến, cháo, phở', 1),
('0000011', 'kem, thực phẩm đông mát', 1),
('0000012', 'dầu ăn, nước chấm, gia vị', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `MAQUYEN` char(7) NOT NULL,
  `TENQUYEN` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`MAQUYEN`, `TENQUYEN`, `TONTAI`) VALUES
('ADMIN01', 'Admin', 1),
('NVBH203', 'Nhân viên bán hàng', 1),
('NVTK203', 'Nhân viên thủ kho', 1),
('QL20003', 'Quản lý', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieukiemhang`
--

CREATE TABLE `phieukiemhang` (
  `MAPHIEU` char(7) NOT NULL,
  `MANV` char(7) NOT NULL,
  `THOIGIANKIEMHANG` datetime NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieukiemhang`
--

INSERT INTO `phieukiemhang` (`MAPHIEU`, `MANV`, `THOIGIANKIEMHANG`, `TONTAI`) VALUES
('0000001', 'A038645', '2023-10-30 07:00:00', 1),
('0000002', 'A038645', '2023-10-31 07:00:00', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MAPHIEUNHAP` char(7) NOT NULL,
  `MANV` char(7) NOT NULL,
  `THOIGIANLAP` datetime NOT NULL,
  `VAT` double NOT NULL,
  `SOMATHANG` int(11) NOT NULL,
  `TONGTIEN` double NOT NULL,
  `TRANGTHAI` varchar(20) NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MAPHIEUNHAP`, `MANV`, `THOIGIANLAP`, `VAT`, `SOMATHANG`, `TONGTIEN`, `TRANGTHAI`, `TONTAI`) VALUES
('0000001', 'A038645', '2023-09-20 08:49:50', 0.08, 12, 11403720, 'DA NHAP', 1),
('0000002', 'B041003', '2023-09-20 16:32:34', 0.08, 3, 4341600, 'DA NHAP', 1),
('0000003', 'B041003', '2023-11-04 08:30:00', 0.08, 1, 270000, 'KHONG DUYET', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MAPHIEUXUAT` char(7) NOT NULL,
  `MANV` char(7) NOT NULL,
  `MAKH` char(7) NOT NULL,
  `TONGTIEN` double NOT NULL,
  `THOIGIANXUAT` datetime NOT NULL,
  `LYDO` text NOT NULL,
  `GHICHU` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`MAPHIEUXUAT`, `MANV`, `MAKH`, `TONGTIEN`, `THOIGIANXUAT`, `LYDO`, `GHICHU`, `TONTAI`) VALUES
('0000001', 'A038645', '0000001', 1675800, '2023-10-20 07:51:00', 'khách mua hàng', '', 1),
('0000002', 'A038645', '0000001', 1675800, '2023-11-05 10:20:22', 'khách mua hàng', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuyeucaunhap`
--

CREATE TABLE `phieuyeucaunhap` (
  `MAPHIEUNHAP` char(7) NOT NULL,
  `MAHANGNHAP` char(13) NOT NULL,
  `TENHANGNHAP` text NOT NULL,
  `MANCC` char(7) NOT NULL,
  `VAT` double NOT NULL,
  `XUATXU` text NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVI` text NOT NULL,
  `GIANHAP` double NOT NULL,
  `TONGTIENNHAP` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuyeucaunhap`
--

INSERT INTO `phieuyeucaunhap` (`MAPHIEUNHAP`, `MAHANGNHAP`, `TENHANGNHAP`, `MANCC`, `VAT`, `XUATXU`, `SOLUONG`, `DONVI`, `GIANHAP`, `TONGTIENNHAP`, `TONTAI`) VALUES
('0000001', '4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'gói', 165000, 1650000, 1),
('0000001', '8657882990341', 'Nước giặt Downy vườn hoa thơm ngát túi 3.05kg', 'NCCDYQN', 0.08, 'Việt Nam', 20, 'túi', 89400, 1788000, 1),
('0000001', '8809541033891', 'Mặt nạ chiết xuất từ nghệ Purederm dưỡng da', 'NCCDYQN', 0.08, 'Việt Nam', 100, 'miếng', 12000, 1200000, 1),
('0000001', '8835166023316', 'Lốc 3 cuộn túi rác đen tự huỷ sinh học 64x78cm (1kg)', 'NCCDYQN', 0.08, 'Việt Nam', 50, 'lốc', 24500, 1225000, 1),
('0000001', '8843331098667', 'Thùng 24 bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 'NCCDYQN', 0.08, 'Việt Nam', 5, 'thùng', 194600, 973000, 1),
('0000001', '8853301530293', 'Thức ăn cho chó lớn Pedigree vị bò kho và rau củ túi 130g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'túi', 86300, 863000, 1),
('0000001', '8934558928122', 'Dầu ăn cao cấp Happi Koki chai 1 lít', 'NCCDYQN', 0.08, 'Việt Nam', 50, 'chai', 36100, 1805000, 1),
('0000001', '8934561667891', 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'thùng', 83900, 839000, 1),
('0000001', '8934822561234', 'Thùng 12 lon bia Bia Việt 330ml', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'thùng', 186300, 1863000, 1),
('0000001', '8935162895621', 'Gạo thơm đặc sản Neptune ST25 túi 5kg', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'túi', 112700, 1127000, 1),
('0000001', '8936011896782', 'Sữa chua dẻo phô mai Merino gói 50g', 'NCCDYQN', 0.08, 'Việt Nam', 40, 'gói', 36400, 1456000, 1),
('0000001', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'cái', 27000, 270000, 1),
('0000002', '8934563138165', 'Mì Hảo Hảo gói 75g', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'gói', 3200, 960000, 1),
('0000002', '8934822220112', 'Lon bia Việt 330ml', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'lon', 8500, 255000, 1),
('0000002', '8934841903058', 'Bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 'NCCDYQN', 0.08, 'Việt Nam', 300, 'bịch', 5900, 1770000, 1),
('0000003', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 'NCCDYQN', 0.08, 'Việt Nam', 10, 'cái', 27000, 270000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MANV` char(7) NOT NULL,
  `MATKHAU` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MANV`, `MATKHAU`, `TONTAI`) VALUES
('A000001', 'xhne', 1),
('A000003', 'tuoine', 1),
('A038645', '130613', 1),
('A070103', '070103', 1),
('A140403', '140403', 1),
('B041003', '100403', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiet_hoadon`
--
ALTER TABLE `chitiet_hoadon`
  ADD PRIMARY KEY (`SOHD`,`MASP`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `chitiet_kiemhang`
--
ALTER TABLE `chitiet_kiemhang`
  ADD PRIMARY KEY (`MAPHIEU`,`MASP`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `chitiet_phieunhap`
--
ALTER TABLE `chitiet_phieunhap`
  ADD PRIMARY KEY (`MAPHIEUNHAP`,`MAHANGNHAP`),
  ADD KEY `MAHANGNHAP` (`MAHANGNHAP`),
  ADD KEY `MANCC` (`MANCC`);

--
-- Chỉ mục cho bảng `chitiet_phieuxuat`
--
ALTER TABLE `chitiet_phieuxuat`
  ADD PRIMARY KEY (`MAPHIEUXUAT`,`MAHANGXUAT`),
  ADD KEY `MAHANGXUAT` (`MAHANGXUAT`);

--
-- Chỉ mục cho bảng `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD PRIMARY KEY (`MASP`),
  ADD KEY `MANH` (`MANH`),
  ADD KEY `MANCC` (`MANCC`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`SOHD`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKH` (`MAKH`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MANCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`,`MAQUYEN`),
  ADD KEY `MAQUYEN` (`MAQUYEN`);

--
-- Chỉ mục cho bảng `nhomhang`
--
ALTER TABLE `nhomhang`
  ADD PRIMARY KEY (`MANH`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`MAQUYEN`);

--
-- Chỉ mục cho bảng `phieukiemhang`
--
ALTER TABLE `phieukiemhang`
  ADD PRIMARY KEY (`MAPHIEU`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPHIEUNHAP`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MAPHIEUXUAT`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKH` (`MAKH`);

--
-- Chỉ mục cho bảng `phieuyeucaunhap`
--
ALTER TABLE `phieuyeucaunhap`
  ADD PRIMARY KEY (`MAPHIEUNHAP`,`MAHANGNHAP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MANV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiet_hoadon`
--
ALTER TABLE `chitiet_hoadon`
  ADD CONSTRAINT `chitiet_hoadon_ibfk_1` FOREIGN KEY (`SOHD`) REFERENCES `hoadon` (`SOHD`),
  ADD CONSTRAINT `chitiet_hoadon_ibfk_2` FOREIGN KEY (`MASP`) REFERENCES `hanghoa` (`MASP`);

--
-- Các ràng buộc cho bảng `chitiet_kiemhang`
--
ALTER TABLE `chitiet_kiemhang`
  ADD CONSTRAINT `chitiet_kiemhang_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `hanghoa` (`MASP`),
  ADD CONSTRAINT `chitiet_kiemhang_ibfk_2` FOREIGN KEY (`MAPHIEU`) REFERENCES `phieukiemhang` (`MAPHIEU`);

--
-- Các ràng buộc cho bảng `chitiet_phieunhap`
--
ALTER TABLE `chitiet_phieunhap`
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_1` FOREIGN KEY (`MAPHIEUNHAP`) REFERENCES `phieunhap` (`MAPHIEUNHAP`),
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_2` FOREIGN KEY (`MAHANGNHAP`) REFERENCES `hanghoa` (`MASP`),
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_3` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

--
-- Các ràng buộc cho bảng `chitiet_phieuxuat`
--
ALTER TABLE `chitiet_phieuxuat`
  ADD CONSTRAINT `chitiet_phieuxuat_ibfk_2` FOREIGN KEY (`MAHANGXUAT`) REFERENCES `hanghoa` (`MASP`),
  ADD CONSTRAINT `chitiet_phieuxuat_ibfk_3` FOREIGN KEY (`MAPHIEUXUAT`) REFERENCES `phieuxuat` (`MAPHIEUXUAT`);

--
-- Các ràng buộc cho bảng `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD CONSTRAINT `hanghoa_ibfk_3` FOREIGN KEY (`MANH`) REFERENCES `nhomhang` (`MANH`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`MAQUYEN`) REFERENCES `phanquyen` (`MAQUYEN`);

--
-- Các ràng buộc cho bảng `phieukiemhang`
--
ALTER TABLE `phieukiemhang`
  ADD CONSTRAINT `phieukiemhang_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `phieuxuat_ibfk_2` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phieuxuat_ibfk_3` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`);

--
-- Các ràng buộc cho bảng `phieuyeucaunhap`
--
ALTER TABLE `phieuyeucaunhap`
  ADD CONSTRAINT `phieuyeucaunhap_ibfk_1` FOREIGN KEY (`MAPHIEUNHAP`) REFERENCES `phieunhap` (`MAPHIEUNHAP`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
