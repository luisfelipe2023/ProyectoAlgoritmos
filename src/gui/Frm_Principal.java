package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Frm_Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmDocente;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenu mnMatriculas;
	private JMenu mnRetiros;
	private JMenu mnAsignacion;
	private JMenu mnReportes;
	private final JLabel lbIcon = new JLabel("");
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiroAlumnos;
	private JMenuItem mntmAsignacion;
	private JMenuItem mntmReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Principal frame = new Frm_Principal();
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
	public Frm_Principal() {
		setTitle("Institucion educativa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Principal.class.getResource("/imagenes/colegial.png")));
		setBackground(new Color(240, 230, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 455);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sitema");
		mnSistema.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/salida.png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnSistema.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/configuracion.png")));
		menuBar.add(mnMantenimiento);
		
		mntmDocente = new JMenuItem("Docente");
		mntmDocente.addActionListener(this);
		mnMantenimiento.add(mntmDocente);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnMatriculas = new JMenu("Matriculas");
		mnMatriculas.addActionListener(this);
		mnMatriculas.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/registro.png")));
		menuBar.add(mnMatriculas);
		
		mntmMatricula = new JMenuItem("Matricula Alumno");
		mntmMatricula.addActionListener(this);
		mnMatriculas.add(mntmMatricula);
		
		mnRetiros = new JMenu("Retiros");
		mnRetiros.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/retiro.png")));
		menuBar.add(mnRetiros);
		
		mntmRetiroAlumnos = new JMenuItem("Retiro Alumnos");
		mntmRetiroAlumnos.addActionListener(this);
		mnRetiros.add(mntmRetiroAlumnos);
		
		mnAsignacion = new JMenu("Asignacion Docente");
		mnAsignacion.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/asignacion.png")));
		menuBar.add(mnAsignacion);
		
		mntmAsignacion = new JMenuItem("Asignacion");
		mntmAsignacion.addActionListener(this);
		mnAsignacion.add(mntmAsignacion);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/reporte.png")));
		menuBar.add(mnReportes);
		
		mntmReportes = new JMenuItem("Reportes");
		mntmReportes.addActionListener(this);
		mnReportes.add(mntmReportes);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbIcon.setIcon(new ImageIcon(Frm_Principal.class.getResource("/imagenes/ninos (1).png")));
		lbIcon.setBounds(0, 11, 687, 283);
		contentPane.add(lbIcon);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReportes) {
			actionPerformedMntmReportes(e);
		}
		if (e.getSource() == mntmAsignacion) {
			actionPerformedMntmAsignacion(e);
		}
		if (e.getSource() == mntmRetiroAlumnos) {
			actionPerformedMntmRetiroAlumnos(e);
		}
		if (e.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(e);
		}
	
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmDocente) {
			actionPerformedMntmDocente(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedMntmDocente(ActionEvent e) {
		Frm_Docente fd = new Frm_Docente();
		fd.setLocationRelativeTo(this);
		fd.setVisible(true);
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		Frm_Alumno fa = new Frm_Alumno();
		fa.setLocationRelativeTo(this);
		fa.setVisible(true);
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		Frm_Curso fc = new Frm_Curso();
		fc.setLocationRelativeTo(this);
		fc.setVisible(true);
	}
	protected void actionPerformedMntmMatricula(ActionEvent e) {
		Frm_Matricula fm = new Frm_Matricula();
		fm.setLocationRelativeTo(this);
		fm.setVisible(true);
	}
	protected void actionPerformedMntmRetiroAlumnos(ActionEvent e) {
		Frm_Retiro fr = new Frm_Retiro();
		fr.setLocationRelativeTo(this);
		fr.setVisible(true);
	}
	protected void actionPerformedMntmAsignacion(ActionEvent e) {
		Frm_Asignacion fs = new Frm_Asignacion();
		fs.setLocationRelativeTo(this);
		fs.setVisible(true);
	}
	protected void actionPerformedMntmReportes(ActionEvent e) {
		Frm_Reportes fp = new Frm_Reportes();
		fp.setLocationRelativeTo(this);
		fp.setVisible(true);
	
	}
}
