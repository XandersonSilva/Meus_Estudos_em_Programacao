# Exercício de Conta Bancária

Este projeto é um exercício em Java que simula o funcionamento de uma conta bancária. Ele permite realizar diversas operações típicas de uma conta, como consultar saldo, utilizar cheque especial, efetuar depósitos, saques e pagamento de boletos, além de verificar se o cheque especial está sendo utilizado.

## Funcionalidades

- **Consultar Saldo:** Exibe o saldo atual somado ao limite do cheque especial disponível.
- **Consultar Cheque Especial:** Mostra o valor disponível no cheque especial.
- **Depositar Dinheiro:** Permite adicionar um valor ao saldo da conta, atualizando o limite do cheque especial conforme necessário.
- **Sacar Dinheiro:** Realiza saques, utilizando o saldo e, se necessário, parte do cheque especial.
- **Pagar Boleto:** Efetua o pagamento de um boleto, descontando o valor do saldo ou do cheque especial.
- **Verificar Uso do Cheque Especial:** Indica se a conta está ou não utilizando o cheque especial.

## Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Entrada de Dados:** Scanner (interação com o usuário pelo console)

## Estrutura do Projeto

O projeto está organizado em dois pacotes principais:

- **`xanderson.edu.conta_banco.Conta`**  
  Implementa a classe `Conta`, que contém os atributos (número da conta, saldo, limite do cheque especial) e métodos para realizar as operações bancárias.

- **`xanderson.edu.conta_banco.App`**  
  Contém a classe `App` com o método `main`, que gerencia a interação com o usuário por meio de um menu no console. É nessa classe que o usuário cria uma conta e escolhe as operações desejadas.

## Como Executar

### Pré-requisitos

- **Java 17** ou superior instalado.
- Um ambiente de desenvolvimento Java (como IntelliJ IDEA, Eclipse ou VS Code) ou a utilização do terminal/linha de comando.

### Passos para Compilar e Executar

1. **Clone o repositório** (ou baixe os arquivos fonte).

2. **Compile o projeto:**  
   Navegue até a pasta raiz do projeto e execute o seguinte comando:
   
   ```sh
   javac -d bin src/xanderson/edu/conta_banco/*.java
   ```

3. **Execute o programa:**  
   Após a compilação, execute o aplicativo com o comando:
   
   ```sh
   java -cp bin xanderson.edu.conta_banco.App
   ```

   > **Observação:** Certifique-se de que os diretórios e pacotes estejam corretamente configurados conforme a estrutura do projeto.

## Uso do Programa

Ao iniciar o programa, você será questionado se deseja criar uma conta. Se optar por criar, deverá fornecer:

- **Número da conta**
- **Valor inicial para o saldo**

Após a criação da conta, um menu interativo será exibido com as seguintes opções:

```
[0] Sair
[1] Consultar saldo
[2] Consultar cheque especial
[3] Depositar dinheiro
[4] Sacar dinheiro
[5] Pagar um boleto
[6] Verificar se a conta está usando cheque especial
```

Basta digitar o número correspondente à operação desejada e seguir as instruções apresentadas no console.

## Considerações Importantes

- **Cheque Especial:**  
  - Se o saldo inicial for menor ou igual a R$500, o cheque especial é fixo em R$50.
  - Se o saldo inicial for maior que R$500, o cheque especial é definido como 50% do saldo.

- **Operações:**  
  - O sistema atualiza automaticamente o uso do cheque especial conforme as operações realizadas (ex.: após depósitos ou saques).
  - Ao realizar saques ou pagamento de boletos, o sistema verifica se há saldo suficiente, considerando também o limite do cheque especial.

## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**

---



