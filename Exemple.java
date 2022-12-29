package Game;
import java.awt.Color;
import GUI.*;

public class Exemple {
    
public static void main(String[]args){
GUI Test =new GUI();
Test.startWindow();
System.out.println("La partie n'est pas commencée");
while(Test.gameIsStarted() == false){System.out.println(" ");} //REMARQUE : je suis obligé de mettre une intruction dans le while sinon ca ne fonctionne pas.
System.out.println("La partie commence et il y a " + Test.getPlayerNumber() + " joueurs");


for (int i = 1 ; i < Test.getPlayerNumber()+1 ; i++){
    System.out.println("le joueur " + i + " s'appelle : " + Test.getPlayerName(i) +".");
}


}

    
}
