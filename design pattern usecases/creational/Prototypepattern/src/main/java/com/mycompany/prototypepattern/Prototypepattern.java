/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Cloning animals
package com.mycompany.prototypepattern;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Animal extends Cloneable {
    Animal clone();
}

// Concrete Prototype
class Sheep implements Animal {
    private String name;

    public Sheep(String name) {
        this.name = name;
    }

    @Override
    public Animal clone() {
        return new Sheep(name);
    }

    @Override
    public String toString() {
        return "Sheep [name=" + name + "]";
    }
}

// Prototype Registry
class AnimalRegistry {
    private Map<String, Animal> animals = new HashMap<>();

    public AnimalRegistry() {
        loadAnimals();
    }

    private void loadAnimals() {
        Sheep dolly = new Sheep("Dolly");
        animals.put("Sheep", dolly);
    }

    public Animal getAnimal(String type) {
        Animal animal = animals.get(type);
        return animal.clone();
    }
}

// Main class
public class Prototypepattern{
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();

        Animal sheep1 = registry.getAnimal("Sheep");
        System.out.println(sheep1);

        Animal sheep2 = registry.getAnimal("Sheep");
        System.out.println(sheep2);
    }
}
