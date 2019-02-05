package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@NamedQuery(
	name="conta", 
	query = "SELECT * FROM conta;"
)
public class Conta {
	@Id
    @GeneratedValue(generator = "uuid")
            @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String agencia;

    private String contaNum;
        
    private String instituicaoBancariaNome;
    
    private float saldo;
    
    private String usuarioNome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaNum() {
		return contaNum;
	}

	public void setContaNum(String contaNum) {
		this.contaNum = contaNum;
	}

	public String getInstituicaoBancariaNome() {
		return instituicaoBancariaNome;
	}

	public void setInstituicaoBancariaNome(String instituicaoBancariaNome) {
		this.instituicaoBancariaNome = instituicaoBancariaNome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
      

}
