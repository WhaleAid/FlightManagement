import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterfaceTest {

    Menu itest;
    Client ctest;
    Vol vtest;

    @BeforeEach
    public void initInterfaceTest ()
    {
        itest = new Menu(false);
        try {
            ctest = new Client("ClientTestNom", "ClientTestPrenom", 25);
            vtest = new Vol("Paris", "Zaghreb", 120, 25);
            itest.add_client(ctest);
            itest.add_vol(vtest);

        }
        catch (Exception e) {}
    }

    @Test
    public void interfaceTest ()
    {
        try {
            assertTrue(ctest == itest.trouver_client(ctest.getId_client()));
            assertTrue(vtest == itest.trouver_vol(vtest.getId_vol()));
            assertTrue(vtest == itest.trouver_vol(vtest.getDepart(), vtest.getDestination()));
        }
        catch (Exception e) {}
    }

}
