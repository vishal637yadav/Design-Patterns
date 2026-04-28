package com.sourcecode.spring.dp.state.article.state;

import com.sourcecode.spring.dp.state.article.ArticleContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArticlePublishedState implements ArticleState {
    @Override
    public void create(ArticleContext article) {
        log.info("Create not supported as currently Article is in {} State.",getState());
        throw new IllegalStateException("Create not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void draft(ArticleContext article) {
        log.info("Draft not supported as currently Article is in {} State.",getState());
        throw new IllegalStateException("Draft not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void review(ArticleContext article) {
        log.info("Review not supported as currently Article is in {} State.",getState());
        throw new IllegalStateException("Review not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public void publish(ArticleContext article) {
        log.info("Publishing is in progress. Article Published Successfully !!");
        article.setState(new ArticleArchivedState());
    }

    @Override
    public void archive(ArticleContext article) {
        log.info("Archive not supported as currently Article is in {} State.",getState());
        throw new IllegalStateException("Archive not supported as currently Article is in "+getState()+" State.");
    }

    @Override
    public ArticleStateEnum getState() {
        return ArticleStateEnum.PUBLISHED;
    }
}
