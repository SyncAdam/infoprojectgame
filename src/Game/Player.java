package Game;
public class Player{

    public String name;
    public int[][] playercircles = new int[3][2];
    boolean isRobot;                               
                                                
    //Constructeur

    Player(int n){
        this.name = "nom de defaut";
        this.isRobot = false;

        for(int i = 0; i < 3; i++){

            playercircles[i][0] = n+1;
            playercircles[i][1] = 3;

        }
    }
}