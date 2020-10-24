package Locadora;

public class CadastroFilmes {
    private Filme [] filmesCadastrados;
    private int qtd;
    
    public CadastroFilmes (int tam){
        this.filmesCadastrados = new Filme[tam];
    }
    
    private int buscaMelhoradaRelevancia(Filme f[], double relevancia){
        for(int i = 0; i < this.qtd; i++){
            if(relevancia >= f[i].relevancia()){
                return i;
            }
        }
        return -1;
    }
    
    public void inserirOrdenado(Filme f){
        if(this.qtd == this.filmesCadastrados.length){
            System.out.println("Vetor cheio! Não é possível cadastrar novos filmes.");
        }else{
            int aux = buscaMelhoradaRelevancia(this.filmesCadastrados, f.relevancia());
            if(aux == -1){
                this.filmesCadastrados[qtd] = f;
                this.qtd++;
            }else{
                if(this.filmesCadastrados[aux].relevancia() == f.relevancia()){
                    if(f.getDislikes() < this.filmesCadastrados[aux].getDislikes()){
                        for(int i = this.qtd; i > aux; i--){
                            this.filmesCadastrados[i] = this.filmesCadastrados[i-1];
                        }
                        this.filmesCadastrados[aux] = f;
                        this.qtd++;
                    }else{
                        for(int i = this.qtd; i > aux+1; i--){
                            this.filmesCadastrados[i] = this.filmesCadastrados[i-1];
                        }
                        this.filmesCadastrados[aux+1] = f;
                        this.qtd++;
                    }
                }else{
                    for(int i = this.qtd; i > aux; i--){
                        this.filmesCadastrados[i] = this.filmesCadastrados[i-1];
                    }
                    this.filmesCadastrados[aux] = f;
                    this.qtd++;
                }
            }
        }
    }
    
    public Filme consultar (String titulo){
        for(int i = 0; i < this.qtd; i++){
            if(titulo.equals(this.filmesCadastrados[i].getTitulo())){
                return this.filmesCadastrados[i];
            }
        }
        return null;
    }
    
    public void remover (String titulo){
        int aux = buscar(titulo);
        if(aux != -1){
            for(int i = aux; i < this.qtd-1; i++){
                this.filmesCadastrados[i] = this.filmesCadastrados[i+1];
            }
            this.filmesCadastrados[this.qtd-1] = null;
            this.qtd--;
        }
    }
    
    public int buscar (String titulo){
        for(int i = 0; i < this.qtd; i++){
            if(titulo.equals(this.filmesCadastrados[i].getTitulo())){
                return i;
            }
        }
        return -1;
    }
    
    public void listarCategoria (String categoria){
        for(int i = 0; i < this.qtd; i++){
            if(categoria.equals(this.filmesCadastrados[i].getCategoria())){
                System.out.println(this.filmesCadastrados[i]);
            }
        }
    }
    
    public void listarFilmes (){
        for(int i = 0; i < this.qtd; i++){
            System.out.println(this.filmesCadastrados[i]);
        }
    }
}