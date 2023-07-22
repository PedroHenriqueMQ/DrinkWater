package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import application.App;

import java.io.IOException;

public class HomeController {
    @FXML
    private ListView<VBox> lista;
    @FXML
    private Label listHorario;
    @FXML
    private Label listMls;
    @FXML
    private Label status;
    @FXML
    private Label meta;

    public static Stage stage;
    public static int selectedIndex;
    public static ListView<VBox> lista1;
    public static Label meta1;

    public void initialize() {

        System.out.println(App.horarioList.size());
        System.out.println(App.listLista.size());

        if (App.horarioList.size() > 0){
            if (listHorario != null) listHorario.setText(App.horarioList.get(App.horarioList.size()-1).horario + " : " + App.horarioList.get(App.horarioList.size()-1).minuto);
            if (listMls != null) listMls.setText(Integer.toString(Integer.parseInt(App.horarioList.get(App.listLista.size()).mls)));
        }
        if (App.horarioList.size() == 0) meta1 = meta;
    }

    @FXML
    void abrirConfig() throws IOException {

        Parent configScreen = FXMLLoader.load(App.class.getResource("/telas/config.fxml"));
        stage = new Stage();

        stage.initOwner(App.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(configScreen));
        stage.showAndWait();

        if(App.definicao != null) if (!App.definicao.meta.equals("")) meta.setText("Meta: " + App.definicao.meta + " mls");
    }

    @FXML
    public void adicionar() throws IOException {

        Parent adicionar = FXMLLoader.load(App.class.getResource("/telas/adiciona.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initOwner(App.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(adicionar));
        stage.showAndWait();

        int guardador;
        int somador = 0;
        if (App.horarioList.size() > 0) {
            for (int i = 0; i < App.horarioList.size(); i++) {
                guardador = Integer.parseInt(App.horarioList.get(i).mls);
                somador += guardador;
            }
        }
        if (App.horarioList.size() > 0) status.setText("Status: " + somador + " mls");
        lista.scrollTo(lista.getItems().size() - 1);

        }


    @FXML
    void remover() throws IOException {

        Parent remover = FXMLLoader.load(App.class.getResource("/telas/remove.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("AVISO");
        stage.initOwner(App.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(remover));
        stage.showAndWait();

        int guardador;
        int somador = 0;
        if (lista.getItems().size() > 0) {
            for (int i = 0; i < App.horarioList.size(); i++) {
                guardador = Integer.parseInt(App.horarioList.get(i).mls);
                somador += guardador;
            }
        }

        if (App.horarioList.size() == 0) status.setText("Status: XXX");
        if (App.horarioList.size() > 0) status.setText("Status: " + somador + " mls");

    }
    @FXML
    void limpar() throws IOException {
        Parent remover = FXMLLoader.load(App.class.getResource("/telas/clear.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("AVISO");
        stage.initOwner(App.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(remover));
        stage.showAndWait();

        if (App.horarioList.size() == 0) status.setText("Status: XXX");
    }
}
