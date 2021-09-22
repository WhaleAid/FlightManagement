public class VolPlaceException extends Exception {
    VolPlaceException() {
        System.out.println ("*** Aucune place disponible pour ce vol ***");
    }
}
