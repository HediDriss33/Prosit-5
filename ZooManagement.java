package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;

public class ZooManagement {
    public static void main(String[] args) {

        // ---- Instruction 21 : constructeurs par défaut ----
        Aquatic a0 = new Aquatic();
        Terrestrial t0 = new Terrestrial();
        Dolphin d0 = new Dolphin();
        Penguin p0 = new Penguin();
        System.out.println("Objets créés avec les constructeurs par défaut :");
        System.out.println(a0);
        System.out.println(t0);
        System.out.println(d0);
        System.out.println(p0);

        // ---- Instruction 22 : constructeurs paramétrés ----
        Aquatic aquatic = new Aquatic("Cyprinidae", "Nemo", 2, false, "bassin");
        Terrestrial terrestrial = new Terrestrial("Felidae", "Simba", 5, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "océan", 35.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingu", 4, false, "mer", 120.0f);

        // ---- Instruction 23 : toString() redéfini ----
        System.out.println("\nObjets créés avec les constructeurs paramétrés :");
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        // ---- Instruction 24 : swim() ----
        System.out.println("\nAppels de swim() :");
        aquatic.swim();  // This aquatic animal is swimming.
        dolphin.swim();  // This dolphin is swimming.         (méthode redéfinie)
        penguin.swim();  // This aquatic animal is swimming.  (méthode héritée d'Aquatic)
    }
}
