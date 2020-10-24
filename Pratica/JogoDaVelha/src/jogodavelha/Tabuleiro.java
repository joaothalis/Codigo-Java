package jogodavelha;

import java.io.Serializable;

public class Tabuleiro implements Serializable{

    private int[][] matriz = new int [3][3];
    private int J1;
    private int J2;

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }
        J1 = 0;
        J2 = 0;
    }

    public int getJ1() {
        return J1;
    }

    public void setJ1(int J1) {
        this.J1 = J1;
    }

    public int getJ2() {
        return J2;
    }

    public void setJ2(int J2) {
        this.J2 = J2;
    }

    public int getMatriz(int x, int y) {
        return matriz[x][y];
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void setTabuleiro(int x, int y, int vezJogador) {
        this.matriz[x][y] = vezJogador;
    }

    public void pontuou(int ponto) {
        if (ponto == 3) {
            J1++;
        } else if (ponto == -3) {
            J2++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }
        System.out.println("Pontuação:\n"
                + "Jogador 1: "+J1+"\n"
                + "Jogador 2: "+J2);
    }
    
    public void zerou(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }
        J1 = 0;
        J2 = 0;
    }

    public int ganhou() {
        int linha, coluna, d1, d2;
        boolean temZero = false;
        for (int i = 0; i < 3; i++) {
            linha = 0;
            coluna = 0;
            for (int j = 0; j < 3; j++) {
                linha = linha + matriz[i][j];
                coluna = coluna + matriz[j][i];
                if (matriz[i][j] == 0) {
                    temZero = true;
                }
            }
            if (linha == 3 || coluna == 3) {
                return 3;
            } else if (linha == -3 || coluna == -3) {
                return -3;
            }
        }
        d1 = matriz[0][0] + matriz[1][1] + matriz[2][2];
        d2 = matriz[0][2] + matriz[1][1] + matriz[2][0];
        if (d1 == -3 || d2 == -3) {
            return -3;
        } else if (d1 == 3 || d2 == 3) {
            return 3;
        }
        if (!temZero) {
            return 4;
        }
        return 0;
    }
    
    /*@Override
    public String toString() {
        return "Tabuleiro{" + "Jogador 1 = " + J1 + ", Jogador 2 = " + J2 + '}';
    }*/

    @Override
    public String toString() {
        return "Tabuleiro{" + "matriz=" + matriz + ", J1=" + J1 + ", J2=" + J2 + '}';
    }
    
    
}
