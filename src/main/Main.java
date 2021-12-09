package main;

import controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Definicao;
import models.Horario;
import models.Lista;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Horario> horarioList = new ArrayList<>();
    public static List<Lista> listLista = new ArrayList<>();
    public static Definicao definicao;
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage stage) throws Exception{
        Main.stage = stage;
        URL resource = Main.class.getResource("/telas/principal.fxml");
        Parent screen = FXMLLoader.load(resource);

        stage.setTitle("DrinkWater");
        stage.setScene(new Scene(screen, 800, 600));
        stage.show();
        if (horarioList.size() == 0) {
            Parent configScreen = FXMLLoader.load(Main.class.getResource("/telas/config.fxml"));
            HomeController.stage = new Stage();

            HomeController.stage.initOwner(Main.stage);
            HomeController.stage.initModality(Modality.WINDOW_MODAL);
            HomeController.stage.initStyle(StageStyle.UNDECORATED);
            HomeController.stage.setScene(new Scene(configScreen));
            HomeController.stage.showAndWait();
            if(Main.definicao != null) if (!Main.definicao.meta.equals("")) HomeController.meta1.setText("Meta: " + Main.definicao.meta + " mls");
        }
    }
}
