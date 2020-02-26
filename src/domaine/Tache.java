package domaine;

import domaine.exception.TacheException;
import java.util.Date;
import java.util.Objects;

public class Tache {

    private Personne createur;
    private String description;
    private Date date;
    private Status status;
    private Resolution resolution;

    public Tache(Personne createur, String description, Date date, Status status, Resolution resolution) throws TacheException {
        if (new Date().compareTo(date) < 0) {
            throw new TacheException("Création impossible, date antérieur à la d'aujourd'hui."+" Date désiré : "+date.toString()+", date d'aujourd'hui : "+ new Date().toString());
        }
        this.createur = createur;
        this.description = description;
        this.date = date;
        this.status = status;
        this.resolution = resolution;
    }

    public void annulerTache(){
        status = Status.canceled;
        resolution = Resolution.ignored;
    }

    public void replanifierTache(Date date){
        this.date = date;
    }

    @Override
    public String toString() {
        return description+" pour le "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear() +" status -> "+status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return Objects.equals(createur, tache.createur) &&
                Objects.equals(description, tache.description) &&
                Objects.equals(date, tache.date) &&
                status == tache.status &&
                resolution == tache.resolution;
    }

    @Override
    public int hashCode() {
        return Objects.hash(createur, description, date, status, resolution);
    }
}
