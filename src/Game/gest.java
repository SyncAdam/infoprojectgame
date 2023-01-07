package Game;
import GUI.GUI;

//Class pour les fonctions du gestion du jeu

public class gest {

    //Creer les jouers
    public static Player[] createPlayers(int num, boolean contrepc, GUI gui, boolean moreColors){

        Player[] p = new Player[num];
    
        for(int i = 0; i < num; i++){

            p[i] = new Player(i);

            if((!contrepc || i != num-1) && !moreColors){
    
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
    

    //================================
    //  Thibault
    //================================

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

    //================================
    //  
    //================================


    //================================
    //  Thibault
    //================================

    public static boolean hasElement(Player P, int t, GUI s){
        if(P.playercircles[t][1] == 0){
            System.out.println("Vous n'avez plus de pion de cette taille");
            s.setDisplayedText("You dont have any circles of this size.");
            return false;
        }
        else{
            return true;
        }
    }

    //================================
    // 
    //================================

    public static boolean possibleToPlay(int[][][]M,  Player player){

		for(int i = 0; i < 3; i++){

			for(int j = 0; j < 3; j++){

				if(M[j][i][0] == 0 && player.playercircles[0][1] !=0) return true;	

				if(M[j][i][1] == 0 && player.playercircles[1][1] !=0) return true;

				if(M[j][i][2] == 0 && player.playercircles[2][1] !=0) return true;
			}
		}
		return false;

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
