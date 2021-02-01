#language: pt
# encoding: utf8

Funcionalidade: Listar Usuario com Get da documentacao api
  Cenario: Alterar Usuario
    Dado que acesso a documentacao api "2"
    Quando executo o endpoint /empregado/list/553 de Get
    Entao lista o "nome do funcionario" com sucesso

