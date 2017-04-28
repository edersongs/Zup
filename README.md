# Desafio Zup

1) Construa um serviço para cadastrar pontos de interesse, com 3 atributos: Nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo). Os POIs devem ser armazenados em uma base de dados.

2) Construa um serviço para listar todos os POIs cadastrados.

3) Construa um serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

# Tecnologias Utilizadas

* Spring Boot
* FlyWay
* Database h2database

# Ferramenta para Testes

Foi utilizado para os testes dos serviços a ferramenta Postman https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

# Execução dos Testes

1. (Extra) Caso deseje cadastrar todos os pontos descritos no desafio de uma só vez, execute o recurso `localhost:8080/api/salvarPadrao` com verbo http **GET**. Com isso todas Posições sitadas como exemplo no desafio serão cadastradas.

2. Para salvar Nome do POI, coordenadaX, coordenadaY e distância Máxima, execute o recurso `localhost:8080/api/salvar` com verbo http **POST**. Esse recurso consome um **APPLICATION_JSON** e recebe como parametro um objeto chamado Coordenada. Para execução desse recurso será necessário passar um **APPLICATION_JSON** no corpo da requisição com os valores de **"nome, posicaoX e posicaoY"** .

3. Para listar todas as Coordenadas salvas, execute o recurso `localhost:8080/api/listarCoordenadas`

4. Para retornar todas as coordenadas cadastradas que tenham uma distância menor ou igual a distância máxima. Execute o recurso `localhost:8080/api/proximidades` com verbo http **GET**. Os parâmetros **"posicaoX,posicaoY e distanciaMax"** devem ser passados no Cabeçalho da requisição.
