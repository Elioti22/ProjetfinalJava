package com.isep.rpg;
import java.util.Random;

public abstract class Enemy extends Combatant {


    public Enemy(String nom, int vie, int attaque, int defense) {
        super(nom, 50, 10, 5);
    }


    public abstract void Pertepv1(int damage);
}