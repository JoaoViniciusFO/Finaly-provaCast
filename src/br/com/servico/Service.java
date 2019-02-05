package br.com.servico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import br.com.dao.ContaDAO;
import br.com.entity.Conta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Path("/main")
public class Service {
	//Criação de estrutura da documentação do swagger para o registro de nova conta.
	@ApiOperation(value = "Cria nova conta", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiResponses(@ApiResponse(code = 201, message = "Novo pagamento criado", response = Conta.class, responseHeaders = @ResponseHeader(name = "Location", description = "nova conta", response = String.class)))
	@POST
	@Path("teste")
	@Produces("application/json")
	@Consumes("application/json")
	public Conta getMsg(@ApiParam(value="Conta", name="conta") Conta conta) throws Exception {
		return ContaDAO.getInstance().persistTestData(conta);
	}

	@GET
	@Path("teste")
	@Produces("application/json")
	public List<Conta> getAllContas() {
		return ContaDAO.getInstance().findAll();
	}

}
