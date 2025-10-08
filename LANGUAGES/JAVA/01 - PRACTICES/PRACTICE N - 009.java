// TP 2 - OOP

package POO3;

import java.lang.reflect.Constructor;

public class Jouer {

    String nom;
    Integer numero;
    String poste;
    Integer nbButs;
    double salaire;

    public Jouer () {
        this.nom = "Abderrafie";
        this.numero = 1;
        this.poste = "goalkeeper";
        this.nbButs = 2;
        this.salaire = 70000;
    }

    public Jouer (String nomJ, Integer numeroJ, String posteJ, Integer nbButsJ, double salaireJ) {
        this.nom = nomJ;
        this.numero = numeroJ;
        this.poste = posteJ;
        this.nbButs = nbButsJ;
        this.salaire = salaireJ;
    }

    public void afficherInfos () {
        System.out.println("Le Nom de Jouer : " + nom);
        System.out.println("Le Numero de Jouer : " + numero);
        System.out.println("Le Poste de Jouer : " + poste);
        System.out.println("Le Numero des Buts de Jouer : " + nbButs);
        System.out.println("Le Salaire de Jouer : " + salaire + " DH");
    }

}
