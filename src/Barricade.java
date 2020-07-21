import javax.swing.*;

public class Barricade extends SpelObject {

    /*
    De klasse Barricade overerft de constructor van spelobject.
    Barricade moet voorzien worden van een waarde waarmee je het object kan ontgrendelen.
    Er bestaan 4 barricades met ieder zijn eigen ontgrendelwaarde 100/200/300/400.
    De images zijn meteen voorzien van de deze ontgrendelwaarde
    De barricadewaarde wordt aangeroepen bij het uitlezen van de map.
    Wanneer niet de juiste sleutelwaarde wordt toegepast op de muur geven we een melding door gebruik van JOptionPane.
     */

    int ontgrendelWaarde;

    public Barricade(int ontgrendelWaarde){
        this.ontgrendelWaarde = ontgrendelWaarde;
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/Barricade" + ontgrendelWaarde + ".png").getFile())));
    }

    @Override
    public boolean collisie() {
        if(Speler.sleutelWaarde == ontgrendelWaarde) {
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Je hebt niet de juiste sleutel!");
            return false;
        }
    }
}
