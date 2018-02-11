package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Clases.Usuario;
import Ficheros.GestionFicheros;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaScores extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelOeste, panelEste, panelCentro;
	private JTextArea textAreaScores;
	private JButton btnVolver;
	private JLabel lblHighscores;
	private JFrame vp;
	/**
	 * Launch the application.
	 */

	
	/**Este metodo carga el textArea con el nombre y la puntuacion en el fichero.**/
	private void cargarTextArea(){
		String texto="NOMBRE\tPUNTUACION\n";
		int mayor,pos;
		ArrayList<Usuario> a = GestionFicheros.volcarFicheroArrayUsuarios("USUARIOS.DAT");
		for(int i=0;i<a.size();i++){
			mayor=0;
			pos=0;
			for(int j=0;j<a.size();j++){	
				Usuario u = a.get(j);
				if(u.getPuntuacion()>mayor){
					mayor=u.getPuntuacion();
					pos=j;
				}
			}
			texto = texto + (i+1)+".- " + a.get(pos).getNombre() + "\t" + a.get(pos).getPuntuacion()+ "\n";
			a.get(pos).setPuntuacion(-1);
		}
		textAreaScores.setText(texto);
	}
	/**
	 * Create the frame.
	 */
	public VentanaScores(JFrame vp) {
		this.vp=vp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aE) {
			}
		});
		panelSur.add(btnVolver);
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		lblHighscores = new JLabel("HIGHSCORES");
		lblHighscores.setFont(new Font("Snap ITC", Font.ITALIC, 24));
		lblHighscores.setBounds(106, 22, 201, 43);
		panelCentro.add(lblHighscores);
		
		textAreaScores = new JTextArea();
		textAreaScores.setEditable(false);
		textAreaScores.setColumns(1);
		textAreaScores.setBounds(116, 76, 179, 241);
		cargarTextArea();
		JScrollPane scrollArea =  new JScrollPane(textAreaScores);
		scrollArea.setBounds(116, 76, 179, 241);
		panelCentro.add(scrollArea);
		this.setVisible(true);
		
	}
	
	/**Este metodo abre la cierra la ventana score y abre la ventana principal pulsando
	 * el boton volver*/
	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = (JButton)e.getSource();
		if (botonPulsado==btnVolver){
			this.dispose();
			vp.setVisible(true);
		}
	}
}
