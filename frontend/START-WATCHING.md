# Quando devo começar a assistir

Você está ansioso para a nova temporada de uma série que você gosta muito e não lembra mais nada? Sempre me pergunto quando terei que começar a reassistir todos os episódios para terminar bem no dia que começa a próxima temporada. Eu tenho uma API com todas as informações das minhas séries favoritas. Que tal fazer uma aplicação que liste essas séries e me diga como fazer para vê-las a tempo?

Vamos lá, o que precisaremos?

* Listagem de séries: exibir as descrições das séries vindas da API. Ao clicar em uma série, direcionar para a calculadora.
* Calculadora, cujos campos são:
    * Quando quero começar (no mínimo hoje)
    * Tempo para assistir por dia (no máximo 24h)
    
Dado um, calcular o outro. Exemplo: Se eu quiser começar a assistir hoje, a calculadora deve retornar quantas horas por dia devo assistir. Se eu quiser assistir 3h por dia, a calculadora deve retornar qual dia começar. Ou se é impossível, nos dois casos, mostrar uma mensagem apropriada. A data final será sempre a release date do próximo episódio a ser lançado.

## API's

Assuma a existência de uma API com a seguinte especificação estão no [link](https://github.com/luanpotter/series-api/blob/master/APIS.md).
Você pode utilizar dados mockados ou implementar a sua versão da API, desde que respeite os protocolos. Se desejar, pode utilizar o seguinte endpoint disponível na Internet `https://nl0rh2wwna.execute-api.us-east-1.amazonaws.com/dev/series`
Para facilitar o desenvolvimento, sugerimos usar sempre o query param mockDate=2019-03-01 (para todas as requests). Dessa forma, nosso catálogo de séries sempre conterá algumas séries que estão em progresso e finalizadas. Note que ao usar esse mock, as datas vão mudar dia a dia, para sempre ficarem a mesma distância temporal do dia atual.

## Sugestões para Adicionar

* Usar um gerenciador de pacotes (npm, yarn...)
* Instruções para executar
* Criar testes

## Critérios básicos para avaliação:

* Usar um gerenciador de pacotes (npm, yarn...)
* Instruções para executar
* Criar testes


O código deve estar em um repositório público.
