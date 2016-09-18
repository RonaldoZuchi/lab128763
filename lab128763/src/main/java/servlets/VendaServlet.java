package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ProcessaVenda;
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
	            name = "java:/queue/VENDAfila",
	            interfaceName = "javax.jms.Queue",
	            destinationName = "VendaFila"
	        ),
	        @JMSDestinationDefinition(
	            name = "java:/topic/VENDAtopico",
	            interfaceName = "javax.jms.Topic",
	            destinationName = "VendaTopico"
	        )
	    })

@WebServlet("/venda")
public class VendaServlet extends HttpServlet {

	private static final long serialVersionUID = 6469719185807035031L;
	private static final int CONTADOR = 5;

	@EJB
	ProcessaVenda processarVenda;

	@Inject
	private JMSContext contexto;

	@Resource(lookup = "java:/queue/VENDAfila")
	private Queue fila;

	@Resource(lookup = "java:/topic/VENDAtopico")
	private Topic topico;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Venda venda = new Venda();
		venda.setItens("Jarro");
		venda.setQuantidade(10);

		Entrega entrega = new Entrega();
		entrega.setEndreco("Rua das Couves");

		processarVenda.processaVenda(venda);

		response.setContentType("text/html"	);
		PrintWriter saida = response.getWriter();
		saida.write("<h1> Venda /venda </h1>");

	}
}