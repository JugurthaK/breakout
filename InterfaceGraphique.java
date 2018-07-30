import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;

/**
 * InterfaceGraphique
 */
public class InterfaceGraphique {

    private int taille;
    private Fenetre f;
    private Souris s;
    private int positionClique;
    private Texte te = new Texte(Couleur.BLANC, "", new Font("Calibri", Font.TYPE1_FONT, 30),
            new Point(500 / 2, 500 + 125));

    public InterfaceGraphique(int taille) {
        taille = taille * 100;
        this.taille = taille;
        this.f = new Fenetre("Break Out", taille, taille + 150);
        this.s = f.getSouris();

        Point origine = new Point();
        Carre c = new Carre(Couleur.GRIS_FONCE, origine, taille + 150, true);
        Texture t = new Texture(Couleur.GRIS_FONCE, "./img/prisonnier_bleu.png", new Point(100, 500), 100, 100);
        Texture t2 = new Texture(Couleur.GRIS_FONCE, "./img/prisonnier_rouge.png", new Point(300, 500), 100, 100);

        f.ajouter(c);

        for (int i = 0; i < (taille) / 100; i++) {
            for (int j = 0; j < (taille) / 100; j++) {
                Point p = new Point(i * 100, j * 100);
                Carre ce = new Carre(Couleur.GRIS_CLAIR, p, 99, true);
                f.ajouter(ce);
            }
        }
        f.ajouter(t);
        f.ajouter(t2);
        f.rafraichir();
    }

    public InterfaceGraphique() {
        this(5);
    }

    public void fromPlateau(Pion[][] tabPions) {
        for (int i = 0; i < tabPions.length; i++) {
            for (int j = 0; j < tabPions.length; j++) {
                if (tabPions[i][j].getNumJoueur() == 1) {
                    Point p = new Point(j * 100, (this.taille - 100) - i * 100);
                    Texture t = new Texture(Couleur.GRIS_CLAIR, "./img/croixBleue.png", p, 99, 99);

                    f.ajouter(t);
                    f.rafraichir();
                } else if (tabPions[i][j].getNumJoueur() == 2) {
                    Point p = new Point(j * 100, (this.taille - 100) - i * 100);
                    Texture t = new Texture(Couleur.GRIS_CLAIR, "./img/croixRouge.png", p, 99, 99);
                    f.ajouter(t);
                    f.rafraichir();
                }
            }
        }
    }

    public Point getPositionClique() {
        do {
            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }
        } while (s.getClicGauche() != true);
        return s.getPosition();
    }

    public void setText(int s) {
        this.te.setTexte("Le joueur " + s + " doit jouer");
        f.ajouter(te);
        f.rafraichir();
    }

    public void setCouleur(Couleur c) {
        this.te.setCouleur(c);
    }

    public void refresh() {
        f.rafraichir();
    }
}