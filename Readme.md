# Sistema de Gestão de Conteúdo (CMS) - Disciplina de POOA

Este repositório contém o código desenvolvido para a disciplina de Programação Orientada a Objetos Avançada (POOA). O projeto consiste na criação de um Sistema de Gestão de Conteúdo (CMS) em Java, que será evoluído ao longo do curso para aplicar conceitos avançados de programação orientada a objetos.

## Estrutura de Versões

O projeto está organizado em diferentes versões para refletir as fases de desenvolvimento 
e aplicação dos conceitos aprendidos:

### Versão 1.0.0 - CMS Estruturado no Terminal

- **Descrição:** Implementação inicial do CMS com estrutura simples e procedural.
- **Funcionalidades:**
  - Autenticação básica de usuário.
  - Criação, listagem, atualização e exclusão de conteúdos.
  - Interface de usuário via terminal.
- **Uso:** Para executar, compile o código e execute o arquivo `Main.java`.

### Versão 1.0.1 - CMS Ajustado para Maven

- **Descrição:** Ajuste do código para uso do Maven como ferramenta de build.
- **Funcionalidades Adicionais:**
  - Estruturação do projeto como um projeto Maven.
  - Adição de `pom.xml` para gerenciamento de dependências e build.
- **Uso:** Execute `mvn clean install` para compilar e `mvn exec:java` para rodar a aplicação.

### Versão 2.0.1 - Aplicando o Princípio S do SOLID (Responsabilidade Única)

- **Descrição:** Refatoração do CMS para aplicar o princípio da responsabilidade única (Single Responsibility Principle - SRP).
- **Modificações:**
  - Separação das responsabilidades em classes distintas.
  - A classe `Main` apenas controla o fluxo da aplicação.
  - A gestão de usuários, conteúdos e autenticação é delegada a classes específicas.

### Versão 2.0.2 - Aplicando o Princípio O do SOLID (Aberto/Fechado)

- **Descrição:** Refatoração do CMS para aplicar o princípio Aberto/Fechado (Open/Closed Principle - OCP).
- **Modificações:**
  - O código foi modificado para permitir a extensão de funcionalidades sem necessidade de modificação do código existente.
  - Introdução de interfaces e abstrações.

### Versão 2.0.3 - Aplicando o Princípio L do SOLID (Substituição de Liskov)

- **Descrição:** Refatoração do CMS para aplicar o princípio da Substituição de Liskov (Liskov Substitution Principle - LSP).
- **Modificações:**
  - A refatoração garante que as subclasses possam substituir suas classes base sem afetar a corretude do programa.
  - Introdução de uma hierarquia de classes que respeita o LSP.

### Versão 2.0.4 - Aplicando o Princípio I do SOLID (Segregação de Interfaces)

- **Descrição:** Refatoração do CMS para aplicar o princípio da Segregação de Interfaces (Interface Segregation Principle - ISP).
- **Modificações:**
  - As interfaces foram segregadas para garantir que as classes dependam apenas dos métodos que utilizam.
  - Introdução de interfaces mais específicas.

### Versão 2.0.5 - Aplicando o Princípio D do SOLID (Inversão de Dependência)

- **Descrição:** Refatoração do CMS para aplicar o princípio da Inversão de Dependência (Dependency Inversion Principle - DIP).
- **Modificações:**
  - As dependências de alto nível não dependem mais de módulos de baixo nível.
  - Introdução de injeção de dependências para gerir as instâncias das classes.

