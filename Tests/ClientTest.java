import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getNum() {
    }

    @Test
    void setNum() {
    }

    @Test
    void getNom() throws IOException {
        Client c1 = new Client("Doe", "John", 35);
        assertEquals("Doe", c1.getNom());
    }

    @Test
    void setNom() {
    }

    @Test
    void getPrenom() {
    }

    @Test
    void setPrenom() {
    }

    @Test
    void getTel() {
    }

    @Test
    void setTel() {
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }

    @Test
    void getId_client() {
    }

    @Test
    void setId_client() {
    }

    @Test
    void afficher() {
    }
}