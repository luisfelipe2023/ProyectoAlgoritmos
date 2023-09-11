package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidade.*;
import arreglos.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Frm_Reportes extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Reportes");
	private JLabel lblNewLabel_1;
	private JComboBox cboReportes;
	private JScrollPane scrollPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JButton btnBuscar;

	ArregloCurso arCur = new ArregloCurso();
	ArregloAlumno arAlu = new ArregloAlumno();
	ArregloDocente arDoc = new ArregloDocente();
	ArregloAsignacion arAsi = new ArregloAsignacion();
	ArregloMatricula arMat = new ArregloMatricula();
	
	private JTable tblReportes;
	DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Reportes frame = new Frm_Reportes();
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
	public Frm_Reportes() {
		setTitle("Reportes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Reportes.class.getResource("/imagenes/aprender-en-linea.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(Frm_Reportes.class.getResource("/imagenes/reporte-de-negocios (1).png")));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 523, 63);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tipo de Reporte:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 78, 143, 18);
		contentPane.add(lblNewLabel_1);
		
		cboReportes = new JComboBox();
		cboReportes.setModel(new DefaultComboBoxModel<String>(new String[] {"Listar cursos matriculados de un alumno.", "Listar cursos asignados de un docente.", "Alumnos matriculados en un curso.", "Docentes sin asignación", "Alumnos no matriculados."}));
		cboReportes.setBounds(163, 74, 350, 22);
		cboReportes.addActionListener(this);
		contentPane.add(cboReportes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 503, 293);
		contentPane.add(scrollPane);
		
		tblReportes = new JTable();
		tblReportes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReportes);
		scrollPane.setViewportView(tblReportes);
		
		model.addColumn("-");
		model.addColumn("-");
		model.addColumn("-");
		model.addColumn("-");
		
		tblReportes.setModel(model);
		
		lblCodigo = new JLabel("Ingrese el c\u00F3digo:");
		lblCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCodigo.setBounds(10, 107, 143, 18);
		lblCodigo.setVisible(false);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(163, 107, 117, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setVisible(false);
		txtCodigo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(290, 106, 89, 23);
		btnBuscar.setVisible(false);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if(e.getSource() == cboReportes) {
			actionPerformedCboReportes(e);
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if(cboReportes.getSelectedIndex() == 0) {
			if(txtCodigo.getText().length() != 0) {
				model.setRowCount(0);
				for(int i = 0; i < arMat.tamanio(); i++) {
					Matricula m = arMat.obtener(i);
					int codigo = Integer.parseInt(txtCodigo.getText());
					if(m.getCodA() == codigo) {
						Object fila[] = {
								m.getCodM(), m.getCodC() ,m.getFecha(), m.getHora()
						};
						model.addRow(fila);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Debe de ingresar el código", "Error", 0);
			}
		}
		if(cboReportes.getSelectedIndex() == 1) {
			if(txtCodigo.getText().length() != 0) {
				model.setRowCount(0);
				for(int i = 0; i < arAsi.tamanio(); i++) {
					Asignacion a = arAsi.obtener(i);
					Curso c = arCur.obtener(i);
					String nombre = txtCodigo.getText().trim();
					if(a.getNomDocente() == nombre) {
						Object fila[] = {
								a.getCodAsig(),c.getNomCur() , a.getFecha(), a.getHora()
						};
						model.addRow(fila);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Debe de ingresar el código", "Error", 0);
			}
		}
		if(cboReportes.getSelectedIndex() == 2) {
			if(txtCodigo.getText().length() != 0) {
				model.setRowCount(0);
				for(int i = 0; i < arMat.tamanio(); i++) {
					Matricula m = arMat.obtener(i);
					int codigo = Integer.parseInt(txtCodigo.getText());
					if(m.getCodC() == codigo) {
						Object fila[] = {
								m.getCodM(), m.getCodA(), m.getFecha(), m.getHora()
						};
						model.addRow(fila);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Debe de ingresar el código", "Error", 0);
			}
		}
	}
	
	protected void actionPerformedCboReportes(ActionEvent e) {
		if(cboReportes.getSelectedIndex() == 0) {
			model.setRowCount(0);
			txtCodigo.setVisible(true);
			lblCodigo.setVisible(true);
			btnBuscar.setVisible(true);
			JTableHeader tableHeader = tblReportes.getTableHeader();
			TableColumnModel tableColumnModel = tableHeader.getColumnModel();
			TableColumn tableColumn1 = tableColumnModel.getColumn(0);
			TableColumn tableColumn2 = tableColumnModel.getColumn(1);
			TableColumn tableColumn3 = tableColumnModel.getColumn(2);
			TableColumn tableColumn4 = tableColumnModel.getColumn(3);
			tableColumn1.setHeaderValue( "Cod.Alumno" );
			tableColumn2.setHeaderValue("Cod.Curso");
			tableColumn3.setHeaderValue("Fecha");
			tableColumn4.setHeaderValue("Hora");
			tableHeader.repaint();
		}
		if(cboReportes.getSelectedIndex() == 1) {
			model.setRowCount(0);
			txtCodigo.setVisible(true);
			lblCodigo.setVisible(true);
			btnBuscar.setVisible(true);
			JTableHeader tableHeader = tblReportes.getTableHeader();
			TableColumnModel tableColumnModel = tableHeader.getColumnModel();
			TableColumn tableColumn1 = tableColumnModel.getColumn(0);
			TableColumn tableColumn2 = tableColumnModel.getColumn(1);
			TableColumn tableColumn3 = tableColumnModel.getColumn(2);
			TableColumn tableColumn4 = tableColumnModel.getColumn(3);
			tableColumn1.setHeaderValue( "Cod.Asig" );
			tableColumn2.setHeaderValue("Nombre Curso");
			tableColumn3.setHeaderValue("Fecha");
			tableColumn4.setHeaderValue("Hora");
			tableHeader.repaint();
			
			
		}
		if(cboReportes.getSelectedIndex() == 2) {
			model.setRowCount(0);
			txtCodigo.setVisible(true);
			lblCodigo.setVisible(true);
			btnBuscar.setVisible(true);
			JTableHeader tableHeader = tblReportes.getTableHeader();
			TableColumnModel tableColumnModel = tableHeader.getColumnModel();
			TableColumn tableColumn1 = tableColumnModel.getColumn(0);
			TableColumn tableColumn2 = tableColumnModel.getColumn(1);
			TableColumn tableColumn3 = tableColumnModel.getColumn(2);
			TableColumn tableColumn4 = tableColumnModel.getColumn(3);
			tableColumn1.setHeaderValue( "Cod.Matrícula" );
			tableColumn2.setHeaderValue("Cod.Alumno");
			tableColumn3.setHeaderValue("Fecha");
			tableColumn4.setHeaderValue("Hora");
			tableHeader.repaint();
		}
		if(cboReportes.getSelectedIndex() == 3) {
			model.setRowCount(0);
			txtCodigo.setVisible(false);
			lblCodigo.setVisible(false);
			btnBuscar.setVisible(false);
			JTableHeader tableHeader = tblReportes.getTableHeader();
			TableColumnModel tableColumnModel = tableHeader.getColumnModel();
			TableColumn tableColumn1 = tableColumnModel.getColumn(0);
			TableColumn tableColumn2 = tableColumnModel.getColumn(1);
			TableColumn tableColumn3 = tableColumnModel.getColumn(2);
			TableColumn tableColumn4 = tableColumnModel.getColumn(3);
			tableColumn1.setHeaderValue( "Cod.Docente" );
			tableColumn2.setHeaderValue("Nombre");
			tableColumn3.setHeaderValue("Apellido");
			tableColumn4.setHeaderValue("DNI");
			tableHeader.repaint();
			
			for(int i = 0; i<arDoc.tamanio(); i++) {
				Object fila [] = {arDoc.obtener(i).getCodDocente(),
						arDoc.obtener(i).getNombre(),
						arDoc.obtener(i).getApellido(),
						   arDoc.obtener(i).getDni()};
				model.addRow(fila);
			}
			/*
			 * 
			 * 
			 * 
			 * 
			 */

			
		}
		if(cboReportes.getSelectedIndex() == 4) {
			txtCodigo.setVisible(false);
			lblCodigo.setVisible(false);
			btnBuscar.setVisible(false);
			JTableHeader tableHeader = tblReportes.getTableHeader();
			TableColumnModel tableColumnModel = tableHeader.getColumnModel();
			TableColumn tableColumn1 = tableColumnModel.getColumn(0);
			TableColumn tableColumn2 = tableColumnModel.getColumn(1);
			TableColumn tableColumn3 = tableColumnModel.getColumn(2);
			TableColumn tableColumn4 = tableColumnModel.getColumn(3);
			tableColumn1.setHeaderValue( "Cod.Alumno" );
			tableColumn2.setHeaderValue("Nombre");
			tableColumn3.setHeaderValue("Apellido");
			tableColumn4.setHeaderValue("DNI");
			tableHeader.repaint();
			model.setRowCount(0);
			for(int i = 0; i < arAlu.tamanio(); i++) {
				if(arAlu.obtener(i).getEstado() == 0) {
					Object fila[] = {
							arAlu.obtener(i).getCodAlumno(), arAlu.obtener(i).getNomA(),
							arAlu.obtener(i).getApeA(), arAlu.obtener(i).getDni()
					};
					model.addRow(fila);
				}
			}
		}
	}
}