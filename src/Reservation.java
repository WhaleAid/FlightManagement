import java.io.IOException;
// import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private static int num = 1;

    int id_reservation, prix;
    Client client;
    Vol vol;

    /*
    List<Client> list_clients = new ArrayList<Client>();
    List<Vol> list_vols = new ArrayList<Vol>();
    /**/

    public Reservation(Client client, Vol vol) throws IOException {
        if (vol.getNb_places_dispo() <= 0) throw new IOException(" Plus de places disponibles pour ce vol ");
        else {
            vol.setNb_places_dispo(vol.getNb_places_dispo() - 1);
            vol.liste_passagers.add(client);
            this.vol = vol;
            this.client = client;
            this.id_reservation = num;
//          this.prix = prix;
            num++;
        }
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Client getClient() {  return client;  }

    public Vol getVol() { return vol; }

    public void afficher ()
    {
        System.out.println("\n*** Reservation #"+this.id_reservation+" ***");
        System.out.println("- Client: ");
        System.out.print("\t"); this.client.afficher ();
        System.out.println("- Vol: ");
        System.out.println("\t- Depart : "+vol.getDepart());
        System.out.println("\t- Arrivee: "+vol.getDestination());
        System.out.println("\t- Duree  : "+vol.getDuree()+"min ");
        System.out.println("**********************\n");
    }
}
