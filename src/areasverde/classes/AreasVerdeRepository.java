package areasverde.classes;
import java.util.ArrayList;
import java.util.List;

public class AreasVerdeRepository {
    private static List<AreaVerde> areasVerde = new ArrayList<>();

    public void salvar(AreaVerde novaAreaVerde){
        novaAreaVerde.setId(this.areasVerde.size() + 1); //ATRIBUI UM ID A NOVA INSTÂNCIA QUE VAI SER ARMAZENADA
        this.areasVerde.add(novaAreaVerde);
    }

    public AreaVerde buscar(int numAreaVerde){
        for(AreaVerde areaVerde : this.areasVerde){
            if (numAreaVerde == areaVerde.getId()){ //CONFIRMA SE EXISTE UMA ÁREA VERDE COM MESMO ID DO INFORMADO
                return areaVerde;
            }
        }
        return null;
    }

    public List<AreaVerde> listaAreasVerde(){
        if (this.areasVerde.isEmpty()){
            System.out.println("LISTA VAZIA. CADASTRE UMA ÁREA VERDE!\n");
        }
        return this.areasVerde;
    }
}
