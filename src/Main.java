import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int choice;
        int move;
        int betrayal = 0;
        int cooperation = 0;
        int comparison = 0;
        int coop = 2;
        int betray = 1;

        System.out.println("Escolha sua tática:\n"
                + " 0-Não iterado\n"
                + " 1-Olho por olho\n"
                + " 2-Olho por 2 olhos\n"
                + " 3-Provador ingenuo\n"
                + " 4-Retaliador Permanente\n"
                + " 5-Finalizar Jogada\n");

        choice = read.nextInt();

        if (choice >5 || choice < 0 ) {
            System.out.println("Escolha inválida. Escolha novamente:\n"
                    + " 0-Não iterado\n"
                    + " 1-Olho por olho\n"
                    + " 2-Olho por 2 olhos\n"
                    + " 3-Provador ingenuo\n"
                    + " 4-Retaliador Permanente\n"
                    + " 5-Finalizar Jogada\n");
            choice = read.nextInt();
        }

        if (choice == 1) {
            System.out.println("Escolha sua jogada:\n"
                    + "1- Trair\n"
                    + "2- Cooperar\n");

            move = read.nextInt();

            System.out.println("Jogada Você: " + move);

            System.out.println("Jogada Comparsa: " + move);
            if(move == 1) {
                cooperation++;
            } else {
                betrayal++;
            }



        } else
        if (choice == 2){
            for (int i = 0; i < 10; i++) {
                comparison = betrayal;

                System.out.println("Escolha sua jogada:\n"
                        + "1- Cooperar\n"
                        + "2- Trair\n");

                move = read.nextInt();

                System.out.println("Jogada Você: " + move);

                if(move == 1) {
                    cooperation++;
                    comparison = betrayal;
                } else {
                    betrayal++;
                    comparison = betrayal;
                }

                if (comparison == betrayal) {
                    System.out.println("Jogada Comparsa: " + coop);

                } else if (betrayal == comparison + 1) {
                    System.out.println("Jogada Comparsa: " + betray);

                }

            }

        } else
        if (choice == 3) {
            System.out.println("coisas");
        }

    }

}

