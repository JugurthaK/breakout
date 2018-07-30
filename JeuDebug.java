class JeuDebug {
    public static void main(String[] args) {

        Plateau p = new Plateau();
        InterfaceGraphique Ig = new InterfaceGraphique();
        int nbCoups = 0;
        int maxCoups = p.getTaille() * p.getTaille();

        while (nbCoups <= maxCoups) {
            int numJoueur = 2;
            Ig.setText(2);


            if (nbCoups % 2 == 0) {
                numJoueur = 1;
            Ig.setText(1);

            }

            int cote = (int) (Ig.getPositionClique().getX()) / 100;
            int ligne = (int) (Ig.getPositionClique().getY()) / 100;
            ligne = (p.getTaille() - 1) - ligne;
          
            if (ligne >= 0) {
                if (cote > 2) {
                    p.ajoutPion(ligne, numJoueur, false);
                    Ig.fromPlateau(p.getPlateau());
                    Ig.refresh();
                    nbCoups++;
                } else {
                    p.ajoutPion(ligne, numJoueur, true);
                    Ig.fromPlateau(p.getPlateau());
                    Ig.refresh();
                    nbCoups++;
                }
            }
        }

        System.out.println(p);
    }
}