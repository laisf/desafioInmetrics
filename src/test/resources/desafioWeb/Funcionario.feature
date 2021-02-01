#language: pt
# encoding: utf8

Funcionalidade: Funcionario

  Esquema do Cenario: Cadastrar Usuario
  Dado que acesso o site de login
  Quando digito o Usuario "Ana Maria"
  E escrevo a Senha "AnaMaria123" e pressiono a tecla Enter
  Entao exibe a pagina de funcionarios que estao cadastrados
  Quando clico em Novo Funcionario
  E preencho <nome> e <cpf> e <sexo> e <admissao> e <cargo> e <salario> e <tipo de contratacao>
  E clico em Enviar
  Entao o cadastro e feito com sucesso
  Exemplos:
    |     nome         |     cpf        |   sexo   |  admissao  |        cargo      | salario |tipo de contratacao|
    |"ana lura Peixoto"|"958.769.788-09"|"feminino"|"20/01/2020"|"Analista de Infra"|"2500,00"|       "clt"       |

  Cenario: Editar Funcionario
    Dado que abro na pagina de login
    Quando preencho o campo Usuario com "Ana Maria"
    E digito Senha "AnaMaria123" e pressiono a tecla Enter
    Quando clico em Funcionario
    E seleciono o botao amarelo de Editar do nome "ana lura Peixoto" da lista
    Quando exibe a pagina de cadastro
    E altero o nome para "Ana Laura Peixoto" em Enviar
    Entao atualiza as informacoes com sucesso

  Cenario: Excluir Funcionario
    Dado que abro na pagina de login
    Quando preencho o campo Usuario com "Ana Maria"
    E digito Senha "AnaMaria123" e pressiono a tecla Enter
    Quando clico em Funcionario
    E seleciono o botao vermelho de Excluir do segundo nome "Ana Laura Peixoto" da lista
    Entao remove o funcionario com sucesso



