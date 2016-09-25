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
import ejb.ProcessaVenda;
import modelo.Entrega;
import modelo.Venda;

@WebService
public class WebVenda {

	@EJB
	ProcessaVenda processarVenda;

	@WebMethod(operationName="operacaoDoGetVenda")
	@WebResult(name="resultadoVenda")
	protected void doGet(@WebParam(name="parReq")HttpServletRequest req, @WebParam(name="parResp") HttpServletResponse resp) throws IOException{
		System.out.println("Iniciando");
		Venda venda = new Venda();
		venda.setItens("Ovo");
		venda.setQuantidade(12);
		System.out.println("Iniciando a Venda");
		processarVenda.processaVenda(venda);;
		resp.setContentType("text/html");
		PrintWriter saida = resp.getWriter();
		saida.write("<p>Venda Realizada</p>");
	}

}
