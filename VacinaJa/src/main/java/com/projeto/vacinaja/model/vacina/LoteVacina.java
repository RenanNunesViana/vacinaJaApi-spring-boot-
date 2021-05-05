package com.projeto.vacinaja.model.vacina;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * US 08 - criando o objeto LoteVacina, seus atributos,seu repositorio e o service do seu repositorio
 */
@Entity
public class LoteVacina {

    @Id
    @GeneratedValue
    private long numeroLote;
    @OneToOne
    private Vacina vacina;
    private int doses;
    private Date dataDeValidade;

    public LoteVacina(){
        this.numeroLote = 0;
    }

    public LoteVacina(long numeroLote, Vacina vacina, int doses, Date dataDeValidade) {
        this.numeroLote = numeroLote;
        this.vacina = vacina;
        this.doses = doses;
        this.dataDeValidade = dataDeValidade;
    }

    public long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Date dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        return "LoteVacina{" +
                "numeroLote=" + numeroLote + ",\n" +
                "vacina=" + vacina + ",\n" +
                "doses=" + doses + ",\n" +
                "dataDeValidade=" + dataDeValidade + ",\n" +
                '}';
    }
}
