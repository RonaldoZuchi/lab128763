package queuetopic;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import modelo.Venda;

@MessageDriven(name = "MdbAuditoria", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/VENDAtopico"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MdbAuditoria implements MessageListener{

	private final static Logger LOGGER = Logger.getLogger(MdbAuditoria.class.toString());

	@Override
	public void onMessage(Message arg0) {

		ObjectMessage mensagem = (ObjectMessage) arg0;

		try{
			if(arg0 instanceof TextMessage){
				Venda venda = (Venda) mensagem.getObject();
				LOGGER.info(MdbAuditoria.class.toString());
			} else {
				LOGGER.info("Mensagem Recebida do Topico " + arg0.getClass().getName());
			}
		} catch(JMSException e){
			throw new RuntimeException(e);
		}
	}
}
