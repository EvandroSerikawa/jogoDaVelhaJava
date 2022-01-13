import java.util.Scanner;

public class jogo {

    private tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private jogador jogador1;
    private jogador jogador2;
    public Scanner entrada = new Scanner(System.in);

    public jogo(){
        tabuleiro = new tabuleiro();
        iniciarJogadores();

        while( jogar( ));
    }

    public void iniciarJogadores(){
        System.out.println("Quem será o jogador 1 ?");

        if( escolherJogador() ==1){
            this.jogador1 = new humano(1);
        }else{
            this.jogador1 = new computador(1);
        }
        System.out.println("----------------------");
        System.out.println("Quem será o jogador 2 ?");

        if ( escolherJogador() ==1){
            this.jogador2 = new humano(2);
        }else{
            this.jogador2 = new humano(2);
        }
    }

    public int escolherJogador(){
        int opcao=0;

        do {
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.println("Opção: ");
            opcao = entrada.nextInt();

            if(opcao !=1 && opcao !=2){
                System.out.println("Opção invalida!\n tente novamente");
            }
        }while(opcao !=1 && opcao !=2 );
        return opcao;
    }

    public boolean jogar(){
        if(ganhou() ==0 ){
            System.out.println("---------------------------");
            System.out.println("\n rodada"+ rodada);
            System.out.println("É a vez do jogador" + vez());

            if( vez() ==1 ){
                jogador1.jogar(tabuleiro);
            }else{
                jogador2.jogar(tabuleiro);
            }

            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro completo!\nJogo empatado.");
                return false;
            }

            vez++;
            rodada++;

            return true;
        }else{
            if( ganhou() == -1 ){
                System.out.println("Jogador 1 ganhou !!");
            }else{
                System.out.println("Jogador 2 ganhou !!");
            }
        }
        return false;
    }

    public int vez(){
        if( vez %2 == 1){
            return 1;
        }else{
            return 2;
        }
    }

    public int ganhou(){
        if(tabuleiro.checarLinhas() ==1 ){
            return 1;
        }
        if(tabuleiro.checarColunas() ==1){
            return 1;
        }
        if(tabuleiro.checarDiagonais() ==1){
            return 1;
        }

        if(tabuleiro.checarLinhas() == -1){
            return -1;
        }
        if(tabuleiro.checarColunas() == -1) {
            return -1;
        }
        if(tabuleiro.checarDiagonais() == -1){
            return -1;
        }
        return 0;
    }




}
