# Spring Boot Product API 🛍️

## Descrição
Este projeto é uma API RESTful construída com **Spring Boot** para gerenciar produtos, com operações CRUD (Criar, Ler, Atualizar, Excluir). A API está configurada para usar **Spring Data JPA** com **PostgreSQL** como banco de dados. Além disso, foi implementado um sistema de autenticação e autorização utilizando **Spring Security** e **JWT**. A documentação da API é gerada automaticamente usando **Swagger** através do **Springdoc** OpenAPI.

## Tecnologias Usadas
- **Spring Boot 3.x**: Framework principal para a criação de aplicações Java.
- **Spring Data JPA**: Para interagir com o banco de dados relacional (PostgreSQL).
- **Spring Boot Starter Web**: Para construir APIs RESTful.
- **Spring Boot Starter Validation**: Para validações de entrada, como garantir que campos obrigatórios estejam presentes.
- **Spring Boot Starter Hateoas**: Para adicionar links HATEOAS nas respostas da API.  
- **Spring Security**: Para autenticação e autorização dos usuários.
- **JWT (JSON Web Token)**: Para geração e validação de tokens de autenticação.
- **Springdoc OpenAPI**: Para gerar e expor a documentação da API via Swagger.
- **PostgreSQL**: Banco de dados relacional para armazenamento dos produtos.

## Pré-requisitos
- **Java 17** ou superior.
- **Maven** para gerenciamento de dependências e construção do projeto.

## Como Rodar

### 1. Clonar o Repositório

Clone o repositório para sua máquina local:

```bash
git clone https://github.com/Riltter/spring-product-api.git
cd springboot
```

### 2. Configurar Banco de Dados

Para rodar a aplicação, é necessário configurar um banco de dados **PostgreSQL**. Caso ainda não tenha o PostgreSQL instalado, você pode seguir as instruções [aqui](https://www.postgresql.org/download/).

Estrutura da tabela:
```
CREATE TABLE IF NOT EXISTS public.tb_products
(
    id_product uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    value numeric(38,2),
    CONSTRAINT tb_products_pkey PRIMARY KEY (id_product)
)
```

No arquivo `application.properties` ou `application.yml`, configure a URL do banco de dados, nome de usuário e senha:


```
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

### 3. Rodar a Aplicação

Execute o projeto com Maven:

`mvn spring-boot:run`

A API estará disponível em `http://localhost:8080`.

### 4. Acessar a Documentação da API

Com a aplicação em execução, você pode acessar a documentação da API via Swagger em:

`http://localhost:8080/swagger-ui/index.html`

### 5. Testar a API

A API expõe os seguintes endpoints:

- **POST** `/products`: Cria um novo produto.
- **GET** `/products`: Lista todos os produtos.
- **GET** `/products/{id}`: Retorna detalhes de um produto.
- **PUT** `/products/{id}`: Atualiza um produto existente.
- **DELETE** `/products/{id}`: Deleta um produto.

## Próximos Passos

Este projeto é apenas o começo da minha jornada no mundo do **Spring Boot** e **desenvolvimento de APIs RESTful**. Embora ele já forneça as funcionalidades principais de um CRUD para produtos, há muitas melhorias e novas funcionalidades que pretendo implementar para tornar a API ainda mais robusta e eficiente.

Nos próximos meses, planejo adicionar:
- **Autenticação e Autorização** com Spring Security.
- **Testes automatizados mais avançados**.
- **Melhoria na estrutura do banco de dados**, incluindo o armazenamento de informações adicionais dos produtos, como data de criação, última atualização, e outras propriedades relevantes. Também pretendo introduzir novas tabelas relacionadas ao contexto dos produtos.
- **Melhorias no desempenho** e na escalabilidade da API.

Este projeto é parte do meu esforço contínuo para aprender mais sobre **Spring**, **arquitetura de software** e **desenvolvimento back-end**. Estou animado para ver o que mais posso aprender e construir!

**Obrigado por conferir o projeto e por qualquer contribuição futura!**
