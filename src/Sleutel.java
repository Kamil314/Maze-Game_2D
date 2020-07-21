import javax.swing.*;

public class Sleutel extends SpelObject {

    /*
    -De klasse sleutel overerft de constructor van spelobject.
    -De sleutels worden aangeroepen bij het uitlezen van de map.

    -Wanneer de sleutelwaarde gelijk is aan de ontgrendelwaarde dan verandert de waarde collisie naar true
    zodat de sleutel van het speelveld verdwijnt.
     */

    int ontgrendelWaarde;

    public Sleutel(int ontgrendelWaarde) {
        this.ontgrendelWaarde = ontgrendelWaarde;
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/Sleutel" + ontgrendelWaarde + ".png").getFile())));
    }

    @Override
    public boolean collisie() {
        Speler.sleutelWaarde = ontgrendelWaarde;
        return true;
    }
}
