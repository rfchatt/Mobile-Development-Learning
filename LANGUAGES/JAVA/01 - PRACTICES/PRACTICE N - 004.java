// TP 4
// Exercise 1

class remplissage {
    public static void main(String[] args) {
        Scanner Objet4 = new Scanner(System.in);

        int[][] table = new int[2][3];

        System.out.println("[horizontal] Entrez un nombre : ");
        int horizontal1 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical1 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical2 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical3 = Objet4.nextInt();

        System.out.println("[horizontal] Entrez un nombre : ");
        int horizontal2 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical1_2 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical2_2 = Objet4.nextInt();
        System.out.println("[vertical] Entrez un nombre : ");
        int vertical3_2 = Objet4.nextInt();


        System.out.println("------------");
        System.out.println("| p1  |  p2 |");
        System.out.println("| " + horizontal1 + " | " + horizontal2 + " | ");
        System.out.println("| " + vertical1 + " | " + vertical1_2 + " | " + "\n" + "| " + vertical2 + " | " + vertical2_2 + " | " +"\n" + "| " + vertical3 + " | " + vertical3_2 + " | ");
        System.out.println("------------");
    }
}
