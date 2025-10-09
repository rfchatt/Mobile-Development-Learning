// TP 2

package POO3;

public class Jouer {

    // Les Attributes

    private String nom;
    private Integer numero;
    private String poste;
    private Integer nbButs;
    private double salaire;

    // Vide Constructor

    public Jouer () {
        this.nom = "Abderrafie";
        this.numero = 1;
        this.poste = "goalkeeper";
        this.nbButs = 2;
        this.salaire = 70000;
    }

    // Constructor avec des Variables

    public Jouer (String nomJ, Integer numeroJ, String posteJ, Integer nbButsJ, double salaireJ) {
        this.nom = nomJ;
        this.numero = numeroJ;
        this.poste = posteJ;
        this.nbButs = nbButsJ;
        this.salaire = salaireJ;
    }

    // Méthode afficherInfos

    public void afficherInfos () {
        System.out.println("Le Nom de Jouer : " + nom);
        System.out.println("Le Numero de Jouer : " + numero);
        System.out.println("Le Poste de Jouer : " + poste);
        System.out.println("Le Numero des Buts de Jouer : " + nbButs);
        System.out.println("Le Salaire de Jouer : " + salaire + " DH");
    }

    // getters & Setters

    public String getNom () {
        return this.nom;
    }
    public void setNom (String nomS) {
        this.nom = nomS;
    }

    public Integer getNumero () {
        return this.numero;
    }
    public void setNumero (Integer numeroS) {
        this.numero = numeroS;
    }

    public String getPoste () {
        return this.poste;
    }
    public void setPoste (String posteS) {
        this.poste = posteS;
    }

    public Integer getNbButs () {
        return nbButs;
    }
    public void setNbButs (Integer nbButsS) {
        this.nbButs = nbButsS;
    }

    public double getSalaire () {
        return this.salaire;
    }
    public void setSalaire (double salaireS) {
        this.salaire = salaireS;
    }

    // Méthodes de Calcul

    public double calculerSalaireMoyen (Jouer[] equipe) {

        double salaireTotal = 0;

        for (Jouer jouer : equipe) {
            salaireTotal = jouer.salaire;
        }
        return salaireTotal / equipe.length;
    }
    // ... compléter les méthodes de calcul

}
