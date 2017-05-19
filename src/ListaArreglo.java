
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ListaArreglo {
	private Usuario[] users = new Usuario[10000];
	private CSVReader csvr = new CSVReader();
	private CSVWritter csvw = new CSVWritter();
	private String resultBusqueda = "";
	private String resultAlta = "";
	private String pathCargaUsuarios = "";
	private int size = 0;
	private boolean ordenado = false;

	public ListaArreglo(String pathCargaUsuarios, String resultBusqueda, String resultAlta) {
		this.pathCargaUsuarios = pathCargaUsuarios;
		this.resultAlta = resultAlta;
		this.resultBusqueda = resultBusqueda;
		cargarUsuarios(this.pathCargaUsuarios, false);
	}

	private void cargarUsuarios(String pathCarga, boolean imprimir) {
		Date init = new Date();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = csvr.reader(pathCarga);
		int temp = size;
		try {
			for (int i = 0; i < (usuarios.size() + temp); i++) {

				if (size >= this.users.length) {
					duplicateArrayLength();
				}
				this.users[size] = usuarios.get(i);
				Date end = new Date();
				long result = end.getTime() - init.getTime();
				guardarTiempo(this.users[size], 3000000, result);
				size++;

			}
		} catch (IndexOutOfBoundsException e) {
		}
		if (imprimir) {
			csvw.createWritter(resultAlta);
			try {
				csvw.write(usuarios);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ordenado = false;
	}

	private void duplicateArrayLength() {
		Usuario[] usersTemp = new Usuario[this.users.length * 2];
		for (int i = 0; i < this.users.length; i++) {
			usersTemp[i] = this.users[i];
		}
		users = usersTemp;
	}

	public Usuario[] getUsers() {
		return users;
	}

	public void buscarUsuarios(String pathSearch) {
		Buscador busqueda = new Buscador(this);////PREGUNTAR POR CLONAR
		if(!ordenado){
			Mergesort m = new Mergesort();
			m.sort(this);
			ordenado = true;
		}
		
		ArrayList<Usuario> usersQuery = new ArrayList<Usuario>();
		usersQuery = this.csvr.reader(pathSearch);
		Date init = new Date();
		for (Usuario user : usersQuery) {
			user.setExists(false);
			user.setExists(busqueda.buscarUsuario(user));
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			int size;
			if (users.length <= 640000) {
				size = 500000;
			} else if (users.length <= 1280000) {
				size = 1000000;
			} else {
				size = 3000000;
			}
			guardarTiempo(user, size, result);
		}
		csvw.createWritter(resultBusqueda);
		try {
			csvw.write(usersQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void guardarTiempo(Usuario user, int size, long result) {
		if (size <= 500000) {
			user.setTimeArray("500k", result);
		} else if (size <= 1000000) {
			user.setTimeArray("1m", result);
		} else {
			user.setTimeArray("3m", result);
		}
	}

	public int getSize() {
		return size;
	}
	public Usuario getUsuarioAt(int pos){
		return users[pos];
	}

	public void altaUsuarios(String pathAlta) {
		cargarUsuarios(pathAlta, true);

		ArrayList<Usuario> usuariosAImprimir = new ArrayList<Usuario>();
		for (Usuario usuario : users) {
			if (usuario != null) {
				usuariosAImprimir.add(usuario);
			}

		}

	}
}