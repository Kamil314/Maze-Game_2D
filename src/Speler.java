import javax.swing.*;

class Speler extends SpelObject {

    /*
    De klasse speler overerft de klasse spelobject i.v.m. de image.
    Daarnaast krijgt het nog wat extra waardes zoals tegelX en tegelY om zich over et speelveld te bewegen.

    Tevens hebben we bij de speler een sleutelwaarde gedeclareerd. Deze komt terug in de methode collisie bij klasse sleutel.
    Zodra de sleutelwaarde gelijk is aan de ontgrendelwaarde verwijdert de barricade en wordt deze vervangen voor een leeg spelobject(tegel).
     */

    static int tegelX, tegelY;
    public static int sleutelWaarde;

    Speler(int tegelY, int tegelX) {
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/SpelerAsh.png").getFile())));
        move(tegelX, tegelY);
    }

    int getTegelX() {
        return tegelX;
    }

    int getTegelY() {
        return tegelY;
    }

    void move(int y, int x) {
        tegelX += x;
        tegelY += y;
    }

    void set(int y, int x) {
        tegelX = x;
        tegelY = y;
    }
}