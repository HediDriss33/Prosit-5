package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    protected float swimmingSpeed;

    public Dolphin() {
    }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat,
                   float swimmingSpeed) {
        super(family, name, age, isMammal, habitat); // appelle le constructeur d'Aquatic
        this.swimmingSpeed = swimmingSpeed;
    }

    // Instruction 24 : redéfinition de swim()
    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }

    @Override
    public String toString() {
        return "Dolphin{family='" + getFamily() + "', name='" + getName() + "', age=" + getAge()
                + ", isMammal=" + isMammal() + ", habitat='" + habitat
                + "', swimmingSpeed=" + swimmingSpeed + "}";
    }
}
