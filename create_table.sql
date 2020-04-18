CREATE TABLE cliente (
   id INT not null primary KEY,
   nome VARCHAR(255),
   email VARCHAR(255)
);

-- Parte Vitória de cadastro de jogos e produtos

CREATE TABLE jogos(
  id INT NOT NULL AUTO_INCREMENT,
  codigobarras Varchar (30) NOT NULL,
  nome Varchar (30) NOT NULL,
  valor FLOAT (10,2),
  dataCadastro DATE,
  descricao Varchar (60) NOT NULL,
  categoria Varchar (30) NOT NULL,
  quantidade INT NOT NULL,
  idloja INT NOT NULL,
  PRIMARY KEY (Id));
  
  CREATE TABLE produtos(
  idprod INT NOT NULL AUTO_INCREMENT,
  codigobarrasprod Varchar (30) NOT NULL,
  nomeprod Varchar (80) NOT NULL,
  valor FLOAT (10,2),
  dataCadastroprod DATE,
  descricaoprod Varchar (80) NOT NULL,
  categoriaprod Varchar (30) NOT NULL,
  quantidadeprod INT NOT NULL,
  idloja INT NOT NULL,
  PRIMARY KEY (Idprod));
               
-- Parte Vitória, inserir alguns produtos para testes.
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('1','Minecraft',104.9,now(),'Jogo Eletrônico de sobrevivência','Jogos',21,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('2','Call of Duty',137.9,now(),'Jogo de tiro em primeira pessoa','Jogos',43,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('3','Resident Evil 3',199.9,now(),'Jogo eletrônico de survival horror','Jogos',97,1);
