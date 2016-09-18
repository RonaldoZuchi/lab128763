package modelo;

import java.io.Serializable;

public class Entrega implements Serializable{

	private static final long serialVersionUID = -8098902534450838983L;
	private String endreco;

	public String getEndreco() {
		return endreco;
	}

	public void setEndreco(String endreco) {
		this.endreco = endreco;
	}
}