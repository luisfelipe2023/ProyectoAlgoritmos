package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import entidade.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Frm_Alumno extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtCodA;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTable tblAlumno;
	DefaultTableModel model = new DefaultTableModel();
	ArregloAlumno arAlu = new ArregloAlumno();
	private JComboBox cboEstado;
	private JButton btnRegistrar;
	private JPanel panel;
	private JTextField txtConsultar;
	private JButton btnBuscar;
	private JRadioButton rdbtnDNI;
	private JRadioButton rdbtnApellido;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Alumno frame = new Frm_Alumno();
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
	public Frm_Alumno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Alumno.class.getResource("/imagenes/colegial.png")));
		setTitle("Mantenimiento Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcodA = new JLabel("Codigo Alumno");
		lblcodA.setBounds(10, 64, 86, 14);
		contentPane.add(lblcodA);
		
		txtCodA = new JTextField();
		txtCodA.setBounds(95, 61, 102, 20);
		contentPane.add(txtCodA);
		txtCodA.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 89, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(223, 64, 46, 14);
		contentPane.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 86, 102, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(279, 61, 110, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(415, 64, 46, 14);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(483, 61, 119, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblTelef = new JLabel("Telefono");
		lblTelef.setBounds(415, 89, 46, 14);
		contentPane.add(lblTelef);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(481, 86, 121, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(223, 89, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		cboEstado.setBounds(279, 85, 110, 22);
		contentPane.add(cboEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(Frm_Alumno.class.getResource("/imagenes/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(171, 220, 119, 35);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Frm_Alumno.class.getResource("/imagenes/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(327, 220, 134, 35);
		contentPane.add(btnModificar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Frm_Alumno.class.getResource("/imagenes/documento.png")));
		btnNuevo.setSelectedIcon(new ImageIcon(Frm_Alumno.class.getResource("/imagenes/documento.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 220, 110, 35);
		contentPane.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Frm_Alumno.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(483, 220, 119, 35);
		contentPane.add(btnEliminar);
		
		JScrollPane scp = new JScrollPane();
		scp.setBounds(10, 271, 592, 257);
		contentPane.add(scp);
		
		tblAlumno = new JTable();
		tblAlumno.addKeyListener(this);
		tblAlumno.addMouseListener(this);
		scp.setViewportView(tblAlumno);
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dni");
		model.addColumn("Telefono");
		model.addColumn("Estado");
		tblAlumno.setModel(model);
		
		txtCodA.setText(""+arAlu.generarCodigoAlumno());
		
		JLabel lblTitulo = new JLabel("Mantenimiento Alumno");
		lblTitulo.setForeground(new Color(0, 51, 102));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 1, 612, 52);
		contentPane.add(lblTitulo);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Consultas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(17, 126, 585, 83);
		contentPane.add(panel);
		
		txtConsultar = new JTextField();
		txtConsultar.setColumns(10);
		txtConsultar.setBounds(212, 40, 187, 28);
		panel.add(txtConsultar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(426, 40, 113, 28);
		panel.add(btnBuscar);
		
		rdbtnDNI = new JRadioButton("Dni");
		rdbtnDNI.setBounds(17, 40, 62, 23);
		panel.add(rdbtnDNI);
		
		rdbtnApellido = new JRadioButton("Apellido");
		rdbtnApellido.setBounds(97, 40, 109, 23);
		panel.add(rdbtnApellido);
		
		listar();
		
		// invocar metodo para mostrar datos de la tabla a las cajas de etxto
		mostrarDatos(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	/**BTN REGISTRAR**/
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarAlu();
	}
	public void registrarAlu() {
		int codA,est;
		String nomb, apell, tlf, dni;

		codA = getCodigoA();
		nomb = getNomA();
		apell = getApeA();
		tlf = getTelef();
		dni = getDni();
		est = getEstado();
	
		if (nomb == null || apell == null || tlf == null || dni == null || codA == -1) {
			return;
		} else {
			Alumno a = arAlu.buscarDNI(dni);
			if (a == null) {
				a = new Alumno();
				a.setCodAlumno(codA);
				a.setNomA(nomb);
				a.setApeA(apell);
				a.setTelef(tlf);
				a.setDni(dni);
				a.setEstado(est);
				arAlu.adicionar(a);
				arAlu.grabar();
				listar();
			} else {
				mensajeError("[ERROR]: El alumno que intenta registrar ya existe.");
			}
		}
	}
	
	/**LISTAR DATOS EN LA TABLA**/
	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arAlu.tamanio(); i++) {
			Object fila[]= {
					arAlu.obtener(i).getCodAlumno(),arAlu.obtener(i).getNomA(),arAlu.obtener(i).getApeA(),arAlu.obtener(i).getDni(),arAlu.obtener(i).getTelef(),
					nombreEstado( arAlu.obtener(i).getEstado())
			};
			model.addRow(fila);
		}
	}
	
	/**VALIDACIONES**/
	public int getCodigoA() {
		return Integer.parseInt(txtCodA.getText());
	}
	public String getNomA() {
		String nomb = null;
		if (txtNombre.getText().trim().length() == 0) {// campo vacio
			mensajeError("Ingresar el nombre del alumno");
		} else {
			nomb = txtNombre.getText();
		}
		return nomb;
	}
	public String getApeA() {
		String nomb = null;
		if (txtApellido.getText().trim().length() == 0) {// campo vacio
			mensajeError("Ingresar el apellido del alumno");
		} else {
			nomb = txtApellido.getText();
		}
		return nomb;
	}
	public String getDni() {
		String dni = null;
		if(txtDni.getText().trim().length() == 0) {
			mensajeError("Ingresar el DNI del alumno");
		}else {
			dni = txtDni.getText();
		}
		return txtDni.getText();
	}
	public String getTelef() {
		String telef = null;
		if(txtTelefono.getText().trim().length() == 0) {
			mensajeError("Ingresar el Teléfono  del alumno");
		}else {
			telef = txtTelefono.getText();
		}
		return txtTelefono.getText();
	}
	
	public int getEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	String nombreEstado(int i) {
        switch (i) {
            case 0: return "REGISTRADO";
            case 1: return "MATRICULADO";
            case 2: return "RETIRADO";
            default:return null;
        }
	 }
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodA.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.setText("");

		txtCodA.setText(arAlu.generarCodigoAlumno() + "");
		txtNombre.setText("");

		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int codA;
		String nomb, apell, tlf, dni;

		codA = getCodigoA();
		nomb = getNomA();
		apell = getApeA();
		tlf = getTelef();
		dni = getDni();

		if (nomb == null || apell == null || tlf == null || dni == null || codA == -1) {
			return;
		} else {
			Alumno alu = arAlu.buscarCodigoA(codA);

			if (alu != null) {
				int opcion = JOptionPane.showConfirmDialog(this, "¿Desea modificar el registro?", "Sistema",
						JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
					alu.setCodAlumno(codA);
					alu.setNomA(nomb);
					alu.setApeA(apell);
					alu.setTelef(tlf);
					alu.setDni(dni);
					
					arAlu.grabar();
					
					listar();
				}
			} else {
				mensajeError("[ERROR] El alumno no existe.");
			}
		}
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR", 0);
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Alumno alu = arAlu.buscarCodigoA(getCodigoA());

		if (alu != null) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Sistema",
					JOptionPane.YES_NO_OPTION);

			if (opcion == 0) {
				arAlu.eliminar(alu);
				arAlu.grabar();
				listar();
			}
		} else {
			mensajeError("[ERROR]: El código de alumno no existe.");
		}
	}

	//METODO CONSULTAR 
		private void consultar(int TipoConsulta , String DatoaBuscar) {
			model.setRowCount(0);

			for (int i = 0; i < arAlu.tamanio(); i++) {
				Alumno a = arAlu.obtener(i);
				if(TipoConsulta == 1) {
					if(a.getDni().startsWith(DatoaBuscar)) {
						Object fila [] = {a.getCodAlumno(),
								          a.getNomA(),
								          a.getApeA(),
								          a.getTelef(),
								          a.getDni(),
								          nombreEstado(a.getEstado())
						                 };
						model.addRow(fila);
					}
				}else {
					if(a.getApeA().startsWith(DatoaBuscar)) {
						Object fila [] = {a.getCodAlumno(),
						          a.getNomA(),
						          a.getApeA(),
						          a.getTelef(),
						          a.getDni(),
						          nombreEstado(a.getEstado())
				                 };
				      model.addRow(fila);
					}
					
				}
			}
		}
		protected void actionPerformedBtnBuscar(ActionEvent e) {
			int tipoConsulta = 0;
			String datoBuscar;

			if (rdbtnDNI.isSelected() == true) {
				tipoConsulta = 1;
			}
			if (rdbtnApellido.isSelected() == true) {
				tipoConsulta = 2;
			}

			datoBuscar = getDatoBuscar();
			consultar(tipoConsulta, datoBuscar);
		}

		private String getDatoBuscar() {
			String dato = null;
			dato = txtConsultar.getText().trim();
			return dato;
		}
	
		//METODO MOSTRAR DATOS
		private void mostrarDatos(int posFila) {
			String codA, nomb, apell, tlf, dni;
			codA = tblAlumno.getValueAt(posFila, 0).toString();
			nomb = tblAlumno.getValueAt(posFila, 1).toString();
			apell = tblAlumno.getValueAt(posFila, 2).toString();
			tlf = tblAlumno.getValueAt(posFila, 3).toString();
			dni = tblAlumno.getValueAt(posFila, 4).toString();
			txtCodA.setText(codA);
			txtNombre.setText(nomb);
			txtApellido.setText(apell);
			txtTelefono.setText(tlf);
			txtDni.setText(dni);

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
		if (e.getSource() == tblAlumno) {
			mouseReleasedTblAlumno(e);
		}
	}
	protected void mouseReleasedTblAlumno(MouseEvent e) {
		int posFila;
		posFila = tblAlumno.getSelectedRow();
		mostrarDatos(posFila);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblAlumno) {
			keyReleasedTblAlumno(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblAlumno(KeyEvent e) {
		int posFila;
		posFila = tblAlumno.getSelectedRow();
		mostrarDatos(posFila);
	}
	
}	
