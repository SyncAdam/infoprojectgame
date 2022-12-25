//Class pour tous les fonctions d'affichage
package Game;

public class aff {
    

    //Méthode pour vider l'écran    
    public static void clearOutputStream(){ 

        System.out.println("\f");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    
    }


    //Methode pour afficher le tableau du jeu sur l'ecran
    public static void printGameTable(int[][][]g){

        for(int i = 2; i >= 0; i--){

            System.out.print("\n\n");
            printGameTableLine(g,i);

        }
        System.out.print("\n\n");

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
 
    //Afficher le nom des jouers avec leurs couleurs    
    public static void writePlayerNamesWithColors(int num, Player[] p){

        for(int i = 0; i < num; i++){
    
            System.out.println((p[i].name) + "  ->  " + p[i].color);
    
        }
    }


    //Afficher jouers avec nombre de pions
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

}
