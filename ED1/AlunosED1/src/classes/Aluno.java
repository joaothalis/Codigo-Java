package classes;

public class Aluno implements Comparable <Aluno> {
    private final String matricula;
    private String nome;
    private double media;
    private int faltas;

    public Aluno (String m){
        this.matricula = m;
    }
    
    public String getMatricula(){
        return this.matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    
    @Override
    public String toString (){
        return "Matrícula: "+this.matricula+" Nome: "+this.nome+" Média: "+this.media+" Faltas: "+this.faltas+" ->";
    }
    
    @Override
    public int compareTo (Aluno value){
        return this.matricula.compareTo(value.matricula);
    }
}