package ejb;

import javax.ejb.Stateless;

import modelo.Entrega;

import javax.ejb.LocalBean;
import java.io.Serializable;

@Stateless
@LocalBean
public class ProcessaEntrega implements Serializable {

	private static final long serialVersionUID = -1L;

	public void processaEntrega(Entrega entrega){

	}

}