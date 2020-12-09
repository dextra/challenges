
# Logue o usuário

Olá! Obrigado por ter se aplicado para essa vaga, esperamos que você aprenda algo novo.

O principal objetivo desde desafio é ver como você trabalha e como soluciona problemas.

Então, vamos começar.

Queremos que você desenvolva um pequeno aplicativo para executar o caso de uso descrito abaixo.

Tela de Login

Desenhe as telas seguindo o layout abaixo:



![](https://lh4.googleusercontent.com/wjmUl96CYroZGG0795qwPjSdEuERLq-rj12GSnsOVUi_az4bu-IX2j3DDw34rGEm226OKE5oqKEx6YQYZ4j_3iXNeB_2oRak4eQ4dIpABdgpaT-JAJQqO-MqUbEezSOt88aTAx5C)  ![](https://lh6.googleusercontent.com/9Jj1v5Lq5pw9e95YsPs7OnUT6ghUy46EQYQsCjuThAlHjsBJ06A5epuOvtLZaQTwVFMuxq7cdw4c5x4Hi14K8-2wEnxvYbYEp7pk4T9ywaRgZbszCZj25Wyc5WxXPDTGsORfkXlu)


Caso de Uso: Logar Usuário

Um usuário efetua o login no aplicativo para acessar suas funcionalidades.

Fluxo Principal

1. Usuário abre o aplicativo

2. Aplicativo direciona usuário para a tela de login

3. Usuário preenche os dados do formulário

4. Usuário pressiona o botão "Login"

5. Aplicativo valida os campos preenchidos, segundo as regras de negócio

6. Aplicativo envia os dados do usuário ao servidor

7. Aplicativo direciona usuário para a tela home

Fluxos Alternativos

	5.1. Existem campos não preenchidos

		5.1.1. Aplicativo exibe a mensagem: "Todos os campos são obrigatórios"

		5.1.2. Usuário preenche os campos inválidos e tenta novamente o envio


	5.2. Existem campos com valores inválidos

		5.2.1. Aplicativo exibe mensagem específica ao usuário

		5.2.2. Usuário preenche os campos inválidos e tenta novamente o envio


	6.1. Ocorreu um erro ao enviar os dados ao servidor

		6.1.1. Aplicativo exibe a mensagem ao usuário: "Ocorreu um erro ao efetuar o login. Verifique sua conexão e tente novamente."

		6.1.2. Usuário fica livre para clicar em "Login" novamente


Regras de Negócio

-   O formulário deve possuir os seguintes campos:
-   E-mail
-   Senha
-   Todos os campos do formulário são obrigatórios
-   O e-mail do usuário deve seguir o padrão válido de endereços de e-mail


Requisitos de UI

-   Quando os valores inseridos nos campos forem inválidos, deve-se exibir as mensagens de erro conforme os cenários abaixo (cenário: mensagem):
-   E-mail inválido: "E-mail inválido"
-   Senha ou E-mail em branco: "Campo Obrigatório"
-   Enquanto a requisição de login estiver em andamento o aplicativo deve:
-   Exibir um Activity Indicator/Progress Bar na tela para indicar o carregamento da solicitação.
-   Bloquear a edição dos campos do formulário e o botão de login
-   No campo "Email": Utilizar o teclado de e-mails
-   No campo "Senha": Deve ter seus caracteres protegidos.


Home

-   Ao abrir a tela home, exibir ao usuário uma mensagem dizendo: "Olá, <nome do usuário retornado na request anterior>"

Requisição de Login

```
Método: POST

Endpoint:  <definir>

Body:

{

	"email" : "usuario@teste.com",

	"password" : "R123ayay",

}
```

Responses:

Sucesso:

```
{

	userId: "<id do usuário>

	userName: "<nome do usuário>"

}
```

Erro:

<definir>

Critérios de avaliação

Determine uma arquitetura organizada e bem definida como se tivesse fazendo um projeto real.

Não esqueça de fazer os testes unitários.

Testes de tela serão considerados um ponto extra.

Crashes ao inicializar ou não funcionamento em fluxos básicos serão considerados eliminatórios, portanto teste antes de enviar.

Capriche e faça como se estivesse de fato trabalhando em um projeto para Dextra. A idéia desse teste é conseguir conhecer um pouquinho da sua forma de trabalhar.


Envio do projeto pronto

Nos envie o link do projeto git do seu teste.

Para testes de Android pode ainda fazer o upload do .apk no Google Drive e compartilhe conosco. (Lembre-se de deixar o link compartilhado para todos).



Boa sorte !! ;)
