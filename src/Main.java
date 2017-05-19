import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	final static String pathBusqueda = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_busqueda_10000.csv";
	final static String pathInsert = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/dataset_insert_10000.csv";
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
	final static String resultAlta_escenarioB = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidaalta_escenarioB.csv";
	final static String resultBusqueda_escenarioB = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidabusqueda_escenarioB.csv";
	final static String resultAlta_escenarioA = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidaalta_escenarioA.csv";
	final static String resultBusqueda_escenarioA = "C:/TUDAI-ws/Fazio-Nieto-TPEspecial-2/datasets/salidabusqueda_escenarioA.csv";

	public static void main(String[] args) {
		// escenario A Pocas inserciones Muchas busquedas
		ListaArreglo a = new ListaArreglo(pathInsert, resultBusqueda_escenarioA, resultAlta_escenarioA);
		a.altaUsuarios(pathBusqueda);
		a.buscarUsuarios(path3m);
		// escenario B Muchas inserciones pocas busquedas
		ListaArreglo b = new ListaArreglo(pathInsert, resultBusqueda_escenarioB, resultAlta_escenarioB);
		b.altaUsuarios(path3m);
		b.buscarUsuarios(pathBusqueda);
	}

}
