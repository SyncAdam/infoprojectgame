package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dimension;

//import java.awt.Color;

import javax.swing.*;

public class GUI {
	//création des images : 
	ImageIcon BigRed = new ImageIcon("GUI/Pictures/BigRed.png");
	ImageIcon MediumRed = new ImageIcon("GUI/Pictures/MediumRed.png");
	ImageIcon SmallRed = new ImageIcon("GUI/Pictures/SmallRed.png");
	ImageIcon BigBlue = new ImageIcon("GUI/Pictures/BigBlue.png");
	ImageIcon MediumBlue = new ImageIcon("GUI/Pictures/MediumBlue.png");
	ImageIcon SmallBlue = new ImageIcon("GUI/Pictures/SmallBlue.png");
	
	JLabel[] Big = new JLabel[9];
	JLabel[] Medium = new JLabel[9];
	JLabel[] Small = new JLabel[9];
	JLayeredPane[] LayeredPane = new JLayeredPane[9]; //creation des layeredPane qui permettent d'empiler des label
	
	public GUI() {}
	public void create() {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); // récupère la hauteur de l'écran
		
	    JFrame Home = new JFrame("Home");
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet d'arreter le prog en cliquant sur la croix
		Home.setSize(400,400); // défini la taille de la fenetre à un carré de 100px de moins que la hauteur de l'écran
		Home.setResizable(false); // taille = fixe
		Home.setTitle("Otrio"); //titre du jeux
		Home.setLayout(new GridLayout(3,3));// permet de placer elements sur une grille
		Home.getContentPane().setBackground(Color.orange); // couleur du fond

		for (int i =0 ; i<9 ; i++) {
			LayeredPane[i] = new JLayeredPane(); // création des 9 layeredPane
			
			//LayeredPane[i].setLayout(null); // sert à dire que l'on veut placer manuellement les éléements dans les layeredPane
			Big[i] = new JLabel(); // création pour chaque case des 3 labels
			Medium[i] = new JLabel();
			Small[i] = new JLabel();
			
			Big[i].setBounds(0,0,100, 100); //permet de def la position et la taille des labels dans leurs LayeredPan
			Medium[i].setBounds(0,0,100, 100);
			Small[i].setBounds(0,0,100, 100);

			LayeredPane[i].add(Big[i]); //on ajoute les labels aux layeredPane
			LayeredPane[i].add(Medium[i]);
			LayeredPane[i].add(Small[i]);
			
			Home.add(LayeredPane[i]);// on ajoute les layered pan à la fenetre
		}
		Home.setVisible(true);
	}
	public void placePawn( int Posx, int Posy, int Size, int PlayerId) {
		
		int Pos =12; //permet de déf la position dans le bon format : x,y --> [0,8]
		if(Posx == 0 && Posy ==2) {Pos = 0;}
		if(Posx == 1 && Posy ==2) {Pos = 1;}
		if(Posx == 2 && Posy ==2) {Pos = 2;}
		if(Posx == 0 && Posy ==1) {Pos = 3;}
		if(Posx == 1 && Posy ==1) {Pos = 4;}
		if(Posx == 2 && Posy ==1) {Pos = 5;}
		if(Posx == 0 && Posy ==0) {Pos = 6;}
		if(Posx == 1 && Posy ==0) {Pos = 7;}
		if(Posx == 2 && Posy ==0) {Pos = 8;}
		
		//verification cas par cas des paramètres Taille et couleur (=Player iD);
		if(Size == 0 && PlayerId == 1) {Small[Pos].setIcon(SmallRed);}
		if(Size == 1 && PlayerId == 1) {Medium[Pos].setIcon(MediumRed);}
		if(Size == 2 && PlayerId == 1) {Big[Pos].setIcon(BigRed);}
		if(Size == 0 && PlayerId == 2) {Small[Pos].setIcon(SmallBlue);}
		if(Size == 1 && PlayerId == 2) {Medium[Pos].setIcon(MediumBlue);}
		if(Size == 2 && PlayerId == 2) {Big[Pos].setIcon(BigBlue);}
		}
	public void clear() {
		for(int i = 0 ; i<9 ; i++) {
			Big[i].setIcon(null);
			Medium[i].setIcon(null);
			Small[i].setIcon(null);
			
		}
	}
}

		
		
		
		
		
		
		
		
		
		
	
		
		
		
		

	
	
	


