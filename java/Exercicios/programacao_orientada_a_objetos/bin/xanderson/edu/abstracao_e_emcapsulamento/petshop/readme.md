# Controle de Banho no Petshop

Este repositório contém uma aplicação simples em Java que simula o controle de uma máquina de banhos de um petshop. O sistema gerencia a realização do banho, o reabastecimento de água e shampoo, a verificação dos níveis dos produtos, o controle da presença do pet na máquina e a limpeza do equipamento.

## Funcionalidades

- **Dar banho no pet**: Realiza o banho, consumindo água e shampoo se as condições forem atendidas.
- **Abastecer com água**: Reabastece a máquina com água, respeitando o limite máximo permitido.
- **Abastecer com shampoo**: Reabastece a máquina com shampoo, respeitando o limite máximo permitido.
- **Verificar nível de água**: Exibe a quantidade atual de água na máquina.
- **Verificar nível de shampoo**: Exibe a quantidade atual de shampoo na máquina.
- **Verificar se há pet no banho**: Indica se a máquina está ou não ocupada por um pet.
- **Colocar pet na máquina**: Adiciona um pet à máquina se ela estiver livre.
- **Retirar pet da máquina**: Remove o pet da máquina, resetando o estado do banho.
- **Limpar a máquina**: Executa a limpeza da máquina, consumindo uma pequena quantidade de água e shampoo, desde que não haja um pet presente.

## Estrutura do Projeto

O projeto é dividido em duas classes principais:

- **Banho**:  
  Contém a lógica para gerenciar todas as operações relacionadas ao banho.  
  Métodos importantes:
  - `Banhar_pet()`: Verifica se o pet já está limpo, se a máquina está limpa, se há um pet presente e se os níveis de água e shampoo são suficientes para dar banho.
  - `Abastecer_agua()`: Incrementa o nível de água na máquina, respeitando o limite máximo.
  - `Abastecer_shampoo()`: Incrementa o nível de shampoo na máquina, respeitando o limite máximo.
  - `verificar_agua()`: Mostra a quantidade atual de água.
  - `verificar_shampoo()`: Mostra a quantidade atual de shampoo.
  - `verificar_pet_banho()`: Informa se há um pet na máquina.
  - `colocar_pet()`: Adiciona um pet à máquina, se esta estiver desocupada.
  - `retirar_pet()`: Remove o pet da máquina, permitindo novas operações.
  - `limpar_maquina()`: Limpa a máquina, consumindo produtos, mas apenas se não houver pet e se houver produtos suficientes.

- **App**:  
  Contém o método `main` e a interface de interação com o usuário via console.  
  O menu permite ao usuário selecionar a operação desejada, chamando os métodos correspondentes da classe `Banho`.

## Como Executar o Projeto

### Pré-requisitos

- **Java Development Kit (JDK)** instalado (versão 17 ou superior).

### Compilação

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório onde o código-fonte está localizado.
3. Compile o projeto executando:
   ```bash
   javac -d bin src/xanderson/edu/petshop/*.java

## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**

---