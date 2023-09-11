package entidade;

import java.util.Vector;

public class Usuario {
	private String usuario;
	private String contraseña;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	
	public static int verificarLogueo(String usuario, String contraseña) {
		Vector lista = mostrar();
		Usuario obj;
		for (int i = 0; i < lista.size(); i++) {
			obj = (Usuario)lista.elementAt(i);
			if(obj.getUsuario().equalsIgnoreCase(usuario) && obj.getContraseña().equalsIgnoreCase(contraseña)) {
				return i;
			}
		}
		return -1;
	}
	
	public static Vector mostrar() {
		return ListaUsuario.mostrar();
	}
}
