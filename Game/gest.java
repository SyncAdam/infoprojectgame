package Game;

//Class pour les fonctions du gestion du jeu

public class gest {

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
    public static Player[] createPlayers(int num, boolean contrepc){
        int i;
        Player[] p = new Player[num];
    
        for(i = 0; i < num; i++){

            p[i] = new Player(i);

            if(!contrepc || i != num-1){
    
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
            else{
                p[i].name = "ROBOT";
                p[i].color = "Black";
                p[i].isRobot = true;
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

    public static boolean hasElement(Player[] P, int p, int t){
        if(P[p].playercircles[t][1] == 0){
            return false;
        }
        else{
            return true;
        }
    }


    //Placer un pion
    public static int[][][] placeElement(int[][][] M, Player[] Players, int n, int t, int[] coord) throws mPE{

        int[][][] X = M;

        if(X[coord[0]-1][coord[1]-1][t] == 0){

            X[coord[0]-1][coord[1]-1][t] = Players[n].playercircles[0][0];
            Players[n].playercircles[t][1] -= 1;

        }
        else{
            throw new mPE("Impossible de placer un pion");
        }            
    return X;        

    }  

}
