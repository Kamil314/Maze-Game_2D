import javax.swing.*;

/*
De klasse Spelobject is een abstracte template voor alle objecten in het spel.
Dit zorgt er voor dat er een beveiliging in komt dat alleen tegels spelobjecten kunnen inhouden.
De klasse zelf staat voor een lege tegel. De andere klasses die de constructor overerven krijgen zijn eigen image/waardes mee.
 */

class SpelObject {
    private JLabel label;

    public SpelObject() {
        setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/RasterTegel.png").getFile())));
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public boolean collisie() {
        return true;
    }
}
