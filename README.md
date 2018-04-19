# Desafio Zup

# Tecnologias Utilizadas

* Spring Boot
* FlyWay
* Database h2database (Embedded)
* Java 8
* Maven

# Introdução

Para usar e testar esse projeto, não é necessário nenhum tipo de instalação terceira, o projeto usa um banco embarcado configurado para recriar sempre que a aplicação for construida e a criação das tabelas é realizada durante o processo de construção do aplicativo atráves do flyway. 
Assim como o banco o servidor tomcat usado com spring boot é embarcado, iniciando durante a construção da aplicação.

# Ferramenta para Testes

Foi utilizado para os testes dos serviços além dos testes unitários a ferramenta Postman https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

# Execução e Testes

1. Para o build da aplicação, execute a Classe **CoordenadaApplication** como um Java Application, nesse processo já são    cadastrados alguns pontos padrão. (Pontos descritos no desafio)
 
2. Para cadastrar um ponto de interesse, execute uma requisição com verbo http **POST** para `localhost:8080/coordenadas`, esse recurso consome um **APPLICATION_JSON**. Para execução desse recurso será necessário passar um objeto **APPLICATION_JSON** no corpo da requisição com os valores de **"nome, posicaoX e posicaoY"** .

4. Para listar todas as Coordenadas salvas, execute o recurso `localhost:8080/coordenadas`

5. Para retornar todas os pontos de interesse cadastrados que tenham uma distância menor ou igual a distância máxima. Execute o recurso `localhost:8080/coordenadas/proximidades` com verbo http **GET**. Os parâmetros **"posicaoX,posicaoY e distanciaMax"** devem ser passados no Cabeçalho da requisição. Exemplo desse recurso sendo chamado via browser http://localhost:8080/coordenadas/proximidades/20/10/10

# Testes Unitários

Existe 3 classes no projeto para cada operação

1 - Classe ListarPontosInteresseCadastradoTest, lista todos pontos de interesse cadastradas.

2 - Classe ListarPontosInteresseProximidadeTest, lista os pontos de interesse por proximidade cadastrados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência passado como parâmetro.
Essa classe está com os parâmetros de posiçãoX, posiçãoY e distância fixos, caso desejar outros valores deve editar o parâmetro na classe antes de executar o teste.

3 - Classe SalvarPontosInteresseTest responsável por cadastrar um novos pontos de interesse



