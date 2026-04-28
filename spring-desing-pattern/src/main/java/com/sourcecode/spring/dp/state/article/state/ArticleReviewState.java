package com.sourcecode.spring.dp.state.article.state;

import com.sourcecode.spring.dp.state.article.ArticleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArticleReviewState implements ArticleState {
    @Override
    public void create(ArticleContext article) {
        log.info("Create not supported as currently Article is in "+getState()+" State.");
        throw new IllegalStateException("Create not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void draft(ArticleContext article) {
        log.info("Draft not supported as currently Article is in "+getState()+" State.");
        throw new IllegalStateException("Draft not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void review(ArticleContext article) {
        log.info("Reviewing is completed. Moving Article to Published State.");
        article.setState(new ArticlePublishedState());
    }

    @Override
    public void publish(ArticleContext article) {
        log.info("Publish not supported as currently Article is in "+getState()+" State.");
        throw new IllegalStateException("Publish not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void archive(ArticleContext article) {
        log.info("Archive not supported as currently Article is in "+getState()+" State.");
        throw new IllegalStateException("Archive not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public ArticleStateEnum getState() {
        return ArticleStateEnum.REVIEW;
    }
}
