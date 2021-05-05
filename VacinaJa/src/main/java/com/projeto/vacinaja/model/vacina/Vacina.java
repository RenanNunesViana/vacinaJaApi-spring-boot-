package com.projeto.vacinaja.model.vacina;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  US 05 - criando o objeto Vacina, seus atributos, seu repositorio e o service de seu repositorio
 */
@Entity
public class Vacina {

    @Id
    private String nomeVacina;
    private String fabicante;
    private int numeroDoses;
    private int diasEntreDoses;

    public Vacina(String nomeVacina, String fabicante, int numeroDoses, int diasEntreDoses) {
        this.nomeVacina = nomeVacina;
        this.fabicante = fabicante;
        this.numeroDoses = numeroDoses;
        this.diasEntreDoses = diasEntreDoses;
    }

    public Vacina() {
        this.nomeVacina = "";
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getFabicante() {
        return fabicante;
    }

    public void setFabicante(String fabicante) {
        this.fabicante = fabicante;
    }

    public int getNumeroDoses() {
        return numeroDoses;
    }

    public void setNumeroDoses(int numeroDoses) {
        this.numeroDoses = numeroDoses;
    }

    public int getDiasEntreDoses() {
        return diasEntreDoses;
    }

    public void setDiasEntreDoses(int diasEntreDoses) {
        this.diasEntreDoses = diasEntreDoses;
    }


    @Override
    public String toString() {
        return "Vacina{" +
                "nomeVacina='" + nomeVacina  + ",\n" +
                "fabicante='" + fabicante + ",\n" +
                "numeroDoses=" + numeroDoses + ",\n" +
                "diasEntreDoses=" + diasEntreDoses + ",\n" +
                '}';
    }
}
