import java.util.Scanner;

// TP 5

class Main {
    public static void main(String[] args) {
        Scanner Objet1 = new Scanner(System.in);

        String[] subjects = {"     ", "Maths", "Physique", "Francais", "Histoire"};
        String[] students = {" Sara", "Ahmed", "  Aya", "Amine"};

        double[][] notes = {
                {15.5, 14.0, 16.0, 13.5},
                {12.0, 11.5, 14.5, 10.0},
                {18.0, 17.5, 15.0, 16.5},
                {13.0, 12.5, 11.0, 14.0}
        };

        // Affichage de Tableau

        System.out.println(java.util.Arrays.toString(subjects));
        System.out.println("  ------------------------------------------");
        for (int i = 0; i < notes.length; i++) {
            System.out.print( " | " + students[i] + " | ");
            for (int j = 0; j < students.length; j++) {
                System.out.print(notes[i][j] + " |   ");
            }
            System.out.println();
        }
        System.out.println("  ------------------------------------------");
        System.out.println();


        // Moyenne général
        for (int i = 0; i < students.length; i++) {
            double totalNotes = 0.0;
            for (int j = 0; j < notes[i].length; j++) {
                totalNotes += notes[i][j];
            }
            double moyenneNote = totalNotes / (subjects.length - 1);
            System.out.println("La Moyenne général de " + students[i] + " : " + moyenneNote);
        }
        System.out.println();


        // Meilleur moyenne général
        double maxMoyenne = 0.0;
        for (int i = 0; i < students.length; i++) {
            double AllMoyennes = 0.0;
            for (int j = 0; j < notes[i].length; j++) {
                AllMoyennes += notes[i][j];
            }
            double moyenne = AllMoyennes / notes.length;
            if (maxMoyenne < moyenne) {
                maxMoyenne = moyenne;
            }
        }
        System.out.println("La meilleur moyenne général : " + maxMoyenne);


        // Moyenne par matiére
        // ...

    }
}







// ----------------------------------------

// V=> Run 

//     [     , Maths, Physique, Francais, Histoire]
//       ------------------------------------------
//      |  Sara | 15.5 |   14.0 |   16.0 |   13.5 |   
//      | Ahmed | 12.0 |   11.5 |   14.5 |   10.0 |   
//      |   Aya | 18.0 |   17.5 |   15.0 |   16.5 |   
//      | Amine | 13.0 |   12.5 |   11.0 |   14.0 |   
//       ------------------------------------------

//     La Moyenne général de  Sara : 14.75
//     La Moyenne général de Ahmed : 12.0
//     La Moyenne général de   Aya : 16.75
//     La Moyenne général de Amine : 12.625

//     La meilleur moyenne général : 16.75

