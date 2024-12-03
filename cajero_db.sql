-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2024 a las 04:22:51
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cajero_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajero`
--

CREATE TABLE `cajero` (
  `id` bigint(20) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `denominacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajero`
--

INSERT INTO `cajero` (`id`, `tipo`, `cantidad`, `denominacion`) VALUES
(1, 'Billete', 2, 1000),
(2, 'Billete', 5, 500),
(3, 'Billete', 10, 200),
(4, 'Billete', 20, 100),
(5, 'Billete', 30, 50),
(6, 'Billete', 40, 20),
(7, 'Moneda', 50, 10),
(8, 'Moneda', 100, 5),
(9, 'Moneda', 200, 2),
(10, 'Moneda', 300, 1),
(11, 'Moneda', 100, 0.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajero`
--
ALTER TABLE `cajero`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
