package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Alumno;
import entidade.Asignacion;
import entidade.Matricula;
import entidade.Retiro;

public class ArregloRetiro {
	//Atributos privados
	private ArrayList<Retiro>arRetiro;
	//constructor
	
	public ArregloRetiro() {
		arRetiro = new ArrayList<Retiro>();
		cargar();
	}
	
	public void adicionar(Retiro ret) {
		arRetiro.add(ret);
		grabar();
		
	}
	
	public int tamanio() {
		return arRetiro.size();
	}
	
	public Retiro obtener(int pos) {
		return arRetiro.get(pos);
	}
	
	public void eliminar(Retiro ret) {
		arRetiro.remove(ret);
	}
	
	public int generarCodigoRetiro() {
		// si no tengo datos en el arreglo -- 5001
		if (tamanio() == 0) //
			return 5001;
		else
			return obtener(tamanio() - 1).getCodRetiro() + 1;
	}
	public Retiro buscarCodRet(int codR) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodRetiro() == codR)
				return obtener(i);
		}
		return null;
	}
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("retiro.txt"));
			String linea;
			for(Retiro r : arRetiro) {
				linea = r.codRetiro + ";" + r.getCodAlumno() + ";" + r.getNomAlumno() + ";" +  r.getFecha() + ";" + r.getHora();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println("Error en grabar retiro.txt :" + e.getMessage());
		}
	}
	
	 public void cargar() {
	    	String linea;
	    	try {
				BufferedReader br = new BufferedReader(new FileReader("retiro.txt"));
				String nomAlu, fecha, hora;
				int codRet,codAlu;
				while((linea = br.readLine()) != null) {
					String parte[] = linea.split(";");
					codRet = Integer.parseInt(parte[0].trim());
					codAlu =Integer.parseInt(parte[1].trim());
					nomAlu = parte[2].trim();
					fecha = parte[3].trim();
					hora = parte[4].trim();
					adicionar(new Retiro(codRet, codAlu, nomAlu, fecha, hora));
			    }
				br.close();
			} catch (Exception e) {
				System.out.println("Error en la lectura retiro.txt :" + e.getMessage());
				}
			}
	
	
	

}
