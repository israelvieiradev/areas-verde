package miniprojeto.classes;

import java.util.ArrayList;
import java.util.List;

public class LocalizacoesRepository {
    private static List<Localizacao> Localizacoes = new ArrayList<>();

    public void salvar(Localizacao novaLocalizacao){
        novaLocalizacao.setIdAreaV(Localizacoes.size() + 1);
        Localizacoes.add(novaLocalizacao);
    }

    public Localizacao buscar(int numLocalizacao){
        for(Localizacao localizacao : this.Localizacoes){
            if (numLocalizacao == localizacao.getIdAreaV()){
                return localizacao;
            }
        }
        return null;
    }

    public List<Localizacao> listaLocalizacoes(){
        if (this.Localizacoes.isEmpty()){
            System.out.println("LISTA VAZIA!\n");
        }
        return this.Localizacoes;
    }
}