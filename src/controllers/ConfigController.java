package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import models.Definicao;

public class ConfigController {

    @FXML
    private TextField idade;
    @FXML
    private TextField peso;
    @FXML
    private Label mensagemLabel;


    public void salvar(){
        Definicao definidor = new Definicao(peso.getText() ,idade.getText(), "");
        Main.definicao = (new Definicao("","", ""));
        String getPeso = definidor.peso;
        String getIdade = definidor.idade;
        char[] pesoArray = getPeso.toCharArray();
        char[] idadeArray = getIdade.toCharArray();
        boolean verificadorPeso = false;
        boolean verificadorIdade = false;

        if (definidor.peso.equals("") || definidor.idade.equals("")) {
                mensagemLabel.setText("Você deve preencher todos os campos.");
                mensagemLabel.setVisible(true);

        } else {
            for (int i = 0; i < pesoArray.length; i++) {
                verificadorPeso = Character.isDigit(pesoArray[i]);
                if (!verificadorPeso) break;
            }
            for (int i = 0; i < idadeArray.length; i++) {
                verificadorIdade = Character.isDigit(idadeArray[i]);
                if (!verificadorIdade) break;
            }
            if (!verificadorIdade || !verificadorPeso) {
                mensagemLabel.setText("Você deve digitar apenas números.");
                mensagemLabel.setVisible(true);

            } else {
                verificadorIdade = true;
                verificadorPeso = true;
                String peso = new String(pesoArray);
                String idade = new String(idadeArray);
                int pesoNumber = Integer.parseInt(peso);
                int idadeNumber = Integer.parseInt(idade);
                if (verificadorIdade & verificadorPeso) {
                    if (idadeNumber < 18) {
                        int calculo = pesoNumber * 40;
                        Main.definicao.meta = String.valueOf(calculo);
                    } else if (idadeNumber < 56) {
                        int calculo = pesoNumber * 35;
                        Main.definicao.meta = String.valueOf(calculo);
                    } else if (idadeNumber < 66) {
                        int calculo = pesoNumber * 30;
                        Main.definicao.meta = String.valueOf(calculo);
                    } else {
                        int calculo = pesoNumber * 25;
                        Main.definicao.meta = String.valueOf(calculo);
                    }
                    Main.definicao.peso = String.valueOf(pesoNumber);
                    Main.definicao.idade = String.valueOf(idadeNumber);
                    HomeController.stage.close();
                }
            }
        }
    }
}
