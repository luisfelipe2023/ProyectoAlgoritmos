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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlg_BuscarAlumno extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Buscar Alumno");
	private JLabel lblNewLabel_1;
	private JTextField txtBuscarApe;
	private JButton btnEnviarDatos;
	private JScrollPane scp;
	private JTable tblBuscarAlumno;
	DefaultTableModel model = new DefaultTableModel();
	ArregloAlumno arAlu = new ArregloAlumno();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dlg_BuscarAlumno frame = new dlg_BuscarAlumno();
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
	public dlg_BuscarAlumno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 483, 45);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBuscarApe = new JTextField();
		txtBuscarApe.addKeyListener(this);
		txtBuscarApe.setBounds(83, 54, 244, 20);
		contentPane.add(txtBuscarApe);
		txtBuscarApe.setColumns(10);
		
		btnEnviarDatos = new JButton("Enviar Datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setBounds(351, 53, 122, 23);
		contentPane.add(btnEnviarDatos);
		
		scp = new JScrollPane();
		scp.setBounds(10, 95, 463, 262);
		contentPane.add(scp);
		
		tblBuscarAlumno = new JTable();
		scp.setViewportView(tblBuscarAlumno);
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("DNI");
		model.addColumn("Teléfono");
		model.addColumn("Estado");
		tblBuscarAlumno.setModel(model);

	}
	
	private void consultarAlumno(String apellido) {
		model.setRowCount(0);
		for (int i = 0; i < arAlu.tamanio(); i++) {
			Alumno a = arAlu.obtener(i);
			if(a.getApeA().startsWith(apellido)) {
				Object fila[] = {
						a.getCodAlumno(),a.getNomA(),a.getApeA(),a.getDni(),a.getTelef(),nombreEstado(a.getEstado())
				};
				model.addRow(fila);
			}
			
		}
		
	}
	
	String nombreEstado(int i) {
        switch (i) {
            case 0: return "REGISTRADO";
            case 1: return "MATRICULADO";
            case 2: return "RETIRADO";
            default:return null;
        }
	 }
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarApe) {
			keyReleasedTxtBuscarApe(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscarApe(KeyEvent e) {
		String apellido ;
		apellido= txtBuscarApe.getText().trim();
		consultarAlumno(apellido);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		String cod,nombre,apellido,dni,telef,estado;
		int fila;
		fila = tblBuscarAlumno.getSelectedRow();
		
		cod = tblBuscarAlumno.getValueAt(fila,0).toString();
		nombre= tblBuscarAlumno.getValueAt(fila,1).toString();
		apellido = tblBuscarAlumno.getValueAt(fila,2).toString();
		dni = tblBuscarAlumno.getValueAt(fila,3).toString();
		telef = tblBuscarAlumno.getValueAt(fila,4).toString();
		estado = tblBuscarAlumno.getValueAt(fila,5).toString();
		
		Frm_Matricula.txtCodAlum.setText(cod);
		Frm_Matricula.txtNombreA.setText(nombre);
		Frm_Matricula.txtApellidoA.setText(apellido);
		Frm_Matricula.txtDni.setText(dni);
		Frm_Matricula.txtTelefono.setText(telef);
		Frm_Matricula.txtEstado.setText(estado);
		
		this.dispose();
		
	}
}
