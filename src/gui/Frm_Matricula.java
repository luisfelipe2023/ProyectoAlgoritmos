package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloAsignacion;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import entidade.Alumno;
import entidade.Asignacion;
import entidade.Curso;
import entidade.Hora;
import entidade.Matricula;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Frm_Matricula extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private final JLabel lblTitulo = new JLabel("Registro Matricula");
	private JLabel lblcodM;
	public static JTextField txtCodMat;
	private JLabel lblFecha;
	public static JTextField txtFecha;
	private JLabel lblHora;
	public static JTextField txtHora;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCodigoA;
	public static JTextField txtCodAlum;
	private JLabel lblNombre;
	private JLabel lblApellido;
	public static JTextField txtNombreA;
	private JButton btnBuscarAlu;
	public static JTextField txtApellidoA;
	public static JTextField txtDni;
	public static JTextField txtTelefono;
	public static JTextField txtEstado;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblCodCurso;
	private JLabel lblCurso;
	public static JTextField txtCodC;
	public static JTextField txtCurso;
	public static JLabel lblCategoria;
	public static JTextField txtCategoria;
	private JButton btnBuscarCur;
	public static JTextField txtModalidad;
	private JLabel lblModalidad;
	public static JTextField txtHoras;
	public static JTextField txtVacantes;
	private JLabel lblHoras;
	private JLabel lblVacantes;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private JButton btnNuevo;
	private JButton btnRegistrar;

	// IMPORTAR
	DefaultTableModel model = new DefaultTableModel();
	ArregloMatricula arMatri = new ArregloMatricula();
	ArregloAlumno arAlum = new ArregloAlumno();
	ArregloCurso arCurso = new ArregloCurso();
	ArregloAsignacion arAsig = new ArregloAsignacion();
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Matricula frame = new Frm_Matricula();
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
	public Frm_Matricula() {
		setTitle("Registro Matricula");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Matricula.class.getResource("/imagenes/colegial.png")));
		setBackground(new Color(240, 230, 140));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitulo.setIcon(new ImageIcon(Frm_Matricula.class.getResource("/imagenes/retiro.png")));
		lblTitulo.setForeground(new Color(0, 51, 102));
		lblTitulo.setBackground(new Color(0, 51, 102));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 530, 56);
		contentPane.add(lblTitulo);

		lblcodM = new JLabel("Codigo Matricula");
		lblcodM.setBounds(10, 65, 92, 14);
		contentPane.add(lblcodM);

		txtCodMat = new JTextField();
		txtCodMat.setEditable(false);
		txtCodMat.setBounds(112, 62, 106, 20);
		contentPane.add(txtCodMat);
		txtCodMat.setColumns(10);

		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(228, 65, 46, 14);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(279, 62, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(387, 65, 46, 14);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(441, 62, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 101, 517, 114);
		contentPane.add(panel);
		panel.setLayout(null);

		lblCodigoA = new JLabel("Codigo Alumno");
		lblCodigoA.setBounds(10, 27, 89, 14);
		panel.add(lblCodigoA);

		txtCodAlum = new JTextField();
		txtCodAlum.setEditable(false);
		txtCodAlum.setBounds(102, 24, 106, 20);
		panel.add(txtCodAlum);
		txtCodAlum.setColumns(10);

		lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 56, 82, 14);
		panel.add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 81, 46, 14);
		panel.add(lblApellido);

		txtNombreA = new JTextField();
		txtNombreA.setEditable(false);
		txtNombreA.setBounds(102, 52, 205, 20);
		panel.add(txtNombreA);
		txtNombreA.setColumns(10);

		btnBuscarAlu = new JButton("Buscar");
		btnBuscarAlu.addActionListener(this);
		btnBuscarAlu.setBounds(218, 23, 89, 23);
		panel.add(btnBuscarAlu);

		txtApellidoA = new JTextField();
		txtApellidoA.setEditable(false);
		txtApellidoA.setBounds(102, 78, 205, 20);
		panel.add(txtApellidoA);
		txtApellidoA.setColumns(10);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(421, 24, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(421, 53, 86, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(421, 78, 86, 20);
		panel.add(txtEstado);
		txtEstado.setColumns(10);

		lblNewLabel_7 = new JLabel("Dni");
		lblNewLabel_7.setBounds(335, 27, 76, 14);
		panel.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Telefono");
		lblNewLabel_8.setBounds(335, 56, 76, 14);
		panel.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Estado");
		lblNewLabel_9.setBounds(335, 81, 76, 14);
		panel.add(lblNewLabel_9);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 226, 517, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblCodCurso = new JLabel("Codigo Curso");
		lblCodCurso.setBounds(10, 24, 89, 14);
		panel_1.add(lblCodCurso);

		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 49, 46, 14);
		panel_1.add(lblCurso);

		txtCodC = new JTextField();
		txtCodC.setEditable(false);
		txtCodC.setBounds(105, 21, 106, 20);
		panel_1.add(txtCodC);
		txtCodC.setColumns(10);

		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setBounds(105, 46, 205, 20);
		panel_1.add(txtCurso);
		txtCurso.setColumns(10);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 75, 71, 14);
		panel_1.add(lblCategoria);

		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setBounds(105, 72, 205, 20);
		panel_1.add(txtCategoria);
		txtCategoria.setColumns(10);

		btnBuscarCur = new JButton("Buscar");
		btnBuscarCur.addActionListener(this);
		btnBuscarCur.setBounds(221, 20, 89, 23);
		panel_1.add(btnBuscarCur);

		txtModalidad = new JTextField();
		txtModalidad.setEditable(false);
		txtModalidad.setBounds(403, 21, 104, 20);
		panel_1.add(txtModalidad);
		txtModalidad.setColumns(10);

		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(329, 24, 64, 14);
		panel_1.add(lblModalidad);

		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setBounds(403, 46, 104, 20);
		panel_1.add(txtHoras);
		txtHoras.setColumns(10);

		txtVacantes = new JTextField();
		txtVacantes.setEditable(false);
		txtVacantes.setBounds(403, 72, 104, 20);
		panel_1.add(txtVacantes);
		txtVacantes.setColumns(10);

		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(329, 49, 64, 14);
		panel_1.add(lblHoras);

		lblVacantes = new JLabel("Vacantes");
		lblVacantes.setBounds(329, 75, 64, 14);
		panel_1.add(lblVacantes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 401, 517, 226);
		contentPane.add(scrollPane);

		tblMatricula = new JTable();
		tblMatricula.addMouseListener(this);
		tblMatricula.addKeyListener(this);
		scrollPane.setViewportView(tblMatricula);
		// crea columnas para la tabla
		model.addColumn("Codigo Matricula");
		model.addColumn("Codigo Alumno");
		model.addColumn("Codigo Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");

		// asociar el objeto "model" con la tabla "tblDocente"
		tblMatricula.setModel(model);
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Frm_Matricula.class.getResource("/imagenes/documento.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(60, 351, 109, 35);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(Frm_Matricula.class.getResource("/imagenes/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(202, 351, 120, 35);
		contentPane.add(btnRegistrar);
		txtCodMat.setText("" + arMatri.generarCodigomAT());
		txtFecha.setText("" + Hora.fechaActual());
		txtHora.setText("" + Hora.horaActual());
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Frm_Matricula.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(361, 351, 120, 33);
		contentPane.add(btnEliminar);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnBuscarAlu) {
			actionPerformedBtnBuscarAlu(e);
		}
		if (e.getSource() == btnBuscarCur) {
			actionPerformedBtnBuscarCur(e);
		}
	}

	protected void actionPerformedBtnBuscarCur(ActionEvent e) {
		dlg_BuscarCurso dg = new dlg_BuscarCurso();
		dg.setLocationRelativeTo(this);
		dg.setVisible(true);
	}

	protected void actionPerformedBtnBuscarAlu(ActionEvent e) {
		dlg_BuscarAlumno da = new dlg_BuscarAlumno();
		da.setLocationRelativeTo(this);
		da.setVisible(true);
	}

	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arMatri.tamanio(); i++) {
			Object fila[] = { arMatri.obtener(i).getCodM(), arMatri.obtener(i).getCodA(), arMatri.obtener(i).getCodC(),
					arMatri.obtener(i).getFecha(), arMatri.obtener(i).getHora()

			};
			model.addRow(fila);
		}
	}
	/**MÉTODO REGISTRAR**/
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarAlumno();
		limiteMat() ;
	}
	public void registrarAlumno() {
		int codM, codA, codC;
		String fecha, Hora;

		codM = getcodM();
		codA = getcodA();
		codC = getcodC();
		fecha = getFecha();
		Hora = getHora();

		if (codA == 0) {
			return;
		} else {
			Matricula m = arMatri.buscarCodMat(codM);
			//Alumno alu = arAlum.buscarCodigoA(codA);
			//int c = arCurso.buscarCodigoCurso(codC);
			Curso c=arCurso.buscarCodigoA(codC);
			if (m == arMatri.buscarCodMat(codM) || m==null || 	c!=null /*c!=Integer.parseInt(txtCodC.getText())*/ ) {
				m = new Matricula(codM, codA, codC, fecha, Hora);
				m.setCodM(codM);
				m.setCodA(codA);
				m.setCodC(codC);
				m.setFecha(fecha);
				m.setHora(Hora);
				arMatri.adicionar(m);
				Alumno a = arAlum.buscarCodigoA(codA);
				Curso cr = arCurso.buscarCodigoA(codC);
				a.setEstado(1);
				cr.setVacantes(cr.getVacantes() - 1);
				;/** ACA VA 1 **/
				arAlum.grabar();
				arCurso.grabar();
				listar();
				

			} else {
				mensajeError("EROR AL REALIZAR LA MATRICULA");
			}
		}
	}
	
	/*******MÉTODO NUEVO*********/
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
		txtHora.setText("" + Hora.horaActual());
		txtCodMat.setText(arMatri.generarCodigomAT()+"");
	}
	
/***************VALIDACIONES***********************/
	String nombreEstado(int i) {
		switch (i) {
		case 0:
			return "REGISTRADO";
		case 1:
			return "MATRICULADO";
		case 2:
			return "RETIRADO";
		default:
			return null;
		}
	}

	private String getFecha() {

		return txtFecha.getText();
	}

	private String getHora() {

		return txtHora.getText();
	}

	private int getcodC() {

		return Integer.parseInt(txtCodC.getText());
	}

	private int getcodA() {

		return Integer.parseInt(txtCodAlum.getText());
	}

	private int getcodM() {
		return Integer.parseInt(txtCodMat.getText());
	}
	/****MENSAJE ERROR**/
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!!", 0);
	}

	/**METODO LIMPIAR**/
	public void limpiar() {
		txtCodAlum.setText("");
		txtCodC.setText("");
		txtCategoria.setText("");
		txtNombreA.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtApellidoA.setText("");
		txtHoras.setText("");
		txtEstado.setText("");
		txtVacantes.setText("");
		txtModalidad.setText("");
		txtCurso.setText("");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarMatricula();
		
;	}

	private void eliminarMatricula() {
		//verificar que el codigo del docente exista
				//buscar codigo
				Matricula mat= arMatri.buscarCodMat(getcodM());
				//validar si el docente existe
				if(mat !=null) {//quiere decir que el codigo del docente existe
					//eliminar--ventana de confirmacion
					int opcion= JOptionPane.showConfirmDialog(this, "Seguro de eliminar ? ", "Sistema", JOptionPane.YES_NO_OPTION);
					//validar 
					if(opcion==0) {
						arMatri.eliminar(mat);
						arMatri.guardarMatricula();
					//actualizar la tabla
						listar();
					}
				}else {
					mensajeError("Codigo del docente no existe");
				}
				
		
	}
	
	/********************LIMITE DE MATRICULAS****************************/
	
	public void limiteMat() {
		if(arMatri.tamanio() > 20 ) {
			mensajeError("LIMITE DE MATRICULAS COMPLETO");
			btnRegistrar.setEnabled(false);
			
		}
		else {
			habilitarBton();
		}
	}
	public void habilitarBton() {
		btnEliminar.setEnabled(true);
	}
	
	
	
	
	
	
	
	
	
	
	private void mostrarDatos(int posFila) {
		String cod;
		
		cod = tblMatricula.getValueAt(posFila, 0).toString();
		
		txtCodMat.setText(cod);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblMatricula) {
			keyReleasedTblMatricula(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblMatricula(KeyEvent e) {
		int posFila;
		posFila = tblMatricula.getSelectedRow();
		//mostrar datos de la fila seleccionada
		mostrarDatos(posFila);
		
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
		if (e.getSource() == tblMatricula) {
			mouseReleasedTblMatricula(e);
		}
	}
	protected void mouseReleasedTblMatricula(MouseEvent e) {
		int posFila;
		posFila = tblMatricula.getSelectedRow();
		//mostrar datos de la fila seleccionada
		mostrarDatos(posFila);
	}
}
