package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.ServletException;
import java.io.IOException;

@JMSDestinationDefinitions(
	    value = {
	        @JMSDestinationDefinition(
	            name = "java:/queue/CLASSEqueue",
	            interfaceName = "javax.jms.Queue",
	            destinationName = "ClasseQueue"
	        ),
	        @JMSDestinationDefinition(
	            name = "java:/topic/CLASSEtopic",
	            interfaceName = "javax.jms.Topic",
	            destinationName = "ClasseTopic"
	        )
	    })
@WebServlet(urlPatterns = "config")
public class Config extends HttpServlet {

	private static final long serialVersionUID = -4480557914856200427L;

    private static final int MSG_COUNT = 6;

    @Inject
    private JMSContext contexto;

    @Resource(lookup = "java:/queue/CLASSEqueue")
    private Queue queuePedido;

    @Resource(lookup = "java:/topic/CLASSEtopic")
    private Topic topicVenda;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}