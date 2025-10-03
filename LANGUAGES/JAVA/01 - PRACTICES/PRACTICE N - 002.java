import java.util.Scanner;

// TP 1

class Main4 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        System.out.println("Enter a Number : ");
        int number = Objet.nextInt();

        if (number < 0) {
            System.out.println(number + " is a Negative Number");
        } else if (number > 0) {
            System.out.println(number + " is a Positive Number");
        } else {
            System.out.println(number + " is equal to 0");
        }

    }
}


// TP 2

class Main5 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}

// TP 3

class Main6 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

// TP 4

class main7 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        int[] numbers = {5, 10, 15, 20, 25};

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}

// TP 5

class main8 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        int count = 7;
        while (count >= 0) {
            System.out.println(count);
            count--;
        }
    }
}

// TP 6

class main9 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        System.out.println("Enter a Number : ");
        int number = Objet.nextInt();

        double result = 0;
        int i = 1;

        while (i <= number) {
            result += 1.0/i;
            i++;
        }
        System.out.println("la somme c'est : " + result);
    }
}

// TP 7

class main10 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        System.out.println("Enter a Number : ");
        int n = Objet.nextInt();

        long factorielle = 1;

        for (int i = 1; i <= n; i++) {
            factorielle *= i;
        }
        System.out.println("le factorielle de " + n + " est : " + factorielle);
    }
}

// TP 8

class main11 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        for (int i = 1; i <= 100; i++) {

            if (i % 3 == 0) {
                System.out.print(i+" 3z \n");
            } else if (i % 5 == 0) {
                System.out.println(i+" 5z \n");
            } else if (i % 3 == 0 || i % 5 == 0) {
                System.out.println(i+" 3z5z \n");
            } else {
                System.out.print(i+"\n");
            }
        }

    }
}

// TP 9

class main12 {
    public static void main(String[] args) {
        int foix = 1;
        int max_foix = 3;
        int result = (int)(Math.random() * 6) + 1;

        System.out.println("Tentative N " + foix + " : " + result);

        while (result == 6 && foix < max_foix) {
            foix++;
            result = (int)(Math.random() * 6) + 1;
            System.out.println("Tentative N " + foix + " : " + result);
        }
    }
}
