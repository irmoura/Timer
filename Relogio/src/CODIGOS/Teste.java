/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mael
 */
public class Teste {
    
public static String horario_do_inicio;

public static int ss, segundos_totais;
public static int mm;
public static int hh;

public static double segundos_totais_double;

public static int ss_2;
public static int mm_2;
public static int hh_2;

public static String segundos;
public static String minutos;
public static String horas;
public static String cronometro_string = "";
public static String horario_do_fim;

public static String segundos_finais;
public static String minutos_finais;
public static String horas_finais;
    
public static void marca_tempo(String tempo){
    String tempo_locado = tempo;

    SimpleDateFormat hora_completa = new SimpleDateFormat("hh:mm:ss");
    horario_do_inicio = ""+hora_completa.format(new Date());//RECEBE HORA DE INICIO

    String[] hora_inicio_separada = horario_do_inicio.split(":");

    hh_2 = Integer.parseInt(hora_inicio_separada[0]);
    mm_2 = Integer.parseInt(hora_inicio_separada[1]);
    ss_2 = Integer.parseInt(hora_inicio_separada[2]);

    while(!(cronometro_string.equals(tempo_locado))){

    ss++;
    ss_2++;
    segundos_totais++;

        /**********************************************************************/
    if(ss == 60){
        ss = 0;
        segundos = "00";
        mm++;
    }else
    if(ss < 10){
        segundos = "0"+ss;
    }else
    if(ss > 9){
        segundos = ""+ss;
    }
    /**********************************************************************/
    if(mm == 60){
        mm = 0;
        minutos = "00";
        hh++;
    }else
    if(mm < 10){
        minutos = "0"+mm;
    }else
    if(mm > 9){
        minutos = ""+mm;
    }
    /**********************************************************************/
    if(hh == 24){
        hh = 0;
        horas = "00";
    }else
    if(hh < 10){
        horas = "0"+hh;
    }else
    if(hh > 9){
        horas = ""+hh;
    }
    /**********************************************************************/
    if(ss_2 == 60){
        ss_2 = 0;
        segundos_finais = "00";
        mm_2++;
    }else
    if(ss_2 < 10){
        segundos_finais = "0"+ss_2;
    }else
    if(ss_2 > 9){
        segundos_finais = ""+ss_2;
    }
    /**********************************************************************/
    if(mm_2 == 60){
        mm_2 = 0;
        minutos_finais = "00";
        hh_2++;
    }else
    if(mm_2 < 10){
        minutos_finais = "0"+mm_2;
    }else
    if(mm_2 > 9){
        minutos_finais = ""+mm_2;
    }
    /**********************************************************************/
    if(hh_2 == 24){
        hh_2 = 0;
        horas_finais = "00";
    }else
    if(hh_2 < 10){
        horas_finais = "0"+hh_2;
    }else
    if(hh_2 > 9){
        horas_finais = ""+hh_2;
    }
    ////////////////////////////////////////////////////////////////////////   
    cronometro_string = horas+":"+minutos+":"+segundos;

    horario_do_fim = horas_finais+":"+minutos_finais+":"+segundos_finais;
    }

    segundos_totais_double = Double.parseDouble(""+segundos_totais);

    }
}
