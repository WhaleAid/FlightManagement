import java.io.IOException;

public class Client
{
    private static int num = 1;

    String nom, prenom, tel;
    int age, id_client;

    Client (String n, String p, int age) throws IOException
    {
        if (!Generic.nom_valide(n.trim()) || !Generic.nom_valide(p.trim())) throw new IOException ("*** Noms saisis non valides *** ");
        if (!Generic.age_valide(age))  throw new IOException("*** Age non valide ***");

        this.id_client = num;
        this.nom = n.trim();
        this.prenom = p.trim();
        this.age = age;

        num++;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Client.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void afficher ()
    {
        System.out.println (this.id_client+" : "+this.nom +" "+ this.prenom);
    }
}
