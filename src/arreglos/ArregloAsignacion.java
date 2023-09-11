package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Asignacion;
import entidade.Curso;
import entidade.Docente;

public class ArregloAsignacion {
	private ArrayList<Asignacion>arAsignacion;
	//constructor
	public ArregloAsignacion() {
		arAsignacion = new ArrayList<Asignacion>();
		//grabar();
		cargar();
		
	}
	/********************MÉTODOS BASICOS*****************************/
	
	public void adicionar(Asignacion asi) {
		arAsignacion.add(asi);
	}
	
	public int tamanio() {
		return arAsignacion.size();
	}
	
	public Asignacion obtener(int pos) {
		return arAsignacion.get(pos);
	}
	
	public void eliminar(Asignacion cur) {
		arAsignacion.remove(cur);
	}
	
	/**************************METODOS COMPLEMENTARIIOS******************************************/
	public int generarCodigoAsig() {
		// si no tengo datos en el arreglo -- 2001
		if (tamanio() == 0) //
			return 6001;
		else
			return obtener(tamanio() - 1).getCodAsig() + 1;
	}

	public Asignacion buscarCodigoAsig(int codAsg) { 
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodAsig() == codAsg)
				return obtener(i);
	}
		return null;
	}
	
	/**METODO GRABAR DATOS**/
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("asignacionDoc.txt"));
			String linea;
			for(Asignacion a : arAsignacion) {
				linea = a.getCodAsig() + ";" + a.getCodDoc() +";"+a.getNomDocente() + ";" + a.getNomCurso() + ";" +  a.getFecha() + ";" + a.getHora();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error en grabar asignacionDoc.txt :" + e.getMessage());
		}
	}
	
	/**M�TODO CARGAR DATOS A LA TABLA**/
	  public void cargar() {
	    	String linea;
	    	try {
				BufferedReader br = new BufferedReader(new FileReader("asignacionDoc.txt"));
				String nomDocente, nomCurso, fecha, hora;
				int codAsig,codDoc;
				while((linea = br.readLine()) != null) {
					String parte[] = linea.split(";");
					codAsig = Integer.parseInt(parte[0].trim());
					codDoc = Integer.parseInt(parte[1].trim());
					nomDocente = parte[2].trim();
					nomCurso = parte[3].trim();
					fecha = parte[4].trim();
					hora = parte[5].trim();
					adicionar(new Asignacion(codAsig,codDoc, nomDocente, nomCurso, fecha, hora));
			    }
				br.close();
			} catch (Exception e) {
				System.out.println("Error en la lectura asignacionDoc.txt :" + e.getMessage());
				}
			}
	
}
