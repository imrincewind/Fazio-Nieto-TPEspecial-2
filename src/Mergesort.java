
public class Mergesort {
	private Usuario[] usuarios;

	private Usuario[] helper;

	private int size;

	public void sort(ListaArreglo values) {

		this.usuarios = values.getUsers();
		
		size = values.getSize();

		this.helper = new Usuario[size];

		mergesort(0, size - 1);
	}

	private void mergesort(int low, int high) {

		if (low < high) {

			int middle = (low + high) / 2;

			mergesort(low, middle);

			mergesort(middle + 1, high);

			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
try {
	for (int i = low; i <= high; i++) {

		helper[i] = usuarios[i];

	}

	int i = low;

	int j = middle + 1;

	int k = low;

	while (i <= middle && j <= high) {

		if (helper[i].getUserId() <= helper[j].getUserId()) {

			usuarios[k] = helper[i];

			i++;

		} else {

			usuarios[k] = helper[j];

			j++;

		}

		k++;

	}

	while (i <= middle) {

		usuarios[k] = helper[i];

		k++;

		i++;

	}

}
 catch (Exception e) {
	
}
		

}
}