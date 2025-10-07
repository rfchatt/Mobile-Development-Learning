// TP 7

// Ex 1

class Main1 {

    public static double maximum (double[] tableau) {
        double max = 0;
        for (double nombre : tableau) {
            if (max < nombre) {
                max = nombre;
            }
        }
        return max;
    }

    public static double moyenne (double[] tableau) {
        double somme = 0;
        for (double nombre : tableau) {
            somme += nombre;
        }
        return somme / tableau.length - 1;
    }

    public static double pairs (double[] tableau) {
        int pairCounter = 0;
        for (double nombre : tableau) {
            if (nombre % 2 == 0) {
                pairCounter++;
            }
        }
        return pairCounter;
    }

    public static double position (double[] tableau, double nbr_check) {
        double index = 0;
        for (int i = 0; i < tableau.length; i++) {
            for (double nombre : tableau) {
                if (nbr_check == nombre) {
                    index = tableau[i] + 1;
                    break;
                }
            }
        }
        if (index == 0) {
            System.out.print("La position du nombre : " + nbr_check + " est : [-!-] (n'existe pas) --> ");
        } else {
            System.out.print("La position du nombre : " + nbr_check + " est : --> ");
        }
        return index;
    }

    public static void main (String[] args) {

        double[] tableau = {12, 5, 27, 8, 15, 3};

        System.out.println("Le Maximum : " + maximum(tableau));
        System.out.println("Le Moyenne : " + String.format("%.2f", moyenne(tableau)));
        System.out.println("Le nombre de pairs: " + pairs(tableau));
        System.out.println(position(tableau, 8));
        System.out.println(position(tableau, 100));
    }
}

// Ex 2

class Main2 {

    public static double aireCalcule (double rayon) {
        double Pi = 3.14;
        double aire = Pi * (Math.pow(rayon, 2));
        return aire;
    }

    public static double perimetreCalcule (double rayon) {
        double Pi = 3.14;
        double perimetre = 2 * Pi * rayon;
        return perimetre;
    }

    public static double aireRectangleCalcule (double longeur, double largeur) {
        double aireRectangle = longeur * largeur;
        return aireRectangle;
    }

    public static double sphereVolumeCalcule (double rayon) {
        double Pi = 3.14;
        double sphereVolume = (4/3) * Pi * (Math.pow(rayon, 3));
        return sphereVolume;
    }

    public static void main(String[] args) {
        System.out.println("--- Le Cercle ---");
        System.out.println("L'Aire : " + aireCalcule(7));
        System.out.println("Le Perimetre : " + perimetreCalcule(7));
        System.out.println();
        System.out.println("--- Le Rectangle ---");
        System.out.println("L'Aire : " + aireRectangleCalcule(8, 4));
        System.out.println();
        System.out.println("--- La Sphére ---");
        System.out.println("Le Volume : " + sphereVolumeCalcule(3));
    }
}

// Ex 3

