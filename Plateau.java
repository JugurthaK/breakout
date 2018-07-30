class Plateau {

    private Pion tabPions[][];
    private int taille;

    public Plateau(int taille) {
        this.taille = taille;
        tabPions = new Pion[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tabPions[i][j] = new Pion(i, j, 0);
            }
        }
    }

    public Plateau() {
        this(5);
    }

    private int caseVide(int numLigne, boolean gauche) {

        if (gauche) {
            for (int i = 0; i < tabPions.length; i++) {
                if (tabPions[numLigne][i].getNumJoueur() == 0) {
                    return i;
                }
            }
            return tabPions.length;
        }

        else {
            for (int i = tabPions.length - 1; i >= 0; i--) {
                if (tabPions[numLigne][i].getNumJoueur() == 0) {
                    return i;
                }
            }
            return 0;
        }
    }

    private void decalageLigneGauche(int numLigne, int numJoueur) {
        int caseVide = caseVide(numLigne, true);

        if (caseVide == 0) {
            tabPions[numLigne][0].setNumJoueur(numJoueur);
        } else if (caseVide != -1) {
            for (int i = caseVide; i > 0; i--) {
                try {
                    tabPions[numLigne][i].setNumJoueur(tabPions[numLigne][i - 1].getNumJoueur());

                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
            tabPions[numLigne][0].setNumJoueur(numJoueur);
        }
    }

    private void decalageLigneDroite(int numLigne, int numJoueur) {
        int caseVide = caseVide(numLigne, false);
        int taille = tabPions.length - 1;

        if (caseVide == taille) {
            tabPions[numLigne][taille].setNumJoueur(numJoueur);
        } else if (caseVide != -1) {
            for (int i = caseVide; i < taille; i++) {
                try {
                    tabPions[numLigne][i].setNumJoueur(tabPions[numLigne][i + 1].getNumJoueur());

                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
            tabPions[numLigne][taille].setNumJoueur(numJoueur);
        }
    }

    public void ajoutPion(int numLigne, int numJoueur, boolean gauche) {
        if (gauche) {
            decalageLigneGauche(numLigne, numJoueur);
        } else {
            decalageLigneDroite(numLigne, numJoueur);
        }
    }

    public String toString() {

        String affichage = new String();

        affichage += "\n";
        for (int i = 0; i < tabPions.length; i++) {
            for (int j = 0; j < tabPions.length; j++) {
                affichage += " " + tabPions[i][j].getNumJoueur();
            }
            affichage += "\n";
        }

        return affichage;
    }

    public void clearPlateau() {
        for (int i = 0; i < tabPions.length; i++) {
            for (int j = 0; j < tabPions.length; j++) {
                tabPions[i][j] = new Pion();
            }
        }
    }

    public Pion[][] getPlateau() {
        return tabPions;
    }

    public int getTaille() {
        return taille;
    }

    public boolean gagne(int numLigne, int numColonne, int numJoueur) {
        try {
            if (tabPions[numLigne + 1][numColonne].getNumJoueur() == numJoueur) {
                gagne(numLigne + 1, numColonne, numJoueur);
                if (numLigne == tabPions.length - 1) {
                    System.out.println("Joueur gagne");
                    return true;
                }
            } else if (tabPions[numLigne][numColonne + 1].getNumJoueur() == numJoueur) {
                gagne(numLigne, numColonne + 1, numJoueur);
                if (numLigne == tabPions.length - 1) {
                    System.out.println("Joueur gagne");
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        System.out.println("Joueur gagne pas");
        return false;
    }

}