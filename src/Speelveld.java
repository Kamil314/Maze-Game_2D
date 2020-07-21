import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Speelveld extends JPanel implements ActionListener {

    /*
    -Speelveld extends de superklasse JPanel. Welke vervolgens op het JFrame wordt gepalaatst.
    Het JPanel wordt onderverdeelt in 2 gebieden door middel van de borderlayout (menu gedeelte/ veld gedeelte).
    -Daarnaast is speelveld het punt waar veel klasses samen komen. Veel objecten worden hier gedeclareerd om vervolgens verderop in de
    code te kunnen gebruiken.
    -De methode update spelobjecten speelt een belangrijke rol in onderstaande code. Bij iedere verandering zoals een beweging
    gedurend het spel moeten de spelobjecten opnieuw ingelezen worden en bij verandering worden aangepast(repaint).

     */

    public JLabel stopLabel = new JLabel("(ESC) = Stoppen", JLabel.CENTER);
    public JLabel groepsLabel = new JLabel("Groep C", JLabel.CENTER);
    public JLabel resetLabel = new JLabel("(Delete) = Resetten", JLabel.CENTER);
    public Speler speler;
    public Map map;
    public int level;

    private JPanel veldPanel;
    private JPanel menuPanel;

    public Speelveld() {
        super.setLayout(new BorderLayout());
        speler = new Speler(0, 0);
        level = 1;
        map = new Map(level, speler);

        menuPanel = new JPanel(new GridLayout(1, 3));
        veldPanel = new JPanel(new GridLayout(map.breedte, map.hoogte));

        super.add(menuPanel, BorderLayout.PAGE_START);
        super.add(veldPanel, BorderLayout.CENTER);

        this.menuPanel.add(this.stopLabel);
        this.menuPanel.add(this.groepsLabel);
        this.menuPanel.add(this.resetLabel);

        this.stopLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 20));
        this.groepsLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 20));
        this.resetLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 20));

        this.menuPanel.setBackground(Color.DARK_GRAY);
        this.menuPanel.setPreferredSize(new Dimension(500, 80)); // size van de menu(boven) panel met 2 labels (stoppen/reset)


        // Render alle objecten.
        updateSpelObjecten();
    }

    void beweegSpeler(int moveY, int moveX) {
        int origineleX = speler.getTegelX();
        int origineleY = speler.getTegelY();

        if(map.tegels[origineleY + moveY][origineleX + moveX].collisie()) {
            map.tegels[origineleY][origineleX] = new SpelObject();
            map.tegels[origineleY + moveY][origineleX + moveX] = speler;
            speler.move(moveY, moveX);
        }
        updateSpelObjecten();
    }

    void updateSpelObjecten() {

        // Verwijder alles uit het panel.
        veldPanel.removeAll();

        // Toon alle objecten opnieuw in het panel.
        for (SpelObject[] tegel : map.tegels) {
            for (SpelObject object : tegel) {
                veldPanel.add(object.getLabel());
            }
        }
        veldPanel.revalidate();
        veldPanel.repaint();
    }

    public void levelUp(int lvl) {
        level = lvl;
        speler = new Speler(0,0);
        speler.set(0,0);
        map = new Map(level, speler);
        updateSpelObjecten();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateSpelObjecten();
    }
}
