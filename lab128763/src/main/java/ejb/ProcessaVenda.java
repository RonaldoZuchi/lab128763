package ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

import modelo.Venda;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Remote;

import java.io.Serializable;

@Stateless
@Remote
public class ProcessaVenda implements Serializable {

	private static final long serialVersionUID = -1L;

	@Inject
	private JMSContext contexto;

	@Resource(lookup = "java:/topic/VENDAtopico")
	private Topic topico;

	public void processaVenda(Venda venda){

		System.out.println("Recebendo Venda");
		final Destination destino = topico;

		try {

			System.out.println("Processando Venda");
			ObjectMessage objeto = contexto.createObjectMessage();
			objeto.setObject(venda);
			System.out.println("Finalizando Venda");
			contexto.createProducer().send(destino, objeto);

		} catch (Exception e){
			e.printStackTrace();
		}

	}

}