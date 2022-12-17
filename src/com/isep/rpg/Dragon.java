package com.isep.rpg;

public class Dragon extends Enemy {


    public Dragon(String nom, int vie, int attaque ,int defense) {
        super(nom, vie, attaque, defense);
    }

    @Override
    public void Pertepv1(int damage) {

    }

    @Override
    public void combattre() {

    }
    public void setHealth(int health) {
        this.vie = health;
    }

    public int getHealth() {
        return this.vie;
    }
}
