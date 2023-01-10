import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

public class Tempo extends Thread {

	private Timer tempo;
	private DateFormat formato = new SimpleDateFormat("mm:ss");
	private Calendar calendario = Calendar.getInstance();
	private String timer;
	

	public Tempo() {
		this.tempo = new Timer();
		calendario.set(0, 0, 0, 0, 3, 0);
		TimerTask tarefa = new TimerTask() {

			@Override
			public void run() {
				timer = getTime();
			}
		};
		tempo.scheduleAtFixedRate(tarefa, 0, 1000);
	}

	public String getTime() {
		calendario.add(Calendar.SECOND, -1);
		return formato.format(calendario.getTime());
	}
	
	public void cancela(){
		tempo.cancel();
	}
	
	

	public Timer getTempo() {
		return tempo;
	}

	public void setTempo(Timer tempo) {
		this.tempo = tempo;
	}

	public DateFormat getFormato() {
		return formato;
	}

	public void setFormato(DateFormat formato) {
		this.formato = formato;
	}

	public Calendar getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

	public String getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
	}
	
	
	
}
