import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class ReservationTest {

    int prix = 120;
    Client client;
    Vol vol;
    Reservation resTest;




    @BeforeEach
    public void initResTest(){
        try{
            client = new Client("nom","prenom",28);
            vol = new Vol("Paris", "Dakar", 80, 666);
            resTest = new Reservation(client, vol );
        }catch (IOException ioe){}
    }


    @Test
    public void reservationGetTest(){
        assertTrue(resTest.getClient() == client);
        try{
        client = new Client("oui", "non", 69);}
        catch(IOException ioe){}
        assertFalse(resTest.getClient() == client);
        assertTrue(resTest.getVol() == vol);
        assertTrue(resTest.getId_reservation() == resTest.id_reservation);
    }

}
