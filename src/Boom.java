import javax.swing.*;

class Boom extends SpelObject {

    /*
    De klasse Boom overerft de constructor van spelobject.
    De klasse boom is verder alleen een image die een plek in neemt op de map.
    De speler kan niet over de boom heen lopen en hierom hebben we de methode collisie geschreven.
    Polymorphise toegepast wat er voor zorgt dat de speler niet door de bomen/muren heen kan lopen.
     */

    Boom() {
        super.setLabel(new JLabel(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("img/Boom.png").getFile())));
    }

    @Override
    // Polymorphisme
    public boolean collisie() {
        return false;
    }
}