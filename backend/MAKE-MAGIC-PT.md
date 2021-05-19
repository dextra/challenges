# Faça a magia - Desafio de backend

Olá! Obrigado por ter se aplicado para essa vaga, esperamos que você aprenda algo novo.

O principal objetivo desde desafio é ver como você trabalha e como soluciona problemas.

Então, vamos começar.

## Introdução

Este desafio consiste em criar uma API REST para cumprir alguns requisitos.

Para que seja possível completar o desafio, utilize a documentação abaixo:

### 1 - Criação de usuário:

```
Método: POST
Host: http://us-central1-rh-challenges.cloudfunctions.net/potterApi/users
Body: {
	"email": "SEU_EMAIL_AQUI",
	"password": "DEFINA_UMA_SENHA_AQUI",
	"name": "SEU_NOME_AQUI"
}
```

O retorno da chamada será o seu usuário criado, seguindo o seguinte modelo:

```
{
  "user": {
    "email": "email",
    "password": "sua senha criptografada",
    "id": "id",
    "apiKey": "sua apikey",
    "name": "nome"
  }
}
```

Grave a sua `apiKey` em um lugar seguro, ela será sua chave para conseguir completar o desafio.

### 2 - Recuperação das casas:

```
Método: GET
Host: http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses
Header: {
	"apikey": "SUA_APIKEY_AQUI",
}
```

O retorno da chamada será a lista de casas, seguindo o seguinte modelo:

```
{
  "houses": [
    {
      "id": "id da casa",
      "name": "Nome da casa",
      "headOfHouse": "Diretor da casa",
      "values": "lista de valores da casa",
      "colors": "lista de cores da casa"
      "school": "Nome da escola",
      "mascot": "mascote da casa",
      "houseGhost": "Fantasma da casa",
      "founder": "Fundador da casa"
    }
  ]
}
```


Queremos que você crie uma aplicação CRUD para os personagens de Harry Potter, que na nossa opinião é um ótimo filme.

Sua aplicação precisa cumprir os seguintes requisitos:
* Criar um novo personagem
* Ler um único ou vários personagens
* Atualizar um único personagem
* Deletar um único personagem

Mas, para salvar corretamente a respectiva casa que pertence o personagem, você precisa validar o `id` da casa integrando sua aplicação com o sistema que falamos anteriormente sobre nossa parceria.


## Então, o que nós esperamos?

Vamos começar com um simples `json` contendo as propriedados de um personagem:

```
{
    "name": "Harry Potter",
    "role": "student",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "1760529f-6d51-4cb1-bcb1-25087fce5bde",
    "patronus": "stag"
}
```
Nós queremos criar um novo registro com todas essas informações e sua aplicação também deve estar apta para ler, atualizar e deletar este registro.

NOTAS:
* Você pode especificar todas as propriedades requeridas.
* Você pode especificar todos os tipos dos valores.
* A propriedade `house`, ou outra propriedade com o mesmo significado, quando especificada, precisa ser uma `string` com o `id` da casa vindo do potterapi.
* Quando o `id` da casa for inválido, você precisa retornar uma mensagem de erro.


## Persistência

Isso não é um requisito para completar o desafio, mas tenha em mente que queremos ver como você trabalhar, então, essa é uma ótima oportunidade de você nos mostrar suas habilidades, sinta-se à vontade to implementar uma persistência com banco de dados que você julgar necessário.


## Filtros

Os filtros nos ajudam a resgatar somente os registro que queremos...

Então, implemente um filtro por casa, como o exemplo a seguir:

`http://localhost:3000/api/characters?house=1760529f-6d51-4cb1-bcb1-25087fce5bde`

O resultado precisa ser todos os personagens que pertencêm a casa com id `1760529f-6d51-4cb1-bcb1-25087fce5bde`


## Teste

Crie todos os testes necessários
* Teste unitário
* Teste de integração

E outros que achar necessário


## Linguagem

Sinta-se à vontade para usar a linguagem que você se sente mais confortável.


## Dicas

Como falamos anteriormente, esse desafio é a sua hora de mostrar todas as suas habilidades, então, algumas dicas que você pode usar no seu projeto.
Isso não define seu nível, mas é uma ótima hora para impressionar os avaliadores, então pense sobre:

* Docker
* Documentação
  * De código
  * Da API
* Ter a aplicação rodando.
* Qualidade de código.
* Circuit breaker
* Cache
* Tentar novamente caso alguma chamada HTTP falhe.

Seja criativo!

Você precisa criar um repositório público no github ou outros.

Boa Sorte.
