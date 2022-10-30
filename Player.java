/*
 * Comment ca marche un joueur?
 * Tout les joueurs ont un nom un couleur et un tableau de morpilles a la facon suivante
 * 
 * nombre qui correspond á joueur par ex 1
 * [1][1][1]
 * [3][3][3]
 * Il lui reste
 */

public class Player{

    String name;
    String color;                               //Réfléchissons - Est-ce qu'on a besoin de faire un tableau 3x3 ou il suffit de faire
    int[][] playercircles = new int[3][2];      //un tableau 3x2 avec dans le premier ligne le nombre référentiel et le 2ieme combien
                                                //il y en a                                            
                                                //Faire 2ieme moyenne
    //Constructeur

    Player(int n){
        this.name = "nom de defaut";
        this.color =  "noir";

        for(int i = 0; i < 3; i++){

            playercircles[i][0] = n;
            playercircles[i][1] = 3;

        }
    }
}