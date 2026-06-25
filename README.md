# 🔐 Usuários API

API REST desenvolvida com Java e Spring Boot para gerenciamento e autenticação de usuários, aplicando conceitos modernos de segurança, arquitetura em camadas e documentação de APIs.

O projeto implementa autenticação baseada em JWT, criptografia de senhas, controle de acesso, validações de negócio e documentação automática utilizando Swagger/OpenAPI.

---

# 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* JWT (JSON Web Token)
* Swagger / OpenAPI
* Maven
* MySQL
* JDBC
* Lombok

---

# ✨ Funcionalidades

* Cadastro de usuários
* Autenticação de usuários
* Geração de Token JWT
* Validação de Token JWT
* Consulta de usuário autenticado
* Criptografia de senha com SHA-256
* Validação de senha forte
* Controle de perfis de usuário
* Documentação automática da API com Swagger

---

# 🔒 Recursos de Segurança

O projeto implementa diversos mecanismos utilizados em aplicações corporativas:

* Autenticação baseada em JWT
* Filtro de autenticação para rotas protegidas
* Criptografia de senha utilizando SHA-256
* Validação de senhas fortes
* Controle de acesso por Token Bearer
* Configuração de CORS
* Tratamento de erros de autenticação

---

# 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas para separar responsabilidades e facilitar a manutenção do código.

```text
src/
├── components
├── configurations
├── controllers
├── dtos
├── entities
├── exceptions
├── factories
├── filters
├── repositories
└── services
```

---

# 📌 Endpoints

| Método | Endpoint                      | Descrição                               |
| ------ | ----------------------------- | --------------------------------------- |
| POST   | `/api/v1/usuario/criar`       | Cadastro de usuário                     |
| POST   | `/api/v1/usuario/autenticar`  | Login                                   |
| GET    | `/api/v1/usuario/obter-dados` | Retorna os dados do usuário autenticado |

---

# 🧠 Conceitos Aplicados

Durante o desenvolvimento deste projeto foram aplicados conceitos amplamente utilizados no mercado:

* Programação Orientada a Objetos
* Arquitetura em Camadas
* Injeção de Dependência
* DTOs
* JWT Authentication
* Filtros HTTP
* Criptografia de Senhas
* Tratamento de Exceções
* Boas práticas para APIs REST
* Separação de responsabilidades

---

# ▶️ Como Executar

## Pré-requisitos

* Java 21+
* Maven
* MySQL

## Clonar o projeto

```bash
git clone https://github.com/beatrizlima-tech/usuarios-api.git
```

## Configurar

Configure as propriedades do banco de dados e da aplicação no arquivo:

```text
application.properties
```

Depois execute:

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 📚 Objetivo

Este projeto foi desenvolvido para consolidar conhecimentos em desenvolvimento Backend com Java e Spring Boot, implementando autenticação baseada em JWT, segurança de APIs, arquitetura em camadas e boas práticas utilizadas em aplicações corporativas.

---

# 👩‍💻 Autora

**Beatriz Lima de Oliveira**

GitHub:
https://github.com/beatrizlima-tech
