
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KnopBesturing implements KeyListener {

    /*
    Naar aanleiding van eerdere feedback momenten is ons aangeraden de KeyEvents in een aparte klasse te doen.
    De knop besturing implementeerd de KeyListeren. De KeyListener is onderdeel van de Java library.
    Door deze superklasse te impenmenteren kan de speler door middel van opgegeven knoppen bewegen.
    Hierin hebben we ondervangen dat wanneer de speler van het veld wilt aflopen dat de try en catch dit opvangt.

     */

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        try {
            switch (keycode) {

                case KeyEvent.VK_UP: {

                    if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX(), Main.veld.speler.getTegelY() - 1).equals("")) {
                        if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX(), Main.veld.speler.getTegelY() - 1).equals("")) {
                            Main.veld.beweegSpeler(-1, 0);
                        }
                    }
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX(), Main.veld.speler.getTegelY() + 1).equals("")) {
                        if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX(), Main.veld.speler.getTegelY() + 1).equals("")) {
                            Main.veld.beweegSpeler(1, 0);
                        }
                    }
                    break;

                }
                case KeyEvent.VK_LEFT: {
                    if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX() - 1, Main.veld.speler.getTegelY()).equals("")) {
                        if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX() - 1, Main.veld.speler.getTegelY()).equals("")) {
                            Main.veld.beweegSpeler(0, -1);
                        }
                    }
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX() + 1, Main.veld.speler.getTegelY()).equals("")) {
                        if (!Main.veld.map.getTegel(Main.veld.speler.getTegelX() + 1, Main.veld.speler.getTegelY()).equals("")) {
                            Main.veld.beweegSpeler(0, 1);
                        }
                    }
                    break;
                }
                case  KeyEvent.VK_ESCAPE: {
                    Main.stop();
                    break;
                }
                case  KeyEvent.VK_DELETE: {
                    Main.veld.levelUp(1);
                    break;
                }
            }

        } catch (Exception error) {
            System.out.println("De speler kan zich niet buiten het speelveld verplaatsen");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
