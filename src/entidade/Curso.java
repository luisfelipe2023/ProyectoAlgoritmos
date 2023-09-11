package entidade;

public class Curso {
	//Atributos privados
	private int codCur;
	private String nomCur;
	private int categoria;
	private int modalidad;
	private int horas;
	private int vacantes;
	//Constructores
	public Curso() {
		
	}
	
	public Curso(int codCur, String nomCur, int categoria, int modalidad, int horas, int vacantes) {
		this.codCur = codCur;
		this.nomCur = nomCur;
		this.categoria = categoria;
		this.modalidad = modalidad;
		this.horas = horas;
		this.vacantes = vacantes;
	}
	
	//metodos get y set
	public int getCodCur() {
		return codCur;
	}
	public void setCodCur(int codCur) {
		this.codCur = codCur;
	}
	public String getNomCur() {
		return nomCur;
	}
	public void setNomCur(String nomCur) {
		this.nomCur = nomCur;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getModalidad() {
		return modalidad;
	}
	public void setModalidad(int modalidad) {
		this.modalidad = modalidad;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	
	
	
	
	
	
	
	

}
