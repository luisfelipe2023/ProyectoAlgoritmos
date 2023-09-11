package entidade;

public class Asignacion {
	//atributos privados
	private int codAsig;
	private int codDoc;
	private String nomDocente;
	private String nomCurso;
	private String fecha;
	private String hora;
	
	//Constructores
	public Asignacion() {
		
	}
	public Asignacion(int codAsig,int codD, String nomDocente, String nomCurso, String fecha, String hora) {
		super();
		this.codAsig = codAsig;
		this.codDoc = codD;
		this.nomDocente = nomDocente;
		this.nomCurso = nomCurso;
		this.fecha = fecha;
		this.hora = hora;
		
	}
	
	//metodos get y set
	public int getCodAsig() {
		return codAsig;
	}
	public void setCodAsig(int codAsig) {
		this.codAsig = codAsig;
	}
	public String getNomDocente() {
		return nomDocente;
	}
	public void setNomDocente(String nomDocente) {
		this.nomDocente = nomDocente;
	}
	public String getNomCurso() {
		return nomCurso;
	}
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
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
	public int getCodDoc() {
		return codDoc;
	}
	public void setCodDoc(int codDoc) {
		this.codDoc = codDoc;
	}
	
	
	

}
