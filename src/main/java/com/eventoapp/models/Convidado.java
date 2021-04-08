package com.eventoapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 * Class Convidado
 */
@Entity
public class Convidado {

    /**
     * Id, NotEmpty
     */
   @Id
   @NotEmpty
    private String cpf;

    /**
     * NotEmpty
     */
    @NotEmpty
    private String nomeConvidado;

    /**
     * ManyToOne
     */
    @ManyToOne
    private Evento evento;

    public String getCpf() {
        return cpf;
    }
    public String getNomeConvidado() {
        return nomeConvidado;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setNomeConvidado(String nomeConvidado) {
        if(nomeConvidado==null || nomeConvidado.isEmpty()){
            throw new RuntimeException("Informe o nome do convidado");
        }else{
            this.nomeConvidado = nomeConvidado;
        }
    }
    public void setCpf(String cpf) {
        if(cpf==null || cpf.isEmpty()){
            throw new RuntimeException("Informe o cpf do convidado");
        }else{
            this.cpf = cpf;
        }
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}
