
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException, TacheException {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Date
            Date date1 = sdf.parse("1998-06-23");
        Date date2 = sdf.parse("2019-07-26");
        Date date3 = sdf.parse("2001-09-11");
        Date date4 = sdf.parse("2011-03-11");
        Date date5 = sdf.parse("2020-09-02");
        Date date6 = sdf.parse("2003-12-26");

        //Personne
        Personne personne1 = new Personne(1, "Anakin", "Skywalker");
        Personne personne2 = new Personne(2, "Luke", "Skywalker");
        Personne personne3 = new Personne(3, "Han", "Solo");
        Personne personne4 = new Personne(4, "Obi-Wan", "Kenobi");
        Personne personne5 = new Personne(5, "Lando", "Calrissian");
        Personne personne6 = new Personne(6, "Boba", "Fett");

        //Taches
        Tache tache1 = new Tache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);
        Tache tache2 = new Tache(personne3, "Entrainer anakin", date6, Status.open, Resolution.ignored);
        //Tache tache3 = new Tache(personne3, "Quitter Corellia", date5, Status.open, Resolution.ignored);


        GestionTaches gestionTaches = new GestionTaches();
        gestionTaches.creerTache(personne1, "Aller sauver ma maman sur tatooine", date1, Status.open, Resolution.ignored);
        gestionTaches.creerTache(personne4, "Entrainer anakin", date6, Status.open, Resolution.ignored);
        //gestionTaches.creerTache(personne3, "Quitter Corellia", date5, Status.open, Resolution.ignored);



    }
}
