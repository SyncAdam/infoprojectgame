//Class pour tous les fonctions d'affichage
package Game;

public class aff {
    

    //Méthode pour vider l'écran    
    public static void clearOutputStream(){ 

        System.out.println("\f");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    
    }


    public static void printTrophy(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⣀⠀⢀⣶⣿⡛⠛⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠙⠛⢛⣿⣶⡄⠀⣀⠀⠀");
        System.out.println("⠀⠀⣿⣧⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣼⣿⠀⠀");
        System.out.println("⠀⠀⣿⡏⠉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠉⢹⣿⠀⠀");
        System.out.println("⠀⠀⢻⣧⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⣼⡏⠀⠀");
        System.out.println("⠀⠀⠘⣿⡄⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⢰⣿⠃⠀⠀");
        System.out.println("⠀⠀⠀⠹⣷⡀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⢠⣿⡏⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⢻⣿⣄⢀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⣠⣿⡟⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠙⣿⣾⡿⠋⠻⣿⣿⣿⣿⣿⣿⣿⣿⠟⠙⢿⣿⣿⠏⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠈⠻⠟⠀⠀⠀⢹⣿⣿⣿⣿⡏⠀⠀⠀⠻⠟⠁⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⡟⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠛⠛⠛⠛⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public static void printGameTableLine(int[][][] gameTable, int i){

        for(int j = 0; j < 3; j++){

            System.out.print(" | ");
            System.out.print((Integer.toString(gameTable[j][i][2]))+" " + (Integer.toString(gameTable[j][i][2]))+" " + (Integer.toString(gameTable[j][i][2]))+" " + (Integer.toString(gameTable[j][i][2]))+" " + (Integer.toString(gameTable[j][i][2])));
        
        }
        System.out.print("\n");
        for(int j = 0; j < 3; j++){

            System.out.print(" | ");
            System.out.print(Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][2]));
        
        }
        System.out.print("\n");
        for(int j = 0; j < 3; j++){

            System.out.print(" | ");
            System.out.print(Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][0]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][2]));
        
        }
        System.out.print("\n");
        for(int j = 0; j < 3; j++){

            System.out.print(" | ");
            System.out.print(Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][1]) +" "+ Integer.toString(gameTable[j][i][2]));
        
        }
        System.out.print("\n");
        for(int j = 0; j < 3; j++){

            System.out.print(" | ");
            System.out.print(Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][2]) +" "+ Integer.toString(gameTable[j][i][2]));
        
        }
    }

}
