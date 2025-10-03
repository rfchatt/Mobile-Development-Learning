import java.util.Scanner;

// TP 3
// Exercise 1

class somme {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        System.out.println("Enter the 1st Number : ");
        int num1 = Objet.nextInt();
        System.out.println("Enter the 2nd Number : ");
        int num2 = Objet.nextInt();
        System.out.println("Enter the 3rd Number : ");
        int num3 = Objet.nextInt();
        System.out.println("Enter the 4rd Number : ");
        int num4 = Objet.nextInt();
        System.out.println("Enter the 5rd Number : ");
        int num5 = Objet.nextInt();

        Integer[] table = {num1, num2, num3, num4, num5};
        int somme = num1 + num2 + num3 + num4 + num5;

        System.out.println("La somme des élément de Tableau : " + somme);

    }
}

// Exercise 2

class moyenne {
    public static void main(String[] args) {
        Scanner Objet1 = new Scanner(System.in);

        System.out.println("Enter the 1st Number : ");
        int num1 = Objet1.nextInt();
        System.out.println("Enter the 2nd Number : ");
        int num2 = Objet1.nextInt();
        System.out.println("Enter the 3rd Number : ");
        int num3 = Objet1.nextInt();
        System.out.println("Enter the 4rd Number : ");
        int num4 = Objet1.nextInt();
        System.out.println("Enter the 5rd Number : ");
        int num5 = Objet1.nextInt();

        int moyenne = (num1 + num2 + num3 + num4 + num5) / 5;
        System.out.println("Le moyenne des élément de Tableau : " + moyenne);

        Integer[] table = {num1, num2, num3, num4, num5};
        int max = table[0];
        for (int i = 1; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
            }
        }
        System.out.println("Le plus grand nombre c'est : " + max);

        System.out.print("Le tableau en ordre inverse : ");
        for (int i = table.length - 1; i >= 0; i--) {
            System.out.print(table[i] + " ");
            }
    }
}

// Exercise 3

