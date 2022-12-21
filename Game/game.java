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
import GUI.GUI;

public class game{ 



public static void main(String[]args){

    GUI screen = new GUI();
    screen.create();

    aff.clearOutputStream();

    String userInput;
    char size = 0;
    int cp = 0;
    int t = -1;
    int[] coords = new int[2];
    int[][][] gameTable = new int[3][3][3];
    int numplayers = gest.askNumPlayers();
    boolean gagne = false;

    System.out.println("Creation des joueurs...");
    Player[] Playertableau = gest.createPlayers(numplayers, false); //á changer

    gameTable = gest.initialiseGameTable();
    aff.clearOutputStream();

    // aff.writePlayerNamesWithColors(numplayers, Playertableau);
    // for(int i = 0; i < numplayers; i++){
    //     aff.writePlayerTab(Playertableau[i]);
    // }

    while(!gagne){

        if(cp == numplayers) cp = 0;

        aff.printGameTable(gameTable);

        aff.writePlayerTab(Playertableau[cp]);

        System.out.println("Place un pion " + Playertableau[cp].name);


        userInput = Lire.S();
        String[] splitted = userInput.split(" ", 3);

        boolean goodInput = false;

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
        }

        aff.clearOutputStream();      
 
        if(gest.hasElement(Playertableau, cp, t)){
            try{
                gameTable = gest.placeElement(gameTable, Playertableau, cp, t, coords);
                screen.placePawn(coords[0]-1, coords[1]-1, t, Playertableau[cp].playercircles[0][0]);
                if(fonction.check(gameTable, Playertableau[cp].playercircles[0][0]) != 0){
                    gagne = true;
                    aff.printTrophy();
                    continue;
                }
                cp++;
            }
            catch(mPE e){
                e.printStackTrace();
            }

        }

    }

}

}
