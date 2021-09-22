import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Generic
{
    public static final int VOL_PLACES_MIN = 4;
    public static final int VOL_PLACES_MAX = 200;
    public static final int CLIENT_AGE_MIN = 10;
    public static final int CLIENT_AGE_MAX = 100;
    public static final int VOL_DUREE_MIN  = 30;
    public static final int VOL_DUREE_MAX  = 930;

    public static boolean nom_valide (String nom) {
        Pattern p = Pattern.compile("^[a-zA-Z]{2,}$");
        Matcher m = p.matcher (nom);
        return m.matches();
    }

    public static boolean age_valide (int age) {
        return (age > CLIENT_AGE_MIN && age < CLIENT_AGE_MAX );
    }

    public static boolean duree_valide (int duree) {
        return (duree > VOL_DUREE_MIN && duree < VOL_DUREE_MAX);
    }

    public static int definir_nb_places (int places)
    {
        if (places > VOL_PLACES_MAX) places = VOL_PLACES_MAX;
        if (places < VOL_PLACES_MIN) places = VOL_PLACES_MIN;
        return places;
    }
}