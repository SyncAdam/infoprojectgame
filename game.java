public class game{

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
    System.out.println(num);
    return num;

}

//fonction pour initialiser le tableau du jeu

public static void initialiseGameTable(char[][][] gameTable){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){

                                        //Remplir tout les valeurs du tableau 3 dimensionnel avec 0s
            gameTable[i][j][k] = 48; //Char table a besoin du valeur 48 pour afficher 0
        }
        }
    }
}

public static void printGameTable(char[][][] gameTable){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            for(int k = 0; k < 3; k++){

                System.out.print(gameTable[i][j][k] + "  ");

            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
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

    char[][][] gameTable = new char[3][3][3];


    askNumPlayers(numplayers);
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