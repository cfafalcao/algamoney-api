CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(10),
	complemento VARCHAR(20),
	bairro VARCHAR(40),
	cep VARCHAR(9),
	cidade VARCHAR(40),
	estado VARCHAR(2),
	ativo BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Celso','Rua Sertania','6','casa 3','Rocha Miranda','21540-450','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Eliane','Rua Sertania','6','casa 3','Rocha Miranda','21540-450','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Carolina','Rua Sertania','6','casa 3','Rocha Miranda','21540-450','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Gustavo','Rua Satisfas','6','','Pavuna','21540-000','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Jorge','Rua da Subida','16','','Alemão','21640-110','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Andreia','Rua Serafim','60','casa 1','','22500-450','Rio de Janeiro','RJ',false);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Marly','Rua Henrique de Goes','101','','Coelho Neto','21450-010','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Katharina','Estr. do Catonho','16','casa 4','Jacarepaguá','22040-050','Rio de Janeiro','RJ',true);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Edith','Rua Pescador Josino','222','','Madureira','','Rio de Janeiro','RJ',false);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) 
values ('Walter','Rua Da Praia','116','apt 301','Recreio Dos Bandeirantes','25540-650','Rio de Janeiro','RJ',true);