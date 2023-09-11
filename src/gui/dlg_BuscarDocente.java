package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloDocente;
import entidade.Curso;
import entidade.Docente;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlg_BuscarDocente extends JDialog implements KeyListener, ActionListener {
	private final JLabel lblBuscarDoc = new JLabel("Buscar Docente");
	private JTextField txtBuscarDoc;
	private JButton btnEnviarDatosDoc;
	private JScrollPane scrollPane;
	private JTable tblBuscarDocente;
	
	DefaultTableModel model = new DefaultTableModel();
	ArregloDocente arDoce = new ArregloDocente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlg_BuscarDocente dialog = new dlg_BuscarDocente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlg_BuscarDocente() {
		getContentPane().setBackground(new Color(255, 255, 153));
		setBounds(100, 100, 567, 384);
		getContentPane().setLayout(null);
		lblBuscarDoc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarDoc.setBounds(0, 0, 551, 46);
		getContentPane().add(lblBuscarDoc);
		
			JLabel lblBusApellido = new JLabel("Apellido");
			lblBusApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBusApellido.setBounds(10, 57, 75, 14);
			getContentPane().add(lblBusApellido);
		
		
			txtBuscarDoc = new JTextField();
			txtBuscarDoc.addKeyListener(this);
			txtBuscarDoc.setBounds(89, 54, 321, 20);
			getContentPane().add(txtBuscarDoc);
			txtBuscarDoc.setColumns(10);
		
		
		btnEnviarDatosDoc = new JButton("Enviar Datos");
		btnEnviarDatosDoc.addActionListener(this);
		btnEnviarDatosDoc.setBounds(435, 53, 106, 23);
		getContentPane().add(btnEnviarDatosDoc);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 531, 252);
		getContentPane().add(scrollPane);
		
		tblBuscarDocente = new JTable();
		scrollPane.setViewportView(tblBuscarDocente);
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Categoria");
		model.addColumn("Teléfono");
		model.addColumn("DNI");
		
		tblBuscarDocente.setModel(model);
		
	}
	
	private void consultarDocente(String nombreD) {
		model.setRowCount(0);
		for (int i = 0; i < arDoce.tamanio(); i++) {
			Docente d = arDoce.obtener(i);
			if(d.getApellido().startsWith(nombreD)) {
				Object fila[] = {
						d.getCodDocente(),d.getNombre(),d.getApellido(), nombreCategoria( d.getCategoria()),d.getTelefono(),d.getDni()
				};
				model.addRow(fila);
			}
			
		}
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
		if (e.getSource() == txtBuscarDoc) {
			keyReleasedTxtBuscarDoc(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscarDoc(KeyEvent e) {
		String nombreD ;
		nombreD= txtBuscarDoc.getText().trim();
		consultarDocente(nombreD);
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatosDoc) {
			actionPerformedBtnEnviarDatosDoc(e);
		}
	}
	protected void actionPerformedBtnEnviarDatosDoc(ActionEvent e) {
		String codigo,nombre,apellido,categoria,telefono,dni;
		int fila;
		fila = tblBuscarDocente.getSelectedRow();
		codigo =tblBuscarDocente.getValueAt(fila,0).toString();
		nombre= tblBuscarDocente.getValueAt(fila,1).toString();
		apellido = tblBuscarDocente.getValueAt(fila,2).toString();
		categoria = tblBuscarDocente.getValueAt(fila,3).toString();
		telefono = tblBuscarDocente.getValueAt(fila,4).toString();
		dni = tblBuscarDocente.getValueAt(fila,5).toString();
		
		Frm_Asignacion.txtCodDocente.setText(codigo);
		Frm_Asignacion.txtNombreD.setText(nombre);
		Frm_Asignacion.txtApellidoD.setText(apellido);
		Frm_Asignacion.txtCategoriaD.setText(categoria);
		Frm_Asignacion.txtTelefonoDoc.setText(telefono);
		Frm_Asignacion.txtDniDoc.setText(dni);
		
		this.dispose();
	}
}
