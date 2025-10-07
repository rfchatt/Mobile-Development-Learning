// TP 6
class main {

        public static double somme (double a, double b) {
            return a + b;
        }

        public static double difference(double a, double b) {
            return a - b;
        }

        public static double multiplication(double a, double b) {
            return a * b;
        }

        public static double division(double a, double b) {
            return a / b;
        }

        public static double reste(double a, double b) {
            return a % b;
        }

        public static double puissance(double a, double b) {
            return Math.pow(a, b);
        }

        public static void main(String[] args) {
            System.out.println("L'Addition : " + somme(8,3));
            System.out.println("Le Soustraction : " + difference(15, 7));
            System.out.println("La Multiplication : " + multiplication(4, 6));
            System.out.println("Le Division : " + division(20, 5));
            System.out.print("Le Modulo : " + reste(17, 5));
            System.out.println("La Puissance : " + puissance(2, 8));
        }

}
