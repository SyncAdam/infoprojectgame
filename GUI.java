package GUI;
/*Pour Adam Méthodes que j'ai créées pour que tu puisses y rajouter a ta partie: 

 * name.create() initialise une fenetre / plateau vierge
 * name.tryPawn(int PlayerId) //place graphiquement l'élément selectionné par le joueur sur le plateau ; /!\ : rentre dans une boucle
 * infinie et n'en sort que quand le joueur a cliqué sur une case !
 * name.clear() // efface graphiquement tous les éléments du plateau
 * name.setDisplayedText(String Text) // Affiche dans la zone de texte un message
 * name.getLastSize() // retourne la taille du dernier pion joué sous forme d'un int
 * name.getLastX() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * name.getLastY() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * 
 * name.getPlayerNumber() // retourne nombre joueurs selectionnés
 * name.gameIsStarted() // retourne true or false si le joueur a cliqué ou non sur le bouton start
 * name.getPlayerName(int PlayerId) // retourne le nom du joueur sous forme d'un STRING (id entre 1 et 4 inclus)
 * NOTE : Quand le joueur clique sur start cela créer automatiquement un nouveau tableau de jeu
 * 
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.nio.channels.ClosedByInterruptException;
//import java.awt.Dimension;
import java.awt.Font;
//import java.awt.event.*;
import Game.Player;

//import javax.lang.model.util.SimpleElementVisitor14;

//import java.awt.Color;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

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



	//Création des éléments de la fenetre de démarage :
	JFrame start = new JFrame("Start");
	JPanel namePanel = new JPanel(); // Création de tous les élements de la fenetre de démarage 
	JPanel numberPanel = new JPanel(); //panel qui contient les radio box
	JLabel welcomeTxt = new JLabel("Welcome to Otrio");
	JLabel numberTxt = new JLabel("How many players ?");
	JLabel nameTxt = new JLabel("Names ?");
	// JRadioButton[] numberRadioButton = new JRadioButton[4];   //fonctionnerait avec la boucle for écrite en commentaire plus bas, mais ne fonctionne pas pour une raison inconnue, je obligé de délarer les boutons 1 par 1
	JRadioButton numberRadioButton1 = new JRadioButton("1 Player");
	JRadioButton numberRadioButton2 = new JRadioButton("2 Player");
	JRadioButton numberRadioButton3 = new JRadioButton("3 Player");
	JRadioButton numberRadioButton4 = new JRadioButton("4 Player");
	ButtonGroup group2 = new ButtonGroup(); // groupe qui permet de faire en sorte que l'on puisse selectionner qu'un seul nb de joueur à la fois
	
	JButton startButton = new JButton("Start");

	
	JTextField namePlayerField1 = new JTextField();//champs de texte pour les pseudosd
	JTextField namePlayerField2 = new JTextField();
	JTextField namePlayerField3 = new JTextField();
	JTextField namePlayerField4 = new JTextField();
	//String numberRadioButtonString = "";


	public GUI() {}
	int i ;
	boolean startButtonState ;
	int PlayerNumber =2; //2 car plus bas on dit que la valeure selectionnée par défaut est 2.
		
	public void startWindow (){
		//création des éléments de la fenetre de démarrage :
		
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet d'arreter le prog en cliquant sur la croix
		start.setSize(450,450); 
		start.setResizable(false); // taille = fixe
		start.setLayout(null);// permet de placer les conteneurs librement sur la fenetre
		start.getContentPane().setBackground(Color.white); // couleur du fond
		start.setVisible(true);


		
		
		

		welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTxt.setFont(new Font("Arial",Font.PLAIN,20));

		start.setLayout(null); // on ajoute et dimmensionne les label dans les Panel
		namePanel.setBounds(200, 50, 200, 300); //on place les 2 conteneur principaux et on définit leur layout comme grille à une colonne pour pouvoir empiler les éléments
		namePanel.setLayout(new GridLayout(5,1) );
		namePanel.setBackground(Color.white);
		numberPanel.setBackground(Color.white);
		numberPanel.setBounds(0, 50, 200, 300);
		numberPanel.setLayout(new GridLayout(5,1) );
		
		


		

		
		 

			/*for (i=0 ; i < 4 ; i++){
			numberRadioButton[i] = new JRadioButton();
			numberRadioButtonString = (i+1 + " Player"); // on actualise la variable qui conteient le nom du bouton

			numberRadioButton[i].setText(numberRadioButtonString);
			numberPanel.add(numberRadioButton[i]);
			}*/

			// Ajout des boutons dans le bon panel : 
			//IMPOSSIBLE d'utiliser la boucle ci-dessus pour les créer et ajouter les boutons dans le panel : a chaque lancement j'obtiens une fenetre différente !!!!
			group2.add(numberRadioButton1);
			group2.add(numberRadioButton2);
			group2.add(numberRadioButton3);
			group2.add(numberRadioButton4);
			numberRadioButton2.setSelected(true);
			
			namePanel.add(nameTxt);
			
			numberPanel.add(numberTxt);
			numberPanel.add(numberRadioButton1);
			numberPanel.add(numberRadioButton2);
			numberPanel.add(numberRadioButton3);
			numberPanel.add(numberRadioButton4);

			namePanel.add(namePlayerField1);
			namePanel.add(namePlayerField2);
			namePanel.add(namePlayerField3);
			namePanel.add(namePlayerField4);
			


			

		



			/*namePlayerField[i] = new JTextField();
			namePlayerField[i].setPreferredSize(new Dimension(40,10));
			namePanel.add(namePlayerField[i]);
			System.out.println(i + "ok ");*/
			
	
		

		
	
		

		

		startButton.setBounds(250, 350, 100, 50);
		start.add(startButton);
		start.add(welcomeTxt);
		welcomeTxt.setBounds(0,0,400,50);
		start.add(numberPanel);
		start.add(namePanel);


		numberRadioButton1.addActionListener(e -> PlayerNumber = 1);
		numberRadioButton2.addActionListener(e -> PlayerNumber = 2);
		numberRadioButton3.addActionListener(e -> PlayerNumber = 3);
		numberRadioButton4.addActionListener(e -> PlayerNumber = 4);

		//while(startButtonState == false) {
			startButton.addActionListener(e -> startButtonAction());
			
		//}

	}





	
	
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
					//=======================================================
	int Pos = 10 ;	//Pourquoi c'est la? Je mettrais plustot en haut avec les autres variables
	int Size; 		//=======================================================


	//=======================================================
	//J'ai change son nom car on ne place pas, on juste relai l'information au programme ou est-ce qu'on essaye de placer
	//=======================================================

	public void tryPawn(int PlayerId, Player[] P) {
		Pos = 10;
		System.out.println("Tout début place pawn, Pos ="+ Pos);
			
		labelInfos.setText("Place un pion " + P[PlayerId].name); //affiche l'instruction dans le label d'info
		smallSize.setSelected(true);
		Size =0; //o car par défaut c'est "small ring" qui est coché
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

		//=======================================================		| |
		//On a meme pas besoin de guarder cette partie 					| |
		//=======================================================	   \   /
		//																\ /

		//verification cas par cas des paramètres Taille et couleur (=Player iD);
		if(Size == 0 && PlayerId == 0) System.out.println("I want to place element"); //Small[Pos].setIcon(SmallRed);
		if(Size == 1 && PlayerId == 0) System.out.println("I want to place element"); //Medium[Pos].setIcon(MediumRed);
		if(Size == 2 && PlayerId == 0) System.out.println("I want to place element"); //Big[Pos].setIcon(BigRed);
		if(Size == 0 && PlayerId == 1) System.out.println("I want to place element"); //Small[Pos].setIcon(SmallBlue);
		if(Size == 1 && PlayerId == 1) System.out.println("I want to place element"); //Medium[Pos].setIcon(MediumBlue);
		if(Size == 2 && PlayerId == 1) System.out.println("I want to place element"); //Big[Pos].setIcon(BigBlue);
		if(Size == 0 && PlayerId == 2) System.out.println("I want to place element"); //Small[Pos].setIcon(SmallPink);
		if(Size == 1 && PlayerId == 2) System.out.println("I want to place element"); //Medium[Pos].setIcon(MediumPink);
		if(Size == 2 && PlayerId == 2) System.out.println("I want to place element"); //Big[Pos].setIcon(BigPink);
		if(Size == 0 && PlayerId == 3) System.out.println("I want to place element"); //Small[Pos].setIcon(SmallBlack);
		if(Size == 1 && PlayerId == 3) System.out.println("I want to place element"); //Medium[Pos].setIcon(MediumBlack);
		if(Size == 2 && PlayerId == 3) System.out.println("I want to place element"); //Big[Pos].setIcon(BigBlack);
	
		}



	public void refreshScreen(int[][][] G){

		int CurPos = 12;

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					if(G[k][j][i] != 0){
						if(k == 0 && j == 0) CurPos = 6;
						else if(k == 1 && j == 0) CurPos = 7;
						else if(k == 2 && j == 0) CurPos = 8;
						else if(k == 0 && j == 1) CurPos = 3;
						else if(k == 1 && j == 1) CurPos = 4;
						else if(k == 2 && j == 1) CurPos = 5;
						else if(k == 0 && j == 2) CurPos = 0;
						else if(k == 1 && j == 2) CurPos = 1;
						else if(k == 2 && j == 2) CurPos = 2;

						if(i == 1 && G[k][j][i] == 0) Medium[CurPos].setIcon(MediumRed);
						if(i == 0 && G[k][j][i] == 0) Small[CurPos].setIcon(SmallRed);
						if(i == 2 && G[k][j][i] == 0) Big[CurPos].setIcon(BigRed);
						if(i == 0 && G[k][j][i] == 1) Small[CurPos].setIcon(SmallBlue);
						if(i == 1 && G[k][j][i] == 1) Medium[CurPos].setIcon(MediumBlue);
						if(i == 2 && G[k][j][i] == 1) Big[CurPos].setIcon(BigBlue);
						if(i == 0 && G[k][j][i] == 2) Small[CurPos].setIcon(SmallPink);
						if(i == 1 && G[k][j][i] == 2) Medium[CurPos].setIcon(MediumPink);
						if(i == 2 && G[k][j][i] == 2) Big[CurPos].setIcon(BigPink);
						if(i == 0 && G[k][j][i] == 3) Small[CurPos].setIcon(SmallBlack);
						if(i == 1 && G[k][j][i] == 3) Medium[CurPos].setIcon(MediumBlack);
						if(i == 2 && G[k][j][i] == 3) Big[CurPos].setIcon(BigBlack);

					}
				}
			}
		}

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

	public String getPlayerName (int Player) {
		String name ="";
		switch(Player) { 
			case 1 : 
			name = namePlayerField1.getText();
			break;
			case 2 : 
			name = namePlayerField2.getText();
			break;
			case 3 : 
			name = namePlayerField3.getText();
			break;
			case 4 : 
			name = namePlayerField4.getText();
			break;


		}

		
		
		
		return name;
	}
	
	private void startButtonAction(){
		
		System.out.println("Début de la partie");
		

		
		start.dispose(); //ferme la fenetre quand on a cliqué sur start
		create();
		startButtonState = true;


	}


	public int getPlayerNumber(){ //fonction qui retourne le nombre de joueur sélectionné

		return PlayerNumber;
	}

	public boolean gameIsStarted(){
		return startButtonState;
	}
	
}