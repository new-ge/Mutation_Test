# Mutation_Test
Este projeto é uma aplicação Java baseada em **Spring Boot**, com foco na utilização da ferramenta de testes de mutação **PIT (Pitest)** para análise da qualidade dos testes automatizados.

## PIT (Pitest)
É uma ferramenta de testes de mutação para código Java. 
Os Testes de mutação são uma técnica avançada de teste que ajuda a avaliar a eficácia dos testes automatizados (como testes unitários).

### Como funciona?
São alterados algumas partes do código-fonte de uma maneira controlada, ou seja, são o que consideramos como mutações. Com essas alterações, os testes automatizados são executados para verificar se algum teste irá "falhar", devido a mutação apresentada. 
Em resumo:
- Se um teste falha = a mutação foi detectada --> bom teste ✅ 
- Se nenhum teste falha = a mutação está viva --> teste fraco ou inexistente ❌

### Para que serve?
- Avaliar a qualidade dos testes
- Localizar falhas ou pontos cegos implementados nos testes
- Melhorar a confiabilidade do software/projeto em desenvolvimento

### Canais oficiais: 
Se você deseja saber mais sobre o Pitest, por favor, acesse:
- O site oficial: <https://pitest.org/> 
- O GitHub oficial: <https://github.com/hcoles/pitest>

---

## :hammer_and_wrench: Mutation_Test: Tecnologias e Ferramentas Utilizadas

| Ferramenta             | Versão      | Descrição                                                                 |
|------------------------|-------------|--------------------------------------------------------------------------|
| Java                   | 21          | Linguagem de programação utilizada                                       |
| Maven                  | 3.9+        | Gerenciador de dependências e build                                      |
| Spring Boot            | 3.5.0       | Framework para desenvolvimento de aplicações Java                        |
| JUnit 5                | incluso     | Framework de testes                                                      |
| PIT (Pitest)           | 1.19.5      | Ferramenta de testes de mutação                                          |
| Plugin JUnit5 Pitest   | 1.2.1       | Plugin para integração do Pitest com JUnit 5                             |
| Lombok                 | 1.18.30     | Geração automática de código boilerplate                                |

*** Projeto elaborado em Windows

---

## :rocket: Como rodar o projeto

### 1. Pré-requisitos

- Java 21 instalado
- Maven instalado
- Git instalado

### 2. Clonar o repositório

```bash
git clone https://github.com/new-ge/Mutation_Test.git
cd mutation_test
```

### 3. Compilar o projeto
```bash
mvn clean compile
```

### 4. Rodar os testes automatizados
```bash
mvn test
```

### 5. Executar o PIT (Testes de Mutação)

- Comando para gerar o relatório:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

- Localização do relatório: Após a execução, o relatório HTML será gerado no diretório:

```bash
cd target\pit-reports\pasta_com_timestamp
```
Para *{pasta_com_timestamp}* : substitua pela pasta criada automaticamente com a data e hora da execução

E depois: 

```bash
start index.html
```
- Abra o arquivo index.html no seu navegador para visualizar os resultados.

---

### :gear: Configurações do PIT
- Para que seja possível implementar o Pitest no seu projeto, pasta adicionar em *pom.xlm*, a seguinte estrutura:
```xml
    <plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
        <!-- Substitua pela versão que seu projeto irá utilizar -->
    <version>1.19.5</version>
    <configuration>
        <!-- Substitua pelo pacote base da sua aplicação -->
        <targetClasses>
        <param>com.seu.pacote.aqui.*</param>
        </targetClasses>
        <!-- Percentual mínimo esperado de mutações detectadas -->
        <mutationThreshold>X</mutationThreshold>
        <!-- Se true, falha a build quando não houver mutações -->
        <failWhenNoMutations>false</failWhenNoMutations>
        <!-- Plugin de testes utilizado (ex: definir qual o junit está sendo utilizado) -->
        <testPlugin>junitX</testPlugin>
    </configuration>
    </plugin>
```

- *mutationThreshold*: Percentual mínimo de cobertura de mutação (ajustável)
- *failWhenNoMutations*: Se true, a build falha quando não há mutações (atualmente está como false)


🎯 Em quais tipos de testes o teste de mutação é útil?
Tipo de teste	Teste de mutação funciona bem?	Explicação
✅ Teste unitário	⭐⭐⭐⭐⭐ Excelente	Ideal: pequenos métodos testados em isolamento. Mutantes são facilmente associados ao método testado.
⚠️ Teste de integração	⭐⭐ Razoável	Pode funcionar, mas é mais difícil saber qual mutante sobreviveu e por quê. Também mais difícil isolar problemas.
❌ Teste de sistema / UI	⭐ Quase inútil	Não recomendado: muito alto nível, cobertura de código específica não é garantida, testes são mais frágeis e lentos.
❌ Teste manual	🚫 Não se aplica	Teste de mutação só avalia testes automatizados.

--- 

🧪 O que o teste de mutação mede?
Ele mede se seus testes são capazes de:

Detectar erros comuns de programação simulados (mutações no código).

"Matar mutantes" = os testes falham quando algo está errado (isso é bom).

Identificar áreas mal testadas (mutantes sobrevivem = perigo!).

---

🛡️ Vulnerabilidades que podem ser evitadas indiretamente com teste de mutação
O teste de mutação trabalha melhor em nível de código, ajudando a encontrar testes que não detectam comportamentos incorretos — e isso, por consequência, pode expor ou deixar passar:
