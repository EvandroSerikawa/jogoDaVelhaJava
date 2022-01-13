public abstract class jogador {

    protected int[] tentativa = new int[2];
    protected int jogador;

    public jogador ( int jogador){
        this.jogador = jogador;
    }


    public abstract void jogar(tabuleiro tabuleiro);

    public abstract void tentativa( tabuleiro tabuleiro);

    public boolean checarTentativa( int[] tentativa , tabuleiro tabuleiro ){
        if(tabuleiro.getPosicao(tentativa)==0){
            return true;
        }else{
            return false;
        }
    }




}
