package queuetopic;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "ClasseTopic", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/CLASSEtopic"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class ClasseTopic implements MessageListener{

	private final static Logger LOGGER = Logger.getLogger(ClasseTopic.class.toString());

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}
