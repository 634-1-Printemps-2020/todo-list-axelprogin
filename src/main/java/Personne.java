import java.util.Objects;

public class Personne {

    private int id;
    private String nom;
    private String  prenom;

    public Personne(int id, String nom, String prenom) throws PersonneException {
        if (id<0){
            throw new PersonneException("L'id de la personne ne peut pas être négaitf, ID souhaité : "+id);
        }
        if (nom == null){
            throw new PersonneException("Le nom de la personne ne peut pas être null");
        }
        if (prenom == null){
            throw new PersonneException("Le prenom de la personne ne peut pas être null");
        }
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return nom+" "+prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return id == personne.id &&
                Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom);
    }
}
