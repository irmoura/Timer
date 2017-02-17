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
public class Metodos {
    
    public static String horas_string;
    
    public static String segundos;
    public static String minutos;
    public static String horas;
    
    public static String segundos_restantes;
    public static String minutos_restantes;
    public static String horas_restantes;
    
    public static String tempo_locado;
    
    public static String cronometro_string;
    
    public static String tempo_restante_string;
    
    public static int ss;
    public static int mm;
    public static int hh;
    
    public static int ss_restantes = 60;
    public static int mm_restantes;
    public static int hh_restantes;
    
    public static int count;
    public static int contador_porcentagem;
    
    public static double porcentagem;
    public static double porcentagem_regressiva;
    
    public static void zerador(){
        /*ZERA AS INFORMACOES*/
        ss = 0;
        mm = 0;
        hh = 0;
        count = 0;

        ss_restantes = 60;
        
        contador_porcentagem = 0;//ZERA A PORCENTAGEM

        Tela.LABEL_HORA_ATUAL.setText("Hora Atual | 00:00:00");
        Tela.LABEL_TEMPO_DECORRIDO.setText("Tempo Decorrido | 00:00:00");
        Tela.LABEL_TEMPO_RESTANTE.setText("Tempo Restante | 00:00:00");
        Tela.LABEL_TESTE.setText("INICIO - 00:00:00 | FIM - 00:00:00");
        Tela.LABEL_PORCENT_PROGRESSIVA.setText("0%");
        Tela.LABEL_PORCENT_REGRESSIVA.setText("0%");
        Tela.BARRA_PROGRESSIVA.setValue(0);
        Tela.BARRA_REGRESSIVA.setValue(0);

        Tela.BTN_INICIAR.setEnabled(true);
        Tela.COMBO_HORAS.setEnabled(true);
        Tela.COMBO_MINUTOS.setEnabled(true);

        Tela.BTN_PARAR.setEnabled(false);
    }
    public static void hora(){
        
        SimpleDateFormat hora_completa = new SimpleDateFormat("hh:mm:ss");// dd/MM/yyyy - hh:mm:ss  
        horas_string = ""+hora_completa.format(new Date());
    }
    public static void tempo_decorrido(String horas_locadas, String minutos_locados){
        
        tempo_locado = horas_locadas+":"+minutos_locados+":00";
        
        ss++;
        ss_restantes--;
        
        count++;
        contador_porcentagem++;
        
        porcentagem = (contador_porcentagem/Teste.segundos_totais_double)*100;
        porcentagem_regressiva = 100 - porcentagem;
        
        if(count == 1){
            mm_restantes = Integer.parseInt(minutos_locados);
            hh_restantes = Integer.parseInt(horas_locadas);
            if(mm_restantes > 0){
                mm_restantes--;
            }
        }
        
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
        cronometro_string = horas+":"+minutos+":"+segundos;
        /**********************************************************************/
        /**********************************************************************/
        /**********************************************************************/
        if(ss_restantes == 0){
            segundos_restantes = "00";
            ss_restantes = 60;
            mm_restantes--;
        }else
        if(ss_restantes < 10){
            segundos_restantes = "0"+ss_restantes;
        }else
        if(ss_restantes > 9){
            segundos_restantes = ""+ss_restantes;
        }
        /**********************************************************************/
    if(hh_restantes > 0 && mm_restantes == 0){
        minutos_restantes = "00";
        mm_restantes = 59;
        if(hh_restantes > 0){
                hh_restantes--;
        }
    }else
        if(mm_restantes > 9){
            minutos_restantes = ""+mm_restantes;
        }else
        if(mm_restantes < 10){
            minutos_restantes = "0"+mm_restantes;
        }
        /**********************************************************************/
        if(hh_restantes > 9){
            horas_restantes = ""+hh_restantes;
        }else
        if(hh_restantes < 10){
            horas_restantes = "0"+hh_restantes;
        }
        /**********************************************************************/
        tempo_restante_string = horas_restantes+":"+minutos_restantes+":"+segundos_restantes;
    }
}