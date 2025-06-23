package it.formazione.model;

import java.sql.Date;

public class Autore {
    private long idAutore;
    private String nominativo;
    private java.sql.Date dataDiNascita;

    public long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(long idAutore) {
        this.idAutore = idAutore;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
