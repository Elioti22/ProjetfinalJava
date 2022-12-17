package com.isep.rpg;

public class Healer extends Hero {

    // Attributs de la classe Healer
    private int nbMana;
    private static final int COUT_SOIN_LEGER = 5;
    private static final int COUT_SOIN_MODERE = 8;
    private static final int COUT_SOIN_CRITIQUE = 12;

    // Constructeur de la classe Healer
    public Healer(String nom, int vie, int attaque, int defense, int nbMana) {
        super(nom, vie, attaque,nbMana);
        this.nbMana = nbMana;
    }

    // Implémentation de la méthode abstraite "combattre"
    @Override
    public void combattre() {
        System.out.println(getNom() + " lance un sort de soin !");
    }

    // Méthodes de la classe Healer
    public void soignerLeger(Combatant allie) {
        if (nbMana >= COUT_SOIN_LEGER) {
            nbMana -= COUT_SOIN_LEGER;
            allie.recevoirDegats(-10);
            System.out.println(getNom() + " soigne " + getNom() + " de 10 points de vie !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer un sort de soin léger !");
        }
    }

    public void soignerModere(Combatant allie) {
        if (nbMana >= COUT_SOIN_MODERE) {
            nbMana -= COUT_SOIN_MODERE;
            allie.recevoirDegats(-20);
            System.out.println(getNom() + " soigne " + getNom() + " de 20 points de vie !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer un sort de soin modéré !");
        }
    }

    public void soignerCritique(Combatant allie) {
        if (nbMana >= COUT_SOIN_MODERE) {
            nbMana -= COUT_SOIN_MODERE;
            allie.recevoirDegats(-30);
            System.out.println(getNom() + " soigne " + getNom() + " de 30 points de vie !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer un sort de soin modéré !");
        }
    }

    public void gainMana(int amount) {
        nbMana += amount;
        System.out.println("Vous avez récupérer 50 de mana");
    }
}