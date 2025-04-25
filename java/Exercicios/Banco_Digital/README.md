# Banco Digital POO - Sistema Bancário em Java

![Java 17](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![Orientação a Objetos](https://img.shields.io/badge/Orienta%C3%A7%C3%A3o%20a%20Objetos-100%25-success)
![Licença MIT](https://img.shields.io/badge/License-MIT-green)

---

## 📌 Visão Geral

**Banco Digital POO** é uma aplicação bancária robusta desenvolvida em Java 17, que exemplifica os conceitos fundamentais de Programação Orientada a Objetos (POO). O sistema permite:

- Cadastro e autenticação de clientes (pessoa física e jurídica);
- Criação e gerenciamento de contas bancárias (corrente e poupança);
- Operações financeiras seguras: depósito, saque, transferência e consulta de saldo;
- Implementação de regras de negócio para linha de crédito em conta corrente;
- Exibição consolidada de extratos e listagem de contas.



## 🚀 Principais Funcionalidades

| Módulo        | Descrição                                                         |
|---------------|-------------------------------------------------------------------|
| **Clientes**  | - Pessoa Física (CPF) <br>- Pessoa Jurídica (CNPJ)                |
| **Contas**    | - Conta Corrente com linha de crédito dinâmica <br>- Conta Poupança com regras de saque |
| **Transações**| - Depósito instantâneo <br>- Saque com validação de limite <br>- Transferência interna entre contas |
| **Consultas** | - Saldo em tempo real <br>- Listagem detalhada de contas          |
| **Segurança** | - Autenticação por credenciais <br>- Hashing de identificadores    |

---

## Estrutura do Projeto

```
src/
├── agentes/
│   ├── Cliente.java           # Classe abstrata base para clientes
│   ├── PessoaFisica.java      # Cliente do tipo pessoa física
│   └── PessoaJuridica.java    # Cliente do tipo pessoa jurídica
├── banco/
│   └── Banco.java             # Gerenciador de clientes e transferências
├── conta/
│   ├── Conta.java             # Classe abstrata base para contas
│   ├── ContaCorrente.java     # Implementação de conta corrente
│   └── ContaPoupanca.java     # Implementação de conta poupança
└── App.java                   # Classe principal com interface de texto
```

---

## 📊 Diagrama de Classes



``` mermaid
classDiagram
    class Cliente{
        <<abstract>>
        -String nome
        -String senha
        -ArrayList<Conta> contas
        +adicionarConta(Conta)
        +receberTransferencia(int, int, double)
        +buscarConta(int, int)
        +validarLogin(String, String) abstract
    }
    
    class PessoaFisica{
        -String CPF
        -String nascimento
        +validarLogin(String, String)
    }
    
    class PessoaJuridica{
        -String CNPJ
        +validarLogin(String, String)
    }
    
    class Conta{
        <<abstract>>
        -Cliente titular
        -int agencia
        -int numero
        -double saldo
        +sacar(double) abstract
        +depositar(double)
        +transferir(Banco, int, int, double)
    }
    
    class ContaCorrente{
        -double linhaCredito
        +sacar(double)
    }
    
    class ContaPoupanca{
        +sacar(double)
    }
    
    class Banco{
        -String nome
        -Set<Cliente> clientes
        +adicionarCliente(Cliente)
        +realizarTransferencia(int, int, double)
        +buscarCliente(String, String)
    }
    
    Cliente <|-- PessoaFisica
    Cliente <|-- PessoaJuridica
    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
    Cliente "1" *-- "*" Conta
    Banco "1" *-- "*" Cliente

``` 

---

## Funcionalidades Principais

### Clientes
- **Cliente (abstrato)**  
  - Armazena nome, senha e lista de contas.  
  - Gerencia ID sequencial para cada cliente.  
  - Métodos genéricos para adicionar contas, buscar contas, receber transferências e listar dados.
- **PessoaFisica**  
  - Validação de login por CPF e senha.  
  - Geração de `hashCode` a partir do CPF.
- **PessoaJuridica**  
  - Validação de login por CNPJ e senha.  
  - Geração de `hashCode` a partir do CNPJ.

### Contas
- **Conta (abstrata)**  
  - Define atributos comuns: titular, agência, número aleatório, saldo e tipo.  
  - Métodos genéricos para depositar, validar agência/número e consultar saldo.
- **ContaPoupanca**  
  - Permite saque até o saldo disponível.
- **ContaCorrente**  
  - Possui linha de crédito com regras de negócio:
    - **Linha 0**: primeiro depósito < R$200  
    - **Linha R$300**: primeiro depósito entre R$200 e R$1499,99  
    - **Linha R$500 + 25%**: primeiro depósito ≥ R$3000  
  - Implementa saque e transferência respeitando o limite de crédito.

### Banco
- Mantém um `HashSet` de clientes para evitar duplicatas (baseado em `hashCode`).
- Métodos para:
  - Adicionar cliente.
  - Listar todas as contas e saldos de clientes.
  - Realizar transferências, delegando aos clientes.

### Aplicação (App.java)
- Interface de texto via `Scanner`.
- Fluxo principal:
  1. Menu inicial: cadastro ou login.
  2. Menu do cliente autenticado: criar contas, listar contas ou acessar conta específica.
  3. Operações na conta: consultar saldo, depositar, sacar e transferir.

---

## Tecnologias e Requisitos

- **Linguagem:** Java 17+  
- **Dependências:** somente bibliotecas padrão do JDK  
- **Construção:** ferramenta de sua preferência (Javac/Maven/Gradle)

---



## Exemplos de Uso

1. **Cadastrar Pessoa Física**  
   ```
   [1] Fazer Cadastro
   [2] Fazer Login
   -> 1
   [2] Cadastrar pessoa física
   Informe seu nome: João Silva
   Informe sua data de nascimento: 01/01/1990
   Informe seu CPF: 12345678900
   Informe sua senha: senha123
   ```
2. **Criar Conta Corrente**  
   ```
   [1] Criar conta poupança
   [2] Criar conta corrente
   -> 2
   Deposite o primeiro valor da sua conta: 3500
   ```
3. **Operar na Conta**  
   ```
   [1] Consultar saldo        -> exibe saldo + linha de crédito
   [2] Depositar dinheiro
   [3] Sacar dinheiro
   [4] Transferir dinheiro
   ```

---

## Boas Práticas e Padrões

- **Encapsulamento:** atributos protegidos e métodos públicos bem definidos.  
- **Polimorfismo e herança:** classes abstratas (`Cliente`, `Conta`) e implementações específicas.  
- **Tratamento de erros:** checagem de parâmetros inválidos em operações financeiras.  
- **Imutabilidade parcial:** o número da conta é gerado aleatoriamente no construtor e não é alterável.

---

## Contribuindo

1. Fork deste repositório.  
2. Crie uma branch para sua feature ou correção (`git checkout -b feature/nome-da-feature`).  
3. Faça commits claros e atômicos.  
4. Abra um Pull Request descrevendo sua contribuição.

---

## Licença

Este projeto está licenciado sob a **MIT License**. 

---

## Contato

- **Autor:** Xanderson Silva  
- **E-mail:** xandersonsilvasouza@gmail.com  
- **LinkedIn:** https://www.linkedin.com/in/xanderson-silva  

Obrigado por usar este projeto! Sinta-se à vontade para enviar dúvidas, sugestões ou reportar issues.

