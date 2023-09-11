package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAsignacion;
import entidade.Asignacion;
import entidade.Hora;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Frm_Asignacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblTitulo = new JLabel("Asignacion Docente");
	private JLabel lblcodAsig;
	private JTextField txtCodAsig;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JPanel panel;
	public static JLabel lblCodigoDocente;
	public static JTextField txtCodDocente;
	private JLabel lblNombreD;
	private JLabel lblApellidoD;
	public static JTextField txtNombreD;
	private JButton btnBuscarDoc;
	public static JTextField txtApellidoD;
	public static JTextField txtDniDoc;
	public static JTextField txtTelefonoDoc;
	public static JTextField txtCategoriaD;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_1;
	private JLabel lblCodCurso;
	private JLabel lblCurso;
	public static JTextField txtCodCur;
	public static JTextField txtNomCur;
	private JLabel lblCategoria;
	public static JTextField txtCategoriaCur;
	private JButton btnBuscarCur;
	public static JTextField txtModalidadCur;
	private JLabel lblModalidad;
	public static JTextField txtHorasCur;
	public static JTextField txtVacantesCur;
	private JLabel lblHoras;
	private JLabel lblVacantes;
	private JScrollPane scrollPane;
	private JTable tblAsignacion;
	
	DefaultTableModel model = new DefaultTableModel();
	ArregloAsignacion arAsig = new ArregloAsignacion();
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Asignacion frame = new Frm_Asignacion();
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
	public Frm_Asignacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Asignacion.class.getResource("/imagenes/colegial.png")));
		setTitle("Asignacion Docente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitulo.setForeground(new Color(0, 51, 102));
		lblTitulo.setIcon(new ImageIcon(Frm_Asignacion.class.getResource("/imagenes/profesor.png")));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 555, 55);
		contentPane.add(lblTitulo);
		
		lblcodAsig = new JLabel("Codigo Asignacion");
		lblcodAsig.setBounds(10, 66, 108, 14);
		contentPane.add(lblcodAsig);
		
		txtCodAsig = new JTextField();
		txtCodAsig.setEditable(false);
		txtCodAsig.setForeground(new Color(0, 51, 102));
		txtCodAsig.setBounds(128, 63, 86, 20);
		contentPane.add(txtCodAsig);
		txtCodAsig.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(237, 66, 46, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setForeground(new Color(0, 51, 102));
		txtFecha.setEditable(false);
		txtFecha.setBounds(293, 63, 100, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(403, 66, 46, 14);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setForeground(new Color(0, 51, 102));
		txtHora.setEditable(false);
		txtHora.setBounds(459, 63, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Docente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(7, 100, 538, 114);
		contentPane.add(panel);
		
		lblCodigoDocente = new JLabel("Codigo Docente");
		lblCodigoDocente.setBounds(10, 27, 89, 14);
		panel.add(lblCodigoDocente);
		
		txtCodDocente = new JTextField();
		txtCodDocente.setEditable(false);
		txtCodDocente.setColumns(10);
		txtCodDocente.setBounds(102, 24, 106, 20);
		panel.add(txtCodDocente);
		
		lblNombreD = new JLabel("Nombre ");
		lblNombreD.setBounds(10, 56, 82, 14);
		panel.add(lblNombreD);
		
		lblApellidoD = new JLabel("Apellido");
		lblApellidoD.setBounds(10, 81, 46, 14);
		panel.add(lblApellidoD);
		
		txtNombreD = new JTextField();
		txtNombreD.setEditable(false);
		txtNombreD.setColumns(10);
		txtNombreD.setBounds(102, 52, 205, 20);
		panel.add(txtNombreD);
		
		btnBuscarDoc = new JButton("Buscar");
		btnBuscarDoc.addActionListener(this);
		btnBuscarDoc.setBounds(218, 23, 89, 23);
		panel.add(btnBuscarDoc);
		
		txtApellidoD = new JTextField();
		txtApellidoD.setEditable(false);
		txtApellidoD.setColumns(10);
		txtApellidoD.setBounds(102, 78, 205, 20);
		panel.add(txtApellidoD);
		
		txtDniDoc = new JTextField();
		txtDniDoc.setEditable(false);
		txtDniDoc.setColumns(10);
		txtDniDoc.setBounds(421, 24, 107, 20);
		panel.add(txtDniDoc);
		
		txtTelefonoDoc = new JTextField();
		txtTelefonoDoc.setEditable(false);
		txtTelefonoDoc.setColumns(10);
		txtTelefonoDoc.setBounds(421, 53, 107, 20);
		panel.add(txtTelefonoDoc);
		
		txtCategoriaD = new JTextField();
		txtCategoriaD.setEditable(false);
		txtCategoriaD.setColumns(10);
		txtCategoriaD.setBounds(421, 78, 107, 20);
		panel.add(txtCategoriaD);
		
		lblNewLabel_4 = new JLabel("Dni");
		lblNewLabel_4.setBounds(335, 27, 76, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setBounds(335, 56, 76, 14);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setBounds(335, 81, 76, 14);
		panel.add(lblNewLabel_6);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 219, 535, 114);
		contentPane.add(panel_1);
		
		lblCodCurso = new JLabel("Codigo Curso");
		lblCodCurso.setBounds(10, 24, 89, 14);
		panel_1.add(lblCodCurso);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 49, 46, 14);
		panel_1.add(lblCurso);
		
		txtCodCur = new JTextField();
		txtCodCur.setEditable(false);
		txtCodCur.setColumns(10);
		txtCodCur.setBounds(105, 21, 106, 20);
		panel_1.add(txtCodCur);
		
		txtNomCur = new JTextField();
		txtNomCur.setEditable(false);
		txtNomCur.setColumns(10);
		txtNomCur.setBounds(105, 46, 205, 20);
		panel_1.add(txtNomCur);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 75, 71, 14);
		panel_1.add(lblCategoria);
		
		txtCategoriaCur = new JTextField();
		txtCategoriaCur.setEditable(false);
		txtCategoriaCur.setColumns(10);
		txtCategoriaCur.setBounds(105, 72, 205, 20);
		panel_1.add(txtCategoriaCur);
		
		btnBuscarCur = new JButton("Buscar");
		btnBuscarCur.addActionListener(this);
		btnBuscarCur.setBounds(221, 20, 89, 23);
		panel_1.add(btnBuscarCur);
		
		txtModalidadCur = new JTextField();
		txtModalidadCur.setEditable(false);
		txtModalidadCur.setColumns(10);
		txtModalidadCur.setBounds(403, 21, 122, 20);
		panel_1.add(txtModalidadCur);
		
		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(329, 24, 64, 14);
		panel_1.add(lblModalidad);
		
		txtHorasCur = new JTextField();
		txtHorasCur.setEditable(false);
		txtHorasCur.setColumns(10);
		txtHorasCur.setBounds(403, 46, 122, 20);
		panel_1.add(txtHorasCur);
		
		txtVacantesCur = new JTextField();
		txtVacantesCur.setEditable(false);
		txtVacantesCur.setColumns(10);
		txtVacantesCur.setBounds(403, 72, 122, 20);
		panel_1.add(txtVacantesCur);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(329, 49, 64, 14);
		panel_1.add(lblHoras);
		
		lblVacantes = new JLabel("Vacantes");
		lblVacantes.setBounds(329, 75, 64, 14);
		panel_1.add(lblVacantes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 381, 535, 183);
		contentPane.add(scrollPane);
		
		tblAsignacion = new JTable();
		scrollPane.setViewportView(tblAsignacion);
		
		model.addColumn("Codigo Asignacion");
		model.addColumn("Cod.Docente");
		model.addColumn("Docente");
		model.addColumn("Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		tblAsignacion.setModel(model);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(90, 347, 89, 23);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(242, 347, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(403, 344, 89, 23);
		contentPane.add(btnEliminar);
		txtCodAsig.setText(""+arAsig.generarCodigoAsig());
		txtFecha.setText(""+Hora.fechaActual());
		txtHora.setText(""+Hora.horaActual());
		btnEliminar.addActionListener(this);
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnBuscarCur) {
			actionPerformedBtnBuscarCur(e);
		}
		if (e.getSource() == btnBuscarDoc) {
			actionPerformedBtnBuscarDoc(e);
		}
		if(e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarAsignacion();
	}
	
	protected void actionPerformedBtnBuscarDoc(ActionEvent e) {
		dlg_BuscarDocente db = new dlg_BuscarDocente();
		db.setLocationRelativeTo(this);
		db.setVisible(true);
	}
	protected void actionPerformedBtnBuscarCur(ActionEvent e) {
		dlg_AsignarCurso as = new dlg_AsignarCurso();
		as.setLocationRelativeTo(this);
		as.setVisible(true);
	}
	/**BTN ADICIONAR**/
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarAsignacion();
		
	}
	
	public void eliminarAsignacion() {
		Asignacion as = arAsig.buscarCodigoAsig(getCodigoAsig());
		if(as != null) {
			int opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar?", "Sistema", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				arAsig.eliminar(as);
				arAsig.grabar();
				listar();
			}
		} else {
			mensajeError("Código de asignación no existe.");
		}
	}
	public void registrarAsignacion() {
		String nomDocente,nomCur,fecha,hora;
		int codAsig,codDoc;
		
		codAsig = getCodigoAsig();
		codDoc = getCodDocente();
		nomDocente = getnomDocente();
		nomCur = getnomCur();
		fecha = getFecha();
		hora = getHora();
		Asignacion asig = arAsig.buscarCodigoAsig(codAsig);
		if(asig == null) {
			asig = new Asignacion(codAsig,codDoc,nomDocente,nomCur,fecha,hora);
			asig.setCodAsig(codAsig);
			asig.setNomDocente(nomDocente);
			asig.setNomCurso(nomCur);
			asig.setFecha(fecha);
			asig.setHora(hora);
			JOptionPane.showMessageDialog(this, "EL DOCENTE   "+asig.getNomDocente()+"    a SIDO ASIGNADO AL CURSO   "+asig.getNomCurso());
			arAsig.adicionar(asig);
			arAsig.grabar();
			listar();
			
		}else {
			mensajeError("ERROR AL REALIZAR LA ASIGNACIÓN");
		}
		
		
		
	}
	/**************VALIDACIONES*************************/
	public int getCodigoAsig() {
		return Integer.parseInt(txtCodAsig.getText());
	}
	public int getCodDocente() {
		return Integer.parseInt(txtCodDocente.getText());
	}
	
	public String getnomDocente() {
		return txtNombreD.getText();
	}
	
	public String getnomCur() {
		return txtNomCur.getText();
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
	
	/************METODO LIMPIAR**********************/
	public void limpiar() {
		txtCodDocente.setText("");
		txtNombreD.setText("");
		txtApellidoD.setText("");
		txtCategoriaD.setText("");
		txtModalidadCur.setText("");
		txtHorasCur.setText("");
		txtDniDoc.setText("");
		txtTelefonoDoc.setText("");
		txtVacantesCur.setText("");
		txtCodCur.setText("");
		txtNomCur.setText("");
		txtCategoriaCur.setText("");
	}
	
	
	
	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arAsig.tamanio(); i++) {
			Object fila[]= {
					arAsig.obtener(i).getCodAsig(),
					arAsig.obtener(i).getCodDoc(),
					arAsig.obtener(i).getNomDocente(),
					arAsig.obtener(i).getNomCurso(),
					arAsig.obtener(i).getFecha(),
					arAsig.obtener(i).getHora()
			};
			model.addRow(fila);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodAsig.setText(arAsig.generarCodigoAsig() + "");
		txtHora.setText(""+Hora.horaActual());
		limpiar();
	}
}
