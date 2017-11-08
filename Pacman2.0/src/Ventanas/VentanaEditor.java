package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;

public class VentanaEditor extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public ArrayList<String> aFotos;
	private JButton btnGuardarNivel, btnVolver;
	private String descripcion ;
	private JComboBox<String> comboBox;
	private Point puntoIni, puntoFin;
	private JButton btnPared, btnFondo, btnPacman;
	private ArrayList<String> fantasmas;
	private int contadorPacman = 0;
	private JLabel lblSeleccion;

	private void inicializarConFondo() {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				im.setDescription("Imagenes\\Fondo.png");
				JLabel lblFoto = new JLabel(im);
				panelCentro.add(lblFoto);
			}
		}
	}

	/*
	 * private void cargarFotos() { for (String ruta : aFotos) { ImageIcon im =
	 * new ImageIcon(ruta); im.setDescription(ruta); JLabel lblFoto = new
	 * JLabel(im); panelCentro.add(lblFoto); } }
	 */

	public VentanaEditor() {
		descripcion =  "Pared";
		fantasmas = new ArrayList<String>();
		fantasmas.add("Pinky");
		fantasmas.add("Inky");
		fantasmas.add("Clyde");
		fantasmas.add("Blinky");
		aFotos = VentanaPrincipal.bd.obtenerFotos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		lblSeleccion = new JLabel("");
		panelSur.add(lblSeleccion);
		if(descripcion.equals("Pared")){
			ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
			im.setDescription("Imagenes\\Pared.png");
			lblSeleccion.setIcon(im);
		}

		btnPared = new JButton("Pared");
		panelSur.add(btnPared);
		btnPared.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				descripcion = "Pared";
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				im.setDescription("Imagenes\\Pared.png");
				lblSeleccion.setIcon(im);
			}
		});

		btnFondo = new JButton("Fondo");
		panelSur.add(btnFondo);
		btnFondo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				descripcion = "Fondo";
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				im.setDescription("Imagenes\\Fondo.png");
				lblSeleccion.setIcon(im);
			}
		});

		/* Aniadir que solo pueda poner 1 */
		btnPacman = new JButton("Pacman");
		panelSur.add(btnPacman);
		btnPacman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				descripcion = "Pacman";
				ImageIcon im = new ImageIcon("Imagenes\\Pacman.png");
				im.setDescription("Imagenes\\Pacman.png");
				lblSeleccion.setIcon(im);
			}
		});

		/* Implementar que si quitan los fantasmas vuelvan a estar visibles. */
		comboBox = new JComboBox<String>();
		panelSur.add(comboBox);
		comboBox.addItem("Blinky");
		comboBox.addItem("Inky");
		comboBox.addItem("Pinky");
		comboBox.addItem("Clyde");
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=-1){
					String fantasmaSeleccion = (String) comboBox.getSelectedItem();
					descripcion = fantasmaSeleccion;
					switch (fantasmaSeleccion) {
					case "Blinky": {
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
						im.setDescription("Imagenes\\FantasmaRojo.png");
						lblSeleccion.setIcon(im);
					}
						break;
	
					case "Inky": {
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
						im.setDescription("Imagenes\\FantasmaAzul.png");
						lblSeleccion.setIcon(im);
					}
						break;
	
					case "Clyde": {
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
						im.setDescription("Imagenes\\FantasmaNaranja.png");
						lblSeleccion.setIcon(im);
					}
						break;
	
					case "Pinky": {
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
						im.setDescription("Imagenes\\FantasmaRosa.png");
						lblSeleccion.setIcon(im);
					}
						break;
					}
					comboBox.setSelectedIndex(-1);
					
				}else {
					descripcion = "Pared";
					ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
					im.setDescription("Imagenes\\Pared.png");
					lblSeleccion.setIcon(im);
				}
			}
		});

		btnGuardarNivel = new JButton("Guard.Nivel");
		btnGuardarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreNivel = JOptionPane.showInputDialog("Introduce el nombre del nivel: ");
				nombreNivel = "Niveles\\" + nombreNivel + ".dat";
				File f = new File(nombreNivel);
				while (f.exists()) {
					JOptionPane.showMessageDialog(null, "Ese nombre ya existe!!", "ERROR!!", JOptionPane.ERROR_MESSAGE);
					nombreNivel = JOptionPane.showInputDialog("Introduce el nombre del nivel: ");
					nombreNivel = nombreNivel + ".dat";
					f = new File(nombreNivel);
				}
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(nombreNivel);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					System.out.println("Guardamos fichero.");
					System.out.println("El panel tiene: " + panelCentro.getComponentCount());
					Object componentes[] = panelCentro.getComponents();
					for (int i = 0; i < componentes.length; i++)
						oos.writeObject(componentes[i]);
					oos.writeObject(null);
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El nivel ha sido guardado con éxito.", "OK!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelSur.add(btnGuardarNivel);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventPrinc = new VentanaPrincipal();
				ventPrinc.setLocationRelativeTo(null);
				ventPrinc.setVisible(true);
				dispose();
			}
		});
		panelSur.add(btnVolver);

		panelCentro = new JPanel();
		panelCentro.setBackground(Color.BLACK);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 25, 0, 0));
		/*
		 * Hay que aniadir al panelCentro un listener para los eventos de raton.
		 */
		panelCentro.addMouseListener(this);
		inicializarConFondo();
	}

	private void actualizarCombo() {
		comboBox.removeAllItems();
		for (String f : fantasmas)
			comboBox.addItem(f);
	}

	private String obtenerDescripcionLabel(JLabel lblFoto) {
		ImageIcon im = (ImageIcon) lblFoto.getIcon();
		String des = im.getDescription();
		return des;
	}

	private void restaurarFantasma(String des) {
		switch (des) {
		case "FantasmaAzul":
			fantasmas.add("Inky");
			break;
		case "FantasmaRosa":
			fantasmas.add("Pinky");
			break;
		case "FantasmaNaranja":
			fantasmas.add("Clyde");
			break;
		case "FantasmaRojo":
			fantasmas.add("Blinky");
			break;
		}
		comboBox.updateUI();
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getPoint();
		JLabel lblFoto = (JLabel) panelCentro.getComponentAt(p);
		String des = obtenerDescripcionLabel(lblFoto).substring(9, obtenerDescripcionLabel(lblFoto).length() - 4);
		System.out.println(des);
		switch (descripcion) {
		case "Pared": {
			// if (contadorPacman<1){
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
			im.setDescription("Imagenes\\Pared.png");
			lblFoto.setIcon(im);
			System.out.println(panelCentro.getComponentCount());
			// contadorPacman++;
			// }
		}
			break;
		case "Fondo": {
			/**Sacar la descripcion del label donde estas clickando, si es igual a pacman significa que estas quitando
			  el pacman. poner enable el boton pacman.
			if(== "Pacman") {
				tbtnPacman.setEnabled(true);	
			}**/
			
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
			im.setDescription("Imagenes\\Fondo.png");
			lblFoto.setIcon(im);
		}
			break;

		case "Pacman": {
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\Pacman.png");
			im.setDescription("Imagenes\\Pacman.png");
			lblFoto.setIcon(im);
		}
			break;

		case "Inky": {
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
			im.setDescription("Imagenes\\fantasmaAzul.png");
			lblFoto.setIcon(im);
			// comboBox.removeItem("Inky");
			fantasmas.remove("Inky");
		}
			break;

		case "Pinky": {
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
			im.setDescription("Imagenes\\FantasmaRosa.png");
			lblFoto.setIcon(im);
			// comboBox.removeItem("Pinky");
			fantasmas.remove("Pinky");
		}
			break;

		case "Blinky": {
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
			im.setDescription("Imagenes\\FantasmaRojo.png");
			lblFoto.setIcon(im);
			// comboBox.removeItem("Blinky");
			fantasmas.remove("Blinky");
		}
			break;

		case "Clyde": {
			restaurarFantasma(des);
			ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
			im.setDescription("Imagenes\\FantasmaNaranja.png");
			lblFoto.setIcon(im);
			// comboBox.removeItem("Clyde");
			fantasmas.remove("Clyde");
		}
			break;

		}
		actualizarCombo();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		puntoIni = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		puntoFin = e.getPoint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
