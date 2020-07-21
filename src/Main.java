import javax.swing.*;
import java.awt.*;

public class Main {

	/*
	-We hebben voor een final int breedte/hoogte gekozen zodat dit later niet meer kan worden aangepast.
	-Resized hebben we op false gezet anders heeft deze breedte/hoogte geen nut.

	-Speelveld extends JPanel, waardoor het speelveld wordt toegevoegd aan het frame.
	 Tevens hebben we een methode aangemaakt met Stop (dispose). Deze wordt in de klasse Keyevents gebruikt om de JFrame
	 uiteindelijk af te sluiten.
	 */

	public static JFrame f = new JFrame();
	private final static int hoogte = 749;
	private final static int breedte = 646;
	public static Speelveld veld;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		veld = new Speelveld();

		f.setTitle("SleutelBarricade");

		veld.updateSpelObjecten();
		KnopBesturing knopbesturing = new KnopBesturing();

		f.addKeyListener(knopbesturing);
		f.add(veld);

		f.setSize(breedte, hoogte);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//opmaak van de labels
		veld.stopLabel.setForeground(Color.white);
		veld.groepsLabel.setForeground(Color.orange);
		veld.resetLabel.setForeground(Color.white);
		veld.stopLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		veld.groepsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		veld.resetLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		f.setVisible(true);
	}

	public static void stop() {
		f.dispose();
	}
}
