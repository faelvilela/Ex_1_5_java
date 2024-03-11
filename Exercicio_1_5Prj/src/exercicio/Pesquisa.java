package exercicio;

import java.util.List;
import java.util.ListIterator;

public class Pesquisa extends Thread{
	
	private List<Integer> lista;
	private int elemento;
	private boolean direto;
	private Pesquisa colega;
	
	private boolean encontrado = false;
	
	public Pesquisa(List<Integer> lista, int elemento, boolean direto) {
		super();
		this.lista = lista;
		this.elemento = elemento;
		this.direto = direto;
	}
	
	public void setColega(Pesquisa colega) {
		this.colega = colega;
	}
	
	//Get
	public boolean isEncontrado() {
		return encontrado;
	}

	public void run() {
		ListIterator<Integer> it = lista.listIterator(direto ? 0 : lista.size());
		
		encontrado = false;
		if (direto) {
			// Pesquisando do inicio para o final
			while(it.hasNext()) {
				if (this.isInterrupted())
					break;
				int e = it.next();
				if (elemento == e) {
					colega.interrupt();
					encontrado = true;
					break;
				}
			}
		}
		else {
			// Pesquisando do final para o inicio
			while(it.hasPrevious()) {
				if (this.isInterrupted())
					break;
				int e = it.previous();
				if (elemento == e) {
					colega.interrupt();
					encontrado = true;
					break;
				}
			}
		}
		
	}

}
