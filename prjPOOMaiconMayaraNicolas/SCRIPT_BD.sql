CREATE table TBVENDEDOR(
CPF  				VARCHAR2(11) not null
,NOME    			varchar2(50)
,ENDERECO         	varchar2(50)
,CIDADE      		varchar2(30)
,CEP          		varchar2(8)
,UF        			varchar2(2)
,TELEFONE_DDD 		VARCHAR2(2)
,TELEFONE_NUMERO 	VARCHAR2(10)
,SALARIO_BASE 		NUMBER(10)
,COMISSAO 			NUMBER(10,2)
,constraint pk_CPF primary key (CPF)
);
----------------------------
create table TBPRODUTO(
Codigo_Produto  	VARCHAR2(11) not null
,Descricao    		varchar2(40)
,Qtde_Disponivel	number(3)
,Preco_Unit      	number(3)
,Estoque_Minimo     number(3)
,constraint pk_codprod primary key (Codigo_Produto)
);
----------------------------------
create table TBCLIENTE(
CPF  				VARCHAR2(11) not null
,NOME    			varchar2(50)
,ENDERECO         	varchar2(50)
,CIDADE      		varchar2(30)
,CEP          		varchar2(8)
,UF        			varchar2(2)
,TELEFONE_DDD 		VARCHAR2(2)
,TELEFONE_NUMERO 	VARCHAR2(10)
,LIMITE_CREDITO 	NUMBER(10,2)
,LIMITE_DISPONIVEL	NUMBER(10,2)
,constraint pk_cpfcli primary key (CPF)
);
---------------------------------
CREATE TABLE TBPEDIDO(
NUMERO 			VARCHAR2(5) NOT NULL,
DATA_EMISSAO	VARCHAR2(10), --01/02/2022
DATA_PAGTO 		VARCHAR2(10),
FORMA_PAGTO 	VARCHAR2(5),--- 'T' -> TRUE 'F' -> FALSE
SITUACAO 		VARCHAR2(5),--- 'T' -> TRUE 'F'-> FALSE

CLIENTE_ID 		VARCHAR2(11),
VENDEDOR_ID		VARCHAR2(11),
CONSTRAINT PK_NUMERO PRIMARY KEY (NUMERO),
CONSTRAINT FK_CLIENTE_ID FOREIGN KEY(CLIENTE_ID) REFERENCES TBCLIENTE(CPF),
CONSTRAINT FK_VENDEDOR_ID FOREIGN KEY(VENDEDOR_ID) REFERENCES TBVENDEDOR(CPF)
);
----------------------------
create table TBITEMPEDIDO(
SEQUENCIA 		NUMBER(10),
QTDE_VENDIDA	NUMBER(10,2),

PRODUTO_ID		VARCHAR2(11),
PEDIDO_ID		VARCHAR2(5),
CONSTRAINT FK_ITEMPEDIDO_PROD FOREIGN KEY (PRODUTO_ID) REFERENCES TBPRODUTO(CODIGO_PRODUTO),
CONSTRAINT FK_ITEMPEDIDO_PED FOREIGN KEY (PEDIDO_ID) REFERENCES TBPEDIDO(NUMERO)
);


