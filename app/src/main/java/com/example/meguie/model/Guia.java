package com.example.meguie.model;

public class Guia {

    private int idGuia;
    private String nome;
    private int imagem;

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Guia() {
    }


    public Guia(int imagem,String nome) {

        this.imagem=imagem;
        this.nome=nome;

    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return nome;
    }
}
