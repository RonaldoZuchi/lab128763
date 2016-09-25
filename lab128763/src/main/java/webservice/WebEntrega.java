package webservice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.ProcessaEntrega;
import modelo.Entrega;

@WebService
public class WebEntrega {

	@EJB
	ProcessaEntrega processarEntrega;

	@WebMethod(operationName="operacaoDoGetEntrega")
	@WebResult(name="resultadoEntrega")
	protected void doGet(@WebParam(name="parReq")HttpServletRequest req, @WebParam(name="parResp") HttpServletResponse resp) throws IOException{
		System.out.println("Iniciando");
		Entrega entrega = new Entrega();
		entrega.setEndreco("Rua das Couves");
		System.out.println("Iniciando a Entrega");
		processarEntrega.processandoEntrega(entrega);
		resp.setContentType("text/html");
		PrintWriter saida = resp.getWriter();
		saida.write("<p>Entrega Realizada</p>");
	}

}
