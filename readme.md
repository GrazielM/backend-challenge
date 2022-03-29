# Desafio Java Itau

## Começando

Para executar essa aplicação você irá precisar ter instalado em sua maquina:

- java igual ou superior a versão 11.0.1
- maven igual ou superior a versão 3.8.4

## Construção

Para iniciar a aplicação basta acessar seu diretório raiz e digitar os seguintes comando:

````
    mvn clean install
    mvn spring-boot:run
````

## Execução

Essa aplicação se baseia em uma api web que faz a validação de uma senha a partir da entrada
e retorna se a mesma é valida ou não, para que seja executado, após a construção da aplicação
você deve acessa-lá pelo link:

````
    http://localhost:8080/desafio/passwords/password/valid/{senha}
````

Onde "{senha}" você deve informar a senha que deseja validar convertida para o formato Base64.
E como saida terá true para valida, false para invalida.

Para codificar a senha em base64 pode-se utilizar do seguinte site:

````
    https://www.4devs.com.br/codificar_decodificar_base64
````

## Solução

A Solução para o problema consiste em receber a senha convertida para Base64 para que não ocorra problemas caso o usuario
tente utilizar caracteres especiais invalidos como "\"
Na classe PasswordServiceImpl consiste a lógica de validação, onde foi escolhido fazer uma validação utilizando uma expressão
regular indicando todos as condições exigidas para validação de senha.
