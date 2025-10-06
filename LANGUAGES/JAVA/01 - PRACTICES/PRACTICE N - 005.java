import java.util.Scanner;

// TP 5

class main {
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

        System.out.println(java.util.Arrays.toString(subjects));
        for (int i = 0; i < notes.length; i++) {
            System.out.print(students[i] + " | ");
            for (int j = 0; j < students.length; j++) {
                System.out.print(notes[i][j] + " |   ");
            }
            System.out.println();
        }


        for (int i = 0; i < students.length; i++) {
            double totalNotes = 0.0;

            for (int j = 0; j < notes[i].length; j++) {
                totalNotes += notes[i][j];
            }

            double moyenneNote = totalNotes / (subjects.length - 1);
            System.out.println("La moyenne général de " + students[i] + " : " + moyenneNote);
        }
    }
}

