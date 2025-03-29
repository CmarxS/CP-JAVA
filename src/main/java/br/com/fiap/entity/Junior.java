package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("J")
public class Junior extends Funcionario {
    private final static double desconto = 0.1;
    private final static double valeTransporte = 200;
    private final static double valeRefeicao = 800;

    public Junior() {
    }

    public Junior(String nome, int horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }


    @Override
    public double calcularSalarioFinal() {
        return (getHorasTrabalhadas() * getValorHora()) - (getHorasTrabalhadas() * getValorHora() * desconto) + valeTransporte + valeRefeicao;
    }

    @Override
    public void mostrarInformacoesDoUsuario() {
        System.out.println("Nome: " + getNome() +
                "\nHoras trabalhadas: " + getHorasTrabalhadas() +
                "\nValor da hora: " + getValorHora() +
                "\nDesconto: " + desconto +
                "\nVale Transporte: " + valeTransporte +
                "\nVale Refeição: " + valeRefeicao +
                "\nSalário final: " + calcularSalarioFinal());
    }
}
