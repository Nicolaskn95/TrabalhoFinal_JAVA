CREATE table TBVENDEDOR(
CPF                 VARCHAR2(11) not null
,NOME               varchar2(50)
,ENDERECO           varchar2(50)
,CIDADE             varchar2(30) 
,CEP                varchar2(2)
,UF                 varchar2(2)
,TELEFONE_DDD       VARCHAR2(2)
,TELEFONE_NUMERO    VARCHAR2(10)
,SALARIO_BASE       NUMBER(10)
,COMISSAO           NUMBER(10,2)
,constraint pk_CPF primary key (CPF));

----------------------------
create table TBPRODUTO(
CODIGO_PRODUTO      VARCHAR2(11) not null
,DESCRICAO          varchar2(40)
,QTDE_DISPONIVEL    number(3)
,PRECO_UNIT         number(3)
,ESTOQUE_MINIMO     number(3)
,constraint pk_codprod primary key (Codigo_Produto));

----------------------------------
create table TBCLIENTE(
CPF                 VARCHAR2(11) not null
,NOME               varchar2(50)
,ENDERECO           varchar2(50)
,CIDADE             varchar2(30)
,CEP                varchar2(2)
,UF                 varchar2(2)
,TELEFONE_DDD       VARCHAR2(2)
,TELEFONE_NUMERO    VARCHAR2(10)
,LIMITE_CREDITO     NUMBER(10,2)
,LIMITE_DISPONIVEL  NUMBER(10,2)
,constraint pk_codprod primary key (Codigo_Produto));
