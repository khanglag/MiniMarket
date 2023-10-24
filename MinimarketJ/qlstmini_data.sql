-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 18, 2023 lúc 12:05 PM
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
-- Cơ sở dữ liệu: `qlstmini`
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
(1, '8809541033891', 1, 1);

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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_phieunhap`
--

CREATE TABLE `chitiet_phieunhap` (
  `MAPHIEUNHAP` char(7) NOT NULL,
  `MAHANGNHAP` char(13) NOT NULL,
  `TENHANGNHAP` text NOT NULL,
  `VAT` double NOT NULL,
  `XUATXU` text NOT NULL,
  `ANHSP` text NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONVI` text NOT NULL,
  `GIANHAP` double NOT NULL,
  `TONGTIENNHAP` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiet_phieunhap`
--

INSERT INTO `chitiet_phieunhap` (`MAPHIEUNHAP`, `MAHANGNHAP`, `TENHANGNHAP`, `VAT`, `XUATXU`, `ANHSP`, `SOLUONG`, `DONVI`, `GIANHAP`, `TONGTIENNHAP`, `TONTAI`) VALUES
('0000001', '4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', 0.08, 'Việt Nam', '', 10, 'gói', 309600, 3343680, 1),
('0000001', '8657882990341', 'Nước giặt Downy vườn hoa thơm ngát túi 3.05kg', 0.08, 'Việt Nam', '', 20, 'túi', 89400, 1931040, 1),
('0000001', '8809541033891', 'Mặt nạ chiết xuất từ nghệ Purederm dưỡng da', 0.08, 'Việt Nam', '', 100, 'miếng', 5000, 540000, 1),
('0000001', '8835166023316', 'Lốc 3 cuộn túi rác đen tự huỷ sinh học 64x78cm (1kg)', 0.08, 'Việt Nam', '', 50, 'lốc', 33600, 1814400, 1),
('0000001', '8843331098667', 'Thùng 24 bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 0.08, 'Việt Nam', '', 5, 'thùng', 76200, 411480, 1),
('0000001', '8853301530293', 'Thức ăn cho chó lớn Pedigree vị bò kho và rau củ túi 130g', 0.08, 'Việt Nam', '', 100, 'túi', 9000, 972000, 1),
('0000001', '8934558928122', 'Dầu ăn cao cấp Happi Koki chai 1 lít', 0.08, 'Việt Nam', '', 50, 'chai', 20700, 1117800, 1),
('0000001', '8934561667891', 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', 0.08, 'Việt Nam', '', 10, 'thùng', 64800, 699840, 1),
('0000001', '8934822561234', 'Thùng 12 lon bia Bia Việt 330ml', 0.08, 'Việt Nam', '', 10, 'thùng', 80600, 870480, 1),
('0000001', '8935162895621', 'Gạo thơm đặc sản Neptune ST25 túi 5kg', 0.08, 'Việt Nam', '', 10, 'túi', 81000, 874800, 1),
('0000001', '8936011896782', 'Sữa chua dẻo phô mai Merino gói 50g', 0.08, 'Việt Nam', '', 50, 'gói', 3600, 194400, 1),
('0000001', '8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', 0.08, 'Việt Nam', '', 10, 'cái', 27000, 291600, 1),
('0000002', '8934563138165', 'Mì Hảo Hảo gói 75g', 0.08, 'Việt Nam', '', 300, 'gói', 1800, 583200, 1),
('0000002', '8934822220112', 'Lon bia Việt 330ml', 0.08, 'Việt Nam', '', 300, 'lon', 8500, 2754000, 1),
('0000002', '8934841903058', 'Bịch sữa tiệt trùng ít đường Dutch Lady 180ml', 0.08, 'Việt Nam', '', 300, 'bịch', 3100, 1004400, 1);

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
('0000001', '4902430556781', 3, 3, 'gói', 433440, 1300320, 1),
('0000001', '8657882990341', 3, 3, 'túi', 125160, 375480, 1);

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
('4902430556781', 'Tã dán Pampers nội địa Nhật Bản cao cấp thượng hạn size M 52 miếng 6-11 kg', '0000004', 'NCCDYQN', 'gói', 309600, 433440, 7, 'Việt Nam', 'Images\\tadan.jpg', 1),
('8657882990341', 'Nước giặt Downy vườn hoa thơm ngát túi 3.05kg', '0000003', 'NCCDYQN', 'túi', 89400, 125160, 17, 'Việt Nam', 'Images\\nuocgiat.jpg', 1),
('8809541033891', 'Mặt nạ chiết xuất từ nghệ Purederm dưỡng da', '0000005', 'NCCDYQN', 'miếng', 5000, 7000, 99, 'Việt Nam', 'Images\\matna.jpg', 1),
('8835166023316', 'Lốc 3 cuộn túi rác đen tự huỷ sinh học 64x78cm (1kg)', '0000002', 'NCCDYQN', 'lốc', 33600, 47040, 50, 'Việt Nam', 'Images\\tuirac.jpg', 1),
('8843331098667', 'Thùng 24 bịch sữa tiệt trùng ít đường Dutch Lady 180ml', '0000007', 'NCCDYQN', 'thùng', 76200, 99060, 5, 'Việt Nam', 'Images\\thung24bichsua.jpg', 1),
('8853301530293', 'Thức ăn cho chó lớn Pedigree vị bò kho và rau củ túi 130g', '0000001', 'NCCDYQN', 'túi', 9000, 12600, 100, 'Việt Nam', 'Images\\thucancho.jpg', 1),
('8934558928122', 'Dầu ăn cao cấp Happi Koki chai 1 lít', '0000012', 'NCCDYQN', 'chai', 20700, 28980, 50, 'Việt Nam', 'Images\\dauan.jpg', 1),
('8934561667891', 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', '0000010', 'NCCDYQN', 'thùng', 64800, 84240, 10, 'Việt Nam', 'Images\\thung30goimihaohao.jpg', 1),
('8934563138165', 'Mì Hảo Hảo gói 75g', '0000010', 'NCCDYQN', 'gói', 1800, 2520, 300, 'Việt Nam', 'Images\\mihaohao.jpg', 1),
('8934822220112', 'Lon bia Việt 330ml', '0000008', 'NCCDYQN', 'lon', 8500, 11900, 300, 'Việt Nam', 'Images\\biaviet.jpg', 1),
('8934822561234', 'Thùng 12 lon bia Bia Việt 330ml', '0000008', 'NCCDYQN', 'thùng', 80600, 104780, 10, 'Việt Nam', 'Images\\thung12lonbiaviet.jpg', 1),
('8934841903058', 'Bịch sữa tiệt trùng ít đường Dutch Lady 180ml', '0000007', 'NCCDYQN', 'bịch', 3100, 4340, 300, 'Việt Nam', 'Images\\suatiettrung.jpg', 1),
('8935162895621', 'Gạo thơm đặc sản Neptune ST25 túi 5kg', '0000009', 'NCCDYQN', 'túi', 81000, 113400, 10, 'Việt Nam', 'Images\\gao.jpg', 1),
('8936011896782', 'Sữa chua dẻo phô mai Merino gói 50g', '0000011', 'NCCDYQN', 'gói', 3600, 5040, 50, 'Việt Nam', 'Images\\suachua.jpg', 1),
('8936021003321', 'Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 120g', '0000006', 'NCCDYQN', 'cái', 27000, 37800, 10, 'Việt Nam', 'Images\\btt.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `SOHD` int(11) NOT NULL,
  `MANV` char(7) NOT NULL,
  `THOIGIANLAP` datetime NOT NULL,
  `MAKH` char(7) NOT NULL,
  `TONGHD` double NOT NULL,
  `THANHTOAN` double NOT NULL,
  `TIENKHACHDUA` double NOT NULL,
  `TIENTRAKHACH` double NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`SOHD`, `MANV`, `THOIGIANLAP`, `MAKH`, `TONGHD`, `THANHTOAN`, `TIENKHACHDUA`, `TIENTRAKHACH`, `TONTAI`) VALUES
(1, 'A070103', '2023-09-19 08:00:30', '0000001', 7000, 7000, 10000, 3000, 1);

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
('0000001', 'Jeon JungKook', '1997-09-01', '0368779041', 'Seoul', 1);

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
('NCCDYQN', 'Nhà cung cấp cho CH', '0358808913', '477 Au duong lan', 1);

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
('A000001', 'Võ Đinh Xuân Hoàng', '2003-02-02', 'nam', '068000000002', '0944313407', 'vodinhxuanhoang@gmail.com', '277 Au Duong Lan', 'NVBH203', 1),
('A000003', 'Nguyễn Trần Yến Nhi', '2003-02-02', 'nữ', '068000000000', '0368562519', 'tuoi@gmail.com', 'Thủ Đức', 'NVTK203', 1),
('A038645', 'Nguyễn Thị Anh Thư ', '2003-08-15', 'nữ', '068303002628', '0368779041', 'nguyenanhthu15082003@gmail.com', '101 Nguyễn Thị Tần', 'NVTK203', 1),
('A070103', 'Nguyễn Kế Cường', '2003-01-07', 'nam', '052000000000', '0682620178', 'kecuong0701@gmail.com', '477 Tân Sơn', 'NVBH203', 1),
('A140403', 'Đỗ Minh Khang', '2003-04-14', 'nam', '068000000001', '0838208944', 'khanglag@gmail.com', 'Duong Quan Ham', 'NVBH203', 1),
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
('', '', 1),
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
('NVBH203', 'Nhân viên bán hàng', 1),
('NVTK203', 'Nhân viên thủ kho', 1),
('QL20003', 'Quản lý', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuchi`
--

CREATE TABLE `phieuchi` (
  `MAPHIEUCHI` char(7) NOT NULL,
  `SOTIEN` double NOT NULL,
  `MANV` char(7) NOT NULL,
  `THOIGIANCHI` datetime NOT NULL,
  `LYDO` text NOT NULL,
  `GHICHU` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuchi`
--

INSERT INTO `phieuchi` (`MAPHIEUCHI`, `SOTIEN`, `MANV`, `THOIGIANCHI`, `LYDO`, `GHICHU`, `TONTAI`) VALUES
('0000001', 11403720, 'B041003', '2023-09-20 07:30:00', 'Chi tiền hàng nhập phiếu 1', '', 1),
('0000002', 4341600, 'B041003', '2023-09-20 17:35:17', 'chi tiền hàng nhập phiếu 2', '', 1);

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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MAPHIEUNHAP` char(7) NOT NULL,
  `MANV` char(7) NOT NULL,
  `MANCC` char(7) NOT NULL,
  `THOIGIANLAP` datetime NOT NULL,
  `VAT` double NOT NULL,
  `SOMATHANG` int(11) NOT NULL,
  `TONGTIEN` double NOT NULL,
  `TONTAI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MAPHIEUNHAP`, `MANV`, `MANCC`, `THOIGIANLAP`, `VAT`, `SOMATHANG`, `TONGTIEN`, `TONTAI`) VALUES
('0000001', 'A038645', 'NCCDYQN', '2023-09-20 08:49:50', 0.08, 12, 11403720, 1),
('0000002', 'B041003', 'NCCDYQN', '2023-09-20 16:32:34', 0.08, 3, 4341600, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MAPHIEUXUAT` char(7) NOT NULL,
  `MANV` char(7) NOT NULL,
  `MAKH` char(7) NOT NULL,
  `TONGTIEN` double NOT NULL,
  `LYDO` text NOT NULL,
  `GHICHU` text NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`MAPHIEUXUAT`, `MANV`, `MAKH`, `TONGTIEN`, `LYDO`, `GHICHU`, `TONTAI`) VALUES
('0000001', 'A038645', '0000001', 1675800, 'xuat hang', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuyeucaunhap`
--

CREATE TABLE `phieuyeucaunhap` (
  `MAPHIEU` char(7) NOT NULL,
  `MASP` char(7) NOT NULL,
  `TENSP` text NOT NULL,
  `SOLUONGTONKHO` int(11) NOT NULL,
  `LYDO` text NOT NULL,
  `THOIGIANYEUCAU` datetime NOT NULL,
  `TRANGTHAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MANV` char(7) NOT NULL,
  `MATKHAU` text NOT NULL,
  `MAPQ` char(7) NOT NULL,
  `TONTAI` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MANV`, `MATKHAU`, `MAPQ`, `TONTAI`) VALUES
('A000001', 'xhne', 'NVBH203', 1),
('A000003', 'tuoine', 'NVTK203', 1),
('A038645', '130613', 'NVTK203', 1),
('A070103', '070103', 'NVBH203', 1),
('A140403', '140403', 'NVBH203', 1),
('B041003', '100403', 'QL20003', 1);

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
  ADD KEY `MAHANGNHAP` (`MAHANGNHAP`);

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
-- Chỉ mục cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  ADD PRIMARY KEY (`MAPHIEUCHI`),
  ADD KEY `MANV` (`MANV`);

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
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MANCC` (`MANCC`);

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
  ADD PRIMARY KEY (`MAPHIEU`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MANV`),
  ADD KEY `MANV` (`MANV`,`MAPQ`);

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
  ADD CONSTRAINT `chitiet_phieunhap_ibfk_2` FOREIGN KEY (`MAHANGNHAP`) REFERENCES `hanghoa` (`MASP`);

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
-- Các ràng buộc cho bảng `phieuchi`
--
ALTER TABLE `phieuchi`
  ADD CONSTRAINT `phieuchi_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `phieukiemhang`
--
ALTER TABLE `phieukiemhang`
  ADD CONSTRAINT `phieukiemhang_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

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
  ADD CONSTRAINT `phieuyeucaunhap_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `hanghoa` (`MASP`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MANV`,`MAPQ`) REFERENCES `nhanvien` (`MANV`, `MAQUYEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
