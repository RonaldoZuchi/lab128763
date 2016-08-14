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

@JMSDestinationDefinitions(
	    value = {
	        @JMSDestinationDefinition(
	            name = "java:/queue/MDBLogistica",
	            interfaceName = "javax.jms.Queue",
	            destinationName = "MdbLogistica"
	        ),
	        @JMSDestinationDefinition(
	            name = "java:/topic/MDBAuditoria",
	            interfaceName = "javax.jms.Topic",
	            destinationName = "MdbAuditoria"
	        ),
	        @JMSDestinationDefinition(
		            name = "java:/topic/MDBContabilidade",
		            interfaceName = "javax.jms.Topic",
		            destinationName = "MdbContabilidade"
		        ),
	        @JMSDestinationDefinition(
		            name = "java:/topic/MDBFinanceiro",
		            interfaceName = "javax.jms.Topic",
		            destinationName = "MdbFinanceiro"
		        ),
	        @JMSDestinationDefinition(
		            name = "java:/topic/MDBLog",
		            interfaceName = "javax.jms.Topic",
		            destinationName = "MdbLog"
		        ),
	        @JMSDestinationDefinition(
		            name = "java:/topic/MDBVenda",
		            interfaceName = "javax.jms.Topic",
		            destinationName = "MdbVenda"
		        )
	    })
@WebServlet("/Config")
public class Config extends HttpServlet {

	private static final long serialVersionUID = -4480557914856200427L;

    private static final int MSG_COUNT = 6;

    @Inject
    private JMSContext contexto;

    @Resource(lookup = "java:/queue/MDBLogistica")
    private Queue queuePedido;

    @Resource(lookup = "java:/topic/MDBAuditoria")
    private Topic topicAuditoria;

    @Resource(lookup = "java:/topic/MDBContabilidade")
    private Topic topicContabilidade;

    @Resource(lookup = "java:/topic/MDBFinanceiro")
    private Topic topicFinanceiro;

    @Resource(lookup = "java:/topic/MDBLog")
    private Topic topicLog;

    @Resource(lookup = "java:/topic/MDBVenda")
    private Topic topicVenda;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Quickstart: Example demonstrates the use of <strong>JMS 2.0</strong> and <strong>EJB 3.2 Message-Driven Bean</strong> in WildFly 8.</h1>");
        try {
            boolean useTopic = request.getParameterMap().keySet().contains("topic");
            final Destination destination = useTopic ? topicVenda : queuePedido;

            out.write("<p>Sending messages to <em>" + destination + "</em></p>");
            out.write("<h2>Following messages will be send to the destination:</h2>");
            for (int i = 0; i < MSG_COUNT; i++) {
                String text = "This is message " + (i + 1);
                contexto.createProducer().send(destination, text);
                out.write("Message (" + i + "): " + text + "</br>");
            }
            out.write("<p><i>Go to your WildFly Server console or Server log to see the result of messages processing</i></p>");
        } finally {
            if (out != null) {
                out.close();
            }
        }
	}
}