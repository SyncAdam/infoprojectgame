package GUI;
/*Pour Adam Méthodes que j'ai créées pour que tu puisses y rajouter a ta partie: 

 * name.create() initialise une fenetre / plateau vierge
 * name.tryPawn(int PlayerId) //attend que le joueur clique sur une case pour pouvoir ensuite utiliser getLastX/y
 * name.refreshScreen : Actualise l'affichage en parcourant tout le tableau de jeux
 * name.clear() // efface graphiquement tous les éléments du plateau
 * name.setDisplayedText(String Text) // Affiche dans la zone de texte un message
 * name.getLastSize() // retourne la taille du dernier pion joué sous forme d'un int
 * name.getLastX() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * name.getLastY() // retourne la coordonnée en X du dernier pion joué sous forme d'un int
 * name.setInventory(String) // actualise le txt de l'inventaire
 * name.getPlayerNumber() // retourne nombre joueurs selectionnés
 * name.gameIsStarted() // retourne true or false si le joueur a cliqué ou non sur le bouton start
 * name.getPlayerName(int PlayerId) // retourne le nom du joueur sous forme d'un STRING (id entre 1 et 4 inclus)
 * name.askReplay() //popup qui demande si on veut rejouer
 * name.noOneWon() // popup qui dit que personne n'a gagné
 * name.gameWon() //popup qui dit qu'un joueur a gagné 
 * NOTE : Quand le joueur clique sur start cela créer automatiquement un nouveau tableau de jeu
 * 
 * 
 */

import java.awt.Color; //Importation des biliothèques necessaires 
import java.awt.GridLayout;
import java.awt.Font;
import Game.Player;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


public class GUI {
	
	//création des images : 
	ImageIcon BigRed = new ImageIcon("src/GUI/Pictures/BigRed.png");
	ImageIcon MediumRed = new ImageIcon("src/GUI/Pictures/MediumRed.png");		
	ImageIcon SmallRed = new ImageIcon("src/GUI/Pictures/SmallRed.png");				
	ImageIcon BigBlue = new ImageIcon("src/GUI/Pictures/BigBlue.png");
	ImageIcon MediumBlue = new ImageIcon("src/GUI/Pictures/MediumBlue.png");	
	ImageIcon SmallBlue = new ImageIcon("src/GUI/Pictures/SmallBlue.png");
	ImageIcon BigPink = new ImageIcon("src/GUI/Pictures/BigPink.png");
	ImageIcon MediumPink = new ImageIcon("src/GUI/Pictures/MediumPink.png");
	ImageIcon SmallPink = new ImageIcon("src/GUI/Pictures/SmallPink.png");	
	ImageIcon BigBlack = new ImageIcon("src/GUI/Pictures/BigBlack.png");
	ImageIcon MediumBlack = new ImageIcon("src/GUI/Pictures/MediumBlack.png");
	ImageIcon SmallBlack = new ImageIcon("src/GUI/Pictures/SmallBlack.png");

	 //Creation des tous les autres elements à afficher dans le tableau de jeu :
	JLabel[] Big = new JLabel[9]; // Création de tous les labels de taille différentes pour afficher les images
	JLabel[] Medium = new JLabel[9];
	JLabel[] Small = new JLabel[9];

	JLayeredPane[] LayeredPane = new JLayeredPane[9]; //creation des layeredPane qui permettent d'empiler des labels sur la grille
	JButton[] Button = new JButton[9]; //Creation des boutons invisibles de la grille pour détecter où le joueur clique

	//Creation des 3 cases à cocher pour selectionner la taille :
	JRadioButton smallSize = new JRadioButton("Small ring"); 
	JRadioButton mediumSize = new JRadioButton("Medium ring");
	JRadioButton bigSize = new JRadioButton("Big ring"); 
	ButtonGroup group = new ButtonGroup(); // groupe qui permet de faire en sorte que l'on puisse selectionner qu'une taille à la fois

	JLabel labelInfos = new JLabel("Default"); //Label qui affiche le texte d'intruction du jeu
	JLabel Inventory = new JLabel("Small pawn : , Medium pawn : , Big pawn : "); //Label qui va contenir l'affichage de l'inventaire
	JPanel Plateau = new JPanel(); // creation du conteneur du plateau de jeu 
	JPanel Infos = new JPanel(); // creation du conteneur pour le label qui affiche le texte d'intruction
	JPanel panelChoixTaille = new JPanel(); // création du panel qui contient les radiobutton du choix de la taille

	//Fenetre de démarage :
	JFrame start = new JFrame("Start"); //Creation de la fenetre de démarage 
	// Création de tous les élements de la fenetre de démarage : (textes et planels associés)
	JPanel namePanel = new JPanel(); 
	JPanel numberPanel = new JPanel(); //panel qui contient les radio box
	JLabel welcomeTxt = new JLabel("Welcome to Otrio");
	JLabel numberTxt = new JLabel("How many players ?");
	JLabel nameTxt = new JLabel("Names ?");

	// JRadioButton[] numberRadioButton = new JRadioButton[4];   //fonctionnerait avec la boucle for écrite en commentaire plus bas, mais ne fonctionne pas pour une raison inconnue, je sui obligé de déclarer les boutons 1 par 1
	JRadioButton numberRadioButton1 = new JRadioButton("1 Player VS IA");
	JRadioButton numberRadioButton2 = new JRadioButton("2 Player");
	JRadioButton numberRadioButton3 = new JRadioButton("3 Player");
	JRadioButton numberRadioButton4 = new JRadioButton("4 Player");
	ButtonGroup group2 = new ButtonGroup(); // groupe qui permet de faire en sorte que l'on puisse selectionner qu'un seul nb de joueur à la fois
	
	JButton startButton = new JButton("Start");

	JTextField namePlayerField1 = new JTextField();//champs de texte pour les pseudos
	JTextField namePlayerField2 = new JTextField();
	JTextField namePlayerField3 = new JTextField();
	JTextField namePlayerField4 = new JTextField();

	JFrame Home = new JFrame("Otrio"); // Création de la fenetre de jeu
	
	

	public GUI() {}
	public boolean startButtonState = false;
	public boolean againstPC = false;
	public boolean moreColors = false;
	int i ;
	int Pos = 10 ;	
	int Size; 	
	
	public int PlayerNumber =2; //2 car plus bas on dit que la valeure selectionnée par défaut est 2.
		
	public void startWindow (){
		//configuration et disposition des éléments de la fenetre de démarrage :
		
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
		namePanel.setLayout(new GridLayout(5,1) ); // on met un layoud grid pour que les élements soient disposés les uns au dessus des autres
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
		
	
		
		numberPanel.add(numberTxt); // ajout des Radios boutons du nb de joueur dans le bon panel
		numberPanel.add(numberRadioButton1);
		numberPanel.add(numberRadioButton2);
		numberPanel.add(numberRadioButton3);
		numberPanel.add(numberRadioButton4);

		namePanel.add(nameTxt);
		namePanel.add(namePlayerField1); // ajout des zones de txt dans le bon panel
		namePanel.add(namePlayerField2);
		namePanel.add(namePlayerField3);
		namePanel.add(namePlayerField4);
			


		startButton.setBounds(250, 350, 100, 50);
		start.add(startButton);
		start.add(welcomeTxt);
		welcomeTxt.setBounds(0,0,400,50);
		start.add(numberPanel);
		start.add(namePanel);


		numberRadioButton1.addActionListener(e -> PlayerNumber = 1); //action  effectuée en fonction du nombre de joueur selectionné
		numberRadioButton2.addActionListener(e -> PlayerNumber = 2);
		numberRadioButton3.addActionListener(e -> PlayerNumber = 3);
		numberRadioButton4.addActionListener(e -> PlayerNumber = 4);

		
			startButton.addActionListener(e -> startButtonAction()); //voir à la fin pour voir toutes les actions effectuées quand le bouton start est pressé
	

	}

	
	public void create() { //créer la fenetre de jeu 
		
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
		panelChoixTaille.setBounds(400, 100, 400, 50); //def taille et position
		panelChoixTaille.setBackground(Color.white);
		Home.add(panelChoixTaille); // on ajoute le panel à la fenetre
		Home.add(Inventory); //on ajoute le label de l'inventaire à la fenetre principale
	
		Inventory.setBounds(450, 200, 400, 200 ); //on dimmensionne et positionne le label

		//config de l'affichage des boutons de choix de taille :
		panelChoixTaille.add(smallSize);
		panelChoixTaille.add(mediumSize);
		panelChoixTaille.add(bigSize);
		smallSize.setSelected(true); // par defaut le premier bouton est coché
		smallSize.setOpaque(false); //On rend les bouttons invisibles
		mediumSize.setOpaque(false);
		bigSize.setOpaque(false);
		
		//config du group de case a cocher (permet de pouvoir n'en cocher qu'une):
		group.add(smallSize);
		group.add(mediumSize);
		group.add(bigSize);

		for ( i =0 ; i<9 ; i++) { //Boucle qui permet de créer les éléments necessaire à l'affichage / fonctionnement du plateau de jeu
			Button[i] = new JButton();
			LayeredPane[i] = new JLayeredPane(); // création des 9 layeredPane
			
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

		Home.setVisible(true); //Finalement, nous rendons la fenetre configurée visible
	}
				

	public void tryPawn(int PlayerId, Player[] P) { //On rentre dans une boucle et on attend que le joueur clique sur une case pour pouvoir ensuite utiliser getLastX/y
		Pos = 10; // valeure arbritraire qui ne correspond pas a un index de case
		labelInfos.setText(P[PlayerId].name + "'s turn"); //affiche l'instruction dans le label d'info
		
		while (Pos ==10){  //Tant qu'un bouton du plateau n'a pas été cliqué on reste dans la boucle
			

			smallSize.addActionListener(e -> Size =0); //on check quelle taille est selectionée et on actualise la variable size
			mediumSize.addActionListener(e -> Size =1);
			bigSize.addActionListener(e -> Size =2);

			//Il aurait fallu utiliser la boucle ci-dessous mais cela ne fonctionne pas;
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

	}



	public void refreshScreen(int[][][] G, Player[] P, int n){ //on parcourt tout le tableau de jeux, a chaque fois qu'on avance d'une case on actualise la position actuelle dans la variable CurPos puis on vérifie si un pion d'une certaine taille et d'un certain joueur est présent : si c'est le cas on affiche la bonne image

		int CurPos = 12;

		for(int i = 0; i < 3; i++){  // on parcourt tout le tableau de jeux avec des valeurs nons nulles
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){

					if(G[k][j][i] != 0){

						if(k == 0 && j == 0) CurPos = 6;   //a chaque fois qu'on inspecte une nouvelle case du tableauu, on actualise la valeur de CurPos
						else if(k == 1 && j == 0) CurPos = 7;
						else if(k == 2 && j == 0) CurPos = 8;
						else if(k == 0 && j == 1) CurPos = 3;
						else if(k == 1 && j == 1) CurPos = 4;
						else if(k == 2 && j == 1) CurPos = 5;
						else if(k == 0 && j == 2) CurPos = 0;
						else if(k == 1 && j == 2) CurPos = 1;
						else if(k == 2 && j == 2) CurPos = 2;

						if(i == 1 && G[k][j][i] == 1) Medium[CurPos].setIcon(MediumRed); // i correspond à la taille : on vérifie s'il y a un pion d'une certaine taille et d'un certain joeur  : si c'est le cas on affiche l'image voulue avec la bonne CurPos definie juste avant
						if(i == 0 && G[k][j][i] == 1) Small[CurPos].setIcon(SmallRed);
						if(i == 2 && G[k][j][i] == 1) Big[CurPos].setIcon(BigRed);
						if(i == 0 && G[k][j][i] == 2) Small[CurPos].setIcon(SmallBlue);
						if(i == 1 && G[k][j][i] == 2) Medium[CurPos].setIcon(MediumBlue);
						if(i == 2 && G[k][j][i] == 2) Big[CurPos].setIcon(BigBlue);
						if(i == 0 && G[k][j][i] == 3) Small[CurPos].setIcon(SmallPink);
						if(i == 1 && G[k][j][i] == 3) Medium[CurPos].setIcon(MediumPink);
						if(i == 2 && G[k][j][i] == 3) Big[CurPos].setIcon(BigPink);
						if(i == 0 && G[k][j][i] == 4) Small[CurPos].setIcon(SmallBlack);
						if(i == 1 && G[k][j][i] == 4) Medium[CurPos].setIcon(MediumBlack);
						if(i == 2 && G[k][j][i] == 4) Big[CurPos].setIcon(BigBlack);
					

					}
				}
			}
		}

		setInventory("You have " + P[n].playercircles[0][1] + " small, " + P[n].playercircles[1][1] + " medium, and " + P[n].playercircles[2][1] + " large circles");

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
	public void clear() { // on efface tout

		for(int i = 0 ; i<9 ; i++) {

			Big[i].setIcon(null);
			Medium[i].setIcon(null);
			Small[i].setIcon(null);
			
		}
	}

	public void setDisplayedText(String text){ //permet d'afficher du txt dans la fenetre de jeux
		labelInfos.setText(text);
	}

	public int getLastSize(){ //Retourne la dernière coordonée X jouée (après un TryPawn)
		return Size;
	}

	public String getPlayerName (int Player) { //retourne le nom d'un joueur en fc de son num

		String name ="";

		switch(Player) { 
			case 0 : 
				name = namePlayerField1.getText();
				break;

			case 1 : 
				name = namePlayerField2.getText();
				break;

			case 2 : 
				name = namePlayerField3.getText();
				break;

			case 3 : 
				name = namePlayerField4.getText();
				break;
		}
		
		return name;
	}
	
	private void startButtonAction(){
		
		System.out.println("Début de la partie");

		if(PlayerNumber == 2){ // ouvre la popup de si on veut jouer avec 2 couleurs

			Object[] options = {"Yes", "No"};

			int n = JOptionPane.showOptionDialog(start,
    			"Would you like to play with 2 colors",
				"More colors?",
    			JOptionPane.YES_NO_OPTION,
    			JOptionPane.QUESTION_MESSAGE,
    			null,     //do not use a custom Icon
    			options,  //the titles of buttons
    			options[0]); //default button title

			while(n != JOptionPane.YES_OPTION && n != JOptionPane.NO_OPTION){
			}

			if(n == JOptionPane.YES_OPTION){
				moreColors = true;
				PlayerNumber = 4; //utile pour la gestion --> voir avec Adam
			}
		}
		else if(PlayerNumber == 1){
			againstPC = true;
			PlayerNumber = 2;
		}
		startButtonState = true;
		start.dispose(); //ferme la fenetre quand on a cliqué sur start
		create();

	}

	public void noOneWon(){ //Pop-up qui dit que personne n'a gagné

		JOptionPane.showMessageDialog(start, "Unfortunately nobody won"); 
		Home.dispose();

	}

	public void gameWon(String name){ ////Pop-up qui dit que qqun a gagné

		JOptionPane.showMessageDialog(start, "Congratulations to " + name + " who won the game!");
		Home.dispose();

	}

	public boolean askReplay(){ //popup qui demande si on veut rejouer 

		Object[] options = {"Yes", "No"};

			int n = JOptionPane.showOptionDialog(start,
    			"Would you like to replay?",
				"Replay?",
    			JOptionPane.YES_NO_OPTION,
    			JOptionPane.QUESTION_MESSAGE,
    			null,     //do not use a custom Icon
    			options,  //the titles of buttons
    			options[0]); //default button title

			while(n != JOptionPane.YES_OPTION && n != JOptionPane.NO_OPTION){
				try{
					TimeUnit.MILLISECONDS.sleep(1); //delai car sinon le programme va trop vite --> bug
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			if(n == JOptionPane.YES_OPTION){
				return true;
			}
			else{
				return false;
			}
			
	}


	public int getPlayerNumber(){ //fonction qui retourne le nombre de joueur sélectionné
		return PlayerNumber;
	}

	

	public void setInventory (String InventoryText){ //permet de mettre à jour le txt de l'inventaire
		Inventory.setText(InventoryText);
	}
	
}
