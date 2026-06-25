# 🔐 API Usuários

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-green?style=for-the-badge\&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge\&logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-Autenticação-black?style=for-the-badge)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge\&logo=swagger)
![License](https://img.shields.io/badge/license-MIT-lightgrey?style=for-the-badge)

---

# 📌 Sobre o projeto

A **API Usuários** é uma aplicação backend desenvolvida com **Java** e **Spring Boot** para cadastro e autenticação de usuários.

O projeto implementa cadastro de usuários, autenticação utilizando **JWT**, criptografia de senhas com **SHA-256**, validações de negócio e documentação automática com **Swagger/OpenAPI**, seguindo uma arquitetura organizada em camadas.

---

# 🚀 Funcionalidades

* Cadastro de usuários
* Autenticação de usuários
* Geração de token JWT
* Criptografia de senha com SHA-256
* Validação de senha forte
* Controle de perfis de usuário
* Documentação da API com Swagger/OpenAPI
* Configuração de CORS para integração com aplicações frontend

---

# 🔒 Recursos de Segurança

* Geração de Token JWT durante a autenticação
* Criptografia de senhas utilizando SHA-256
* Validação de senha forte através de Expressão Regular (Regex)
* Perfis de usuário (Usuário Comum e Administrador)
* Configuração de CORS

> **Observação:** Nesta versão do projeto o token JWT é gerado durante o login, porém ainda não há filtro de autenticação para proteger os endpoints da aplicação.

---

# 🧱 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* PostgreSQL
* JWT (JJWT)
* Swagger / OpenAPI
* Lombok
* Maven

---

# 🏗️ Estrutura do Projeto

```text
src/main/java/br/com/cotiinformatica/api_usuarios/

├── configurations
├── controllers
├── dtos
├── entities
├── enums
├── repositories
└── services
```

---

# 🔗 Endpoints

| Método | Endpoint                     | Descrição                     |
| ------ | ---------------------------- | ----------------------------- |
| POST   | `/api/v1/usuario/criar`      | Cadastro de usuário           |
| POST   | `/api/v1/usuario/autenticar` | Autenticação e geração do JWT |

---

# ⚙️ Como Executar

## 1. Clone o repositório

```bash
git clone https://github.com/beatrizlima-tech/api-usuarios.git
```

## 2. Configure o banco de dados

Crie o banco PostgreSQL e configure as credenciais no arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=postgres
spring.datasource.password=senha
```

Também configure a chave JWT:

```properties
jwt.secret=sua_chave_secreta
```

---

## 3. Execute a aplicação

```bash
mvn spring-boot:run
```

---

## 4. Acesse a documentação

```text
http://localhost:8080/swagger-ui.html
```

---

# 📊 Arquitetura

```text
Cliente (Frontend)
        │
        ▼
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
PostgreSQL
```

---

# 📚 Conceitos Aplicados

* Programação Orientada a Objetos
* Arquitetura em Camadas
* API REST
* DTO Pattern
* Spring Data JPA
* Injeção de Dependência
* JWT
* SHA-256
* Regex para validação
* PostgreSQL
* Swagger/OpenAPI

---

# 📌 Melhorias Futuras

* Implementar filtro JWT para proteger rotas
* Controle de acesso por perfil
* Refresh Token
* Bean Validation
* Tratamento global de exceções
* Testes automatizados
* Dockerização da aplicação

---

# 👩‍💻 Autora

Desenvolvido por **Beatriz Lima**

🔗 GitHub
https://github.com/beatrizlima-tech

💼 LinkedIn
https://www.linkedin.com/in/beatrizlima-tech
