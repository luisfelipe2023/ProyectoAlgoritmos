package IniciarSesion;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidade.Usuario;
import gui.Frm_Principal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class IniciarSesion extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarSesion dialog = new IniciarSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarSesion() {
		setTitle("Iniciar Sesion");
		getContentPane().setBackground(new Color(255, 255, 102));
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 153, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
			lblIniciarSesion.setForeground(new Color(0, 51, 153));
			lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
			lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblIniciarSesion.setBounds(0, 11, 424, 27);
			contentPanel.add(lblIniciarSesion);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Usuario :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(37, 100, 81, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(221, 99, 175, 20);
			contentPanel.add(txtUsuario);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a : ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(37, 155, 94, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtContraseña = new JPasswordField();
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(221, 154, 175, 20);
			contentPanel.add(txtContraseña);
		}
		{
			btnIniciarSesion = new JButton("Iniciar Sesion");
			btnIniciarSesion.addActionListener(this);
			btnIniciarSesion.setBounds(277, 202, 119, 30);
			contentPanel.add(btnIniciarSesion);
		}
		{
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(this);
			btnRegistrarse.setBounds(37, 202, 121, 30);
			contentPanel.add(btnRegistrarse);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
		if (e.getSource() == btnRegistrarse) {
			actionPerformedBtnRegistrarse(e);
		}
	}
	
	protected void actionPerformedBtnRegistrarse(ActionEvent e) {
		Registrarse abrir = new Registrarse();
		abrir.setVisible(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		String usuario = txtUsuario.getText();
		String contraseña = txtContraseña.getText();
		int pos = Usuario.verificarLogueo(usuario, contraseña);
		if(pos == -1) {
			JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTO");
		}else {
			Frm_Principal abrir = new Frm_Principal();
			abrir.setVisible(true);
			this.dispose();
		}
	}
}
