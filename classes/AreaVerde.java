package miniprojeto.classes;
import java.util.ArrayList;
import java.util.List;

public class AreaVerde {
    private int id;
    private String nome;
    private Localizacao localizacao;
    private List vegetacao = new ArrayList();
    private String periodoDeVisita;
    private List atividades = new ArrayList();
    private Avaliacao avaliacoes;

    @Override
    public String toString(){
        return "Id:" + id + " Nome:" + nome + " Localização:" + localizacao + " Vegetação:" + vegetacao +
                " Período de Visita:" + periodoDeVisita + " Atividades:" + atividades + " Avaliações:" + avaliacoes;
    }
    public String dadosListagem(){ //RESUMO
        return "Id: " + id + "\nNome: " + nome + "\nVegetação: " + vegetacao + " \nHorário de Funcionamento: " + periodoDeVisita;
    }
    public String dadosDetalhes(){ //TODOS OS DADOS
        if (avaliacoes == null){
            return "Id: " + id + "\nNome: " + nome + "\nLocalização: " + localizacao + "\nVegetação: " + vegetacao +
                    "\nPeríodo de Visita: " + periodoDeVisita + "\nAtividades: " + atividades;
        }
        return "Id: " + id + "\nNome: " + nome + "\nLocalização: " + localizacao + "\nVegetação: " + vegetacao +
                "\nPeríodo de Visita: " + periodoDeVisita + "\nAtividades: " + atividades + "\nAvaliações:\n" + avaliacoes;
    }
    public double mediaAvaliacoes(){
        return avaliacoes.calcularMedia();
    }

    //GETTER E SETTER ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //GETTER E SETTER NOME
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.equals("") || nome.length() < 4){
            System.out.println("ERRO! CADASTRO ENCERRADO. INSIRA UM NOME VÁLIDO!");
        }else{
            this.nome = nome;
        }
    }
    //GETTER E SETTER LOCALIZAÇÃO
    public Localizacao getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    //GETTER E SETTER VEGETAÇÃO
    public List getVegetacao() {
        return vegetacao;
    }
    public void setVegetacao(String vegetacao) {
        this.vegetacao.add(vegetacao);
    }
    //GETTER E SETTER HORARIO DE FUNCIONAMENTO
    public String getPeriodoDeVisita() {
        return periodoDeVisita;
    }
    public void setPeriodoDeVisita(String periodoDeVisita) {
        this.periodoDeVisita = periodoDeVisita;
    }
    //GETTER E SETTER ATIVIDADES DISPONIVEIS NO LOCAL
    public List getAtividades() {
        return atividades;
    }
    public void setAtividades(String atividade) {
        this.atividades.add(atividade);
    }
    //GET E SET AVALIACOES
    public Avaliacao getAvaliacoes() {
        return avaliacoes;
    }
    public void setAvaliacoes(Avaliacao novaAvaliacao) {
        this.avaliacoes = novaAvaliacao;
    }
}
