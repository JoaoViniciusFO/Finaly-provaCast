package br.com.servico.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ TesteServico.class })
public class TestAll {
	public static Test suite() {
		TestSuite suite = new TestSuite("Testando os serviços simples!");
		suite.addTestSuite(TesteServico.class);
		
		return suite;
	}
}
