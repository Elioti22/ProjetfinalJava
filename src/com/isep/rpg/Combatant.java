package com.isep.rpg;

public abstract class Combatant {

    // Attributs de la classe Combattant
    protected int vie;
    protected int attaque;
    protected int defense;

    protected String nom;

    // Constructeur de la classe Combattant
    public Combatant(String nom, int vie, int attaque, int defense) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.nom = nom;
    }


    // Méthode abstraite "combattre" qui doit être implémentée par les classes filles de Combattant
    public abstract void combattre();

    // Méthodes de la classe Combattant
    public void recevoirDegats(int degats) {
        vie -= degats;
    }

    public int infligerDegats(Hero Dragon) {
        return attaque;
    }

    public boolean estVivant() {
        return this.vie > 0;
    }

    public boolean estmort() {
        // Determine if the dragon is dead and return the appropriate value
        // For example, you could check if the dragon's hit points are less than or equal to 0
        if (this.vie <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void gethp() {

        this.vie = 6 + vie;
}
    private String nomHero;

    public String getNom() {
        return nomHero;
    }

    // Méthode pour attaquer un autre personnage
    public void attack(Combatant target) {
        // Diminue les points de vie de la cible en fonction de l'attaque du personnage
        target.setHealth(target.getHealth() - this.attaque);
    }

    // Getters et setters pour les attributs de la classe
    public String getName() {
        return this.nom;
    }
    public int getHealth() {
        return this.vie;
    }
    public void setHealth (int vie) {
        this.vie = vie;
    }
    public int getAttack() {
        return this.attaque;
    }
    public void setAttack(int attaque) {
        this.attaque = attaque;
    }

    //public boolean estVivant2() {
      //  return this.vie() > 0;
   // }

    public void perdreVie(int degats) {
        this.vie -= degats;
        if (this.vie < 0) {
            this.vie = 0;
        }
    }


}


