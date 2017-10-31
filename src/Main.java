import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
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
    char decision;

    System.out.println("Escolha sua tática:\n"
        + " 0-Não iterado\n"
        + " 1-Olho por olho\n"
        + " 2-Olho por 2 olhos\n"
        + " 3-Provador ingenuo\n"
        + " 4-Retaliador Permanente\n"
        + " 5-Finalizar Jogada\n");

    choice = read.nextInt();

    System.out.println("Sua estratégia é:" + choice);

    if (choice > 5 || choice < 0) {
      System.out.println("Escolha inválida. Escolha novamente:\n"
          + " 0-Não iterado\n"
          + " 1-Olho por olho\n"
          + " 2-Olho por 2 olhos\n"
          + " 3-Provador ingenuo\n"
          + " 4-Retaliador Permanente\n"
          + " 5-Finalizar Jogada\n");

      choice = read.nextInt();
      System.out.println("Sua estratégia é:" + choice);
    }
    while (choice != 5) {
      System.out.println("Escolha sua jogada:\n"
          + "1- Trair\n"
          + "2- Cooperar\n");

      move = read.nextInt();

      if (choice == 1) {
        System.out.println("Jogada Você: " + move);

        System.out.println("Jogada Comparsa: " + move);
        if (move == 1) {
          cooperation++;
        } else {
          betrayal++;
        }


      } else if (choice == 2) {

         if (betrayal < 2) {

          System.out.println("Jogada Você: " + move);

          System.out.println("Jogada Comparsa: " + coop);

          if (move == 1)
            betrayal++;
          else if (move == 2)
            cooperation++;

          System.out.println("cooperar: "+ cooperation + "trair: " + betrayal);

          } else if (betrayal >= 2){

           System.out.println("cooperar: " + cooperation + "trair: " + betrayal);
           betrayal++;

           System.out.println(cooperation + betrayal);
         }

      } else if (choice == 3) {
        //provador ingenuo
      } else if(choice == 4){
        //retaliador permanente
        if (move == 2){
          System.out.println("Jogada Comparsa: " + coop);
          cooperation++;
        }
        System.out.println("Jogada Comparsa: " + betray);
        betrayal++;
      }

      System.out.println("Voc\u00ea deseja mudar de estrat\u00e9gia?\n"
          + "Insira S - Sim, N - N\u00e3o");

      decision = read.next(".").charAt(0);





    }

    System.out.println("Traições: " + betrayal + "\nCooperações: " + cooperation);

  }
}

