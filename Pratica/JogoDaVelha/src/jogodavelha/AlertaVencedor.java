package jogodavelha;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AlertaVencedor {

    public static void alertar(int pontuação) {
        Stage janela = new Stage();

        janela.initModality(Modality.APPLICATION_MODAL);
        janela.setTitle("O vencedor é:");

        Label mensagem = new Label();
        if (pontuação == 3) {
            mensagem.setText("O jogador 1 venceu!");
        } else if (pontuação == -3) {
            mensagem.setText("O jogador 2 venceu!");
        } else if (pontuação == 4) {
            mensagem.setText("Deu velha!");
        }
        Button ok = new Button("Ok!");
        ok.setOnAction(e -> janela.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(mensagem, ok);
        layout.setAlignment(Pos.CENTER);

        Scene alerta = new Scene(layout, 350, 200);
        janela.setScene(alerta);
        janela.showAndWait();
    }
}
