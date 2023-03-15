package fr.greta92.DomesServiceSpring.serviceTest;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;
import fr.greta92.DomesServiceSpring.repository.ArticleRepo;
import fr.greta92.DomesServiceSpring.service.GestionArticle;
import fr.greta92.DomesServiceSpring.service.GestionArticleImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class GestionArticleTest {
    @Mock
    ArticleRepo articleRepo;
    @InjectMocks
    GestionArticle gestionArticle = new GestionArticleImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void returnArticleTest() throws ArticleNonExistantException {

        Mockito.when(articleRepo.existsById(5000)).thenReturn(true);

        Mockito.when(articleRepo.findById(5000)).thenReturn(Optional.of(new AnimalArticle(5000,
                "Alvin",
                5000,
                "na",
                10,
                "je suis trop mignon",
                true,
                null,
                null)));

        AnimalArticle article = gestionArticle.returnArticle(5000);
        assertThat(article).isNotNull();
        assertThat(article.getRef()).isEqualTo(5000);
    }
    @Test
    void returnExceptionArticleTest()
    {
        Mockito.when(articleRepo.existsById(5001)).thenReturn(false);

        try {
            AnimalArticle article = gestionArticle.returnArticle(5001);
            fail("ArticleNonExistantException non levée");
        }
        catch (ArticleNonExistantException e) {

        }

    }
}
