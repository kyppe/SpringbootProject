// Nourrissable.java
public interface Nourrissable {
    // Méthodes abstraites (public abstract implicite)
    void manger(String nourriture);
    double getRationJournaliere(); // en kg

    // Méthode par défaut (Java 8+)
    default void afficherRegime() {
        System.out.println("Ration journalière : " +
                           getRationJournaliere() + " kg");
    }
}
