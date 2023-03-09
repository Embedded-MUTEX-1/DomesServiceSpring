package fr.greta92.DomesServiceSpring.repositoryTest;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.repository.ClientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepoTest {
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    void testClientsByEmail_returnClient()
    {
        //given
        Client saveClients=testEntityManager.persistAndFlush(new
                Client(0, "test", "test", "password", "test@gmail.com", "06 06 06 06 06", true, null, null));
        //when
        Client client = clientRepo.getByEmail("test@gmail.com");
        //then
        then(client).isNotNull();
        then(client.getEmail()).isEqualTo(saveClients.getEmail());
    }
}
