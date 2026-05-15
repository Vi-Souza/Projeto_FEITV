🎬 
O Projeto FEITV é uma aplicação Java desenvolvida para simular uma plataforma de streaming, permitindo que usuários se cadastrem, façam login, visualizem vídeos (filmes e séries), curtam conteúdos e gerenciem seus favoritos.
O sistema foi construído com foco em organização de camadas, boas práticas de programação e integração com banco de dados PostgreSQL.

🧩 Objetivo
O projeto tem como objetivo demonstrar uma arquitetura completa de software em Java, utilizando o padrão MVC (Model–View–Controller) e integração com banco de dados relacional.
Ele serve como base para estudos de:

CRUD com JDBC

Separação de responsabilidades entre camadas

Interface gráfica com Swing

Relacionamentos entre entidades (Usuário, Vídeo, Favoritos)

🏗️ Arquitetura do Sistema
O sistema segue o padrão MVC, dividido em três camadas principais:

Camada	Responsabilidade
Model	Representa as entidades do sistema (Usuário, Vídeo, Filme, Série, Lista de Reprodução).
DAO	Responsável pela comunicação com o banco de dados PostgreSQL.
Controller	Intermedia as chamadas entre a View e o DAO, aplicando regras de negócio.
View	Interface gráfica construída com Swing, permitindo interação do usuário.

🧠 Funcionalidades
Cadastro de Usuário:  
Permite criar novos usuários com nome, email e senha.

Login:  
Autentica o usuário e redireciona para o menu principal.

Listagem de Vídeos:  
Exibe todos os vídeos cadastrados no banco.

Busca por Título:  
Permite localizar vídeos pelo nome.

Curtir/Descurtir:  
Incrementa ou decrementa o número de curtidas de um vídeo.

Favoritar/Remover Favorito:  
Adiciona ou remove vídeos da lista de favoritos do usuário.

Listar Favoritos:  
Mostra todos os vídeos favoritos do usuário logado.

🗄️ Banco de Dados (PostgreSQL)
O sistema utiliza o banco PostgreSQL com três tabelas principais:

sql
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100)
);

CREATE TABLE videos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    descricao TEXT,
    tipo VARCHAR(20),
    curtidas INT DEFAULT 0
);

CREATE TABLE favoritos (
    id_usuario INT REFERENCES usuarios(id),
    id_video INT REFERENCES videos(id),
    PRIMARY KEY (id_usuario, id_video)
);
⚙️ Configuração e Execução
Instale o PostgreSQL e crie o banco feitv.

Configure a classe ConexaoBD.java com suas credenciais:

java
private static final String URL = "jdbc:postgresql://localhost:5432/feitv";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
Compile e execute o projeto:

bash
mvn clean install
java -jar target/ProjetoFEITV.jar
A aplicação abrirá a tela de Login.

🖥️ Interface Gráfica

A interface foi construída com Java Swing, utilizando GridBagLayout para melhor alinhamento dos componentes.
As telas principais são:

LoginView: autenticação e navegação para cadastro.

CadastroView: criação de novos usuários.

MenuPrincipalView: listagem de vídeos, favoritos e ações de curtir/descurtir.

🧰 Tecnologias Utilizadas
Tecnologia	Função
Java 17+	Linguagem principal
Swing	Interface gráfica
PostgreSQL	Banco de dados
JDBC	Conexão com o banco
Maven	Gerenciamento de dependências
MVC Pattern	Organização do código


🚀 Melhorias Futuras
Implementar cadastro de vídeos via interface (admin).

Adicionar filtros por gênero, tipo e curtidas.

Criar sistema de login com hashing de senha.

Adicionar interface responsiva com JavaFX.

Implementar autenticação JWT para versão web.

Criar API REST para integração com front-end.


🏁 Licença
Este projeto é de código aberto sob a licença MIT.
Você pode usar, modificar e distribuir livremente, desde que mantenha os créditos originais.
