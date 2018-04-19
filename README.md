# Introdução

Para usar e testar esse projeto, não é necessário nenhum tipo de instalação terceira, o projeto usa um banco embarcado configurado para ser recriado sempre que a aplicação for construída, o mesmo ocorre para criação das tabelas. Essa escolha foi usada para deixar a construção e execução do aplicativo de forma mais simples para avaliação, sem a necessidade de instalações local como banco de dados, servidor de aplicação para testar o aplicativo.

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

# Execução e Testes

1. Para o build da aplicação, execute a Classe **CoordenadaApplication** como um Java Application, nesse processo já são cadastrados automaticamente alguns pontos padrão. (Pontos descritos no desafio)
 
2. **Cadastrar Pontos de Interesse**

Para cadastrar um ponto de interesse, execute uma requisição com verbo http **POST** para `localhost:8080/coordenadas`, esse recurso consome um **APPLICATION_JSON**. Para execução desse recurso será necessário passar um objeto **APPLICATION_JSON** no corpo da requisição com os atributos e valores de **"nome, posicaoX e posicaoY"**. 

* Exemplo
`{
  "nome": "Novo Ponto",
  "posicaoX": 30,
  "posicaoY": 15
}`

3. Para listar todos os pontos cadastrados, execute o recurso `localhost:8080/coordenadas`

4. Para retornar todas os pontos de interesse cadastrados que tenham uma distância menor ou igual a distância máxima. Execute o recurso `localhost:8080/coordenadas/proximidades` com verbo http **GET**. Os parâmetros **"posicaoX,posicaoY e distanciaMax"** devem ser passados no Cabeçalho da requisição. 

* Exemplo desse recurso sendo chamado via browser http://localhost:8080/coordenadas/proximidades/20/10/10

# Testes Unitários

Existe 3 classes de teste no projeto para cada operação

1 - Classe ListarPontosInteresseCadastradoTest, lista todos pontos de interesse cadastradas.

2 - Classe ListarPontosInteresseProximidadeTest, lista os pontos de interesse por proximidade cadastrados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência passado como parâmetro.
Essa classe está com os parâmetros de posiçãoX, posiçãoY e distância fixos, caso desejar outros valores deve editar o parâmetro na classe antes de executar o teste.

3 - Classe SalvarPontosInteresseTest responsável por cadastrar um novo ponto de interesse




