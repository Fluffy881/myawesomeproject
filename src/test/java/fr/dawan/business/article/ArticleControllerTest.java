package fr.dawan.business.article;

import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ArticleController.class, ArticleService.class, ArticleRepository.class, ArticleMapper.class})
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc; //simuler une requete http vers votre application
    @MockBean
    private ArticleRepository repository;
    @Test
    void findByTitle() throws Exception {
        //arrange
        String title = "un";
        Pageable pageable = PageRequest.of(0,20);

        Article articleUn = new Article("un article",null);
        Article articleDeux = new Article("article deux",null);
        Page<Article> entities = new PageImpl<>(List.of(articleUn, articleDeux));

        Mockito.when(repository.findByTitleLike("%" + title + "%", pageable)).thenReturn(entities);

        //act
        mockMvc.perform(// lancer une requete
                MockMvcRequestBuilders.get("/articles/byTitle/" + title)
        ).andDo(print())//assert
                .andExpect(//corespond a un "assert"
             status().isOk()
        ).andExpect(
                jsonPath("$")
                        .isNotEmpty()
                );
    }
}