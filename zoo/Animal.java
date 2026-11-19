// Animal.java — version abstraite finale
public abstract class Animal {
    private String nom;
    private int age;
    private double poids;
    private String espece;

    public Animal(String nom, int age, double poids, String espece) {
        this.nom = nom;
        setAge(age);
        setPoids(poids);
        this.espece = espece;
    }

    // ── Méthode ABSTRAITE → sous-classes obligées d'implémenter ──
    public abstract void faireDuBruit();

    // ── Méthodes concrètes ────────────────────
    public String getNom() { return nom; }
    public int getAge() { return age; }
    public double getPoids() { return poids; }
    public String getEspece() { return espece; }

    public void setNom(String nom) {
        if (nom != null && !nom.isEmpty()) this.nom = nom;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 100) this.age = age;
        else
            System.out.println("Erreur : age invalide (" + age + ")");
    }

    public void setPoids(double p) {
        if (p > 0) this.poids = p;
    }

    @Override
    public String toString() {
        return "[" + espece + "] " + nom +
               " | Age : " + age + " | " + poids + " kg";
    }
}
