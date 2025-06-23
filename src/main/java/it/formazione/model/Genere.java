package it.formazione.model;

public class Genere {
    private long idGenere;
    private String nome;
    private String descrizione;

    public long getIdGenere() {
        return idGenere;
    }

    public void setIdGenere(long idGenere) {
        this.idGenere = idGenere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
