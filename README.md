# Introdução

Para usar e testar esse projeto, não é necessário nenhum tipo de instalação terceira, o projeto usa um banco embarcado configurado para ser recriado sempre que a aplicação for construída, o mesmo ocorre para criação das tabelas. Essa escolha foi usada para deixar a construção e execução do aplicativo de forma mais simples para avaliação, sem a necessidade de instalações local como banco de dados, servidor de aplicação etc.

# Tecnologias Utilizadas

* Spring Boot
* FlyWay
* Database h2database (Embedded)
* Java 8
* Maven
* IDE Eclipse oxygen

# Pré-requisitos

* Jdk 8 ou superior
* IDE Eclipse oxygen ou uma de sua escolha que suporta as tecnologias utilizadas no projeto.

# Ferramenta para Testes

Foi utilizado para os testes dos serviços além dos testes unitários a ferramenta Postman https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

# Build do aplicativo 
* Para o build da aplicação, após fazer o clone do projeto e importar em sua IDE de preferência, execute a Classe **CoordenadaApplication** como um Java Application, esse processo irá disponibilizar o aplicativo a um servidor Tomcat embarcado e já são cadastrados automaticamente alguns pontos padrão. (Pontos descritos no desafio) 

* Caso desejar fazer o build via linha de comando com maven, execute a instrução **mvn spring-boot:run** dentro do diretório raiz do aplicativo que é coordenada

# Testes dos End-Points pelo Postman ou via browser

* **Cadastrar Pontos de Interesse**

É necessário passar um objeto **APPLICATION_JSON** no corpo da requisição com os atributos e valores de **"nome, posicaoX e posicaoY"**.

```
Exemplo
{
  "nome": "Novo Ponto",
  "posicaoX": 30,
  "posicaoY": 15
}
```

```
Verbo http  POST

Request localhost:8080/coordenadas

Response Http Status 201 com objeto APPLICATION_JSON dos dados inseridos.
```

* **Listar todos pontos de interesse cadastrados**

```
Verbo http  GET

Request localhost:8080/coordenadas

Response Http Status 200 com objeto APPLICATION_JSON com todos registros cadastrados na base
```
* **Retornar pontos de interesse em uma distância máxima a partir de xy** 

```
Verbo http  GET

Request localhost:8080/coordenadas/proximidades

Parâmetros "posicaoX, posicaoY e distanciaMax" do tipo inteiro

Response Http Status 200 com objeto APPLICATION_JSON com todos os pontos de interesse são menores ou iguais a distância máxima a partir de xy.
```
```
Exemplo via browser http://localhost:8080/coordenadas/proximidades/20/10/10
```
# Testes Unitários

Existe 3 classes de teste no projeto para cada operação

1 - Classe ListarPontosInteresseCadastradoTest, lista todos pontos de interesse cadastradas.

2 - Classe ListarPontosInteresseProximidadeTest, lista os pontos de interesse por proximidade cadastrados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência passado como parâmetro.

3 - Classe SalvarPontosInteresseTest responsável por cadastrar um novo ponto de interesse

Os itens 2 e 3 está com os parâmetros de posiçãoX, posiçãoY e distância fixos, caso desejar testar outros valores deve editar o parâmetro nas classes antes de executar o teste.
