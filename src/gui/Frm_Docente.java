package gui;

import java.awt.BorderLayout;
import entidade.Docente;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloDocente;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Window.Type;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Frm_Docente extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtCodigoD;
	private JTextField txtNombreD;
	private JTextField txtApellidoD;
	private JTextField txtTelefonoD;
	private JTextField txtDniD;
	private JTable tblDocente;
	//instanciar objeto de tipo default table mode para modelar o estructurar la tabla
	DefaultTableModel model = new DefaultTableModel();
	//instanciar objeto ""Arreglo Docente
	ArregloDocente arDocente = new ArregloDocente();
	private JButton btnRegistrar;
	private JComboBox cboCategoria;
	private JLabel lblError;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JPanel panel;
	private JRadioButton rdbtnDNI;
	private JRadioButton rdbtnApellido;
	private JTextField txtDatoBuscar;
	private JButton btnBuscar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Docente frame = new Frm_Docente();
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
	public Frm_Docente() {
		setTitle("Mantenimiento Docente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Docente.class.getResource("/imagenes/colegial.png")));
		setType(Type.UTILITY);
		setBackground(UIManager.getColor("CheckBox.foreground"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoD = new JLabel("Mantenimiento Docente");
		lblMantenimientoD.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/profesor.png")));
		lblMantenimientoD.setBorder(new LineBorder(Color.BLUE, 2));
		lblMantenimientoD.setBackground(new Color(240, 230, 140));
		lblMantenimientoD.setForeground(SystemColor.textText);
		lblMantenimientoD.setOpaque(true);
		lblMantenimientoD.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoD.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblMantenimientoD.setBounds(0, 0, 569, 43);
		contentPane.add(lblMantenimientoD);
		
		JLabel lblCodigoD = new JLabel("Codigo Docente");
		lblCodigoD.setBounds(331, 57, 111, 14);
		contentPane.add(lblCodigoD);
		
		txtCodigoD = new JTextField();
		txtCodigoD.setBorder(null);
		txtCodigoD.setEditable(false);
		txtCodigoD.setBounds(450, 54, 109, 20);
		contentPane.add(txtCodigoD);
		txtCodigoD.setColumns(10);
		
		JLabel lblNombreD = new JLabel("Nombre");
		lblNombreD.setBounds(20, 57, 66, 14);
		contentPane.add(lblNombreD);
		
		txtNombreD = new JTextField();
		txtNombreD.addMouseListener(this);
		txtNombreD.setBackground(new Color(230, 230, 250));
		txtNombreD.setBorder(null);
		txtNombreD.addKeyListener(this);
		txtNombreD.setBounds(96, 54, 158, 20);
		contentPane.add(txtNombreD);
		txtNombreD.setColumns(10);
		
		JLabel lblApellidoD = new JLabel("Apellido");
		lblApellidoD.setBounds(20, 88, 46, 14);
		contentPane.add(lblApellidoD);
		
		txtApellidoD = new JTextField();
		txtApellidoD.addMouseListener(this);
		txtApellidoD.setBackground(new Color(230, 230, 250));
		txtApellidoD.setBorder(null);
		txtApellidoD.setBounds(96, 85, 158, 20);
		contentPane.add(txtApellidoD);
		txtApellidoD.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(20, 120, 66, 14);
		contentPane.add(lblCategoria);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.addMouseListener(this);
		cboCategoria.setBackground(new Color(255, 228, 181));
		cboCategoria.setBorder(null);
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"seleccione...", "Contratado", "Nombrado", "Por horas"}));
		cboCategoria.setBounds(96, 116, 158, 22);
		contentPane.add(cboCategoria);
		
		JLabel lblTelefonoD = new JLabel("Tel\u00E9fono");
		lblTelefonoD.setBounds(331, 88, 78, 14);
		contentPane.add(lblTelefonoD);
		
		txtTelefonoD = new JTextField();
		txtTelefonoD.addMouseListener(this);
		txtTelefonoD.setBorder(null);
		txtTelefonoD.setBounds(450, 85, 109, 20);
		contentPane.add(txtTelefonoD);
		txtTelefonoD.setColumns(10);
		
		JLabel lblDniD = new JLabel("Dni");
		lblDniD.setBounds(331, 120, 78, 14);
		contentPane.add(lblDniD);
		
		txtDniD = new JTextField();
		txtDniD.addMouseListener(this);
		txtDniD.setBorder(null);
		txtDniD.setBounds(450, 117, 109, 20);
		contentPane.add(txtDniD);
		txtDniD.setColumns(10);
		
		JScrollPane scp = new JScrollPane();
		scp.setBounds(10, 284, 549, 253);
		contentPane.add(scp);
		
		tblDocente = new JTable();
		tblDocente.setBorder(new LineBorder(new Color(0, 0, 128)));
		tblDocente.addMouseListener(this);
		scp.setViewportView(tblDocente);
		tblDocente.setFillsViewportHeight(true);
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Categoria");
		model.addColumn("Teléfono");
		model.addColumn("DNI");
		
		//asociar el objeto model co
		tblDocente.setModel(model);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/documento.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(20, 149, 109, 28);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(153, 149, 119, 29);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(301, 150, 127, 28);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(438, 148, 109, 28);
		contentPane.add(btnEliminar);
		
		//metodo que permite cargar la informacion de la tabla
		listar();
		//mostrar el codigo generado
		txtCodigoD.setText(""+arDocente.generarCodigoDocente());
		
		lblError = new JLabel("*");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblError.setForeground(Color.RED);
		lblError.setBounds(254, 54, 46, 31);
		contentPane.add(lblError);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Consultas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 190, 549, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnDNI = new JRadioButton("Dni");
		buttonGroup.add(rdbtnDNI);
		rdbtnDNI.setBounds(28, 40, 62, 23);
		panel.add(rdbtnDNI);
		
		rdbtnApellido = new JRadioButton("Apellido");
		buttonGroup.add(rdbtnApellido);
		rdbtnApellido.setBounds(108, 40, 109, 23);
		panel.add(rdbtnApellido);
		
		txtDatoBuscar = new JTextField();
		txtDatoBuscar.setBounds(223, 37, 187, 28);
		panel.add(txtDatoBuscar);
		txtDatoBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Frm_Docente.class.getResource("/imagenes/lupa.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(436, 37, 103, 28);
		panel.add(btnBuscar);
		lblError.setVisible(false);
		//invocar metodo para mostrar datos de la tabla a las cajas de texto
		mostrarDatos(0);
	}

	private void listar() {
		//limpiar la tabla
		model.setRowCount(0);
		//generar un bucle
		for (int i = 0; i < arDocente.tamanio(); i++) {
			//crear un arreglo de tipo "Object " para almacenar los datos 
			//del arreglo arDocente
			Object fila [] = {arDocente.obtener(i).getCodDocente(),
							  arDocente.obtener(i).getNombre(),
							  arDocente.obtener(i).getApellido(),
							   nombreCategoria(arDocente.obtener(i).getCategoria()),
							   arDocente.obtener(i).getTelefono(),
							   arDocente.obtener(i).getDni()};
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
	//METODO REGISTRAR DOCENTE
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarDocente();
	}

	private void registrarDocente() {
		//declare variables
		int cod,cat;
		String nomb, ape, dni, telef, nomCategoria;
		
		//obtener los datos dela gui
		cod = getCodigo();
		nomb = getNombre();
		ape = getApellido();
		dni = getDNI();
		telef = getTelefono();
		cat = getCategoria();
		//valida los campos tengan los datos correctos
		
		if(nomb ==null || ape == null) {
			return;
		}else {//los datos ingresados son correctos
			//valida que el docente no exista mediante el dni
			Docente d = arDocente.buscarDNI(dni);
			if(d == null) {//el docente no existe
				//instancia el objeto Docente
				d = new Docente();
				//setear los valores  --> asignar los valores ingresados de la GUI
				//a los atributos privados
				d.setCodDocente(cod);
				d.setNombre(nomb);;
				d.setApellido(ape);;
				d.setCategoria(cat);; 
				d.setDni(dni);
				d.setTelefono(telef);
				//adicionar el nuevo objeto "Docente" al arreglo
				arDocente.adicionar(d);
				//mostrar el docente agregado en la tabla
				listar();
				//habilitar los botenes
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
			}else {//docente existe
				mensajeError("Error!! , docente ya existe");
			}
		}
 	}
//MENSAJE ERROR
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!",0);
		
	}
// VALIDACIONES

	private int getCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	private String getTelefono() {
		String telef = null;
		if(txtTelefonoD.getText().trim().length() == 0) {
			mensajeError("Ingresar el Teléfono  del docente");
		}else {
			telef = txtTelefonoD.getText();
		}
		return txtTelefonoD.getText();
	}
	
	private String getDNI() {
		String dni = null;
		if(txtDniD.getText().trim().length() == 0) {
			mensajeError("Ingresar el DNI del docente");
		}else {
			dni = txtDniD.getText();
		}
		return txtDniD.getText();
	}
	
	private String getApellido() {
		String ape = null;
		if(txtApellidoD.getText().trim().length() == 0) {
			mensajeError("Ingresar el apellido del docente");
		}else {
			ape = txtApellidoD.getText();
		}
		return txtApellidoD.getText();
	}
	
	private String getNombre() {
		String nomb = null;
		if(txtNombreD.getText().trim().length() == 0) {//campo vacio
			mensajeError("Ingresa el nombre del docente");
			lblError.setVisible(true);
			txtNombreD.setBackground(Color .red);
		}else {
			nomb = txtNombreD.getText();
		}
		return txtNombreD.getText();
	}
	String nombreCategoria(int i) {
        switch (i) {
            case 0: return "Nombrado";
            case 1: return "Contratado";
            case 2: return "Por Horas";
            default:return null;
        }
	 }
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNombreD) {
			keyReleasedTxtNombreD(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNombreD(KeyEvent e) {
		txtNombreD.setBackground(Color .WHITE);
		lblError.setVisible(false);
	}
	
	private int getCodigo() {
		return Integer.parseInt(txtCodigoD.getText());
	}
	
	//metodo encargado de mostrar los datos en la tabla a las cajas de texto, segun la fila seleccionada
	private void mostrarDatos(int posFila) {
		//declara variables
		String cod, nomb, apell, dni, tlf, cate;
		//paso 1: obtener los valores de la tabla segun la seleccion de la fila
		//getValueAt(posFila, 0) --> codigo
		cod = tblDocente.getValueAt(posFila, 0).toString();
		nomb = tblDocente.getValueAt(posFila, 1).toString();
		apell = tblDocente.getValueAt(posFila, 2).toString();
		dni = tblDocente.getValueAt(posFila, 5).toString();
		tlf = tblDocente.getValueAt(posFila, 4).toString();
		cate = tblDocente.getValueAt(posFila, 3).toString();
		//paso 2: mostrar los vqalores obtenidos de la fila seleccionada a las cajas de texto
		txtCodigoD.setText(cod);
		txtNombreD.setText(nomb);
		txtApellidoD.setText(apell);
		txtTelefonoD.setText(tlf);
		txtDniD.setText(dni);
		cboCategoria.setSelectedItem(cate);
	}

	
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblDocente) {
			mouseReleasedTblDocente(e);
		}
	}
	protected void mouseReleasedTblDocente(MouseEvent e) {
		//obtener el valor de la fila seleccionada
		int posFila;
		posFila = tblDocente.getSelectedRow();
		//mostrar datos de la fila seleccionada
		mostrarDatos(posFila);
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarDocente();
	}

	private void modificarDocente() {
		//declarar variable
		int cod, cate;
		String nomb, ape, dni , tlf;
		//obtener los datos que se van a modificar
		cod = getCodigo();
		nomb = getNombre();
		ape = getApellido();
		dni = getDNI();
		tlf = getTelefono();
		cate = getCategoria();
		
		//validar
		if(nomb ==null || ape == null || dni == null || tlf == null || cod == -1) {
			return;
		}else {
			//validar si el codigo del docente existe
			Docente doc = arDocente.buscarCodigoA(cod);
			
			if(doc != null) {//el docente existe
				//actualizar
				int opcion = JOptionPane.showConfirmDialog(this, "Seguro de modificar ? ", "sistema", JOptionPane.YES_NO_CANCEL_OPTION);
				//yes --> 0
				//no --> 1
				if(opcion == 0) { //hizo click en yes
					//setear los nuevos valores ingresados
					doc.setCodDocente(cod);
					doc.setNombre(nomb);;
					doc.setApellido(ape);;
					doc.setDni(dni);
					doc.setTelefono(tlf);
					doc.getCategoria();
					arDocente.grabar();
					//mostrar datos modificados
					listar();
				}
			}else {
				mensajeError("Docente no existe");
			}
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoDocente();
	}

	private void nuevoDocente() {
		//limpiar las cajas de texto
		txtCodigoD.setText("");
		txtNombreD.setText("");
		txtApellidoD.setText("");
		txtDniD.setText("");
		txtTelefonoD.setText("");
		cboCategoria.setSelectedIndex(0);
		//generar nuvo codigo 
		txtCodigoD.setText(arDocente.generarCodigoDocente()+"");
		//cursor activo
		txtNombreD.setText("");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		//verificar que el codigo del docente exista
		//buscar codigo
		Docente doc = arDocente.buscarCodigoA(getCodigo());
		//validar si el docente existe
		if(doc != null) { //quiere decir que el codigo docente si existe
			//eliminar ----ventana de confirmacion
			int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Eliminar ? ", "sistema", JOptionPane.YES_NO_CANCEL_OPTION);
			//validar la seleccion del cuadro de confirmacion
			if(opcion == 0) {
				arDocente.eliminar(doc);
				//actualizar la tabla
				listar();
			}
		}else {
			mensajeError("Codigo del docente no existe");
		}
	}
	
	//Metodo para consultar
	private void consultar(int TipoConsulta , String DatoaBuscar) {
		//paso 1 - limpiar tabla
		model.setRowCount(0);
		//paso 2 - generar bucle
		for (int i = 0; i < arDocente.tamanio(); i++) {
			//instanciar un objeto de tipo docente
			Docente d = arDocente.obtener(i);
			//realizar una consulta segun el tipo... DNI O Apellido
			if(TipoConsulta == 1) { //DNI
				if(d.getDni().startsWith(DatoaBuscar)) {
					Object fila [] = {d.getCodDocente(),
							          d.getNombre(),
							          d.getApellido(),
							          d.getDni(),
							          d.getTelefono(),
							          d.getCategoria()
					                 };
					model.addRow(fila);
				}
			}else {//APELLIDO
				if(d.getApellido().startsWith(DatoaBuscar)) {
					Object fila [] = {d.getCodDocente(),
					          d.getNombre(),
					          d.getApellido(),
					          d.getDni(),
					          d.getTelefono(),
					          d.getCategoria()
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
		
		//validar la seleccion del tipo consulta
		if(rdbtnDNI.isSelected() == true) {
			tipoConsulta = 1;
		}
		if(rdbtnApellido.isSelected() == true) {
			tipoConsulta = 2;
		}
		
		//obtener el dato a buscar
		datoBuscar = getDatoBuscar();
		//invocar el metodo -- consultar
		consultar(tipoConsulta, datoBuscar);
	}

	private String getDatoBuscar() {
		String dato = null; //completar validacion
		dato = txtDatoBuscar.getText().trim();
		return dato;
	}
	//CAMBIO BORDE
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == txtDniD) {
			mouseClickedTxtDniD(e);
		}
		if (e.getSource() == txtTelefonoD) {
			mouseClickedTxtTelefonoD(e);
		}
		if (e.getSource() == txtApellidoD) {
			mouseClickedTxtApellidoD(e);
		}
		if (e.getSource() == txtNombreD) {
			mouseClickedTxtNombreD(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
		txtNombreD.setBorder(new LineBorder(Color.white , 0));
		txtApellidoD.setBorder(new LineBorder(Color.white , 0));
		txtTelefonoD.setBorder(new LineBorder(Color.white , 0));
		txtDniD.setBorder(new LineBorder(Color.white , 0));
	}
	
	public void mousePressed(MouseEvent e) {
	}
	protected void mouseClickedTxtNombreD(MouseEvent e) {
		txtNombreD.setBorder(new LineBorder(Color.blue , 2));
		
	}
	protected void mouseClickedTxtApellidoD(MouseEvent e) {
		txtApellidoD.setBorder(new LineBorder(Color.blue , 2));
	}
	
	protected void mouseClickedTxtTelefonoD(MouseEvent e) {
		txtTelefonoD.setBorder(new LineBorder(Color.blue , 2));
	}
	protected void mouseClickedTxtDniD(MouseEvent e) {
		txtDniD.setBorder(new LineBorder(Color.blue , 2));
	}
}

































