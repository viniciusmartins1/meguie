package com.example.meguie.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    int codigo;
    String nome;
    String email;

    //Construtor para instanciação
    public Cliente() {

    }

    //Construtor para Update
    public Cliente(int _codigo, String _nome, String _email, String _senha, String _telefone, String _cpf) {
        this.nome = _nome;
        this.email = _email;
    }

    //Construtor para Insert
    public Cliente(String _nome, String _email, String _senha, String _telefone, String _cpf) {
        this.nome = _nome;
        this.email = _email;

    }

    //==================================================================================

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
