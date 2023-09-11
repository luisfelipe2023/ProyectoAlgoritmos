package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Alumno;

public class ArregloAlumno {
	//Atributos privados
	private ArrayList<Alumno> arAlumno;
	//constructor
	public ArregloAlumno() {
		arAlumno = new ArrayList<Alumno>();
		cargar();
	}
	
	public void adicionar(Alumno alu) {
		arAlumno.add(alu);
		grabar();
	}
	
	public int tamanio() {
		return arAlumno.size();
	}
	
	public Alumno obtener(int pos) {
		return arAlumno.get(pos);
	}
	
	public void eliminar(Alumno alu) {
		arAlumno.remove(alu);
	}
	/**M�TODO QUE GENERA EL CODIGO DEL ALUMNO**/
	public int generarCodigoAlumno() {
		// si no tengo datos en el arreglo -- 2001
		if (tamanio() == 0) //
			return 2001;
		else
			return obtener(tamanio() - 1).getCodAlumno() + 1;
	}
	
	public Alumno buscarDNI(String dni) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getDni().equals(dni))
				return obtener(i);
		}
		return null; //cuando no existe el dni ingresado
	}
	
	public Alumno buscarCodigoA(int codA) { 
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodAlumno() == codA)
				return obtener(i);
	}
		return null;
	}
	/**METODO GRABAR DATOS**/
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("alumno.txt"));
			String linea;
			for(Alumno a : arAlumno) {
				linea = a.getCodAlumno() + ";" + a.getNomA() + ";" + a.getApeA() + ";" +  a.getDni() + ";" + a.getTelef() + ";" + a.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error en grabar alumno.txt :" + e.getMessage());
		}
	}
	/**M�TODO CARGAR DATOS A LA TABLA**/
	  private void cargar() {
	    	String linea;
	    	try {
				BufferedReader br = new BufferedReader(new FileReader("alumno.txt"));
				String nombre, apellido, telefono, dni;
				int codigoAlumno, estado;
				while((linea = br.readLine()) != null) {
					String parte[] = linea.split(";");
					codigoAlumno = Integer.parseInt(parte[0].trim());
					nombre = parte[1].trim();
					apellido = parte[2].trim();
					dni = parte[3].trim();
					telefono = parte[4].trim();
					estado = Integer.parseInt(parte[5].trim());
					adicionar(new Alumno(codigoAlumno, nombre, apellido, dni , telefono, estado));
			    }
				br.close();
			} catch (Exception e) {
				System.out.println("Error en la lectura alumno.txt :" + e.getMessage());
				}
			}
	
	
}
