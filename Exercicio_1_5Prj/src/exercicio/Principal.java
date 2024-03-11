package exercicio;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Principal {

	public static void main(String[] args) {
		final int TAMANHO = 10000;
		
		List<Integer> lista = new LinkedList<Integer>();
		
		for(int i = 0; i < TAMANHO; i++)
			lista.add(i);
		
		//ListIterator<Integer> it = lista.listIterator();
		//while(it.hasNext())
		//	System.out.println(it.next());
		
		int elemento = 4000;
		
		Pesquisa direto = new Pesquisa(lista, elemento, true);
		Pesquisa reverso = new Pesquisa(lista, elemento, false);
		
		direto.setColega(reverso);
		reverso.setColega(direto);
		
		direto.start();
		reverso.start();
		
		try {
			direto.join();
			reverso.join();
		}
		catch (InterruptedException e) {}
		
		if (direto.isEncontrado())
			System.out.println("A thread direta encontrou o elemento");
		else
			System.out.println("A thread direta não encontrou o elemento");
		if (reverso.isEncontrado())
			System.out.println("A thread reversa encontrou o elemento");
		else
			System.out.println("A thread reversa não encontrou o elemento");
	}

}
