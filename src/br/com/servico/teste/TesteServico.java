package br.com.servico.teste;

import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

import br.com.dao.ContaDAO;
import br.com.entity.Conta;
import junit.framework.TestCase;

public class TesteServico extends TestCase {

	@Test
	public void test() throws Exception {
		Conta conta = new Conta();
		conta.setAgencia("0007-5");
		conta.setContaNum("1592-x");
		conta.setSaldo(100);
		conta.setInstituicaoBancariaNome("Banco do Pais");
		conta.setUsuarioNome("Usuario de Teste da Silva");
		
		ContaDAO.getInstance().persistTestData(conta);
		Conta contaRetrivied = ContaDAO.getInstance().find(conta);
		assertNotNull(contaRetrivied);		
	}

}
