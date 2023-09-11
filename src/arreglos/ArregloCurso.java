package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Alumno;
import entidade.Curso;

public class ArregloCurso {
	//Atributos privados
	private ArrayList<Curso> arCurso;
	//constructores
	public ArregloCurso() {
		arCurso = new ArrayList<Curso>();
		cargar();
	}
	
	/*****************METODOS BASICOS*****************************/
	
	public void adicionar(Curso cur) {
		arCurso.add(cur);
		grabar();
	
	}
	
	public int tamanio() {
		return arCurso.size();
	}
	
	public Curso obtener(int pos) {
		return arCurso.get(pos);
	}
	
	public void eliminar(Curso cur) {
		arCurso.remove(cur);
	}
	/********************METODOS COMPLEMENTARIOS*******************/
	public int generarCodigoCurso() {
		// si no tengo datos en el arreglo -- 2001
		if (tamanio() == 0) //
			return 3001;
		else
			return obtener(tamanio() - 1).getCodCur() + 1;
	}
	public Curso buscarNombre(String nombreC) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getNomCur().equals(nombreC))
				return obtener(i);
		}
		return null;
	}
	
	public Curso buscarCodigoA(int codC) { 
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodCur() == codC)
				return obtener(i);
	}
		return null;
	}
	/**METODO GRABAR DATOS**/
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("curso.txt"));
			String linea;
			for(Curso c : arCurso) {
				linea = c.getCodCur() + ";" + c.getNomCur() + ";" + c.getCategoria() + ";" +  c.getModalidad() + ";" + c.getHoras() + ";" + c.getVacantes();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error en grabar curso.txt :" + e.getMessage());
		}
	}
	/**M�TODO CARGAR DATOS A LA TABLA**/
	  private void cargar() {
	    	String linea;
	    	try {
				BufferedReader br = new BufferedReader(new FileReader("curso.txt"));
				String nombre;
				int codigoCurso,categoria,modalidad,horas,vacantes;
				while((linea = br.readLine()) != null) {
					String parte[] = linea.split(";");
					codigoCurso = Integer.parseInt(parte[0].trim());
					nombre = parte[1].trim();
					categoria = Integer.parseInt(parte[2].trim());
					modalidad =Integer.parseInt(parte[3].trim());
					horas = Integer.parseInt(parte[4].trim());
					vacantes = Integer.parseInt(parte[5].trim());
					adicionar(new Curso(codigoCurso, nombre, categoria, modalidad , horas, vacantes));
			    }
				br.close();
			} catch (Exception e) {
				System.out.println("Error en la lectura curso.txt :" + e.getMessage());
				}
			}
	
	
	
	
}
