-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.11-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para senac
CREATE DATABASE IF NOT EXISTS `senac` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `senac`;

-- Copiando estrutura para tabela senac.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `sobrenome` varchar(50) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `genero` varchar(30) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `rua` varchar(30) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela senac.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `nome`, `sobrenome`, `cpf`, `email`, `genero`, `data_nascimento`, `telefone`, `cep`, `rua`, `bairro`, `complemento`, `cidade`, `numero`, `estado`) VALUES
	(11, 'lezzma', 'Ramalho', '33333333333', 'neto.silva101@outlook.com', 'MASCULINO', '1998-01-05', '11951333960', '04849160', 'rua manuel pla', 'Bairro residencial cocaia', '11951333960', 'São paulo', '12', 'SP'),
	(15, 'José', 'Ramalho', '38879169807', 'neto.silva101@outlook.com', 'MASCULINO', '1998-01-05', '11951333960', '04849160', 'rua manuel pla', 'Bairro residencial cocaia', 'c', 'São paulo', '12', 'PR'),
	(16, 'José', 'Ramalho', '38879169807', 'neto.silva101@outlook.com', 'MASCULINO', '2020-05-19', '11951333960', '04849160', 'rua manuel pla', 'cocaia', 'v', 'São paulo', '12', 'PI');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela senac.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT '0',
  `sobrenome` varchar(50) DEFAULT '0',
  `cpf` varchar(50) DEFAULT '0',
  `email` varchar(50) DEFAULT '0',
  `genero` char(1) DEFAULT '0',
  `data_nascimento` date DEFAULT NULL,
  `tell` float DEFAULT 0,
  `cep` varchar(8) DEFAULT '0',
  `rua` varchar(50) DEFAULT '0',
  `bairro` varchar(50) DEFAULT '0',
  `complemento` char(1) DEFAULT '0',
  `cidade` varchar(50) DEFAULT '0',
  `numero` int(11) DEFAULT 0,
  `estado` varchar(50) DEFAULT '0',
  `departamento` varchar(50) DEFAULT '0',
  `cargo` varchar(50) DEFAULT '0',
  `salario` float DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela senac.funcionario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `nome`, `sobrenome`, `cpf`, `email`, `genero`, `data_nascimento`, `tell`, `cep`, `rua`, `bairro`, `complemento`, `cidade`, `numero`, `estado`) VALUES
	(1, 'teste', 'teste', '0', '0', '0', NULL, 0, '0', '0', '0', '0', '0', 0, '0');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela senac.itens
CREATE TABLE IF NOT EXISTS `itens` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lista_intes` longtext CHARACTER SET utf8mb4 NOT NULL CHECK (json_valid(`lista_intes`)),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela senac.itens: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` (`id`, `lista_intes`) VALUES
	(28, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":23,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"},{"idProduto":2,"codigobarrasprod":"seila","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":23,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(29, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":22,"itensvenda":5,"idloja":0,"categoriaprod":"Jogo"}]'),
	(30, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":17,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"},{"idProduto":2,"codigobarrasprod":"seila","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":21,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(31, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":16,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(32, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":15,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(33, '[{"idProduto":2,"codigobarrasprod":"seila","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":19,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(34, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":13,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(35, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":11,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(36, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":10,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(37, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":9,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(38, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":8,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"}]'),
	(39, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":6,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(40, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":5,"itensvenda":5,"idloja":0,"categoriaprod":"Jogo"}]');
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;

-- Copiando estrutura para tabela senac.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `idprod` int(11) NOT NULL AUTO_INCREMENT,
  `codigobarrasprod` varchar(30) NOT NULL,
  `nomeprod` varchar(80) NOT NULL,
  `valor` float(10,2) DEFAULT NULL,
  `dataCadastroprod` date DEFAULT NULL,
  `descricaoprod` varchar(80) NOT NULL,
  `categoriaprod` varchar(30) NOT NULL,
  `quantidadeprod` int(11) NOT NULL,
  `idloja` int(11) NOT NULL,
  PRIMARY KEY (`idprod`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela senac.produtos: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` (`idprod`, `codigobarrasprod`, `nomeprod`, `valor`, `dataCadastroprod`, `descricaoprod`, `categoriaprod`, `quantidadeprod`, `idloja`) VALUES
	(1, 'teste', 'teste', 123.00, '2020-04-18', 'teste', 'Jogo', 0, 0),
	(2, 'seila', 'teste', 123.00, '2020-04-18', 'teste', 'Jogo', 17, 0),
	(3, '2526', 'teclad top', 1.00, '2020-05-13', 'teclado gamer top', 'Jogo', 1, 0),
	(4, 'meupiru', 'teclad top', 1000.00, '2020-05-13', 'teclado gamer top', 'Brinde', 50, 0);vendas
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;

-- Copiando estrutura para tabela senac.vendas
heroku_77b37ec5c6ca4dc ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela senac.vendas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` (`id`, `id_itens`, `id_cliente`, `id_funcionario`, `filial`, `preco_total`, `create_at`) VALUES
	(22, 28, 15, 1, 'Brasília', 369, '2020-05-12'),
	(23, 29, 15, 1, 'São Paulo', 615, '2020-05-13'),
	(24, 30, 15, 1, 'Brasília', 369, '2020-05-13'),
	(25, 31, 15, 1, 'São Paulo', 123, '2020-05-13'),
	(26, 32, 15, 1, 'Joinville', 246, '2020-05-13'),
	(27, 33, 15, 1, 'São Paulo', 246, '2020-05-13'),
	(28, 34, 15, 1, 'São Paulo', 246, '2020-05-13'),
	(29, 35, 15, 1, 'Campina', 123, '2020-05-13'),
	(30, 36, 15, 1, 'Brasília', 123, '2020-05-13'),
	(31, 37, 15, 1, 'Brasília', 123, '2020-05-13'),
	(32, 38, 15, 1, 'Brasília', 246, '2020-05-13'),
	(33, 39, 15, 1, 'Joinville', 123, '2020-05-13'),
	(34, 40, 11, 1, 'São Paulo', 615, '2020-05-13');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
