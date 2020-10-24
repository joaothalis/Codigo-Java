package jogodavelha;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class JogoDaVelha extends Application {

    Stage janela;
    Scene inicial, jogo;
    public String simbolo = "X";
    public int vezJogador = 1;
    Button[][] bts;
    Tabuleiro t = new Tabuleiro();
    File arquivo = new File("C:\\Users\\joaot\\OneDrive\\Documentos\\NetBeansProjects\\JogoDaVelha\\jogosalvo");
    FileChooser fc = new FileChooser();
    Label jogador = new Label("É a vez do jogador 1!");
    Label placar = new Label("Pontuação:\n"
            + "Jogador 1: " + t.getJ1() + "\n"
            + "Jogador 2: " + t.getJ2());

    @Override
    public void start(Stage primaryStage) throws Exception {
        janela = primaryStage;
        fc.getExtensionFilters().add(new ExtensionFilter("Arquivo de Jogo", "*.jv"));
        fc.setInitialFileName("*.jv");
        fc.setInitialDirectory(arquivo);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button newGame = new Button("Novo Jogo");
        Button loadGame = new Button("Continuar");
        Button exit = new Button("Sair");

        VBox vbButton = new VBox(10);
        vbButton.setAlignment(Pos.CENTER_LEFT);
        vbButton.getChildren().addAll(newGame, loadGame, exit);
        grid.add(vbButton, 0, 0);

        newGame.setOnAction(e -> {
            novoJogo();
            t = new Tabuleiro();
            atualizarPlacar();
            janela.setScene(jogo);
        });
        loadGame.setOnAction(e -> {
            arquivo = fc.showOpenDialog(janela);
            System.out.println("\nLendo arquivo...");
            try {
                FileInputStream fin = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Tabuleiro novojogo = (Tabuleiro) ois.readObject();
                this.t = novojogo;
                atualizarPlacar();
                atualizarBtns();
                System.out.println(t);
            } catch (EOFException eofe) {
                System.out.println("\nFim de arquivo.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
            }
            janela.setScene(jogo);
        });
        exit.setOnAction(e -> {
            janela.close();
        });

        bts = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bts[i][j] = new Button("");
                bts[i][j].setFont(new Font("Calibri", 25));
                bts[i][j].setMaxSize(100, 100);
                bts[i][j].setMinSize(100, 100);
            }
        }
        bts[0][0].setOnAction(e -> {
            Jogada(0, 0);
        });
        bts[0][1].setOnAction(e -> {
            Jogada(0, 1);
        });
        bts[0][2].setOnAction(e -> {
            Jogada(0, 2);
        });
        bts[1][0].setOnAction(e -> {
            Jogada(1, 0);
        });
        bts[1][1].setOnAction(e -> {
            Jogada(1, 1);
        });
        bts[1][2].setOnAction(e -> {
            Jogada(1, 2);
        });
        bts[2][0].setOnAction(e -> {
            Jogada(2, 0);
        });
        bts[2][1].setOnAction(e -> {
            Jogada(2, 1);
        });
        bts[2][2].setOnAction(e -> {
            Jogada(2, 2);
        });

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem back = new MenuItem("voltar");
        back.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        back.setOnAction(e -> {
            janela.setScene(inicial);
        });
        MenuItem save = new MenuItem("Salvar");
        save.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
        save.setOnAction(e -> {
            arquivo = fc.showSaveDialog(janela);
            try {
                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }
                FileOutputStream fout = new FileOutputStream(arquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(t);
                System.out.println("Jogo salvo!");

                oos.close();
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
            }
            janela.setScene(inicial);
        });
        menu.getItems().addAll(back, save);
        menuBar.getMenus().addAll(menu);
        GridPane tabuleiro = new GridPane();
        tabuleiro.setAlignment(Pos.CENTER);
        tabuleiro.setHgap(10);
        tabuleiro.setVgap(10);
        tabuleiro.setPadding(new Insets(25, 25, 25, 25));
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro.add(bts[i][j], j, i);
            }
        }
        tabuleiro.add(jogador, 4, 1);
        tabuleiro.add(placar, 4, 0);

        jogo = new Scene(new VBox(), 550, 400);
        ((VBox) jogo.getRoot()).getChildren().addAll(menuBar, tabuleiro);
        inicial = new Scene(grid, 400, 400);

        janela.setTitle("Jogo da Velha!");
        janela.setScene(inicial);
        janela.show();
    }

    public void Jogada(int x, int y) {
        if (vezJogador == 1) {
            t.setTabuleiro(x, y, vezJogador);
            simbolo = "X";
            vezJogador = -1;
            jogador.setText("É a vez do jogador 2!");
        } else {
            t.setTabuleiro(x, y, vezJogador);
            simbolo = "O";
            vezJogador = 1;
            jogador.setText("É a vez do jogador 1!");
        }
        bts[x][y].setText(simbolo);
        bts[x][y].setDisable(true);
        if (t.ganhou() == 3 || t.ganhou() == -3 || t.ganhou() == 4) {
            AlertaVencedor.alertar(t.ganhou());
            t.pontuou(t.ganhou());
            novoJogo();
        }
    }

    public void novoJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bts[i][j].setText("");
                bts[i][j].setDisable(false);
            }
        }
        vezJogador = 1;
        jogador.setText("É a vez do jogador 1!");
        atualizarPlacar();
    }

    public void atualizarPlacar() {
        placar.setText("Pontuação:\n"
                + "Jogador 1: " + t.getJ1() + "\n"
                + "Jogador 2: " + t.getJ2());
    }

    public void atualizarBtns() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t.getMatriz(i, j) != 0) {
                    Jogada(i, j);
                } else {
                    bts[i][j].setText("");
                    bts[i][j].setDisable(false);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
