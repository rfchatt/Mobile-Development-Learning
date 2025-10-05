import java.util.Scanner;

// TP 4
// Exercise 1

class main{
    public static void main(String[] args) { 
        Scanner Objet = new Scanner(System.in);

        int[][] tableau2D = new int[2][3];

        System.out.println("Veuillez remplir ce tableau : \n");

        for (int i = 0; i < tableau2D.length; i++) {
            for (int j = 0; j < tableau2D[i].length; j++) {
                System.out.println("entrer la valeur de ligne [" + i + "] colonne[" + j + "] : ");
                tableau2D[i][j] = Objet.nextInt();
            }
        }
        System.out.println("_________________\n");
        for (int i = 0; i < tableau2D.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < tableau2D[i].length; j++) {
                System.out.print("| " + tableau2D[i][j] + " ");
            }
            System.out.print("|");
        }
        System.out.println("\n___________________");
    }
}

// Exercise 2

class main2 {
    public static void main(String[] args) {
        Scanner Objet2 = new Scanner(System.in);

        int[][] tableau2 = new int [3][3];

        for (int i = 0; i < tableau2.length; i++) {
            for (int j = 0; j < tableau2[i].length; j++) {
                System.out.println("Enter the value of ligne " + i + " et Column " + j + " : ");
                tableau2[i][j] = Objet2.nextInt();
            }
        }

        System.out.println("La sommes des lignes :");
        for (int i = 0; i < tableau2.length; i++) {
            int somme_lignes = 0;
            for (int j = 0; j < tableau2[i].length; j++) {
                somme_lignes += tableau2[i][j];
            }
            System.out.println("ligne " + i + " est : " + somme_lignes);
        }

        System.out.println("-----------------------");
        System.out.println("La sommes des columns :");

        for (int j = 0; j < tableau2[0].length; j++) {
            int somme_columns = 0;
            for (int i = 0; i < tableau2.length; i++) {
                somme_columns += tableau2[i][j];
            }
            System.out.println("ligne " + j + " est : " + somme_columns);
        }
    }
}

// Exercise 3

class main3 {
    public static void main (String[] args) {
        Scanner Objet3 = new Scanner(System.in);

        int[][] tableau3 = new int[2][3];

        for (int i = 0; i < tableau3.length; i++) {
            for (int j = 0; j < tableau3[i].length; j++) {
                System.out.print("Enter the value of line " + i + " column " + j + " : ");
                tableau3[i][j] = Objet3.nextInt();
            }
        }

        System.out.println("--- Le tableau original : ---");
        for (int i = 0; i < tableau3.length; i++) {
            for (int j = 0; j < tableau3[i].length; j++) {
                System.out.print(tableau3[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=== Le tableau transposé : ===");
        for (int j = 0; j < tableau3[0].length; j++) {
            for (int i = 0; i < tableau3.length; i++) {
                System.out.print(tableau3[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Exercise 4

class main4 {
    public static void main(String[] args) {
        Scanner Objet4 = new Scanner(System.in);

        int[][] tableau4 = new int[3][4];

        System.out.println("Remplissage de tableau : ");
        for (int i = 0; i < tableau4.length; i++) {
            for (int j = 0; j < tableau4[i].length; j++) {
                System.out.print("Ligne " + i + " Colonne " + j + " : ");
                tableau4[i][j] = Objet4.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < tableau4.length; i++) {
            for (int j = 0; j < tableau4[i].length; j++) {
                if (max < tableau4[i][j]) {
                    max = tableau4[i][j];
                }
            }
        }
        System.out.println("La valeur max : " + max);

        int min = 0;
        for (int i = 0; i < tableau4.length; i++) {
            for (int j = 0; j < tableau4[i].length; j++) {
                if (min > tableau4[i][j]) {
                    min = tableau4[i][j];
                }
            }
        }
        System.out.println("La valeur min : " + min);

    }
}

// Exercise 5

class main5 {
    public static void main (String[] args) {
        Scanner Objet5 = new Scanner(System.in);

        int [][] tableau5 = new int[3][3];

        System.out.println("Remplissage de Tableau : ");
        for (int i = 0; i < tableau5.length; i++) {
            for (int j = 0; j < tableau5[i].length; j++) {
                System.out.print("Ligne " + i + " Colonne " + j + " : ");
                tableau5[i][j] = Objet5.nextInt();
            }
        }

        System.out.println("--- Affichage de Tableau ---");
        for (int i = 0; i < tableau5.length; i++) {
            for (int j = 0; j < tableau5[i].length; j++) {
                System.out.print(tableau5[i][j] + " ");
            }
            System.out.println();
        }

        int somme = 0;
        for (int i = 0; i < tableau5.length; i++) {
            for (int j = 0; j < tableau5[i].length; j++) {
                somme += tableau5[i][j];
            }
        }
        System.out.println("La somme des Lignes et Colonnes : " + somme);

        int moyenne = 0;
        for (int i = 0; i < tableau5.length; i++) {
            for (int j = 0; j < tableau5[i].length; j++) {
                moyenne = somme / (tableau5.length * tableau5[0].length);
            }
        }
        System.out.println("Le moyenne de Tableau : " + moyenne);
    }
}
