-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Mai 19, 2014 as 08:52 
-- Versão do Servidor: 5.1.41
-- Versão do PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `mercado`
--
CREATE DATABASE `mercado` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mercado`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `Nome` varchar(400) NOT NULL,
  `Cidade` varchar(400) NOT NULL,
  `login` varchar(400) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Nome`, `Cidade`, `login`, `senha`) VALUES
('Rafael favalli', 'Canas', 'rafael', 'fael'),
('João', 'Lorena', 'joao', 'joao'),
('adm', 'Lorena', '123', '123'),
('Charles Nascimento', 'Lorena', '1234', '1234'),
('Otavio Henrique', 'Cachoeira Paulista', 'otavio', '1234'),
('Amanda Dorotea', 'Cachoeira Paulista', 'Amanda', 'amanda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `Codproduto` varchar(400) NOT NULL,
  `Produto` varchar(400) NOT NULL,
  `Preco` varchar(400) NOT NULL,
  `img` varchar(400) NOT NULL,
  `Vendidos` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Codproduto`, `Produto`, `Preco`, `img`, `Vendidos`) VALUES
('01', 'Laranja', '0,50', 'laranja.jpg', 20),
('11', 'Coca-cola', '2,50', 'coca.jpg', 9),
('04', 'Limão', '1,00', 'limao.jpg', 7),
('10', 'Chiquinha', '500,00', 'chiquinha.jpg', 2),
('06', 'Batata Ruffles', '3,00', 'ruffos.jpg', 18),
('07', 'Bolo chocolate', '3,50', 'bolo.jpg', 35),
('001', 'Arroz Rarroz', '6,59', 'arroz.jpg', 7),
('04', 'Leite Moça', '5,50', 'leitec.jpg', 66);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE IF NOT EXISTS `vendas` (
  `codproduto` varchar(400) NOT NULL,
  `produto` varchar(400) NOT NULL,
  `preco` varchar(400) NOT NULL,
  `vendedor` varchar(400) NOT NULL,
  `cidade` varchar(400) NOT NULL,
  `nvenda` varchar(400) NOT NULL,
  `total` varchar(400) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`codproduto`, `produto`, `preco`, `vendedor`, `cidade`, `nvenda`, `total`) VALUES
('04', 'Leite Moça', 'R$ 5,50', 'Amanda Dorotea', 'Cachoeira Paulista', '6', '33.0'),
('001', 'Arroz Rarroz', 'R$ 6,59', 'Rafael favalli', 'Canas', '5', '32.95'),
('06', 'Batata Ruffles', 'R$ 3,00', 'Rafael favalli', 'Canas', '15', '45.0'),
('10', 'Chiquinha', 'R$ 500,00', 'Rafael favalli', 'Canas', '2', '1000.0'),
('01', 'Laranja', 'R$ 0,50', 'Rafael favalli', 'Canas', '10', '5.0'),
('11', 'Coca-cola', 'R$ 2,50', 'Rafael favalli', 'Canas', '3', '7.5'),
('04', 'Limão', 'R$ 1,00', 'adm', 'Lorena', '4', '4.0'),
('04', 'Limão', 'R$ 1,00', 'adm', 'Lorena', '3', '3.0'),
('01', 'Laranja', 'R$ 0,50', 'Rafael favalli', 'Canas', '6', '3.0'),
('07', 'Bolo chocolate', 'R$ 3,50', 'Rafael favalli', 'Canas', '30', '105.0'),
('06', 'Batata Ruffles', 'R$ 3,00', 'adm', 'Lorena', '3', '9.0'),
('11', 'Coca-cola', 'R$ 2,50', 'adm', 'Lorena', '6', '15.0'),
('04', 'Leite Moça', 'R$ 5,50', 'adm', 'Lorena', '60', '330.0'),
('01', 'Laranja', 'R$ 0,50', 'adm', 'Lorena', '4', '2.0'),
('001', 'Arroz Rarroz', 'R$ 6,59', 'Amanda Dorotea', 'Cachoeira Paulista', '2', '13.18'),
('07', 'Bolo chocolate', 'R$ 3,50', 'Rafael favalli', 'Canas', '5', '17.5');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
