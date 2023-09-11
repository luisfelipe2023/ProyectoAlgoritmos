package entidade;

import java.util.Vector;

public class Usuario {
	private String usuario;
	private String contrase�a;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public static int verificarUsuarioNuevo(String usuario) {
		Vector lista = mostrar();
		Usuario obj;
		for (int i = 0; i < lista.size(); i++) {
			obj = (Usuario)lista.elementAt(i);
			if(obj.getUsuario().equalsIgnoreCase(usuario)) {
				return i;
			}
		}
		return -1;
	}
	
	public static int verificarLogueo(String usuario, String contrase�a) {
		Vector lista = mostrar();
		Usuario obj;
		for (int i = 0; i < lista.size(); i++) {
			obj = (Usuario)lista.elementAt(i);
			if(obj.getUsuario().equalsIgnoreCase(usuario) && obj.getContrase�a().equalsIgnoreCase(contrase�a)) {
				return i;
			}
		}
		return -1;
	}
	
	public static Vector mostrar() {
		return ListaUsuario.mostrar();
	}
}
