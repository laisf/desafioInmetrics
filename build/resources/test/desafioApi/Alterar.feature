#language: pt
# encoding: utf8

 Funcionalidade: Alterar Usuario com Put da documentacao api
   Cenario: Alterar Usuario
     Dado que acesso a documentacao api "4"
     Quando executo o endpoint /alterar/553 de Put
     Entao retorna o codigo de sucesso "200"

