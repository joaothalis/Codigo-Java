package aulanic;

public class Televisao {
    private String marca;
    private String modelo;
    private int tamanho;
    private boolean ligado;
    private int canal;
    private int volume;
    public static final int VOLUME_MAX=100;
    public static final int CANAL_MAX=100;
    private boolean mute;
    /**
     * Classe utilizada para a seleção de marca, modelo e tamanho da tv e assim 
     * criação de seu controle
     * @param marca
     * @param modelo
     * @param tamanho 
     */
    public Televisao(int tamanho){
        //marca
        this.marca = "LG";
        //modelo
        this.modelo = "LGE" + tamanho;
        //tamanho
        if(tamanho<27 || tamanho>75){
            this.tamanho=27;
        } else{
            this.tamanho=tamanho;
        }
        this.ligado=false;
        this.canal=2;
        this.volume=0;
        this.mute=false;
    }
    /**
     * é equivalente ao botão de liga e desliga da televisão
     */
    public void ligar(){
        this.ligado=!this.ligado;
    }
    /**
     * mostra o status atual da televisão(LIGADA ou DESLIGADA)
     * @return 
     */
    public boolean isLigado(){
        return this.ligado;
    }
    /**
     * mostra o volume atual da televisão
     * @return 
     */
    public int getVolume(){
        return this.volume;
    }
    /**
     * mostra o canal atual
     * @return 
     */
    public int getCanal(){
        return this.canal;
    }
    /**
     * usado para receber o valor do canal em numeros inteiros
     * @param canal
     * @return 
     */
    public int setCanal(int canal){
        if(this.ligado){
            return canal;
        }
        else{
            return this.canal;
        }
    }
    /**
     * equivalente ao botão de aumentar o volume no controle
     */
    public void volumeMais(){
        if(this.ligado){
            if(this.volume<VOLUME_MAX){
                this.volume=this.volume+1;
            }
            this.mute=false;
        }
    }
    /**
     * equivalente ao botão de baixar o volume no controle
     */
    public void volumeMenos(){
        if(this.ligado){
            if(this.volume>0){
                this.volume=this.volume-1;
            }
            else{
                this.mute=true;
            }
        }
    }
    /**
     * equivalente ao botão de passar o canal de maneira crescente
     */
    public void canalMais(){
        if(this.ligado){
            if(this.canal<CANAL_MAX){
                this.canal=this.canal+1;
            }
        }
    }
    /**
     * equivalente ao botão de passar o canal de maneira decrescente
     */
    public void canalMenos(){
        if(this.ligado){
            if(this.canal>2){
                this.canal=this.canal-1;
            }
        }
    }
    @Override
    public String toString(){
       return this.marca +": "+this.modelo+" "+this.tamanho+"' \nVol: "+this.volume+", canal: "+this.canal+", "+(this.ligado?"ligado.":"desligado.");
               //"{"+this.marca+" : "+this.modelo+" ("+this.tamanho+"\"), vol: "+this.volume+
               //", canal: "+this.canal+", "+(this.ligado?"ligado":"desligado")+ "}";
    }
}
