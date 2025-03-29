package br.com.fiap.entity;
import javax.persistence.*;


@Entity
@Table(name="TAB_FUNCIONARIO")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_TAB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {
    @Id
    @Column(name="id_funcionario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private int id;

    @Column(name="nm_funcionario", nullable = false, length = 100)
    private String nome;

    @Column(name="nr_horas_trabalhadas", nullable = false)
    private int horasTrabalhadas;

    @Column(name="vl_hora", nullable = false)
    private double valorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double calcularSalarioFinal() {
        return horasTrabalhadas * valorHora;
    }

    public void mostrarInformacoesDoUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor da hora: " + valorHora);
        System.out.println("Salário final: " + calcularSalarioFinal());
    }
}
