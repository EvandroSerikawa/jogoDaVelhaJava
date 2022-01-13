import java.util.Scanner;

public class humano extends jogador {

    public Scanner entrada = new Scanner(System.in);

    public humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Novo jogador criado.");
    }


    @Override
    public void jogar(tabuleiro tabuleiro) {
        tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);

    }

    @Override
    public void tentativa(tabuleiro tabuleiro) {
        do{
            do{
                System.out.println("Linha: ");
                tentativa[0] = entrada.nextInt();

                if(tentativa[0] >3 || tentativa[0]<1){
                    System.out.println("linha inválida!\nTente novamente( 1, 2, 3).");
                }
            }while( tentativa[0] >3 || tentativa[0]<1);


            do{
                System.out.println("Coluna: ");
                tentativa[1] = entrada.nextInt();

                if(tentativa[1] >3 || tentativa[1]<1){
                    System.out.println("Coluna inválida!\nTente novamente( 1, 2, 3).");
                }
            }while( tentativa[1] >3 || tentativa[1]<1);

            tentativa[0]--;
            tentativa[1]--;

            if(!checarTentativa(tentativa,tabuleiro)){
                System.out.println("Esse local já foi marcado!\nTente novamente.");
            }
        }while(!checarTentativa(tentativa, tabuleiro));
    }


}
