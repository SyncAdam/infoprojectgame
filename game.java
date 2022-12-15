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

public class game{ 



public static void main(String[]args){

    ecran f = new ecran();

    aff.clearOutputStream();

    String userInput;
    char size = 0;
    int cp = 0;
    int[] coords = new int[2];
    int[][][] gameTable = new int[3][3][3];
    int numplayers = gest.askNumPlayers();

    System.out.println("Creation des joueurs...");
    Player[] Playertableau = gest.createPlayers(numplayers);

    gameTable = gest.initialiseGameTable();
    aff.clearOutputStream();

    // aff.writePlayerNamesWithColors(numplayers, Playertableau);
    // for(int i = 0; i < numplayers; i++){
    //     aff.writePlayerTab(Playertableau[i]);
    // }

    while(true){

        aff.printGameTable(gameTable);

        aff.writePlayerTab(Playertableau[cp]);

        System.out.println("Place un pion " + Playertableau[cp].name);
        userInput = Lire.S();
        String[] splitted = userInput.split(" ", 3);

        try{
            coords[0] = Integer.parseInt(splitted[0]);
            coords[1] = Integer.parseInt(splitted[1]);
            size = splitted[2].charAt(0);
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }        

        aff.clearOutputStream();

        try{
            gameTable = gest.placeElement(gameTable, Playertableau, cp, size ,coords);
            cp++;

        }
        catch(mPE | ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        if(cp == numplayers) cp = 0;
    }

}

}
