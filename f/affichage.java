package f;
public class affichage {
    
    public static void clearOutputStream(){

        System.out.println("\f");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    
    }


//Methode pour afficher le tableau du jeu sur l'ecran
    public static void printGameTable(int[][][] gameTable){

        for(int i = 0; i < 3; i++){

            System.out.print("\n\n");

            for(int j = 0; j < 3; j++){

                for(int k = 0; k < 3; k++){

                    System.out.print(gameTable[k][j][i] + "  ");
                    if(k < 2) System.out.print(" | ");

                }
                System.out.print("\n");
                if(j < 2) System.out.print("---------------");
                System.out.print("\n");
            }
        }
}

}
