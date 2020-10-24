//questão 4)
package br.unicap.listaSoma.Q4;

public class LSE {
    private Node first;
    private Node last;
    private int qtd;
    
    public boolean isEmpty(){
        return this.qtd==0;
    }
    
    public void inserirFinal(int value){
        Node novo = new Node(value);
        if(this.isEmpty()==true){
            this.first=novo;
            this.last=novo;
            this.qtd++;
        }else{
            last.setNext(novo);
            this.last = novo;
            this.qtd++;
        }
    }
    
    public void copiar(LSE l){
        Node aux = this.first;
        while(aux != null){
            l.inserirFinal(aux.getInfo());
            aux = aux.getNext();
        }
    }
    
    public LSE somar(LSE l){
        LSE lAux = new LSE();
        if(this.isEmpty()==true&&l.isEmpty()==true){
            return lAux;
        }else if(this.isEmpty()==true){
            l.copiar(lAux);
            return lAux;
        }else if(l.isEmpty()==true){
            this.copiar(lAux);
            return lAux;
        }else{
            Node aux1 = this.first;
            Node aux2 = l.first;
            Node aux3;
            while(aux1 != null && aux2 != null){
                lAux.inserirFinal(aux1.getInfo()+aux2.getInfo());
                aux1=aux1.getNext();
                aux2=aux2.getNext();
            }
            if(aux1 == null){
                aux3=aux2;
            }else{
                aux3=aux1;
            }while(aux3!=null){
                lAux.inserirFinal(aux3.getInfo());
                aux3=aux3.getNext();
            }
            return lAux;
        }
    }
    
    public LSE intercalar (LSE l){
        LSE lAux = new LSE();
        if(this.isEmpty()==true&&l.isEmpty()==true){
            return lAux;
        }else if(this.isEmpty()==true){
            l.copiar(lAux);
            return lAux;
        }else if(l.isEmpty()==true){
            this.copiar(lAux);
            return lAux;
        }else{
            Node aux1 = this.first;
            Node aux2 = l.first;
            Node aux3;
            while(aux1 != null & aux2 != null){
                if(aux1.getInfo()==aux2.getInfo()){
                    lAux.inserirFinal(aux1.getInfo());
                    aux1=aux1.getNext();
                    aux2=aux2.getNext();
                }else if(aux1.getInfo()<aux2.getInfo()){
                    lAux.inserirFinal(aux1.getInfo());
                    aux1.getNext();
                }else{
                    lAux.inserirFinal(aux2.getInfo());
                    aux2.getNext();
                }
            }if(aux1 == null){
                aux3=aux2;
            }else{
                aux3=aux1;
            }while(aux3 != null){
                lAux.inserirFinal(aux3.getInfo());
                aux3 = aux3.getNext();
            }
            return lAux;
        }
    }
}