# Teste Prático - Iniflex | Prothera
Projeto Maven desenvolvido para o teste prático da vaga de Desenvolvedor Full Stack JR

## Tecnologias

- Java 17
- Maven
- Programação Orientada a Objetos
- Collections
- LocalDate
- BigDecimal

## Estrutura

```text
iniflex/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        └── java/
            └── br/com/prothera/iniflex/
                ├── Principal.java
                ├── model/
                │   ├── Pessoa.java
                │   └── Funcionario.java
                ├── service/
                │   └── FuncionarioService.java
                └── utils/
                    └── Formatador.java
```

## Como executar

Com Java 17 e Maven instalados no NetBeans IDE, abra o projeto Maven e execute o arquivo `Principal.java`.

## Responsabilidades

- `Pessoa`: dados básicos da pessoa
- `Funcionario`: herda de `Pessoa` e acrescenta salário e função
- `FuncionarioService`: operações relacionadas aos funcionários
- `Formatador`: formatação de datas e valores monetários
- `Principal`: executa o projeto e apresenta os resultados

## Requisitos implementados

- 3.1 - Inserção dos funcionários na ordem da tabela
- 3.2 - Remoção do funcionário João
- 3.3 - Impressão das informações com data e salário formatados
- 3.4 - Aumento de 10% nos salários
- 3.5 - Agrupamento por função em um Map
- 3.6 - Impressão dos funcionários agrupados por função
- 3.8 - Aniversariantes dos meses 10 e 12
- 3.9 - Funcionário com maior idade
- 3.10 - Ordenação alfabética
- 3.11 - Total dos salários
- 3.12 - Quantidade aproximada de salários mínimos (considerando o salário base de R$ 1.212,00)