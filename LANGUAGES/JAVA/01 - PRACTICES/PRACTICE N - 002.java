import java.util.Scanner;


// Exercise 1

class Main {
    public static void main(String[] args) {
        String salutation = "Bonjour";
        Scanner Objet = new Scanner(salutation);

        System.out.println(salutation);
    }
}


// Exercise 2

class Main2 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter the 1st Number :");
        int number1 = myObj.nextInt();

        System.out.print("Enter the 2nd Number :");
        int number2 = myObj.nextInt();

        int result = number1 * number2;

        System.out.println("The result is : " + result);
    }
}

// Exercise 3

class Main3 {
    public static void main(String[] args) {
        Scanner Objet = new Scanner(System.in);

        System.out.print("Enter the 1st Number :");
        int number1 = Objet.nextInt();

        System.out.print("Enter the 2nd Number :");
        int number2 = Objet.nextInt();

        int number1_changed = number2;
        int number2_changed = number1;

        System.out.println("The 1st number after change is : " + number1_changed);
        System.out.println("The 2nd number after change is : " + number2_changed);
    }
}



// TP 2 ======================
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
