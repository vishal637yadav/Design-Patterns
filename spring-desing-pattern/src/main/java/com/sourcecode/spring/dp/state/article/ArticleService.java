package com.sourcecode.spring.dp.state.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService {
    private ArticleContext articleContext;

    public void createArticle() {
        articleContext.create(articleContext);
        //articleContext.
    }

    public void draftArticle() {
        articleContext.draft(articleContext);
    }

    public  void reviewArticle() {
        articleContext.review(articleContext);
    }

    public void publishArticle() {
        articleContext.publish(articleContext);
    }

    public void archiveArticle() {
        articleContext.archive(articleContext);
    }

}
