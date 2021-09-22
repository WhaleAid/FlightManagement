import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GenericTest {

    @Test
    public void genericNomValideTest () {

        assertTrue  (Generic.nom_valide("NomValide"));
        assertFalse (Generic.nom_valide("Nom Invalide"));
        assertFalse (Generic.nom_valide("Nom_Invalide"));
        assertFalse (Generic.nom_valide("NomInvalide056"));

    }

    @Test
    public void genericDureeValideTest () {
        assertTrue (Generic.duree_valide( (Generic.VOL_DUREE_MIN + Generic.VOL_DUREE_MAX)/2 ));
        assertFalse(Generic.duree_valide  (Generic.VOL_DUREE_MIN - 10) );
        assertFalse(Generic.duree_valide  (Generic.VOL_DUREE_MAX + 100) );
    }

    @Test
    public void genericAgeValideTest () {
        assertTrue (Generic.age_valide( (Generic.CLIENT_AGE_MAX  + Generic.CLIENT_AGE_MIN)/2 ));
        assertFalse(Generic.age_valide  (Generic.CLIENT_AGE_MAX + 10) );
        assertFalse(Generic.age_valide  (Generic.CLIENT_AGE_MIN - 10) );
    }

    @Test
    public void genericDefinirNbPlaces () {
        assertTrue( Generic.definir_nb_places(-5) == Generic.VOL_PLACES_MIN );
        assertTrue( Generic.definir_nb_places( 0) == Generic.VOL_PLACES_MIN );
        assertTrue( Generic.definir_nb_places( Generic.VOL_PLACES_MIN) == Generic.VOL_PLACES_MIN );
        assertTrue( Generic.definir_nb_places( Generic.VOL_PLACES_MAX + 10) == Generic.VOL_PLACES_MAX );
    }

}
