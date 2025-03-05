# Sistema de Bilheteria de Cinema

Este projeto é um exercício em Java que demonstra os conceitos de **herança** e **polimorfismo** através de um sistema de bilheteria para cinema. O programa permite que o usuário escolha entre diferentes tipos de ingressos e, com base na opção selecionada, calcula e exibe o valor a ser pago.

## Funcionalidades

- **Herança:**  
  Utiliza uma classe base selada (`Ingresso`) que define os atributos e comportamentos comuns a todos os tipos de ingresso.

- **Polimorfismo:**  
  As classes filhas (`IngressoFamilia` e `MeiaEntrada`) sobrescrevem o método `valor_real()` para implementar cálculos específicos de acordo com o tipo de ingresso.

- **Tipos de Ingressos:**
  - **Ingresso Padrão (Ingresso):**  
    Exibe o valor base do ingresso.
  - **Meia Entrada (MeiaEntrada):**  
    Calcula o valor com 50% de desconto sobre o valor base.
  - **Ingresso Família (IngressoFamilia):**  
    Multiplica o valor base pela quantidade de pessoas; se houver mais de 3 pessoas, aplica um desconto de 5% no total.

## Estrutura do Projeto

```plaintext
xanderson.edu.heranca_e_polimorfismo/
├── cinema
│   └── App.java                # Classe principal que executa a aplicação.
└── cinema/bileteria
    ├── Ingresso.java           # Classe base selada para os ingressos.
    ├── IngressoFamilia.java    # Classe final para o ingresso família.
    └── MeiaEntrada.java        # Classe final para a meia entrada.
```

## Contribuições

Contribuições para melhorias e aprimoramentos são bem-vindas. Caso deseje contribuir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com suas sugestões ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para dúvidas, sugestões ou feedback, entre em contato através do e-mail:

**isacsilvasouza5@gmail.com**

---