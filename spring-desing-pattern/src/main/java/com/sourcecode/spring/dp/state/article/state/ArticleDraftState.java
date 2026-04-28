package com.sourcecode.spring.dp.state.article.state;

import com.sourcecode.spring.dp.state.article.ArticleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArticleDraftState implements ArticleState {
    @Override
    public void create(ArticleContext article) {
        log.info("Article is already Created, Currently in {} State.", getState());
        throw new IllegalStateException("Article is already Created, Currently in Draft State");
    }

    @Override
    public void draft(ArticleContext article) {
        log.info("Perform Editioning on the Article as it is in Draft State");
        article.setState(new ArticleReviewState());
    }

    @Override
    public void review(ArticleContext article) {
        log.info("Review not supported as currently Article is in {} State.", getState());
        throw new IllegalStateException("Review not supported as currently Article is in " + getState() + " State.");
    }

    @Override
    public void publish(ArticleContext article) {
        log.info("Publish not supported as currently Article is in {} State.", getState());
        throw new IllegalStateException("Publish not supported as currently Article is in " + getState() + " State.");
    }

    @Override
    public void archive(ArticleContext article) {
        log.info("Archive not supported as currently Article is in {} State.", getState());
        throw new IllegalStateException("Archive not supported as currently Article is in " + getState() + " State.");
    }

    @Override
    public ArticleStateEnum getState() {
        return ArticleStateEnum.DRAFT;
    }
}
