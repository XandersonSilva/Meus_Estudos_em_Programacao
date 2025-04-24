# Sistema de Gestão de Vendas

## Descrição

Este projeto consiste em um sistema de gestão de vendas desenvolvido em Java, utilizando conceitos de herança e polimorfismo. O sistema permite a interação de diferentes tipos de usuários (Atendente, Gerente e Vendedor) para gerenciar transações, processar pagamentos e gerar relatórios financeiros de forma eficiente.

## Estrutura do Projeto

O projeto está organizado em pacotes, conforme descrito abaixo:

- **xanderson.edu.heranca_e_polimorfismo.loja.agentes**: Contém as classes responsáveis pelos diferentes usuários do sistema.
  - `Usuario` (classe abstrata): Define atributos e métodos comuns a todos os usuários.
  - `Atendente`: Responsável pelo recebimento de pagamentos e fechamento de caixa.
  - `Gerente`: Capaz de gerar relatórios financeiros e consultar vendas.
  - `Vendedor`: Executa e consulta vendas realizadas.

- **xanderson.edu.heranca_e_polimorfismo.loja.armazenamento**: Contém a classe `PlaniliaDeVenda`, que gerencia as transações e registros de vendas.

- **xanderson.edu.heranca_e_polimorfismo.loja**: Contém a classe `App`, que serve como ponto de entrada do sistema, gerenciando a interação do usuário.

## Estrutura de Arquivos e Diretórios

A organização do projeto segue a seguinte estrutura:

```
SistemaGestaoVendas/
│── src/
│   ├── xanderson/edu/heranca_e_polimorfismo/loja/
│   │   ├── App.java
│   │   ├── agentes/
│   │   │   ├── Usuario.java
│   │   │   ├── Atendente.java
│   │   │   ├── Gerente.java
│   │   │   ├── Vendedor.java
│   │   ├── armazenamento/
│   │   │   ├── PlaniliaDeVenda.java
│───│───│─── readme.md
```

## Funcionalidades

### Usuário

Os usuários do sistema possuem as seguintes funcionalidades:

- Login e logoff.
- Atualização de dados cadastrais.
- Alteração de senha.

### Atendente

- Processamento de pagamentos pendentes.
- Fechamento de caixa com exibição do total recebido.

### Gerente

- Geração de relatórios financeiros com valores recebidos e pendentes.
- Consulta detalhada de todas as vendas registradas.

### Vendedor

- Registro de novas vendas, incluindo produtos e valores.
- Consulta de vendas realizadas.

## Estrutura da `PlaniliaDeVenda`

A classe `PlaniliaDeVenda` utiliza uma estrutura de lista de arrays para armazenar as vendas, seguindo o formato:

```java
[pagamentoRealizado, nomeProduto, quantidade, valorTotal, id]
```

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Compile o código:
   ```sh
   javac -d bin src/**/*.java
   ```
3. Execute o programa:
   ```sh
   java -cp bin xanderson.edu.heranca_e_polimorfismo.loja.App
   ```

## Melhorias Futuras

- Implementação de um banco de dados para armazenamento persistente.
- Desenvolvimento de uma interface gráfica para melhorar a usabilidade.
- Implementação de testes unitários para garantir a confiabilidade do sistema.

## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**


## Autor

**Xanderson** - Desenvolvimento do projeto utilizando conceitos de herança e polimorfismo em Java.

