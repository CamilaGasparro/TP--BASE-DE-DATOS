package paquete;

import java.util.Comparator;

public class CostoComparator implements Comparator<Producto> {
	@Override
	public int compare(Producto a1, Producto a2) {
		return Double.compare(a1.getCosto(), a2.getCosto());
	}
}
