package fr.greta92.DomesServiceSpring.serviceTest;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import fr.greta92.DomesServiceSpring.repository.ClientRepo;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import fr.greta92.DomesServiceSpring.service.GestionClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class GestionClientTest {

    @Mock
    ClientRepo clientRepo;
    @InjectMocks
    GestionClient gestionClient = new GestionClientImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(clientRepo.getByEmail("test@gmail.com")).thenReturn(new Client(
                0,
                "test",
                "test",
                "$2a$10$DNgRoQy12U5MxmoffZaoIOHSa.IrdIVZAwiZRzZY1bwiVdk1Cg0eq",
                "test@gmail.com",
                "06 06 06 06 06",
                true,
                null,
                null));
    }

    @Test
    void loginTest()
    {
        try {
            Client client = gestionClient.login("test@gmail.com", "12345678");
            assertThat(client).isNotNull();
        } catch (WrongEmailOrPasswordExecption e) {
            fail("WrongEmailOrPasswordExecption");
        }
    }
    @Test
    void loginTestExecption(){
        try {
            gestionClient.login("test@gmail.com", "wrongPassword");
            fail("WrongEmailOrPasswordExecption non levée");
        } catch (WrongEmailOrPasswordExecption e) {

        }
    }
}
