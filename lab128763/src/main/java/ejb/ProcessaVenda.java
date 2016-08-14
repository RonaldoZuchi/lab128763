package ejb;

import javax.ejb.Stateless;

import modelo.Venda;

import javax.ejb.LocalBean;
import java.io.Serializable;

@Stateless
@LocalBean
public class ProcessaVenda implements Serializable {

	private static final long serialVersionUID = -1L;

	public void processaVenda(Venda venda){

	}

}