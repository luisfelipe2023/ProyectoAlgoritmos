package entidade;

public class Retiro {
	public int codRetiro;
	public int codAlumno;
	public String nomAlumno;
	public String fecha;
	public String hora;
	
	//CONSTRUCTORES
	public Retiro() {
		
	}
	public Retiro(int codRetiro, int codAlumno, String nomAlumno, String fecha, String hora) {
		super();
		this.codRetiro = codRetiro;
		this.codAlumno = codAlumno;
		this.nomAlumno = nomAlumno;
		this.fecha = fecha;
		this.hora = hora;
	}
	///METODOS GET Y SET
	public int getCodRetiro() {
		return codRetiro;
	}
	public void setCodRetiro(int codRetiro) {
		this.codRetiro = codRetiro;
	}
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNomAlumno() {
		return nomAlumno;
	}
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
