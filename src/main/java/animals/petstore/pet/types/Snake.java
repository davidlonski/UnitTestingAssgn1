package animals.petstore.pet.types;

import animals.AnimalType;
import animals.petstore.pet.Pet;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.PetType;
import animals.petstore.pet.attributes.Skin;

import java.math.BigDecimal;

public class Snake extends Pet implements PetImpl {
    private Breed breed;
    private boolean isVenomous;

    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed) {
        this(animalType, skinType, gender, breed, new BigDecimal(0));
    }

    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost) {
        this(animalType, skinType, gender, breed, cost, 0);
    }

    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost, int petStoreId) {
        super(PetType.SNAKE, cost, gender, petStoreId);
        super.skinType = skinType;
        super.animalType = animalType;
        this.breed = breed;
        this.isVenomous = isVenomousBreed(breed);
    }

    private boolean isVenomousBreed(Breed breed) {
        return breed == Breed.COPPERHEAD || breed == Breed.CORAL;
    }

    public String snakeHypoallergenic() {
        return super.petHypoallergenic(this.skinType).replaceAll("pet", "snake");
    }

    public String speak() {
        String language;
        switch (this.animalType) {
            case DOMESTIC:
                language = "The snake goes hiss! hiss!";
                break;
            case WILD:
                language = "The snake goes ssss! ssss!";
                break;
            default:
                language = "The snake goes " + super.getPetType().speak + "! " + super.getPetType().speak + "!";
                break;
        }
        return language;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    @Override
    public Breed getBreed() {
        return this.breed;
    }

    public AnimalType getAnimalType() {
        return super.animalType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "The snake is " + this.animalType + "!\n" +
                "The snake breed is " + this.getBreed() + "!\n" +
                "The snake is " + (isVenomous ? "venomous" : "not venomous") + "!\n" +
                this.snakeHypoallergenic() + "!\n" +
                this.speak();
    }
} 