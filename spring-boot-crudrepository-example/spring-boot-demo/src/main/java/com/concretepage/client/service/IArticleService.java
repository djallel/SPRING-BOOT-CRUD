package com.concretepage.client.service;

import com.concretepage.client.entity.Article;

import java.util.List;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(long articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
