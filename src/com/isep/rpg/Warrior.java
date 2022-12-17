package com.isep.rpg;

public class Warrior extends Hero {

    // Attributs de la classe Warrior
    private boolean enDefense;

    // Constructeur de la classe Warrior
    public Warrior(String nom, int vie, int attaque, int defense) {
        super(nom, vie, attaque,defense);
        this.enDefense = false;
    }

    // Implémentation de la méthode abstraite "combattre"
    @Override
    public void combattre() {
        if (enDefense) {
            System.out.println(getNom() + " se défend !");
        } else {
            System.out.println(getNom() + " attaque avec son épée !");
        }
    }

    // Méthodes de la classe Warrior
    public void seDefendre() {
        enDefense = true;
    }

    public void attaquer() {
        enDefense = false;
    }

    public boolean estEnDefense() {
        return enDefense;
    }

}
