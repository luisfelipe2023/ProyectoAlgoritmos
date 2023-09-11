package entidade;

public class Alumno {
	private int codAlumno;
	private String nomA;
	private String apeA;
	private String dni;
	private String telef;
	private int estado;
	
	public Alumno() {
	}
	public Alumno(int codAlumno, String nomA, String apeA, String dni, String telef, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.nomA = nomA;
		this.apeA = apeA;
		this.dni = dni;
		this.telef = telef;
		this.estado = estado;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNomA() {
		return nomA;
	}

	public void setNomA(String nomA) {
		this.nomA = nomA;
	}

	public String getApeA() {
		return apeA;
	}

	public void setApeA(String apeA) {
		this.apeA = apeA;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	
	

}
