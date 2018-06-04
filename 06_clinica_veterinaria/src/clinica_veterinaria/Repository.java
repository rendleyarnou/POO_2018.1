package clinica_veterinaria;

import java.util.ArrayList;

public class Repository<T> {

	private ArrayList<T> lista;
	private String typename;

	public Repository(String typename) {
		lista = new ArrayList<T>();
		this.typename = typename;
	}

	public void add(T t) {
		for (T elem : lista)
			if (elem.equals(t)) {
				elem = t;
				return;
			}
		lista.add(t);
	}

	public T get(T t) {
		for (T elem : lista)
			if (lista.equals(t))
				return elem;
		throw new RuntimeException("fail: " + typename + " " + t + " não existe!");
	}

	public void remove(T t) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(t)) {
				lista.remove(i);
				return;
			}
		}
		throw new RuntimeException("fail: " + typename + " " + t + " não existe!");
	}

	public ArrayList<T> getAll() {
		ArrayList<T> all = new ArrayList<T>();
		for (T elem : lista)
			all.add(elem);
		return all;
	}

	public String toString() {
		String saida = "";
		for (T elem : lista)
			saida += elem + "\n";
		return saida;
	}

}
