package GUI;
/*Pour Adam Méthodes que j'ai créées pour que tu puisses y rajouter a ta partie: 

 * name.create() initialise une fenetre / plateau vierge
 * name.placePawn(int PlayerId) //place graphiquement l'élément selectionné par le joueur sur le plateau ; /!\ : rentre dans une boucle
 * infinie et n'en sort que quand le joueur a cliqué sur une case !
 * name.clear() // efface graphiquement tous les éléments du plateau
 * name.setDisplayedText(String Text) // Affiche dans la zone de texte un message
 * name.getLastSize() // retourne la taille du dernier pion joué sous forme d'un int
 * name.getLastX() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * name.getLastY() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * 
 */




import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

//import javax.lang.model.util.SimpleElementVisitor14;

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
	ImageIcon BigPink = new ImageIcon("GUI/Pictures/BigPink.png");
	ImageIcon MediumPink = new ImageIcon("GUI/Pictures/MediumPink.png");
	ImageIcon SmallPink = new ImageIcon("GUI/Pictures/SmallPink.png");	
	ImageIcon BigBlack = new ImageIcon("GUI/Pictures/BigBlack.png");
	ImageIcon MediumBlack = new ImageIcon("GUI/Pictures/MediumBlack.png");
	ImageIcon SmallBlack = new ImageIcon("GUI/Pictures/SmallBlack.png");










	 //Creation des tous less autres elements à afficher :
	JLabel[] Big = new JLabel[9];
	JLabel[] Medium = new JLabel[9];
	JLabel[] Small = new JLabel[9];
	JLayeredPane[] LayeredPane = new JLayeredPane[9]; //creation des layeredPane qui permettent d'empiler des label
	JButton[] Button = new JButton[9]; //Creation des boutons invisibles de la grille


	JRadioButton smallSize = new JRadioButton("Small ring"); //Creation des 3 cases à cocher popour selectionner la taille
	JRadioButton mediumSize = new JRadioButton("Medium ring");
	JRadioButton bigSize = new JRadioButton("Big ring"); 
	ButtonGroup group = new ButtonGroup(); // groupe qui permet de faire en sorte que l'on puisse selectionner qu'une taille à la fois

	JLabel labelInfos = new JLabel("Default"); //Label qui affiche le texte
	JPanel Plateau = new JPanel(); // creation du conteneur du plateau de jeu
	JPanel Infos = new JPanel(); // creation du conteneur pour le label qui affiche le texte
	JPanel panelChoixTaille = new JPanel();

	public GUI() {}
	int i ;
	
	public void create() {
		
		
	    JFrame Home = new JFrame("Otrio");
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet d'arreter le prog en cliquant sur la croix
		Home.setSize(800,400); // défini la taille de la fenetre à un carré de 100px de moins que la hauteur de l'écran
		Home.setResizable(false); // taille = fixe
		Home.setLayout(null);// permet de placer les conteneurs librement sur la fenetre
		Home.getContentPane().setBackground(Color.white); // couleur du fond

		//config du conteneur du plateau
		Plateau.setBounds(0, 0, 400, 400); //postionnement et dimmmensions du plateau
		Plateau.setBackground(Color.white);
		Home.add(Plateau); // ajout du plateau à la fenetre
		Plateau.setLayout(new GridLayout(3,3)); // Disposition en grille des elements du plateau

		//config du conteneur du label d'information
		Infos.setLayout(null);
		Infos.setBounds(400,0,400,100);
		Infos.setBackground(Color.white);
		Home.add(Infos); // ajout du plateau à la fenetre
		
		//config du label d'information
		labelInfos.setLayout(null);
		labelInfos.setBounds(0, 0, 400, 100);
		labelInfos.setFont(new Font("Arial",Font.PLAIN,20));
		labelInfos.setVerticalAlignment(JLabel.CENTER);
		labelInfos.setHorizontalAlignment(JLabel.CENTER);
		Infos.add(labelInfos); // on ajoute le label à son conteneur

		//config du conteneur des boutons du choix de taille;
		//panelChoixTaille.setLayout(null);
		panelChoixTaille.setBounds(400, 100, 400, 300); //def taille et position
		panelChoixTaille.setBackground(Color.white);
		Home.add(panelChoixTaille); // on ajoute le panel à la fenetre

		//config du bouton choix de taille :
		panelChoixTaille.add(smallSize);
		panelChoixTaille.add(mediumSize);
		panelChoixTaille.add(bigSize);
		smallSize.setSelected(true); // par defaut le premier bouton est coché
		smallSize.setOpaque(false); //On rend les bouttons invisibles
		mediumSize.setOpaque(false);
		bigSize.setOpaque(false);
		






		//config du group de case a cocher:
		group.add(smallSize);
		group.add(mediumSize);
		group.add(bigSize);
		

		



		for ( i =0 ; i<9 ; i++) { //Boucle qui permet de créer les éléments necessaire à l'affichage / fonctionnement du plateau de jeu
			Button[i] = new JButton();
			LayeredPane[i] = new JLayeredPane(); // création des 9 layeredPane
			
			//LayeredPane[i].setLayout(null); // sert à dire que l'on veut placer manuellement les éléements dans les layeredPane
			Big[i] = new JLabel(); // création pour chaque case des 3 labels
			Medium[i] = new JLabel();
			Small[i] = new JLabel();
			
			Big[i].setBounds(0,0,100, 100); //permet de def la position et la taille des labels dans leurs LayeredPan
			Medium[i].setBounds(0,0,100, 100);
			Small[i].setBounds(0,0,100, 100);
			Button[i].setBounds(0, 0, 100, 100); //on donne les dimmensions du bouton
			Button[i].setOpaque(false); //On rend les bouttons invisibles
			Button[i].setContentAreaFilled(false);
			Button[i].setBorderPainted(true);
			
			LayeredPane[i].add(Big[i]); //on ajoute les labels aux layeredPane
			LayeredPane[i].add(Medium[i]);
			LayeredPane[i].add(Small[i]);
			LayeredPane[i].add(Button[i], 5); // ajout du bouton à la couche 5 du LayeredPane pour qu'il soit au dessus des autres éléments
			Plateau.add(LayeredPane[i]);// on ajoute les layered pan au plateau
		}


		Home.setVisible(true);
	}
	int Pos =10 ;
	int Size ; 



	public void placePawn(int PlayerId) {
		Pos = 10;
		System.out.println("Tout début place pawn, Pos ="+ Pos);
			
		labelInfos.setText("Select size then location."); //affiche l'instruction dans le label d'info
		smallSize.setSelected(true); //o car par défaut c'est "small ring" qui est coché
		//Size =0; // on le reprécise au cas ou le joueur garde small size selectionné
		

		

		
		while (Pos ==10){  //Tant qu'un bouton du plateau n'a pas été cliqué on reste dans la boucle
			

			smallSize.addActionListener(e -> Size =0); //on check quelle taille est selectionée et on actualise la variable size
			mediumSize.addActionListener(e -> Size =1);
			bigSize.addActionListener(e -> Size =2);

			//ADAM, POURQUOI LA BOUCLE NE MARCHE PAS ?
			/*for (i = 0 ; i<9 ; i++){
			Button[i].addActionListener(e -> Pos = i);
			}*/ 
			Button[0].addActionListener(e -> Pos = 0); //on associe la valeur de pos en fonction du bouton cliqué
			Button[1].addActionListener(e -> Pos = 1);
			Button[2].addActionListener(e -> Pos = 2);
			Button[3].addActionListener(e -> Pos = 3);
			Button[4].addActionListener(e -> Pos = 4);
			Button[5].addActionListener(e -> Pos = 5);
			Button[6].addActionListener(e -> Pos = 6);
			Button[7].addActionListener(e -> Pos = 7);
			Button[8].addActionListener(e -> Pos = 8);
			

		}
		
		
		

		//verification cas par cas des paramètres Taille et couleur (=Player iD);
		if(Size == 0 && PlayerId == 1) Small[Pos].setIcon(SmallRed);
		if(Size == 1 && PlayerId == 1) Medium[Pos].setIcon(MediumRed);
		if(Size == 2 && PlayerId == 1) Big[Pos].setIcon(BigRed);
		if(Size == 0 && PlayerId == 2) Small[Pos].setIcon(SmallBlue);
		if(Size == 1 && PlayerId == 2) Medium[Pos].setIcon(MediumBlue);
		if(Size == 2 && PlayerId == 2) Big[Pos].setIcon(BigBlue);
		if(Size == 0 && PlayerId == 3) Small[Pos].setIcon(SmallPink);
		if(Size == 1 && PlayerId == 3) Medium[Pos].setIcon(MediumPink);
		if(Size == 2 && PlayerId == 3) Big[Pos].setIcon(BigPink);
		if(Size == 0 && PlayerId == 4) Small[Pos].setIcon(SmallBlack);
		if(Size == 1 && PlayerId == 4) Medium[Pos].setIcon(MediumBlack);
		if(Size == 2 && PlayerId == 4) Big[Pos].setIcon(BigBlack);


		System.out.println("Fin place pawn, Pos ="+ Pos);
		
		Pos=10;	
		}

	public int getLastX(){ //retourne la dernière coordonnées x du dernier pion joué
		int Posx = 12;
		if (Pos == 0 ||Pos == 3||Pos == 6) Posx = 1;
		if (Pos == 1 ||Pos == 4||Pos == 7) Posx = 2;
		if (Pos == 2 ||Pos == 5||Pos == 8) Posx = 3;

		return Posx;
	}	
	public int getLastY(){ //retourne la dernière coordonnées y du dernier pion joué
			int Posy = 12;
			if (Pos == 6 ||Pos == 7||Pos == 8) Posy = 1;
			if (Pos == 3 ||Pos == 4||Pos == 5) Posy = 2;
			if (Pos == 0 ||Pos == 1||Pos == 2) Posy = 3;
	
			return Posy;
		}	
	public void clear() {
		for(int i = 0 ; i<9 ; i++) {
			Big[i].setIcon(null);
			Medium[i].setIcon(null);
			Small[i].setIcon(null);
			
		}
	}
	public void setDisplayedText(String text){
		labelInfos.setText(text);
	}
	public int getLastSize(){
		return Size;
	}

	
	
	
}