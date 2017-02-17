package CODIGOS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    
//    public static String tempo_restante_string;
    
    private Timer cronometro;
    private DateFormat formato = new SimpleDateFormat("HH:mm:ss");
    private Calendar calendario = Calendar.getInstance();
    private final byte contagem;
    public static final byte PROGRESSIVA = 1;
    public static final byte REGRESSIVA = -1;
    public Cronometro(int ano, int mes, int dia, int horas, int minutos, int segundos, byte tipoContagem) {
        this.cronometro = new Timer();
        calendario.set(ano, mes, dia, horas, minutos, segundos);
        this.contagem = tipoContagem;
    }
    public void cronometro() {
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
//                System.out.println(getTime());
            }
        };
        cronometro.scheduleAtFixedRate(tarefa, 0, 1000);
        this.cronometro = null;
    }
    public String getTime() {
        calendario.add(Calendar.SECOND, contagem);
        return formato.format(calendario.getTime());
    }
//    public static void main(String[] args) {
//        Cronometro contagem = new Cronometro(0, 0, 0, 10, 30, 0, REGRESSIVA);
//        contagem.cronometro();
//    }
}