#language: pt
# encoding: utf8

Funcionalidade: Usuario

  Cenario: Login com sucesso
  Dado que entro na pagina de login
  Quando escrevo o Usuario "Ana Maria"
  E digito a Senha "AnaMaria123" e pressiono a tecla Enter
  Entao exibe a pagina de funcionarios cadastrados

  Cenario: Login Incorreto
    Dado que entro na pagina de login
    Quando escrevo o Usuario "Ana Maria"
    E digito a Senha "AnaMaria1234" e pressiono a tecla Enter
    Entao o site exibe a menssagem de "ERRO!" Usuário ou Senha inválidos




