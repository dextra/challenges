# COVID notification - Backend

Olá! Obrigado por ter aceitado o desafio! E esperamos que você aprenda algo novo.

O principal objetivo desde desafio é ver como você trabalha e como soluciona problemas.

Então, vamos começar.

## Introdução

Dado o cenário do ano de 2020, bem atípico na vida das pessoas com a pandamia do COVID-19, gostaríamos de ajudar todos a se manterem informados do aumento do número de casos da doença em determinado país.

Já existem outras APIs que podem nos ajudar, fornecendo dados sobre o número de casos no país. Um exemplo é a [disease.sh](https://disease.sh/docs/#/COVID-19%3A%20Worldometers), que já entrega os dados filtrados por país, através do seguinte endpoint: `/v3/covid-19/countries/{country}`.

Sendo assim, gostaríamos que você construísse um sistema de notificação para o aumento de casos de COVID-19 em determinado país.

Vamos aos detalhes do desafio.


## Detalhes

Gostaríamos que você implementasse as operações CRUD de uma simples tabela, que armazenará as configurações da notificação. Construa as seguintes operações:

* Criação
* Edição
* Recuperação
* Exclusão


Para a criação de uma notificação, gostaríamos de enviar as seguintes informações:

* País: no formato `ISO3`, exemplo: 'BRA' (Brasil)
* Diferença de casos mínima para notificação: Um número que represente quando eu quero ser notificado. Por exemplo, caso a diferença de casos de COVID-19 seja maior que 5.
* Tipo de notificação: `['EMAIL', 'TELEGRAM']`
* Destinatário da notificação: Quando o tipo for `EMAIL`, este campo deve conter um email e quanto for `TELEGRAM` este campo deve conter o `chat_id` do telegram a ser notificado.
* Tempo de intervalo a cada interação: `60000` tempo em milisegundos. Exemplo, gostaria de ser notificado a cada 1 segundo = `60000` milisegundos, ou a cada 3 segundos = `180000` milisegundos...

O body ficaria da seguinte maneira:

```
{
        "country": "BRA",
        "count_difference": 5,
        "notification_type": "EMAIL",
        "notification_destination": "test@test.com",
        "notification_loop": 1
}
```

Regras:

* A consulta na API deve ser feita pelo país cadastrado. Exemplo: No cadastro está `BRA`, a consulta na [API](https://disease.sh/docs/#/COVID-19%3A%20Worldometers), deve ser feita passando `BRA` como parâmetro.
* Após o cadastro de uma notificação, o processamento já deve ser começado e a cada tempo de notificação a execução deve começar novamente.
   * Como não haverá dados para comparação na primeira execução, a notificação deverá acontecer informando 'COVID Notification: Processo iniciado'.
* A cada execução, deve se comparar o valor de casos, na [API](https://disease.sh/docs/#/COVID-19%3A%20Worldometers) está com o nome `cases`, com a última execução concluída com sucesso. Caso a diferença seja maior ou igual a quandidade de diferença definida no cadastro, deve ser executado o fluxo de notificação.

## Notificações

Não será necessário implementar de fato os dois tipo de notificação, EMAIL e [TELEGRAM](https://telegram.org/), com o intuito de otimizar o tempo, você pode optar por implementar o envio de email **OU** um bot no [telegram](https://telegram.org/).

## Teste

Crie todos os testes necessários
* Teste unitário
* Teste de integração

E outros que achar necessário.

## O que avaliaremos

Como um bom engenheiro de software, você deve mostrar capaz de entregar um código:

* Funcional e sem bugs: avaliaremos se o seu código funciona de acordo com as especificações acima
* Legível: seu código deve ser fácil de enteder, respeitando regras como identação, nomenclatura correta e variáveis e classes, etc.
* Escalável: nos preocuparemos com a performance do seu código. Fique atento a problemas como loops dentro de loops (O(N^2)) e concorrência.
* Testado: testes estão no nosso dia-a-dia. Analisaremos sua capacidade de criar testes bem escritos e que ajudem a capturar bugs.
* De alta qualidade: boas práticas de programação são muito importante, como os princípios SOLID e outros design patterns que façam sentido.

## Diferenciais

* A aplicação, no nosso ponto de vista, não é muito grande, o desenvolvimento pode ser em uma arquitetua monolítica ou de microserviço. Será considerado um diferencial a utilização de um microserviço para cadastro e outro para as notificações.
* Aplicação rodando em container
* Documentação
   * De código
   * Da API
* Qualidade de código
* Circuit breaker
* Retry caso uma chamada HTTP falhe.


Seja criativo! Features extras que não pensamos ou formas diferentes de se resolver problemas serão vistas com bons olhos!

Você precisa criar um repositório público no GitHub ou outros.

Boa Sorte.
