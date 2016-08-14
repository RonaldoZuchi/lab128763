package queuetopic;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MdbLogistica", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/MDBLogistica"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MdbLogistica implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(MdbLogistica.class.toString());

	@Override
	public void onMessage(Message arg0) {

        TextMessage msg = null;
        try {
            if (arg0 instanceof TextMessage) {
                msg = (TextMessage) arg0;
                LOGGER.info("Received Message from queue: " + msg.getText());
                LOGGER.info("Processando");
                for (int i=0; i<1; i++){
                	LOGGER.info(".");
                	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
                LOGGER.info("Entrega Confirmada.");
            } else {
                LOGGER.warning("Message of wrong type: " + arg0.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

	}

}
