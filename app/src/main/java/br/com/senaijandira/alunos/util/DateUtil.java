package br.com.senaijandira.alunos.util;

public class DateUtil {

    public int convertToInt(String data){

        //"01/01/2000"
        String[] dataSplit = data.split("/");

        String dia = dataSplit[0];
        String mes = dataSplit[1];
        String ano = dataSplit[2];

        String dataFormatada = ano + mes + dia;

        return  Integer.parseInt(dataFormatada);
    }
}
