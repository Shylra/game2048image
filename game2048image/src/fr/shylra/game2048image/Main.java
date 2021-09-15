package fr.shylra.game2048image;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Main extends JPanel {

	boolean move;
	BufferedImage image;
	BufferedImage[] images = new BufferedImage[12];
	
	String plateau = "/plateau.jpg";
	String nb2 = "/deux.jpg";
	String nb4 = "/quatre.jpg";
	String nb8 = "/huit.jpg";
	String nb16 = "/seize.jpg";
	String nb32 = "/trente_deux.jpg";
	String nb64 = "/soixante_quatre.jpg";
	String nb128 = "/cent_vingt_huit.jpg";
	String nb256 = "/deux_cent_cinquante_six.jpg";
	String nb512 = "/cinq_cent_douze.jpg";
	String nb1024 = "/mille_vingt_quatre.jpg";
	String nb2048 = "/deux_mille_quarante_huit.jpg";
	String[] nbs = new String[] {plateau, nb2, nb4, nb8, nb16, nb32, nb64, nb128, nb256, nb512, nb1024, nb2048};
	int[][] map = new int[4][4];
	
	public Main(JFrame frm) {
		setSize(500, 500);
		setVisible(true);
		loadImage(nbs);

		Grille grille = new Grille();
		map = grille.map;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grille.map[i][j] < 10) {
					System.out.print("     ");
				} else if (grille.map[i][j] < 100) {
					System.out.print("    ");
				} else if (grille.map[i][j] < 1000) {
					System.out.print("   ");
				} else if (grille.map[i][j] < 10000) {
					System.out.print("  ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("\n");
		}
		System.out.println();
		frm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				move = false;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
					move = grille.droite();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
					move = grille.gauche();
				} else if (e.getKeyCode() == KeyEvent.VK_UP ) {
					move = grille.haut();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
					move = grille.bas();
				}
				if (!move) {
					System.out.println("cette action n'a généré aucun mouvement choisisez une autre action");
				} else {
					grille.Next();
					if (grille.IsOver()) {
						System.out.println("Game Over !");
					}
				}
				updateUI();
			}

		});
	}

	private void loadImage(String[] str) {
		for (int i = 0; i < 12; i++) {
			try {
				images[i] = ImageIO.read(Main.class.getResource(str[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images[0], 0, 0, 500, 500, this);
		if (map[0][0] != 0) {
			image = Image.Img(0, 0, map[0][0], images);
			g.drawImage(image, 15, 15, 107, 107, this);
		}
		if (map[0][1] != 0) {
			image = Image.Img(0, 0, map[0][1], images);
			g.drawImage(image, 136, 15, 107, 107, this);
		}
		if (map[0][2] != 0) {
			image = Image.Img(0, 0, map[0][2], images);
			g.drawImage(image, 258, 15, 107, 107, this);
		}
		if (map[0][3] != 0) {
			image = Image.Img(0, 0, map[0][3], images);
			g.drawImage(image, 379, 15, 107, 107, this);
		}
		if (map[1][0] != 0) {
			image = Image.Img(0, 0, map[1][0], images);
			g.drawImage(image, 15, 137, 107, 107, this);
		}
		if (map[1][1] != 0) {
			image = Image.Img(0, 0, map[1][1], images);
			g.drawImage(image, 136, 137, 107, 107, this);
		}
		if (map[1][2] != 0) {
			image = Image.Img(0, 0, map[1][2], images);
			g.drawImage(image, 258, 137, 107, 107, this);
		}
		if (map[1][3] != 0) {
			image = Image.Img(0, 0, map[1][3], images);
			g.drawImage(image, 379, 137, 107, 107, this);
		}
		if (map[2][0] != 0) {
			image = Image.Img(0, 0, map[2][0], images);
			g.drawImage(image, 15, 259, 107, 107, this);
		}
		if (map[2][1] != 0) {
			image = Image.Img(0, 0, map[2][1], images);
			g.drawImage(image, 136, 259, 107, 107, this);
		}
		if (map[2][2] != 0) {
			image = Image.Img(0, 0, map[2][2], images);
			g.drawImage(image, 258, 259, 107, 107, this);
		}
		if (map[2][3] != 0) {
			image = Image.Img(0, 0, map[2][3], images);
			g.drawImage(image, 379, 259, 107, 107, this);
		}
		if (map[3][0] != 0) {
			image = Image.Img(0, 0, map[3][0], images);
			g.drawImage(image, 15, 381, 107, 107, this);
		}
		if (map[3][1] != 0) {
			image = Image.Img(0, 0, map[3][1], images);
			g.drawImage(image, 136, 381, 107, 107, this);
		}
		if (map[3][2] != 0) {
			image = Image.Img(0, 0, map[3][2], images);
			g.drawImage(image, 258, 381, 107, 107, this);
		}
		if (map[3][3] != 0) {
			image = Image.Img(0, 0, map[3][3], images);
			g.drawImage(image, 379, 381, 107, 107, this);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frm = new JFrame();
				frm.setSize(515, 539);
				frm.setVisible(true);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.add(new Main(frm));
			}
		});
	}
}
