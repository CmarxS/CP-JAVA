package br.com.fiap.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Senior extends Funcionario {
    private static final double BONUS = 1000;

    public Senior() {
    }

    public Senior(String nome, int horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularSalarioFinal() {
    //o bonus será a cada 15 horas trabalhadas
        return getHorasTrabalhadas() * getValorHora() + (getHorasTrabalhadas() / 15) * BONUS;
    }

    @Override
    public void mostrarInformacoesDoUsuario() {
        System.out.println("Nome: " + getNome() + "\nHoras trabalhadas: " + getHorasTrabalhadas() + "\nValor da hora: " + getValorHora() + "\nSalário final: " + calcularSalarioFinal());
    }
}
