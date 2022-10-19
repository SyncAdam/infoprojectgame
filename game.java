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

// Créer des joueurs
public class Player{

    String name;
    String color;
    int[][] playercircles = new int[3][3];

    //Constructeur

    Player(int n){
        this.name = "nom de defaut";
        this.color =  "noir";

        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 3; j++){

                this.playercircles[i][j] = n + 1;

            }
        }
    }
}

// Créer des joueurs s'ils sont 2 avec 2 couleurs
//public class Player2{}

public static Player[] createPlayers(int num){

    Player[] p = new Player[num];

    for(int i = 0; i < num; i++){

        p[i] = new game(). new Player(i);             // ????????????????????????????????? class Player n'est pas static????

        System.out.print("Donnez le nom du " + (i+1) + "ieme joueur: ");
        p[i].name = Lire.S();
        System.out.print("\n");

        System.out.print("Donnez le couleur du " + (i+1) + "ieme joueur: ");
        p[i].color = Lire.S();
        System.out.print("\n");

    }
    return p;
}

public static void writePlayerNamesWithColors(int num, Player[] p){

    for(int i = 0; i < num; i++){

        System.out.println((p[i].name) + "  ->  " + p[i].color);

    }
}

public static void writePlayerTab(Player p){

    for(int i = 0; i < 3; i++){

        for(int j = 0; j < 3; j++){

            System.out.print(p.playercircles[i][j]);

        }
        
        System.out.print("\n");
    }
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
                gameTable[i][j][k] = 0;     //Char table a besoin du valeur 48 pour afficher 0
            }
        }
    }
}

//Methode pour afficher le tableau du jeu sur l'ecran
public static void printGameTable(int[][][] gameTable){

    for(int i = 0; i < 3; i++){

        System.out.print("\n\n");

        for(int j = 0; j < 3; j++){

            for(int k = 0; k < 3; k++){

                System.out.print(gameTable[i][j][k] + "  ");

            }
            System.out.print("\n");
        }
    }
}

public static void main(String[]args){

    //Test
    //Pour faciliter la vie     System.out.println("");


    int[][][] gameTable = new int[3][3][3];

    int numplayers = askNumPlayers();

    System.out.println("Creation des joueurs...");

    Player[] Playertableau = createPlayers(numplayers);

    writePlayerNamesWithColors(numplayers, Playertableau);

    for(int i = 0; i < numplayers; i++){
        writePlayerTab(Playertableau[i]);
    }

    initialiseGameTable(gameTable);

    printGameTable(gameTable);

    /*
    while(jeu pas fini) {

        printGameTable(gameTable);
        prochaineJoueurPlaceCercle();
        voirSiQuelquunagagne();
        
    }
    */
}
}
