public class Requin extends Animal implements Nourrissable {
    private String espece;   // ex: "Blanc", "Marteau"
    private double longueur; // en mètres

    public Requin(String nom, int age, double poids,
                  String espece, double longueur) {
        super(nom, age, poids, "Poisson");
        this.espece = espece;
        this.longueur = longueur;
    }

    public void nager() {
        System.out.println(getNom() + " nage silencieusement...");
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " ... (silence) ...");
    }

    @Override
    public void manger(String nourriture) {
        System.out.println(getNom() + " avale : " + nourriture);
    }

    @Override
    public double getRationJournaliere() {
        return getPoids() * 0.02; // 2% du poids corporel
    }

    @Override
    public String toString() {
        return super.toString() +
               " | " + espece + " " + longueur + "m";
    }
}
