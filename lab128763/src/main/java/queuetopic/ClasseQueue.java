package queuetopic;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "ClasseQueue", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/CLASSEqueue"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class ClasseQueue implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(ClasseQueue.class.toString());

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}
