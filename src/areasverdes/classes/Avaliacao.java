package areasverdes.classes;

public class Avaliacao {
    private int idAreaV;
    private int qtdArvores;
    private int qldAr;
    private int baixoRuido;
    private int limpeza;
    private int acessibilidade;

    public Avaliacao(int idAreaV, int qtdArvores, int qldAr, int baixoRuido,
                     int limpeza, int acessibilidade) {
        this.idAreaV = idAreaV;
        this.qtdArvores = qtdArvores;
        this.qldAr = qldAr;
        this.baixoRuido = baixoRuido;
        this.limpeza = limpeza;
        this.acessibilidade = acessibilidade;
    }

    @Override
    public String toString(){
        return "Nota Quantidade de árvores: " + qtdArvores + "\nNota Qualidade do ar: " + qldAr +
                "\nNota Ausência de poluição sonora: " + baixoRuido + "\nNota Coleta de resíduos: " + limpeza +
                "\nNota Facilidade de chegar utilizando transporte público: " + acessibilidade;
    }

    public double calcularMedia() {
        double media = (this.qtdArvores + this.qldAr +
                this.baixoRuido + this.limpeza + this.acessibilidade)/5;
        return media;
    }

    public int getIdAreaV() {
        return idAreaV;
    }
    public void setIdAreaV(int idAreaV) {
        this.idAreaV = idAreaV;
    }

    //GET E SET QUANTIDADE DE ÁRVORES
    public int getQtdArvores() {
        return qtdArvores;
    }
    public void setQtdArvores(int qtdArvores) {
        if(qtdArvores <= 0 || qtdArvores > 5){
            System.out.println("VALOR INÁLIDO! DIGITE UMA NOTA DE 1 A 5!");
        }else{
            this.qtdArvores = qtdArvores;
        }
    }
    //GET E SET QUALIDADE DO AR
    public int getQldAr() {
        return qldAr;
    }
    public void setQldAr(int qldAr) {
        if(qldAr <= 0 || qldAr > 5){
            System.out.println("VALOR INÁLIDO! DIGITE UMA NOTA DE 1 A 5!");
        }else{
            this.qldAr = qldAr;
        }
    }
    //GET E SET POLUIÇÃO SONORA
    public int getBaixoRuido() {
        return baixoRuido;
    }
    public void setBaixoRuido(int baixoRuido) {
        if(baixoRuido <= 0 || baixoRuido > 5){
            System.out.println("VALOR INÁLIDO! DIGITE UMA NOTA DE 1 A 5!");
        }else{
            this.baixoRuido = baixoRuido;
        }
    }
    //GET E SET COLETA DE RESÍDUOS
    public int getLimpeza() {
        return limpeza;
    }
    public void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
    }

    //GET E SET FACILIDADE DE ACESSO COM TRANSPORTE PÚBLICO
    public int getAcessibilidade() {
        return acessibilidade;
    }
    public void setAcessibilidade(int acessibilidade) {
        if(acessibilidade <= 0 || acessibilidade > 5){
            System.out.println("VALOR INÁLIDO! DIGITE UMA NOTA DE 1 A 5!");
        }else{
            this.acessibilidade = acessibilidade;
        }
    }
}
