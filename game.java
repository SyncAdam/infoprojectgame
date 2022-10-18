public class game{

/* Disposition du tableau du jeu
 *
 *	0ieme couche <- tableau 2d des cercles petits
 *	1ere couche <- tableau 2d des cercles moyennes
 *	2ieme couche <- tableau 2d des cercles grandes
 *
 *	0ieme:
 *		.	.	.
 *
 *		.	.	.
 *
 *		.	.	.
 *	1ere
 *		o	o	o
 *
 *		o	o	o
 *
 *		o	o	o
 *	2ieme
 *		O	O	O
 *
 *		O	O	O
 *
 *		O	O	O
 */


// Créer des joueurs
public class Player{
    String name;
    String color;
    int[][] playercircles = new int[3][3];

    //Constructeur
    Player(String n, String c){
        name = n;
        color = c;
    }
}
// Créer des joueurs s'ils sont 2 avec 2 couleurs
//public class Player2{}

//fonction pour demander le nombre de joueurs
public static int askNumPlayers(int num){

    System.out.println("===========================");
    System.out.println("Bienvenue au jeu d'Otrio \n");
    System.out.println("Saisissez le nombre de joueurs dans votre jeu");
    num = Lire.i();
    while(num < 2 || num > 4){

        System.out.println("Le nombre de joueurs ne peut pas dépasser 4");
        num = Lire.i();

    }
    //System.out.println(num);
    return num;

}

public static void createPlayers(int num, Player[] p){
    String var1, var2;
    for(int i = 0; i < num; i++){
        System.out.println("Donnez le nom du " + (i+1) + "ieme joueur");
        var1 = Lire.S();
        System.out.println("Donnez le couleur du " + (i+1) + "ieme joueur");
        var2 = Lire.S();
        p[i].name = var1;
        p[i].color = var2;
    }
}

public static void writePlayerNames(int num, Player[] p){
    for(int i = 0; i < num; i++){
        System.out.println(p[i].name);
    }
}

//fonction pour initialiser le tableau du jeu
public static void initialiseGameTable(int[][][] gameTable){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){
                                            //Remplir tout les valeurs du tableau 3 dimensionnel avec 0s
                gameTable[i][j][k] = 48;    //Char table a besoin du valeur 48 pour afficher 0
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

/*
    L'idée est de stocker les cercles de tailles et couleurs differents dans un tableau de 3 dimension
    progresser le jeu et dans tout les tour voir si quelqu'un a gagné ou pas
*/
public static void main(String[]args){

    //Test
    //Pour faciliter la vie     System.out.println("");

    int numplayers = 0;

    int[][][] gameTable = new int[3][3][3];
    Player[] Playertableau = new Player[4];

    askNumPlayers(numplayers);
    System.out.println("Creation des joueurs...");
    createPlayers(numplayers, Playertableau);       //A FIXER!!!!!!!
    writePlayerNames(numplayers, Playertableau);    //A FIXER!!!!!!!
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
