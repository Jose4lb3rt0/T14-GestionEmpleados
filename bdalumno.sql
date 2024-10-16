-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-10-2024 a las 03:08:24
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
-- Base de datos: `bdalumno`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `tipoDocumento` varchar(100) DEFAULT NULL,
  `numeroDocumento` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `estadoCivil` enum('Soltero','Casado','Viudo') DEFAULT NULL,
  `informacionAdicional` text DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `departamento` varchar(100) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `estadoLaboral` enum('Activo','Inactivo','Suspendido') DEFAULT NULL,
  `metodoPago` enum('Efectivo','Transferencia','Cheque') DEFAULT NULL,
  `ultimaEmpresa` varchar(100) DEFAULT NULL,
  `anosExperiencia` int(11) DEFAULT NULL,
  `comunicacion` tinyint(1) DEFAULT 0,
  `analisis` tinyint(1) DEFAULT 0,
  `trabajoEquipo` tinyint(1) DEFAULT 0,
  `resolucionProblemas` tinyint(1) DEFAULT 0,
  `liderazgo` tinyint(1) DEFAULT 0,
  `adaptabilidad` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
