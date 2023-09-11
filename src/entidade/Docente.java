package entidade;

public class Docente {
	//atributos privados
	private int codDocente;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private int categoria;
	
	
	//CONSTRUCTORES
	public Docente() {
		
	}
	public Docente(int codDocente, String nombre, String apellido, String dni, String telefono, int categoria) {
		super();
		this.codDocente = codDocente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.categoria = categoria;
	}
	
	//metodos get y set
	public int getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


}
