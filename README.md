# Chess-Arena: Uma Aplicação Web de Xadrez com Arquitetura Orientada a Serviços
♟️ Mais que um jogo, um estudo de caso em arquitetura de software web. Backend robusto com Java, Spring Boot e princípios DDD para uma lógica de xadrez escalável e testável. 👉 Mergulhe na arquitetura e explore o código!

Este projeto não é apenas um jogo de xadrez; é um case prático de desenvolvimento de software, demonstrando a aplicação de princípios de arquitetura limpa, design orientado a objetos e gestão de projetos ágil em um ambiente web.
## 🎯 Visão Geral do Projeto
O objetivo do Chess-Arena é fornecer uma plataforma de xadrez web funcional e escalável. O projeto foi concebido não apenas como um desafio de lógica, mas principalmente como uma vitrine para as melhores práticas de engenharia de software no ecossistema Java/Spring, criando uma base robusta que poderia ser estendida para suportar múltiplos jogadores, rankings e análise de partidas.

<!-- ➡️ Acesse a Demo Ao Vivo Aqui (Se aplicável) -->

## ✨ Funcionalidades Principais
Tabuleiro Interativo: Interface web responsiva para interação com o tabuleiro via cliques do mouse.

* Validação de Movimentos: Lógica de backend completa para validar todos os movimentos de acordo com as regras oficiais do xadrez.

* Controle de Turnos: Gerenciamento rigoroso da vez de cada jogador.

* Condições Especiais: Implementação de lógicas como Roque, promoção de peão e captura en passant.

* Detecção de Xeque e Xeque-mate: Lógica para identificar e anunciar estados de xeque e o fim do jogo.

## 🏛️ Arquitetura e Decisões de Design
A arquitetura foi concebida seguindo os princípios da Clean Architecture, garantindo uma clara Separação de Preocupações (SoC) e um baixo acoplamento entre as camadas. A filosofia central é que a lógica de negócio (as regras do xadrez) não deve ter conhecimento da tecnologia web que a expõe.

Domínio no Coração: O núcleo do sistema é o modelo de domínio (Model), que contém as entidades (Game, Board, Piece) e a lógica intrínseca a elas. Foi adotado um Modelo de Domínio Rico, onde as próprias entidades são responsáveis por proteger suas regras internas (invariantes).

Camada de Serviço Agnóstica: A camada de Service orquestra os casos de uso (ex: realizarMovimento), mas delega a lógica fundamental para as entidades de domínio. Os serviços são stateless e não têm dependências de frameworks web.

API REST como Fronteira: A camada de Controller atua como a fronteira da aplicação, traduzindo requisições HTTP em chamadas para a camada de serviço e formatando as respostas. Ela é a única camada que "sabe" que a aplicação está na web.

Injeção de Dependência: O Spring Boot gerencia o ciclo de vida dos componentes, utilizando a Injeção de Dependência para conectar as camadas de forma desacoplada.

## Diagrama de Classes UML (Modelo de Domínio)
O diagrama a seguir não é apenas um desenho; é a representação visual do nosso Modelo de Domínio. Ele ilustra as relações entre as entidades centrais e foi a base para a construção da lógica de negócio.

<!-- [Cole seu diagrama] -->

## Fluxo do Sistema: Anatomia de uma Jogada
Para ilustrar a interação entre as camadas, o fluxo de uma única jogada do usuário ocorre da seguinte forma:

Frontend (UI): O usuário clica na casa de origem e na de destino. O JavaScript captura esses eventos e envia uma requisição POST /api/game/{gameId}/move com os dados do movimento.

Controller: O @RestController recebe a requisição HTTP. Ele extrai os dados e chama o método apropriado no GameService, passando o ID do jogo e o movimento desejado.

Service: O GameService carrega a instância do jogo do repositório. Em seguida, ele delega a ação, chamando game.performMove(move).

Model: O objeto Game e suas entidades associadas (Board, Piece) executam a lógica de validação. Se o movimento for ilegal, uma BusinessException é lançada. Se for válido, o estado do tabuleiro é atualizado.

Resposta: A exceção (se houver) é capturada por um GlobalExceptionHandler e convertida em uma resposta HTTP 400. Se o movimento for bem-sucedido, o Service retorna o novo estado do jogo, que o Controller serializa como JSON e envia de volta ao frontend com um status HTTP 200.

Frontend (UI): O JavaScript recebe a resposta e atualiza a interface do tabuleiro para refletir o novo estado do jogo.

## 🛠️ Tech Stack
Backend: Java 17, Spring Boot 3.x, Spring Web, Lombok

Build & Dependências: Apache Maven

Frontend: HTML5, CSS3, JavaScript (Vanilla)

Testes: JUnit 5, Mockito (planejado)

## 🚀 Gestão do Projeto: Sprints e Kanban
A gestão do projeto foi conduzida utilizando um quadro Kanban para visualizar o fluxo de trabalho e dividir o desenvolvimento em Sprints lógicos. Esta abordagem ágil permitiu a entrega incremental de valor e a adaptação a novos desafios de forma organizada.

Exemplo de Sprints:

* Sprint 1: Fundação do Backend & Regras de Movimentação. Foco em configurar o projeto Spring, modelar as entidades principais e implementar a lógica de movimento para Peão, Torre e Cavalo.

* Sprint 2: Movimentos Especiais & Lógica do Jogo. Implementação de Bispo, Rainha e Rei, além das regras de xeque, roque e promoção de peão.

* Sprint 3: Interface Web & API. Desenvolvimento do frontend básico em HTML/JS e criação dos endpoints REST no backend para conectar as duas partes.

* Sprint 4: Finalização & Refatoração. Implementação da detecção de xeque-mate e polimento da UI e do código.

<!-- [Cole seu sprint kanban] -->

## ⚙️ Como Executar o Projeto Localmente
Pré-requisitos:

Java JDK 17 ou superior

Apache Maven 3.8+

# 1. Clone o repositório
git clone [https://github.com/seu-usuario/chess-arena.git](https://github.com/Gs2ntana/Chess-Arena.git)

# 2. Navegue até o diretório do projeto
cd chess-arena

# 3. Execute o projeto com o Maven
# O backend iniciará na porta 8080 por padrão
./mvnw spring-boot:run

Após a inicialização, acesse http://localhost:8080 no seu navegador para interagir com a aplicação.

## 📈 Melhorias Futuras (Roadmap)
Este projeto serve como uma base sólida. As próximas evoluções planejadas incluem:

WebSockets: Substituir o polling HTTP por WebSockets para atualizações do tabuleiro em tempo real.

Persistência de Dados: Integrar um banco de dados (ex: PostgreSQL) para salvar e continuar jogos.

Autenticação de Usuários: Adicionar Spring Security para permitir que usuários criem contas e tenham seu histórico de partidas.

Implementação de IA: Desenvolver um "oponente" de IA utilizando algoritmos como o Minimax.

Testes Unitários e de Integração: Aumentar a cobertura de testes para garantir a robustez e facilitar a manutenção.

Desenvolvido com dedicação por Gustavo Santana.

<!--[Link para seu LinkedIn] | [Link para seu GitHub] -->
