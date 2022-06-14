package MarcialFernandez.GreenPlay.Interface;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Usuario;

public interface IdescargaDao {
	public boolean Download(Descarga d);
}
