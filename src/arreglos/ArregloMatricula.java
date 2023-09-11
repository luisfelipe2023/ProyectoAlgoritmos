package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidade.Alumno;
import entidade.Matricula;

public class ArregloMatricula {
	//atributo privado
		private ArrayList<Matricula> arMat;

		//constructor
		public ArregloMatricula() {
			arMat = new ArrayList<Matricula>();
			//adicionar objetos de tipo Matricula
			cargarMatricula();

		}
		
		//Operaciones basicas
		
		//metodo adicionar
		public void adicionar(Matricula mat) {
			arMat.add(mat);
			guardarMatricula();
		}
		//metodo tamanio
		public int tamanio() {
			return arMat.size();
		}
		public void eliminar(Matricula mat) {
			arMat.remove(mat);
		}
		//metodo obtener
		//recibe la posicion como parametro y retorna un objeto de tipo "docente" que se encuentra en la posicion infresada 
		public Matricula obtener(int pos) {
			return arMat.get(pos);
		}
		
		public int generarCodigomAT() {
			// si no tengo datos en el arreglo -- 3001
			if (tamanio() == 0) //
				return 3001;
			else
				return obtener(tamanio() - 1).getCodM() + 1;
		}
		public Matricula buscarCodMat(int codM) {
			for (int i = 0; i < tamanio(); i++) {
				if(obtener(i).getCodM() == codM)
					return obtener(i);
			}
			return null;
		}
		public void guardarMatricula() {
			try {
				PrintWriter pw;
				Matricula mat;
				String linea;
				
				pw = new PrintWriter(new File ("matricula.txt"));
				
				for (int i = 0; i < arMat.size(); i++) {
					mat = obtener(i);
					linea = mat.getCodM() + ";" +
					        mat.getCodA()+ ";" +
							mat.getCodC() + ";"+
							mat.getFecha() + ";"+
							mat.getHora() + ";";
					
					pw.println(linea);
				}
				pw.close();
			} catch (Exception e) {
				System.out.println("Error al guardar los datos de la matricula:"+e.getMessage());
			}
		}
		
		public void cargarMatricula() {
			try {
				BufferedReader br;
				String linea, fecha, hora;
				int codMat, codAlu, codCur; 
				String[] sep;
				br = new BufferedReader(new FileReader("matricula.txt"));
				
				while((linea = br.readLine())!=null) {
					sep = linea.split(";");
					
					codMat = Integer.parseInt(sep[0]);
					codAlu = Integer.parseInt(sep[1]);
					codCur = Integer.parseInt(sep[2]);
					fecha = sep[3];
					hora = sep[4];
				
					arMat.add(new Matricula(codMat, codAlu, codCur, fecha, hora));
				}
				
			} catch (Exception e) {
				System.out.println("Error al cargar los datos de la matricula:"+e.getMessage());
			}
		}

}
