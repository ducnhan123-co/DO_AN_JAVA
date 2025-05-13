-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 03, 2025 lúc 10:50 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cuahangthucpham`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` char(100) NOT NULL,
  `MaHang` char(100) NOT NULL,
  `DonGia` int(11) NOT NULL CHECK (`DonGia` >= 0),
  `SoLuong` int(11) DEFAULT NULL CHECK (`SoLuong` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaHang`, `DonGia`, `SoLuong`) VALUES
('HD.nhanvien.251828081856', 'SP002.251528071543', 120000, 1),
('HD.nhanvien.251928081917', 'SP001.251328071311', 30000, 1),
('HD.nhanvien.252628072625', 'SP002.251528071543', 120000, 1),
('HD.nhanvien.252628072625', 'SP005.251428071408', 300000, 1),
('HD.nhanvien.255530065557', 'SP001.251328071311', 30000, 2),
('HD.nhanvien.255530065557', 'SP002.251528071543', 120000, 2),
('HD.nhanvien.255530065557', 'SP005.251428071408', 300000, 2),
('HD.nhanvien.255530065557', 'SP010.251428071446', 180000, 2),
('HD.nhanvien.255530065557', 'SP012.251628071616', 20000, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietpnhap`
--

CREATE TABLE `chitietpnhap` (
  `MaPhieu` char(100) NOT NULL,
  `MaHang` char(100) NOT NULL,
  `DonGia` int(11) NOT NULL CHECK (`DonGia` >= 0),
  `SoLuong` int(11) DEFAULT NULL CHECK (`SoLuong` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietpnhap`
--

INSERT INTO `chitietpnhap` (`MaPhieu`, `MaHang`, `DonGia`, `SoLuong`) VALUES
('NH.nhanvien.251628071619', 'SP001.251328071311', 20000, 500),
('NH.nhanvien.251628071619', 'SP002.251528071543', 100000, 500),
('NH.nhanvien.251628071619', 'SP005.251428071408', 200000, 500),
('NH.nhanvien.251628071619', 'SP010.251428071446', 100000, 400),
('NH.nhanvien.251628071619', 'SP012.251628071616', 10000, 400);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donvi`
--

CREATE TABLE `donvi` (
  `MaDonVi` int(11) NOT NULL,
  `TenDonVi` varchar(32) NOT NULL,
  `MoTa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `donvi`
--

INSERT INTO `donvi` (`MaDonVi`, `TenDonVi`, `MoTa`) VALUES
(1, 'Kg', NULL),
(2, 'Lit', NULL),
(3, 'Cai', NULL),
(4, 'Chai', NULL),
(5, 'Goi', NULL),
(6, 'Tui', NULL),
(7, 'Hop', NULL),
(8, 'Can', NULL),
(9, 'Bo', NULL),
(10, 'Cuon', NULL),
(11, 'Mieng', NULL),
(12, 'Lo', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hang`
--

CREATE TABLE `hang` (
  `MaHang` char(100) NOT NULL,
  `MaSP` char(100) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL CHECK (`SoLuong` >= 0),
  `NgaySanXuat` datetime NOT NULL,
  `GiamGia` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hang`
--

INSERT INTO `hang` (`MaHang`, `MaSP`, `SoLuong`, `NgaySanXuat`, `GiamGia`) VALUES
('SP001.251328071311', 'SP001', 497, '2025-04-28 00:00:00', 0),
('SP002.251528071543', 'SP002', 496, '2025-04-28 00:00:00', 0),
('SP005.251428071408', 'SP005', 497, '2025-04-28 00:00:00', 0),
('SP008.251602051624', 'SP008', 100, '2025-05-02 00:00:00', 0),
('SP010.251428071446', 'SP010', 398, '2025-04-28 00:00:00', 0),
('SP012.251628071616', 'SP012', 399, '2025-04-28 00:00:00', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` char(100) NOT NULL,
  `MaKH` char(100) NOT NULL,
  `MaNV` char(100) NOT NULL,
  `TongTien` int(11) DEFAULT 0,
  `TienGiam` int(100) DEFAULT 0,
  `ThoiGian` datetime DEFAULT current_timestamp(),
  `KhuyenMai` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `TongTien`, `TienGiam`, `ThoiGian`, `KhuyenMai`) VALUES
('HD.nhanvien.251828081856', 'KH.251228071240', 'nhanvien', 120000, 12000, '2025-04-28 20:18:56', 'mungngay30thg4'),
('HD.nhanvien.251928081917', 'KH.251228071240', 'nhanvien', 30000, 6000, '2025-04-28 20:19:17', 'thitbongon'),
('HD.nhanvien.252628072625', 'KH.251228071240', 'nhanvien', 420000, 0, '2025-04-28 19:26:25', NULL),
('HD.nhanvien.255530065557', 'KH.255430065424', 'nhanvien', 1300000, 260000, '2025-04-30 06:55:57', 'thitbongon');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` char(100) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `TenLot` varchar(20) DEFAULT NULL,
  `Ten` varchar(20) NOT NULL,
  `Phai` varchar(10) DEFAULT NULL CHECK (`Phai` in ('nam','nu')),
  `NgaySinh` date DEFAULT NULL,
  `SDT` char(10) NOT NULL,
  `TinhThanh` int(11) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `NgayThamGia` date DEFAULT curdate(),
  `Diem` int(11) DEFAULT 0,
  `TrangThai` varchar(10) NOT NULL CHECK (`TrangThai` in ('active','inactive'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `TenLot`, `Ten`, `Phai`, `NgaySinh`, `SDT`, `TinhThanh`, `DiaChi`, `NgayThamGia`, `Diem`, `TrangThai`) VALUES
('KH.251228071240', 'Người', 'Khách', 'Hàng', 'nu', '2005-04-27', '111111111', 1, 'trường đại học Sài Gòn (SGU)', '2025-04-28', 0, 'active'),
('KH.255430065424', 'Người', 'Khách', 'Khác', 'nam', '2025-04-30', '2222222222', 13, 'đại học Mở', '2025-04-30', 0, 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` char(100) NOT NULL,
  `TenKM` varchar(255) NOT NULL,
  `MoTa` varchar(255) DEFAULT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `MaSP` char(100) DEFAULT NULL,
  `GiaTri` decimal(10,2) DEFAULT NULL,
  `SoLuong` int(11) NOT NULL,
  `TrangThai` varchar(10) NOT NULL CHECK (`TrangThai` in ('active','inactive'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `MoTa`, `NgayBatDau`, `NgayKetThuc`, `MaSP`, `GiaTri`, `SoLuong`, `TrangThai`) VALUES
('mungngay30thg4', 'kỉ niệm ngày giải phóng', 'tất cả hoá đơn được giảm 10%', '2025-04-20', '2025-05-01', NULL, 30.00, 999, 'active'),
('thitbongon', 'giảm giá thịt bò', 'hoá đơn có thịt bò được giảm 20%', '2025-04-01', '2026-04-30', 'SP001', 20.00, 998, 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL,
  `MoTa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`, `MoTa`) VALUES
(1, 'Thit va hai san', 'Cac loai thuc pham tu thit va hai san, chua nhieu protein va chat beo tot.'),
(2, 'Rau cu', 'Cac loai rau va cu, cung cap vitamin, khoang chat va chat xo.'),
(3, 'Trai cay', 'Cac loai trai cay tuoi, giau vitamin va chat chong oxy hoa.'),
(4, 'Ngu coc va tinh bot', 'Cac loai ngu coc va tinh bot, cung cap nang luong cho co the.'),
(5, 'San pham tu sua', 'Cac loai thuc pham che bien tu sua, giau canxi va protein.'),
(6, 'Gia vi va thao moc', 'Cac loai gia vi va thao moc dung de lam gia vi va tang huong vi mon an.'),
(7, 'Dau va hat', 'Cac loai dau va hat, chua nhieu protein thuc vat va chat beo lanh manh.'),
(8, 'Do uong', 'Cac loai do uong tu nuoc, tra, ca phe, den cac loai nuoc ep va sinh to.'),
(9, 'Banh keo', 'Cac loai banh, keo va do ngot, thuong duoc lam tu duong, bot va cac thanh phan tao ngot.'),
(10, 'Mon an che bien san', 'Cac mon an da duoc che bien san, de dang su dung hoac can lam nong lai.'),
(11, 'Do hop', 'Cac loai thuc pham duoc dong hop de bao quan lau dai, bao gom cac mon nhu thit hop, ca hop, rau cu hop.'),
(12, 'cồn', 'bia rượu'),
(13, 'beef', 'bừa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCCap` char(100) NOT NULL,
  `TenNCCap` varchar(255) NOT NULL,
  `TenLienHe` varchar(255) DEFAULT NULL,
  `SDThoai` char(10) NOT NULL,
  `TinhThanh` int(11) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `TrangThai` char(10) NOT NULL CHECK (`TrangThai` in ('active','inactive'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCCap`, `TenNCCap`, `TenLienHe`, `SDThoai`, `TinhThanh`, `DiaChi`, `TrangThai`) VALUES
('nhacungcap', 'Nhà cung cấp', 'Nhà cung cấp', '1231231231', 54, 'Bến tre', 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` char(100) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `TenLot` varchar(20) DEFAULT NULL,
  `Ten` varchar(20) NOT NULL,
  `Phai` varchar(10) DEFAULT NULL CHECK (`Phai` in ('nam','nu')),
  `NgaySinh` date DEFAULT NULL,
  `SDT` char(10) NOT NULL,
  `TinhThanh` int(11) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `Luong` int(11) DEFAULT NULL,
  `chucVu` char(3) NOT NULL CHECK (`chucVu` in ('QL','NV')),
  `TrangThai` char(10) NOT NULL CHECK (`TrangThai` in ('active','inactive')),
  `MatKhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `TenLot`, `Ten`, `Phai`, `NgaySinh`, `SDT`, `TinhThanh`, `DiaChi`, `Luong`, `chucVu`, `TrangThai`, `MatKhau`) VALUES
('admin', 'Sieu', 'quan', 'ly', NULL, NULL, '0123456789', NULL, NULL, NULL, 'QL', 'active', 'admin'),
('nhanvien', 'Người', 'Nhân', 'Viên', 'nam', '1995-01-01', '1234567890', 34, 'trường đại học Sài Gòn', 10000000, 'NV', 'active', 'nhanvien');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MaPhieu` char(100) NOT NULL,
  `MaNCCap` char(100) NOT NULL,
  `NguoiNhap` char(100) NOT NULL,
  `TongTien` int(11) NOT NULL DEFAULT 0,
  `ThoiGian` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`MaPhieu`, `MaNCCap`, `NguoiNhap`, `TongTien`, `ThoiGian`) VALUES
('NH.nhanvien.251628071619', 'nhacungcap', 'nhanvien', 204000000, '2025-04-28 19:16:19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` char(100) NOT NULL,
  `TenSP` varchar(255) NOT NULL,
  `Loai` int(11) NOT NULL,
  `DonViTinh` int(11) NOT NULL,
  `HSDung` int(11) DEFAULT NULL,
  `MoTa` varchar(255) DEFAULT NULL,
  `Gia` int(11) NOT NULL,
  `SoLuongTon` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `Loai`, `DonViTinh`, `HSDung`, `MoTa`, `Gia`, `SoLuongTon`) VALUES
('SP001', 'Thịt bò', 1, 1, 3, 'Thit bo tuoi', 30000, 497),
('SP002', 'Thit Heo', 1, 1, 3, 'Thit heo tuoi', 120000, 496),
('SP003', 'Cua hoang de', 1, 1, 7, 'Cua hoang de tuoi', 5000000, 0),
('SP004', 'Tom Hum', 1, 1, 20251231, 'Tom hum song', 500000, 0),
('SP005', 'Ca Hoi', 1, 1, 20251231, 'Ca hoi nhap khau', 300000, 497),
('SP006', 'Ca Basa', 1, 1, 20251231, 'Ca basa tuoi', 80000, 0),
('SP007', 'Muc Ong', 1, 1, 20251231, 'Muc ong tuoi', 500000, 0),
('SP008', 'Ca Chep', 1, 1, 20251231, 'Ca chep tuoi', 90000, 100),
('SP009', 'Hau', 1, 1, 20251231, 'Hau tuoi', 220000, 0),
('SP010', 'Tom Tuoi', 1, 1, 20251231, 'Tom tuoi song', 180000, 398),
('SP011', 'Cai Bo Xoi', 2, 1, 20250301, 'Cai bo xoi tuoi', 30000, 0),
('SP012', 'Ca Rot', 2, 1, 20250301, 'Ca rot tuoi', 20000, 398),
('SP013', 'Su Su', 2, 1, 20250301, 'Su su tuoi', 25000, 0),
('SP014', 'Rau Muong', 2, 1, 20250301, 'Rau muong tuoi', 15000, 0),
('SP015', 'Cai Ngot', 2, 1, 20250301, 'Cai ngot tuoi', 22000, 0),
('SP016', 'Bap Cai', 2, 1, 20250301, 'Bap cai tuoi', 28000, 0),
('SP017', 'Mong Toi', 2, 1, 20250301, 'Mong toi tuoi', 18000, 0),
('SP018', 'Dưa leo', 2, 1, 4, 'Dua leo tuoi', 10000, 0),
('SP019', 'Rau Den', 2, 1, 20250301, 'Rau den tuoi', 17000, 0),
('SP020', 'Cai Cuc', 2, 1, 20250301, 'Cai cuc tuoi', 24000, 0),
('SP021', 'Tao', 3, 1, 20250701, 'Tao do tuoi', 40000, 0),
('SP022', 'Cam', 3, 1, 20250701, 'Cam tuoi', 35000, 0),
('SP023', 'Nho', 3, 1, 20250701, 'Nho xanh tuoi', 45000, 0),
('SP024', 'Le', 3, 1, 20250701, 'Le tuoi', 50000, 0),
('SP025', 'Chom Chom', 3, 1, 20250701, 'Chom chom tuoi', 60000, 0),
('SP026', 'Dua Hau', 3, 1, 20250701, 'Dua hau tuoi', 30000, 0),
('SP027', 'Mang Cut', 3, 1, 20250701, 'Mang cut tuoi', 70000, 0),
('SP028', 'Sau Rieng', 3, 1, 20250701, 'Sau rieng tuoi', 80000, 0),
('SP029', 'Bo', 3, 1, 20250701, 'Bo tuoi', 90000, 0),
('SP030', 'Quyt', 3, 1, 20250701, 'Quyt tuoi', 25000, 0),
('SP031', 'Gao', 4, 1, 20251231, 'Gao trang sach', 30000, 0),
('SP032', 'Banh Mi', 4, 1, 20251231, 'Banh mi tuoi', 12000, 0),
('SP033', 'Bánh bao', 4, 3, 1, 'Bánh bao ngon nhất thế giới', 10000, 0),
('SP034', 'Bun', 4, 1, 20251231, 'Bun tuoi', 12000, 0),
('SP035', 'Mi', 4, 1, 20251231, 'Mi goi', 5000, 0),
('SP036', 'Pho', 4, 1, 20251231, 'Pho tuoi', 20000, 0),
('SP037', 'Mien', 4, 1, 20251231, 'Mien kho', 22000, 0),
('SP038', 'Com Tam', 4, 1, 20251231, 'Com tam suon', 30000, 0),
('SP039', 'Nui', 4, 1, 20251231, 'Nui kho', 10000, 0),
('SP040', 'Soi Banh Canh', 4, 1, 20251231, 'Banh canh tuoi', 22000, 0),
('SP041', 'Sua Ong Tho', 5, 1, 20251231, 'Sua dac co duong', 12000, 0),
('SP042', 'Sua Tuoi Vinamilk', 5, 1, 20251231, 'Sua tuoi nguyen kem', 25000, 0),
('SP043', 'Sua Bot Meiji', 5, 1, 20251231, 'Sua bot cho tre em', 35000, 0),
('SP044', 'Sua Chua Vinamilk', 5, 1, 20251231, 'Sua chua tuoi', 15000, 0),
('SP045', 'Sua Bot Anlene', 5, 1, 20251231, 'Sua bot cho nguoi gia', 45000, 0),
('SP046', 'Sua Bot Grow', 5, 1, 20251231, 'Sua bot cho tre em', 55000, 0),
('SP047', 'Sua Tuoi TH True Milk', 5, 1, 20251231, 'Sua tuoi khong duong', 20000, 0),
('SP048', 'Sua Bot Dutch Lady', 5, 1, 20251231, 'Sua bot cho tre em', 30000, 0),
('SP049', 'Sua Dau Nanh', 5, 1, 20251231, 'Sua dau nanh nguyen chat', 22000, 0),
('SP050', 'Sua Bot Friso', 5, 1, 20251231, 'Sua bot dinh duong cho tre', 60000, 0),
('SP051', 'Muoi Hong Himalaya', 6, 1, 20251231, 'Muoi hong nguyen chat', 30000, 0),
('SP052', 'Tieu Den', 6, 1, 20251231, 'Tieu den xay', 35000, 0),
('SP053', 'Bot Ngot', 6, 1, 20251231, 'Bot ngot gia vi', 10000, 0),
('SP054', 'Nuoc Mam', 6, 1, 20251231, 'Nuoc mam nguyen chat', 15000, 0),
('SP055', 'Bot Ca Ri', 6, 1, 20251231, 'Bot gia vi ca ri', 20000, 0),
('SP056', 'Gung Tuoi', 6, 1, 20251231, 'Gung tuoi', 25000, 0),
('SP057', 'Toi Tuoi', 6, 1, 20251231, 'Toi tuoi', 20000, 0),
('SP058', 'Hung Que', 6, 1, 20251231, 'Hung que tuoi', 18000, 0),
('SP059', 'Ca Phe', 6, 1, 20251231, 'Ca phe rang xay', 60000, 0),
('SP060', 'Ot Tuoi', 6, 1, 20251231, 'Ot tuoi', 15000, 0),
('SP061', 'Hat De', 7, 1, 20251231, 'Hat de rang', 50000, 0),
('SP062', 'Hat Huong Duong', 7, 1, 20251231, 'Hat huong duong rang', 35000, 0),
('SP063', 'Hat Dieu', 7, 1, 20251231, 'Hat dieu rang muoi', 60000, 0),
('SP064', 'Hat Macca', 7, 1, 20251231, 'Hat macca rang', 80000, 0),
('SP065', 'Hat Chia', 7, 1, 20251231, 'Hat chia nguyen chat', 70000, 0),
('SP066', 'Hat Luu', 7, 1, 20251231, 'Hat luu kho', 40000, 0),
('SP067', 'Hat Qua Oc Cho', 7, 1, 20251231, 'Hat oc cho', 75000, 0),
('SP068', 'Hat Lan', 7, 1, 20251231, 'Hat lan kho', 20000, 0),
('SP069', 'Hat Sen', 7, 1, 20251231, 'Hat sen kho', 30000, 0),
('SP070', 'Hat Dua', 7, 1, 20251231, 'Hat dua rang', 15000, 0),
('SP071', 'Nuoc Ngot Coca Cola', 8, 1, 20251231, 'Nuoc ngot Coca Cola', 20000, 0),
('SP072', 'Nuoc Suoi Aquafina', 8, 1, 20251231, 'Nuoc suoi Aquafina', 15000, 0),
('SP073', 'Tra Xanh Lipton', 8, 1, 20251231, 'Tra xanh Lipton', 25000, 0),
('SP074', 'Nuoc Ep Cam', 8, 1, 20251231, 'Nuoc ep cam nguyen chat', 30000, 0),
('SP075', 'Nuoc Ep Dua', 8, 1, 20251231, 'Nuoc ep dua nguyen chat', 30000, 0),
('SP076', 'Nuoc Chanh Leo', 8, 1, 20251231, 'Nuoc chanh leo tuoi', 35000, 0),
('SP077', 'Ca Phe Sua', 8, 1, 20251231, 'Ca phe sua da', 40000, 0),
('SP078', 'Nuoc Ep Dua Hau', 8, 1, 20251231, 'Nuoc ep dua hau tuoi', 25000, 0),
('SP079', 'Nuoc Ep Tao', 8, 1, 20251231, 'Nuoc ep tao nguyen chat', 35000, 0),
('SP080', 'Tra Sua', 8, 1, 20251231, 'Tra sua tran chau', 45000, 0),
('SP081', 'Banh Pia', 9, 1, 20251231, 'Banh Pia sau rieng', 40000, 0),
('SP082', 'Banh Che', 9, 1, 20251231, 'Banh che dau xanh', 20000, 0),
('SP083', 'Banh Bao', 9, 1, 20251231, 'Banh bao nhan thit', 10000, 0),
('SP084', 'Banh Croissant', 9, 1, 20251231, 'Banh croissant tuoi', 25000, 0),
('SP085', 'Banh Quy', 9, 1, 20251231, 'Banh quy gion', 15000, 0),
('SP086', 'Banh Dau Xanh', 9, 1, 20251231, 'Banh dau xanh', 20000, 0),
('SP087', 'Banh Trung Thu', 9, 1, 20251231, 'Banh trung thu', 50000, 0),
('SP088', 'Banh Mi Nuong', 9, 1, 20251231, 'Banh mi nuong', 12000, 0),
('SP089', 'Banh Mochi', 9, 1, 20251231, 'Banh mochi Nhat Ban', 35000, 0),
('SP090', 'Banh Quy Bo', 9, 1, 20251231, 'Banh quy bo', 25000, 0),
('SP091', 'Banh Bao Ca', 10, 1, 20251231, 'Banh bao nhan ca', 25000, 0),
('SP092', 'Cha Ca', 10, 1, 20251231, 'Cha ca tuoi', 30000, 0),
('SP093', 'Goi Ca', 10, 1, 20251231, 'Goi ca tuoi', 35000, 0),
('SP094', 'Sushi Ca', 10, 1, 20251231, 'Sushi ca hoi', 50000, 0),
('SP095', 'Ca Nuong', 10, 1, 20251231, 'Ca nuong mo hanh', 45000, 0),
('SP096', 'Lau Ca', 10, 1, 20251231, 'Lau ca tuoi', 60000, 0),
('SP097', 'Ca Chien', 10, 1, 20251231, 'Ca chien gion', 35000, 0),
('SP098', 'Sup Ca', 10, 1, 20251231, 'Sup ca tuoi', 30000, 0),
('SP099', 'Cá kho', 10, 1, 3, 'Ca kho to', 90000, 0),
('SP100', 'Bánh gạo khánh dư', 9, 5, 14, 'Bánh gạo ngon nhất thế giới mẹ luôn', 22000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tinhthanh`
--

CREATE TABLE `tinhthanh` (
  `MaTThanh` int(11) NOT NULL,
  `TenTThanh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tinhthanh`
--

INSERT INTO `tinhthanh` (`MaTThanh`, `TenTThanh`) VALUES
(1, 'Ha Giang'),
(2, 'Cao Bang'),
(3, 'Bac Kan'),
(4, 'Lang Son'),
(5, 'Tuyen Quang'),
(6, 'Thai Nguyen'),
(7, 'Phu Tho'),
(8, 'Bac Giang'),
(9, 'Quang Ninh'),
(10, 'Lao Cai'),
(11, 'Yen Bai'),
(12, 'Dien Bien'),
(13, 'Lai Chau'),
(14, 'Son La'),
(15, 'Hoa Binh'),
(16, 'Ha Noi'),
(17, 'Hai Phong'),
(18, 'Hung Yen'),
(19, 'Ha Nam'),
(20, 'Nam Dinh'),
(21, 'Thai Binh'),
(22, 'Ninh Binh'),
(23, 'Bac Ninh'),
(24, 'Vinh Phuc'),
(25, 'Hai Duong'),
(26, 'Thanh Hoa'),
(27, 'Nghe An'),
(28, 'Ha Tinh'),
(29, 'Quang Binh'),
(30, 'Quang Tri'),
(31, 'Thua Thien Hue'),
(32, 'Da Nang'),
(33, 'Quang Nam'),
(34, 'Quang Ngai'),
(35, 'Binh Dinh'),
(36, 'Phu Yen'),
(37, 'Khanh Hoa'),
(38, 'Ninh Thuan'),
(39, 'Binh Thuan'),
(40, 'Kon Tum'),
(41, 'Gia Lai'),
(42, 'Dak Lak'),
(43, 'Dak Nong'),
(44, 'Lam Dong'),
(45, 'Thanh pho Ho Chi Minh'),
(46, 'Ba Ria - Vung Tau'),
(47, 'Binh Duong'),
(48, 'Binh Phuoc'),
(49, 'Dong Nai'),
(50, 'Tay Ninh'),
(51, 'Can Tho'),
(52, 'Long An'),
(53, 'Tien Giang'),
(54, 'Ben Tre'),
(55, 'Tra Vinh'),
(56, 'Vinh Long'),
(57, 'Dong Thap'),
(58, 'An Giang'),
(59, 'Kien Giang'),
(60, 'Hau Giang'),
(61, 'Soc Trang'),
(62, 'Bac Lieu'),
(63, 'Ca Mau');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaHang`),
  ADD KEY `idx_ChiTietHoaDon_MaHD` (`MaHD`),
  ADD KEY `idx_ChiTietHoaDon_MaHang` (`MaHang`);

--
-- Chỉ mục cho bảng `chitietpnhap`
--
ALTER TABLE `chitietpnhap`
  ADD PRIMARY KEY (`MaPhieu`,`MaHang`),
  ADD KEY `idx_ChiTietPNhap_MaPhieu` (`MaPhieu`),
  ADD KEY `idx_ChiTietPNhap_MaHang` (`MaHang`);

--
-- Chỉ mục cho bảng `donvi`
--
ALTER TABLE `donvi`
  ADD PRIMARY KEY (`MaDonVi`);

--
-- Chỉ mục cho bảng `hang`
--
ALTER TABLE `hang`
  ADD PRIMARY KEY (`MaHang`),
  ADD KEY `idx_Hang_MaSP` (`MaSP`),
  ADD KEY `idx_Hang_NgaySanXuat` (`NgaySanXuat`),
  ADD KEY `idx_Hang_GiamGia` (`GiamGia`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `idx_HoaDon_MaKH` (`MaKH`),
  ADD KEY `idx_HoaDon_MaNV` (`MaNV`),
  ADD KEY `idx_HoaDon_ThoiGian` (`ThoiGian`),
  ADD KEY `hoadon_ibfk_3` (`KhuyenMai`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`),
  ADD UNIQUE KEY `SDT` (`SDT`),
  ADD KEY `idx_KhachHang_TinhThanh` (`TinhThanh`),
  ADD KEY `idx_KhachHang_SDT` (`SDT`),
  ADD KEY `idx_KhachHang_TrangThai` (`TrangThai`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`),
  ADD KEY `khuyenmai_sanpham` (`MaSP`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCCap`),
  ADD KEY `idx_NhaCungCap_TinhThanh` (`TinhThanh`),
  ADD KEY `idx_NhaCungCap_TrangThai` (`TrangThai`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`),
  ADD UNIQUE KEY `SDT` (`SDT`),
  ADD KEY `idx_NhanVien_TinhThanh` (`TinhThanh`),
  ADD KEY `idx_NhanVien_TrangThai` (`TrangThai`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MaPhieu`),
  ADD KEY `idx_PhieuNhapHang_MaNCCap` (`MaNCCap`),
  ADD KEY `idx_PhieuNhapHang_NguoiNhap` (`NguoiNhap`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `idx_SanPham_TenSP` (`TenSP`),
  ADD KEY `idx_SanPham_Loai` (`Loai`),
  ADD KEY `idx_SanPham_DonViTinh` (`DonViTinh`),
  ADD KEY `idx_SanPham_SoLuongTon` (`SoLuongTon`);

--
-- Chỉ mục cho bảng `tinhthanh`
--
ALTER TABLE `tinhthanh`
  ADD PRIMARY KEY (`MaTThanh`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donvi`
--
ALTER TABLE `donvi`
  MODIFY `MaDonVi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tinhthanh`
--
ALTER TABLE `tinhthanh`
  MODIFY `MaTThanh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaHang`) REFERENCES `hang` (`MaHang`);

--
-- Các ràng buộc cho bảng `chitietpnhap`
--
ALTER TABLE `chitietpnhap`
  ADD CONSTRAINT `chitietpnhap_ibfk_1` FOREIGN KEY (`MaPhieu`) REFERENCES `phieunhaphang` (`MaPhieu`),
  ADD CONSTRAINT `chitietpnhap_ibfk_2` FOREIGN KEY (`MaHang`) REFERENCES `hang` (`MaHang`);

--
-- Các ràng buộc cho bảng `hang`
--
ALTER TABLE `hang`
  ADD CONSTRAINT `hang_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`KhuyenMai`) REFERENCES `khuyenmai` (`MaKM`);

--
-- Các ràng buộc cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`TinhThanh`) REFERENCES `tinhthanh` (`MaTThanh`);

--
-- Các ràng buộc cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD CONSTRAINT `khuyenmai_sanpham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Các ràng buộc cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD CONSTRAINT `nhacungcap_ibfk_1` FOREIGN KEY (`TinhThanh`) REFERENCES `tinhthanh` (`MaTThanh`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`TinhThanh`) REFERENCES `tinhthanh` (`MaTThanh`);

--
-- Các ràng buộc cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`MaNCCap`) REFERENCES `nhacungcap` (`MaNCCap`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`NguoiNhap`) REFERENCES `nhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`Loai`) REFERENCES `loai` (`MaLoai`),
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`DonViTinh`) REFERENCES `donvi` (`MaDonVi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
