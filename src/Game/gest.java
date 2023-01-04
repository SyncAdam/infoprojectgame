package Game;
import GUI.GUI;

//Class pour les fonctions du gestion du jeu

public class gest {

    //
    // Thibault
    //

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

    

    //Creer les jouers
    public static Player[] createPlayers(int num, boolean contrepc, GUI gui, boolean moreColors){
        int i;
        Player[] p = new Player[num];


    
        for(i = 0; i < num; i++){

            p[i] = new Player(i);

            if((!contrepc || i != num-1) && !moreColors){
    
                /*System.out.print("Donnez le nom du " + (i+1) + "ieme joueur: ");
                p[i].name = Lire.S();
                System.out.print("\n");
        
                while(p[i].name == ""){
        
                    System.out.print("Donnez un nom non nul pour le " + (i+1) + "ieme joueur: ");
                    p[i].name = Lire.S();
                    System.out.print("\n");
        
                }*/
        
                /*System.out.print("Donnez le couleur du " + (i+1) + "ieme joueur: ");
                p[i].color = Lire.S();
                System.out.print("\n");
        
                while(p[i].color == ""){
        
                    System.out.print("Donnez un couleur non nul pour le " + (i+1) + "ieme joueur: ");
                    p[i].color = Lire.S();
                    System.out.print("\n");
                    
                }
                */
                String name = gui.getPlayerName(i);
                if(name.equals("")){
                    p[i].name = ("Player " + (i+1));
                }
                else{
                    p[i].name = name;
                }

            }

            else if(!moreColors){
                p[i].name = "ROBOT";
                p[i].isRobot = true;
            }
    
        }
        if(moreColors){
            String name = gui.getPlayerName(0);
            if(name.equals("")){
                p[0].name = ("Player " + (1));
                p[1].name = ("Player " + (1));
            }
            else{
                p[0].name = name;
                p[1].name = name;
            }
            name = gui.getPlayerName(1);
            if(name.equals("")){
                p[2].name = ("Player " + (2));
                p[3].name = ("Player " + (2));
            }
            else{
                p[2].name = name;
                p[3].name = name;
            }
        }
        return p;
    }
    
    //fonction pour initialiser le tableau du jeu
    public static int[][][] initialiseGameTable(){

        int[][][] gT = new int[3][3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){

                    gT[k][j][i] = 0;            //Remplir tout les valeurs du tableau 3 dimensionnel avec 0s

                }
            }
        }
        return gT;
    }

    public static int convertSize(char c) throws mPE{
        int t;
        switch (c) {
            case 'p':
                t = 0;
                break;
            case 'P':
                t = 0;
            break;
            case 'm':
                t = 1;
            break;
            case 'M':
                t = 1;
            break;
            case 'g':
                t = 2;
            break;
            case 'G':
                t = 2; 
            break;
            default:
                throw new mPE("Taille inconnue");
        }
        return t;
    }

    public static boolean hasElement(Player P, int t){
        if(P.playercircles[t][1] == 0){
            System.out.println("Vous n'avez plus de pion de cette taille");
            return false;
        }
        else{
            return true;
        }
    }


    //Placer un pion
    public static int[][][] placeElement(int[][][] M, Player Player, int t, int[] coord) throws mPE{

        int[][][] X = M;

        if(X[coord[0]-1][coord[1]-1][t] == 0){

            X[coord[0]-1][coord[1]-1][t] = Player.playercircles[0][0];
            Player.playercircles[t][1] -= 1;

        }
        else{
            throw new mPE("Impossible de placer un pion");
        }
    return X;        

    }  

}
