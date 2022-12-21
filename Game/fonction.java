package Game;

public class fonction {
    

    public static int check(int tableau[][][], int player){ // player = identificateur du joueur
        int result =0 ; // par défaut le joueur ne gagne pas.
        int i,j;
        
        //verification des diagonales de pions de même taille :
        for(i =0 ; i<3; i++){ //on parcourt les différentes tailles de pion
            if(tableau[1][1][i] == player){ //vérif de si pion au centre
                if(tableau[0][2][i] == player && tableau[2][0][i] == player){result= 1;} //verif diago1
                if(tableau[2][2][i] == player && tableau[0][0][i] == player){result= 1;} //verif diago 2
            }
        }

        //verification des lignes et colonnes de même taille et des triplets sur une même case :
        for( i =0 ; i<3; i++){ 
            for(j =0 ; j<3; j++){
                //vérification des lignes :
                if(tableau[1][j][i] == player){ //vérif de s'il y a un pion dans la colonne centrale
                    if(tableau[0][j][i] == player && tableau[2][j][i] == player ) { result = 2;} //vérifie à gauche et à droite du pion déjà présent
                }
                //vérification des colonnes : 
                if(tableau[j][1][i] == player){ //vérif de s'il y a un pion dans la ligne centrale
                    if(tableau[j][0][i] == player && tableau[j][2][i] == player) {result = 3;} //vérifie en haut et en bas du pion déjà présent
                }
                //verification des triplets sur une case :
                if(tableau[i][j][1] == player){//on parcourt les 9 cases du plateau du milieu (les pions moyens) à la recherche d'un pion du joueur
                    if(tableau[i][j][0] == player && tableau[i][j][2] == player){result =4;} // on vérifie s'il y a un pion du joueur au dessus et en dessous du pion précédemment trouvé
                }
            }
        }

        //verification des cas avec des tailles différentes : 
        
        for (i=0 ; i<3; i++){
            //vérif des lignes : méthode : il y a forcément un pion moyen au milieu d'une ligne, on le vérifie, puis on check les 2 autres combinaisons possibles (un petit à sa gauche et un grand à droite ou inversement)
            if(tableau[1][i][1] == player) { //vérification de la présence d'un pion moyen dans colonne centrale :
                if((tableau[0][i][2] == player && tableau[2][i][0] == player) || (tableau[0][i][0] == player && tableau[2][i][2] == player)){result =5;} // vérif des 2 combinaisons possibles à gauche et à droite du pion detecté juste avant
            }
            //vérif des colonnes : même méthode
            if(tableau[i][1][1] == player){ //on vérifie la présence d'un pion moyen dans la ligne centrale du plateau
            if((tableau[i][0][2] == player && tableau[i][2][0] == player) || (tableau[i][0][0] == player && tableau[i][2][2] == player)){result =6;} // vérif des 2 combinaisons possibles en haut et en bas pion detecté juste avant
            }
        }
        //vérif des diagonales :
        if(tableau[1][1][1] == player){ //on vérifie si pion moyen au milieu
            if((tableau[0][2][2] == player && tableau[2][0][0] == player) || (tableau[0][2][0] == player && tableau[2][0][2] == player)){result = 7;} //vérif les 2 combi possibles pour la diago1
            if((tableau[0][0][0] == player && tableau[2][2][2] == player) || (tableau[0][0][2] == player && tableau[2][2][0] == player)){result = 7;} //vérif les 2 combi possibles pour la diago2
        }
   
        /*si result = 1 = victoire par diagonales, =2 victoire par ligne, =3 par colonne, =4 par triplet, =5 par ligne de taille différente;
         * si resul =6, victoire par colonne de taille différente
        */

        if (result != 0){System.out.println("Bravo au joueur "+ player + " qui remporte la manche");}
        else {System.out.println("Pas de gagnant");}
        return result;
    }
}



