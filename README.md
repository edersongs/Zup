# Desafio Zup

1) Construa um serviço para cadastrar pontos de interesse, com 3 atributos: Nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo). Os POIs devem ser armazenados em uma base de dados.

2) Construa um serviço para listar todos os POIs cadastrados.

3) Construa um serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

# Tecnologias Utilizadas

* Spring Boot
* FlyWay
* Database h2database (Embedded)
* Java 8
* Maven

# Ferramenta para Testes

Foi utilizado para os testes dos serviços além dos testes unitários a ferramenta Postman https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

# Execução dos Testes

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



