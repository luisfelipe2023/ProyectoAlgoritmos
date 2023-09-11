
package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Alumno;
import entidade.Docente;

public class ArregloDocente {
	//atributos privados
	private ArrayList<Docente>arDocente;
	//constructor
	public ArregloDocente() {
		arDocente = new ArrayList<Docente>();
		
		cargar();
	}
	/*****************METODOS BASICOS************************/
	public void adicionar(Docente doc) {
		arDocente.add(doc);
		grabar();
	}
	public int tamanio() {
		return arDocente.size();
	}
	public Docente obtener(int pos) {
		return arDocente.get(pos);
	}
	public void eliminar(Docente doc) {
		arDocente.remove(doc);
		grabar();
	}
	/********************METODOS COMPLEMENTARIOS***************************/
	public int generarCodigoDocente() {
		// si no tengo datos en el arreglo -- 2001
		if (tamanio() == 0) //
			return 1001;
		else
			return obtener(tamanio() - 1).getCodDocente() + 1;
	}
	
	public Docente buscarDNI(String dni) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getDni().equals(dni))
				return obtener(i);
		}
		return null; //cuando no existe el dni ingresado
	}
	
	public Docente buscarCodigoA(int codA) { 
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodDocente() == codA)
				return obtener(i);
	}
		return null;
	}
	/**METODO GRABAR DATOS**/
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("docente.txt"));
			String linea;
			for(Docente d : arDocente) {
				linea = d.getCodDocente() + ";" + d.getNombre() + ";" + d.getApellido() + ";" +  d.getDni() + ";" + d.getTelefono() 
				+ ";" + d.getCategoria();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error en grabar docente.txt :" + e.getMessage());
		}
	}
	/**M�TODO CARGAR DATOS A LA TABLA**/
	  public void cargar() {
	    	String linea;
	    	try {
				BufferedReader br = new BufferedReader(new FileReader("docente.txt"));
				String nombre, apellido, telefono, dni;
				int codigoDocente, categoria;
				while((linea = br.readLine()) != null) {
					String parte[] = linea.split(";");
					codigoDocente = Integer.parseInt(parte[0].trim());
					nombre = parte[1].trim();
					apellido = parte[2].trim();
					dni = parte[3].trim();
					telefono = parte[4].trim();
					categoria = Integer.parseInt(parte[5].trim());
					adicionar(new Docente(codigoDocente, nombre, apellido, dni , telefono, categoria));
			    }
				br.close();
			} catch (Exception e) {
				System.out.println("Error en la lectura docente.txt :" + e.getMessage());
				}
			}
	
	
	
	
	
	
	
}
