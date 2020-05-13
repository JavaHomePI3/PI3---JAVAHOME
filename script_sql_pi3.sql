-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.11-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.3.0.5771
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela senac.itens
CREATE TABLE IF NOT EXISTS `itens` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lista_intes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'Não tem itens',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela senac.vendas
CREATE TABLE IF NOT EXISTS `vendas` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `id_itens` int(255),
  `id_cliente` int(255) DEFAULT NULL,
  `id_funcionario` int(255) DEFAULT NULL,
  `preco_total` double DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_itens` (`id_itens`),
  KEY `FK_func` (`id_funcionario`),
  KEY `FK_cliente` (`id_cliente`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_func` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_itens` FOREIGN KEY (`id_itens`) REFERENCES `itens` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
