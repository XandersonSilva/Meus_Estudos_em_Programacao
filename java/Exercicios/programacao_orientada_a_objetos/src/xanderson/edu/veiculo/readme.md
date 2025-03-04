
# Simulador de Funções de um Carro

Este projeto é um exercício em Java que simula o controle de um veículo, permitindo a execução de diversas operações, tais como ligar, desligar, acelerar, reduzir velocidade, mudar de direção e trocar de marcha. O código demonstra o uso de conceitos básicos de orientação a objetos e controle de fluxo.

## Funcionalidades

O sistema permite controlar as seguintes funções de um carro:

- **Ligar o carro:** Ativa o veículo, permitindo que outras operações sejam realizadas.
- **Desligar o carro:** Desativa o veículo, mas somente se ele estiver parado e em ponto morto.
- **Acelerar:** Incrementa a velocidade do carro, dependendo da marcha atual.
- **Diminuir velocidade:** Reduz a velocidade do veículo, também validando a marcha.
- **Virar para esquerda:** Permite uma curva à esquerda, com restrição de velocidade.
- **Virar para direita:** Permite uma curva à direita, com restrição de velocidade.
- **Verificar velocidade:** Exibe a velocidade atual do carro.
- **Trocar a marcha:** Altera a marcha do veículo de acordo com a velocidade atual.

## Estrutura do Projeto

O projeto está organizado no pacote `xanderson.edu.veiculo` e possui as seguintes classes:

- **Carro:**  
  Implementa as funcionalidades do carro. Possui atributos como `estado` (indica se o carro está ligado ou desligado), `velocidade`, `marcha` e `direcao`.  
  Contém métodos para ligar/desligar o carro, acelerar, diminuir velocidade, virar para os lados, verificar a velocidade e trocar a marcha, com validações específicas para cada operação.

- **app:**  
  Classe contendo o método `main` que executa o sistema. Utiliza um `Scanner` para capturar a entrada do usuário e oferece um menu interativo para testar as funcionalidades do carro.

## Como Executar

### Pré-requisitos

- **Java Development Kit (JDK):** Certifique-se de que o JDK esteja instalado e configurado na sua máquina.



### Execução

Após a compilação, execute o aplicativo com o comando:
```bash
java xanderson.edu.veiculo.app
```

O sistema exibirá um menu interativo no console, permitindo a escolha das operações disponíveis (ligar, desligar, acelerar, etc.).

## Observações

- **Validações:**  
  Cada método possui validações que garantem o correto funcionamento do carro. Por exemplo, o carro não poderá ser desligado se estiver em movimento ou se não estiver em ponto morto.

- **Mecânica de marchas:**  
  A aceleração e a diminuição de velocidade dependem da marcha correta para o intervalo de velocidade atual. Caso contrário, uma mensagem de erro é exibida.

- **Uso de Scanner:**  
  A classe `app` utiliza o `Scanner` para leitura de comandos do usuário, encerrando o programa quando a opção `0` for selecionada.


## Conclusão

Este exercício demonstra os fundamentos da programação orientada a objetos em Java e a aplicação prática de lógica condicional para controle de fluxo em sistemas interativos. É um excelente ponto de partida para projetos mais complexos relacionados à simulação de veículos.


## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**

---