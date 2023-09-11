package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCurso;
import entidade.Curso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

public class Frm_Curso extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtCodigoC;
	private JTextField txtNombre;
	private JTextField txtHoras;
	private JTable tblCurso;
	// instanciar un objeto de tipo "DefaultTableModel" para modelar o estructurar
	// la tabla
	DefaultTableModel model = new DefaultTableModel();

	// instacio objeto "Arreglo Docente"
	ArregloCurso arCur = new ArregloCurso();
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JPanel panel;
	private JRadioButton rdbtnNombre;
	private JTextField txtConsulta;
	private JButton btnBuscar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtVacantes;
	private JComboBox cboModalidadC;
	private JComboBox cboCategoriaC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Curso frame = new Frm_Curso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_Curso() {
		setTitle("Mantenimiento Curso");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMantenimientoC = new JLabel("Mantenimiento Curso");
		lblMantenimientoC.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/aprender-en-linea.png")));
		lblMantenimientoC.setOpaque(true);
		lblMantenimientoC.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoC.setForeground(Color.BLACK);
		lblMantenimientoC.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblMantenimientoC.setBackground(new Color(240, 230, 140));
		lblMantenimientoC.setBounds(0, 0, 612, 43);
		contentPane.add(lblMantenimientoC);

		JLabel lblCodigoC = new JLabel("Cod. Curso");
		lblCodigoC.setBounds(23, 54, 66, 14);
		contentPane.add(lblCodigoC);

		txtCodigoC = new JTextField();
		txtCodigoC.setEditable(false);
		txtCodigoC.setColumns(10);
		txtCodigoC.setBounds(117, 54, 109, 20);
		contentPane.add(txtCodigoC);

		JLabel lblNombreD = new JLabel("Nombre");
		lblNombreD.setBounds(23, 88, 66, 14);
		contentPane.add(lblNombreD);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 85, 109, 20);
		contentPane.add(txtNombre);

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(437, 88, 46, 14);
		contentPane.add(lblHoras);

		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(493, 85, 109, 20);
		contentPane.add(txtHoras);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/documento.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(42, 121, 100, 28);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(172, 121, 117, 29);
		contentPane.add(btnRegistrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(309, 121, 117, 28);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(450, 121, 109, 28);
		contentPane.add(btnEliminar);

		JScrollPane scp = new JScrollPane();
		scp.setBounds(11, 259, 591, 224);
		contentPane.add(scp);

		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scp.setViewportView(tblCurso);
		// crea columnas para la tabla
		model.addColumn("Codigo curso");
		model.addColumn("Curso");
		model.addColumn("Categoria");
		model.addColumn("Modalidad");
		model.addColumn("Horas");
		model.addColumn("Vacantes");
		// asociar el objeto "model" con la tabla "tblDocente"
		tblCurso.setModel(model);

		// metodo que permite caragar la informacion a la tabla y mostrar lso datos
		listar();
		// mostrar el codigo generado
		txtCodigoC.setText("" + arCur.generarCodigoCurso());
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Consultas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 160, 592, 83);
		contentPane.add(panel);
		
		rdbtnNombre = new JRadioButton("Nombre");
		buttonGroup.add(rdbtnNombre);
		rdbtnNombre.setBounds(28, 40, 78, 23);
		panel.add(rdbtnNombre);
		
		txtConsulta = new JTextField();
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(200, 37, 187, 28);
		panel.add(txtConsulta);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Frm_Curso.class.getResource("/imagenes/lupa.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(427, 37, 100, 28);
		panel.add(btnBuscar);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(236, 57, 66, 14);
		contentPane.add(lblModalidad);
		
		lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(236, 88, 55, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Vacantes");
		lblNewLabel_1.setBounds(437, 54, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		txtVacantes = new JTextField();
		txtVacantes.setBounds(493, 55, 105, 20);
		contentPane.add(txtVacantes);
		txtVacantes.setColumns(10);
		
		cboModalidadC = new JComboBox<String>();
		cboModalidadC.setModel(new DefaultComboBoxModel<String>(new String[] {"Basico", "Intermedio", "Avanzado"}));
		cboModalidadC.setBounds(300, 54, 117, 22);
		contentPane.add(cboModalidadC);
		
		cboCategoriaC = new JComboBox<String>();
		cboCategoriaC.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione..","Diseño Grafico", "Tecnologia", "Gestion","Generales"}));
		cboCategoriaC.setBounds(299, 84, 118, 22);
		contentPane.add(cboCategoriaC);
		// invocar metodo para mostrar datos de la tabla a las cajas de etxto
		mostrarDatos(0);
	}

	private void listar() {
		// limpiar la tabla
		model.setRowCount(0);

		// bucle
		for (int i = 0; i < arCur.tamanio(); i++) {
			// crear un arreglo tipo "Objet" para almacenar los datos del tipo "ArDoc"
			Object fila[] = { arCur.obtener(i).getCodCur(), arCur.obtener(i).getNomCur(),
					nombreCategoria(arCur.obtener(i).getCategoria()), nombreModalidad(arCur.obtener(i).getModalidad()) ,arCur.obtener(i).getHoras(),arCur.obtener(i).getVacantes()
				};
			// mostrar informacion en la tabla
			model.addRow(fila);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarCurso();
	}

	private void registrarCurso() {
		// declare variables
		int  codC, horas,categoria,modalidad,vacantes;
		String nombreC,nombreCate,nombreModa;

		// obtener los datos dela gui
		
		codC = getCodigoC();
		nombreC = getNombreC();
		categoria = getCategoria();
		modalidad = getModaliad();
		horas = getHoras();
		vacantes = getVacantes();
		
		// validar los campos tengan los datos correctos

		if (nombreC == null || horas == 0 || codC == 0) {
			return;
		} else {
			Curso c = arCur.buscarNombre(nombreC);
			if (c == null) { // el curso no existe
				// instanciar el objeto curso
				c = new Curso();
				
				c.setCodCur(codC);
				c.setNomCur(nombreC);
				c.setCategoria(categoria);
				c.setModalidad(modalidad);
				c.setHoras(horas);
				c.setVacantes(vacantes);
				// adicionar le neuvo objeto curso al arreglo
				arCur.adicionar(c);
				// mostrar el curso agregado en la tabla
				listar();
				//habilitar botones
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			} else {
				mensajeError("Error!! , curso existe");
			}
		}
	}




	private int getVacantes() {
		
		return Integer.parseInt(txtVacantes.getText());
	}

	private int getModaliad() {
		return cboModalidadC.getSelectedIndex();
	}

	private int getCategoria() {
		
		return cboCategoriaC.getSelectedIndex();
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!!", 0);
	}
	
	

	private String getNombreC() {
		String nomb = null;
		if (txtNombre.getText().trim().length() == 0) {// campo vacio
			mensajeError("Ingresar el nombre del curso");
		} else {
			nomb = txtNombre.getText();
		}
		return nomb;
	}

	private int getHoras() {
		int horas = 0;
		if (txtHoras.getText().length() == 0) {
			mensajeError("Ingresa las horas del curso");
		} else {
			horas = Integer.parseInt(txtHoras.getText());
			;
		}
		return horas;
	}

	private int getCodigoC() {
		return Integer.parseInt(txtCodigoC.getText());
	}
	//nombre categoria
		String nombreCategoria(int i) {
	        switch (i) {
	            case 0: return "Seleccione";
	            case 1: return "Diseño Grafico";
	            case 2: return "Tecnologia";
	            case 3 : return "Gestion";
	            case 4 : return "Generales";
	            default:return null;
	        }}
		String nombreModalidad(int i) {
	        switch (i) {
	            case 0: return "Basico";
	            case 1: return "Intermedio";
	            case 2: return "Avanzado";
	            default:return null;
	        }}



	// Metodo encargado de mostrar los datos a las cajasde texto , segun la fila
	// seleccionada
	private void mostrarDatos(int posFila) {
		// declarar variables
		String  codC, nomb, horas,vacantes;
		// paso 1: obtener los valores de la tabla segun la seleccion de la fila
		// getValueAt (fila, columna) --> codigo
		codC = tblCurso.getValueAt(posFila, 0).toString(); // codigo
		nomb = tblCurso.getValueAt(posFila, 1).toString();
		horas = tblCurso.getValueAt(posFila, 4).toString();
		vacantes = tblCurso.getValueAt(posFila, 5).toString();

		// paos 2: mostrar valores obtenidos de la fila seleccioanda a las cajas de
		// texto
		txtCodigoC.setText(codC);
		txtNombre.setText(nomb);
		txtHoras.setText(horas);
		txtVacantes.setText(vacantes);

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblCurso) {
			mouseReleasedTblCurso(e);
		}
	}

	protected void mouseReleasedTblCurso(MouseEvent e) {
		// obtener el valode de la fila seleccionada
		int posFila;
		posFila = tblCurso.getSelectedRow();
		// MOSTRAr datos de la fila seleccionada
		mostrarDatos(posFila);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCurso) {
			keyReleasedTblCurso(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTblCurso(KeyEvent e) {
		// obtener el valode de la fila seleccionada
		int posFila;
		posFila = tblCurso.getSelectedRow();
		// MOSTRAr datos de la fila seleccionada
		mostrarDatos(posFila);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarCurso();
	}

	private void modificarCurso() {
		// declare variables
				int  codC, horas,categoria,modalidad,vacantes;
				String nombreC;

				// obtener los datos dela gui
				
				codC = getCodigoC();
				nombreC = getNombreC();
				categoria = getCategoria();
				modalidad = getModaliad();
				horas = getHoras();
				vacantes = getVacantes();
		
		//validar
		if(nombreC  == null || horas == -1 || codC == -1 ) {
			return;
		}else {
			//validar si el codigo del curso existe
			Curso cur = arCur.buscarCodigoA(codC);
			
			if(cur != null) {//el docente existe
				//actualizar
				int opcion = JOptionPane.showConfirmDialog(this, "Seguro de modificar ?" , "Sistema", JOptionPane.YES_NO_OPTION);
				//yes --> 0
				//no -->1
				if(opcion == 0) { //hizo click en yes
				//setear los nuevos valores ingresados
					cur.setCodCur(codC);
					cur.setNomCur(nombreC);;
					cur.setCategoria(categoria);
					cur.setModalidad(modalidad);
					cur.setHoras(horas);
					cur.setVacantes(vacantes);
				
				//mostrar datos modificados
				arCur.grabar();
				listar();
			}
		    }else {
		    	mensajeError("Codigo Curso no existe!!");
		    }
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoCurso();
	}

	private void nuevoCurso() {
		//limpiar cajas de texto
		txtCodigoC.setText("");
		txtNombre.setText("");
		txtHoras.setText("");
		//generar nuvo codigo
		txtCodigoC.setText(arCur.generarCodigoCurso()+ "");
		//cursor activo
		txtNombre.setText("");
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarCurso();
	}

	private void eliminarCurso() {
		//verificar que le codido del curso exista
		//buscar codigo
		Curso cur = arCur.buscarCodigoA(getCodigoC());
		//validar si el curso existe
		if(cur != null) {//quiere decir que el codifo curso existe
			//eliminar ---> ventana de confirmacion para eliminar
			int opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar ?" , "Sistema", JOptionPane.YES_NO_OPTION);
			//valida la seleccion del cuadro de confirmacion
			if(opcion == 0) {
				arCur.eliminar(cur);
				
				//actualiza la tabla
				listar();
			}
		}else {
			mensajeError("Codigo del Curso no existe!!!");
		}
	}
	
	//Metodo para realizar consultas por nombre
	private void consultar(int tipoConsulta, String datoBuscar) {
		String str = toString();
	//paso 1 -- limpiar tabla
		model.setRowCount(0);
		//paso 2 --generar bucle
		for (int i = 0; i < arCur.tamanio(); i++) {
			//instanciar un objeto de tipo curso
			Curso c = arCur.obtener(i);
			//realizar la consulta segun el tipo
			if(tipoConsulta == 1) {
				if(c.getNomCur().startsWith(datoBuscar)) {
					Object fila [] = {c.getCodCur(),
					          c.getNomCur(),
					          nombreCategoria(c.getCategoria()),
					          nombreModalidad(c.getModalidad()),
					          c.getHoras(),
					          c.getVacantes()
					          
			                 };
			      model.addRow(fila);
			}
			}
				}
			}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		//variables
		int tipoConsulta = 0;
		String datoBuscar;
		
		//validar la seleccion
		if(rdbtnNombre.isSelected() == true) {
			tipoConsulta = 1;
		}
		
		//obtener el dato a buscar
		datoBuscar = getDatoBuscar();
		//invocar el metodo -- consultar 
		consultar(tipoConsulta, datoBuscar);
	}

	private String getDatoBuscar() {
		String datos = null;
		datos = txtConsulta.getText().trim();
		return datos;
	}
}

