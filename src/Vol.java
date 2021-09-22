import java.io.IOException;
import java.util.ArrayList;

public class Vol
{
    private static int num = 1;

    int id_vol;
    String depart, destination;
    ArrayList<Client> liste_passagers;
    int duree, nb_places, nb_places_dispo; /* Pilote & CoPilote non compris */

    public Vol (String o, String d, int duree, int nb_places) throws IOException {

        if (!Generic.nom_valide(o.trim()) || !Generic.nom_valide(d.trim())) throw new IOException("*** Noms saisis non valides ***");
        if (!Generic.duree_valide(duree)) throw new IOException("*** Durée saisie non valide ***");
        if (d.equals(o)) throw new IOException("Les villes de départ et d'arrivée sont identiques");

        this.id_vol = num;
        this.depart = o.trim();
        this.destination = d.trim();
        this.duree = duree;
        this.nb_places = Generic.definir_nb_places (nb_places);
        this.nb_places_dispo = this.nb_places;

        this.liste_passagers = new ArrayList<Client> ();

        num++;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public int getNb_places_dispo() {
        return nb_places_dispo;
    }

    public void setNb_places_dispo(int nb_places_dispo) {
        this.nb_places_dispo = nb_places_dispo;
    }

    public void afficher ()
    {
        System.out.println("\n*** Vol #"+ this.id_vol+" ***");
        System.out.println("Départ: "+this.depart +" - Arrivée: "+this.destination);
        System.out.println("- Durée: "+this.duree+" min");
        System.out.println("- Places disponibles: "+this.nb_places_dispo+"\n");
    }

    public void afficher_passagers ()
    {
        if (liste_passagers.isEmpty()) System.out.println("> Liste Vide");
        else for (Client c : liste_passagers) c.afficher();
    }

}