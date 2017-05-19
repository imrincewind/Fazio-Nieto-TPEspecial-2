import javax.swing.text.Highlighter.Highlight;

public class Buscador {
private ListaArreglo usuarios;
private Usuario user;
private boolean encontrado = false;
public Buscador(ListaArreglo users) {
	this.usuarios = users;
}

	public boolean buscarUsuario(Usuario u){
		this.encontrado = false;
		int low = 0;
		int high = usuarios.getSize()-1;
		int middle = high/2;
		
		this.user = u;
		return buscarUsuarioRecursivo(low, high, middle);
	}
	
	private boolean buscarUsuarioRecursivo(int low, int high, int middle){
		if((user.compareTo(usuarios.getUsuarioAt(middle) )< 0) && (middle != high) && (middle != low)){
			high = middle;
			middle = (middle + low) /2;
			buscarUsuarioRecursivo(low, high, middle);
		} else if((user.compareTo(usuarios.getUsuarioAt(middle) )> 0) && (middle != high) && (middle != low)){
			low = middle;
			middle = (middle + high)/2;
			buscarUsuarioRecursivo(low, high, middle);
		} else if((middle != high) && (middle != low)){
			encontrado = true;
		}
		return encontrado;
	}
	
}
