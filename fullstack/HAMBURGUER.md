# Hamburgueria

Oi 
Tudo bem?
 
Conforme falamos para avançar no processo seletivo, nossa próxima etapa é uma avaliação técnica do seu código. \o/

## Descrição

Somos uma startup do ramo de alimentos e precisamos de uma aplicação web para gerir nosso negócio. Nossa especialidade é a venda de lanches, de modo que alguns lanches são opções de cardápio e outros podem conter ingredientes personalizados.
 
A seguir, apresentamos a lista de ingredientes disponíveis:

| Ingredientes               | Valor     |
|:---------------------------| :-------- |
| Alface                     | R$ 0,40   |
| Bacon                      | R$ 2,00   |
| Hambúrguer de carne        | R$ 3,00   |
| Ovo                        | R$ 0,80   |
| Queijo                     | R$ 1,50   |

Segue as opções de cardápio e seus respectivos ingredientes:

| Lanche                     | Ingredientes                             |
|:---------------------------| :--------------------------------------- |
| X-Bacon                    | Bacon, hambúrguer de carne e queijo      |
| X-Burger                   | Hambúrguer de carne e queijo             |
| X-Egg                      | Ovo, hambúrguer de carne e queijo        |
| X-Egg Bacon                | Ovo, bacon, hambúrguer de carne e queijo |

O valor de cada opção do cardápio é dado pela soma dos ingredientes que compõem o lanche. Além destas opções, o cliente pode personalizar seu lanche e escolher os ingredientes que desejar. Nesse caso, o preço do lanche também será calculado pela soma dos ingredientes.
 
Existe uma exceção à regra para o cálculo de preço, quando o lanche pertencer à uma promoção. A seguir, apresentamos a lista de promoções e suas respectivas regras de negócio:

| Promoção        | Regra de negócio                                                                                                            |
|:----------------| :-------------------------------------------------------------------------------------------------------------------------- |
| Light           | Se o lanche tem alface e não tem bacon, ganha 10% de desconto.                                                              |
| Muita carne     | A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...          |
| Muito queijo    | A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...         |
| Inflação        | Os valores dos ingredientes são alterados com frequência e não gastaríamos que isso influenciasse nos testes automatizados. |


## Critérios de completude
 
O projeto deve ser entregue atendendo aos seguintes critérios:

* O server-side deve ser desenvolvido em uma linguagem que se sinta confortável em utilizar no **backend**.
* O client-side pode ser desenvolvido utilizando uma linguagem e/ou framework que se sinta confortável em utilizar no **frontend**.
* Deve possuir cobertura de testes automatizados para os seguintes pontos:  Valor dos lanches de cardápio, regra para cálculo de preço e promoções.
* Não é necessário se preocupar com a autenticação dos usuários.Não é necessário persistir os dados em um banco, pode fazer armazenamento em memória.

## Entregáveis

Você deve entregar um conjunto de artefatos, de acordo com o nível de complexidade que achar melhor. A seguir, os níveis de complexidade e seus respectivos entregáveis:

* ### Fácil
    * Implementação dos requisitos;
    * Instruções para executar.

* ### Médio
    * Implementação dos requisitos;
    * Relatório de justificativas para escolha do design de código;
    * Instruções para executar.

* ### Difícil
    * Implementação dos requisitos;
    * Relatório de justificativas para escolha do design de código;
    * Os testes automatizados devem ser executados por algum modelo de integração contínua;
    * O ambiente de execução da aplicação deve possuir um HTTP Proxying com nginx, redireciendo as requisições da porta 80 para o server-side.
    * Ambiente virtualizado em Docker com scripts para execução


O código deve estar em um repositório público
