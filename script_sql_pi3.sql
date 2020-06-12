-- --------------------------------------------------------
-- Servidor:                     us-cdbr-east-05.cleardb.net
-- Versão do servidor:           5.5.62-log - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para heroku_77b37ec5c6ca4dc
CREATE DATABASE IF NOT EXISTS `heroku_77b37ec5c6ca4dc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `heroku_77b37ec5c6ca4dc`;

-- Copiando estrutura para tabela heroku_77b37ec5c6ca4dc.cliente
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

-- Copiando dados para a tabela heroku_77b37ec5c6ca4dc.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `nome`, `sobrenome`, `cpf`, `email`, `genero`, `data_nascimento`, `telefone`, `cep`, `rua`, `bairro`, `complemento`, `cidade`, `numero`, `estado`) VALUES
	(11, 'lezzma', 'Ramalho', '33333333333', 'neto.silva101@outlook.com', 'MASCULINO', '1998-01-05', '11951333960', '04849160', 'rua manuel pla', 'Bairro residencial cocaia', '11951333960', 'São paulo', '12', 'SP'),
	(15, 'José', 'Ramalho', '38879169807', 'neto.silva101@outlook.com', 'MASCULINO', '1998-01-05', '11951333960', '04849160', 'rua manuel pla', 'Bairro residencial cocaia', 'c', 'São paulo', '12', 'PR');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela heroku_77b37ec5c6ca4dc.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT '0',
  `sobrenome` varchar(50) DEFAULT '0',
  `cpf` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `genero` varchar(50) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `tell` float DEFAULT '0',
  `cep` varchar(8) DEFAULT '0',
  `rua` varchar(50) DEFAULT '0',
  `bairro` varchar(50) DEFAULT '0',
  `complemento` varchar(10) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT '0',
  `numero` int(11) DEFAULT '0',
  `estado` varchar(50) DEFAULT '0',
  `senha` varchar(250) NOT NULL,
  `departamento` varchar(50) NOT NULL DEFAULT 'Não definido',
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=3391 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela heroku_77b37ec5c6ca4dc.funcionario: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `nome`, `sobrenome`, `cpf`, `email`, `genero`, `data_nascimento`, `tell`, `cep`, `rua`, `bairro`, `complemento`, `cidade`, `numero`, `estado`, `senha`, `departamento`, `salario`) VALUES
	(1, 'ADM', 'NETO', '33333333333', 'admin@hotmail.com', 'MASCULINO', '2020-06-06', 11951300000, '04849160', 'rua', 'worggwart', 'quartos', 'São paulo', 12, 'SP', 'ba3b99ab58669e2f15083f4528f42c9e', 'TI', 1200),
	(2, 'Venda', 'Venda', '55555555555', 'venda@hotmail.com', 'MASCULINO', '2020-06-09', 11951300000, '04849160', 'beco de agonal', 'worggwart', 'quartos', 'São paulo', 93, 'SP', 'ba3b99ab58669e2f15083f4528f42c9e', 'VENDAS', 5000),
	(11, 'Professor', 'Ramalho', '12312312312', 'proff@hotmail.com', 'MASCULINO', '2020-06-09', 11951300000, '04849160', 'beco de agonal', 'worggwart', 'c', 'São paulo', 12, 'PI', 'eb4d5530306fc1aef0be70116382718c', 'TI', 12000),
	(3341, 'T.I', 'Ramalho', '31331331330', 'ti@hotmail.com', 'MASCULINO', '2020-06-10', 11951300000, '04849160', 'beco de agonal', 'worggwart', 'quartos', 'São paulo', 1, 'SP', 'ba3b99ab58669e2f15083f4528f42c9e', 'TI', 10000),
	(3371, 'Adiministrador', 'teste', '99999999999', 'administrador@hotmail.com', 'MASCULINO', '2020-06-08', 11951300000, '04849160', 'beco de agonal', 'worggwart', 'c', 'São paulo', 12, 'PB', 'ba3b99ab58669e2f15083f4528f42c9e', 'ADM', 1500),
	(3381, 'Backoffice', 'teste', '88888888888', 'back@hotmail.com', 'FEMININO', '2020-06-10', 11951300000, '04849160', 'manuel', 'worggwart', 'c', 'São paulo', 23, 'SE', 'eb4d5530306fc1aef0be70116382718c', 'BACKOFFICE', 6000);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela heroku_77b37ec5c6ca4dc.itens
CREATE TABLE IF NOT EXISTS `itens` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lista_intes` longtext CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela heroku_77b37ec5c6ca4dc.itens: ~16 rows (aproximadamente)
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
	(40, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"abr 17, 2020","descricaoprod":"teste","qtdestoque":5,"itensvenda":5,"idloja":0,"categoriaprod":"Jogo"}]'),
	(41, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"Apr 18, 2020","descricaoprod":"teste","qtdestoque":1000,"itensvenda":2,"idloja":0,"categoriaprod":"Jogo"},{"idProduto":2,"codigobarrasprod":"seila","valorprod":123.0,"nomeprod":"teste","dtCadastro":"Apr 18, 2020","descricaoprod":"teste","qtdestoque":100,"itensvenda":3,"idloja":0,"categoriaprod":"Jogo"}]'),
	(51, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"Apr 18, 2020","descricaoprod":"teste","qtdestoque":998,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"}]'),
	(61, '[{"idProduto":1,"codigobarrasprod":"teste","valorprod":123.0,"nomeprod":"teste","dtCadastro":"Apr 18, 2020","descricaoprod":"teste","qtdestoque":997,"itensvenda":1,"idloja":0,"categoriaprod":"Jogo"},{"idProduto":2,"codigobarrasprod":"seila","valorprod":123.0,"nomeprod":"teste","dtCadastro":"Apr 18, 2020","descricaoprod":"teste","qtdestoque":97,"itensvenda":20,"idloja":0,"categoriaprod":"Jogo"}]');
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;

-- Copiando estrutura para tabela heroku_77b37ec5c6ca4dc.produtos
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela heroku_77b37ec5c6ca4dc.produtos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` (`idprod`, `codigobarrasprod`, `nomeprod`, `valor`, `dataCadastroprod`, `descricaoprod`, `categoriaprod`, `quantidadeprod`, `idloja`) VALUES
	(1, 'teste', 'teste', 123.00, '2020-04-18', 'teste', 'Jogo', 996, 0),
	(2, 'seila', 'teste', 123.00, '2020-04-18', 'teste', 'Jogo', 77, 0),
	(3, '2526', 'teclad top', 1.00, '2020-05-13', 'teclado gamer top', 'Jogo', 100, 0),
	(11, '1234', 'teste', 10.00, '2020-06-09', 'teste 1234', 'Outros', 22, 0);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;

-- Copiando estrutura para tabela heroku_77b37ec5c6ca4dc.vendas
CREATE TABLE IF NOT EXISTS `vendas` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `id_itens` int(255) DEFAULT NULL,
  `id_cliente` int(255) DEFAULT NULL,
  `id_funcionario` int(255) DEFAULT NULL,
  `filial` varchar(50) DEFAULT NULL,
  `preco_total` double DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_itens` (`id_itens`),
  KEY `FK_func` (`id_funcionario`),
  KEY `FK_cliente` (`id_cliente`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_func` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_itens` FOREIGN KEY (`id_itens`) REFERENCES `itens` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela heroku_77b37ec5c6ca4dc.vendas: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` (`id`, `id_itens`, `id_cliente`, `id_funcionario`, `filial`, `preco_total`, `create_at`) VALUES
	(22, 28, 15, 1, 'Brasília', 369, '2020-05-12'),
	(23, 29, 15, 1, 'São Paulo', 615, '2020-05-13'),
	(24, 30, 15, 1, 'Brasília', 369, '2020-05-13'),
	(25, 31, 15, 1, 'São Paulo', 123, '2020-05-13'),
	(41, 41, 15, 2, 'São Paulo', 615, '2020-06-11'),
	(51, 51, 11, 2, 'São Paulo', 123, '2020-06-11'),
	(61, 61, 15, 2, 'São Paulo', 2583, '2020-06-12');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
