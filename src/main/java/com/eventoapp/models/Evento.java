package com.eventoapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 * Class Evento
 */
@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
     * Id, NotEmpty
     */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;

	/**
     * NotEmpty
     */
	@NotEmpty
	private String nome;

	/**
     * NotEmpty
     */
	@NotEmpty
	private String local;

	/**
     * NotEmpty
     */
	@NotEmpty
	private String data;

	/**
     * NotEmpty
     */
	@NotEmpty
	private String horario;
	
	/**
     * OneToMany
     */
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	public List<Convidado> convidados;
	
	/**
	 * 
	 * @param nome
	 * @param local
	 * @param data
	 * @param horario
	 */
	public Evento(String nome, String local, String data, String horario) {
		super();
        this.nome = nome;
        this.local = local;
		this.data = data;
		this.horario = horario;
    }
	/**
	 * Construtor vazio
	 */
    public Evento() {
		/**
		 * 
		 */
    }
    public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome==null || nome.isEmpty()){
            throw new RuntimeException("Informe o nome");
        }else{
            this.nome = nome;
        }
    }
		
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		if(local==null || local.isEmpty()){
            throw new RuntimeException("Informe o local");
        }else{
            this.local = local;
        }
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(data==null || data.isEmpty()){
            throw new RuntimeException("Informe a data");
        }else{
            this.data = data;
        }
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		if(horario==null || horario.isEmpty()){
            throw new RuntimeException("Informe o horario");
        }else{
            this.horario = horario;
        }
	}



}
