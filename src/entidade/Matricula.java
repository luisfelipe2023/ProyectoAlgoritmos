package entidade;

public class Matricula {
	private int codM;
	private int codA;
	private int codC;
	private String fecha;
	private String hora;
	//Constructores
	public Matricula() {
		
	}
	public Matricula(int codM, int codA, int codC, String fecha, String hora) {

		this.codM = codM;
		this.codA = codA;
		this.codC = codC;
		this.fecha = fecha;
		this.hora = hora;
	}
	//METODOS GET Y SET
	public int getCodM() {
		return codM;
	}
	public void setCodM(int codM) {
		this.codM = codM;
	}
	public int getCodA() {
		return codA;
	}
	public void setCodA(int codA) {
		this.codA = codA;
	}
	public int getCodC() {
		return codC;
	}
	public void setCodC(int codC) {
		this.codC = codC;
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
