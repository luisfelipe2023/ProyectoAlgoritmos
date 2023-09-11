package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import entidade.Alumno;
import entidade.Curso;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlg_BuscarAlumnoRetiro extends JDialog implements KeyListener, ActionListener {
	private final JLabel lblNewLabel = new JLabel("Buscar Alumno");
	private JTextField txtBuscarAlumno;
	private JTable tblBuscarCretiro;
	DefaultTableModel model = new DefaultTableModel(); 
	ArregloAlumno arAlu = new ArregloAlumno();
	private JButton btnEnviarDat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlg_BuscarAlumnoRetiro dialog = new dlg_BuscarAlumnoRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlg_BuscarAlumnoRetiro() {
		getContentPane().setBackground(new Color(255, 255, 153));
		setBounds(100, 100, 518, 439);
		getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(0, 0, 503, 58);
		getContentPane().add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel("Apellido");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 78, 55, 14);
			getContentPane().add(lblNewLabel_1);

		
			txtBuscarAlumno = new JTextField();
			txtBuscarAlumno.addKeyListener(this);
			txtBuscarAlumno.setBounds(109, 75, 224, 20);
			getContentPane().add(txtBuscarAlumno);
			txtBuscarAlumno.setColumns(10);
		
			btnEnviarDat = new JButton("Enviar Datos");
			btnEnviarDat.addActionListener(this);
			btnEnviarDat.setForeground(new Color(0, 51, 102));
			btnEnviarDat.setToolTipText("");
			btnEnviarDat.setBounds(386, 74, 106, 23);
			getContentPane().add(btnEnviarDat);
	
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 103, 482, 286);
			getContentPane().add(scrollPane);
			
			tblBuscarCretiro = new JTable();
			scrollPane.setViewportView(tblBuscarCretiro);
			model.addColumn("Codigo");
			model.addColumn("Curso");
			model.addColumn("Categoria");
			model.addColumn("Modalidad");
			model.addColumn("Horas");
			model.addColumn("Vacantes");
			
			tblBuscarCretiro.setModel(model);
	
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
		if (e.getSource() == txtBuscarAlumno) {
			keyReleasedTxtBuscarAlumno(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscarAlumno(KeyEvent e) {
		String nombreC ;
		nombreC= txtBuscarAlumno.getText().trim();
		consultarAlumno(nombreC);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDat) {
			actionPerformedBtnEnviarDat(e);
		}
	}
	protected void actionPerformedBtnEnviarDat(ActionEvent e) {
		String cod,nombre,apellido,dni,telef,estado;
		int fila;
		fila = tblBuscarCretiro.getSelectedRow();
		
		cod = tblBuscarCretiro.getValueAt(fila,0).toString();
		nombre= tblBuscarCretiro.getValueAt(fila,1).toString();
		apellido = tblBuscarCretiro.getValueAt(fila,2).toString();
		dni = tblBuscarCretiro.getValueAt(fila,3).toString();
		telef = tblBuscarCretiro.getValueAt(fila,4).toString();
		estado = tblBuscarCretiro.getValueAt(fila,5).toString();
		
		Frm_Retiro.txtCodAlumno.setText(cod);
		Frm_Retiro.txtNombreALumno.setText(nombre);
		Frm_Retiro.txtApellidoAlum.setText(apellido);
		Frm_Retiro.txtDniAlumno.setText(dni);
		Frm_Retiro.txtTelefonoAlumno.setText(telef);
		Frm_Retiro.txtEstadoAlumno.setText(estado);
		
		
		this.dispose();
	}
}
