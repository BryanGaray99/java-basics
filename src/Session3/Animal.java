package Session3;

public class Animal {
    private String name;
    private String species;
    private String features;
    private String likes;

    public void registerAnimal(String name, String species, String features, String likes){
        this.name = name;
        this.species = species;
        this.features = features;
        this.likes = likes;
    }

    public String printAnimal(){
        String animal = ("Name: " + this.name + "; Species: " + this.species + "; Features: " + this.features + "; Liked... " + this.likes);
        return animal;
    }
}

class Zoo {
    public static void main(String[] args) {
        System.out.println("Animals you liked the most:");
        Animal animal1 = new Animal();
        animal1.registerAnimal("Axolotl", "Ambystoma mexicanum", "Salamander with external gills", "Watching him swimming in the water");
        System.out.println(animal1.printAnimal());

        Animal animal2 = new Animal();
        animal2.registerAnimal("Quokka", "Setonix brachyurus", "Smiling marsupial", "Seeing its cute smile");
        System.out.println(animal2.printAnimal());

        Animal animal3 = new Animal();
        animal3.registerAnimal("Okapi", "Okapia johnstoni", "Giraffe-like body with zebra stripes", "Watching its unique appearance");
        System.out.println(animal3.printAnimal());

        Animal animal4 = new Animal();
        animal4.registerAnimal("Aye-Aye", "Daubentonia madagascariensis", "Nocturnal primate with long fingers", "Seeing its long fingers");
        System.out.println(animal4.printAnimal());

        Animal animal5 = new Animal();
        animal5.registerAnimal("Narwhal", "Monodon monoceros", "Arctic whale with a long spiral tusk", "Being amazed by its long tusk");
        System.out.println(animal5.printAnimal());
    }
}
