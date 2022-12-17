package com.isep.rpg;

public class Hero extends Combatant {

    // Constructeur de la classe Guerrier
    public Hero(String nom, int vie, int attaque, int defense) {
        super( nom, vie, attaque, defense);
    }

    public boolean estVivant() {
        return this.vie > 0;
    }

    // Implémentation de la méthode abstraite "combattre"
    @Override
    public void combattre() {
        System.out.println("Le guerrier attaque avec sa épée !");
    }
    private String nomHero;

    public String getNom() {
        return nomHero;
    }

}




