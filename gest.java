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


    //Placer un pion
    public static int[][][] placeElement(int[][][] M, Player[] Players, int n, char t, int[] coord) throws mPE{

        int[][][] X = M;

        switch (t) {
            case 'p':
                if(X[coord[0]-1][coord[1]-1][0] == 0 && Players[n].playercircles[0][1] != 0){
                    X[coord[0]-1][coord[1]-1][0] = Players[n].playercircles[0][0];
                    Players[n].playercircles[0][1] -= 1;
                }
                break;
            case 'P':
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
            case 'M':
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
            case 'G':
                if(X[coord[0]-1][coord[1]-1][0] == 0 && Players[n].playercircles[2][1] != 0){
                    X[coord[0]-1][coord[1]-1][2] = Players[n].playercircles[0][0];
                    Players[n].playercircles[2][1] -= 1;
                }
                break;
        
            default:
                throw new mPE("Impossible de placer un pion");
        }

        return X;
    }

    

    

}
