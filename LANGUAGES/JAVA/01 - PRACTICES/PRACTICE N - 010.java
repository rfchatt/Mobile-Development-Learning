// path : 

//   ______________________
//   src ¬                 |
//       POO3 (package) ¬  |
//           Logement      |
//           Appartement   |
//           Maison        |
//       Main3             |
//   ______________________|



// Class Logement

package POO3;

public class Logement {

    private String adress;
    private double surface;
    private double prix;

    public Logement(String a, double s, double p) {
        this.adress = a;
        this.surface = s;
        this.prix = p;
    }

    public String getAdress () {
        return this.adress;
    }
    public void setAdress (String adressS) {
        this.adress = adressS;
    }

    public double getSurface () {
        return this.surface;
    }
    public void setSurface (double surfaceS) {
        this.surface = surfaceS;
    }

    public double getPrix () {
        return this.prix;
    }
    public void setPrix (double prixS) {
        this.prix = prixS;
    }

    public void afficherInfos () {
        System.out.println("L'Adress : " + adress);
        System.out.println("Le Surface : " + surface);
        System.out.println("Le Prix : " + prix);
    }

}

// ---

// Class Appartement

package POO3;

public class Appartement extends Logement {

    Integer etage;

    public Appartement (String a, double s, double p, Integer etg) {
        super(a, s, p);
        this.etage = etg;
    }

    @Override
    public void afficherInfos () {
        super.afficherInfos();
        System.out.println("L'étage : " + etage);
    }

}

// ---

// Class Maison

package POO3;

public class Maison extends Logement {

    Integer nbChambres;

    public Maison (String a, double s, double p, Integer nbChbr) {
        super(a, s, p);
        this.nbChambres = nbChbr;
    }

    @Override
    public void afficherInfos () {
        super.afficherInfos();
        System.out.println("Le Nombre de Chambres : " + nbChambres);
    }

}

// ---

// Class Main3 (Programme Principal)

import POO3.Appartement;
import POO3.Maison;

public class Main3 {

    public static void main(String[] args) {

        Appartement appartement = new Appartement("Mesnana", 2, 400000, 1);
        Maison maison = new Maison("BenDiban", 1, 650000, 3);

        appartement.afficherInfos();
        maison.afficherInfos();

        appartement.setPrix(375000);
        maison.setPrix(600000);

    }
}



/*
    QUESTIONS :

        * Les Attributes sont déclarés privés pour : Protéger l'accés direct á laide
          d'Encapsulation, et Getters & Setters.

        * super() est une mot clé utiliser pour : Appeler le Constructor de Class-Mére
          et initialiser les Attributes hérites.

        * Héritée : Utilisée directement depuis la classe parente.
          Redéfinie : Implémentée à nouveau dans la sous-classe pour modifier/compléter
          son comportement.

        * ERREUR de compilation.

        *

* */
