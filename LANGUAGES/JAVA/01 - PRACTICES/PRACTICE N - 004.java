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
