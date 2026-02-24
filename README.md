# 🧠 CRM Agenda Backend — API Spring Boot

Backend REST desenvolvido com **Spring Boot**, focado em autenticação, segurança, arquitetura limpa e padrões utilizados em ambientes reais de produção.

Este projeto demonstra práticas modernas de desenvolvimento backend:

* Autenticação stateless com JWT
* Configuração avançada com Spring Security
* Versionamento de banco com Flyway
* Arquitetura em camadas (Clean Layers)
* Hash seguro de senhas com BCrypt

---

# 🏗️ Visão Geral da Arquitetura

```text
Cliente
   ↓
Controller (Camada HTTP)
   ↓
Service (Regras de Negócio)
   ↓
Repository (Persistência)
   ↓
PostgreSQL
```

## Estrutura de Pastas

```text
src/main/java/com/kaique/crm
│
├── controller      → Endpoints REST
├── service         → Regras de negócio
├── repository      → Acesso ao banco (JPA)
├── entity          → Entidades do banco
├── dto             → Objetos de request/response
└── security        → JWT + Configuração de segurança
```

### Princípios Aplicados

* Single Responsibility Principle (SRP)
* Separation of Concerns
* API Stateless
* Injeção de Dependência (DI)
* Segurança como prioridade

---

# 🔐 Arquitetura de Segurança

A autenticação é totalmente baseada em **JWT (stateless)**.

## Fluxo de Autenticação

1. Usuário envia credenciais → `/auth/login`
2. Spring Security valida o usuário
3. Token JWT é gerado
4. Cliente armazena o token
5. Rotas protegidas exigem:

```http
Authorization: Bearer <TOKEN>
```

## Componentes de Segurança

```text
security/
├── SecurityConfig.java   → Regras e filtros de segurança
├── JwtService.java       → Geração e validação do JWT
├── JwtAuthFilter.java    → Interceptação do token
└── PasswordConfig.java   → Encoder BCrypt
```

### Por que JWT?

* Arquitetura stateless
* Fácil escalabilidade horizontal
* Não depende de sessão no servidor
* Padrão amplamente usado no mercado

---

# 🗄️ Banco de Dados & Migrations

Banco utilizado: **PostgreSQL**

Controle de versão do schema com **Flyway**.

## Arquivos de Migration

```text
src/main/resources/db.migration
├── V1_create_users_table.sql
├── V2_seed_admin_user.sql
```

### Usuário Admin inicial

```text
email: admin@local.com
senha: Admin123!
```

---

# ⚙️ Configuração

Arquivo:

```text
src/main/resources/application.yml
```

Exemplo:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/crm_agenda
    username: postgres
    password: sua_senha

app:
  jwt:
    secret: sua_chave_com_32_bytes_ou_mais
    expiration-minutes: 60
```

---

# ▶️ Executando Localmente

## 1 — Clonar o repositório

```bash
git clone https://github.com/SEU-USUARIO/crm-agenda-backend
```

## 2 — Criar o banco

```sql
CREATE DATABASE crm_agenda;
```

## 3 — Rodar o projeto

Windows:

```bash
mvnw spring-boot:run
```

Linux/Mac:

```bash
./mvnw spring-boot:run
```

---

# 📚 Documentação da API

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🔓 Endpoint de Autenticação

### Request

```http
POST /auth/login
```

```json
{
  "email": "admin@local.com",
  "password": "Admin123!"
}
```

### Response

```json
{
  "token": "jwt-token"
}
```

---

# 🧠 Decisões Técnicas

## Por que Flyway ao invés de update automático do Hibernate?

* Evolução segura do banco
* Histórico de versões
* Controle total em produção
* Melhor colaboração em equipe

## Por que Service Layer?

* Isolamento da lógica de negócio
* Facilidade para testes
* Escalabilidade futura

## Por que BCrypt?

* Padrão de mercado para hash de senhas
* Uso de salt automático
* Resistência a ataques de força bruta

## Por que JWT HS256?

* Assinatura rápida
* Estratégia simples para APIs backend
* Excelente custo-benefício para projetos REST

---

# 🚧 Roadmap (Próximas Evoluções)

* [X] Refresh Token
* [ ] Controle de acesso por Roles (RBAC)
* [x] Testes unitários e integração
* [x] Dockerização
* [x] Pipeline CI/CD
* [X] Observabilidade e logs
* [ ] Deploy em ambiente cloud

---

# 📈 Aprendizados Técnicos

Durante o desenvolvimento foram resolvidos desafios reais de backend:

* JWT WeakKeyException
* Configuração de filtros do Spring Security
* Conflitos de checksum do Flyway
* Debug do fluxo de autenticação
* Tratamento de erros HTTP (401 / 403 / 500)

---

# 👨‍💻 Autor

**Kaique Costa**
Desenvolvedor FullStack

* GitHub → https://github.com/kaiqueblz
* LinkedIn → https://www.linkedin.com/in/kaique-oliveira-495b6b1a0/

---

# ⭐ Objetivo do Projeto

Este projeto faz parte do meu portfólio backend e demonstra minha capacidade de:

* Projetar APIs seguras
* Estruturar sistemas backend escaláveis
* Aplicar padrões modernos de segurança
* Resolver problemas reais de autenticação e arquitetura
