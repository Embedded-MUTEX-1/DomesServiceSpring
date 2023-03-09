package fr.greta92.DomesServiceSpring.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.entity.CompteEntity;
import fr.greta92.DomesServiceSpring.exception.CompteDejaExistantException;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@SpringBootTest
@AutoConfigureMockMvc
public class CreationCompteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GestionClient gestionClient;

    @BeforeEach
    void setUp() {

    }

    @Test
    void postMethodTest() throws Exception {

        mockMvc.perform(post("/CreationCompte_")
                        .flashAttr("user", new CompteEntity())
                        .accept(MediaType.APPLICATION_FORM_URLENCODED)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .locale(Locale.FRANCE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
