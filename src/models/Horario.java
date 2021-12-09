package models;

public class Horario {

    public String horario;
    public String minuto;
    public String mls;

    public Horario(String horarioText,String minutoText , String mlsText){
        horario = horarioText;
        minuto = minutoText;
        mls = mlsText;
    }
}
