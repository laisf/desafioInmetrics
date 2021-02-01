#language: pt
# encoding: utf8

Funcionalidade: Listar Usuario com Get All da documentacao api
  Cenario: Listar Todos os Usuarios
    Dado que acesso a documentacao api "3"
    Quando que executo o endpoint /empregado/list_all de Get All
    Entao mostra a lista com todos os funcionarios e o "condigo de ok"

