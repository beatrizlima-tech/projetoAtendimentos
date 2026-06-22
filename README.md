# 🤖 Assistente Virtual com OpenAI e PostgreSQL

Projeto desenvolvido em Java que integra a API da OpenAI para criação de um atendente virtual especializado em suporte de TI.

A aplicação recebe perguntas dos usuários, envia a solicitação para a OpenAI, exibe a resposta gerada pela inteligência artificial e registra todo o histórico de atendimento em um banco de dados PostgreSQL.

---

## 🚀 Tecnologias Utilizadas

* Java
* OpenAI API
* PostgreSQL
* JDBC
* OkHttp
* Jackson Databind
* SQL

---

## 📋 Funcionalidades

### Atendimento Inteligente

O usuário informa:

* Nome
* Pergunta

A aplicação envia a solicitação para a OpenAI e recebe uma resposta gerada por inteligência artificial.

### Especialização em Suporte de TI

O assistente foi configurado para responder exclusivamente dúvidas relacionadas a:

* Hardware
* Software
* Redes
* Sistemas Operacionais
* Suporte Técnico

Perguntas fora desse contexto são recusadas pelo modelo.

### Histórico de Atendimentos

Cada interação é armazenada no banco de dados contendo:

* Usuário
* Pergunta
* Resposta
* Data e hora do atendimento

---

## 🏗️ Arquitetura do Projeto

```text
src
│
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

## 🔄 Fluxo da Aplicação

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

## 🗄️ Banco de Dados

### Criação da Tabela

```sql
CREATE TABLE atendimentos(
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    pergunta VARCHAR(500) NOT NULL,
    resposta VARCHAR(2000) NOT NULL,
    datahora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Banco Utilizado

```text
PostgreSQL
```

---

## 🔌 Integração com OpenAI

A comunicação com a OpenAI é realizada através de requisições HTTP utilizando:

* OkHttp Client
* API Responses da OpenAI
* Processamento JSON com Jackson

O sistema envia a pergunta do usuário juntamente com um prompt de sistema responsável por definir o comportamento do atendente virtual.

---

## 📚 Conceitos Aplicados

Durante o desenvolvimento foram praticados:

* Integração com APIs REST
* Consumo da API da OpenAI
* JDBC
* PostgreSQL
* Programação Orientada a Objetos
* Manipulação de JSON
* Persistência de Dados
* Arquitetura em Camadas
* Tratamento de Exceções

---

## 🎯 Objetivo

Desenvolver uma aplicação backend capaz de integrar inteligência artificial generativa a um sistema Java tradicional, registrando todas as interações realizadas pelos usuários.

---

## 👩‍💻 Desenvolvedora

Beatriz Lima

GitHub:
https://github.com/beatrizlima-tech
