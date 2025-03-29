package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;

public class FuncionarioDAO implements IFuncionarioDAO {

    private EntityManager em;

    public FuncionarioDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException {
        buscarPorId(funcionario.getId()); //valida se existe o funcionario para atualizar
        em.merge(funcionario);
    }

    @Override
    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario buscarPorId(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null)
            throw new IdNaoEncontradoException("Funcionario nao encontrado");
        return funcionario;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
