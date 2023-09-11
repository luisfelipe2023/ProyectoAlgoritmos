package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAsignacion;
import arreglos.ArregloCurso;
import entidade.Curso;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlg_AsignarCurso extends JDialog implements KeyListener, ActionListener {
	private final JLabel lblNewLabel = new JLabel("Buscar Curso");
	private JTextField txtAsigCurso;
	private JTable tblAsignarCurso;
	ArregloAsignacion arAsi= new ArregloAsignacion();
	DefaultTableModel model = new DefaultTableModel();
	ArregloCurso arCurso = new ArregloCurso();
	private JButton btnEnviarDat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlg_AsignarCurso dialog = new dlg_AsignarCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlg_AsignarCurso() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(0, 51, 102));
		setBounds(100, 100, 542, 425);
		getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 526, 52);
		getContentPane().add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel("Curso");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(10, 66, 59, 14);
			getContentPane().add(lblNewLabel_1);
		
		
			txtAsigCurso = new JTextField();
			txtAsigCurso.addKeyListener(this);
			txtAsigCurso.setBounds(79, 63, 307, 20);
			getContentPane().add(txtAsigCurso);
			txtAsigCurso.setColumns(10);
		
		
			btnEnviarDat = new JButton("Enviar Datos");
			btnEnviarDat.addActionListener(this);
			btnEnviarDat.setBounds(416, 63, 100, 23);
			getContentPane().add(btnEnviarDat);
		
	
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 96, 506, 279);
			getContentPane().add(scrollPane);
			
			tblAsignarCurso = new JTable();
			scrollPane.setViewportView(tblAsignarCurso);
			model.addColumn("Codigo curso");
			model.addColumn("Curso");
			model.addColumn("Categoria");
			model.addColumn("Modalidad");
			model.addColumn("Horas");
			model.addColumn("Vacantes");
			tblAsignarCurso.setModel(model);
	}
	
	private void consultarCurso(String nombreC) {
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
		if (e.getSource() == txtAsigCurso) {
			keyReleasedTxtAsigCurso(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtAsigCurso(KeyEvent e) {
		String nombreC ;
		nombreC= txtAsigCurso.getText().trim();
		consultarCurso(nombreC);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDat) {
			actionPerformedBtnEnviarDat(e);
		}
	}
	protected void actionPerformedBtnEnviarDat(ActionEvent e) {
		String codigo,nombre,categoria,modalidad,horas,vacantes;
		int fila;
		fila = tblAsignarCurso.getSelectedRow();
		codigo =tblAsignarCurso.getValueAt(fila,0).toString();
		nombre= tblAsignarCurso.getValueAt(fila,1).toString();
		categoria = tblAsignarCurso.getValueAt(fila,2).toString();
		modalidad = tblAsignarCurso.getValueAt(fila,3).toString();
		horas = tblAsignarCurso.getValueAt(fila,4).toString();
		vacantes = tblAsignarCurso.getValueAt(fila,5).toString();
		
		Frm_Asignacion.txtCodCur.setText(codigo);
		Frm_Asignacion.txtNomCur.setText(nombre);
		Frm_Asignacion.txtCategoriaCur.setText(categoria);
		Frm_Asignacion.txtModalidadCur.setText(modalidad);
		Frm_Asignacion.txtHorasCur.setText(horas);
		Frm_Asignacion.txtVacantesCur.setText(vacantes);
		
		this.dispose();
		
	}
}
