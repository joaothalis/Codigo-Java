package Locadora;

public class Filme {
    private String titulo;
    private String diretor;
    private String categoria;
    private int likes;
    private int dislikes;
    
    public Filme(String titulo, String diretor, String categoria){
        this.titulo = titulo;
        this.diretor = diretor;
        this.categoria = categoria;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public double relevancia(){
        return (float) this.likes / (this.likes + this.dislikes) * 100;
    }
    
    @Override
    public String toString() {
        return "Filme: " + this.titulo + " Diretor: " + this.diretor + " Categoria: " + this.categoria;
    }
}