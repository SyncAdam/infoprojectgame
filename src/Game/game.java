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

    //String userInput;
    //char size = 0;
    int cp = 0;
    int nt = 0; //nombre de tour;
    int t = -1;
    int[] coords = new int[2];
    int[][][] gameTable = new int[3][3][3];
    boolean gagne = false;
    boolean veutjouer = true;
    boolean contrepc = false;
    boolean moreColors = false;

    int numplayers = 0;
    Player[] Playertableau;

    aff.clearOutputStream();

    //
    gameTable = gest.initialiseGameTable();
    while(screen.startButtonState == false){
        try{
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    numplayers = screen.getPlayerNumber();
    contrepc = screen.againstPC;
    moreColors = screen.moreColors;

    System.out.println("Done.");

    Playertableau = gest.createPlayers(numplayers, contrepc, screen, moreColors);
    System.out.println("Creation des joueurs...");
    //aff.clearOutputStream();

    screen.clear();
    int cpw = cp+1;
    if(cp+1 >= numplayers) cpw = 0;
    screen.refreshScreen(gameTable, Playertableau, cpw);

    while(veutjouer){

        while(!gagne){

            if(cp == numplayers) cp = 0;

            aff.printGameTable(gameTable);


            aff.writePlayerTab(Playertableau[cp]);
            //String[] splitted;

            //boolean goodInput = false;

            if(Playertableau[cp].isRobot != true){

                /*

                System.out.println("Place un pion " + Playertableau[cp].name);
                userInput = Lire.S();
                splitted = userInput.split(" ", 3);

                try{
                    coords[0] = Integer.parseInt(splitted[0]); //(int)splitted[0];
                    coords[1] = Integer.parseInt(splitted[1]);
                    size = splitted[2].charAt(0);
                    t = gest.convertSize(size);
                    goodInput = true;
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException | mPE | StringIndexOutOfBoundsException ex){
                    //ex.printStackTrace();
                    System.out.println("Reessayez");
                }
    
                while(!goodInput){
                    
                    userInput = Lire.S();
                    splitted = userInput.split(" ", 3);
    
                    try{
                        coords[0] = Integer.parseInt(splitted[0]);
                        coords[1] = Integer.parseInt(splitted[1]);
                        size = splitted[2].charAt(0);
                        t = gest.convertSize(size);
                        goodInput = true;
                    }
                    catch (NumberFormatException | ArrayIndexOutOfBoundsException | mPE | StringIndexOutOfBoundsException ex){
                        //ex.printStackTrace();
                        System.out.println("Reessayez");
                    }
                }*/

                screen.tryPawn(cp, Playertableau);
                coords[0] = screen.getLastX();
                coords[1] = screen.getLastY();
                t = screen.getLastSize();
                

            }
            else{

                coords[0] = (int)Math.ceil(Math.random()*3);
                coords[1] = (int)Math.ceil(Math.random()*3);
                t = (int)(Math.ceil(Math.random()*3)-1);

            }

            //aff.clearOutputStream();
    
            if(gest.hasElement(Playertableau[cp], t) && nt != (numplayers*9)-1){
                try{
                    gameTable = gest.placeElement(gameTable, Playertableau[cp], t, coords);
                    screen.clear();
                    cpw = cp+1;
                    if(cp+1 >= numplayers) cpw = 0;
                    screen.refreshScreen(gameTable, Playertableau, cpw);
                    if(fonction.check(gameTable, Playertableau[cp].playercircles[0][0]) != 0){
                        gagne = true;
                        aff.printTrophy();
                        screen.gameWon(Playertableau[cp].name);
                    }
                    cp++;
                    nt++;
                }
                catch(mPE e){
                    e.printStackTrace();
                }

            }
            else if(!gest.hasElement(Playertableau[cp], t)) continue; 
            else{
                gagne = true;
                System.out.println("Personne n'a gagné");
                screen.noOneWon();
            }
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }
        /*
        screen.askReplay();
        System.out.println("Est-ce que vous voulez rejouer? O ou N");
        var = Lire.c();
        while(var != 'o' && var != 'O' && var != 'n' && var != 'N'){
            System.out.println("Entrez O ou N");
            var = Lire.c();
        }
        */

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
            /* 
            if(numplayers == 2){
                System.out.println("Est-ce que vous voulez jouer contre l'ordinateur? O ou N");
                ans = Lire.c();
                while(ans != 'o' && ans != 'O' && ans != 'n' && ans != 'N'){
                    System.out.println("Entrez O ou N");
                    ans = Lire.c();
                }
                if(ans == 'o' || ans == 'O'){
                    contrepc = true;
                }
            }
            */
            Playertableau = gest.createPlayers(numplayers, contrepc, screen, moreColors);
            System.out.println("Creation des joueurs...");
            gagne = false;
            contrepc = false;
            moreColors = false;
            cp = 0;
            nt = 0;
        }
        else{
            aff.clearOutputStream();
            veutjouer = false;
        }
        
    }

    System.exit(0);

}

}