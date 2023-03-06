import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField recibir;
	private JTextField enviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Conectar = new JButton("Conectar");
		Conectar.setBounds(54, 200, 103, 32);
		contentPane.add(Conectar);
		Conectar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String mensaje = LanzadorServer.main();
					recibir.setText(mensaje);
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton Enviar = new JButton("Enviar");
		Enviar.setBounds(274, 200, 103, 32);
		contentPane.add(Enviar);
		Enviar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensaje = enviar.getText();
				try {
					LanzadorCliente.main(mensaje);
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		recibir = new JTextField();
		recibir.setBounds(135, 52, 242, 32);
		contentPane.add(recibir);
		recibir.setColumns(10);
		
		enviar = new JTextField();
		enviar.setBounds(135, 124, 242, 32);
		contentPane.add(enviar);
		enviar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mensaje recibido:");
		lblNewLabel.setBounds(41, 54, 84, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mensaje a enviar:");
		lblNewLabel_1.setBounds(41, 124, 96, 32);
		contentPane.add(lblNewLabel_1);
	}
}
