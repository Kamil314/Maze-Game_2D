import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Map {

    /*
    -Klasse map wordt gebruikt om alle spelobjecten in te laden op de coordinaten in de map.
    -Er wordt een nieuw spelobject geladen. Als deze gelijk is aan de default dan krijg je een nieuw leeg spelobject.
    -We hanteren een standaard map grootte van 10 X 10 tegels.
    -We hebben hiervoor gekozen anders verspringt de layout steeds.
    -Eerst wordt de map uitgelezen op grootte. Vervolgens wordt de map doormiddel van een forloop gevuld met spelobjecten.
    -Ieder spelobject heeft zijn eigen stringwaarde/ontgrendelwaarde/sleutelwaarde meegekregen.
     */

    public SpelObject[][] tegels;
    public int breedte;
    public int hoogte;
    public Speler speler;

    public SpelObject getTegel(int x, int y) {
        return tegels[y][x];
    }

    private void berekenMapGrootte(int level) {
        Scanner blauwdruk = null;
        try {
            blauwdruk = new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource(String.format("maps/level_%s.txt", level)).getFile()));

            if (blauwdruk.hasNextLine()) {
                breedte = blauwdruk.nextLine().length();
            }

            while (blauwdruk.hasNextLine()) {
                hoogte = blauwdruk.nextLine().length();
            }

            tegels = new SpelObject[hoogte][breedte];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            blauwdruk.close();
        }
    }

    public Map(int level, Speler speler) {
        this.speler = speler;
        berekenMapGrootte(level);

        Scanner blauwdrukprint = null;
        try {
            blauwdrukprint = new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource(String.format("maps/level_%s.txt", level)).getFile()));

            int y = -1;
            while (blauwdrukprint.hasNextLine() && y < hoogte) {
                y++;
                String tekst = blauwdrukprint.nextLine();

                String[] textArray = tekst.split("");

                for (int x = 0; x < breedte; x++) {
                    switch (textArray[x]) {
                        case "m": {
                            tegels[y][x] = new Muur();
                            break;
                        }
                        case "b": {
                            tegels[y][x] = new Boom();
                            break;
                        }
                        case "1": {
                            tegels[y][x] = new Barricade(100);
                            break;
                        }
                        case "2": {
                            tegels[y][x] = new Barricade(200);
                            break;
                        }
                        case "3": {
                            tegels[y][x] = new Barricade(300);
                            break;
                        }
                        case "4": {
                            tegels[y][x] = new Barricade(400);
                            break;
                        }
                        case "5": {
                            tegels[y][x] = new Sleutel(100);
                            break;
                        }
                        case "6": {
                            tegels[y][x] = new Sleutel(200);
                            break;
                        }
                        case "7": {
                            tegels[y][x] = new Sleutel(300);
                            break;
                        }
                        case "8": {
                            tegels[y][x] = new Sleutel(400);
                            break;
                        }
                        case "9": {
                            tegels[y][x] = new EindDoel();
                            break;
                        }

                        default: {
                            tegels[y][x] = new SpelObject();
                            break;
                        }
                    }
                }
            }

            tegels[speler.getTegelY()][speler.getTegelX()].setLabel(speler.getLabel());

        } catch (Exception e) {
            System.out.println("Error loading map");
        } finally {
            blauwdrukprint.close();
        }
    }
}
