/* Disposition du tableau du jeu
 *
 *	0ieme couche <- tableau 2d des cercles petits
 *	1ere couche <- tableau 2d des cercles moyennes
 *	2ieme couche <- tableau 2d des cercles grandes
 *
 *  Exemple: Tableau[i][j][k]
 * 
 *	0ieme:  ou k = 0
 *		.	.	.
 *
 *		.	.	.
 *
 *		.	.	.
 *	1ere    ou k = 1
 *		o	o	o
 *
 *		o	o	o
 *
 *		o	o	o
 *	2ieme   ou k = 2
 *		O	O	O
 *
 *		O	O	O
 *
 *		O	O	O
 */
package Game;
import java.util.concurrent.TimeUnit;

import GUI.GUI;

public class game{ 



public static void main(String[]args){

    GUI screen = new GUI();
        screen.startWindow();

    aff.clearOutputStream();

    int cp = 0; // joueur actuel
    int t = -1; //taille
    int[] coords = new int[2];  //coordonnées X - Y pour placer les pions dans le tableau 3D du jeu
    int[][][] gameTable = new int[3][3][3]; //Tableau 3D du jeu
    boolean gagne = false;  // boolean pour voir si le jeu est fini ou pas
    boolean veutjouer = true;   //utilise pour savoir si le joueur veut rejouer ou pas
    boolean contrepc = false;   //pour savoir si l'utilisateur joue contre l'ordinateur
    boolean moreColors = false; //pour savoir si l'utilisateur veut jouer a 2 couleur

    int numplayers = 0;         //nombre de joueurs
    Player[] Playertableau;     //tableau, qui contient des type joueurs

    aff.clearOutputStream();

    gameTable = gest.initialiseGameTable(); // initialiser le tableau du jeu, rempli avec des 0
    while(screen.startButtonState == false){    //attendre que l'utilisateur appuie sur le bouton
        try{
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    numplayers = screen.getPlayerNumber();  //saisir le nombre des joueurs
    contrepc = screen.againstPC;            //saisir le boolean si l'utilisateur joue contre l'ordinateur
    moreColors = screen.moreColors;         //saisir si 2 joueurs veulent jouer a 2 couleurs

    System.out.println("Done.");

    try{
        TimeUnit.MILLISECONDS.sleep(50);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }

    Playertableau = gest.createPlayers(numplayers, contrepc, screen, moreColors);       //fonction qui crée un tableau de type Player
    System.out.println("Creation des joueurs...");
    //aff.clearOutputStream();

    screen.clear();     //effacer le GUI
    screen.refreshScreen(gameTable, Playertableau, cp);    //rafraichir l'ecran

    while(veutjouer){       //tantque l'utilisateur veut jouer on est dans le boucle du jeu

        while(!gagne){

            if(gest.possibleToPlay(gameTable,Playertableau[cp])){
                if(Playertableau[cp].isRobot == false){

                    screen.tryPawn(cp, Playertableau);
                    coords[0] = screen.getLastX();
                    coords[1] = screen.getLastY();
                    t = screen.getLastSize();
                    
                }
                else{
    
                    coords[0] = (int)Math.ceil(Math.random()*3);    // entre 1 et 3
                    coords[1] = (int)Math.ceil(Math.random()*3);    // entre 1 et 3
                    t = (int)(Math.ceil(Math.random()*3)-1);    //entre 0 et 2
    
                }
        
                if(gest.hasElement(Playertableau[cp], t, screen) && gest.possibleToPlay(gameTable, Playertableau[cp])){
                    try{
                        gameTable = gest.placeElement(gameTable, Playertableau[cp], t, coords);
                        if(fonction.check(gameTable, Playertableau[cp].playercircles[0][0]) != 0){
                            gagne = true;
                            aff.printTrophy();
                            screen.clear();
                            screen.refreshScreen(gameTable, Playertableau, cp);
                            screen.gameWon(Playertableau[cp].name);
                        }
                        cp++;
                        if(cp == numplayers) cp = 0; //vue qu'on itere l'indexe du joueur actuel, si ce nombre d
                        screen.clear();
                        screen.refreshScreen(gameTable, Playertableau, cp);
                        
                    }
                    catch(mPE e){
                        e.printStackTrace();
                        screen.setDisplayedText("You can't play here !");
                    }
    
                }
            }
            else if(!gest.possibleToPlay(gameTable, Playertableau[cp])){
                gagne = true;
                System.out.println("Personne n'a gagné");
                screen.noOneWon();

        }
            else if(!gest.hasElement(Playertableau[cp], t, screen)) continue; 
            
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }

        screen = null;
        System.gc();
        screen = new GUI();


        if(screen.askReplay()){
            screen.startWindow();
            aff.clearOutputStream();

            gameTable = gest.initialiseGameTable();
            while(screen.startButtonState == false){
                try{
                    TimeUnit.MILLISECONDS.sleep(20);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            numplayers = screen.getPlayerNumber();
            contrepc = screen.againstPC;
            moreColors = screen.moreColors;

            Playertableau = gest.createPlayers(numplayers, contrepc, screen, moreColors);
            System.out.println("Creation des joueurs...");

            try{
                TimeUnit.MILLISECONDS.sleep(20);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            screen.clear();
            screen.refreshScreen(gameTable, Playertableau, cp);
            gagne = false;
            contrepc = false;
            moreColors = false;
            cp = 0;
        }
        else{
            aff.clearOutputStream();
            veutjouer = false;
        }
        
    }

    System.exit(0);

}

}
