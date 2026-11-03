# 🍔 Sistema de Restaurante

**Projeto 1 | Bootcamp Java + IA — ElasTech | SoulCode + PagBank**

## 📖 Sobre o projeto

Sistema de gerenciamento de pedidos de restaurante desenvolvido em **Java**, como atividade prática do Bootcamp Java + IA | ElasTech, proposta pela professora **Flora Belas**.

O projeto foi implementado por **Jennifer Rangel**, aplicando conceitos de Programação Orientada a Objetos (POO), princípios SOLID, coleções, tratamento de exceções, testes unitários e padrões de projeto.

## 🚀 Funcionalidades implementadas

- Cadastro de pedidos com identificação do cliente e numeração automática.
- Cardápio com X-Burger, X-Salada e X-Bacon.
- Inclusão de múltiplos lanches em um pedido.
- Personalização dos lanches com retirada de ingredientes.
- Adição de cheddar e bacon extra.
- Consulta e listagem dos pedidos cadastrados.
- Modificação de pedidos com inclusão e remoção de itens.
- Cancelamento de pedidos com confirmação.
- Cálculo automático dos valores dos pedidos.
- Fechamento do dia com faturamento total.
- Identificação das combinações diferentes vendidas.
- Validação de entradas e tratamento de opções inválidas.

## 🎁 Funcionalidade Bônus

- Geração de arquivo executável `.jar` utilizando Maven.
- Execução do sistema pelo terminal com Java 27.

## 🛠️ Tecnologias e conceitos aplicados

- **Linguagem:** Java 27.
- **Ferramentas:** IntelliJ IDEA, Maven, Git e GitHub.
- **Bibliotecas:** Lombok e JUnit 5.
- **Programação Orientada a Objetos:** classes, objetos, construtores, encapsulamento, abstração, interfaces, polimorfismo e composição.
- **SOLID:** Princípio da Responsabilidade Única (SRP).
- **Padrões de projeto:** Factory (criacional), Decorator e Facade (estruturais).
- **Collections Framework:** ArrayList, HashMap e HashSet.
- **Estruturas de controle:** operadores, condicionais, switch, for, for-each, while e do-while.
- **Entrada e saída de dados:** Scanner, printf e manipulação de String.
- **Tratamento de exceções:** try-catch, IllegalArgumentException e InputMismatchException.
- **Boas práticas:** organização em pacotes, separação de responsabilidades, validação de dados e reutilização de código.

## 🏗️ Organização do projeto

O sistema está organizado em três pacotes principais, com responsabilidades específicas:

- **app:** controla a execução, a interação com o usuário e a comunicação com as regras de negócio.
- **cardapio:** contém as classes responsáveis pelos lanches, ingredientes, adicionais e sua criação.
- **pedido:** gerencia o cadastro, a consulta e as alterações dos pedidos, além dos cálculos dos valores.

## 🧩 Padrões de projeto

- **Factory:** centraliza a criação dos lanches do cardápio, garantindo uma nova instância a cada solicitação.
- **Decorator:** permite adicionar ingredientes extras dinamicamente, sem modificar a classe original.
- **Facade:** simplifica o acesso às operações do restaurante, centralizando a comunicação entre as classes.

## 🧪 Testes unitários

Foram desenvolvidos testes utilizando **JUnit 5** para verificar validações e cálculos de preços dos lanches com adicionais.

Para executar os testes:

```bash
mvn test
```

## ▶️ Como executar o projeto

Para executar o sistema, é necessário ter o **Java 27** instalado.

### 1. Gerar o arquivo executável

Na pasta raiz do projeto, execute:

```bash
mvn clean package
```

O Maven irá compilar o projeto, executar os testes e gerar o arquivo:

```text
target/sistema-restaurante-1.0-SNAPSHOT.jar
```

### 2. Executar o restaurante

No terminal, execute:

```bash
java -jar target/sistema-restaurante-1.0-SNAPSHOT.jar
```

O sistema será iniciado no terminal, apresentando o menu interativo para gerenciamento dos pedidos.

**Observação:** o sistema funciona pelo console e não necessita do IntelliJ IDEA para ser executado.

## 🎥 Vídeo de demonstração

O vídeo apresenta o funcionamento do sistema, a organização dos pacotes, a aplicação de um padrão de projeto e a execução de um teste unitário.

**Link do vídeo:** https://youtu.be/njicSBgZTro

## 👩‍💻 Desenvolvedora

**Jennifer Rangel**

Projeto desenvolvido a partir de uma atividade proposta pela **Prof.ª Flora Belas**, durante o **Bootcamp Java + IA | ElasTech — SoulCode + PagBank**.

**GitHub:** https://github.com/Jenniferrangel5
