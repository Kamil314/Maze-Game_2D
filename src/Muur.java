import javax.swing.*;

class Muur extends SpelObject {

    /*
    -De klasse muur overerft de constructor van spelobject.
    -De klasse muur is verder alleen een image die een plek in neemt op de map.
    -De speler kan niet over de muur heen lopen en hierom hebben we de methode collisie geschreven.
    -Polymorphise toegepast wat er voor zorgt dat de speler niet door de bomen/muren heen kan lopen.
     */

    Muur() {
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/Muur.png").getFile())));
    }

    @Override
    public boolean collisie() {
        return false;
    }
}