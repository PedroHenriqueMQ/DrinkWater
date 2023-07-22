package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import application.App;



public class RemoveController {

    @FXML
    private Button butaoConfirma;
    @FXML
    private Button butaoFechar;
    @FXML
    private VBox removeScreen;


    public void fechar() {
        HomeController.stage.close();
    }

    public void confirmar() {
        if (App.horarioList.size() < 1) {
            butaoFechar.setText("fechar");
            butaoConfirma.setDisable(true);
            Label mensagem = new Label("Você deve adicionar elementos na lista primeiro.");
            mensagem.setTextFill(Color.RED);
            removeScreen.getChildren().add(mensagem);
        } else {
            HomeController.selectedIndex = HomeController.lista1.getSelectionModel().getSelectedIndex();
            if (HomeController.selectedIndex > -1) {
                HomeController.lista1.getItems().remove(HomeController.selectedIndex);
                App.horarioList.remove(HomeController.selectedIndex);
                App.listLista.remove(HomeController.selectedIndex);
                HomeController.stage.close();
            } else {
                butaoFechar.setText("fechar");
                butaoConfirma.setDisable(true);
                Label mensagem = new Label("Você deve selecionar elementos da lista primeiro.");
                mensagem.setTextFill(Color.RED);
                removeScreen.getChildren().add(mensagem);
            }
        }
    }
}
