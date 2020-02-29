import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TacheTest {

    @Test
    public void annulerTache() throws ParseException, TacheException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1998-06-23");
        Personne personne1 = new Personne(1, "Anakin", "Skywalker");
        Tache tache1 = new Tache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);

        tache1.annulerTache();
        if (tache1.getStatus().equals(Status.canceled)){
            System.out.println("TEST OK");
        }else {
            System.out.println("TEST NOK");
        }

    }

    @Test
    public void getStatus() throws ParseException, TacheException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1998-06-23");
        Personne personne1 = new Personne(1, "Anakin", "Skywalker");
        Tache tache1 = new Tache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);

        if (tache1.getStatus().equals(Status.open)){
            System.out.println("TEST OK");
        }else {
            System.out.println("TEST NOK");
        }
    }

    @Test
    public void getDate() throws ParseException, TacheException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1998-06-23");
        Personne personne1 = new Personne(1, "Anakin", "Skywalker");
        Tache tache1 = new Tache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);

        if (tache1.getDate().equals(date1)){
            System.out.println("TEST OK");
        }else {
            System.out.println("TEST NOK");
        }
    }

    @Test
    public void replanifierTache() throws ParseException, TacheException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1998-06-23");
        Date date2 = sdf.parse("2000-06-23");
        Personne personne1 = new Personne(1, "Anakin", "Skywalker");
        Tache tache1 = new Tache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);

        tache1.replanifierTache(date2);
        if (tache1.getDate().equals(date1)){
            System.out.println("TEST NOK");
        }else {
            System.out.println("TEST OK");
        }
    }
}