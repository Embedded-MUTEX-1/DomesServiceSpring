package fr.greta92.DomesServiceSpring.controllerRestTest;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;
import fr.greta92.DomesServiceSpring.service.GestionArticle;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleRessourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GestionArticle gestionArticle;

    @Test
    void returnArticleTest() throws Exception, ArticleNonExistantException {
        when(gestionArticle.returnArticle(3)).thenReturn(new AnimalArticle(3,
                "Alvin",
                5000,
                "na",
                10,
                "je suis trop mignon",
                true,
                null,
                null));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/article/{id}", 3)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Alvin"));
    }
}
