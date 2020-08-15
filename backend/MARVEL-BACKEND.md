# Marvel - Backend

Nosso time de desenvolvedores front end estava desenvolvendo um catálogo de super-heróis usando a [API da Marvel](https://developer.marvel.com/docs#!/public) quando Thanos estalou seus dedos e fez metade dos endpoints bugar (desculpe pelo spoiler).

Agora, você tem a missão de re-implementar os endpoints *characters* (ver lista abaixo) e commitar essa implementação em um repositório e compartilhar conosco.

Endpoints a serem implementados:

* `/v1/public/characters`
* `/v1/public/characters/{characterId}`
* `/v1/public/characters/{characterId}/comics`
* `/v1/public/characters/{characterId}/events`
* `/v1/public/characters/{characterId}/series`
* `/v1/public/characters/{characterId}/stories`

## Você terá cumprido a missão quando esse repositório tiver:

* Um arquivo README com instruções de como baixar, compilar, executar e testar seu código

* Código-fonte propriamente dito

* Quaisquer scripts de inicialização que sejam necessários (como inserts de banco por exemplo)

## Restrições:

* o código deve ser capaz de executar totalmente offline, ou seja, na máquina que vai ser testado, sem acesso a Internet (nota.: essa restrição é apenas para o runtime. A build/compilação pode ser feita com o auxílio da Internet, especialmente para download de dependências)

* a implementação deve ser sua e você deve ser capaz de explicar quaisquer decisões arquiteturais e/ou de implementação

## O que será avaliado?

* Se a API funciona corretamente, retornando os resultados esperados, o que inclui eventuais códigos de erros e mensagens (nota: os resultados não precisam ser os mesmos da API original, desde que mantenham a mesma ideia. Por exemplo: não é necessário que seja retornado “Hulk” no campo de nome do personagem. É aceitável retornar “ABC” ou “XYZ”, mas não é aceitável retornar 42 ou 25/05/1977

* Código: legibilidade, acoplamento, coesão e boas práticas em geral

* Cobertura de testes


O código deve estar em um repositório público.
