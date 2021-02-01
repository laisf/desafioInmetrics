  #language: pt
# encoding: utf8

  Funcionalidade: Cadastrar usuario com Post da documentacao api
    Cenario: Cadastrar Usuario
      Dado que acesso a documentacao api "1"
      Quando executo o endpoint /emprego/cadastrar de Post
      Entao retorna o codigo de sucesso "200"