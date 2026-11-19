import java.util.ArrayList;
import java.util.List;

public class Enclos {
    private String nom;
    private String type; // ex: "Savane", "Aquarium"
    private int capaciteMax;
    private List<Animal> animaux = new ArrayList<>();

    public Enclos(String nom, String type, int capaciteMax) {
        this.nom = nom;
        this.type = type;
        this.capaciteMax = capaciteMax;
    }

    // Ajouter un animal à l'enclos
    public boolean ajouterAnimal(Animal a) {
        if (animaux.size() < capaciteMax) {
            animaux.add(a);
            System.out.println(a.getNom() + " ajouté à " + nom);
            return true;
        }
        System.out.println("Enclos " + nom + " est plein !");
        return false;
    }

    // Faire faire du bruit à tous les animaux (polymorphisme !)
    public void reveillerAnimaux() {
        System.out.println("\n=== Réveil de " + nom + " ===");
        for (Animal a : animaux) {
            a.faireDuBruit(); // polymorphisme en action
        }
    }

    public void afficherAnimaux() {
        System.out.println("Enclos [" + type + "] " + nom +
                           " (" + animaux.size() + "/" + capaciteMax + ") :");
        animaux.forEach(a -> System.out.println("  - " + a));
    }
}
