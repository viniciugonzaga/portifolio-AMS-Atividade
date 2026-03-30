-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30/03/2026 às 03:15
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `empresa`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `envio`
--

CREATE TABLE `envio` (
  `cod_envio` int(11) NOT NULL,
  `nomenavio` varchar(100) DEFAULT NULL,
  `frete` decimal(10,2) DEFAULT NULL,
  `cod_t` int(11) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `data_envio` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `envio`
--

INSERT INTO `envio` (`cod_envio`, `nomenavio`, `frete`, `cod_t`, `cidade`, `pais`, `data_envio`) VALUES
(10250, 'Navio A', 60.50, 1, NULL, NULL, NULL),
(10251, 'Navio B', 30.00, 2, NULL, NULL, NULL),
(10252, 'Navio C', 80.00, 1, NULL, NULL, NULL),
(10253, 'Navio D', 45.00, 3, 'Berlin', 'Germany', '1996-08-10'),
(10254, 'Navio E', 70.00, 4, 'Rio de Janeiro', 'Brazil', '1996-07-05'),
(10255, 'Navio F', 20.00, 5, 'Lyon', 'France', '1996-08-08'),
(10256, 'Navio G', 90.00, 6, 'Resende', 'Brazil', '1996-12-15'),
(10257, 'Navio H', 55.00, 7, 'Bern', 'Switzerland', '1996-11-20');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `envio`
--
ALTER TABLE `envio`
  ADD PRIMARY KEY (`cod_envio`),
  ADD KEY `cod_t` (`cod_t`);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `envio`
--
ALTER TABLE `envio`
  ADD CONSTRAINT `envio_ibfk_1` FOREIGN KEY (`cod_t`) REFERENCES `territorio` (`cod_t`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
