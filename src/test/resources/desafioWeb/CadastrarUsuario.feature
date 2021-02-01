#language: pt
# encoding: utf8

Funcionalidade: Cadastro de usuario

  Cenario: Cadastro com sucesso
  Dado que acesso a pagina de login
  Quando clico em Cadastre-se
  E preencho o Usuario "Ana Maria12456"
  Quando digito a Senha "AnaMaria123" e confirmo a Senha "AnaMaria123"
  E clico em Cadastrar
  Entao o site realiza o cadastro e vai para a pagina de login

  Cenario: Cadastro com senhas diferentes
  Dado que acesso a pagina de login
  Quando clico em Cadastre-se
  E preencho o Usuario "Ana Maria"
  Quando digito a Senha "AnaMaria123" e confirmo a Senha "AnaMaria1234"
  E clico em Cadastrar
  Entao exibe a mensagem de erro: "Senhas não combinam"

  Cenario: Cadastro com nome de usuario repetido
  Dado que acesso a pagina de login
  Quando clico em Cadastre-se
  E preencho o Usuario "Ana Maria123"
  Quando digito a Senha "AnaMaria123" e confirmo a Senha "AnaMaria123"
  E clico em Cadastrar
  Entao exibe a mensagem que explica o erro: "Usuário já cadastrado"










