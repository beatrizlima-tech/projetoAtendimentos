# 🤖 Projeto Atendimentos

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge\&logo=openjdk)
![OpenAI](https://img.shields.io/badge/OpenAI-API-412991?style=for-the-badge\&logo=openai)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge\&logo=postgresql)
![JDBC](https://img.shields.io/badge/JDBC-Database-orange?style=for-the-badge)
![Build](https://img.shields.io/badge/build-passing-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/license-MIT-lightgrey?style=for-the-badge)

---

# 📌 Sobre o projeto

O **Projeto Atendimentos** é uma aplicação desenvolvida em **Java** que integra a API da OpenAI para oferecer um assistente virtual especializado em suporte técnico de TI.

A aplicação recebe perguntas dos usuários, envia as solicitações para a API da OpenAI, processa as respostas utilizando inteligência artificial e registra automaticamente todo o histórico de atendimentos em um banco de dados PostgreSQL.

O projeto foi desenvolvido com foco em integração com APIs externas, persistência de dados, arquitetura em camadas e aplicação de boas práticas no desenvolvimento backend.

---

# 🚀 Funcionalidades

* Atendimento inteligente utilizando a API da OpenAI
* Especialização em suporte técnico de TI
* Registro automático do histórico de atendimentos
* Persistência dos dados em PostgreSQL
* Integração com APIs REST
* Processamento de respostas em JSON

---

# 🧱 Tecnologias utilizadas

* Java
* OpenAI API
* PostgreSQL
* JDBC
* OkHttp
* Jackson Databind
* SQL
* Maven

---

# 🏗️ Estrutura do projeto

```text
src/

├── controllers
│   └── AtendimentoController
│
├── entities
│   └── Atendimento
│
├── services
│   └── OpenAIService
│
├── repositories
│   └── AtendimentoRepository
│
└── factories
    └── ConnectionFactory
```

---

# 🔄 Fluxo da aplicação

```text
Usuário
    │
    ▼
AtendimentoController
    │
    ▼
OpenAIService
    │
    ▼
API OpenAI
    │
    ▼
Resposta da IA
    │
    ▼
AtendimentoRepository
    │
    ▼
PostgreSQL
```

---

# ⚙️ Como executar o projeto

## 1. Clone o repositório

```bash
git clone https://github.com/beatrizlima-tech/projetoAtendimentos.git
```

## 2. Crie o banco de dados

Execute o script SQL disponível no projeto para criar a tabela **atendimentos**.

## 3. Configure a conexão com o banco

Caso necessário, ajuste os dados da classe:

```text
ConnectionFactory.java
```

com as credenciais do seu PostgreSQL.

## 4. Configure sua chave da OpenAI

Informe sua chave de API no local configurado pelo projeto antes da execução.

## 5. Execute a aplicação

Abra o projeto em uma IDE Java (IntelliJ IDEA ou Eclipse) e execute a classe principal.

---

# 🗄️ Banco de dados

```sql
CREATE TABLE atendimentos(
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    pergunta VARCHAR(500) NOT NULL,
    resposta VARCHAR(2000) NOT NULL,
    datahora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Banco utilizado:

```text
PostgreSQL
```

---

# 🔗 Integração com OpenAI

A comunicação com a OpenAI é realizada através de requisições HTTP utilizando:

* OkHttp Client
* OpenAI API
* Jackson Databind para serialização e desserialização de JSON

O sistema envia um prompt responsável por definir o comportamento do assistente virtual, restringindo as respostas ao contexto de suporte técnico em TI.

---

# 📚 Conceitos aplicados

* Consumo de APIs REST
* Integração com Inteligência Artificial
* Programação Orientada a Objetos
* JDBC
* PostgreSQL
* Manipulação de JSON
* Persistência de dados
* Arquitetura em Camadas
* Tratamento de exceções

---

# 📌 Melhorias futuras

* Implementar autenticação de usuários
* Armazenar histórico por sessão
* Desenvolver interface web em Angular
* Migrar para Spring Boot
* Dockerizar a aplicação
* Criar testes automatizados

---

# 👩‍💻 Autora

Desenvolvido por **Beatriz Lima**

🔗 GitHub
https://github.com/beatrizlima-tech

💼 LinkedIn
https://www.linkedin.com/in/beatrizlima-tech
