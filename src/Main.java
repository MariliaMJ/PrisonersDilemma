
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner read = new Scanner(System.in);

    int choice;
    int move;
    int betrayal = 0;
    int cooperation = 0;
    int coop = 2;
    int betray = 1;
    int decision = 1;
    int yes = 1;
    int no = 2;

    while (decision == yes) {
      System.out.println("Escolha sua tática:\n"
          + " 0-Não iterado\n"
          + " 1-Olho por olho\n"
          + " 2-Olho por 2 olhos\n"
          + " 3-Provador ingenuo\n"
          + " 4-Retaliador Permanente\n"
          + " 5-Finalizar Jogada\n");

      choice = read.nextInt();
      System.out.println("Sua estrat\u00e9gia \u00e9:" + choice);

      decision = no;

      while (decision == no) {
          choice = read.nextInt();

          System.out.println("Sua estrat\u00e9gia \u00e9:" + choice);
        }
        while (choice != 5) {
          System.out.println("Escolha sua jogada:\n"
              + "1- Trair\n"
              + "2- Cooperar\n");

          move = read.nextInt();

          switch (choice) {
            case (1):
              System.out.println("Jogada Voc\u00ea: " + move);
              System.out.println("Jogada Comparsa: " + move);
              switch (move) {
                case (2):
                  cooperation++;
                  break;
                case (1):
                  betrayal++;
                  break;
              }
              break;
            case (2):
              if (betrayal < 2) {
                System.out.println("Jogada Voc\u00ea: " + move);
                System.out.println("Jogada Comparsa: " + coop);
              } else if (betrayal >= 2) {
                System.out.println("Jogada Voc\u00ea: " + move);
                System.out.println("Jogada Comparsa: " + betray);
                betrayal++;
              }
              switch (move) {
                case (1):
                  betrayal++;
                  break;
                case (2):
                  cooperation++;
                  break;
              }
              break;
            case (3):
              //provador ingênuo
              System.out.println("Jogada Voc\u00ea: " + move);
              int comparsa;
              comparsa = (int) (1 + Math.random() * 2);
              System.out.println("Jogada Voc\u00ea: " + comparsa);
              break;
            case (4):
              //permanent retaliation
              switch (move) {
                case (2):
                  System.out.println("Jogada Voc\u00ea: " + move);
                  System.out.println("Jogada Comparsa: " + coop);
                  cooperation++;
                  break;
                case (1):
                  System.out.println("Jogada Comparsa: " + betray);
                  betrayal++;
                  break;
              }
            case(5):
              System.out.println("Total de coop:" + cooperation + "total de traições:" + betrayal);
              break;
            default:
              System.out.println("Insira uma estrat\u00e9gia v\u00e1lida!");
          }
          System.out.println("Voc\u00ea deseja mudar de estrat\u00e9gia?\n"
              + " 1-Sim ou 2-N\u00e3o? ");
          decision = read.nextInt();
        }
      }
    }
    /*break;*/
  }



