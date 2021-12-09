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
import main.Main;

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

        System.out.println(Main.horarioList.size());
        System.out.println(Main.listLista.size());

        if (Main.horarioList.size() > 0){
            if (listHorario != null) listHorario.setText(Main.horarioList.get(Main.horarioList.size()-1).horario + " : " + Main.horarioList.get(Main.horarioList.size()-1).minuto);
            if (listMls != null) listMls.setText(Integer.toString(Integer.parseInt(Main.horarioList.get(Main.listLista.size()).mls)));
        }
        if (Main.horarioList.size() == 0) meta1 = meta;
    }

    @FXML
    void abrirConfig() throws IOException {

        Parent configScreen = FXMLLoader.load(Main.class.getResource("/telas/config.fxml"));
        stage = new Stage();

        stage.initOwner(Main.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(configScreen));
        stage.showAndWait();

        if(Main.definicao != null) if (!Main.definicao.meta.equals("")) meta.setText("Meta: " + Main.definicao.meta + " mls");
    }

    @FXML
    public void adicionar() throws IOException {

        Parent adicionar = FXMLLoader.load(Main.class.getResource("/telas/adiciona.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initOwner(Main.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(adicionar));
        stage.showAndWait();

        int guardador;
        int somador = 0;
        if (Main.horarioList.size() > 0) {
            for (int i = 0; i < Main.horarioList.size(); i++) {
                guardador = Integer.parseInt(Main.horarioList.get(i).mls);
                somador += guardador;
            }
        }
        if (Main.horarioList.size() > 0) status.setText("Status: " + somador + " mls");
        lista.scrollTo(lista.getItems().size() - 1);

        }


    @FXML
    void remover() throws IOException {

        Parent remover = FXMLLoader.load(Main.class.getResource("/telas/remove.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("AVISO");
        stage.initOwner(Main.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(remover));
        stage.showAndWait();

        int guardador;
        int somador = 0;
        if (lista.getItems().size() > 0) {
            for (int i = 0; i < Main.horarioList.size(); i++) {
                guardador = Integer.parseInt(Main.horarioList.get(i).mls);
                somador += guardador;
            }
        }

        if (Main.horarioList.size() == 0) status.setText("Status: XXX");
        if (Main.horarioList.size() > 0) status.setText("Status: " + somador + " mls");

    }
    @FXML
    void limpar() throws IOException {
        Parent remover = FXMLLoader.load(Main.class.getResource("/telas/clear.fxml"));
        stage = new Stage();
        lista1 = lista;

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("AVISO");
        stage.initOwner(Main.stage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(remover));
        stage.showAndWait();

        if (Main.horarioList.size() == 0) status.setText("Status: XXX");
    }
}
