package areasverde;
import areasverde.classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        AreasVerdeRepository areasVerdeRepository = new AreasVerdeRepository();
        LocalizacoesRepository localizacaoRepository = new LocalizacoesRepository();
        AvaliacoesRepository avaliacaoRepository = new AvaliacoesRepository();

        String opcao = "";
        System.out.println("MAPEADOR DE ÁREAS VERDES EM JOINVILLE\n");
        do {
            System.out.print("_______________MENU_______________\n" +
                    "1- Listar áreas verdes\n" +
                    "2- Avaliar área verde\n" +
                    "3- Ver detalhe de uma área verde\n" +
                    "4- Cadastrar nova área verde\n" +
                    "0- Sair do programa\n" +
                    "_________________________________\n" +
                    "Digite a opção que deseja acessar: ");
            opcao = entrada.nextLine().trim();

            switch (opcao) {
                case "1":
                    //VALIDAÇÃO DE LISTA VAZIA
                    if (areasVerdeRepository.listaAreasVerde().isEmpty()){
                        break;
                    }
                    //LISTA DE AREAS VERDES
                    for(AreaVerde areaV : areasVerdeRepository.listaAreasVerde()){
                        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-ÁREA VERDE " + areaV.getNome() + "-=-=-=-=-=-=-=-=-=-=-");
                        System.out.println(areaV.dadosListagem()); //Método Listagem
                        if(areaV.getAvaliacoes() == null){ //VALIDACAO MEDIA
                            System.out.println("Média das Avaliações:");
                            System.out.println("SEM AVALIAÇÕES DISPONÍVEIS. AVALIE NA OPÇÃO 2 DO MENU.");
                        }else{
                            System.out.println("Média das Avaliações: " + areaV.mediaAvaliacoes());
                        }
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    }
                    break;
                case "2":
                    //VALIDAÇÃO DE LISTA VAZIA
                    if (areasVerdeRepository.listaAreasVerde().isEmpty()){
                        break;
                    }
                    System.out.print("Informe o Identificador (id) da Área Verde que deseja avaliar: ");
                    int idAreaV = Integer.parseInt(entrada.nextLine());
                    // VALIDAÇÃO DE ID NÃO ENCONTRADO
                    if (idAreaV <= 0 || idAreaV > areasVerdeRepository.listaAreasVerde().size()){
                        System.out.println("ID NÃO ENCONTRADO. INFORME UM ID PELA ORDEM DE CADASTRO!\n" +
                        "Ex: Se você cadastrou como primeiro digite o valor 1 e assim sucessivamente.\n");
                        break;
                    }
                    System.out.println("\nAVALIAÇÃO DA ÁREA VERDE " + areasVerdeRepository.buscar(idAreaV).getNome() +
                            "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("Com base em critérios sustentáveis\n" +
                            "dê uma nota de 1 a 5 para os seguintes tópicos:\n");
                    //NOTA QUANTIDADE DE ÁRVORES
                    int notaQtdArvores = 0;
                    while(true){
                        try{//VALIDACAO VALOR VAZIO
                            System.out.print("Quantidade de árvores: ");
                            notaQtdArvores = Integer.parseInt(entrada.nextLine());
                            if(notaQtdArvores > 0 && notaQtdArvores <= 5) {//QUEBRA O LOOP
                                break;
                            }else{//VALIDACAO VALOR FORA DO INTERVALO
                                System.out.println("VALOR INVÁLIDO! USE APENAS NÚMEROS INTEIROS DE 1 A 5!");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("NÚMERO NÃO INFORMADO OU INVÁLIDO.");
                        }
                    }
                    //NOTA QUALIDADE DO AR
                    int notaQldAr = 0;
                    while(true) {
                        try{
                            System.out.print("Qualidade do ar: ");
                            notaQldAr = Integer.parseInt(entrada.nextLine());
                            if  (notaQldAr > 0 && notaQldAr <= 5) {
                                break;
                            }else{
                                System.out.println("VALOR INVÁLIDO! USE APENAS NÚMEROS INTEIROS DE 1 A 5!");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("NÚMERO NÃO INFORMADO OU INVÁLIDO.");
                        }
                    }
                    //NOTA PARA AUSENCIA DE POLUICAO SONORA (NOTA MAIOR PARA POUCA POLUICAO)
                    int notaBaixoRuido = 0;
                    while(true){
                        try{
                            System.out.print("Ausência de poluição sonora: ");
                            notaBaixoRuido = Integer.parseInt(entrada.nextLine());
                            if (notaBaixoRuido > 0 || notaBaixoRuido <= 5) {
                                break;
                            }else{
                                System.out.println("VALOR INVÁLIDO! USE APENAS NÚMEROS INTEIROS DE 1 A 5!");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("NÚMERO NÃO INFORMADO OU INVÁLIDO.");
                        }
                    }
                    //NOTA PARA LIMPEZA DO LOCAL
                    int notaLimpeza = 0;
                    while(true){
                        try {
                            System.out.print("Coleta de Resíduos: ");
                            notaLimpeza = Integer.parseInt(entrada.nextLine());
                            if (notaLimpeza > 0 && notaLimpeza <= 5) {
                                break;
                            }else{
                                System.out.println("VALOR INVÁLIDO! USE APENAS NÚMEROS INTEIROS DE 1 A 5!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("NÚMERO NÃO INFORMADO OU INVÁLIDO. AVALIAÇÃO ENCERRADA!");
                        }
                    }
                    //NOTA DE ACESSIBILIDADE COM TRANSPORTE PÚBLICO
                    int notaAcessibilidade = 0;
                    while(true) {
                        try {
                            System.out.print("Facilidade de chegar com transporte público: ");
                            notaAcessibilidade = Integer.parseInt(entrada.nextLine());
                            if (notaAcessibilidade > 0 && notaAcessibilidade <= 5) {
                                break;
                            }else{
                                System.out.println("VALOR INVÁLIDO! USE APENAS NÚMEROS INTEIROS DE 1 A 5!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("NÚMERO NÃO INFORMADO OU INVÁLIDO. AVALIAÇÃO ENCERRADA!");
                        }
                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

                    Avaliacao novaAvaliacao = new Avaliacao(idAreaV, notaQtdArvores, notaQldAr, notaBaixoRuido, notaLimpeza, notaAcessibilidade);
                    avaliacaoRepository.salvar(novaAvaliacao);
                    areasVerdeRepository.buscar(idAreaV).setAvaliacoes(novaAvaliacao);
                    break;
                case "3":
                    //VALIDAÇÃO DE LISTA VAZIA
                    if (areasVerdeRepository.listaAreasVerde().isEmpty()){
                        break;
                    }
                    System.out.print("Informe o Identificador (id) da Área Verde para mostrar seus dados: ");
                    idAreaV = Integer.parseInt(entrada.nextLine());
                    // VALIDAÇÃO DE ID NÃO INFORMADO
                    if (idAreaV <= 0 || idAreaV > areasVerdeRepository.listaAreasVerde().size()){
                        System.out.println("ID NÃO ENCONTRADO. INFORME UM ID PELA ORDEM DE CADASTRO!\n" +
                                "Ex: Se você cadastrou como primeiro digite o valor 1 e assim sucessivamente.\n");
                        break;
                    }
                    System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=DADOS DA ÁREA VERDE=-=-=-=-=-=-=-=-=-=-=-=-\n");
                    System.out.println(areasVerdeRepository.buscar(idAreaV).dadosDetalhes());//LISTAR DETALHES
                    if(areasVerdeRepository.buscar(idAreaV).getAvaliacoes() == null) {
                        System.out.println("\nSEM AVALIAÇÕES DISPONÍVEIS. AVALIE NA OPÇÃO 2 DO MENU.");
                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                    break;
                case "4":
                    AreaVerde novaAreaVerde = new AreaVerde(); //INSTÂNCIA ÁREA VERDE
                    //CABEÇALHO
                    System.out.println("\nCADASTRO DE ÁREA VERDE\n" +
                            "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" +
                            "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    //OBTÉM O NOME DA ÁREA VERDE
                    String nome = "";
                    do{
                        System.out.print("Informe o Nome: ");
                        nome = entrada.nextLine().trim();
                        if (nome.equals("") || nome.length() < 3) { //VALIDACAO NOME VAZIO
                            System.out.println("NOME INVÁLIDO! TENTE NOVAMENTE!");
                        }
                    }while(nome.equals("") || nome.length() < 3);
                    novaAreaVerde.setNome(nome);
                    //OBTÉM A LATIDUDE DA LOCALIZAÇÃO DA ÁREA VERDE
                    String latitude = "";
                    System.out.println("Informe a Localização");
                    do{
                        System.out.print("Latitude: "); // LATITUDE
                        latitude = entrada.nextLine().trim();
                        if (latitude.equals("")) {
                            System.out.println("LATITUDE VAZIA! TENTE NOVAMENTE!");
                        }
                    }while(latitude.equals(""));
                    //OBTÉM A LONGITUDE DA LOCALIZAÇÃO DA ÁREA VERDE
                    String longitude = "";
                    do{
                        System.out.print("Longitude: "); // LONGITUDE
                        longitude = entrada.nextLine().trim();
                        if (longitude.equals("")) {
                            System.out.println("LONGITUDE VAZIA! TENTE NOVAMENTE!");
                        }
                    }while(longitude.equals(""));
                    //OBTÉM TIPOS DE VEGETAÇÃO
                    String vegetacao = "";
                    do{
                        System.out.print("Informe um tipo de vegetação (árvores, arbustos, grama, etc.): ");
                        vegetacao = entrada.nextLine().trim();
                        if (vegetacao.equals("")) {
                            System.out.println("VEGETAÇÃO VAZIA! TENTE NOVAMENTE!");
                        }
                    }while(vegetacao.equals(""));
                    novaAreaVerde.setVegetacao(vegetacao);
                    String resp = "";
                    while(resp.equals("s") || resp.equals("")){
                        System.out.print("Quer informar mais um tipo de vegetação (s/n)? ");
                        resp = entrada.nextLine().trim();
                        if (!resp.equals("s")){
                            break;
                        }
                        do {
                            System.out.print("Informe outro tipo de vegetação (árvores, arbustos, grama, etc.)? ");
                            vegetacao = entrada.nextLine().trim();
                            if (vegetacao.equals("")){
                                System.out.println("VEGETAÇÃO VAZIA! TENTE NOVAMENTE!");
                            }
                        }while(vegetacao.equals(""));
                        novaAreaVerde.setVegetacao(vegetacao);
                    }
                    //OBTÉM O HORÁRIO DE FUNCIONAMENTO DA ÁREA VERDE
                    String periodoDeVisita = "";
                    do{
                        System.out.print("Informe o horário de funcionamento (ex: 7h às 18h): ");
                        periodoDeVisita = entrada.nextLine().trim();
                        if (periodoDeVisita.equals("")) {
                            System.out.println("PERÍODO VAZIO! TENTE NOVAMENTE!");
                        }
                    }while(periodoDeVisita.equals(""));
                    novaAreaVerde.setPeriodoDeVisita(periodoDeVisita);
                    //OBTÉM AS ATIVIDADES DISPONÍVEIS NA ÁREA VERDE
                    String atividade = "";
                    do {
                        System.out.print("Informe um tipo de atividade disponível no local " +
                                "(caminhada, ciclismo, pedalinho, etc.): ");
                        atividade = entrada.nextLine().trim();
                        if (atividade.equals("")) {
                            System.out.println("ATIVIDADE VAZIA! TENTE NOVAMENTE!");
                        }
                    }while(atividade.equals(""));
                    novaAreaVerde.setAtividades(atividade);
                    resp = "";
                    while(resp.equals("s") || resp.equals("")){
                        System.out.print("Quer informar mais um tipo de atividade (s/n)? ");
                        resp = entrada.nextLine().trim();
                        if (!resp.equals("s")){
                            break;
                        }
                        do {
                            System.out.print("Informe outro tipo de atividade (caminhada, ciclismo, pedalinho, etc.)? ");
                            atividade = entrada.nextLine().trim();
                            if (atividade.equals("")) {
                                System.out.println("ATIVIDADE VAZIA! TENTE NOVAMENTE!");
                            }
                        }while(atividade.equals(""));
                        novaAreaVerde.setAtividades(atividade);
                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-CADASTRO FINALIZADO!" +
                            "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

                    Localizacao novaLocalizacao = new Localizacao(novaAreaVerde.getId(), latitude, longitude);
                    localizacaoRepository.salvar(novaLocalizacao); //SALVA A LOCALIZACAO NO REPOSITORY DE LOCALIZACAO
                    novaAreaVerde.setLocalizacao(novaLocalizacao); //ATRIBUI OS VALORES DA LOCALIZACAO NA AREA VERDE

                    areasVerdeRepository.salvar(novaAreaVerde);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA, USE APENAS AS OPÇÕES DO MENU!\n");
            }
        }while(!opcao.equals("0"));
    }
}
