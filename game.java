import f.*;

/*
    L'idée est de stocker les cercles de tailles et couleurs differents dans un tableau de 3 dimension
    progresser le jeu et dans tout les tour voir si quelqu'un a gagné ou pas
*/

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

//Créer des joueurs s'ils sont 2 avec 2 couleurs
//public class Player2{}



public static Player[] createPlayers(int num){

    Player[] p = new Player[num];

    for(int i = 0; i < num; i++){

        p[i] = new Player(i);

        System.out.print("Donnez le nom du " + (i+1) + "ieme joueur: ");
        p[i].name = Lire.S();
        System.out.print("\n");

        while(p[i].name == ""){

            System.out.print("Donnez un nom non nul pour le " + (i+1) + "ieme joueur: ");
            p[i].name = Lire.S();
            System.out.print("\n");

        }

        System.out.print("Donnez le couleur du " + (i+1) + "ieme joueur: ");
        p[i].color = Lire.S();
        System.out.print("\n");

        while(p[i].color == ""){

            System.out.print("Donnez un couleur non nul pour le " + (i+1) + "ieme joueur: ");
            p[i].color = Lire.S();
            System.out.print("\n");
            
        }

    }
    return p;
}

public static void writePlayerNamesWithColors(int num, Player[] p){

    for(int i = 0; i < num; i++){

        System.out.println((p[i].name) + "  ->  " + p[i].color);

    }
}

public static void writePlayerTab(Player p){

    System.out.println("Nom de Joueur: " + p.name);
    System.out.println("Couleur de Joueur: " + p.color);
    System.out.println("ident. | quant. |     taille ");

    for(int i = 0; i < 3; i++){

        for(int j = 0; j < 2; j++){

            System.out.print("     ");
            System.out.print(p.playercircles[i][j] + " | ");

        }
        
        if(i == 0) System.out.println(" <- cercles petits");
        if(i == 1) System.out.println(" <- cercles moyens");
        if(i == 2) System.out.println(" <- cercles grands");
    }
    System.out.print("\n");
}

//fonction pour demander le nombre de joueurs
public static int askNumPlayers(){

    int num;

    System.out.println("===========================");
    System.out.println("Bienvenue au jeu d'Otrio \n");
    System.out.print("Saisissez le nombre de joueurs dans votre jeu: ");

    num = Lire.i();

    while(num < 2 || num > 4){

        System.out.println("Le nombre de joueurs ne peut pas dépasser 4");
        num = Lire.i();

    }

    return num;
}

//fonction pour initialiser le tableau du jeu
public static void initialiseGameTable(int[][][] gameTable){

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){
                                            //Remplir tout les valeurs du tableau 3 dimensionnel avec 0s
                gameTable[k][j][i] = 0;     //Char table a besoin du valeur 48 pour afficher 0
            }
        }
    }
}


public static int[][][] placeElement(int[][][] X, Player[] Players, int n, char t, int[] coord){

    switch (t) {
        case 'p':
            if(X[coord[0]-1][coord[1]-1][0] == 0 && Players[n].playercircles[0][1] != 0){
                X[coord[0]-1][coord[1]-1][0] = Players[n].playercircles[0][0];
                Players[n].playercircles[0][1] -= 1;
            }
            break;
        case 'm':
            if(X[coord[0]-1][coord[1]-1][0] == 0 && Players[n].playercircles[1][1] != 0){
                X[coord[0]-1][coord[1]-1][1] = Players[n].playercircles[0][0];
                Players[n].playercircles[1][1] -= 1;
            }
            break;
        case 'g':
            if(X[coord[0]-1][coord[1]-1][0] == 0 && Players[n].playercircles[2][1] != 0){
                X[coord[0]-1][coord[1]-1][2] = Players[n].playercircles[0][0];
                Players[n].playercircles[2][1] -= 1;
            }
            break;
    
        default:
            System.out.println("Aucun élément n'a été placé");
            break;
    }

    return X;
}



public static void main(String[]args){

    //Test
    //Pour faciliter la vie     System.out.println("");

    ecran f = new ecran();

    affichage.clearOutputStream();

    String userInput;
    char size = 0;
    int cp = 0;

    int[] coords = new int[2];
    int[][][] gameTable = new int[3][3][3];
    int numplayers = askNumPlayers();

    System.out.println("Creation des joueurs...");
    Player[] Playertableau = createPlayers(numplayers);

    initialiseGameTable(gameTable);
    affichage.clearOutputStream();
    writePlayerNamesWithColors(numplayers, Playertableau);

    for(int i = 0; i < numplayers; i++){
        writePlayerTab(Playertableau[i]);
    }

    while(true){

        affichage.printGameTable(gameTable);

        System.out.println("Qui joue?");
        cp = Lire.i();

        writePlayerTab(Playertableau[cp]);

        System.out.println("Placing a circle");
        userInput = Lire.S();
        String[] splitted = userInput.split(" ", 3);
        for(int i = 0; i < 3; i++){
            System.out.println(splitted[i]);
        }

        try{
            coords[0] = Integer.parseInt(splitted[0]);
            coords[1] = Integer.parseInt(splitted[1]);
            size = splitted[2].charAt(0);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        

        affichage.clearOutputStream();    
        placeElement(gameTable, Playertableau, cp, size ,coords);
    }

/*
    writePlayerNamesWithColors(numplayers, Playertableau);

    for(int i = 0; i < numplayers; i++){
        writePlayerTab(Playertableau[i]);
    }
*/


    /*
    while(jeu pas fini) {

        printGameTable(gameTable);
        prochaineJoueurPlaceCercle();
        voirSiQuelquunagagne();
        
    }
    */
}

}

