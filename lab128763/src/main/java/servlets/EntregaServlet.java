package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ProcessaEntrega;
import modelo.Entrega;
import modelo.Venda;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@JMSDestinationDefinitions(
	    value = {
	        @JMSDestinationDefinition(
	            name = "java:/queue/ENTREGAfila",
	            interfaceName = "javax.jms.Queue",
	            destinationName = "EntregaFila"
	        ),
	        @JMSDestinationDefinition(
	            name = "java:/topic/ENTREGAtopico",
	            interfaceName = "javax.jms.Topic",
	            destinationName = "EntregaTopico"
	        )
	    })

@WebServlet("/entrega")
public class EntregaServlet extends HttpServlet {

	private static final long serialVersionUID = 3753765883982135195L;
	private static final int CONTADOR = 5;

	@EJB
	ProcessaEntrega processarEntrega;

	@Inject
	private JMSContext contexto;

	@Resource(lookup = "java:/queue/ENTREGAfila")
	private Queue fila;

	@Resource(lookup = "java:/topic/ENTREGAtopico")
	private Topic topico;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Venda venda = new Venda();
		venda.setItens("Jarro");
		venda.setQuantidade(10);

		Entrega entrega = new Entrega();
		entrega.setEndreco("Rua das Couves");

		processarEntrega.processandoEntrega(entrega);

		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.write("<h1> Entrega /entrega </h1>");
	}
}