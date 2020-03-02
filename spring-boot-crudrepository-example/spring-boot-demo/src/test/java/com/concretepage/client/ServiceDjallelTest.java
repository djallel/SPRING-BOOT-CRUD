package com.concretepage.client;

import com.concretepage.client.entity.Article;
import com.concretepage.client.repository.ArticleRepository;
import com.concretepage.client.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {MyApplication.class})
@AutoConfigureMockMvc
@WebMvcTest
@WebAppConfiguration
public class ServiceDjallelTest  extends DataTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ArticleService articleServiceImpl;


    @Mock
    ArticleRepository articleRepository;

    private Article article;

    private List<Article> articles;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getAllArticlesTest(){

        articles= getArticles();

        Mockito.when(articleRepository.findAll()).thenReturn(getArticles());

        List<Article> listArticle = articleServiceImpl.getAllArticles();
        assertThat(listArticle).isNotNull();
        assertTrue(listArticle.retainAll(articles));

    }

    @Test
    public void addArticleTest(){

        articles= getArticles();
        article=getArticle();
//tester le false
        Mockito.when(articleRepository.findByTitleAndCategory(any(),any() )).thenReturn(getArticles());

        boolean exist = articleServiceImpl.addArticle(article);
        assertTrue(!exist);
//tester le true
        List<Article> listvide = new ArrayList<>();
        Mockito.when(articleRepository.findByTitleAndCategory(any(),any() )).thenReturn(listvide);
        Mockito.when(articleRepository.save(any(Article.class))).thenReturn(getArticle());

        exist = articleServiceImpl.addArticle(article);
        assertTrue(exist);

    }
}
