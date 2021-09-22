import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class VolTest {
    String depart = "Paris", arrivee = "Berlin";
    int duree = 120, nb_places = 15;
    Vol vtest;

    @BeforeEach
    public void initVolTest() {
        try {
            vtest = new Vol (depart, arrivee, duree, nb_places);
        }
        catch (IOException e) {}
    }

    @Test
    public void volGetTest ()
    {
        assertTrue(vtest.getId_vol() == 1);
        assertTrue(vtest.getDepart().equals(depart));
        assertTrue(vtest.getDestination().equals(arrivee));
        assertTrue(vtest.getNb_places() == nb_places);
        assertTrue(vtest.getNb_places_dispo() == nb_places);
        assertTrue(vtest.getDuree() == duree);
    }
}
