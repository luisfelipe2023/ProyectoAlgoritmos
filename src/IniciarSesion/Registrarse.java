package IniciarSesion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidade.ListaUsuario;
import entidade.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Registrarse extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_2;
	private JPasswordField txtContraseña;
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IniciarSesion abrir = new IniciarSesion();
		abrir.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public Registrarse() {
		setTitle("Registrarse");
		setBounds(100, 100, 392, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 153, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRARSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 21, 376, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Usuario :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 71, 81, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(128, 70, 175, 20);
		contentPanel.add(txtUsuario);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(21, 107, 94, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(128, 106, 175, 20);
		contentPanel.add(txtContraseña);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(224, 157, 119, 23);
		contentPanel.add(btnIniciarSesion);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setBounds(21, 157, 121, 23);
		contentPanel.add(btnRegistrarse);
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
		String usuario = txtUsuario.getText();
		String contraseña = txtContraseña.getText();
		
		Usuario obj = new Usuario();
		if(Usuario.verificarUsuarioNuevo(usuario) == -1){
			obj.setUsuario(usuario);
			obj.setContraseña(contraseña);
			ListaUsuario.agregar(obj);
			JOptionPane.showMessageDialog(this, "SE REGISTRO CORRECTAMENTE");
		}
		else {
			JOptionPane.showMessageDialog(this, "ESTE USUARIO YA EXISTE");
		}
	}
	
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		IniciarSesion abrir = new IniciarSesion();
		abrir.setVisible(true);
		this.dispose();
	}
}
