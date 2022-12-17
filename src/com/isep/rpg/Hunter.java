package com.isep.rpg;

public class Hunter extends Hero {

    // Attributs de la classe Hunter
    private int nbFlechesArc;
    private int nbFlechesArbalete;
    private boolean cache;

    // Constructeur de la classe Hunter
    public Hunter(String nom, int vie, int attaque, int defense) {
        super(nom, vie, attaque, defense);
        // this.nbFlechesArc = nbFlechesArc;
        // this.nbFlechesArbalete = nbFlechesArbalete;
        this.cache = false;
    }

    // Implémentation de la méthode abstraite "combattre"
    @Override
    public void combattre() {
        if (nbFlechesArc > 0) {
            nbFlechesArc--;
            System.out.println(getNom() + " attaque avec son arc et inflige 5 points de dégâts !");
        } else if (nbFlechesArbalete > 0) {
            nbFlechesArbalete--;
            System.out.println(getNom() + " attaque avec son arbalète et inflige 7 points de dégâts !");
        } else {
            System.out.println(getNom() + " n'a plus de flèches et ne peut pas attaquer !");
        }
    }

    // Méthodes de la classe Hunter
    /*public void seCacher() {
        cache = true;
        System.out.println(getNom() + " se cache !");
    }

     */

    public void sortirDeSaCache() {
        cache = false;
        System.out.println(getNom() + " sort de sa cache !");
    }

    public boolean estCache() {
        return cache;
    }

    public int getNbFlechesArc() {
        return nbFlechesArc;
    }

    public int getNbFlechesArbalete() {
        return nbFlechesArbalete;
    }

    public void attackArbalette(Combatant target) {
        // Diminue les points de vie de la cible en fonction de l'attaque du personnage
        target.setHealth(target.getHealth() - 5);
    }
    public void attackArc(Combatant target) {
        // Diminue les points de vie de la cible en fonction de l'attaque du personnage
        target.setHealth(target.getHealth() - 3);

}


    public void seCacher() {
        this.cache = true;
        System.out.println("Tu te caches pour éviter les attaques ennemies.");
    }

}