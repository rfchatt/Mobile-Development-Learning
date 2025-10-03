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

