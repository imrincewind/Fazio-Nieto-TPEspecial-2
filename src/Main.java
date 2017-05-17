import java.io.IOException;
		import java.util.ArrayList;

public class Main {
//binarizar la busqueda
	//formas de optimizar, 1- fijarnos el size del arraylist a agregar/cargar usuarios y en base al tamaño ejecutar
	//distintos metodos (numero chico, insertarOrdenado, numero grande ordenar antes de buscar)
	//otra forma de optimizar, ordenar la lista a buscar (además de ordenar los ya cargados) y podar en base a que 
	// no recorra indices menores al índice del último encontrado
	// C:\TUDAI-ws\Fazio-Nieto-TPEspecial-2\datasets
	final static String path2 = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_2.csv";
	final static String path24 = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_24.csv";
	final static String path500k = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_500000.csv";
	final static String path1m = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_1000000.csv";
	final static String path3m = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_3000000.csv";
	final static String resultBusqueda500k_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidabusqueda500k_array.csv";
	final static String resultAlta500k_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidaalta500k_array.csv";
	final static String resultBusqueda1m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidabusqueda1m_array.csv";
	final static String resultBusqueda3m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidabusqueda3m_array.csv";
	final static String resultAlta1m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidaalta1m_array.csv";
	final static String resultAlta3m_array = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidaalta3m_array.csv";
	
	public static void main(String[] args) {
		ListaArreglo a = new ListaArreglo(path500k, resultBusqueda1m_array, resultAlta1m_array);
		a.buscarUsuarios(path2);
	
	}

}
