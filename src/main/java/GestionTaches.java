import java.util.*;

public class GestionTaches implements ITache {

    private Map<Personne, List<Tache>> listeDesTaches;

    public GestionTaches() {
        this.listeDesTaches = new HashMap<>();
    }

    @Override
    public void creerTache(Personne p, String descri, Date date, Status status, Resolution resolution) throws TacheException {
        List<Tache> listeDeLaPersonne = listeDesTaches.get(p);
        Tache tache = new Tache(p, descri, date, status, resolution);
        if (listeDeLaPersonne == null){
            listeDeLaPersonne = new ArrayList<>();
        }
        listeDeLaPersonne.add(tache);
        listeDesTaches.put(p, listeDeLaPersonne);
    }

    @Override
    public void annulerTache(Tache tacheToDelete, Personne personne) throws TacheException {
        checkPersonneExiste(personne);
        checkTacheExiste(personne, tacheToDelete);
        List<Tache> taches = listeDesTaches.get(personne);
        Tache tache = taches.get(taches.indexOf(tacheToDelete));
        tache.annulerTache();
    }

    @Override
    public void replanifierTache(Personne personne, Tache tache, Date date) throws TacheException {
        checkPersonneExiste(personne);
        checkTacheExiste(personne, tache);
        tache.replanifierTache(date);
    }

    private void checkPersonneExiste(Personne personne) throws TacheException {
        if (!listeDesTaches.containsKey(personne)){
            throw new TacheException("Impossible de replanifier la tache, car la personne : "+personne+" n'est pas dans liste");
        }
    }

    private void checkTacheExiste(Personne personne, Tache tache) throws TacheException {
        if (!listeDesTaches.get(personne).contains(tache)){
            throw new TacheException("Impossible de replanifier la tache : "+ tache + ", car elle n'est pas la liste des taches pour : "+ personne);
        }
    }

    @Override
    public void consulterTaches() {
        for (Personne p: listeDesTaches.keySet()){
            System.out.println(p);
            for (Tache t: listeDesTaches.get(p)){
                System.out.println("- "+t);
            }
        }
    }

    @Override
    public void consulterTaches(Personne p) throws TacheException {
        checkPersonneExiste(p);
        for (Tache t: listeDesTaches.get(p)){
            System.out.println("- "+t);
        }
    }
}
