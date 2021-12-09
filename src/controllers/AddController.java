package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import models.Horario;
import models.Lista;

import java.io.IOException;

public class AddController {
    @FXML
    private TextField hours;
    @FXML
    private TextField minutes;
    @FXML
    private TextField mls;
    @FXML
    private Label mensagem;

    public static Horario horario;

    public void salvar() throws IOException {

        if (hours.getText().equals("") || minutes.getText().equals("") || mls.getText().equals("")) {
            mensagem.setVisible(true);
            mensagem.setText("Você deve preencher todos os campos.");

        } else{
            horario = new Horario("", "", "");
            boolean verificadorMls = true;
            boolean verificadorHoras = true;
            boolean verificadorMinutos = true;
            String hora = hours.getText();
            String minuto = minutes.getText();
            String ml = mls.getText();
            char[] horaArray = hora.toCharArray();
            char[] minutoArray = minuto.toCharArray();
            char[] mlArray = ml.toCharArray();


            for (int i = 0; i < mlArray.length; i++) {
                verificadorMls = Character.isDigit(mlArray[i]);
                if (!verificadorMls) break;
            }
            for (int i = 0; i < horaArray.length; i++) {
                verificadorHoras = Character.isDigit(horaArray[i]);
                if (!verificadorHoras) break;
            }
            for (int i = 0; i < minutoArray.length; i++) {
                verificadorMinutos = Character.isDigit(minutoArray[i]);
                if (!verificadorMinutos) break;
            }

                if (!verificadorHoras || !verificadorMinutos || !verificadorMls) {
                    mensagem.setVisible(true);
                    mensagem.setText("Você deve digitar apenas números.");
                } else {
                    if (horaArray.length > 2 || minutoArray.length > 2) {
                        mensagem.setVisible(true);
                        mensagem.setText("Apenas 2 digitos nos campos: Hora e Minuto.");
                    } else {
                        int horaNumber = Integer.parseInt(hora);
                        int minutoNumber = Integer.parseInt(minuto);

                        if (horaNumber > 23 || minutoNumber > 59) {
                            mensagem.setVisible(true);
                            mensagem.setText("Apenas Horas até 23 e Minutos até 59.");
                        } else {
                            if (horaNumber < 10) {
                                hora = "0" + horaNumber;
                            }
                            if (minutoNumber < 10) {
                                minuto = "0" + minutoNumber;
                            }
                            horario.mls = ml;
                            horario.horario = hora;
                            horario.minuto = minuto;
                            Main.horarioList.add(AddController.horario);
                            Lista novaLista = new Lista((FXMLLoader.load((Main.class.getResource("/telas/lista.fxml")))));
                            Main.listLista.add(novaLista);
                            HomeController.lista1.getItems().add(Main.listLista.get(Main.listLista.size() - 1).listador);
                            HomeController.stage.close();
                        }
                    }
                }
            }
    }
}
