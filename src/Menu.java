import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner s;
    boolean running;

    ArrayList<Client> list_clients;
    ArrayList<Vol> list_vols;
    ArrayList<Reservation> list_res;

    Menu(boolean notest)
    {
        running      = true;
        list_clients = new ArrayList<Client>();
        list_res     = new ArrayList<Reservation>();
        list_vols    = new ArrayList<Vol>();

        if (notest) run ();
    }

    private void run ()
    {
        while (running) {
            disp ("\n------------MENU---------------");
            disp("");
            disp("1. Ajouter un client");
            disp("2. Ajouter un vol");
            disp("3. Faire une reservation");
            disp("");
            disp("4. Lister les clients");
            disp("5. Lister les vols");
            disp("6. Lister les reservations");
            disp("");
            disp("7. Trouver un vol disponible");
            disp("");
            disp("0. Quitter");
            disp("");
            disp("-------------------------------\n");

            this.s = new Scanner(System.in);
            try {
                switch (s.nextInt()) {
                    case 1:
                        ajouter_client();
                        break;

                    case 2:
                        ajouter_vol();
                        break;

                    case 3:
                        ajouter_reservations();
                        break;

                    case 4:
                        lister_clients ();
                        break;

                    case 5:
                        lister_vols ();
                        break;

                    case 6:
                        lister_reservations ();
                        break;

                    case 7:
                        vol_disponible ();
                        break;

                    case 0:
                        running = false;
                        break;

                    default : continue;
                }
            } catch (Exception e) {}
        }
    }

    public void ajouter_client ()
    {
        String info, nom, prenom;
        int age;

        Scanner temp = new Scanner (System.in);

        disp ("> Saisir le nom");
        nom = temp.nextLine();

        disp ("> Saisir le prenom");
        prenom = temp.nextLine();

        disp ("> Saisir l'age");
        age = temp.nextInt();

        try {
            add_client (new Client(nom, prenom, age));
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }
    public void ajouter_vol () {
        String depart, arrivee;
        int places, duree;

        Scanner temp = new Scanner (System.in);

        disp ("> Ville de départ ");
        depart = temp.nextLine();

        disp ("> Ville d'arrivee ");
        arrivee = temp.nextLine();

        disp ("> Durée du vol ");
        duree = temp.nextInt();

        disp ("> Nombre de places disponibles ");
        places = temp.nextInt();

        try {
            add_vol(new Vol(depart, arrivee, duree, places));
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }
    public void ajouter_reservations() {
        int id_client, id_vol;
        Client client;
        Vol vol;

        Scanner temp = new Scanner (System.in);

        disp ("> ID Voyageur ");
        id_client = temp.nextInt();

        disp ("> ID Vol ");
        id_vol = temp.nextInt();

        try {
            client = this.trouver_client(id_client);
            vol = this.trouver_vol(id_vol);

            this.list_res.add (new Reservation(client, vol));
            disp ("*** Reservation validee ***");
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }

    public void vol_disponible ()
    {
        Scanner temp = new Scanner (System.in);
        String depart, arrivee;

        disp ("> Depart ");
        depart = temp.nextLine ();

        disp ("> Arrivee ");
        arrivee = temp.nextLine ();

        try
        {
            trouver_vol(depart, arrivee).afficher();
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }

    private void lister_clients ()
    {
        disp ("\n----------CLIENTS--------------\n");
        if (!list_clients.isEmpty()) for (Client c : list_clients) c.afficher();
        else disp ("> Liste vide");
        disp ("\n-------------------------------");
    }
    private void lister_vols () {
        disp ("\n------------VOLS---------------\n");
        if (!this.list_vols.isEmpty()) for (Vol v : list_vols) v.afficher();
        else disp("> Liste vide");
        disp ("\n-------------------------------");
    }
    private void lister_reservations () {
        disp ("\n-----RESERVATIONS----------\n");
        if (!list_res.isEmpty()) for (Reservation r : list_res) r.afficher();
        else disp ("> Liste vide");
        disp ("\n--------------------------");
    }
    private static void disp ( String message ) { System.out.println(message); }


    public Client trouver_client (int id) throws IOException
    {
        Client res = null;
        if (id < 0) throw new IOException("*** Identifiant non valide ***");
        for (Client c : list_clients) if (c.getId_client() == id) {
                res = c;
                break;
            }
        if (res == null) throw new IOException ("*** Client non enregistré ***");
        return res;
    }

    public Vol trouver_vol (int id) throws IOException
    {
        Vol res = null;
        if (id < 0) throw new IOException("*** Identifiant non valide ***");
        for (Vol v : list_vols) if (v.getId_vol() == id) {
            res = v;
            break;
        }
        if (res == null) throw new IOException ("*** Client non enregistré ***");
        return res;
    }

    public Vol trouver_vol (String depart, String arrivee) throws IOException
    {
        Vol res = null;

        for (Vol v : list_vols)
            if (v.getDepart().equals(depart.trim()) && v.getDestination().equals(arrivee.trim()) && v.getNb_places_dispo() > 0) {
                res = v;
                break;
            }

        if (res == null) throw new IOException("*** Aucun vol trouvé ***");
        return res;
    }

    public void add_client (Client c) { this.list_clients.add(c); }

    public void add_vol (Vol v) { this.list_vols.add(v); }
}
