public class Main {

    static void nourrirAnimal(Animal a) {
        System.out.println("\n>>> Nourrissage de " + a.getNom());
        a.faireDuBruit();
    }

    public static void main(String[] args) {
        // Créer les enclos
        Enclos savane   = new Enclos("Savane Africaine", "Mammifères", 4);
        Enclos aquarium = new Enclos("Grand Aquarium", "Poissons", 3);
        Enclos voliere  = new Enclos("Volière Tropicale", "Oiseaux", 5);

        // Créer les animaux
        Lion simba = new Lion("Simba", 5, 190.0, "Africain");
        Lion nala  = new Lion("Nala", 4, 135.0, "Berbère");
        Perroquet coco = new Perroquet("Coco", 3, 0.4, "Vert", "Bonjour");
        Perroquet rio  = new Perroquet("Rio", 2, 0.5, "Rouge", "Ola !");
        Requin jaws = new Requin("Jaws", 10, 680.0, "Grand Blanc", 5.5);

        // Placer les animaux
        savane.ajouterAnimal(simba);
        savane.ajouterAnimal(nala);
        aquarium.ajouterAnimal(jaws);
        voliere.ajouterAnimal(coco);
        voliere.ajouterAnimal(rio);

        // Afficher le zoo
        System.out.println("\n=== BIENVENUE AU ZOO ===\n");
        savane.afficherAnimaux();
        aquarium.afficherAnimaux();
        voliere.afficherAnimaux();

        // Réveiller tous les animaux (polymorphisme !)
        savane.reveillerAnimaux();
        voliere.reveillerAnimaux();

        // Nourrir tous les animaux (interface Nourrissable)
        Animal[] tous = { simba, nala, coco, rio, jaws };
        System.out.println("\n=== Nourrissage du soir ===");
        for (Animal a : tous) {
            nourrirAnimal(a);
            if (a instanceof Nourrissable n) {
                n.manger("sa nourriture habituelle");
                n.afficherRegime();
            }
        }
    }
}
