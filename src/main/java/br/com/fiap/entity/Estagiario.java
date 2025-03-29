package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Estagiario extends Funcionario {
    private static final double bolsaAuxilio = 500;
    private static final double valeTransporte = 150;

    public Estagiario() {
    }

    public Estagiario(String nome, int horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalarioFinal() {
        return (getHorasTrabalhadas() * getValorHora()) + bolsaAuxilio + valeTransporte;
    }

    @Override
    public void mostrarInformacoesDoUsuario() {
        System.out.println("Nome: " + getNome() +
                "\nHoras trabalhadas: " + getHorasTrabalhadas() +
                "\nValor da hora: " + getValorHora() +
                "\nBolsa auxílio: " + bolsaAuxilio +
                "\nVale Transporte: " + valeTransporte +
                "\nSalário final: " + calcularSalarioFinal());
    }
}
