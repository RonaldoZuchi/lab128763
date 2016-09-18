package ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import modelo.Entrega;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Remote;

import java.io.Serializable;

@Stateless
public class ProcessaEntrega implements Serializable {

	private static final long serialVersionUID = -1L;

	@Inject
	private JMSContext contexto;

	@Resource(lookup = "java:/queue/ENTREGAfila")
	private Queue fila;


	public void processandoEntrega(Entrega entrega){

		System.out.println("Informando Entrega ");
		final Destination destino = fila;

		try{

			System.out.println("Processando");
			ObjectMessage objeto = contexto.createObjectMessage();
			objeto.setObject(entrega);
			System.out.println("Finalizando o Processamento");
			contexto.createProducer().send(destino, objeto);

		} catch (Exception e){
				e.printStackTrace();
		}

	}


}