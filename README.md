# Aplicativo de Gerenciamento de Ações - BACKEND

Aplicação desenvolvida para receber, processar e fornecer dados para a [aplicação de gerenciamento de uma carteira de ações](https://github.com/gabrielcanto461/carteira-de-acoes) desenvolvido utilizando as ferramentas:  
- SpringBoot;
- Docker;
- Dbeaver;
Como fonte de dados foi utilizada a API [brapi.dev](https://brapi.dev/), e disponibilizada endpoints para salvar e recuperar registros, realizando as manipulações necessárias.

## Instalação
Para instalar a aplicação e utilizar em seu ambiente:

```bash
git clone https://github.com/gabrielcanto461/carteira-de-acoes-backend.git
cd carteira-de-acoes-backend
mvn clean install
```

## Uso

Para rodar a aplicação em desenvolvimento:

```bash
docker compose up
mvn spring-boot:run
```

## Desenvolvimento

Desenvolvido por Gabriel Augusto  
Linkedin: https://www.linkedin.com/in/gabrielcant0/

Projeto desenvolvido para ajudar no gerenciamento de minha carteira e praticar os conceitos de React e front-end.
