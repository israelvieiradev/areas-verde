package miniprojeto.classes;

import java.util.ArrayList;
import java.util.List;

public class AvaliacoesRepository {
    private static List<Avaliacao> avaliacoes = new ArrayList<>();

    public void salvar(Avaliacao novaAvaliacao){
        novaAvaliacao.setIdAreaV(avaliacoes.size() + 1);
        avaliacoes.add(novaAvaliacao);
    }

    public Avaliacao buscar(int numAvaliacao){
        for(Avaliacao avaliacao : this.avaliacoes){
            if (numAvaliacao == avaliacao.getIdAreaV()){
                return avaliacao;
            }
        }
        return null;
    }

    public List<Avaliacao> listaAvaliacoes(){
        if (this.avaliacoes.isEmpty()){
            System.out.println("LISTA VAZIA!\n");
        }
        return this.avaliacoes;
    }
}
