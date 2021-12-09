package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.Main;

public class ClearController {
    @FXML
    private Button butaoConfirma;
    @FXML
    private Button butaoFechar;
    @FXML
    private VBox clearScreen;

    public void fechar(){
        HomeController.stage.close();
    }
    public void confirmar(){
        if (Main.horarioList.size() < 1) {
            butaoConfirma.setDisable(true);
            Label mensagem = new Label("Você deve adicionar elementos na lista primeiro.");
            mensagem.setTextFill(Color.RED);
            clearScreen.getChildren().add(mensagem);
        } else {
            Main.horarioList.clear();
            Main.listLista.clear();
            HomeController.lista1.getItems().clear();
            HomeController.stage.close();
        }
    }
}
