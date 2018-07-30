/**
 * Pion
 */
class Pion {

    private int x;
    private int y;
    private int numJoueur;

    public Pion(int x, int y, int numJoueur) {
        this.x = x;
        this.y = y;
        this.numJoueur = 0;
    }

    public Pion (){
        this(0,0,0);
    }

    public int getNumJoueur(){
        return this.numJoueur;
    }

    public void setNumJoueur(int n){
        this.numJoueur = n;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){
        return ("Pion [" + this.x + ", " + this.y + "]" + " Numero : " + this.numJoueur);
    }
}