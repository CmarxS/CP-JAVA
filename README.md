Relatório do Projeto - Sistema de Gestão de Funcionários
  ● Integrantes do Grupo:
  ● Caio Marques - RM 555997
  ● Felipe Camargo - RM 556325
  ● Caio Amarante - RM 558640
  ● Leonardo Salazar - RM 557484
  ● Alexsandro Macedo - RM 557068
Introdução
Este relatório tem como objetivo explicar o funcionamento do sistema de gestão de
funcionários desenvolvido, abordando as principais funcionalidades implementadas, a
estrutura do código.
Estrutura do Projeto
O projeto foi desenvolvido utilizando a linguagem Java e JPA para manipulação do banco
de dados. Abaixo estão detalhadas as principais classes e interfaces do sistema.
Interface FuncionarioDAO
Define os métodos essenciais para a manipulação dos objetos Funcionario no banco de
dados:
  ● cadastrar(Funcionario): Adiciona um novo funcionário.
  ● atualizar(Funcionario): Atualiza um funcionário existente.
  ● remover(id): Remove um funcionário pelo ID.
  ● buscarPorId(id): Busca um funcionário pelo ID.
  ● commit(): Confirma as operações no banco de dados.
Classe FuncionarioDAO
Implementa a interface IFuncionarioDAO, utilizando um EntityManager para realizar
as operações no banco de dados. Os métodos incluem:
  ● cadastrar: Persiste um novo funcionário no banco de dados.
  ● atualizar: Atualiza os dados de um funcionário já existente.
  ● remover: Busca e remove um funcionário pelo ID.
  ● buscarPorId: Retorna um funcionário pelo ID.
  ● commit: Garante que as transações sejam confirmadas ou revertidas em caso de
  erro.
2.
Classe Funcionario
Representa um funcionário com os seguintes atributos:
  ● id (chave primária)
  ● nome
  ● horasTrabalhadas
  ● valorHora
Métodos principais:
  ● calcularSalarioFinal(): Calcula o salário com base nas horas trabalhadas e
no valor por hora.
  ● mostrarInformacoesDoUsuario(): Exibe as informações do funcionário.
Classes Estagiario, Junior e Senior
Essas classes herdam de Funcionario, implementando regras específicas para o cálculo
do salário:
  ● Estagiário: Adiciona bolsa-auxílio e vale-transporte fixos.
  ● Junior: Aplica desconto sobre o salário e adiciona benefícios.
  ● Senior: Adiciona um bônus a cada 15 horas trabalhadas.
3. Pacote
Define exceções personalizadas para tratamento de erros:
  ● CommitException: Lida com falhas ao confirmar transações.
  ● IdNaoEncontradoException: Indica quando um ID não é encontrado no banco
  de dados.
4. Pacote
Contém a classe FuncionarioView, que realiza testes das operações CRUD:
  1. Cadastra um novo funcionário.
  2. Atualiza os dados do funcionário.
  3. Busca um funcionário pelo ID.
  4. Remove um funcionário pelo ID.
Simulação do Sistema
Cadastro de Funcionário
(FOTO)
Atualização de Funcionário
(FOTO)
Busca de Funcionário
(FOTO)
Remoção de Funcionário
(FOTO)
Conclusão
O sistema desenvolvido fornece uma solução eficiente para a gestão de funcionários,
permitindo realizar as operações essenciais de forma segura e organizada. O uso do JPA
facilita a interação com o banco de dados.
