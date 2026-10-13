package tn.esprit.gestionzoo.entities;

public class Zoo {
    // Constante : peut rester publique, elle ne peut pas être modifiée
    public static final int NBR_CAGES = 25;

    // Instruction 18 : attributs privés (encapsulation)
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    public Zoo(String name, String city) {
        this.animals = new Animal[NBR_CAGES];
        setName(name); // on passe par le setter pour appliquer le contrôle
        this.city = city;
    }

    // ----- Getters et setters -----
    public String getName() {
        return name;
    }

    // Règle métier : le nom d'un zoo ne doit pas être vide
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erreur : le nom du zoo ne doit pas être vide.");
            return;
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Pas de setter : le nombre d'animaux ne change que via addAnimal / removeAnimal
    public int getNbrAnimals() {
        return nbrAnimals;
    }

    // Pas de getter/setter sur le tableau : on ne veut pas qu'il soit modifié de l'extérieur

    // Instruction 17 : addAnimal utilise isZooFull()
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (isZooFull()) {
            System.out.println("Impossible d'ajouter " + animal.getName() + " : le zoo est plein.");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Impossible d'ajouter " + animal.getName() + " : il est déjà dans le zoo.");
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Le zoo " + name + " ne contient aucun animal.");
            return;
        }
        System.out.println("Animaux du zoo " + name + " :");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println("  [" + i + "] " + animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }
        for (int i = 0; i < nbrAnimals; i++) {
            // animals[i].name n'est plus accessible : on utilise le getter
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + NBR_CAGES);
        System.out.println("Nombre d'animaux : " + nbrAnimals);
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES
                + ", nbrAnimals=" + nbrAnimals + "}";
    }
}
