package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCurso;
import entidade.Alumno;
import entidade.Curso;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlg_BuscarCurso extends JDialog implements KeyListener, ActionListener {
	private final JLabel lblNewLabel = new JLabel("Buscar Curso");
	private JLabel lblCategoria;
	private JButton btnEnviarDatos2;
	private JScrollPane scrollPane;
	private JTable tblBuscarCurso;
	DefaultTableModel model = new DefaultTableModel();
	ArregloCurso arCurso = new ArregloCurso();
	private JTextField txtBuscarCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlg_BuscarCurso dialog = new dlg_BuscarCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlg_BuscarCurso() {
		setBounds(100, 100, 522, 439);
		getContentPane().setBackground(new Color(255, 255, 153));
		getContentPane().setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 506, 49);
		getContentPane().add(lblNewLabel);
		
		lblCategoria = new JLabel("Curso");
		lblCategoria.setBounds(10, 64, 61, 14);
		getContentPane().add(lblCategoria);
		
		btnEnviarDatos2 = new JButton("Enviar Datos");
		btnEnviarDatos2.addActionListener(this);
		btnEnviarDatos2.setBounds(397, 60, 99, 23);
		getContentPane().add(btnEnviarDatos2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 486, 296);
		getContentPane().add(scrollPane);
		
		tblBuscarCurso = new JTable();
		scrollPane.setViewportView(tblBuscarCurso);
		
		model.addColumn("Codigo");
		model.addColumn("Curso");
		model.addColumn("Categoria");
		model.addColumn("Modalidad");
		model.addColumn("Horas");
		model.addColumn("Vacantes");
		
		tblBuscarCurso.setModel(model);
		
		txtBuscarCurso = new JTextField();
		txtBuscarCurso.addKeyListener(this);
		txtBuscarCurso.setBounds(83, 60, 286, 20);
		getContentPane().add(txtBuscarCurso);
		txtBuscarCurso.setColumns(10);
	}
	
	private void consultarAlumno(String nombreC) {
		model.setRowCount(0);
		for (int i = 0; i < arCurso.tamanio(); i++) {
			Curso a = arCurso.obtener(i);
			if(a.getNomCur().startsWith(nombreC)) {
				Object fila[] = {
						a.getCodCur(),a.getNomCur(), nombreCategoria( a.getCategoria()), nombreModalidad( a.getModalidad()),a.getHoras(),a.getVacantes()
				};
				model.addRow(fila);
			}
			
		}
		
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

	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarCurso) {
			keyReleasedTxtBuscarCurso(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscarCurso(KeyEvent e) {
		String nombreC ;
		nombreC= txtBuscarCurso.getText().trim();
		consultarAlumno(nombreC);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos2) {
			actionPerformedBtnEnviarDatos2(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos2(ActionEvent e) {
		String codigo,nombre,categoria,modalidad,horas,vacantes;
		int fila;
		fila = tblBuscarCurso.getSelectedRow();
		
		codigo = tblBuscarCurso.getValueAt(fila,0).toString();
		nombre= tblBuscarCurso.getValueAt(fila,1).toString();
		categoria = tblBuscarCurso.getValueAt(fila,2).toString();
		modalidad = tblBuscarCurso.getValueAt(fila,3).toString();
		horas = tblBuscarCurso.getValueAt(fila,4).toString();
		vacantes = tblBuscarCurso.getValueAt(fila,5).toString();
		
		
		Frm_Matricula.txtCodC.setText(codigo);
		Frm_Matricula.txtCurso.setText(nombre);
		Frm_Matricula.txtCategoria.setText(categoria);
		Frm_Matricula.txtModalidad.setText(modalidad);
		Frm_Matricula.txtHoras.setText(horas);
		Frm_Matricula.txtVacantes.setText(vacantes);
		
		this.dispose();
		
		
	}
}
