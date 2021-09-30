package com.example.model;

public class Cliente {

    int codigo;
    String nome;
    String email;
    String senha;
    String telefone;
    int cpf;

    //Construtor para instanciação
    public Cliente() {

    }

    //Construtor para Update
    public Cliente(int _codigo, String _nome, String _email, String _senha, String _telefone, int _cpf) {
        this.nome = _nome;
        this.email = _email;
        this.senha = _senha;
        this.telefone = _telefone;
        this.cpf = _cpf;
    }

    //Construtor para Insert
    public Cliente(String _nome, String _email, String _senha, String _telefone, int _cpf) {
        this.nome = _nome;
        this.email = _email;
        this.senha = _senha;
        this.telefone = _telefone;
        this.cpf = _cpf;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
