package application;

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
import java.util.Objects;

public class App extends Application {

    public static List<Horario> horarioList = new ArrayList<>();
    public static List<Lista> listLista = new ArrayList<>();
    public static Definicao definicao;
    public static Stage stage;

    public static void playApp(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage stage) throws Exception{
        App.stage = stage;
        URL resource = App.class.getResource("/telas/principal.fxml");
        Parent screen = FXMLLoader.load(Objects.requireNonNull(resource));

        stage.setTitle("DrinkWater");
        stage.setScene(new Scene(screen, 800, 600));
        stage.show();
        if (horarioList.size() == 0) {
            Parent configScreen = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/telas/config.fxml")));
            HomeController.stage = new Stage();

            HomeController.stage.initOwner(App.stage);
            HomeController.stage.initModality(Modality.WINDOW_MODAL);
            HomeController.stage.initStyle(StageStyle.UNDECORATED);
            HomeController.stage.setScene(new Scene(configScreen));
            HomeController.stage.showAndWait();
            if(App.definicao != null) if (!App.definicao.meta.equals("")) HomeController.meta1.setText("Meta: " + App.definicao.meta + " mls");
        }
    }
}
