import java.awt.*;

public class ecran extends Frame{
    ecran() {  
      
        // creating a button   
        Button b = new Button("Start");  
    
        // setting button position on screen  
        b.setBounds(250,250,100,30);  
    
        // adding button into frame    
        add(b);  
    
        // frame size 600 width and 600 height    
        setSize(600,600);  
    
        // setting the title of Frame  
        setTitle("Jeu Otrio");   
            
        // no layout manager   
        setLayout(null);   
    
        // now frame will be visible, by default it is not visible
        setVisible(true);
    }
}
