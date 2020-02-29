import java.util.Date;

public interface ITache {

    void creerTache(Personne p, String descri, Date date, Status status, Resolution resolution) throws TacheException;

    void annulerTache(Tache tache, Personne personne) throws TacheException;

    void replanifierTache(Personne personne, Tache tache, Date date) throws TacheException;

    void consulterTaches();
    void consulterTaches(Personne p) throws TacheException;

}
