
/*FERNANDO WILSON FARIAS SILVA JUNIOR RA.: 21039235*/
/*NATHAN VINÍCIUS CASSIMIRO NEVES     RA.: 21040584*/
/*MARÍLIA MURARO JANIZELLI            RA.: 21041255*/
/*LUIZ EDUARDO LASCALA ROCHA BARBOSA  RA.: 21038447*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner read = new Scanner(System.in);

    int i = 0;//Quantidade de vezes jogada
    int trairXtrair = 0;// trair x trair
    int coopXcoop = 0;// cooperar x cooperar
    int trairXcoop = 0;// trair x cooperar
    int choice;//variavel de escolha de estrategia
    int res;//Variavel de resposta usuario
    int comparsa;//Variavel de resposta da maquina
    boolean game = true;//variavel que controla o loop do game inteiro
    String estrategia = "";//variavel para decidir se troca de estrategia
    boolean err = false;//variavel que controla o repetiçao, caso haja algum err

    System.out.println(" ");
    System.out.println("\t\t\t\t---------------- O DILEMA DO PRISIONEIRO -----------------");
    System.out.println(" ");

    //Inicio do game
    System.out.println("OBS: INSIRA APENAS NÚMEROS.");
    System.out.println(" ");

    while (game) {//loop que controla se o game continua ou fecha

      do {
        System.out.println("ESCOLHA UMA ESTRATÉGIA: \n");

        //Escolha estratégia
        System.out.println("0 = NÃO ITERADO,"
            + "\n 1 = OLHO POR OLHO,"
            + "\n 2 = OLHO POR DOIS OLHOS,"
            + "\n 3 = PROVADOR INGÊNUO,"
            + "\n 4 = RETALIADOR PERMANENTE,"
            + "\n 5 = SAIR E FECHAR O game");

        choice = read.nextInt();//read estrategia do jogador

        if (choice < 0 || choice > 5) {
          err = true;
          System.out.println("\n\nINSIRA UMA OPÇÃO VÁLIDA\n\n");
        } else {
          err = false;
        }

      } while (err);

      switch (choice) {
        case 0:

          boolean caseZero = true;

          System.out.println("Sua estratégia é: OLHO POR OLHO\n");

          while (caseZero) {
            //começar escrever o que fazer
            System.out.println("\n\n\n1 = Trair ou 2 = Cooperar: \n");
            res = read.nextInt();
            comparsa = (int) (1 + Math.random() * 2);

            if (res == 2 || res == 1) {//teste para ver se digitou corretamente

              int retorno = mensagens(res, comparsa, coopXcoop, trairXtrair, trairXcoop);
              switch (retorno) {
                case 1:
                  coopXcoop++;
                  break;
                case 2:
                  trairXtrair++;
                  break;
                default:
                  trairXcoop++;
              }

              System.out.println("------------------------------");

              do {
                System.out.println("\nDeseja continuar com a estratégia? (s/n)");
                estrategia = read.next();
                if (estrategia.equals("S") || estrategia.equals("s")) {
                  err = false;
                  //continua a estrategia
                } else if (estrategia.equals("N") || estrategia.equals("n")) {
                  System.out.println("trocar estrategia");
                  caseZero = false;//trocar estrategia
                  err = false;
                } else {
                  System.out.println("Digitou algo errado. Tente novamente!");
                  err = true;
                }
              } while (err);

              //else do teste para ver se digitou corretamente
            } else {
              System.out.println("Digitou algo errado. Tente novamente!");
              i--;//retira a jogada caso err
            }
            i++;//Conta quantas rodadas
          } //fim do case0
          break;

        case 1:

          boolean case1 = true;

          System.out.println("Sua estratégia é: OLHO POR OLHO\n");//estrategia

          comparsa = (int) (1 + Math.random() * 2);

          while (case1) {
            //começar escrever o que fazer
            System.out.println("\n\n\n1 = Trair ou 0 = Cooperar: \n");
            res = read.nextInt();

            if (res == 2 || res == 1) {//teste para ver se digitou corretamente

              int retorno = mensagens(res, comparsa, coopXcoop, trairXtrair, trairXcoop);
              switch (retorno) {
                case 1:
                  coopXcoop++;
                  break;
                case 2:
                  trairXtrair++;
                  break;
                default:
                  trairXcoop++;
              }

              System.out.println("------------------------------");

              comparsa = res;

              do {
                System.out.println("\nDeseja continuar com a estratégia? (s/n)");
                estrategia = read.next();
                if (estrategia.equals("S") || estrategia.equals("s")) {
                  err = false;
                  //continua a estrategia
                } else if (estrategia.equals("N") || estrategia.equals("n")) {
                  System.out.println("trocar estrategia");
                  case1 = false;//trocar estrategia
                  err = false;
                } else {
                  System.out.println("Digitou algo errado. Tente novamente!");
                  err = true;
                }
              } while (err);

              //else do teste para ver se digitou corretamente
            } else {
              System.out.println("Digitou algo errado. Tente novamente!");
              i--;//retira a jogada caso err
            }
            i++;//Conta quantas rodadas
          } //fim do case1
          break;

        case 2:
          System.out.println("Sua estratégia é: OLHO POR DOIS OLHOS\n");

          boolean caseTwo = true;
          int repetida = 2; //quantidade de vezes que for igual a res
          int turn = 0;

          while (caseTwo) {
            //começar escrever o que fazer
            System.out.println("\n\n\n1 = Trair ou 2 = Cooperar: ");
            res = read.nextInt();//res = read.nextInt();

            if (res == 1 || res == 2) {//teste para ver se digitou corretamente

              //se true, significa que a resposta foi repetida 2 vezes seguidas
              if (turn > 0) {
                comparsa = repetida;
              } else {//se nao repetida, sempre cooperar
                comparsa = 2;
              }

              //teste para testar se a resposta foi repetida
              if (res == repetida) {
                turn++;//se a resposta for igual a jogada anterior, condição será true
              } else {
                turn = 0;//senão vez continua 0 ou é volta para 0
              }

              int retorno = mensagens(res, comparsa, coopXcoop, trairXtrair, trairXcoop);
              switch (retorno) {
                case 1:
                  coopXcoop++;
                  break;
                case 2:
                  trairXtrair++;
                  break;
                default:
                  trairXcoop++;
              }

              System.out.println("------------------------------");

              repetida = res;

              do {
                System.out.println("\nDeseja continuar com a estratégia? (s/n)");
                estrategia = read.next();
                if (estrategia.equals("S") || estrategia.equals("s")) {
                  err = false;
                  //continua a estrategia
                } else if (estrategia.equals("N") || estrategia.equals("n")) {
                  System.out.println("trocar estrategia");
                  caseTwo = false;//trocar estrategia
                  err = false;
                } else {
                  System.out.println("Digitou algo errado. Tente novamente!");
                  err = true;
                }
              } while (err);

              //else do teste para ver se digitou corretamente
            } else {
              System.out.println("Digitou algo errado. Tente novamente!");
              i--;//retira a jogada caso err
            }
            i++;//conta uma jogada
          }      //fim do case 2
          break;


        case 3:
          System.out.println("Sua estratégia é: PROVADOR INGÊNUO\n");//estrategia

          boolean caseThree = true;

          comparsa = (int) (1 + Math.random() * 2);

          while (caseThree) {
            //começar escrever o que fazer
            System.out.println("\n\n\n1 = Trair ou 2 = Cooperar: \n");
            res = read.nextInt();

            /*Ou seja, jogador
            coopera ou trai de acordo com as ações do jogador, mas trai de forma
            aleatória.*/

            if (Math.random() * 100 < 69) {//70% de chance de continuar olho por olho (copiar a escolha)
              comparsa = res;
            } else if (Math.random() * 100 > 70) {//30% de chance de trair na escolha
              comparsa = 1;
            }

            if (res == 2 || res == 1) {//teste para ver se digitou corretamente

              int retorno = mensagens(res, comparsa, coopXcoop, trairXtrair, trairXcoop);
              switch (retorno) {
                case 1:
                  coopXcoop++;
                  break;
                case 2:
                  trairXtrair++;
                  break;
                default:
                  trairXcoop++;
              }

              System.out.println("------------------------------");

              do {
                System.out.println("\n\nDeseja continuar com a estratégia? (s/n)");
                estrategia = read.next();
                if (estrategia.equals("S") || estrategia.equals("s")) {
                  err = false;
                  //continua a estrategia
                } else if (estrategia.equals("N") || estrategia.equals("n")) {
                  System.out.println("trocar estrategia");
                  caseThree = false;//trocar estrategia
                  err = false;
                } else {
                  System.out.println("Digitou algo errado. Tente novamente!");
                  err = true;
                }
              } while (err);


              //else do teste para ver se digitou corretamente
            } else {
              System.out.println("Digitou algo errado. Tente novamente!");
              i--;//retira a jogada caso err
            }
            i++;//Conta quantas rodadas
          } //fim do case3
          break;


        case 4:
          System.out.println("Sua estratégia é: RETALIADOR PERMANENTE");//estrategia

          boolean caseFour = true;

          comparsa = 0;

          while (caseFour) {
            //começar escrever o que fazer
            System.out.println("\n\n\n1 = Trair ou 2 = Cooperar: \n");
            res = read.nextInt();

            if (res == 2 || res == 1) {//teste para ver se digitou corretamente

              int retorno = mensagens(res, comparsa, coopXcoop, trairXtrair, trairXcoop);
              switch (retorno) {
                case 1:
                  coopXcoop++;
                  break;
                case 2:
                  trairXtrair++;
                  break;
                default:
                  trairXcoop++;
              }

              System.out.println("------------------------------");

              if (res == 1) {
                comparsa = 1;
              }

              do {
                System.out.println("\n\nDeseja continuar com a estratégia? (s/n)");
                estrategia = read.next();
                if (estrategia.equals("S") || estrategia.equals("s")) {
                  err = false;
                  //continua a estrategia
                } else if (estrategia.equals("N") || estrategia.equals("n")) {
                  caseFour = false;//trocar estrategia
                  err = false;
                } else {
                  System.out.println("Digitou algo errado. Tente novamente!");
                  err = true;
                }
              } while (err);


              //else do teste para saber se digitou corretamente
            } else {
              System.out.println("Digitou algo errado. Tente novamente!");
              i--;//retira a jogada caso err
            }
            i++;//Conta quantas rodadas
          } //fim do case4
          break;

        case 5:
          System.out.println("\n\n");
          System.out.println("Foram jogadas " + i + " rodadas");
          System.out.println("\n");
          System.out.println(trairXtrair * 100 / i + "% das vezes ocorreu TRAIR X TRAIR");
          System.out.println(coopXcoop * 100 / i + "% das vezes ocorreu COOPERAR X COOPERAR");
          System.out.println(trairXcoop * 100 / i + "% das vezes ocorreu TRAIR X COOPERAR");
          System.exit(0);
          break;//fim do case5


        default:// CASO DIGITE ALGO ERRADO ELE SAI
          System.out.println("Digitou algo errado. Tente novamente!");
          break;
      }

      do {
        System.out.println("\n\nDeseja escolher nova estratégia? \ns = SIM\nn = SAIR E FECHAR");
        estrategia = read.next();
        if (estrategia.equals("S") || estrategia.equals("s")) {
          err = false;
          //continua a estrategia
        } else if (estrategia.equals("N") || estrategia.equals("n")) {
          err = false;
          game = false;
        } else {
          System.out.println("\n\nDigitou algo errado. Tente novamente!");
          err = true;
        }
      } while (err);

    }//while(game)
    System.out.println("\n\n");
    System.out.println("Foram jogadas " + i + " rodadas");
    System.out.println("\n");
    System.out.println(trairXtrair * 100 / i + "% das vezes ocorreu TRAIR X TRAIR");
    System.out.println(coopXcoop * 100 / i + "% das vezes ocorreu COOPERAR X COOPERAR");
    System.out.println(trairXcoop * 100 / i + "% das vezes ocorreu TRAIR X COOPERAR");
  }

  public static int mensagens(int res, int comparsa, int coopXcoop, int trairXtrair, int trairXcoop) {
    if (res == 2 && comparsa == 2) {
      //coopXcoop++;//cooperar x cooperar
      System.out.println("VOCÊ COOPEROU");
      System.out.println("COMPARSA COOPEROU");
      return 1;

    } else if (res == 1 && comparsa == 1) {
      //trairXtrair++;// trair x trair
      System.out.println("VOCÊ TRAIU");
      System.out.println("COMPARSA TRAIU");
      return 2;

    } else if (res == 1 && comparsa == 2) {
      //trairXcoop++;// trair x cooperar
      System.out.println("VOCÊ TRAIU");
      System.out.println("COMPARSA COOPEROU");
      return 3;

    } else {
      //trairXcoop++;
      System.out.println("VOCÊ COOPEROU");
      System.out.println("COMPARSA TRAIU");
      return 3;
    }
  }

}


