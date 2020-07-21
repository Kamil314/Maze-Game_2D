import javax.swing.*;
import java.awt.*;

public class EindDoel extends SpelObject{

    /*
    De klasse EindDoel overerft de constructor van spelobject.
    Dit houdt in dat een image aan het object wordt meegegeven.
    Tevens moet er een vervolg worden gegeven wanneer de speler in aanraking(collisie) komt met het EindDoel
    Zodra dit gebeurd wordt het volgende level afgespeeld.
    Je kan niet door het EindDoel heen lopen maar je gaat wel door naar een volgend level.
     */

    public EindDoel(){
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/Pikachu.png").getFile())));
    }

    @Override
    public boolean collisie() {

        int nieuwLevel = Main.veld.level;
        if(nieuwLevel < 4) {
            JOptionPane.showMessageDialog(null, "Je hebt het level gehaald :) ");
            nieuwLevel += 1;
        }
        else {
            JOptionPane.showMessageDialog(null, "Laatste level behaald! ");
            nieuwLevel = 1;
        }


        Main.veld.levelUp(nieuwLevel);
        return false;
    }
}
