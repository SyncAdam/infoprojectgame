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
/* 
        playercircles[0][0] = 3*n+1;            // Si logique est trop difficile   
        playercircles[1][0] = 3*n+2;
        playercircles[2][0] = 3*n+3;
*/
        for(int i = 0; i < 3; i++){

            playercircles[i][0] = n+1;
            playercircles[i][1] = 3;

        }
    }
}