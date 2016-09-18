package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
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

//@JMSDestinationDefinitions(
//	    value = {
//	        @JMSDestinationDefinition(
//	            name = "java:/queue/ENTREGAfila",
//	            interfaceName = "javax.jms.Queue",
//	            destinationName = "EntregaFila"
//	        ),
//	        @JMSDestinationDefinition(
//	            name = "java:/topic/VENDAtopic",
//	            interfaceName = "javax.jms.Topic",
//	            destinationName = "VendaTopico"
//	        )
//	    })
@WebServlet("/Config")
public class Config extends HttpServlet {

//	@Resource
//	private Queue entregafila;

//	@Resource
//	private Topic vendatopico;


}