package com.isep.rpg;

public class Mage extends Hero {

    // Attributs de la classe Mage
    private int nbMana;
    private static final int COUT_BOULE_FEU = 5;
    private static final int COUT_BOULE_GLACE = 6;
    private static final int COUT_ENCORSELER = 8;

    // Constructeur de la classe Mage
    public Mage(String nom, int vie, int attaque,int NbMana) {
        super(nom, vie, attaque,NbMana);
        this.nbMana = nbMana;
    }

    // Implémentation de la méthode abstraite "combattre"
    @Override
    public void combattre() {
        System.out.println(getNom() + " lance un sort !");
    }

    // Méthodes de la classe Mage
    public void lancerBouleDeFeu(Combatant target) {
        if (nbMana >= COUT_BOULE_FEU) {
            nbMana -= COUT_BOULE_FEU;
            target.setHealth(target.getHealth() - 5);
            System.out.println(getNom() + " lance une boule de feu et inflige 10 points de dégâts !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer une boule de feu !");
        }
    }

    public void lancerBouleDeGlace(Combatant target) {
        if (nbMana >= COUT_BOULE_GLACE) {
            nbMana -= COUT_BOULE_GLACE;
            target.setHealth(target.getHealth() - 5);
            //int degats = 12;
            //target.setHealth(target.getHealth() - degats);
            System.out.println(getNom() + " lance une boule de glace et inflige " + "degats" + " points de dégâts !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer une boule de glace !");
        }
    }


    public void lancerEncorseler(Combatant target) {
        if (nbMana >= COUT_ENCORSELER) {
            nbMana -= COUT_ENCORSELER;
            target.setHealth(target.getHealth() - 5);
            System.out.println(getNom() + " lance un sort d'encorsellement et inflige 15 points de dégâts !");
        } else {
            System.out.println(getNom() + " n'a pas assez de mana pour lancer un sort d'encorsellement !");
        }
    }

    public int getMana() { return nbMana;
    }

    public void gainMana(int amount) {
        nbMana += amount;
        System.out.println("Vous avez récupérer 50 de mana");
    }
}