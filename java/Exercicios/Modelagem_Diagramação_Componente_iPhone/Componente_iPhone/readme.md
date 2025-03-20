# Modelagem e Diagramação de um Componente iPhone

## Sumário

- [Visão Geral do Sistema](#visão-geral-do-sistema)
- [Estrutura de Pacotes e Classes](#estrutura-de-pacotes-e-classes)
  - [AparelhoTelefonico](#aparelhotelefonico)
  - [NavegadorInternet](#navegadorinternet)
  - [ReprodutorMusical](#reprodutormusical)
  - [Main](#main)
- [Diagrama de Classes](#diagrama-de-classes)
- [Fluxo de Execução](#fluxo-de-execução)
- [Considerações Finais](#considerações-finais)

---

## Visão Geral do Sistema

O sistema simula o funcionamento de um dispositivo (por exemplo, um *iPhone*) que agrega três funcionalidades principais:

- **Reprodutor Musical:** Permite selecionar, tocar, pausar, parar, retroceder e avançar músicas.
- **Navegador de Internet:** Habilita a exibição de páginas web, abertura de novas abas e atualização da página atual.
- **Aparelho Telefônico:** Simula funções de ligação, atendimento, correio de voz e encerramento de chamadas.

Cada funcionalidade é implementada em uma classe específica, organizada dentro do pacote `apps`. A classe `Main` atua como o ponto de entrada, gerenciando a interação com o usuário e a execução dos módulos.

---

## Estrutura de Pacotes e Classes

### AparelhoTelefonico

#### **Atributos:**
- `historicoChamadas`: Lista que armazena os números chamados.
- `emChamada`: Booleano que indica se há uma chamada ativa.

#### **Métodos:**
- **`ligar(String numero)`**: Inicia uma chamada para o número informado. Caso já esteja em uma chamada, exibe uma mensagem de alerta.
- **`atender()`**: Atende uma chamada (adicionando "Número desconhecido" ao histórico), somente se não estiver em uma chamada.
- **`iniciarCorreioVoz()`**: Inicia o correio de voz, desde que não haja uma chamada ativa.
- **`encerrarChamada()`**: Encerra uma chamada ativa, alterando o estado para "não em chamada".
- **`exibirHistoricoChamadas()`**: Lista todas as chamadas realizadas.

### NavegadorInternet

#### **Atributos:**
- `paginaAtual`: Armazena a URL da página atualmente exibida.
- `abasAbertas`: Lista de URLs abertas em novas abas.
- `historico`: Registro das páginas acessadas.

#### **Métodos:**
- **`exibirPagina(String url)`**: Exibe uma página e, se a URL for nova, adiciona-a ao histórico.
- **`adicionarNovaAba(String url)`**: Abre uma nova aba com a URL informada, chamando o método de exibição de página.
- **`atualizarPagina()`**: Simula a atualização da página atual.
- **`exibirHistorico()`**: Exibe todas as páginas acessadas no histórico.

### ReprodutorMusical

#### **Atributos:**
- `tocandoMusica`: Booleano que indica se uma música está sendo reproduzida.
- `musica`: String que armazena o nome da música selecionada.

#### **Métodos:**
- **`tocarMusica()`**: Inicia a reprodução, verificando se nenhuma música está tocando e se uma música foi previamente selecionada.
- **`pausarMusica()`**: Pausa a música em reprodução, se houver.
- **`pararMusica()`**: Interrompe a reprodução da música ativa.
- **`retrocederMusica()`**: Simula a ação de voltar para a música anterior.
- **`avançarMusica()`**: Simula a ação de avançar para a próxima música.
- **`selecionarMusica(String musica)`**: Define a música a ser reproduzida e exibe uma mensagem de confirmação.
- **`exibirMusicaAtual()`**: Mostra a música que está sendo tocada no momento.

### Main

- **Função Principal:**  
  A classe `Main` contém o método `main` que inicia a aplicação e gerencia a interação com o usuário por meio de menus interativos.

- **Métodos Auxiliares:**
  - **`sistema()`**: Loop principal que apresenta o menu com opções para acessar os aplicativos ou desligar o sistema.
  - **Métodos Específicos para cada módulo**:
    - `iPod(ReprodutorMusical iPod)`
    - `safari(NavegadorInternet safari)`
    - `telefone(AparelhoTelefonico telefone)`
  
    Cada método apresenta um submenu com operações específicas, permitindo ao usuário interagir diretamente com cada funcionalidade.
  
  - **`informarNumero()`**: Lê a entrada do usuário, convertendo para um valor numérico e tratando exceções em caso de erro.

---

## Diagrama de Classes

O diagrama de classes ilustra a estrutura e as relações entre as classes do sistema. A imagem do diagrama encontra-se no diretório `diagrama` e pode ser visualizada abaixo.

### Imagem do Diagrama

![Diagrama de Classes](https://mermaid.ink/img/pako:eNp9U8FO5DAM_ZUqJ9AwP1AhpBF7WWlBCNAeVr24iWkjWrtykhELmu_ZD-HH8Ezb2anaIafW78X2e44_jGWHJje2gRB-eKgE2oIyPYdI9oidsEuR5S4Fb6HJPnp4f9aRLZDjHsryrGRuEOiE0Y7QUxRP1X9ktb87JL24PIl3kMIZQBbjglHYosMlELZAn_8W7wVs0HqmI9i3mPUtD8xdQad2bLQJbGp-1rsvTN7yxI_aB3VKo7c1tOAgqPBfGrvuU9-cULEdOEu2rRpfgYwNUWpReKIqIqneiRyv3XiQWxZBz7_5fYIiWRT1byh6sSzvHrZYgWP5SRGFME7UdVB5gk1M-grmA11DCWFTosTvZB8dOktZ4ZsvvTwcio0WJGkm-p3vJ3fPW9iUZ2n7Vv07jMmWRfuHmglHpUdwCK_XN_MlmDHm72JGmXlbkLkyOtkWvNMNPNQvTKyxxcLk-ulAXgtT0E55oNWf_pI1eZSEV0Y4VbXJX6AJ-pc6p09iWN-R0gH9YW4H0u4LMhE-UA)

---

## Fluxo de Execução

1. **Inicialização:**  
   O método `main` da classe `Main` invoca `sistema()`, que apresenta o menu principal.

2. **Menu Principal:**  
   O usuário pode escolher entre desligar o sistema ou acessar um dos aplicativos.

3. **Sub-menus:**  
   Cada opção direciona o usuário para um submenu, onde operações específicas podem ser realizadas.

4. **Validação de Estado:**  
   Antes de executar qualquer operação, os métodos validam o estado atual por meio de verificações como checagem de variáveis booleanas, confirmação de entrada do usuário e tratamento de exceções para evitar conflitos.

5. **Interação com o Usuário:**  
   A leitura e o tratamento das entradas do usuário são realizados por métodos específicos.

---

## Considerações Finais

O sistema simula de forma simplificada um dispositivo multifuncional, organizando a interação entre os módulos por meio de menus estruturados. A modularização permite fácil expansão do projeto para incluir novas funcionalidades no futuro.

## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**
