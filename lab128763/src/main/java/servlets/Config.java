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
@WebServlet(urlPatterns = "config")
public class Config extends HttpServlet {

	private static final long serialVersionUID = -4480557914856200427L;

    private static final int MSG_COUNT = 6;

    @Inject
    private JMSContext contexto;

    @Resource(lookup = "java:/queue/CLASSEqueue")
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
	}
}