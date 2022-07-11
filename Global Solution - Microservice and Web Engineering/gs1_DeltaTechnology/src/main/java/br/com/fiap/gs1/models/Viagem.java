package br.com.fiap.gs1.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.fiap.gs1.service.CalculaDias;

@Entity
public class Viagem implements Serializable, CalculaDias {
	
	public static final int qtdeDiasIda = 260;
	public static final int qtdeDiasVolta = 260;
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDecolagem;
	
	private int durEstadia;
	
	private int quantAssento;
	
	@Pattern(regexp = "([a-zA-Z]{4}-{1}[0-9]{4})")
	private String nomeNave;
	
	private String nomePrimeiroComandante;
	
	@Pattern(regexp = "([a-zA-Z]{3}-{1}[0-9]{4}-[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1})")
	private String matriculaPrimeiroComandante;
	
	private String nomeSegundoComandante;
	
	@Pattern(regexp = "([a-zA-Z]{3}-{1}[0-9]{4}-[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1})")
	private String matriculaSegundoComandante;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataRetorno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(LocalDate dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public int getDurEstadia() {
		return durEstadia;
	}

	public void setDurEstadia(int durEstadia) {
		this.durEstadia = durEstadia;
	}

	public int getQuantAssento() {
		return quantAssento;
	}

	public void setQuantAssento(int quantAssento) {
		this.quantAssento = quantAssento;
	}

	public String getNomeNave() {
		return nomeNave;
	}

	public void setNomeNave(String nomeNave) {
		this.nomeNave = nomeNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}

	public LocalDate getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	@Override
	public boolean validaMultiplo3() {
		return this.durEstadia % 3 == 0;
	}

	@Override
	public void calculaDias() {
		this.dataRetorno = this.dataDecolagem.plusDays(this.durEstadia + qtdeDiasIda + qtdeDiasVolta);
		}
		
}




