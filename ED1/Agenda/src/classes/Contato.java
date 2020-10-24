package classes;

public class Contato {
    private final String nome;
    private String [] email;
    private String [] telefone;
    
    public Contato (String nome){
        this.nome = nome;
        this.email = new String [100];
        this.telefone = new String [100];
    }
    
    public String getNome() {
        return nome;
    }
    
    public String[] getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        
        for(int i=0; i<this.email.length; i++){
            if(this.email[i]==null){
                this.email[i] = email;
                break;
            }
        }
    }
    
    public String[] getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        for(int i=0; i<this.telefone.length; i++){
            if(this.telefone[i]==null){
                this.telefone[i] = telefone;
                break;
            }
        }
    }
    
    public int compareTo(Contato value){
        return this.nome.compareToIgnoreCase(nome);
    }
    
    public void exibirEmail(){
        for(int i = 0; i < this.email.length; i++){
            if(this.email[i]!= null){
                System.out.println(email[i]);
            }
        }
    }
    
    public void exibirTelefone(){
        for(int i = 0; i < this.telefone.length; i++){
            if(this.telefone[i]!=null){
                System.out.println(telefone[i]);
            }
        }
    }
}
