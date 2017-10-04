package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class VentanaNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public static Object aBi[][];
	public int columnas, filas;

	/**
	 * Create the frame.
	 */
	public VentanaNivel(Object aBi[][]) {

		VentanaNivel.aBi = aBi;

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

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 32, 0, 0));
		for (int i = 0; i < aBi.length; i++) {
			for (int j = 0; j < aBi[0].length; j++) {
				panelCentro.add((JLabel) aBi[i][j]);
				//System.out.println(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription());
			}
			setVisible(true);
		}

	}

}
