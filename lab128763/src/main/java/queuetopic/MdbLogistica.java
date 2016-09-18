package queuetopic;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import modelo.Entrega;

@MessageDriven(name = "MdbLogistica", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/ENTREGAfila"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MdbLogistica implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(MdbLogistica.class.toString());

	@Override
	public void onMessage(Message arg0) {

		ObjectMessage mensagem = (ObjectMessage) arg0;

        try {
            if (arg0 instanceof TextMessage) {
            	Entrega entrega = (Entrega) mensagem.getObject();
            	LOGGER.info(MdbLogistica.class.toString());
            	Thread.sleep(3000);
            	LOGGER.info("Enviado");
            } else {
                LOGGER.warning("Message of wrong type: " + arg0.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e){
        	e.printStackTrace();
        }

	}

}
