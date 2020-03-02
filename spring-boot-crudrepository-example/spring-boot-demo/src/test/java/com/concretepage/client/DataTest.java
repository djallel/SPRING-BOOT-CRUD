package com.concretepage.client;

import com.concretepage.client.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class DataTest {

    Article getArticle(long articleId,String title,String category){
        Article article = new Article();
        article.setArticleId(articleId);
        article.setTitle(title);
        article.setCategory(category);
        return article;
    }

    Article getArticle(){

        Article article = new Article();
        article.setArticleId(99L);
        article.setTitle("title 99");
        article.setCategory( " categpory 99");

        return article;
    }

    List<Article> getArticles(){
        List<Article> articles = new ArrayList<>();

        Article article1 = new Article();
        article1.setArticleId(99L);
        article1.setTitle("title 99");
        article1.setCategory( " categpory 99");

        Article article2 = new Article();
        article2.setArticleId(88L);
        article2.setTitle("title 88");
        article2.setCategory( " categpory 88");

        Article article3 = new Article();
        article3.setArticleId(77L);
        article3.setTitle("title 77");
        article3.setCategory( " categpory 77");

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);

        return articles;
    }
}
