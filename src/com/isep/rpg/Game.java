package com.isep.rpg;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    // Liste des héros du jeu
    private ArrayList<Hero> hero;

    // Liste des dragons ennemis du jeu
    private ArrayList<Dragon> dragons;

    public boolean isEmpty(ArrayList<Dragon> dragons) {
        return dragons.isEmpty();
    }


    // Constructeur de la classe Game
    public Game() {
        this.hero = new ArrayList<>();
        this.dragons = new ArrayList<>();
    }

    // Méthode pour ajouter un héros au jeu
    public void addHero(Hero hero) {
        this.hero.add(hero);
    }

    // Méthode pour ajouter un dragon ennemi au jeu
    public void addDragon(Dragon dragon) {
        this.dragons.add(dragon);
    }

    // Méthode pour démarrer le jeu
    public void start() {

        //this.inputParser = inputParser;
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur combien de héros il souhaite créer
        int numHeroes = Rules1("Veuillez indiquer le nombre de héros souhaitez (max 5) : ");
        if (numHeroes>5){
            System.out.print("Veuillez respecter les regles et choisissez un nombre entre 1 et 4 ! \n");
            NombreHero();


        }
        //System.out.print("Combien de héros voulez-vous créer ? ");
        //int numHeroes = scanner.nextInt();

        // Demande à l'utilisateur de choisir les classes et les noms de chaque héros
        for (int i = 0; i < numHeroes; i++) {
            System.out.print("Choisissez la classe du héros (Mage, Hunter, Warrior, Healer) : ");
            String heroClass = scanner.next();
            System.out.print("Choisissez le nom du héros : ");
            String nom = scanner.next();


            // Crée un nouveau héros en fonction de la classe choisie par l'utilisateur
            Hero hero;
            switch (heroClass) {
                case "Mage":
                    hero = new Mage(nom, 5, 5, 5);
                    break;
                case "Hunter":
                    hero = new Hunter(nom, 50, 50, 40);
                    break;
                case "Warrior":
                    hero = new Warrior(nom, 50, 50, 40);
                    break;
                case "Healer":
                    hero = new Healer(nom, 50, 50, 3, 4);
                    break;
                default:
                    throw new IllegalArgumentException("Classe de héros non valide");
            }

            // Ajoute le héros à la liste des héros du jeu
            addHero(hero);
        }

        // Ajoute des dragons ennemis au jeu
        addDragon(new Dragon("Dragon rouge", 50, 0, 50));
        addDragon(new Dragon("Dragon vert", 50, 0, 50));
        addDragon(new Dragon("Dragon bleu", 50, 0, 50));

        // Boucle de jeu principale
        while (true) {

            boolean allHeroesDead = true;
            boolean allDragonsDead = true;

            // Si un héros ou un dragon est mort, quitte la boucle
            for (Hero hero : hero) {
                if (!hero.estmort()) {
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead) {
                System.out.println("Vous avez perdu.");
                break;
            }
            for (Dragon dragon : dragons) {
                if (!dragon.estmort()) {
                    allDragonsDead = false;
                    break;
                }
            }
            if (allDragonsDead) {
                System.out.println("Vous avez gagné.");
                break;
            }


            // Si un héros ou un dragon est mort, quitte la boucle


            // Affiche l'état des héros et des dragons
            while (true) {

                boolean allHeroeslives = true;
                boolean allDragonlives = true;


            System.out.println("État des héros :");
            for (Hero hero : hero) {
                System.out.println(hero.getName() + " (Vie : " + hero.getHealth());
            }
            System.out.println("État des dragons ennemis :");
            for (Dragon dragon : dragons) {
                System.out.println(dragon.getName() + " (Vie : " + dragon.getHealth());
            }

            // Demande à l'utilisateur de choisir quel héros attaquer
            System.out.print("Choisissez un héros pour attaquer (0-" + (numHeroes - 1) + ") : ");
            int heroIndex = scanner.nextInt();
            Hero hero = this.hero.get(heroIndex);

            // Demande à l'utilisateur de choisir quel dragon attaquer
            System.out.print("Choisissez un dragon à attaquer (0-" + (dragons.size() - 1) + ") : ");
            int dragonIndex = scanner.nextInt();
            Dragon dragon = dragons.get(dragonIndex);






                if (hero instanceof Hunter) {
                    System.out.print("Choisissez une arme pour attaquer (Arc, Arbalette,secacher) : ");
                    String arme = scanner.next();

                    if (arme.equals("Arc")) {
                        ((Hunter) hero).attackArbalette(dragon);
                        System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (arme.equals("Arbalette")) {
                        ((Hunter) hero).attackArc(dragon);
                        System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (arme.equals("secacher")) {
                        ((Hunter) hero).seCacher();
                    } else {
                        System.out.println("Arme non valide, veuillez réessayer.");
                    }
                } else if (hero instanceof Warrior) {
                    System.out.print("Voulez-vous attaquer ou vous défendre (Attaquer, Défendre) : ");
                    String action = scanner.next();
                    if (action.equals("Défendre")) {
                        ((Warrior) hero).seDefendre();
                    }
                } else if (hero instanceof Healer) {
                    System.out.print("Voulez-vous soigner un allié ou attaquer (Soigner1, Soigner2,manaa) : ");
                    String action = scanner.next();

                    if (action.equals("Soigner1")) {
                        ((Healer) hero).soignerLeger(hero);
                        hero.recevoirDegats(-10);
                        //System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (action.equals("Soigner2")) {
                        ((Healer) hero).soignerCritique(hero);
                        hero.recevoirDegats(-10);
                        //System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (action.equals("manaa")) {
                        ((Healer) hero).gainMana(50);
                    }



                    /*if (action.equals("Soigner")) {


                        System.out.print("Choisissez un héros à soigner (0-" + (numHeroes - 1) + ") : ");
                        int allyIndex = scanner.nextInt();
                    }

                     */

                } else if (hero instanceof Mage) {
                    System.out.print("Choisissez un sort à lancer (Bouledefeu, Boule de glace, Potion de soin) : ");
                    String sort = scanner.next();

                    if (sort.equals("Bouledefeu")) {
                        ((Mage) hero).lancerBouleDeFeu(dragon);
                        dragon.setHealth(dragon.getHealth() - 5);
                        //System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (sort.equals("BouledeGlace")) {
                        ((Mage) hero).lancerBouleDeGlace(dragon);
                        dragon.setHealth(dragon.getHealth() - 5);
                        //System.out.println("Tu as infligé 5 points de dommages au " + dragon.getName() + " ennemes");
                    }
                    if (sort.equals("manaa")) {
                        ((Mage) hero).gainMana(50);
                    } else
                    {

                   /* switch (sort) {
                        case "Bouledefeu":
                            ((Mage) hero).lancerBouleDeFeu(dragon);
                            break;
                        case "Bouledeglace":
                            ((Mage) hero).lancerBouleDeGlace(dragon);
                            break;
                        case "manaa":
                            ((Mage) hero).gainMana(50);
                            break;
                        default:
                            throw new IllegalArgumentException("Sort non valide");
                    }

                    */

                }


                // Fait attaquer le héros choisi au dragon choisi
                hero.attack(dragon);

                // Vérifie si le dragon est mort
                if (dragon.estmort()) {
                    System.out.println("Le dragon " + dragon.getName() + " est mort !");
                    dragons.remove(dragon);
                }

                // Si tous les dragons sont morts, le jeu se termine
                if (isEmpty(dragons)) {
                    System.out.println("Tous les dragons ont été vaincus, vous avez gagné !");
                    break;
                }

                // Fait attaquer tous les dragons aux héros
                for (Dragon d : dragons) {
                    d.infligerDegats(hero);
                }

                // Vérifie si tous les héros sont morts
                boolean gameOver = true;
                for (Hero h : this.hero) {
                    if (!h.estmort()) {
                        gameOver = false;
                        break;
                    }
                }

                // Si tous les héros sont morts, le jeu se termine
                if (gameOver) {
                    System.out.println("Tous vos héros sont morts, vous avez perdu !");
                    break;
                }

            }
        }
    }
}
    public int Rules1(String text) {
        System.out.println(text);
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez choisir un numero entre 1 et 4 ! ");
            }
        }
    }
    public int NombreHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Combien de héros voulez-vous créer ? ");
        int numHeroes = scanner.nextInt();
        return numHeroes;
    }
}




