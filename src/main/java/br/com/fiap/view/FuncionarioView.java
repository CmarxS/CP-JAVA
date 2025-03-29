package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncionarioView {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = emf.createEntityManager();
        FuncionarioDAO dao = new FuncionarioDAO(em);
        Funcionario funcionario = new Funcionario("Caio", 40, 20.00);

        //Registrando o funcionario 'CREATE'
        try {
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.println("Funcionario cadastrado!");
            funcionario.mostrarInformacoesDoUsuario();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o funcionario!" + e.getMessage());
        }

        //Atualizando o funcionario 'UPDATE'
        try {
            funcionario.setNome("Caio Marques");
            dao.atualizar(funcionario);
            dao.commit();
            System.out.println("Funcionario atualizado!");
            funcionario.mostrarInformacoesDoUsuario();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o funcionario!" + e.getMessage());
        }

        //Procurando o funcionario 'SELECT'
        try {
            Funcionario funcionarioEncontrado = dao.buscarPorId(funcionario.getId());
            System.out.println("Funcionario encontrado!");
            funcionarioEncontrado.mostrarInformacoesDoUsuario();
        } catch (Exception e) {
            System.out.println("Erro ao procurar o funcionario!" + e.getMessage());
        }

        //Removendo o funcionario 'DELETE'
        try {
            dao.remover(funcionario.getId());
            dao.commit();
            System.out.println("Funcionario removido!");
        } catch (Exception e) {
            System.out.println("Erro ao remover o funcionario!" + e.getMessage());
        }


    }
}
