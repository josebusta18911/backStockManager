package ve.com.servicio.rest.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatearFecha {
	
	  public static String formatearFecha(String fecha) {
	        Instant instant = Instant.parse(fecha);
	        LocalDate fechaLocal = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return fechaLocal.format(formatter);
	    }
	  
	  public static String getFormattedFecha(Date fecha) {
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        return formatoFecha.format(fecha);
	    }

	    // Método para formatear la hora antes de guardarla
	    public static String getFormattedHora(Date hora) {
	        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
	        return formatoHora.format(hora);
	    }
}
