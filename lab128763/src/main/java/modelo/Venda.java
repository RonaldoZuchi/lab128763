package modelo;

import java.io.Serializable;

public class Venda implements Serializable{

	private static final long serialVersionUID = -1643782299859833939L;
	private String itens;
	private int quantidade;

	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}