// SmartWash.java

package POO2;

public class SmartWash {

    public String Nom;
    public String Marque;
    public double Prix;
    public String Couleur;

    public void aficherInfos () {
        System.out.println("Le Nom : " + Nom);
        System.out.println("La Marque : " + Marque);
        System.out.println("Le Prix : " + Prix + " DH");
        System.out.println("Le Couleur : " + Couleur);
    }

}

// ----

// Main2.java

import POO1.Voiture;
import POO2.SmartWash;

public class Main2 {
    public static void main(String[] args) {

        SmartWash ob1 = new SmartWash();
        ob1.Nom = "Vehicule";
        ob1.Marque = "Dacia";
        ob1.Prix = 30;
        ob1.Couleur = "Noire";

        SmartWash ob2 = new SmartWash();
        ob2.Nom = "Camion";
        ob2.Marque = "Volvo";
        ob2.Prix = 150;
        ob2.Couleur = "Blanche";

        SmartWash ob3 = new SmartWash();
        ob3.Nom = "Maison";
        ob3.Marque = "Tapis";
        ob3.Prix = 25;
        ob3.Couleur = "Rouge";

        double SmartWash[] = {ob1.Prix, ob2.Prix, ob3.Prix};

        double prixMoyenne = (ob1.Prix + ob2.Prix + ob3.Prix) / 3;
        System.out.println("Le Prix Moyenne des Smart Wash : " + prixMoyenne);

        double prixMax = 0;
        for (double prix : SmartWash) {
            if (prixMax < prix) {
                prixMax = prix;
            }
        }
        System.out.println("Smart Wash la plus Cher : " + prixMax);

    }
}
