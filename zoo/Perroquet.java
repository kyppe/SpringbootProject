public class Perroquet extends Animal implements Nourrissable {
    private String couleurPlumage;
    private String motAppris; // mot que le perroquet répète

    public Perroquet(String nom, int age, double poids,
                     String couleur, String mot) {
        super(nom, age, poids, "Oiseau");
        this.couleurPlumage = couleur;
        this.motAppris = mot;
    }

    public void parler() {
        System.out.println(getNom() + " dit : " + motAppris + " !");
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " crie : " + motAppris + " !");
    }

    @Override
    public void manger(String nourriture) {
        System.out.println(getNom() + " grignote : " + nourriture);
    }

    @Override
    public double getRationJournaliere() {
        return getPoids() * 0.10; // 10% pour les oiseaux
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Plumage : " + couleurPlumage;
    }
}
