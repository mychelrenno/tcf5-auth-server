# TCF5 Auth Server

Um servidor de autenticação robusto e escalável construído com Spring Boot, MongoDB e integração com Eureka Service Discovery.

## 📋 Descrição

O **TCF5 Auth Server** é um microserviço de autenticação desenvolvido para a arquitetura TCF5. Ele gerencia clientes de autenticação, validação de credenciais e integração com o ecosistema de microsserviços através do Eureka Discovery.

## 🛠️ Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 4.0.5** - Framework para construção de aplicações Java
- **Spring Cloud 2025.1.1** - Integração com serviços em nuvem
- **MongoDB 8.2.2** - Banco de dados NoSQL
- **Netflix Eureka** - Service Discovery e Load Balancing
- **Spring Boot Actuator** - Monitoramento e health checks
- **Maven** - Gerenciador de dependências e build

## ⚙️ Requisitos

- Java 21+
- Maven 3.9.10+
- Docker & Docker Compose (para execução containerizada)
- MongoDB 8.2.2+ (se executar sem Docker)

## 📦 Estrutura do Projeto

```
tcf5-auth-server/
├── src/
│   ├── main/
│   │   ├── java/com/devrenno/tcf5/auth/server/
│   │   │   ├── Application.java              # Classe principal da aplicação
│   │   │   ├── controller/
│   │   │   │   └── AuthController.java       # Endpoints de autenticação
│   │   │   ├── entity/
│   │   │   │   └── Client.java               # Modelo de dados Client
│   │   │   ├── service/
│   │   │   │   └── ClientService.java        # Lógica de negócio
│   │   │   └── repository/
│   │   │       └── ClientRepository.java     # Acesso a dados
│   │   └── resources/
│   │       ├── application.yaml              # Configurações principais
│   │       └── application-dev.yml           # Configurações desenvolvimento
│   └── test/
│       └── java/.../ApplicationTests.java   # Testes unitários
├── docker-compose.yml                        # Orquestração de containers
├── Dockerfile                                # Definição da imagem Docker
├── pom.xml                                   # Dependências Maven
└── README.md                                 # Este arquivo
```

## 🚀 Como Executar

### Opção 1: Com Docker Compose (Recomendado)

1. **Clonar o repositório:**
```bash
git clone <repositorio-url>
cd tcf5-auth-server
```

2. **Iniciar os serviços:**
```bash
docker-compose up --build
```

A aplicação estará disponível em `http://localhost:8081`

### Opção 2: Execução Local

1. **Instalar dependências e construir:**
```bash
mvn clean install
```

2. **Configurar MongoDB:**
```bash
# Certifique-se que o MongoDB está rodando na porta 27017
mongosh --authenticationDatabase admin -u admin -p sucesso
```

3. **Executar a aplicação:**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8081`

### Opção 3: Executar JAR compilado

```bash
java -jar target/tcf5-auth-server-0.0.1-SNAPSHOT.jar
```

## 🔌 Endpoints da API

### 1. Buscar Cliente por ID
```http
GET /auth/{id}
```

**Descrição:** Retorna os dados de um cliente específico

**Parâmetros:**
- `id` (path param) - ID do cliente

**Resposta (200 OK):**
```json
{
  "id": "507f1f77bcf86cd799439011",
  "name": "Cliente Exemplo",
  "email": "cliente@example.com"
}
```

### 2. Validar Cliente
```http
GET /auth/validate/{id}
```

**Descrição:** Valida se um cliente existe e está ativo

**Parâmetros:**
- `id` (path param) - ID do cliente

**Resposta (200 OK):**
```json
true
```

## 🔧 Configuração

As configurações da aplicação estão no arquivo `src/main/resources/application.yaml`:

```yaml
server:
  port: 8081

spring:
  application:
    name: tcf5-auth-server
  mongodb:
    host: db              # Host do MongoDB (usar 'localhost' em execução local)
    port: 27017
    database: tcf5-auth-db
    username: admin
    password: sucesso
    authentication-database: admin

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/  # URL do Eureka Server
  instance:
    prefer-ip-address: true
```

### Variáveis de Ambiente

Você pode sobrescrever as configurações usando variáveis de ambiente:

```bash
export SPRING_DATA_MONGODB_HOST=seu-host
export SPRING_DATA_MONGODB_PASSWORD=sua-senha
export EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/
```

## 📊 Monitoramento

A aplicação inclui Spring Boot Actuator para monitoramento:

```http
GET http://localhost:8081/actuator
GET http://localhost:8081/actuator/health
GET http://localhost:8081/actuator/metrics
```

## 🧪 Testes

Executar testes:
```bash
mvn test
```

Executar testes com cobertura:
```bash
mvn test jacoco:report
```

## 🐳 Docker

### Construir imagem
```bash
docker build -t tcf5-auth-server:1.0 .
```

### Executar container
```bash
docker run -p 8081:8081 --name auth-server tcf5-auth-server:1.0
```

## 📝 Variáveis de Ambiente Docker

No `docker-compose.yml`, as seguintes variáveis estão configuradas:

- `MONGO_INITDB_ROOT_USERNAME`: admin
- `MONGO_INITDB_ROOT_PASSWORD`: sucesso
- `MONGO_INITDB_DATABASE`: tcf5-auth-db

## 🔐 Segurança

- Credenciais do MongoDB armazenadas em variáveis de ambiente
- Validação de entrada em endpoints
- Health checks para MongoDB

## 📚 Dependências Principais

| Dependência | Versão | Propósito |
|------------|--------|----------|
| Spring Boot | 4.0.5 | Framework web |
| Spring Data MongoDB | - | ORM para MongoDB |
| Spring Cloud Netflix Eureka | 2025.1.1 | Service Discovery |
| Spring Boot Actuator | - | Monitoramento |

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT.

## 👨‍💻 Desenvolvedor

**DevRenno** - Desenvolvimento e Arquitetura

## 📞 Suporte

Para problemas, dúvidas ou sugestões, abra uma issue no repositório.

---

**Última atualização:** Abril de 2026

