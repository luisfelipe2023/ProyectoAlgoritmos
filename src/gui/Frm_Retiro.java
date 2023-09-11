package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import entidade.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class Frm_Retiro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Retiro");
	DefaultTableModel model = new DefaultTableModel();
	ArregloMatricula arMat = new ArregloMatricula();
	ArregloAlumno arAlu = new ArregloAlumno();
	ArregloRetiro arRetiro = new ArregloRetiro();
	ArregloDocente arDocente = new ArregloDocente();
	private JPanel panel;
	private JLabel lblCodigoA;
	public static JTextField txtCodAlumno;
	private JLabel lblNombre;
	private JLabel lblApellido;
	public static JTextField txtNombreALumno;
	private JButton btnBuscarAlu;
	public static JTextField txtApellidoAlum;
	public static JTextField txtDniAlumno;
	public static JTextField txtTelefonoAlumno;
	public static JTextField txtEstadoAlumno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane scp;
	private JTable tblRetiro;
	private JButton btnNuevo;
	private JButton btRegistarRe;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblcodRetiro;
	private JTextField txtCodRetiro;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Retiro frame = new Frm_Retiro();
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
	public Frm_Retiro() {
		setTitle("Retiro");
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setBackground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 572, 50);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 96, 552, 114);
		contentPane.add(panel);
		
		lblCodigoA = new JLabel("Codigo Alumno");
		lblCodigoA.setBounds(10, 27, 89, 14);
		panel.add(lblCodigoA);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(102, 24, 106, 20);
		panel.add(txtCodAlumno);
		
		lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 56, 82, 14);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 81, 46, 14);
		panel.add(lblApellido);
		
		txtNombreALumno = new JTextField();
		txtNombreALumno.setEditable(false);
		txtNombreALumno.setColumns(10);
		txtNombreALumno.setBounds(102, 52, 205, 20);
		panel.add(txtNombreALumno);
		
		btnBuscarAlu = new JButton("Buscar");
		btnBuscarAlu.addActionListener(this);
		btnBuscarAlu.setBounds(218, 23, 89, 23);
		panel.add(btnBuscarAlu);
		
		txtApellidoAlum = new JTextField();
		txtApellidoAlum.setEditable(false);
		txtApellidoAlum.setColumns(10);
		txtApellidoAlum.setBounds(102, 78, 205, 20);
		panel.add(txtApellidoAlum);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setColumns(10);
		txtDniAlumno.setBounds(421, 24, 121, 20);
		panel.add(txtDniAlumno);
		
		txtTelefonoAlumno = new JTextField();
		txtTelefonoAlumno.setEditable(false);
		txtTelefonoAlumno.setColumns(10);
		txtTelefonoAlumno.setBounds(421, 53, 121, 20);
		panel.add(txtTelefonoAlumno);
		
		txtEstadoAlumno = new JTextField();
		txtEstadoAlumno.setEditable(false);
		txtEstadoAlumno.setColumns(10);
		txtEstadoAlumno.setBounds(421, 78, 121, 20);
		panel.add(txtEstadoAlumno);
		
		lblNewLabel_1 = new JLabel("Dni");
		lblNewLabel_1.setBounds(335, 27, 76, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(335, 56, 76, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setBounds(335, 81, 76, 14);
		panel.add(lblNewLabel_3);
		
		scp = new JScrollPane();
		scp.setBounds(10, 270, 552, 277);
		contentPane.add(scp);
		
		tblRetiro = new JTable();
		scp.setViewportView(tblRetiro);
		
		model.addColumn("Codigo de Retiro");
		model.addColumn("Codigo de Alumno");
		model.addColumn("Nombre Alumno");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		tblRetiro.setModel(model);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Frm_Retiro.class.getResource("/imagenes/documento.png")));
		btnNuevo.setBounds(10, 221, 99, 38);
		contentPane.add(btnNuevo);
		
		btRegistarRe = new JButton("Registrar");
		btRegistarRe.addActionListener(this);
		btRegistarRe.setIcon(new ImageIcon(Frm_Retiro.class.getResource("/imagenes/registro.png")));
		btRegistarRe.setBounds(144, 221, 115, 38);
		contentPane.add(btRegistarRe);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Frm_Retiro.class.getResource("/imagenes/editar.png")));
		btnModificar.setBounds(299, 221, 115, 38);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(Frm_Retiro.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.setBounds(447, 221, 115, 38);
		contentPane.add(btnEliminar);
		
		lblcodRetiro = new JLabel("Codigo de Retiro");
		lblcodRetiro.setBounds(10, 71, 99, 14);
		contentPane.add(lblcodRetiro);
		
		txtCodRetiro = new JTextField();
		txtCodRetiro.setEditable(false);
		txtCodRetiro.setBounds(119, 68, 115, 20);
		contentPane.add(txtCodRetiro);
		txtCodRetiro.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(244, 71, 46, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(299, 65, 99, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(421, 71, 46, 14);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(476, 65, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		txtCodRetiro.setText(""+arRetiro.generarCodigoRetiro());
		txtFecha.setText(""+Hora.fechaActual());
		txtHora.setText(""+Hora.horaActual());
		listar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btRegistarRe) {
			actionPerformedBtRegistarRe(e);
		}
		if (e.getSource() == btnBuscarAlu) {
			actionPerformedBtnBuscarAlu(e);
		}
	}
	protected void actionPerformedBtnBuscarAlu(ActionEvent e) {
		dlg_BuscarAlumnoRetiro br = new dlg_BuscarAlumnoRetiro();
		br.setLocationRelativeTo(this);
		br.setVisible(true);
	}
	protected void actionPerformedBtRegistarRe(ActionEvent e) {
		adicionarRetiro();
	}
	public void adicionarRetiro() {
		int codR,codA;
		String  nombreA,fecha,hora;
		
		codR = getCodigoRetiro();
		codA = getCodigoAlu();
		nombreA = getNombreAlu();
		fecha = getFecha();
		hora = getHora();
		
		Retiro r = arRetiro.buscarCodRet(codR);
		if(r ==null) {
			r = new Retiro();
			r.setCodRetiro(codR);
			r.setCodAlumno(codA);
			r.setNomAlumno(nombreA);
			r.setFecha(fecha);
			r.setHora(hora);
			arRetiro.adicionar(r);
			Alumno a = arAlu.buscarCodigoA(codA);
			a.setEstado(2);
			arAlu.grabar();
			listar();
		}else {
			mensajeError("EROR el RETIRO");
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtHora.setText(""+Hora.horaActual());
		limpiar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarRetiro();
	}
	public void eliminarRetiro() {
		Retiro ret = arRetiro.buscarCodRet(getCodigoRetiro());
		if(ret !=null) {
			int opcion= JOptionPane.showConfirmDialog(this, "Seguro de eliminar ? ", "Sistema", JOptionPane.YES_NO_OPTION);
			//validar 
			if(opcion==0) {
				arRetiro.eliminar(ret);
				arRetiro.grabar();
			//actualizar la tabla
				listar();
			}
		} else {
			mensajeError("Codigo del docente no existe");
		}
		
	}
	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arRetiro.tamanio(); i++) {
			Object fila [] = {
					arRetiro.obtener(i).getCodRetiro(),
					arRetiro.obtener(i).getCodAlumno(),
					arRetiro.obtener(i).getNomAlumno(),
					arRetiro.obtener(i).getFecha(),
					arRetiro.obtener(i).getHora()
					
			};
			model.addRow(fila);
		}
	}
	
	public int getCodigoRetiro() {
		return Integer.parseInt(txtCodRetiro.getText());
	}
	public int getCodigoAlu() {
		return Integer.parseInt(txtCodAlumno.getText());
	}
	public String getNombreAlu() {
		return txtNombreALumno.getText();
	}
	public String getFecha() {
		return txtFecha.getText();
	}
	
	public String getHora() {
		return txtHora.getText();
	}
	/****MENSAJE ERROR**/
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!!", 0);
	}

	/************METODO LIMPIAR***************/
	public void limpiar() {
		txtCodAlumno.setText("");
		txtNombreALumno.setText("");
		txtApellidoAlum.setText("");
		txtDniAlumno.setText("");
		txtTelefonoAlumno.setText("");
		txtEstadoAlumno.setText("");
	}
	
	
	
	
}
