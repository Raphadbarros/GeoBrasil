
# Desafio Java (Em Desenvolvimento)

## Ambiente de Desenvolvimento Backend
*   Clone este repositorio
*   Siga o tutorial de instalação no site https://spring.io/tools;
*   Import o Projeto Maven 
*   Executar Maven Install

## Ambiente de Desenvolvimento FrontEnd
*   Clone este repositorio
*	Siga o tutorial de instalação no site https://angular.io/
*   Execute os comandos abaixo dentro do diretório do projeto
*   Npm install`
*   O Projeto estara disponivel em `http://localhost:4200`


## Configurações do ambiente Backend
* spring-tool-suite-3.9.8.RELEASE-e4.11.0-win32-x86_64
* JDK 8
* Banco de dados: H2 
* Spring boot / Spring MVC / Spring Data JPA / Hibernate

## Configurações do ambiente FrontEnd
* Visual Studio Code-portable-win64-1.51.1-40
* Angular: 8
* Node.js 14.15

## Configurações do ambiente H2 e Querys
* Banco de dados: H2


## Inserts Base H2 (Banco em memoria)
* Criação das Tabelas Estados e Cidades São automaticas
* Acesar localhost:8080/h2-console

  INSERT INTO ESTADOS(BANDEIRA,NOME_ESTADO)VALUES('RG','Rio Grande do Sul')
  INSERT INTO ESTADOS(BANDEIRA,NOME_ESTADO)VALUES('SC','Santa Catarina')
  INSERT INTO ESTADOS(BANDEIRA,NOME_ESTADO)VALUES('PR','Parana')

  INSERT INTO CIDADES(NOME_CIDADES,ESTADO_ID)VALUES('Passo Fundo',1) 
  INSERT INTO CIDADES(NOME_CIDADES,ESTADO_ID)VALUES('Agudo',2)
  INSERT INTO CIDADES(NOME_CIDADES,ESTADO_ID)VALUES('Alegre',1) 


# Documentação da API


### **Buscar todos os Estados 
####  GET /api/estados** 

```json
	[
	   {
	      "idEstado":1,
	      "nomeEstado":"Rio Grande do Sul",
	      "bandeira":"RG"
	   }
	]



### **Buscar um Estado**
#### GET /api/estados/1  


```json
	[
	   {
	      "idEstado":1,
	      "nomeEstado":"Rio Grande do Sul",
	      "bandeira":"RG"
	   }
	]
```


---
### **Listar Cidades**
#### GET /api/cidades  

```json
       [
	  {
	    "id":1,
	    "nomeCidades":"Passo Fundo",
	    "estados":{
		 "idEstado":1,
		 "nomeEstado":"Rio Grande do Sul",
		 "bandeira":"RG"
		  },
	   "delegatee":null,
	   "unwrappingSerializer":false
	  }
      ]
```
---
### **Inserir Cidade (Em andamento)
####  POST /api/Cidades/   

---
### **Deletar uma Cidade** (Em andamento)
####  DELETE /api/cidades/{nomeCidades}

